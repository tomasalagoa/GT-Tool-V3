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
public class TaintVisitor implements AstBuilderVisitorInterface {

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
        }
    }

    @Override
    public void visit(Expression expression) {
        expression.setTainted(propagateTaintInExpressionList(expression.getMembers()));
    }

    @Override
    public void visit(Assignment assignment) {
        assignment.getLeft().accept(this);
        if (assignment.getRight() == null) //when is only a var declaration
            return;
        assignment.getRight().accept(this);
        propagateSetTainted(assignment.getLeft(), assignment.getRight().isTainted());
        assignment.setTainted(assignment.getRight().isTainted());
        assignment.getLeft().setTainted(assignment.getRight().isTainted());
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
            var.setTainted(currentPathVariables.get(var.getName()).isTainted());
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
            var.setTainted(variable.isTainted());
            var.setType(variable.getType());
            currentPathVariables.put(var.getName(), variable);
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

    @Override
    public void visit(IfStatement ifStatement) {
        if (!ifStatement.isFullyExplored()) {
            currentPath.add(ifStatement);
            codeBlocks.forEach(codeBlock -> codeBlock.setFullyExplored(false));
            ifStatement.getCodeBlock().accept(this);
            currentPath.remove(ifStatement);
            return;
        }

        IfStatement firstNotExploredElseIf = ifStatement.getElseIfs().stream().filter(stmt -> !stmt.isFullyExplored()).findFirst().orElse(null);

        if (firstNotExploredElseIf != null) {
            firstNotExploredElseIf.accept(this);
            return;
        }

        if (ifStatement.getElseBlock() != null && !ifStatement.getElseBlock().isFullyExplored()) {
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
            System.out.println("Fount return statement in catch clause " + e.getMessage());
        }
    }


    private boolean propagateTaintInExpressionList(List<Expression> expressions) {
        boolean taint = false;
        for (Expression expr : expressions) {
            expr.accept(this);
            taint = taint || expr.isTainted();
        }
        return taint;
    }


    private void propagateSetTainted(Expression expression, boolean taint) {
        expression.setTainted(taint);
        if (expression instanceof Variable) {
            var variable = (Variable) expression;
            currentPathVariables.get(variable.getName()).setTainted(variable.isTainted());
        }
        for (Expression expr : expression.getMembers()) {
            propagateSetTainted(expr, taint);
        }
    }

}
