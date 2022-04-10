package ist.gt.gastBuilder;

import ist.gt.model.Class;
import ist.gt.model.*;
import ist.gt.util.Util;
import lombok.Data;

import org.antlr.runtime.tree.ParseTree;
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

    public Constant addConstant(ParserRuleContext ctx, String value) {
        var constant = new Constant(ctx, value);
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

    
    /* NEW FUNCTIONS FOR VALUE TRACKING
    */
    public void evaluateRelationalExpression(ParserRuleContext ctx, String operator){
        //Think what to do about both sides of the expression
        Expression expression;
        String leftValue, rightValue;
        Boolean result;
        switch(operator){
            case ">":
                //Do something
                System.out.println("GT Expression");
                expression = (Expression) statements.pop();
                //System.out.println(expression.getMembers().get(0).toString());
                //System.out.println(expression.getMembers().get(1).toString());
                leftValue = expression.getMembers().get(0).getTrackedValue();
                rightValue = expression.getMembers().get(1).getTrackedValue();
                result = Double.valueOf(leftValue) > Double.valueOf(rightValue);
                expression.setTrackedValue(result.toString());
                statements.push(expression);
                return;
            case ">=":
                //Do something
                System.out.println("GE Expression");
                expression = (Expression) statements.pop();
                //System.out.println(expression.getMembers().get(0).toString());
                //System.out.println(expression.getMembers().get(1).toString());
                leftValue = expression.getMembers().get(0).getTrackedValue();
                rightValue = expression.getMembers().get(1).getTrackedValue();
                result = Double.valueOf(leftValue) >= Double.valueOf(rightValue);
                expression.setTrackedValue(result.toString());
                statements.push(expression);
                return;
            case "<":
                //Do something
                System.out.println("LT Expression");
                expression = (Expression) statements.pop();
                //System.out.println(expression.getMembers().get(0).toString());
                //System.out.println(expression.getMembers().get(1).toString());
                leftValue = expression.getMembers().get(0).getTrackedValue();
                rightValue = expression.getMembers().get(1).getTrackedValue();
                result = Double.valueOf(leftValue) < Double.valueOf(rightValue);
                expression.setTrackedValue(result.toString());
                statements.push(expression);
                return;
            case "<=":
                //Do something
                System.out.println("LE Expression");
                expression = (Expression) statements.pop();
                //System.out.println(expression.getMembers().get(0).toString());
                //System.out.println(expression.getMembers().get(1).toString());
                leftValue = expression.getMembers().get(0).getTrackedValue();
                rightValue = expression.getMembers().get(1).getTrackedValue();
                result = Double.valueOf(leftValue) <= Double.valueOf(rightValue);
                expression.setTrackedValue(result.toString());
                statements.push(expression);
                return;
            //TODO Should I care about this one? Instanceof seems a tough nut to crack
            case "instanceof":
                //Do something
                System.out.println("INSTANCEOF Expression");
                expression = (Expression) statements.pop();
                //System.out.println(expression.getMembers().get(0).toString());
                //System.out.println(expression.getMembers().get(1).toString());
                leftValue = expression.getMembers().get(0).getTrackedValue();
                rightValue = expression.getMembers().get(1).getTrackedValue();
                //result = Double.valueOf(leftValue) instanceof Double.valueOf(rightValue);
                //expression.setTrackedValue(result.toString());
                statements.push(expression);
                return;
            default:
                System.out.println("Unknown operator: " + operator);
                return;
        }
    
    }


    public void trackLeftVariableValue(){
        //Updating left variable value in assignment and in current function
        Assignment assignment = (Assignment) statements.pop();
        Variable tmpVar = (Variable) assignment.getLeft();
        Variable var = currentFunction.getVariables().get(tmpVar.getName());
        var.setTrackedValue(assignment.getRight().getTrackedValue());
        currentFunction.getVariables().replace(var.getName(), var);
        assignment.setLeft(var);
        statements.push(assignment);
    }


    public void trackExpressionValue(){
        Expression expression = (Expression) statements.pop();
        //Most likely this expression only has one element
        if(expression.getTrackedValue() == null && expression.getMembers().size() > 0){
            expression.setTrackedValue(expression.getMembers().get(0).getTrackedValue());
            //System.out.println(expression.getTrackedValue());
        }
        statements.push(expression);
    }
}
