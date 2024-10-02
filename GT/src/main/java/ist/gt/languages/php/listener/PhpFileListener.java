package ist.gt.languages.php.listener;

import ist.gt.gastBuilder.GastBuilder;
import ist.gt.languages.php.parser.PhpParser;
import ist.gt.languages.php.parser.PhpParserBaseListener;
import ist.gt.util.Util;
import lombok.Data;


@Data
public class PhpFileListener extends PhpParserBaseListener {

    private final GastBuilder gastBuilder;

    public PhpFileListener(String filename) {
        gastBuilder = new GastBuilder(filename);
    }

    @Override
    public void enterInclude(PhpParser.IncludeContext ctx) {
        gastBuilder.addImportedFile(ctx.expression().getText());
    }

    @Override
    public void enterConstant(PhpParser.ConstantContext ctx) {
        gastBuilder.addConstant(ctx, ctx.getText(), "string");
    }

    @Override
    public void enterAssignment(PhpParser.AssignmentContext ctx) {
        gastBuilder.addAssignment(ctx);
    }

    @Override
    public void exitAssignment(PhpParser.AssignmentContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterStringConstant(PhpParser.StringConstantContext ctx) {
        gastBuilder.addConstant(ctx, ctx.getText(), "string");
    }

    @Override
    public void enterString(PhpParser.StringContext ctx) {
        gastBuilder.addConstant(ctx, ctx.getText(), "string");
    }

    @Override
    public void enterFunctionDeclaration(PhpParser.FunctionDeclarationContext ctx) {
        gastBuilder.addFunction(ctx, ctx.identifier().getText());
    }

    @Override
    public void exitFunctionDeclaration(PhpParser.FunctionDeclarationContext ctx) {
        gastBuilder.exitFunctionOrMethodDeclaration();
    }

    @Override
    public void enterFunctionCall(PhpParser.FunctionCallContext ctx) {
        var name = Util.getPropSafe(() -> ctx.functionCallName().classConstant().identifier().getText());
        if (name == null)
            name = Util.getPropSafe(() -> ctx.functionCallName().qualifiedNamespaceName().namespaceNameList().identifier(0).getText());
        gastBuilder.addFunctionCall(ctx, name);
    }

    @Override
    public void exitFunctionCall(PhpParser.FunctionCallContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterFormalParameter(PhpParser.FormalParameterContext ctx) {
        gastBuilder.addParameter(ctx, ctx.variableInitializer().VarName().getText());
    }

    @Override
    public void enterKeyedVariable(PhpParser.KeyedVariableContext ctx) {
        gastBuilder.addVariable(ctx, ctx.getText().startsWith("$") ? ctx.getText() : "$" + ctx.getText());
    }

    @Override
    public void enterEchoStatement(PhpParser.EchoStatementContext ctx) {
        gastBuilder.addFunctionCall(ctx, "echo");
    }

    @Override
    public void exitEchoStatement(PhpParser.EchoStatementContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterInterpolatedStringPart(PhpParser.InterpolatedStringPartContext ctx) {
        gastBuilder.addConstant(ctx, ctx.getText(), "string");
    }

    @Override
    public void enterLiteralConstant(PhpParser.LiteralConstantContext ctx) {
        gastBuilder.addConstant(ctx, ctx.getText(), "string");
    }

    @Override
    public void enterReturnStatement(PhpParser.ReturnStatementContext ctx) {
        gastBuilder.addReturnStatement(ctx);
    }

    @Override
    public void exitReturnStatement(PhpParser.ReturnStatementContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }


    @Override
    public void enterStatement(PhpParser.StatementContext ctx) {
        gastBuilder.addGenericStatement(ctx);
    }

    @Override
    public void exitStatement(PhpParser.StatementContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterIfStatement(PhpParser.IfStatementContext ctx) {
        gastBuilder.addIfStatement(ctx, ctx.parentheses().getText(), false);
    }

    @Override
    public void exitIfStatement(PhpParser.IfStatementContext ctx) {
        gastBuilder.exitIfStatement();
    }

    @Override
    public void enterElseIfStatement(PhpParser.ElseIfStatementContext ctx) {
        gastBuilder.addIfStatement(ctx, ctx.parentheses().getText(), true);
    }

    @Override
    public void exitElseIfStatement(PhpParser.ElseIfStatementContext ctx) {
        gastBuilder.exitElseIfOrElseStatement();
    }

    @Override
    public void enterElseStatement(PhpParser.ElseStatementContext ctx) {
        gastBuilder.enterElseStatement(ctx);
    }

    @Override
    public void exitElseStatement(PhpParser.ElseStatementContext ctx) {
        gastBuilder.exitElseIfOrElseStatement();
    }

    @Override
    public void enterForStatement(PhpParser.ForStatementContext ctx) {
        gastBuilder.addConditionalStatement(ctx);
    }

    @Override
    public void exitForStatement(PhpParser.ForStatementContext ctx) {
        gastBuilder.exitConditionalStatement();

    }

    @Override
    public void enterForeachStatement(PhpParser.ForeachStatementContext ctx) {
        gastBuilder.addConditionalStatement(ctx);
    }

    @Override
    public void exitForeachStatement(PhpParser.ForeachStatementContext ctx) {
        gastBuilder.exitConditionalStatement();
    }

    @Override
    public void enterWhileStatement(PhpParser.WhileStatementContext ctx) {
        gastBuilder.addConditionalStatement(ctx);
    }

    @Override
    public void exitWhileStatement(PhpParser.WhileStatementContext ctx) {
        gastBuilder.exitConditionalStatement();
    }

    @Override
    public void enterDoWhileStatement(PhpParser.DoWhileStatementContext ctx) {
        gastBuilder.addConditionalStatement(ctx);
    }

    @Override
    public void exitDoWhileStatement(PhpParser.DoWhileStatementContext ctx) {
        gastBuilder.exitConditionalStatement();
    }

    @Override
    public void enterParentheses(PhpParser.ParenthesesContext ctx) {
        gastBuilder.addExpression(ctx);
    }

    @Override
    public void exitParentheses(PhpParser.ParenthesesContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterClassDeclaration(PhpParser.ClassDeclarationContext ctx) {
        gastBuilder.addClass(ctx, ctx.identifier().getText());
    }

    @Override
    public void exitClassDeclaration(PhpParser.ClassDeclarationContext ctx) {
        gastBuilder.exitClass();
    }

    @Override
    public void enterClassStatement(PhpParser.ClassStatementContext ctx) {
        if (ctx.methodBody() != null)
            gastBuilder.addFunction(ctx, ctx.identifier().getText());
        else if (ctx.variableInitializer() != null && !ctx.variableInitializer().isEmpty()) {
            gastBuilder.addAttribute(ctx, ctx.variableInitializer().getFirst().VarName().getText());
        }
    }

    @Override
    public void exitClassStatement(PhpParser.ClassStatementContext ctx) {
        if (ctx.methodBody() != null)
            gastBuilder.exitFunctionOrMethodDeclaration();
        else if (ctx.variableInitializer() != null && !ctx.variableInitializer().isEmpty()) {
            gastBuilder.exitStatementOrExpression();
        }
    }

    @Override
    public void enterVariableInitializer(PhpParser.VariableInitializerContext ctx) {
        gastBuilder.addExpression(ctx);
    }

    @Override
    public void exitVariableInitializer(PhpParser.VariableInitializerContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterNewExpr(PhpParser.NewExprContext ctx) {
        gastBuilder.addNewExpression(ctx, ctx.typeRef().getText());
    }

    @Override
    public void exitNewExpr(PhpParser.NewExprContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterMemberAccess(PhpParser.MemberAccessContext ctx) {
        if (ctx.actualArguments() != null)
            gastBuilder.addFunctionCall(ctx, ctx.keyedFieldName().getText());
        else
            gastBuilder.addAttributeAccess(ctx, ctx.keyedFieldName().getText());
    }

    @Override
    public void exitMemberAccess(PhpParser.MemberAccessContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterActualArgument(PhpParser.ActualArgumentContext ctx) {
        gastBuilder.addExpression(ctx);
    }

    @Override
    public void exitActualArgument(PhpParser.ActualArgumentContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterExpressionStatement(PhpParser.ExpressionStatementContext ctx) {
        gastBuilder.addGenericStatement(ctx);
    }

    @Override
    public void exitExpressionStatement(PhpParser.ExpressionStatementContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterExpression(PhpParser.ExpressionContext ctx) {
        gastBuilder.addExpression(ctx);
    }

    @Override
    public void exitExpression(PhpParser.ExpressionContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }
}
