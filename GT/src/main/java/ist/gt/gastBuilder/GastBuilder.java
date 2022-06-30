package ist.gt.gastBuilder;

import ist.gt.model.Class;
import ist.gt.model.*;
import ist.gt.util.Util;
import lombok.Data;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.Stack;

@Data
public class GastBuilder {

    private final Stack<Statement> statements = new Stack<>();
    private Function currentFunction;
    private Stack<CodeBlock> codeBlocks = new Stack<>();
    private Stack<IfStatement> ifStatements = new Stack<>();
    private final File file;
    private final Stack<Class> classes = new Stack<>();
    private final Stack<TryCatch> tryCatches = new Stack<>();

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
        popIfNotEmpty(codeBlocks);
        CodeBlock block = new CodeBlock();
        tryCatches.peek().getCatchBlock().add(block);
        codeBlocks.push(block);
    }

    public void exitCatchBlock() {
        popIfNotEmpty(codeBlocks);
    }

    public void exitTryCatchBlock() {
        tryCatches.pop();
    }


    public FunctionCall addFunctionCall(ParserRuleContext ctx, String name) {
        var functionCall = new FunctionCall(ctx, name);
        processExpression(functionCall);
        statements.push(functionCall);
        return functionCall;
    }


    public void addExpression(ParserRuleContext ctx) {
        Expression expression = new Expression(ctx);
        processExpression(expression);
        statements.push(expression);
    }


    public Assignment addAssignment(ParserRuleContext ctx) {
        Assignment assignment = new Assignment(ctx);
        codeBlocks.peek().getStatements().add(assignment);
        statements.push(assignment);
        return assignment;
    }


    public ReturnStatement addReturnStatement(ParserRuleContext ctx) {
        ReturnStatement stmt = new ReturnStatement(ctx);
        codeBlocks.peek().getStatements().add(stmt);
        statements.push(stmt);
        return stmt;
    }


    public Variable addVariable(ParserRuleContext ctx, String name) {
        Variable var = new Variable(ctx, name);
        //Update var's tracked value info in case the variable was
        //already analysed
        if(currentFunction.getVariables().containsKey(var.getName())){
            var = currentFunction.getVariables().get(var.getName());
        }
        //In case a parameter's value is overwriten (with an assignment), we will
        //not know its type unless we retrieve it 
        else if(!currentFunction.getVariables().containsKey(var.getName()) &&
        currentFunction.getParameters().containsKey(var.getName())){
            var = currentFunction.getParameters().get(var.getName());
        }
        currentFunction.getVariables().putIfAbsent(var.getName(), var);
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
        statements.clear();
        currentFunction.getParameters().put(param.getName(), param);
        return param;
    }

    public Variable addParameter(ParserRuleContext ctx, String name, String type) {
        Parameter parameter = addParameter(ctx, name);
        parameter.setType(type);
        return parameter;
    }

    public Constant addConstant(ParserRuleContext ctx, String value, String type) {
        var constant = new Constant(ctx, value, type);
        processExpression(constant);
        return constant;
    }


    public Function addFunction(ParserRuleContext ctx, String name) {
        var function = new Function(name, ctx);
        currentFunction = function;
        statements.clear();
        codeBlocks.push(function.getCodeBlock());
        if (classes.empty())
            file.getFunctions().put(function.getName(), function);
        else
            classes.peek().getMethods().put(function.getName(), function);
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
            codeBlocks.peek().getStatements().add(ifStatement);
        }
        setConditionalStmt(ifStatement);
        return ifStatement;
    }


    public void addConditionalStatement(ParserRuleContext ctx) {
        var conditionalStatement = new ConditionalStatement(ctx);
        codeBlocks.peek().getStatements().add(conditionalStatement);
        setConditionalStmt(conditionalStatement);
    }


    public GenericStatement addGenericStatement(ParserRuleContext ctx) {
        var statement = new GenericStatement(ctx);
        codeBlocks.peek().getStatements().add(statement);
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
        classes.peek().getAttributes().put(attribute.getName(), attribute);
        processExpression(attribute);
        statements.push(attribute);
        return attribute;
    }

    public Attribute addAttribute(ParserRuleContext ctx, String name, String type) {
        var attribute = addAttribute(ctx, name);
        attribute.setType(type);
        return attribute;
    }

    /*==================================================================* 
     *      New functions for value tracking (Java only for now)        *
     *==================================================================*/

    /**
     * @function trackLeftVariableValue
     * 
     * Passes the value in the right side of an assignment to the left side,
     * if the right side exists (i.e could just be an empty variable declaration)
     * or if it has a type meaning its value could be tracked earlier (will be
     * tracked later if not).
     */
    public void trackLeftVariableValue(){
        //Updating left variable value in assignment and in current function
        Assignment assignment = (Assignment) statements.pop();

        if(assignment.getRight() != null && assignment.getRight().getType() != null
            && assignment.getRight().getTrackedValue() != null){
            Variable tmpVar = (Variable) assignment.getLeft();
            Variable var = currentFunction.getVariables().get(tmpVar.getName());
            var.setTrackedValue(assignment.getRight().getTrackedValue());
            var.setType(assignment.getRight().getType());
            currentFunction.getVariables().replace(var.getName(), var);
            assignment.setLeft(var);
        }

        statements.push(assignment);
    }

    /**
     * @function trackExpressionValue
     * 
     * Updates the value of current Expression. Can only be made if the current
     * Expression does not possess a tracked value yet and if it only has one 
     * element (Variable, Parameter, etc), making it able to immediately get its
     * value in this stage.
    */
    public void trackExpressionValue(){
        Expression expression = (Expression) statements.pop();
        //Most likely this expression only has one element
        if(expression.getTrackedValue() == null && expression.getMembers().size() == 1){
            expression.setTrackedValue(expression.getMembers().get(0).getTrackedValue());
            expression.setType(expression.getMembers().get(0).getType());
        }

        statements.push(expression);
    }

    /**
     * @function addExpressionOperator
     * @param operator (String)
     * 
     * Gives the @param operator to the current Expression. This auxiliary 
     * function's purpose is to give the current Expression the operator related
     * to the operation it is being used: relational (<, <=, >, >=), 
     * multiplicative (*, /, %), additive (+, -), equality (==, !=) to help in
     * tracking its value in TaintVisitor.
     */ 
    public void addExpressionOperator(String operator){
        Expression expression = (Expression) statements.pop();
        expression.setOperator(operator);
        statements.push(expression);
    }

    /**
     * @function addAssigmentOperator
     * @param operator (String)
     * 
     * Gives the @param operator to the current Assignment. This auxiliary 
     * function's purpose is to simplify the assignments that use the operators:
     * +=, -=, *=, /=, %=, giving it to the current Assignment. More info at
     * @function modifyAssignmentWithOperator.
     */
    public void addAssignmentOperator(String operator){
        Assignment assignment = (Assignment) statements.pop();
        assignment.setOperator(operator);
        statements.push(assignment);
    }

    /** 
     * @function modifyAssignmentWithOperator
     * 
     * This function modifies a given assignment if it possesses one of the
     * following operators: +=, -=, *=, /=, %=. The assignment, for example
     * y += x, is then transformed in an equivalent, for example y = y + x.
    */
    public void modifyAssignmentWithOperator(){
        Assignment assignment = (Assignment) statements.pop();
        if(assignment.getOperator() != null){
            if(assignment.getOperator().equals("=")){
                statements.push(assignment);
                return;
            } else{
                Variable variable = (Variable) assignment.getLeft();
                Expression expression = assignment.getRight();
                expression.getMembers().add(0, variable);

                switch(assignment.getOperator()){
                    case "+=":
                        expression.setOperator("+");
                        break;
                    case "-=":
                        expression.setOperator("-");
                        break;
                    case "*=":
                        expression.setOperator("*");
                        break;
                    case "/=":
                        expression.setOperator("/");
                        break;
                    case "%=":
                        expression.setOperator("%");
                        break;
                    default:
                        statements.push(assignment);
                        return;
                }

                assignment.setRight(expression);
                statements.push(assignment);
            }
        } else {
            statements.push(assignment);
        }
    }

    /**
     * @function normalIncrementDecrementExpression
     * @params ctx (ParserRuleContext), operator (String), condType (String)
     * 
     * This function is used to simplify & transform pre(post)-increments(decrements)
     * when they belong only to an expression (and GenericStatement). This means that they
     * are not used in an Assignment, which is covered in @function 
     * assignmentIncrementDecrementExpression. x++/x--/++x/--x is transformed to
     * x = x +/- 1.
     * The way to know if this does not belong to an Assignment is by analyzing the 
     * stack: if the last element is a GenericStatement then it is only the 
     * expression (x++), if it is an Expression then we are in the Assignment 
     * (y = x++) case.
     */
    public void normalIncrementDecrementExpression(ParserRuleContext ctx, String operator, String condType){
        //This is the case where we have, e.g., x = ++id, so it does not belong in this function.
        if(statements.peek() instanceof Expression){
            assignmentIncrementDecrementExpression(ctx, operator, condType);
            return;
        }
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

        switch(operator){
            case "+":
                expression.setOperator("+");
                break;
            case "-":
                expression.setOperator("-");
                break;
            default:
                System.out.println("Invalid operator");
                return;
        }

        statements.push(genStmt);
    }

    /**
     * @function assignmentIncrementDecrementExpression
     * @params ctx (ParserRuleContext), operator (String), condType (String)
     * 
     * This function is used to simplify & transform pre(post)-increments(decrements)
     * when they belong to an Assignment.
     * The @param condType allows the function to identify which type of 
     * increment/decrement it is dealing with.
     * For example, if it has y = x++ then it transforms this to 2 Assignments: 
     * y = x & x = x + 1. If it has y = ++x then it is transformed to: x = x + 1
     * & y = x;
     */
    public void assignmentIncrementDecrementExpression(ParserRuleContext ctx, String operator, String condType){ 
        Expression expression = new Expression(ctx);
        Assignment assignment = new Assignment(ctx);
        Constant constant = new Constant(ctx, "1", "int");
        Expression assignExp = (Expression) statements.pop();
        Assignment assignmentStack = (Assignment) statements.pop();
        GenericStatement genStmt = (GenericStatement) statements.pop();
        Variable variable = (Variable) assignExp.getMembers().get(0);
        
        expression.getMembers().add(variable);
        expression.getMembers().add(constant);
        
        switch(operator){
            case "+":
                expression.setOperator("+");
                break;
            case "-":
                expression.setOperator("-");
                break;
            default:
                //Should never enter here!
                System.out.println("Invalid operator");
                return;
    }
        //x = ++id; -> id = id + 1; x = id;
        if(condType.equals("pre")){
            assignment.setLeft(variable);
            assignment.setRight(expression);
            genStmt.setStatement(assignment);
        
        // x = id++; -> x = id; id = id + 1;
        } else if(condType.equals("post")){
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
