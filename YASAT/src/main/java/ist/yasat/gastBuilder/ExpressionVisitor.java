package ist.yasat.gastBuilder;

import ist.yasat.model.Class;
import ist.yasat.model.*;

public class ExpressionVisitor implements AstBuilderVisitorInterface {
    private final Expression expr;

    public ExpressionVisitor(Expression expression) {
        expr = expression;
    }

    @Override
    public void visit(FunctionCall functionCall) {
        functionCall.getMembers().add(expr);
    }

    @Override
    public void visit(Expression expression) {
        expression.getMembers().add(expr);
    }

    @Override
    public void visit(Assignment assignment) {
        if (assignment.getLeft() == null)
            assignment.setLeft(expr);
        else
            assignment.setRight(expr);

    }

    @Override
    public void visit(ReturnStatement stmt) {
        stmt.setExpression(expr);
    }

    @Override
    public void visit(Variable var) {
    }

    @Override
    public void visit(Parameter param) {

    }

    @Override
    public void visit(Constant constant) {
    }

    @Override
    public void visit(Function function) {
    }


    @Override
    public void visit(CodeBlock codeBlock) {
    }

    @Override
    public void visit(File file) {
    }

    @Override
    public void visit(Class aClass) {
    }

    @Override
    public void visit(ConditionalStatement conditionalStatement) {
        conditionalStatement.setExpression(expr); //TODO review this because it might not work for DoWhile
    }

    @Override
    public void visit(GenericStatement statement) {
        statement.setStatement(expr);
    }

    @Override
    public void visit(IfStatement ifStatement) {
        ifStatement.setExpression(expr);
    }

    @Override
    public void visit(Attribute attribute) {
        attribute.setValue(expr);
    }

    @Override
    public void visit(NewExpression newExpression) {
        newExpression.getMembers().add(expr);
    }

    @Override
    public void visit(AttributeAccess attributeAccess) {

    }

    @Override
    public void visit(MethodCallExpression methodCall) {
        if (methodCall.getSource() == null)
            methodCall.setSource(expr);
        else
            methodCall.getMembers().add(expr);
    }

    @Override
    public void visit(ThrowException throwException) {
        throwException.setExpression(expr);
    }

    @Override
    public void visit(TryCatch tryCatch) {

    }

}
