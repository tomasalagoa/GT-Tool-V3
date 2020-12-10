package ist.yasat.gastBuilder;

import ist.yasat.model.Class;
import ist.yasat.model.*;
import ist.yasat.util.Util;
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


    public void addImportedFile(String fileName) {

        file.getImportedFiles().add(Util.removeQuotes(fileName));
    }

    private void processExpression(Expression expression) {
        if (!statements.empty())
            statements.peek().accept(new ExpressionVisitor(expression));
    }

    public void exitFunctionOrMethodDeclaration() {
        currentFunction = file.getRootFunc();
        codeBlocks.pop();
    }

    public void exitConditionalStatement() {
        codeBlocks.pop();
        statements.pop();
    }

    public void enterElseStatement(ParserRuleContext ctx) {
        ifStatements.peek().getElseBlock().setLine(ctx.start.getLine());
        codeBlocks.push(ifStatements.peek().getElseBlock());
    }

    public void exitElseIfOrElseStatement() {
        codeBlocks.pop();
    }

    public void exitIfStatement() {
        ifStatements.pop();
        exitConditionalStatement();
    }

    public void exitStatementOrExpression() {
        statements.pop();
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
        codeBlocks.pop();
        CodeBlock block = new CodeBlock();
        tryCatches.peek().getCatchBlock().add(block);
        codeBlocks.push(block);
    }

    public void exitCatchBlock() {
        codeBlocks.pop();
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
}
