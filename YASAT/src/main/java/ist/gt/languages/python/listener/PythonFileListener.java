package ist.yasat.languages.python.listener;

import ist.yasat.gastBuilder.GastBuilder;
import ist.yasat.languages.python.parser.PythonParser;
import ist.yasat.languages.python.parser.PythonParserBaseListener;
import ist.yasat.model.*;
import ist.yasat.model.Class;
import lombok.Data;

@Data
public class PythonFileListener extends PythonParserBaseListener {

    private final GastBuilder gastBuilder;

    public PythonFileListener(String filename) {
        gastBuilder = new GastBuilder(filename);
    }

    @Override
    public void enterLogical_test(PythonParser.Logical_testContext ctx) {
        gastBuilder.addExpression(ctx);
    }

    @Override
    public void exitLogical_test(PythonParser.Logical_testContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }


    @Override
    public void enterIf_stmt(PythonParser.If_stmtContext ctx) {
        gastBuilder.addIfStatement(ctx, ctx.cond.getText(), false);
    }

    @Override
    public void exitIf_stmt(PythonParser.If_stmtContext ctx) {
        gastBuilder.exitIfStatement();
    }

    @Override
    public void enterElif_clause(PythonParser.Elif_clauseContext ctx) {
        gastBuilder.addIfStatement(ctx, ctx.test().getText(), true);
    }

    @Override
    public void exitElif_clause(PythonParser.Elif_clauseContext ctx) {
        gastBuilder.exitElseIfOrElseStatement();
    }

    @Override
    public void enterElse_clause(PythonParser.Else_clauseContext ctx) {
        gastBuilder.enterElseStatement(ctx);
    }

    @Override
    public void exitElse_clause(PythonParser.Else_clauseContext ctx) {
        gastBuilder.exitElseIfOrElseStatement();
    }

    @Override
    public void enterTest(PythonParser.TestContext ctx) {
        gastBuilder.addExpression(ctx);
    }

    @Override
    public void exitTest(PythonParser.TestContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterFuncdef(PythonParser.FuncdefContext ctx) {
        gastBuilder.addFunction(ctx, ctx.name().getText());
    }

    @Override
    public void exitFuncdef(PythonParser.FuncdefContext ctx) {
        gastBuilder.exitFunctionOrMethodDeclaration();
    }

    @Override
    public void enterDef_parameter(PythonParser.Def_parameterContext ctx) {
        gastBuilder.addParameter(ctx, ctx.named_parameter().name().getText());
    }

    @Override
    public void enterSimple_stmt(PythonParser.Simple_stmtContext ctx) {
        gastBuilder.addGenericStatement(ctx);
    }

    @Override
    public void exitSimple_stmt(PythonParser.Simple_stmtContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterClassdef(PythonParser.ClassdefContext ctx) {
        gastBuilder.addClass(ctx, ctx.name().getText());
    }

    @Override
    public void exitClassdef(PythonParser.ClassdefContext ctx) {
        gastBuilder.exitClass();
    }

    @Override
    public void enterExpr(PythonParser.ExprContext ctx) {
        gastBuilder.addExpression(ctx);
    }

    @Override
    public void exitExpr(PythonParser.ExprContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterExprlist(PythonParser.ExprlistContext ctx) {
        gastBuilder.addExpression(ctx);
    }

    @Override
    public void exitExprlist(PythonParser.ExprlistContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterAssign_part(PythonParser.Assign_partContext ctx) {
        gastBuilder.addExpression(ctx);
    }

    @Override
    public void exitAssign_part(PythonParser.Assign_partContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterWhile_stmt(PythonParser.While_stmtContext ctx) {
        gastBuilder.addConditionalStatement(ctx);
    }

    @Override
    public void exitWhile_stmt(PythonParser.While_stmtContext ctx) {
        gastBuilder.exitConditionalStatement();
    }

    @Override
    public void enterName_literal(PythonParser.Name_literalContext ctx) {
        gastBuilder.addVariable(ctx, ctx.getText());
    }


    @Override
    public void enterTrue_false(PythonParser.True_falseContext ctx) {
        gastBuilder.addConstant(ctx, ctx.getText());
    }


    @Override
    public void enterString_literal(PythonParser.String_literalContext ctx) {
        gastBuilder.addConstant(ctx, ctx.getText());
    }


    @Override
    public void enterFor_stmt(PythonParser.For_stmtContext ctx) {
        gastBuilder.addConditionalStatement(ctx);
    }

    @Override
    public void exitFor_stmt(PythonParser.For_stmtContext ctx) {
        gastBuilder.exitConditionalStatement();
    }

    @Override
    public void enterMethod_chain(PythonParser.Method_chainContext ctx) {
        gastBuilder.addMethodCall(ctx);
    }

    @Override
    public void exitMethod_chain(PythonParser.Method_chainContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterAttribute_access(PythonParser.Attribute_accessContext ctx) {
        gastBuilder.addAttributeAccess(ctx, ctx.name().getText());
    }

    @Override
    public void exitAttribute_access(PythonParser.Attribute_accessContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterFunction_call(PythonParser.Function_callContext ctx) {
        gastBuilder.addFunctionCall(ctx, ctx.atom().getText());
    }

    @Override
    public void exitFunction_call(PythonParser.Function_callContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterMethod_call(PythonParser.Method_callContext ctx) {
        gastBuilder.addFunctionCall(ctx, ctx.name().getText());
    }

    @Override
    public void exitMethod_call(PythonParser.Method_callContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterExpr_stmt(PythonParser.Expr_stmtContext ctx) {
        if (ctx.assign_part() != null)
            gastBuilder.addAssignment(ctx);
        else {
            gastBuilder.addGenericStatement(ctx);
        }
    }

    @Override
    public void exitExpr_stmt(PythonParser.Expr_stmtContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterWith_stmt(PythonParser.With_stmtContext ctx) {
        gastBuilder.addGenericStatement(ctx);
    }

    @Override
    public void exitWith_stmt(PythonParser.With_stmtContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }
}
