package ist.gt.gastBuilder;

import ist.gt.AstConverter;
import ist.gt.exceptions.ReturnFoundException;
import ist.gt.model.Class;
import ist.gt.model.*;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;
import ist.gt.util.*;
import lombok.Data;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Data
public class TaintVisitor implements AstBuilderVisitorInterface, ValueTrackingInterface {

    private final List<File> files;
    private final Stack<CodeBlock> codeBlocks = new Stack<>();
    private Stack<Function> functions = new Stack<>();
    private Stack<String> functionNames = new Stack<>();
    private final Map<String, Variable> currentPathVariables = new HashMap<>();
    private File file;
    private Stack<Class> classes = new Stack<>();
    private List<ConditionalStatement> currentPath = new ArrayList<>();
    private TaintSpecification spec;
    private static Settings settings;


    public TaintVisitor(List<File> files, Settings setting) {
        settings = setting;
        this.files = files;
        this.spec = settings.getSpecification();
        initAstTaintState(spec);
    }

    private TaintVisitor(List<File> files, TaintSpecification specification, Stack<String> functionStack, File currentFile, Class clazz) {
        this.files = files;
        this.spec = specification;
        this.functionNames = functionStack;
        this.file = currentFile;
        if (clazz != null)
            classes.add(clazz);
    }

    public void start() {
        if (spec.isAllFiles()) {
            for (File file1 : files) {
                file = file1;
                file1.accept(this);
            }
            return;
        }
        file.accept(this);
    }

    private void initAstTaintState(TaintSpecification specification) {
        if (spec.isAllFiles()) {
            return;
        }

        file = files.stream().filter(file1 -> file1.getName().equals(specification.getFileName())).findFirst().orElseThrow();

        if (spec.isRootSpecification()) {
            spec.getTaintedVarsOrArgs().forEach(var -> file.getRootFunc().getVariables().get(var).setTainted(true));
            return;
        }

        var function = specification.isMethod()
                ? file.getClasses().get(specification.getFunction().getType()).getMethods().get(specification.getFunction().getName())
                : file.getFunctions().get(specification.getFunction().getName());

        if (function == null)
            Util.throwAny(new Exception("Function not found"));

        taintFunctionOrMethod(specification, function);
        if (!spec.getTaintedAttributes().isEmpty() && spec.getFunction().getType() != null) {
            var clazz = file.getClasses().get(spec.getFunction().getType());
            for (String taintedArgument : spec.getTaintedAttributes()) {
                clazz.getAttributes().get(taintedArgument).setTainted(true);
            }
        }

    }

    private void taintFunctionOrMethod(TaintSpecification specification, Function func) {
        specification.getTaintedVarsOrArgs().stream()
                .filter(arg -> func.getParameters().containsKey(arg))
                .forEach(arg -> func.getParameters().get(arg).setTainted(true));
    }

    private boolean isCallToSanitizationFunction(FunctionCall functionCall, boolean isTaintedSource, String sourceType) {
        if (spec.getSanitizationFunctions().stream().anyMatch(call -> call.getName().equals(functionCall.getFunctionName())
                && (sourceType == null || call.getType() == null || call.getName().equals(sourceType)))) {
            functionCall.setTainted(false);
            return true;
        }
        IsVulnerability(functionCall, isTaintedSource, sourceType);
        return false;
    }


    @Override
    public void visit(FunctionCall functionCall) {
        if (isCallToSanitizationFunction(functionCall, false, null)) {
            return;
        }

        if (!classes.empty() && classes.peek().getMethods().containsKey(functionCall.getFunctionName())) {
            processFunction(classes.peek().getMethods().get(functionCall.getFunctionName()), functionCall, file, classes.peek());

        } else if (file.getFunctions().containsKey(functionCall.getFunctionName())) {
            processFunction(file.getFunctions().get(functionCall.getFunctionName()), functionCall, file, null);

        } else if (!file.getImportedFiles().isEmpty()) {

            var fileAndFunction = tryGetFunctionFromImportedFiles(file, functionCall.getFunctionName());
            if (fileAndFunction != null) {
                processFunction(fileAndFunction.getFunction(), functionCall, fileAndFunction.getFile(), null); //
                functionCall.setReturnType(fileAndFunction.getFunction().getReturnType());
            }
        } else {
            functionCall.setTainted(propagateTaintInExpressionList(functionCall.getMembers()));
        }
    }

    private void processFunction(Function function, FunctionCall functionCall, File file, Class clazz) {
        for (int i = 0; i < function.getParameters().size() && i < functionCall.getMembers().size(); i++) {
            functionCall.getMembers().get(i).accept(this);
            function.getParameters().getElement(i).setTainted(functionCall.getMembers().get(i).isTainted());
            //Value tracking of parameters
            Expression parameter = functionCall.getMembers().get(i);
            if(parameter.getType() != null){
                if(parameter.getClassReference() != null){
                    if(parameter.getSelectedAttribute() != null){
                        String attributeName = parameter.getSelectedAttribute();
                        function.getParameters().getElement(i).setTrackedValue(
                            parameter.getClassReference().getAttributes().get(attributeName).getTrackedValue());
                        
                        function.getParameters().getElement(i).setType(
                            parameter.getClassReference().getAttributes().get(attributeName).getType());
                    } else{
                        function.getParameters().getElement(i).setClassReference(parameter.getClassReference());
                        function.getParameters().getElement(i).setType(parameter.getType());
                    }
                } else{
                    function.getParameters().getElement(i).setTrackedValue(parameter.getTrackedValue());
                    function.getParameters().getElement(i).setType(parameter.getType());
                }
            }
        }
        function.accept(new TaintVisitor(files, spec, functionNames, file, clazz));
        functionCall.setTainted(function.getCodeBlock().isReturnTainted());
    }


    public FileAndFunction tryGetFunctionFromImportedFiles(File fileToSearch, String functionName) {
        for (String importedFileName : fileToSearch.getImportedFiles()) {
            var importedFile = files.stream().filter(iterFile -> iterFile.getPath().toString().toLowerCase().contains(importedFileName)).findFirst().orElse(null);
            if (importedFile == null)
                continue;
            if (importedFile.getFunctions().containsKey(functionName))
                return new FileAndFunction(importedFile, importedFile.getFunctions().get(functionName));

            if (importedFile.getImportedFiles().isEmpty())
                continue;
            return tryGetFunctionFromImportedFiles(importedFile, functionName);
        }
        return null;
    }

    private void IsVulnerability(FunctionCall functionCall, boolean isTaintedSource, String sourceType) {
        if (spec.getSensitiveFunctions().stream().anyMatch(func -> functionCall.getFunctionName().equals(func.getName())
                && (sourceType == null || func.getType() == null || func.getType().equals(sourceType)))
                && ((isTaintedSource && spec.isReturnTaintedIfTaintedSource()) || propagateTaintInExpressionList(functionCall.getMembers()))) {

            Vulnerability vulnerability = new Vulnerability(functionCall.getLine(), functionCall.getFunctionName());

            for (ConditionalStatement stmt : currentPath) {
                vulnerability.getConditions().add(new VulnerabilityCondition(stmt.getLine(), stmt.getCondition()));
            }

            vulnerability.setFunctionCallStack(new ArrayList<>(functionNames));
            AstConverter.addVulnerability(vulnerability);
//            CommonTools.throwAny(new Exception("Found vulnerability " + functionCall.getLine()));
            System.out.println("Found vulnerability " + functionCall.getLine() + " " + functionCall.getText());
        }
    }

    @Override
    public void visit(Expression expression) {
        if(expression.getOperator() != null && expression.getTrackedValue() == null){
            expression.addValue(this);
        }
        expression.setTainted(propagateTaintInExpressionList(expression.getMembers()));
    }

    @Override
    public void visit(Assignment assignment) {
        assignment.getLeft().accept(this);
        if (assignment.getRight() == null) //when is only a var declaration
            return;
        assignment.getRight().accept(this);

        //Perform value tracking
        assignment.addValue(this);

        propagateSetTainted(assignment.getLeft(), assignment.getRight().isTainted());
        assignment.setTainted(assignment.getRight().isTainted());
        //Same logic as in @function visit(Variable)
        if(assignment.getLeft().getClassReference() != null){
            if(assignment.getLeft().getSelectedAttribute() != null){
                String attribute = assignment.getLeft().getSelectedAttribute();
                assignment.getLeft().setTainted(assignment.getLeft().getClassReference()
                .getAttributes().get(attribute).isTainted());
            } else{
                assignment.getLeft().setTainted(assignment.getLeft().getClassReference().areAttributesTainted());
            }
        } else{
            assignment.getLeft().setTainted(assignment.getRight().isTainted());
        }
    }

    @Override
    public void visit(ReturnStatement stmt) {
        if (stmt.getExpression() == null)
            return;
        stmt.getExpression().accept(this);
        functions.peek().getCodeBlock().setHasReturn(true);
        functions.peek().getCodeBlock().setReturnTainted(functions.peek().getCodeBlock().isReturnTainted() || stmt.getExpression().isTainted());
        codeBlocks.peek().setReturnTainted(stmt.getExpression().isTainted());
        Util.throwAny(new ReturnFoundException("Found return statement at line " + stmt.getLine()));
    }

    @Override
    public void visit(Variable var) {
        if (currentPathVariables.containsKey(var.getName())) {
            if(currentPathVariables.get(var.getName()).getClassReference() != null){
                /* var will almost always point to a different updated accessed attribute than the variable saved in
                 * currentPathVariables. If it's not different, then they are pointing to the same one. */
                currentPathVariables.get(var.getName()).setSelectedAttribute(var.getSelectedAttribute());
                /* The class reference will always have the attributes' taintedness updated but if the object
                 * (class instance) is being used then we have to update its own taintedness. */
                if(currentPathVariables.get(var.getName()).getSelectedAttribute() == null){
                    var.setTainted(currentPathVariables.get(var.getName()).getClassReference().areAttributesTainted());
                }
            } else{
                var.setTainted(currentPathVariables.get(var.getName()).isTainted());
            }
            currentPathVariables.get(var.getName()).setType(var.getType());
            var.setType(currentPathVariables.get(var.getName()).getType());
            return;
        }


        if (!functions.empty()) {
            var param = functions.peek().getParameters().getOrDefault(var.getName(), null);
            if (param != null) {
                param.accept(this);
                var.setTainted(param.isTainted());
                var.setType(param.getType());
                return;
            }
        }
        if (!classes.empty()) {
            var attribute = classes.peek().getAttributes().getOrDefault(var.getName(), null);
            if (attribute != null) {
                attribute.accept(this);
                var.setType(attribute.getType());
                var.setTainted(attribute.isTainted());
                return;
            }
        }

        if (!functions.empty() && functions.peek().getVariables().containsKey(var.getName())) {
            Variable variable = functions.peek().getVariables().get(var.getName());
            var.setType(variable.getType());
            if(variable.getClassReference() != null){
                if(variable.getSelectedAttribute() != null){
                    String attribute = variable.getSelectedAttribute();
                    var.setTainted(variable.getClassReference().getAttributes().get(attribute).isTainted());
                }else{
                    var.setTainted(variable.getClassReference().areAttributesTainted());
                }
                /* As we are using class references and the attribute accessed can be different, 
                 * this allows us to use a variable that can store that change in attributes without it
                 * affecting the variables referenced in the statements (class reference is always the same)
                 * which could introduce unwanted accesses
                */
                Variable newVarRef = createNewVariableForAttributes(variable);
                currentPathVariables.put(var.getName(), newVarRef);
            }else{
                var.setTainted(variable.isTainted());
                currentPathVariables.put(var.getName(), variable);
            }
            return;
        }
        if (spec.isAllFiles() && !spec.getGlobalTaintVariableRegex().isEmpty()) {
            for (String regex : spec.getGlobalTaintVariableRegex()) {
                if (Pattern.matches(regex, var.getName())) {
                    var.setTainted(true);
                }
            }
        }
        currentPathVariables.put(var.getName(), var);
    }

    @Override
    public void visit(Parameter param) {
        currentPathVariables.put(param.getName(), param);
    }

    @Override
    public void visit(Constant constant) {
    }

    @Override
    public void visit(Function function) {
        functions.push(function);
        while (!function.getCodeBlock().isFullyExplored()) {
            try {
                currentPath.clear();
                currentPathVariables.clear();
                codeBlocks.clear();
                function.getCodeBlock().accept(this);
            } catch (Exception e) {
                if (e.getMessage() != null)
                    System.out.println(e.getMessage());
                else {
                    e.printStackTrace();
                }
            }
        }
        functions.pop();
    }

    @Override
    public void visit(CodeBlock codeBlock) {
        codeBlocks.push(codeBlock);
        codeBlock.setFullyExplored(true);
        for (Statement stmt : codeBlock.getStatements()) {
            stmt.accept(this);
        }
        codeBlocks.pop();
    }

    @Override
    public void visit(File file) {
        if (spec.isAllFiles()) {
            if (file.getRootFunc() != null) {
                file.getRootFunc().accept(this);
            }
            file.getFunctions().forEach((s, function) -> function.accept(this));
            file.getClasses().forEach((s, aClass) -> aClass.getMethods().forEach((name, method) -> method.accept(this)));
            return;
        }
        if (spec.isRootSpecification()) {
            file.getRootFunc().accept(this);
            return;
        }
        if (spec.isMethod())
            file.getClasses().get(spec.getFunction().getType()).accept(this);
        else {
            file.getFunctions().get(spec.getFunction().getName()).accept(this);
        }
    }

    @Override
    public void visit(Class aClass) {
        classes.push(aClass);
        aClass.getMethods().get(spec.getFunction().getName()).accept(this);
        classes.pop();
    }

    @Override
    public void visit(ConditionalStatement conditionalStatement) {
        for (int i = 0; i < settings.getNumberOfTimesToAnalyzeCycles(); i++) {
            conditionalStatement.getCodeBlock().accept(this);
        }
    }

    @Override
    public void visit(GenericStatement statement) {
        if (statement.getStatement() != null) //TODO happens because in php assignments go under this
            statement.getStatement().accept(this);
    }

    //TODO: Check if code can be cleaner
    @Override
    public void visit(IfStatement ifStatement) {
        Expression ifExpr = ifStatement.getExpression();
        boolean conditionFulfilled = false;

        if(ifExpr.getOperator() != null){
            ifExpr.addValue(this);
        }

        if (!ifStatement.isFullyExplored()) {
            if(ifExpr.getTrackedValue() != null && 
            ifExpr.getType().equals("boolean")){
                if(Boolean.parseBoolean(ifExpr.getTrackedValue())){
                    conditionFulfilled = true;
                    currentPath.add(ifStatement);
                    ifStatement.getCodeBlock().accept(this);
                    currentPath.remove(ifStatement);
                    return;
                } else{
                    conditionFulfilled = false;
                    ifStatement.getCodeBlock().setFullyExplored(true);
                }
            } else {
                currentPath.add(ifStatement);
                codeBlocks.forEach(codeBlock -> codeBlock.setFullyExplored(false));
                ifStatement.getCodeBlock().accept(this);
                currentPath.remove(ifStatement);
                return;
            }
        }

        //Check all else if statements until a condition is evaluated to true.
        /* Will still have some impossible paths in more complex and difficult to
         * analyse conditions. */
        if(ifStatement.getElseIfs() != null && ifStatement.getElseIfs().size() > 0){
            for(IfStatement elseIf : ifStatement.getElseIfs()){
                if(!elseIf.isFullyExplored()){
                    if(elseIf.getExpression().getOperator() != null){
                        elseIf.getExpression().addValue(this);
                    }

                    if(elseIf.getExpression().getTrackedValue() != null && 
                    elseIf.getExpression().getType().equals("boolean")){
                        //Found an else if with a true condition
                        if(Boolean.parseBoolean(elseIf.getExpression().getTrackedValue())){
                            conditionFulfilled = true;
                            elseIf.accept(this);
                            return;
                        } else{
                            conditionFulfilled = false;
                            elseIf.getCodeBlock().setFullyExplored(true);
                        }
                    } else{
                        elseIf.accept(this);
                        return;
                    }
                }
            }
        }

        if (ifStatement.getElseBlock() != null && !ifStatement.getElseBlock().isFullyExplored()
        && ifStatement.getElseBlock().getStatements().size() > 0 && !conditionFulfilled) {
            ifStatement.getElseBlock().accept(this);
        }
    }

    @Override
    public void visit(Attribute attribute) {
        currentPathVariables.put(attribute.getName(), attribute);
    }

    @Override
    public void visit(NewExpression newExpression) {

    }

    @Override
    public void visit(AttributeAccess attributeAccess) {
    }

    @Override
    public void visit(MethodCallExpression methodCall) {
        if (methodCall.getSource() == null) {
            methodCall.getMembers().forEach(member -> member.accept(this));
            return;
        }
        methodCall.getSource().accept(this);
        boolean isTainted = false;
        if (methodCall.getSource() instanceof MethodCallExpression) {
            var sourceCall = (MethodCallExpression) methodCall.getSource();
            isTainted = processMethodCall(methodCall, sourceCall.getCurrentType(), sourceCall.isTainted());
            sourceCall.setTainted(isTainted);

        } else if (methodCall.getSource() instanceof Variable) {
            var source = currentPathVariables.get(((Variable) methodCall.getSource()).getName());
            isTainted = processMethodCall(methodCall, source.getType() != null ? source.getType() : source.getName(), source.isTainted());
            source.setTainted(isTainted);
        }
        methodCall.setTainted(isTainted);
        methodCall.getSource().setTainted(isTainted || methodCall.getSource().isTainted());
    }

    private boolean processMethodCall(MethodCallExpression methodCall, String type, boolean isTaintedSource) {
        methodCall.setCurrentType(type);
        var isTainted = false;
        boolean gotLambdaFunc = false;
        for (Expression member : methodCall.getMembers()) {
            if (member instanceof FunctionCall) {
                FunctionCall funcCall = (FunctionCall) member;
                if (methodCall.getCurrentType() == null) {
                    System.out.println("Source type is unknown so function call " + funcCall.getFunctionName() + " will be treated as a simple function " + " file: " + file.getName());
                    methodCall.setCurrentType(funcCall.getReturnType());
                    funcCall.accept(this);
                    isTainted = isTainted || funcCall.isTainted() || (isTaintedSource && spec.isReturnTaintedIfTaintedSource());
                } else {
                    if (isCallToSanitizationFunction(funcCall, isTaintedSource, methodCall.getCurrentType())) {
                        continue;
                    }
                    
                    if(methodCall.getSource() instanceof Variable){
                        Variable variable = (Variable) methodCall.getSource();
                        if(variable.getLambdaFunc() != null){
                            processFunction(variable.getLambdaFunc(), funcCall, file, classes.isEmpty() ? null : classes.peek());
                            isTainted = isTainted || funcCall.isTainted() || (isTaintedSource && spec.isReturnTaintedIfTaintedSource());
                            gotLambdaFunc = true;
                            variable.getLambdaFunc().getCodeBlock().setFullyExplored(false);
                        }
                    }

                    if(!gotLambdaFunc){
                        List<FileAndFunction> functions = getFunctionsForType(methodCall.getCurrentType(), funcCall);
                        if (functions.isEmpty()) {
                            System.out.println("Could not find any function for type " + methodCall.getCurrentType() + " and function: " + funcCall.getFunctionName() + " file: " + file.getName());
                            funcCall.accept(this);
                            methodCall.setCurrentType(funcCall.getReturnType());
                            isTainted = isTainted || funcCall.isTainted() || (isTaintedSource && spec.isReturnTaintedIfTaintedSource());
                        }

                        for (FileAndFunction func : functions) {
                            processFunction(func.getFunction(), funcCall, func.getFile(), func.getClazz());
                            isTainted = isTainted || funcCall.isTainted() || (isTaintedSource && spec.isReturnTaintedIfTaintedSource());
                            methodCall.setCurrentType(func.getFunction().getReturnType());
                        }
                    }
                }

            } else if (member instanceof AttributeAccess) {
                var newVar = new Variable(((AttributeAccess) member).getMemberName());
                newVar.accept(this);
                isTainted = isTainted || newVar.isTainted() || (isTaintedSource && spec.isReturnTaintedIfTaintedSource());
            } else {
                member.accept(this);
                isTainted = isTainted || member.isTainted() || (isTaintedSource && spec.isReturnTaintedIfTaintedSource());
            }
        }
        return isTainted;
    }

    private List<FileAndFunction> getFunctionsForType(String type, FunctionCall funcCall) {
        var classesForType = files.stream().filter(iterFile -> iterFile.getClasses().containsKey(type))
                .map(iterFile -> new FileAndClass(iterFile, iterFile.getClasses().get(type))).collect(Collectors.toList());

        if (classesForType.size() > 1) {
            System.out.println("Found more than one class for type " + type);
        }

        // methods for currentType
        List<FileAndFunction> functions = classesForType.stream().filter(clazz -> clazz.getClazz().getMethods().containsKey(funcCall.getFunctionName()))
                .map(clazz -> new FileAndFunction(clazz.getFile(), clazz.getClazz().getMethods().get(funcCall.getFunctionName()), clazz.getClazz()))
                .collect(Collectors.toList());

        if (functions.isEmpty()) {
            // methods from superclasses
            functions = classesForType.stream().filter(clazz -> clazz.getClazz().getSuperClass() != null)
                    .flatMap(clazz -> {
                        var superClass = clazz.getClazz().getSuperClass();
                        return files.stream()
                                .filter(iterFile -> iterFile.getClasses().containsKey(superClass)
                                        && iterFile.getClasses().get(superClass).getMethods().containsKey(funcCall.getFunctionName()))
                                .map(iterFile -> new FileAndFunction(iterFile, iterFile.getClasses()
                                        .get(superClass).getMethods().get(funcCall.getFunctionName()), iterFile.getClasses().get(superClass)));
                    })
                    .collect(Collectors.toList());
        }

        if (functions.size() > 1) {
            System.out.println("Found more than one file with the function call " + funcCall.getFunctionName());
        }

        return functions;
    }

    @Override
    public void visit(ThrowException throwException) {
        Util.throwAny(new Exception("Found throw statement  " + throwException.getLine()));
    }

    @Override
    public void visit(TryCatch tryCatch) {
        try {
            tryCatch.getTryBlock().accept(this);
        } catch (Exception e) {
            tryCatch.getCatchBlock().forEach(block -> block.accept(this));
            tryCatch.getFinallyBlock().accept(this);
            System.out.println("Found return statement in catch clause " + e.getMessage());
        }
    }

    private boolean propagateTaintInExpressionList(List<Expression> expressions) {
        boolean taint = false;
        for (Expression expr : expressions) {
            expr.accept(this);
            if(expr.getClassReference() != null && expr.getSelectedAttribute() != null){
                String attribute = expr.getSelectedAttribute();
                taint = taint || expr.getClassReference().getAttributes().get(attribute).isTainted();
            } else{
                taint = taint || expr.isTainted();
            }
        }
        return taint;
    }


    private void propagateSetTainted(Expression expression, boolean taint) {
        expression.setTainted(taint);
        if (expression instanceof Variable) {
            var variable = (Variable) expression;
            if(variable.getClassReference() != null){
                if(variable.getSelectedAttribute() != null){
                    String attributeName = variable.getSelectedAttribute();
                    currentPathVariables.get(variable.getName()).getClassReference().getAttributes()
                    .get(attributeName).setTainted(variable.isTainted());
                } else{
                    currentPathVariables.get(variable.getName()).setTainted(
                        variable.getClassReference().areAttributesTainted());
                }
            } else{
                currentPathVariables.get(variable.getName()).setTainted(variable.isTainted());
            }
        }
        for (Expression expr : expression.getMembers()) {
            propagateSetTainted(expr, taint);
        }
    }

    /*==================================================================* 
     *              New functions for value tracking                    *
     *==================================================================*/
    
     /**
      * @function track(Assignment)
      * @param assignment
      * This function is used for value tracking of the left side of the 
      * assignment, be it a primitive type, a class reference (more complex) or 
      * a lambda function reference. More comments along it that explain some of
      * the logic.
      */
     @Override
    public void track(Assignment assignment){
        if(assignment.getRight() != null){
            Expression expression = assignment.getRight();
            Variable variable = (Variable) assignment.getLeft();
            
            //Get expression's value
            if(expression.getOperator() != null){
                expression.addValue(this);
            }
            //Case where the expression has only 1 element (parameter) whose value 
            //isn't known until it arrives to this stage (TaintVisitor), e.g, var = param;
            if(expression.getTrackedValue() == null && expression.getMembers().size() == 1
                && expression.getClassReference() == null && expression.getLambdaFunc() == null){
                expression.setType(expression.getMembers().get(0).getType());
                expression.setTrackedValue(expression.getMembers().get(0).getTrackedValue());
            }

            if(expression.getTrackedValue() != null){
                if(variable.getClassReference() == null){
                    variable.setTrackedValue(expression.getTrackedValue());
                    variable.setType(expression.getType());
                } else{
                    String leftAttribute = assignment.getLeft().getSelectedAttribute();
                    variable.getClassReference().getAttributes().get(leftAttribute)
                    .setTrackedValue(expression.getTrackedValue());
                    variable.getClassReference().getAttributes().get(leftAttribute)
                    .setType(expression.getType());
                }
            }
            
            else if(expression.getClassReference() != null){
                /*Same as in GastBuilder's @function trackLeftVariableValue. 
                 * Have to watch out for the following cases: left-side is a simple variable so it becomes 
                 * a class instance if right-side does not access any attribute OR 
                 * left-side still is a simple variable but right-side accesses an attribute OR 
                 * left-side accesses an attribute but right-side doesnt so that attribute is a class instance OR 
                 * left-side & right-side both access an attribute
                 */
                if(expression.getSelectedAttribute() == null){
                    if(variable.getClassReference() != null && 
                    variable.getSelectedAttribute() != null){
                        String leftAttribute = expression.getSelectedAttribute();
                        variable.getClassReference().getAttributes().get(leftAttribute)
                        .setClassReference(expression.getClassReference());
                        
                        variable.getClassReference().getAttributes().get(leftAttribute)
                        .setType(expression.getType());
                    }
                    else{
                        variable.setClassReference(expression.getClassReference());
                        variable.setType(expression.getType());
                    }
                }
                else{
                    if(variable.getClassReference() != null && 
                    variable.getSelectedAttribute() != null){
                        String leftAttribute = variable.getSelectedAttribute();
                        String rightAttribute = expression.getSelectedAttribute();
                        variable.getClassReference().getAttributes().get(leftAttribute)
                        .setTrackedValue(expression.getClassReference()
                        .getAttributes().get(rightAttribute).getTrackedValue());
                        
                        variable.getClassReference().getAttributes().get(leftAttribute)
                        .setType(expression.getClassReference()
                        .getAttributes().get(rightAttribute).getType());
                    } 
                    else{
                        String rightAttribute = expression.getSelectedAttribute();

                        variable.setTrackedValue(expression.getClassReference()
                        .getAttributes().get(rightAttribute).getTrackedValue());

                        variable.setType(expression.getClassReference()
                        .getAttributes().get(rightAttribute).getType());
                    }
                }
            } else if(expression.getLambdaFunc() != null){
                variable.setLambdaFunc(expression.getLambdaFunc());
            } else{
                if(variable.getClassReference() != null){
                    if(variable.getSelectedAttribute() != null){
                        String attribute = variable.getSelectedAttribute();
                        variable.getClassReference().getAttributes().get(attribute).setTrackedValue(null);
                        variable.getClassReference().getAttributes().get(attribute).setClassReference(null);
                        variable.getClassReference().getAttributes().get(attribute).setLambdaFunc(null);
                        variable.getClassReference().getAttributes().get(attribute).setType(null);
                    } else{
                        variable.setClassReference(null);
                        variable.setType(null);
                    }

                } else{
                    variable.setTrackedValue(null);
                    variable.setType(null);
                }
            }

            assignment.setLeft(variable);

            if(currentPathVariables.containsKey(variable.getName())){
                if(currentPathVariables.get(variable.getName()).getClassReference() == null){
                    currentPathVariables.replace(variable.getName(), variable);
                }
            } else {
                currentPathVariables.put(variable.getName(), variable);
            }

            if(functions.peek().getVariables().containsKey(variable.getName())){
                if(functions.peek().getVariables().get(variable.getName()).getClassReference() == null){
                    functions.peek().getVariables().replace(variable.getName(), variable);
                }
            } 
        }
    }

    /**
     * @function track(Expression)
     * @param expression
     * 
     * Represents the logic for complex expressions between numbers and strings, ie,
     * additive, multiplicative, equality, relational expressions. Various distinctions
     * had to be made to assure the values are correct and legal. This function is invoked
     * if a given expression possesses an operator (+, -, *, /, %, ==, !=, <, <=, >, >=).
     */
    @Override
    public void track(Expression expression){
        Object result;
        double value = 0.0, anotherValue = 0.0;
        double epsilon = 0.000001d;
        
        //Check if its members also possess operators
        for(Expression expr : expression.getMembers()){
            if(expr.getOperator() != null){
                expr.addValue(this);
            }
        }

        Expression expr1 = expression.getMembers().get(0);
        Expression expr2 = expression.getMembers().get(1);
        if((expr1.getTrackedValue() == null && expr1.getClassReference() == null) 
        || (expr2.getTrackedValue() == null && expr2.getClassReference() == null)){
            expression.setTrackedValue(null);
            expression.setType("null");
            return;
        }

        //Have to check if any of the expressions is an attribute access
        if(expr1.getClassReference() != null && expr1.getSelectedAttribute() != null){
            expr1 = (Expression) expr1.getClassReference().getAttributes().get(expr1.getSelectedAttribute());
        }

        if(expr2.getClassReference() != null && expr2.getSelectedAttribute() != null){
            expr2 = (Expression) expr2.getClassReference().getAttributes().get(expr2.getSelectedAttribute());
        }

        boolean areNumbers = (expr1.getType().equals("int") ||
        expr1.getType().equals("double") || expr1.getType().equals("char")) && 
        (expr2.getType().equals("int") || expr2.getType().equals("double") ||
        expr2.getType().equals("char"));

        if(areNumbers){
            value = expr1.getType().equals("char") ? (char)expr1.getTrackedValue().toCharArray()[1] 
            : Double.valueOf(expr1.getTrackedValue());
            anotherValue = expr2.getType().equals("char") ? (char)expr2.getTrackedValue()
            .toCharArray()[1] : Double.valueOf(expr2.getTrackedValue());
        }
        switch(expression.getOperator()){
            case ">":
                System.out.println("GT Expression");
                result = value > anotherValue;
                expression.setTrackedValue(result.toString());
                expression.setType("boolean");
                return;
            case ">=":
                System.out.println("GE Expression");
                result = value >= anotherValue;
                expression.setTrackedValue(result.toString());
                expression.setType("boolean");
                return;
            case "<":
                System.out.println("LT Expression");
                result = value < anotherValue;
                expression.setTrackedValue(result.toString());
                expression.setType("boolean");
                return;
            case "<=":
                System.out.println("LE Expression");
                result = value <= anotherValue;
                expression.setTrackedValue(result.toString());
                expression.setType("boolean");
                return;
            case "*":
                System.out.println("MUL Expression");
                result = value * anotherValue;
                expression.setTrackedValue(result.toString());
                expression.setType("double");
                return;
            case "/":
                System.out.println("DIV Expression");
                result = value / anotherValue;
                expression.setTrackedValue(result.toString());
                expression.setType("double");
                return;
            case "%":
                System.out.println("MOD Expression");
                result = value % anotherValue;
                expression.setTrackedValue(result.toString());
                expression.setType("double");
                return;
            case "+":
                System.out.println("ADD Expression");
                if(areNumbers){
                    result = value + anotherValue;
                    expression.setTrackedValue(result.toString());
                    expression.setType("double"); 
                } else if(expr1.getType().equals("String") || expr2.getType().equals("String")){
                    result = expr1.getTrackedValue() + expr2.getTrackedValue();
                    expression.setTrackedValue(result.toString());
                    expression.setType("String");
                }
                return;
            case "-":
                System.out.println("SUB Expression");
                result = value - anotherValue;
                expression.setTrackedValue(result.toString());
                expression.setType("double");
                return;
            case "==":
                System.out.println("EQUALS");
                if(areNumbers){
                    result = Math.abs(value - anotherValue) < epsilon;
                    expression.setTrackedValue(result.toString());
                    expression.setType("boolean");
                } else if(expr1.getType().equals("boolean") && expr2.getType().equals("boolean")){
                    result = Boolean.valueOf(expr1.getTrackedValue()) == Boolean.valueOf(expr2.getTrackedValue());
                    expression.setTrackedValue(result.toString());
                    expression.setType("boolean");
                } else if(expr1.getType().equals("String") && expr2.getType().equals("String")){
                    result = expr1.getTrackedValue().equals(expr2.getTrackedValue());
                    expression.setTrackedValue(result.toString());
                    expression.setType("boolean");
                }
                return;
            case "!=":
                System.out.println("NOTEQUALS");
                if(areNumbers){
                    result = Math.abs(value - anotherValue) >= epsilon;
                    expression.setTrackedValue(result.toString());
                    expression.setType("boolean");
                } else if(expr1.getType().equals("boolean") && expr2.getType().equals("boolean")){
                    result = Boolean.valueOf(expr1.getTrackedValue()) != Boolean.valueOf(expr2.getTrackedValue());
                    expression.setTrackedValue(result.toString());
                    expression.setType("boolean");
                } else if(expr1.getType().equals("String") && expr2.getType().equals("String")){
                    result = !expr1.getTrackedValue().equals(expr2.getTrackedValue());
                    expression.setTrackedValue(result.toString());
                    expression.setType("boolean");
                }
                return;
            default:
            System.out.println("Unknown operator: " + expression.getOperator());
            return;
        }
    }

    /**
     * @function createNewVariableForAttributes
     * @return Variable
     * 
     * Receives a variable and returns another reference to that variable with the same
     * information regarding name, type, if it's tainted or not, etc. Used mainly because
     * of class instances to know what attribute was used for that instance in a given statement,
     * without having that information be overwritten to all other references of that variable
     */
    public Variable createNewVariableForAttributes(Variable variable){
        Variable var = new Variable(variable.getName());
        var.setClassReference(variable.getClassReference());
        var.setType(variable.getType());
        var.setLine(variable.getLine());
        var.setTainted(variable.isTainted());
        var.setText(variable.getText());
        return var;
    }

}
