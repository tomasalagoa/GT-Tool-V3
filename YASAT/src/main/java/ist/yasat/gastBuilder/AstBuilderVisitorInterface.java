package ist.yasat.gastBuilder;

import ist.yasat.model.Class;
import ist.yasat.model.*;

public interface AstBuilderVisitorInterface {

    void visit(FunctionCall functionCall);

    void visit(Expression expression);

    void visit(Assignment assignment);

    void visit(ReturnStatement stmt);

    void visit(Variable var);

    void visit(Parameter param);

    void visit(Constant constant);

    void visit(Function function);

    void visit(CodeBlock codeBlock);

    void visit(File file);

    void visit(Class aClass);

    void visit(ConditionalStatement conditionalStatement);

    void visit(GenericStatement statement);

    void visit(IfStatement ifStatement);

    void visit(Attribute attribute);

    void visit(NewExpression newExpression);

    void visit(AttributeAccess attributeAccess);

    void visit(MethodCallExpression methodCall);

    void visit(ThrowException throwException);

    void visit(TryCatch tryCatch);
}
