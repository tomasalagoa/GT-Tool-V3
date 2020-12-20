package ist.gt.languages.js.listener;

import ist.gt.gastBuilder.GastBuilder;
import ist.gt.languages.js.parser.JavaScriptParser;
import ist.gt.languages.js.parser.JavaScriptParserBaseListener;
import ist.gt.util.Util;
import lombok.Data;

@Data
public class JsFileListener extends JavaScriptParserBaseListener {

    private final GastBuilder gastBuilder;

    public JsFileListener(String filename) {
        gastBuilder = new GastBuilder(filename);
    }

    @Override
    public void enterLiteral(JavaScriptParser.LiteralContext ctx) {
        gastBuilder.addConstant(ctx, ctx.getText());
    }

    @Override
    public void enterFunctionDeclaration(JavaScriptParser.FunctionDeclarationContext ctx) {
        gastBuilder.addFunction(ctx, ctx.identifier().getText());
    }

    @Override
    public void exitFunctionDeclaration(JavaScriptParser.FunctionDeclarationContext ctx) {
        gastBuilder.exitFunctionOrMethodDeclaration();
    }

    @Override
    public void enterMethodDefinition(JavaScriptParser.MethodDefinitionContext ctx) {
        gastBuilder.addFunction(ctx, ctx.propertyName().getText());
    }

    @Override
    public void exitMethodDefinition(JavaScriptParser.MethodDefinitionContext ctx) {
        gastBuilder.exitFunctionOrMethodDeclaration();
    }

    @Override
    public void enterGenericExpression(JavaScriptParser.GenericExpressionContext ctx) {
        gastBuilder.addExpression(ctx);
    }

    @Override
    public void exitGenericExpression(JavaScriptParser.GenericExpressionContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterClassDeclaration(JavaScriptParser.ClassDeclarationContext ctx) {
        gastBuilder.addClass(ctx, Util.getPropSafe(() -> ctx.identifier().getText()), Util.getPropSafe(() -> ctx.classTail().singleExpression().getText()));
    }

    @Override
    public void exitClassDeclaration(JavaScriptParser.ClassDeclarationContext ctx) {
        gastBuilder.exitClass();
    }


    @Override
    public void enterIdentifierExpression(JavaScriptParser.IdentifierExpressionContext ctx) {
        gastBuilder.addVariable(ctx, ctx.identifier().getText());
    }

    @Override
    public void enterAssignmentExpression(JavaScriptParser.AssignmentExpressionContext ctx) {
        gastBuilder.addAssignment(ctx);
    }

    @Override
    public void exitAssignmentExpression(JavaScriptParser.AssignmentExpressionContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterAssignable(JavaScriptParser.AssignableContext ctx) {
        gastBuilder.addVariable(ctx, ctx.getText());
    }

    @Override
    public void enterVariableDeclaration(JavaScriptParser.VariableDeclarationContext ctx) {
        gastBuilder.addAssignment(ctx);
    }

    @Override
    public void exitVariableDeclaration(JavaScriptParser.VariableDeclarationContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterFormalParameterArg(JavaScriptParser.FormalParameterArgContext ctx) {
        gastBuilder.addParameter(ctx, ctx.assignable().getText());
    }

    @Override
    public void enterFunctionCall(JavaScriptParser.FunctionCallContext ctx) {
        gastBuilder.addFunctionCall(ctx, ctx.identifier().getText());
    }

    @Override
    public void exitFunctionCall(JavaScriptParser.FunctionCallContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterArgument(JavaScriptParser.ArgumentContext ctx) {
        gastBuilder.addExpression(ctx);
    }

    @Override
    public void exitArgument(JavaScriptParser.ArgumentContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterIfStatement(JavaScriptParser.IfStatementContext ctx) {
        gastBuilder.addIfStatement(ctx, ctx.expressionSequence().getText(), false);
    }

    @Override
    public void exitIfStatement(JavaScriptParser.IfStatementContext ctx) {
        gastBuilder.exitIfStatement();
    }

    @Override
    public void enterElseStatement(JavaScriptParser.ElseStatementContext ctx) {
        gastBuilder.enterElseStatement(ctx);
    }

    @Override
    public void exitElseStatement(JavaScriptParser.ElseStatementContext ctx) {
        gastBuilder.exitElseIfOrElseStatement();
    }

    @Override
    public void enterElseIfStatement(JavaScriptParser.ElseIfStatementContext ctx) {
        gastBuilder.addIfStatement(ctx, ctx.expressionSequence().getText(), true);
    }

    @Override
    public void exitElseIfStatement(JavaScriptParser.ElseIfStatementContext ctx) {
        gastBuilder.exitElseIfOrElseStatement();
    }

    @Override
    public void enterAttributeAccess(JavaScriptParser.AttributeAccessContext ctx) {
        gastBuilder.addAttributeAccess(ctx, ctx.identifierName().getText());
    }

    @Override
    public void exitAttributeAccess(JavaScriptParser.AttributeAccessContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterImportFrom(JavaScriptParser.ImportFromContext ctx) {
        gastBuilder.addImportedFile(ctx.StringLiteral().getText());
    }


    @Override
    public void enterIterationStatement(JavaScriptParser.IterationStatementContext ctx) {
        gastBuilder.addConditionalStatement(ctx);
    }

    @Override
    public void exitIterationStatement(JavaScriptParser.IterationStatementContext ctx) {
        gastBuilder.exitConditionalStatement();
    }

    @Override
    public void enterExpressionSequence(JavaScriptParser.ExpressionSequenceContext ctx) {
        gastBuilder.addExpression(ctx);
    }

    @Override
    public void exitExpressionSequence(JavaScriptParser.ExpressionSequenceContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }


    @Override
    public void enterAttribute(JavaScriptParser.AttributeContext ctx) {
        gastBuilder.addAttribute(ctx, ctx.propertyName().getText());
    }

    @Override
    public void exitAttribute(JavaScriptParser.AttributeContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterReturnStatement(JavaScriptParser.ReturnStatementContext ctx) {
        gastBuilder.addReturnStatement(ctx);
    }

    @Override
    public void exitReturnStatement(JavaScriptParser.ReturnStatementContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterArgumentsExpression(JavaScriptParser.ArgumentsExpressionContext ctx) {
        gastBuilder.addMethodCall(ctx);
        gastBuilder.addVariable(ctx,  ctx.singleExpression().getText());
    }

    @Override
    public void exitArgumentsExpression(JavaScriptParser.ArgumentsExpressionContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }
}
