package ist.gt.gastBuilder;

import ist.gt.model.Class;
import ist.gt.model.*;
import ist.gt.util.Util;
import lombok.Data;

import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.commons.lang3.NotImplementedException;

import java.util.*;

@Data
public class GastBuilder {

    private final Stack<Statement> statements = new Stack<>();
    private Function currentFunction;
    private Stack<CodeBlock> codeBlocks = new Stack<>();
    private Stack<IfStatement> ifStatements = new Stack<>();
    private final File file;
    private final Stack<Class> classes = new Stack<>();
    private HashMap<String, Class> analyzedClasses = new HashMap<>();
    private final Stack<TryCatch> tryCatches = new Stack<>();
    private Function currentLambdaFunction;
    private boolean needsFurtherSuperclassUpdate = false;
    private List<String> taintedAttributes = null;
    private boolean isParameter = false;
    private boolean inCollection = false;
    private boolean classInMethodCallSource = false;

    private <E> void popIfNotEmpty(Stack<E> stack) {
        if (!stack.empty())
            stack.pop();
    }

    public void addImportedFile(String fileName) {
        file.getImportedFiles().add(Util.removeQuotes(fileName));
    }

    private void processExpression(Expression expression) {
        if (!statements.empty())
            statements.peek().accept(new ExpressionVisitor(expression));
    }

    public void exitFunctionOrMethodDeclaration() {
        currentFunction = file.getRootFunc();
        popIfNotEmpty(codeBlocks);
    }

    public void exitConditionalStatement() {
        popIfNotEmpty(codeBlocks);
        popIfNotEmpty(statements);
    }

    public void enterElseStatement(ParserRuleContext ctx) {
        ifStatements.peek().getElseBlock().setLine(ctx.start.getLine());
        codeBlocks.push(ifStatements.peek().getElseBlock());
    }

    public void exitElseIfOrElseStatement() {
        popIfNotEmpty(codeBlocks);
    }

    public void exitIfStatement() {
        ifStatements.pop();
        exitConditionalStatement();
    }

    public void exitStatementOrExpression() {
        popIfNotEmpty(statements);
    }

    public void exitClass() {
        classes.pop();
    }

    public GastBuilder(String filename) {
        file = new File(filename);
        currentFunction = file.getRootFunc();
        codeBlocks.push(file.getRootFunc().getCodeBlock());
    }

    public void enterCatchBlock() {
        //popIfNotEmpty(codeBlocks);
        CodeBlock block = new CodeBlock();
        tryCatches.peek().getCatchBlock().add(block);
        codeBlocks.push(block);
    }

    public void exitCatchBlock() {
        popIfNotEmpty(codeBlocks);
    }

    public void enterFinallyBlock() {
        codeBlocks.push(tryCatches.peek().getFinallyBlock());
    }

    public void exitFinallyBlock() {
        popIfNotEmpty(codeBlocks);
    }

    public void exitTryCatchBlock() {
        popIfNotEmpty(codeBlocks);
        tryCatches.pop();
    }


    public FunctionCall addFunctionCall(ParserRuleContext ctx, String name) {
        FunctionCall functionCall = new FunctionCall(ctx, name);
        if (currentLambdaFunction == null) {
            processExpression(functionCall);
        } else {
            if (!addStatementsToLambdaFunc(functionCall)) {
                processExpression(functionCall);
            }
        }
        statements.push(functionCall);
        return functionCall;
    }


    public void addExpression(ParserRuleContext ctx) {
        Expression expression = new Expression(ctx);
        if (currentLambdaFunction == null) {
            processExpression(expression);
        } else {
            if (!addStatementsToLambdaFunc(expression)) {
                processExpression(expression);
            }
        }
        statements.push(expression);
    }


    public Assignment addAssignment(ParserRuleContext ctx) {
        Assignment assignment = new Assignment(ctx);
        if (currentLambdaFunction == null) {
            codeBlocks.peek().getStatements().add(assignment);
        } else {
            if (!addStatementsToLambdaFunc(assignment)) {
                codeBlocks.peek().getStatements().add(assignment);
            }
        }
        statements.push(assignment);
        return assignment;
    }


    public ReturnStatement addReturnStatement(ParserRuleContext ctx) {
        ReturnStatement stmt = new ReturnStatement(ctx);
        if (currentLambdaFunction == null) {
            codeBlocks.peek().getStatements().add(stmt);
        } else {
            if (!addStatementsToLambdaFunc(stmt)) {
                codeBlocks.peek().getStatements().add(stmt);
            }
        }
        statements.push(stmt);
        return stmt;
    }


    public Variable addVariable(ParserRuleContext ctx, String name) {
        Variable var = new Variable(ctx, name);
        /* Update var's tracked value info in case the variable was
         * already analysed. */
        if (currentFunction.getVariables().containsKey(var.getName())) {
            var = currentFunction.getVariables().get(var.getName());
        }
        /* In case a parameter's value is overwritten (with an assignment), we will
         * not know its type unless we retrieve it. */
        else if (!currentFunction.getVariables().containsKey(var.getName()) &&
                currentFunction.getParameters().containsKey(var.getName())) {
            var = currentFunction.getParameters().get(var.getName());
            isParameter = true;
        }
        /* If the variable is not in current function nor is it a parameter of it,
         * then it could be a parameter of a lambda function (declared in an interface to run it). */
        else if (currentLambdaFunction != null &&
                currentLambdaFunction.getParameters().containsKey(var.getName())) {
            var = currentLambdaFunction.getParameters().get(var.getName());
            isParameter = true;
        }
        /* If the variable is not in the current function (not a local variable),
         * not a parameter of the local function and not a parameter of a lambda function, then it could be
         * an attribute that is being used without the keyword "this". */
        else if (!classes.isEmpty() && classes.peek().getAttributes().containsKey(var.getName())) {
            // maybe "this" is already a variable in the current function, meaning we have encountered an attribute
            // before
            String attribute = var.getName();
            if (currentFunction.getVariables().containsKey("this")) {
                currentFunction.getVariables().get("this").setSelectedAttribute(attribute);
            } else {
                var.setName("this");
                var.setSelectedAttribute(attribute);
            }
        }

        if (!var.getName().equals("this")) {
            if (!isParameter) {
                currentFunction.getVariables().putIfAbsent(var.getName(), var);
            } else {
                isParameter = false;
            }
        } else {
            if (!currentFunction.getVariables().containsKey("this")) {
                Variable ths = new Variable("this");
                ths.setType(classes.peek().getName());
                currentFunction.getVariables().put("this", ths);
            }
        }
        processExpression(var);
        return var;
    }


    public Variable addVariable(ParserRuleContext ctx, String name, String type) {
        Variable var = addVariable(ctx, name);
        var.setType(type);
        return var;
    }

    public Parameter addParameter(ParserRuleContext ctx, String name) {
        Parameter param = new Parameter(ctx, name);
        if (currentLambdaFunction == null) {
            statements.clear();
            currentFunction.getParameters().put(param.getName(), param);
        }
        return param;
    }

    public Variable addParameter(ParserRuleContext ctx, String name, String type) {
        Parameter parameter = addParameter(ctx, name);
        parameter.setType(type);
        return parameter;
    }

    /**
     * This function creates a new Constant based on the context generated by the parser of a specific language.
     * To implement language-specific constructs, the developer only needs to add the specific conditional related to
     * their construct.
     * The actual creation of the Constant is deferred to the later addConstant function.
     *
     * @param ctx  the context from the FileListener
     * @param opts this is an object that contains information on if a number is negative or if a string needs its
     *             quotes removed
     * @return the created Constant (unused)
     */
    public Constant addConstant(ParserRuleContext ctx, LiteralOptions opts) {
        // Java / Generic Literals

        if (Util.callMethodIfExists(ctx, "BooleanLiteral") != null) {
            return addConstant(ctx, opts, "boolean");
        } else if (Util.callMethodIfExists(ctx, "IntegerLiteral") != null) {
            return addConstant(ctx, opts, "int");
        } else if (Util.callMethodIfExists(ctx, "FloatingPointLiteral") != null) {
            return addConstant(ctx, opts, "double");
        } else if (Util.callMethodIfExists(ctx, "CharacterLiteral") != null) {
            return addConstant(ctx, opts, "char");
        } else if (Util.callMethodIfExists(ctx, "StringLiteral") != null) {
            return addConstant(ctx, opts, "string");
        } else if (Util.callMethodIfExists(ctx, "NullLiteral") != null) {
            return addConstant(ctx, opts, "null");
        }

        // JS Literals

        else if (Util.callMethodIfExists(ctx, "numericLiteral") != null) {
            // Repeat of FloatingPointLiteral, could be refactored to the same case but for clarity will be separated
            return addConstant(ctx, opts, "double");
        } else if (Util.callMethodIfExists(ctx, "TemplateStringLiteral") != null || Util.callMethodIfExists(ctx, "RegularExpressionLiteral") != null) {
            return addConstant(ctx, opts, "string");
        }

        // PHP

        else if (Util.callMethodIfExists(ctx, "literalConstant") != null) {
            if (Util.callMethodIfExists(ctx, "Real") != null) {
                return addConstant(ctx, opts, "double");
            } else if (Util.callMethodIfExists(ctx, "BooleanConstant") != null) {
                return addConstant(ctx, opts, "boolean");
            } else if (Util.callMethodIfExists(ctx, "numericConstant") != null) {
                return addConstant(ctx, opts, "double");
            } else if (Util.callMethodIfExists(ctx, "stringConstant") != null) {
                return addConstant(ctx, opts, "string");
            } else {
                // Should not happen
                return null;
            }
        } else if (Util.callMethodIfExists(ctx, "magicConstant") != null || Util.callMethodIfExists(ctx,
                "classConstant") != null || Util.callMethodIfExists(ctx, "qualifiedNamespaceName") != null) {
            // TODO not implemented yet
            return addConstant(ctx, opts, "string");
        }else if (Util.callMethodIfExists(ctx, "Real") != null) {
            return addConstant(ctx, opts, "double");
        } else if (Util.callMethodIfExists(ctx, "BooleanConstant") != null) {
            return addConstant(ctx, opts, "boolean");
        } else if (Util.callMethodIfExists(ctx, "numericConstant") != null) {
            return addConstant(ctx, opts, "double");
        } else if (Util.callMethodIfExists(ctx, "stringConstant") != null) {
            return addConstant(ctx, opts, "string");
        } else if (Util.callMethodIfExists(ctx, "Null") != null) {
            return addConstant(ctx, opts, "null");
        }

        else {
            throw new NotImplementedException("Unrecognized data type " + ctx.getText());
        }
    }

    /**
     * This function creates a new constant based on the context generated by the parser of a specific-language.
     * FileListeners should call the more generic version and add conditionals for their specific cases but some
     * parsers generate specific rules for each data type which would necessitate the calling of this function
     * @param ctx the context from the FileListener
     * @param ruleType the type of the constant to be added
     * @param opts this is an object that contains information on if a number is negative or if a string needs its
     *             quotes removed
     * @return the constant created
     */
    public Constant addConstant(ParserRuleContext ctx, LiteralOptions opts, String ruleType) {
        String type = "null";
        String value = ctx.getText();
        switch (ruleType) {
            case "string" -> {
                type = "string";
                if (opts.removeQuotes()) {
                    value = ctx.getText().substring(1, ctx.getText().length() - 1).replace("\"\"", "\"");
                }
            }
            case "int" -> {
                type = "int";
                if (opts.isNegativeNumber()) {
                    value = "-" + value;
                }
            }
            case "double" -> {
                type = "double";
                if (opts.isNegativeNumber()) {
                    value = "-" + value;
                }
            }
            case "boolean" -> {
               type = "boolean";
            }
            case "null" -> {
                // Do nothing
            }
            case "char" -> {
                type = "char";
            }
            default -> {
                throw new NotImplementedException("Unrecognized data type " + ctx.getText());
            }
        }

        var constant = new Constant(ctx, value, type);
        processExpression(constant);
        return constant;
    }


    public Function addFunction(ParserRuleContext ctx, String name) {
        var function = new Function(name, ctx);
        currentFunction = function;
        statements.clear();
        codeBlocks.push(function.getCodeBlock());
        if (classes.empty()) {
            file.getFunctions().put(function.getName(), function);
        } else {
            classes.peek().getMethods().put(function.getName(), function);
            function.getThisVar().setClassReference(this.analyzedClasses.get(classes.peek().getName()));
        }
        return function;
    }


    public Function addFunction(ParserRuleContext ctx, String name, String returnType) {
        var function = addFunction(ctx, name);
        function.setReturnType(returnType);
        return function;
    }


    public Class addClass(ParserRuleContext ctx, String name) {
        var aClass = new Class(ctx, name);
        statements.clear();
        file.getClasses().put(aClass.getName(), aClass);
        classes.push(aClass);
        analyzedClasses.put(aClass.getName(), aClass);
        return aClass;
    }

    public Class addClass(ParserRuleContext ctx, String name, String superClass) {
        var aClass = addClass(ctx, name);
        aClass.setSuperClass(superClass);
        return aClass;
    }


    public IfStatement addIfStatement(ParserRuleContext ctx, String condition, boolean isElseIf) {
        var ifStatement = new IfStatement(ctx, condition, isElseIf);
        if (ifStatement.isElseIf()) {
            ifStatements.peek().getElseIfs().add(ifStatement);
        } else {
            ifStatements.push(ifStatement);
            if (currentLambdaFunction == null) {
                codeBlocks.peek().getStatements().add(ifStatement);
            } else {
                if (!addStatementsToLambdaFunc(ifStatement)) {
                    codeBlocks.peek().getStatements().add(ifStatement);
                }
            }
        }
        setConditionalStmt(ifStatement);
        return ifStatement;
    }


    public void addConditionalStatement(ParserRuleContext ctx) {
        var conditionalStatement = new ConditionalStatement(ctx);
        if (currentLambdaFunction == null) {
            codeBlocks.peek().getStatements().add(conditionalStatement);
        } else {
            if (!addStatementsToLambdaFunc(conditionalStatement)) {
                codeBlocks.peek().getStatements().add(conditionalStatement);
            }
        }
        setConditionalStmt(conditionalStatement);
    }


    public GenericStatement addGenericStatement(ParserRuleContext ctx) {
        var statement = new GenericStatement(ctx);
        if (currentLambdaFunction == null) {
            codeBlocks.peek().getStatements().add(statement);
        } else {
            if (!addStatementsToLambdaFunc(statement)) {
                codeBlocks.peek().getStatements().add(statement);
            }
        }
        statements.push(statement);
        return statement;
    }

    private void setConditionalStmt(ConditionalStatement stmt) {
        codeBlocks.push(stmt.getCodeBlock());
        statements.push(stmt);
    }


    public NewExpression addNewExpression(ParserRuleContext ctx, String className) {
        NewExpression newExpression = new NewExpression(ctx, className);
        processExpression(newExpression);
        statements.push(newExpression);
        return newExpression;
    }


    public AttributeAccess addAttributeAccess(ParserRuleContext ctx, String identifier) {
        AttributeAccess attributeAccess = new AttributeAccess(ctx, identifier);
        processExpression(attributeAccess);
        statements.push(attributeAccess);
        return attributeAccess;
    }


    public void addMethodInvocation(ParserRuleContext ctx, MethodOptions opts) {
        if (Util.callMethodIfExists(ctx, "SUPER") != null) {
            addSuperMethodCall(ctx, opts.identName(), false);
        }

        if (Util.callMethodIfExists(ctx, "methodName") != null) {
            addFunctionCall(ctx, opts.methodName());
        }

        if (Util.callMethodIfExists(ctx, "typeName") != null) {
            addMethodCall(ctx);
            addVariable(ctx, opts.typeName());
            addFunctionCall(ctx, opts.identName());
        } else {
            addMethodCall(ctx);
            if (Util.callMethodIfExists(ctx, "primary") != null) {
                if (opts.primaryName().equals("this")) {
                    addVariable(ctx, opts.primaryName());
                } else {
                    classInMethodCallSource = true;
                }
            }
            addFunctionCall(ctx, opts.identName());
        }
    }

    public void exitMethodInvocation(ParserRuleContext ctx) {
        if (Util.callMethodIfExists(ctx, "SUPER") != null) {
            exitStatementOrExpression();
        }

        if (Util.callMethodIfExists(ctx, "methodName") != null) {
            exitStatementOrExpression();
        } else if (Util.callMethodIfExists(ctx, "typeName") != null) {
            exitStatementOrExpression();
            exitStatementOrExpression();
        } else {
            if (classInMethodCallSource) {
                rearrangeMethodClassWithClassSource();
                classInMethodCallSource = false;
            }
            exitStatementOrExpression();
            exitStatementOrExpression();
        }
    }

    public MethodCallExpression addMethodCall(ParserRuleContext ctx) {
        var methodCall = new MethodCallExpression(ctx);
        processExpression(methodCall);
        statements.push(methodCall);
        return methodCall;
    }


    public ThrowException addThrowException(ParserRuleContext ctx) {
        ThrowException throwException = new ThrowException(ctx);
        codeBlocks.peek().getStatements().add(throwException);
        statements.push(throwException);
        return throwException;
    }


    public TryCatch addTryCatch(ParserRuleContext ctx) {
        var tryCatch = new TryCatch(ctx);
        codeBlocks.peek().getStatements().add(tryCatch);
        codeBlocks.push(tryCatch.getTryBlock());
        tryCatches.push(tryCatch);
        return tryCatch;
    }


    public Attribute addAttribute(ParserRuleContext ctx, String name) {
        var attribute = new Attribute(ctx, name);
        if (this.taintedAttributes != null && this.taintedAttributes.contains(attribute.getName())) {
            attribute.setTainted(true);
        }
        classes.peek().getAttributes().put(attribute.getName(), attribute);
        processExpression(attribute);
        return attribute;
    }

    public Attribute addAttribute(ParserRuleContext ctx, String name, String type) {
        var attribute = addAttribute(ctx, name);
        attribute.setType(type);
        return attribute;
    }

    /**
     * @param ctx Creates a new Function to represent a lambda function and gives it to the
     *            Expression that will store it.
     * @function addLambdaFunction
     */
    public void addLambdaFunction(ParserRuleContext ctx) {
        if (statements.peek() instanceof Expression) {
            Expression expression = (Expression) statements.pop();
            Function lambdaFunc = new Function();
            expression.setLambdaFunc(lambdaFunc);
            expression.setType("Lambda");
            currentLambdaFunction = lambdaFunc;
            statements.push(expression);
        }
    }

    /**
     * @function exitLambdaFunction
     * <p>
     * Sets the flag analyzingLambdaFunc to false as it is no longer analyzing
     * a lambda function.
     */
    public void exitLambdaFunction() {
        currentLambdaFunction = null;
    }

    /**
     * @param ctx       desc
     * @param paramName desc
     *                  <p>
     *                  Receives a parameter's name as well as its context in order to retrieve
     *                  it from the root function and give it to the associated lambda function.
     * @function addParametersToLambdaFunction
     */
    public void addParametersToLambdaFunction(ParserRuleContext ctx, String paramName) {
        if (currentLambdaFunction != null) {
            String type;
            if (this.file.getRootFunc().getParameters().containsKey(paramName)) {
                type = this.file.getRootFunc().getParameters().get(paramName).getType();
            } else {
                type = null;
            }
            Parameter param = new Parameter(ctx, paramName, type);
            currentLambdaFunction.getParameters().put(paramName, param);
        }
    }

    /*==================================================================*
     *      New functions for value tracking (Java only for now)        *
     *==================================================================*/

    /**
     * @function trackClassReference
     * <p>
     * Updates the expression (which will be a variable) with a reference to the
     * class it is being instantiated with (through @param className ), basically
     * doing value tracking for class instances. Right now, it is called
     * whenever a newExpression is used.
     */
    public void trackClassReference(String className) {
        /* NewExpression version stays because of Python, JS value tracking
         * versions being behind Java's. */
        NewExpression newExpression = null;
        /* FunctionCall represents a constructor's invocation (for class instances' creation)*/
        FunctionCall functionCall = null;
        Expression expression = null;
        if (statements.peek() instanceof NewExpression) {
            newExpression = (NewExpression) statements.pop();
        } else if (statements.peek() instanceof FunctionCall) {
            functionCall = (FunctionCall) statements.pop();
            functionCall.setConstructor(true);
        }

        if (statements.peek() instanceof Expression) {
            expression = (Expression) statements.pop();
            Class trackedClass = new Class(className);

            if (this.analyzedClasses.containsKey(className)) {
                Class originalClass = this.analyzedClasses.get(className);
                trackedClass.setSuperClass(originalClass.getSuperClass());
                HashMap<String, Attribute> superclassAttributes = getAllSuperclassesAttributes(
                        originalClass.getSuperClass());

                //Needed so that attributes do not share same reference between different instances
                HashMap<String, Attribute> attributes = new HashMap<>();
                for (Attribute attribute : originalClass.getAttributes().values()) {
                    Attribute newAttribute = createNewAttributeReference(attribute);
                    attributes.put(newAttribute.getName(), newAttribute);
                }

                if (superclassAttributes != null) {
                    if (this.needsFurtherSuperclassUpdate) {
                        trackedClass.setNeedSuperclassUpdate(true);
                        originalClass.setNeedSuperclassUpdate(true);
                        this.needsFurtherSuperclassUpdate = false;
                    }

                    for (Attribute attribute : superclassAttributes.values()) {
                        attributes.put(attribute.getName(), attribute);
                    }
                } else if (trackedClass.getSuperClass() != null) {
                    trackedClass.setNeedSuperclassUpdate(true);
                    originalClass.setNeedSuperclassUpdate(true);
                }
                trackedClass.setAttributes(attributes);
                trackedClass.setMethods(new HashMap<>(originalClass.getMethods()));

                expression.setClassReference(trackedClass);
                if (functionCall != null) {
                    functionCall.getHiddenThis().setClassReference(trackedClass);
                }
                expression.setType(trackedClass.getName());
            } else {
                trackedClass.setNeedSuperclassUpdate(true);
                if (functionCall != null) {
                    functionCall.getHiddenThis().setClassReference(trackedClass);
                }
                expression.setClassReference(trackedClass);
                expression.setType(trackedClass.getName());
            }
        }

        if (newExpression != null) {
            statements.push(newExpression);
        }

        if (expression != null) {
            statements.push(expression);
        }

        if (functionCall != null) {
            statements.push(functionCall);
        }
    }

    /**
     * @param superclassName
     * @return HashMap<String, Attribute>
     * <p>
     * Receives the name of a given superclass and returns its attributes + the ones of its
     * superclass (and so on) if applicable.
     * @function getAllSuperclassesAttributes
     */
    public HashMap<String, Attribute> getAllSuperclassesAttributes(String superclassName) {
        if (superclassName == null || !this.analyzedClasses.containsKey(superclassName)) {
            return null;
        } else {
            HashMap<String, Attribute> attributes = new HashMap<>();
            ArrayList<Class> superclasses = new ArrayList<>();
            boolean noMoreSupers = false;

            while (!noMoreSupers) {
                if (this.analyzedClasses.containsKey(superclassName)) {
                    Class superclass = this.analyzedClasses.get(superclassName);
                    superclasses.add(superclass);
                    if (superclass.getSuperClass() != null) {
                        superclassName = superclass.getSuperClass();
                    } else {
                        noMoreSupers = true;
                    }
                } else {
                    this.needsFurtherSuperclassUpdate = true;
                    break;
                }
            }

            for (Class c : superclasses) {
                for (Attribute attribute : c.getAttributes().values()) {
                    Attribute newAttribute = createNewAttributeReference(attribute);
                    attributes.put(newAttribute.getName(), newAttribute);
                }
            }
            return attributes;
        }
    }

    /**
     * @param attribute
     * @return Attribute
     * <p>
     * Represents the creation of a new reference for the @param attribute.
     * The goal here is to create a new reference for a given attribute (whenever
     * a new class instance is created) so that it is not the same as the one stored
     * in the classes field of GastBuilder.
     * @function createNewAttributeReference
     */
    public Attribute createNewAttributeReference(Attribute attribute) {
        Attribute newAttribute = new Attribute();
        newAttribute.setName(attribute.getName());
        newAttribute.setType(attribute.getType());
        newAttribute.setTainted(attribute.isTainted());
        newAttribute.setLine(attribute.getLine());
        newAttribute.setText(attribute.getText());
        newAttribute.setTrackedValue(attribute.getTrackedValue());
        newAttribute.setClassReference(attribute.getClassReference());
        newAttribute.setLambdaFunc(attribute.getLambdaFunc());
        return newAttribute;
    }

    /**
     * @function trackLeftVariableValue
     * <p>
     * Passes the value on the right side of an assignment to the left side,
     * if the right side exists (i.e. could just be an empty variable declaration)
     * or if it has a type meaning its value could be tracked earlier (will be
     * tracked later if not). Also supports class reference and lambda function tracking.
     */
    public void trackLeftVariableValue() {
        if (statements.peek() instanceof Assignment) {
            Assignment assignment = (Assignment) statements.pop();

            if (assignment.getRight() != null && assignment.getRight().getType() != null && (assignment.getOperator() == null || assignment.getOperator().equals("="))) {
                Variable var = (Variable) assignment.getLeft();
                //Is the right-side a simple variable?
                if (assignment.getRight().getTrackedValue() != null) {
                    //Check if left has class reference or not
                    if (var.getClassReference() == null || var.getSelectedAttribute() == null) {
                        var.setTrackedValue(assignment.getRight().getTrackedValue());
                        var.setClassReference(null);
                        var.setLambdaFunc(null);
                        var.setType(assignment.getRight().getType());
                    }
                } else if (assignment.getRight().getClassReference() != null) {
                    /* A new class reference is assigned to the variable on the left side of the assignment. */
                    if (assignment.getRight().getSelectedAttribute() == null && var.getSelectedAttribute() == null) {
                        var.setClassReference(assignment.getRight().getClassReference());
                        var.setType(assignment.getRight().getType());
                        var.setTrackedValue(null);
                        var.setLambdaFunc(null);
                    }
                } else if (assignment.getRight().getLambdaFunc() != null) {
                    var.setLambdaFunc(assignment.getRight().getLambdaFunc());
                    var.setClassReference(null);
                    var.setTrackedValue(null);
                }

                if (var.getTrackedValue() != null || var.getClassReference() != null
                        || var.getLambdaFunc() != null) {
                    if (var.getSelectedAttribute() == null) {
                        currentFunction.getVariables().replace(var.getName(), var);
                    }
                    assignment.setLeft(var);
                }
            }
            statements.push(assignment);
        }
    }

    /**
     * @function trackExpressionValue
     * <p>
     * Updates the value of current Expression. Can only be made if the current
     * Expression does not possess a tracked value (or class reference) yet and if it only has one
     * element (Variable, Parameter, etc.), making it able to immediately get its
     * value in this stage.
     */
    public void trackExpressionValue() {
        if (statements.peek() instanceof Expression) {
            Expression expression = (Expression) statements.pop();
            //Most likely this expression only has one element
            if (expression.getMembers().size() == 1) {
                if (expression.getTrackedValue() == null && expression.getMembers()
                        .getFirst().getClassReference() == null) {
                    expression.setTrackedValue(expression.getMembers().getFirst().getTrackedValue());
                    expression.setType(expression.getMembers().getFirst().getType());
                } else if (expression.getMembers().getFirst().getClassReference() != null &&
                        expression.getClassReference() == null) {
                    expression.setClassReference(expression.getMembers().getFirst().getClassReference());
                    if (expression.getMembers().getFirst().getSelectedAttribute() != null) {
                        String attribute = expression.getMembers().getFirst().getSelectedAttribute();
                        expression.setSelectedAttribute(attribute);
                        //Avoid exception in case subclass appears before superclass
                        if (expression.getMembers().getFirst().getClassReference()
                                .getAttributes().containsKey(attribute)) {
                            expression.setType(expression.getMembers().getFirst().getClassReference()
                                    .getAttributes().get(attribute).getType());
                        }
                    } else {
                        expression.setType(expression.getMembers().getFirst().getType());
                    }
                }
            }

            statements.push(expression);
        }
    }

    /**
     * @param operator (String)
     *                 <p>
     *                 Gives the @param operator to the current Expression. This auxiliary
     *                 function's purpose is to give the current Expression the operator related
     *                 to the operation it is being used: relational (<, <=, >, >=),
     *                 multiplicative (*, /, %), additive (+, -), equality (==, !=) to help in
     *                 tracking its value in TaintVisitor.
     * @function addExpressionOperator
     */
    public void addExpressionOperator(String operator) {
        if (!statements.isEmpty() && statements.peek() instanceof Expression) {
            Expression expression = (Expression) statements.pop();
            if (expression.getMembers().size() == 2) {
                Expression expr = new Expression();
                expr.getMembers().add(expression.getMembers().removeFirst());
                expr.getMembers().add(expression.getMembers().removeFirst());
                expr.setOperator(Util.toOperator(operator));
                expression.getMembers().add(expr);
            } else {
                expression.setOperator(Util.toOperator(operator));
            }

            statements.push(expression);
        }
    }

    /**
     * @param operator (String)
     *                 <p>
     *                 Gives the @param operator to the current Assignment. This auxiliary
     *                 function's purpose is to simplify the assignments that use the operators:
     *                 +=, -=, *=, /=, %=, giving it to the current Assignment. More info at
     * @function addAssigmentOperator
     * @function modifyAssignmentWithOperator.
     */
    public void addAssignmentOperator(String operator) {
        if (statements.peek() instanceof Assignment) {
            Assignment assignment = (Assignment) statements.pop();
            assignment.setOperator(operator);
            statements.push(assignment);
        }
    }

    /**
     * @function modifyAssignmentWithOperator
     * <p>
     * This function modifies a given assignment if it possesses one of the
     * following operators: +=, -=, *=, /=, %=. The assignment, for example
     * y += x, is then transformed in an equivalent, for example y = y + x.
     */
    public void modifyAssignmentWithOperator() {
        if (statements.peek() instanceof Assignment) {
            Assignment assignment = (Assignment) statements.pop();
            if (assignment.getOperator() != null) {
                if (assignment.getOperator().equals("=")) {
                    statements.push(assignment);
                } else {
                    Variable variable = (Variable) assignment.getLeft();
                    Expression expression;
                    if (statements.peek() instanceof Expression) {
                        expression = assignment.getRight();
                    } else {
                        expression = new Expression();
                        expression.getMembers().add(assignment.getRight());
                    }
                    expression.getMembers().addFirst(variable);

                    switch (assignment.getOperator()) {
                        case "+=" -> expression.setOperator(Operator.ADD);
                        case "-=" -> expression.setOperator(Operator.SUBTRACT);
                        case "*=" -> expression.setOperator(Operator.MULTIPLY);
                        case "/=" -> expression.setOperator(Operator.DIVIDE);
                        case "%=" -> expression.setOperator(Operator.MODULUS);
                        default -> {
                            statements.push(assignment);
                            return;
                        }
                    }

                    assignment.setRight(expression);
                    statements.push(assignment);
                }
            } else {
                statements.push(assignment);
            }
        }
    }

    /**
     * @param ctx      desc
     * @param operator desc
     * @param condType desc
     *                 <p>
     *                 This function is used to simplify & transform pre(post)-increments(decrements)
     *                 when they belong only to an expression (and GenericStatement). This means that they
     *                 are not used in an Assignment, which is covered in @function
     *                 assignmentIncrementDecrementExpression. x++/x--/++x/--x is transformed to
     *                 x = x +/- 1.
     *                 The way to know if this does not belong to an Assignment is by analyzing the
     *                 stack: if the last element is a GenericStatement then it is only the
     *                 expression (x++), if it is an Expression then we are in the Assignment
     *                 (y = x++) case.
     * @function normalIncrementDecrementExpression
     */
    public void normalIncrementDecrementExpression(ParserRuleContext ctx, String operator, String condType) {
        //This is the case where we have, e.g., x = ++id, so it does not belong in this function.
        if (statements.peek() instanceof Expression) {
            assignmentIncrementDecrementExpression(ctx, operator, condType);
        } else if (statements.peek() instanceof GenericStatement) {
            Expression expression = new Expression(ctx);
            Assignment assignment = new Assignment(ctx);
            Constant constant = new Constant(ctx, "1", "int");
            GenericStatement genStmt = (GenericStatement) statements.pop();
            Variable variable = (Variable) genStmt.getStatement();

            expression.getMembers().add(variable);
            expression.getMembers().add(constant);
            assignment.setLeft(variable);
            expression.setType("int");

            assignment.setRight(expression);
            genStmt.setStatement(assignment);

            switch (operator) {
                case "+" -> expression.setOperator(Util.toOperator("+"));
                case "-" -> expression.setOperator(Util.toOperator("-"));
                default -> {
                    System.out.println("Invalid operator");
                    return;
                }
            }

            statements.push(genStmt);
        }
    }

    /**
     * @param ctx      desc
     * @param operator desc
     * @param condType desc
     *                 <p>
     *                 This function is used to simplify & transform pre(post)-increments(decrements)
     *                 when they belong to an Assignment.
     *                 The @param condType allows the function to identify which type of
     *                 increment/decrement it is dealing with.
     *                 For example, if it has y = x++ then it transforms this to 2 Assignments:
     *                 y = x & x = x + 1. If it has y = ++x then it is transformed to: x = x + 1
     *                 & y = x;
     * @function assignmentIncrementDecrementExpression
     */
    public void assignmentIncrementDecrementExpression(ParserRuleContext ctx, String operator, String condType) {
        Expression expression = new Expression(ctx);
        Assignment assignment = new Assignment(ctx);
        Constant constant = new Constant(ctx, "1", "int");
        if (!statements.isEmpty() && statements.peek() instanceof Expression) {
            Expression assignExp = (Expression) statements.pop();
            Assignment assignmentStack = (Assignment) statements.pop();
            GenericStatement genStmt = (GenericStatement) statements.pop();
            Variable variable = (Variable) assignExp.getMembers().getFirst();

            expression.getMembers().add(variable);
            expression.getMembers().add(constant);

            switch (operator) {
                case "+" -> expression.setOperator(Util.toOperator("+"));
                case "-" -> expression.setOperator(Util.toOperator("-"));
                default -> {
                    //Should never enter here!
                    System.out.println("Invalid operator");
                    return;
                }
            }
            //x = ++id; -> id = id + 1; x = id;
            if (condType.equals("pre")) {
                assignment.setLeft(variable);
                assignment.setRight(expression);
                genStmt.setStatement(assignment);

                // x = id++; -> x = id; id = id + 1;
            } else if (condType.equals("post")) {
                assignment.setLeft(assignmentStack.getLeft());
                assignment.setRight(assignExp);
                genStmt.setStatement(assignment);

                assignmentStack.setLeft(variable);
                assignmentStack.setRight(expression);
            }

            statements.push(genStmt);
            statements.push(assignmentStack);
            statements.push(assignExp);
        }
    }

    /**
     * @function accessedAttribute
     * <p>
     * Represents the 3 cases where an attribute will be accessed here:
     * 1. On the left side of an assignment, and it can be known because the last
     * statement in the statements Stack will be the Assignment object.
     * 2. On the right side of an assignment, and it can be known because the right side
     * is always represented with an Expression so it is enough to check if the statement before
     * is an Assignment or not. May also be used when it is an argument in a function call.
     * 3. In a pre/post-increment/decrement expression, known by the use of GenericStatement in these
     * types of statements.
     */
    public void accessedAttribute() {
        List<String> members = null;
        if (statements.isEmpty()) {
            return;
        }
        //Attribute access is on the left side of assignment
        if (statements.peek() instanceof Assignment) {
            Assignment assignment = (Assignment) statements.pop();
            Variable left = (Variable) assignment.getLeft();
            boolean isInLeft = true;
            /*
             * JavaScript treats attribute accesses (and other expressions) different from Java, not using
             * Expression object in certain cases to contain other objects (variable, attribute access, etc).
             * Because of this, eg, var str = x.y will go here as the right side won't have an Expression object but a
             * Variable object instead...
             */
            if (left.getName().matches("[a-zA-Z0-9_]+\\.[a-zA-Z0-9_]+")) {
                members = Arrays.asList(left.getName().split("\\."));
            } else if (assignment.getRight() instanceof Variable right) {
                members = Arrays.asList(right.getName().split("\\."));
                isInLeft = false;
            }

            if (members != null) {
                Variable var = createNewVariableForAttributes(currentFunction.getVariables().get(members.get(0)));
                var.setSelectedAttribute(members.get(1));
                if (isInLeft) {
                    assignment.setLeft(var);
                } else {
                    assignment.setRight(var);
                }
            }
            statements.push(assignment);
            //Attribute access is on the right side of expression
        } else if (statements.peek() instanceof Expression) {
            Variable var = null, attribute;
            int newAttributeAddedIdx = -1;
            String attributeName;
            String fileNameExtension = Arrays.asList(this.file.getName().split("\\.")).get(1);
            Expression expression = (Expression) statements.pop();

            if (fileNameExtension.equals("js")) {
                /* 2 here relates to the members that exist in an expression when we have an attribute access,
                 * e.g., for someClass.someAttribute it would have Variable (someClass) and
                 * Variable (someAttribute). So if we have a complex expression (someClass.someAttribute +
                 * anotherClass.anotherAttribute), it would have 3 members (the already parsed someClass and the
                 * to-be-parsed anotherClass).
                 */
                newAttributeAddedIdx = expression.getMembers().size() - 2;
                attribute = (Variable) expression.getMembers().get(newAttributeAddedIdx + 1);
                attributeName = attribute.getName();
                //No need for Variable for attribute anymore
                expression.getMembers().remove(newAttributeAddedIdx + 1);
                var = createNewVariableForAttributes((Variable) expression.getMembers().get(newAttributeAddedIdx));
                var.setSelectedAttribute(attributeName);
            } else if (fileNameExtension.equals("java") || fileNameExtension.equals("py")) {
                /*
                 * For more complex expressions (using +, -, +=, etc), Python/Java adds the Expression object,
                 * however, the accessed attribute is done with one object only: a Variable with source.attribute name.
                 */
                newAttributeAddedIdx = expression.getMembers().size() - 1;
                Variable tempVar = (Variable) expression.getMembers().get(newAttributeAddedIdx);
                members = Arrays.asList(tempVar.getName().split("\\."));
                attributeName = members.get(1);
                if (currentFunction.getVariables().containsKey(members.get(0))) {
                    var = createNewVariableForAttributes(currentFunction.getVariables().get(members.getFirst()));
                } else {
                    var = new Variable(members.getFirst());
                }
                var.setSelectedAttribute(attributeName);
            }

            if (newAttributeAddedIdx == 0) {
                expression.getMembers().clear();
                expression.getMembers().add(var);
            } else {
                expression.getMembers().remove(newAttributeAddedIdx);
                expression.getMembers().add(newAttributeAddedIdx, var);
            }

            statements.push(expression);
        } else if (statements.peek() instanceof GenericStatement) {
            GenericStatement genStmt = (GenericStatement) statements.pop();
            Expression expression = (Expression) genStmt.getStatement();
            Variable attribute = (Variable) expression.getMembers().get(2);
            Variable var = createNewVariableForAttributes((Variable) expression.getMembers().get(0));
            var.setSelectedAttribute(attribute.getName());

            genStmt.setStatement(var);
            statements.push(genStmt);
        }
    }

    /**
     * @return Variable
     * <p>
     * Receives a variable and returns another reference to that variable with the same
     * information regarding name, type, if it's tainted or not, etc. Used mainly because
     * of class instances to know what attribute was used for that instance in a given statement,
     * without having that information be overwritten to all other references of that variable
     * @function createNewVariableForAttributes
     */
    public Variable createNewVariableForAttributes(Variable variable) {
        Variable var = new Variable(variable.getName());
        var.setClassReference(variable.getClassReference());
        var.setTrackedValue(variable.getTrackedValue());
        var.setType(variable.getType());
        var.setLine(variable.getLine());
        var.setTainted(variable.isTainted());
        var.setText(variable.getText());
        return var;
    }

    /**
     * @return boolean
     * <p>
     * This function is used, primarily for now, for attribute accesses in Generic Statements.
     * The issue being solved here was found regarding pre/post-increment/decrement expressions with
     * attribute accesses. With a Generic Statement, the information regarding attribute accesses is lost
     * and to be able to get that information, this function will instead insert an Expression in the Stack
     * (and in the Generic Statement) to store that information so it can be processed in another function.
     * <p>
     * It returns true/false based on the fact if GT has a Generic Statement in the Stack or not.
     * @function isGenericStatement
     */
    public boolean isGenericStatement() {
        if (!statements.isEmpty() && statements.peek() instanceof GenericStatement) {
            GenericStatement genStmt = (GenericStatement) statements.pop();
            Expression expression = new Expression();
            genStmt.setStatement(expression);

            statements.push(genStmt);
            statements.push(expression);
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param ctx This function was created because, unlike Java8Parser, other Parsers do not know what a
     *            GenericStatement is. To keep the logic made in @assignmentIncrementDecrementExpression intact
     *            (and avoid more if cases), a GenericStatement is created here with the necessary
     *            adjustments to make sure the code is reused.
     * @function createGenStatementForIncDecExpression
     */
    public void createGenStatementForIncDecExpression(ParserRuleContext ctx) {
        GenericStatement genStmt;
        Expression expression;
        addGenericStatement(ctx);
        genStmt = (GenericStatement) statements.pop();
        expression = (Expression) statements.pop();
        if (statements.peek() instanceof Assignment) {
            Assignment assignment = (Assignment) statements.pop();

            statements.push(genStmt);
            statements.push(assignment);
            statements.push(expression);

            int idx = this.codeBlocks.peek().getStatements().size();
            genStmt = (GenericStatement) this.codeBlocks.peek().getStatements().remove(idx - 1);
            assignment = (Assignment) this.codeBlocks.peek().getStatements().remove(idx - 2);
            this.codeBlocks.peek().getStatements().add(genStmt);
            this.codeBlocks.peek().getStatements().add(assignment);
        } else {
            statements.push(expression);
            statements.push(genStmt);
        }
    }

    /**
     * @param switchBack This function is used to keep the logic made in @normalIncrementDecrementExpression intact
     *                   (and avoid more if cases), by switching the GenericStatement with the Expression
     *                   created before it.
     * @function switchGenStatementForIncDecExpression
     */
    public void switchGenStatementForIncDecExpression(boolean switchBack) {
        Expression expression;
        GenericStatement genStmt;
        if (switchBack) {
            genStmt = (GenericStatement) statements.pop();
            expression = (Expression) statements.pop();

            statements.push(genStmt);
            statements.push(expression);

        } else {
            expression = (Expression) statements.pop();
            genStmt = (GenericStatement) statements.pop();
            Variable variable = (Variable) expression.getMembers().getFirst();
            genStmt.setStatement(variable);

            statements.push(expression);
            statements.push(genStmt);
        }
    }

    /**
     * @param statement desc
     * @return boolean
     * Adds a given statement to the codeblock of the current lambda function.
     * Returns true if it is dealing with a lambda function, and false otherwise.
     * @function addStatementsToLambdaFunc
     */
    public boolean addStatementsToLambdaFunc(Statement statement) {
        boolean isLambdaFuncExpr = false;
        GenericStatement genStmt = null;
        /*
         * Found this "bug" in lambda functions (works as intended in normal functions)
         * where if we have, e.g, str = functionCall(something), the Parser will generate
         * a GenericStatement and the Assignment object that follows will be lost. However,
         * what we want to truly capture is the Assignment, so the GenericStatement is
         * redundant in this case.
         */
        if (statements.peek() instanceof GenericStatement) {
            genStmt = (GenericStatement) statements.pop();
        }

        if (statements.peek() instanceof Expression) {
            //This expression should contain the lambda function
            Expression expression = (Expression) statements.pop();
            if (expression.getLambdaFunc() != null) {
                expression.getLambdaFunc().getCodeBlock().getStatements().add(statement);
                isLambdaFuncExpr = true;
            }
            statements.push(expression);
        }

        if (genStmt != null) {
            statements.push(genStmt);
        }

        return isLambdaFuncExpr;
    }

    /**
     * @param ctx
     * @param attributeName In JavaScripParser's case, an Attribute is not immediately recognized as it is only analyzed when
     *                      in the constructor. So, for that, once we verify that we are indeed in the constructor we create
     *                      the attribute so that it can be added to its class.
     * @function addAttributeToClass
     */
    public void addAttributeToClass(ParserRuleContext ctx, String attributeName) {
        if (!this.classes.isEmpty() && !this.classes.peek().getAttributes().containsKey(attributeName)) {
            addAttribute(ctx, attributeName);
        }
    }

    //Will only be used when in a constructor (JavaScript, Python)
    public void addClassAttributeToAssignment(String attributeName) {
        if (!statements.isEmpty() && statements.peek() instanceof Assignment) {
            Assignment assignment = (Assignment) statements.pop();
            assignment.setLeft(this.classes.peek().getAttributes().get(attributeName));
            statements.push(assignment);
        } else if (!statements.isEmpty() && statements.peek() instanceof Expression) {
            Expression expression = (Expression) statements.pop();
            addClassAttributeToAssignment(attributeName);
            statements.push(expression);
        }
    }

    //Used in Assignments from PythonParser
    public void checkIfLeftSideIsExpr() {
        if (!statements.isEmpty() && statements.peek() instanceof Assignment) {
            Assignment assignment = (Assignment) statements.pop();
            if (assignment.getLeft() != null && !assignment.getLeft().getMembers().isEmpty() &&
                    assignment.getLeft().getMembers().getFirst() instanceof Variable leftVar) {
                assignment.setLeft(leftVar);
            }
            statements.push(assignment);
        }
    }

    /* PythonParser does not have a rule for class instance creation (no "new" expression)
     * so that type of expression will lead to a function call rule. In order to know if a class
     * instance is being created, the name of the "function" is compared with the name of classes seen
     * so far to see if it is a function or a class instance.
     */
    public boolean nameBelongsToClass(String name) {
        return this.analyzedClasses.containsKey(name);
    }

    public void collectionInitFound() {
        //Curently in assignment context
        if (!statements.isEmpty() && statements.size() >= 2) {
            Expression expression = (Expression) statements.pop();
            Assignment assignment = (Assignment) statements.pop();
            assignment.getLeft().setCollection(true);
            statements.push(assignment);
            statements.push(expression);
        }
    }

    /**
     * @param name Receives the name of the attribute accessed by the "this" object and, depending on the scenario where
     *             it occurred (Assignment, Expression, GenericStatement), will locate the "this" object and provide it
     *             with the accessed attribute (to be used later in TaintVisitor).
     * @function addSelectedAttributeToThis
     */
    public void addSelectedAttributeToThis(String name) {
        if (statements.peek() instanceof Assignment) {
            Assignment assignment = (Assignment) statements.pop();
            Variable var = createNewVariableForAttributes((Variable) assignment.getLeft());
            var.setSelectedAttribute(name);
            assignment.setLeft(var);
            statements.push(assignment);
        } else if (statements.peek() instanceof Expression) {
            /* For now, this function will be called when JavaFileListener is in enterPrimary due to "this"
             * variable and its attribute access. */
            Expression expression = (Expression) statements.pop();
            Variable tempVar = (Variable) expression.getMembers().getLast();
            Variable var = createNewVariableForAttributes(tempVar);
            var.setSelectedAttribute(name);
            expression.getMembers().removeLast();
            expression.getMembers().add(var);
            statements.push(expression);
        } else if (statements.peek() instanceof GenericStatement) {
            /* When there is a statement: (++/-)this.someAttribute(++/--), the GenericStatement
             * will go straight to the variable "this.someAttribute" found in enterPrimary */
            GenericStatement genericStatement = (GenericStatement) statements.pop();
            Variable var = createNewVariableForAttributes((Variable) genericStatement.getStatement());
            var.setSelectedAttribute(name);
            genericStatement.setStatement(var);
            statements.push(genericStatement);
        }
    }

    /**
     * @param ctx
     * @param functionName
     * @param isConstructorSuper Receives the context (so that, for example, line number is known), name of the funtion
     *                           and if it is a super() or a "super.". The objective of this function is to transform super calls
     *                           into their respective function calls for analysis, distinguishing from super() (used in constructors)
     *                           and "super." (used to call super of a given method).
     * @function addSuperMethodCall
     */
    public void addSuperMethodCall(ParserRuleContext ctx, String functionName, boolean isConstructorSuper) {
        FunctionCall superFunction;
        // addFunctionCall(ctx, functionName);
        // superFunction = (FunctionCall) statements.pop();
        superFunction = addFunctionCall(ctx, functionName);
        if (isConstructorSuper) {
            superFunction.setConstructor(true);
        } else {
            superFunction.setSuper(true);
        }
        statements.push(superFunction);
    }

    /**
     * @param constructorName Auxiliary function. Receives the name of a given constructor so that its function is moved
     *                        from the analysed class's method list into its constructors list.
     * @function addConstructorToClass
     */
    public void addConstructorToClass(String constructorName) {
        Function constructorFunc = classes.peek().getMethods().remove(constructorName);
        classes.peek().getConstructors().add(constructorFunc);
    }

    /**
     * @param ctx
     * @param isSuperStatement Auxiliary function. Receives the context and a boolean to determine if it is analysing a
     *                         super() or this() (used in constructors), so that the appropriate name is provided to the
     *                         addSuperMethodCall function.
     * @function addSuperOrThisInConstructor
     */
    public void addSuperOrThisInConstructor(ParserRuleContext ctx, boolean isSuperStatement) {
        String functionName;
        if (isSuperStatement) {
            functionName = classes.peek().getSuperClass();
        } else {
            functionName = classes.peek().getName();
        }
        addSuperMethodCall(ctx, functionName, true);
    }

    /**
     * @function rearrangeMethodClassWithClassSource
     * Auxiliary function used in Java context (for now) to tackle the problem of
     * having a class being the source of a method call, eg (new someClass()).someMethodCall();
     * This function makes the following assumptions based on observations regarding this case:
     * first, the method call will have as source the function it wants to call and second,
     * that same function will have as first member the class creation expression
     * we want to have as source!
     * <p>
     * (new someClass()).someMethodCall() can also appear in the right side of an assignment and
     * GT will not consider that a method call and will separate them in different statements (also
     * couldn't find a rule in Parser that allowed me to know reliably that it is a methodCall).
     * <p>
     * If you want to also extend this to other languages (might be needed), care
     * for these assumptions!
     */
    public void rearrangeMethodClassWithClassSource() {
        if (!statements.isEmpty()) {
            if (statements.peek() instanceof FunctionCall) {
                FunctionCall functionCall = (FunctionCall) statements.pop();
                MethodCallExpression methodCall = (MethodCallExpression) statements.pop();

                Expression classExpression = functionCall.getMembers().removeFirst();
                methodCall.getMembers().add(functionCall);
                methodCall.setSource(classExpression);

                statements.push(methodCall);
                statements.push(functionCall);
            } else if (statements.peek() instanceof MethodCallExpression && statements.size() >= 2) {
                /* This part represents the appearance of (new someClass()).someMethodCall()
                 * in the right side of an assignment!
                 */
                MethodCallExpression methodCall = (MethodCallExpression) statements.pop();
                Expression expression = (Expression) statements.pop();
                if (!statements.isEmpty() && statements.peek() instanceof Assignment) {
                    Assignment assignment = (Assignment) statements.pop();
                    methodCall.setSource(assignment.getRight().getMembers().removeFirst());
                    statements.push(assignment);
                }

                statements.push(expression);
                statements.push(methodCall);
            }
        }
    }

    /**
     * @param attributeName
     * @param type
     * @param value         Auxiliary function used in Java context (for now) to initialize a class's
     *                      fields/attributes in case primitive data types (or Lists/Maps/Sets/Stacks) are
     *                      used. Doesn't support other classes due to the complexity involved!
     * @function addAttributeTrackedValue
     */
    public void addAttributeTrackedValue(String attributeName, String type, String value) {
        switch (type) {
            case "int", "double", "float", "char", "boolean" ->
                    this.classes.peek().getAttributes().get(attributeName).setTrackedValue(value);
            case "string" -> {
                //Remove quotes from ctx text due to the appearance of double quotes later on
                String rmvQuotes = value.substring(1, value.length() - 1).replace("\"\"", "\"");
                this.classes.peek().getAttributes().get(attributeName).setTrackedValue(rmvQuotes);
            }
            case "List", "ArrayList", "LinkedList", "Map", "HashMap", "Stack", "HashSet", "Set" ->
                    this.classes.peek().getAttributes().get(attributeName).setCollection(true);
        }
    }

    /**
     * @param isElseIf Auxiliary function used in Java context (for now) to give a case
     *                 (from a switch statement) the following expression: switchExpression == caseExpression.
     * @function finishExpressionForCase
     */
    public void finishExpressionForCase(boolean isElseIf) {
        IfStatement ifStatement = (IfStatement) statements.pop();
        Expression switchExpression = (Expression) statements.pop();

        if (!isElseIf) {
            ifStatement.getExpression().getMembers().add(switchExpression.getMembers().getFirst());
            ifStatement.getExpression().setOperator(Util.toOperator("=="));
        } else {
            int lastElseIf = ifStatement.getElseIfs().size() - 1;
            ifStatement.getElseIfs().get(lastElseIf).getExpression().getMembers().add(switchExpression.getMembers().getFirst());
            ifStatement.getElseIfs().get(lastElseIf).getExpression().setOperator(Util.toOperator("=="));
        }

        statements.push(switchExpression);
        statements.push(ifStatement);
    }

    /**
     * @function buildConditionalExpressionasIfStatement
     * <p>
     * Function used in Java context (for now) that converts a conditional expression:
     * (variable = someComparison ? ifTrueExpression : ifFalseExpression;), into an IfStatement.
     * For Java context, the information will all be on the IfStatement condition's expression.
     * Assumptions are made here from testing in Java, might need some tweaks for other languages.
     */
    public void buildConditionalExpressionAsIfStatement() {
        if (!statements.isEmpty() && statements.peek() instanceof Expression) {
            Expression expression = (Expression) statements.pop();
            IfStatement ifStatement = (IfStatement) statements.pop();
            if (statements.size() >= 3) {
                Expression unneededExpression = (Expression) statements.pop();
                if (statements.peek() instanceof Assignment) {
                    Assignment assignment = (Assignment) statements.pop();

                    Assignment ifTrueAssignment = new Assignment();
                    ifTrueAssignment.setOperator("=");
                    ifTrueAssignment.setLeft(assignment.getLeft());
                    ifTrueAssignment.setRight(expression.getMembers().remove(1));
                    ifStatement.getCodeBlock().getStatements().add(ifTrueAssignment);

                    Assignment ifFalseAssignment = new Assignment();
                    ifFalseAssignment.setOperator("=");
                    ifFalseAssignment.setLeft(assignment.getLeft());
                    ifFalseAssignment.setRight(expression.getMembers().remove(1));
                    ifStatement.getElseBlock().getStatements().add(ifFalseAssignment);

                    statements.push(assignment);
                }
                statements.push(unneededExpression);
            }

            statements.push(ifStatement);
            statements.push(expression);
        }
    }

    public void createEnhancedForExpression() {
        if (!statements.isEmpty() && statements.peek() instanceof Expression) {
            Expression expression = (Expression) statements.pop();
            ConditionalStatement conditionalStatement = (ConditionalStatement) statements.pop();

            Assignment assignment = new Assignment();
            assignment.setLeft(expression.getMembers().removeFirst());
            assignment.setRight(expression);

            //conditionalStatement.setExpression(assignment);

            statements.push(conditionalStatement);
        }
    }

    public void addClassCreation(ParserRuleContext ctx, String identifier) {
        if (identifier.equals("ArrayList") || identifier.equals("HashSet") || identifier.equals("LinkedList") ||
            identifier.equals("HashMap") || identifier.equals("Stack")) {
            inCollection = true;
        } else {
            addFunctionCall(ctx, identifier);
            trackClassReference(identifier);
        }
    }

    public void finishClassCreation() {
        if (inCollection) {
            collectionInitFound();
            inCollection = false;
        } else {
            exitStatementOrExpression();
        }
    }
}
