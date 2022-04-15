package ist.gt.languages.java.listener;

import ist.gt.gastBuilder.GastBuilder;
import ist.gt.languages.java.parser.Java8Parser;
import ist.gt.languages.java.parser.Java8ParserBaseListener;
import ist.gt.model.FunctionCall;
import lombok.Data;

import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTree;

@Data
public class JavaFileListener extends Java8ParserBaseListener {

    private final Stack<Boolean> primaries = new Stack<>();
    private boolean wasConditionalExpr;
    private final GastBuilder gastBuilder;
    private final Stack<FunctionCall> expressionAfterPrimaryEnd = new Stack<>();

    public JavaFileListener(String filename) {
        gastBuilder = new GastBuilder(filename);
    }

    @Override
    public void enterNormalClassDeclaration(Java8Parser.NormalClassDeclarationContext ctx) {
        gastBuilder.addClass(ctx, ctx.Identifier().getText());
    }

    @Override
    public void exitNormalClassDeclaration(Java8Parser.NormalClassDeclarationContext ctx) {
        gastBuilder.exitClass();
    }

    @Override
    public void enterMethodDeclaration(Java8Parser.MethodDeclarationContext ctx) {
        gastBuilder.addFunction(ctx, ctx.methodHeader().methodDeclarator().Identifier().getText());
    }

    @Override
    public void exitMethodDeclaration(Java8Parser.MethodDeclarationContext ctx) {
        gastBuilder.exitFunctionOrMethodDeclaration();
    }

    @Override
    public void enterFormalParameter(Java8Parser.FormalParameterContext ctx) {
        gastBuilder.addParameter(ctx, ctx.variableDeclaratorId().Identifier().getText(), ctx.unannType().getText());
    }

    @Override
    public void enterLiteral(Java8Parser.LiteralContext ctx) {
        if(ctx.BooleanLiteral() != null){
            System.out.println("Boolean");
            System.out.println(ctx.BooleanLiteral().getText());
            gastBuilder.addConstant(ctx, ctx.getText(), "boolean");
        } else if(ctx.IntegerLiteral() != null){
            System.out.println("Integer");
            System.out.println(ctx.IntegerLiteral().getText());
            gastBuilder.addConstant(ctx, ctx.getText(), "int");
        } else if(ctx.FloatingPointLiteral() != null){
            System.out.println("Float/Double");
            System.out.println(ctx.FloatingPointLiteral().getText());
            gastBuilder.addConstant(ctx, ctx.getText(), "double");
        } else if(ctx.CharacterLiteral() != null){
            System.out.println("Char");
            System.out.println(ctx.CharacterLiteral().getText());
            gastBuilder.addConstant(ctx, ctx.getText(), "char");
        } else if(ctx.StringLiteral() != null){
            System.out.println("String");
            System.out.println(ctx.getText());
            //Remove quotes from ctx text due to the appearance of double quotes later on
            String rmvQuotes = ctx.getText().substring(1, ctx.getText().length()-1).replace("\"\"", "\"");
            System.out.println(rmvQuotes);
            gastBuilder.addConstant(ctx, rmvQuotes, "String");
        } else if(ctx.NullLiteral() != null){
            System.out.println("Null");
            System.out.println(ctx.NullLiteral().getText());
            gastBuilder.addConstant(ctx, ctx.getText(), null);
        }
        //gastBuilder.addConstant(ctx, ctx.getText());
        
    }

    @Override
    public void enterConditionalExpression(Java8Parser.ConditionalExpressionContext ctx) {
        //gastBuilder.addExpression(ctx);
        if(isConditionalExpression(ctx)){
            gastBuilder.addExpression(ctx);
        }
    }

    @Override
    public void exitConditionalExpression(Java8Parser.ConditionalExpressionContext ctx) {
        //System.out.println("Removing Conditional Expression? " + isConditionalExpression(ctx) + " -> " + ctx.getText());
        if(isConditionalExpression(ctx)){
            gastBuilder.exitStatementOrExpression();
            //System.out.println("Removed from stack");
        }
    }

    /*  Experimental function: ConditionalExpression is of the form: expression ? expression : expression;
        However, it also appears in other expressions for some reason and adds noise to the analysis sometimes
    */
    public boolean isConditionalExpression(Java8Parser.ConditionalExpressionContext ctx){
        if(ctx.getToken(Java8Parser.QUESTION, 0) != null && ctx.getToken(Java8Parser.COLON, 0) != null){
            //System.out.println("A conditional expression was found -> " + ctx.getText());
            return true;
        }

        //System.out.println("Well, not a conditional expression after all -> " + ctx.getText());
        return false;
    }

    @Override
    public void enterExpression(Java8Parser.ExpressionContext ctx) {
        gastBuilder.addExpression(ctx);
    }

    @Override
    public void exitExpression(Java8Parser.ExpressionContext ctx) {
        gastBuilder.trackExpressionValue();
        gastBuilder.exitStatementOrExpression();
    }


    @Override
    public void enterLocalVariableDeclaration(Java8Parser.LocalVariableDeclarationContext ctx) {
        gastBuilder.addVariable(ctx, ctx.variableDeclaratorList().variableDeclarator(0).variableDeclaratorId().Identifier().getText(), ctx.unannType().getText());
    }

    @Override
    public void enterLocalVariableDeclarationStatement(Java8Parser.LocalVariableDeclarationStatementContext ctx) {
        gastBuilder.addAssignment(ctx);
    }

    @Override
    public void exitLocalVariableDeclarationStatement(Java8Parser.LocalVariableDeclarationStatementContext ctx) {
        gastBuilder.trackLeftVariableValue();
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterExpressionName(Java8Parser.ExpressionNameContext ctx) {
        if (ctx.ambiguousName() != null) {
            gastBuilder.addMethodCall(ctx);
            gastBuilder.addVariable(ctx, ctx.ambiguousName().Identifier().getText());
            gastBuilder.addAttributeAccess(ctx, ctx.Identifier().getText());
            gastBuilder.exitStatementOrExpression();
        }
        gastBuilder.addVariable(ctx, ctx.Identifier().getText());
    }

    @Override
    public void enterMethodInvocation_lf_primary(Java8Parser.MethodInvocation_lf_primaryContext ctx) {
        gastBuilder.addFunctionCall(ctx, ctx.Identifier().getText());
    }

    @Override
    public void exitMethodInvocation_lf_primary(Java8Parser.MethodInvocation_lf_primaryContext ctx) {
        gastBuilder.exitStatementOrExpression();

    }

    @Override
    public void enterMethodInvocation_lfno_primary(Java8Parser.MethodInvocation_lfno_primaryContext ctx) {
        if (ctx.typeName() != null) {
            primaries.push(true);
            gastBuilder.addMethodCall(ctx);
            if (ctx.typeName() != null)
                gastBuilder.addVariable(ctx, ctx.typeName().getText());
            gastBuilder.addFunctionCall(ctx, ctx.Identifier().getText());
        } else {
            gastBuilder.addFunctionCall(ctx, ctx.methodName().getText());
        }
    }


    @Override
    public void exitMethodInvocation_lfno_primary(Java8Parser.MethodInvocation_lfno_primaryContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterMethodInvocation(Java8Parser.MethodInvocationContext ctx) {
        if (ctx.methodName() != null) {
            gastBuilder.addFunctionCall(ctx, ctx.methodName().getText());
            return;
        }
        if (ctx.typeName() != null) {
            gastBuilder.addMethodCall(ctx);
            if (ctx.typeName() != null)
                gastBuilder.addVariable(ctx, ctx.typeName().getText());
            gastBuilder.addFunctionCall(ctx, ctx.Identifier().getText());
        } else {
            gastBuilder.addMethodCall(ctx);
            expressionAfterPrimaryEnd.push(new FunctionCall(ctx, ctx.Identifier().getText()));
        }
    }

    @Override
    public void exitMethodInvocation(Java8Parser.MethodInvocationContext ctx) {
        if (ctx.methodName() != null) {
            gastBuilder.exitStatementOrExpression();
        } else if (ctx.typeName() != null) {
            gastBuilder.exitStatementOrExpression();
            gastBuilder.exitStatementOrExpression();
        } else if (!expressionAfterPrimaryEnd.empty()) {
            expressionAfterPrimaryEnd.pop();
        }
    }


    @Override
    public void enterPrimary(Java8Parser.PrimaryContext ctx) {
        primaries.push(false);
    }

    @Override
    public void exitPrimary(Java8Parser.PrimaryContext ctx) {
        if (primaries.peek()) {
            primaries.pop();
            gastBuilder.exitStatementOrExpression();
        }
        if (!expressionAfterPrimaryEnd.empty()) {
            var funcCall = expressionAfterPrimaryEnd.peek();
            gastBuilder.addFunctionCall(ctx, funcCall.getFunctionName());
        }

    }


    @Override
    public void enterClassInstanceCreationExpression(Java8Parser.ClassInstanceCreationExpressionContext ctx) {
        gastBuilder.addNewExpression(ctx, ctx.Identifier(0).getText());
    }

    @Override
    public void exitClassInstanceCreationExpression(Java8Parser.ClassInstanceCreationExpressionContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterClassInstanceCreationExpression_lf_primary(Java8Parser.ClassInstanceCreationExpression_lf_primaryContext ctx) {
        gastBuilder.addNewExpression(ctx, ctx.Identifier().getText());
    }

    @Override
    public void exitClassInstanceCreationExpression_lf_primary(Java8Parser.ClassInstanceCreationExpression_lf_primaryContext ctx) {
        gastBuilder.exitStatementOrExpression();

    }

    @Override
    public void enterClassInstanceCreationExpression_lfno_primary(Java8Parser.ClassInstanceCreationExpression_lfno_primaryContext ctx) {
        gastBuilder.addNewExpression(ctx, ctx.Identifier(0).getText());
    }

    @Override
    public void exitClassInstanceCreationExpression_lfno_primary(Java8Parser.ClassInstanceCreationExpression_lfno_primaryContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterFieldDeclaration(Java8Parser.FieldDeclarationContext ctx) {
        gastBuilder.addAttribute(ctx, ctx.variableDeclaratorList().variableDeclarator(0).variableDeclaratorId().getText(), ctx.unannType().getText());
    }

    @Override
    public void exitFieldDeclaration(Java8Parser.FieldDeclarationContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterAssignment(Java8Parser.AssignmentContext ctx) {
        gastBuilder.addAssignment(ctx);
        gastBuilder.addVariable(ctx.leftHandSide(), ctx.leftHandSide().getText());
    }

    @Override
    public void exitAssignment(Java8Parser.AssignmentContext ctx) {
        gastBuilder.trackLeftVariableValue();
        gastBuilder.exitStatementOrExpression();
    }


    @Override
    public void enterIfThenStatement(Java8Parser.IfThenStatementContext ctx) {
        gastBuilder.addIfStatement(ctx, ctx.expression().getText(), false);
    }

    @Override
    public void exitIfThenStatement(Java8Parser.IfThenStatementContext ctx) {
        gastBuilder.exitIfStatement();
    }

    @Override
    public void enterIfThenElseStatement(Java8Parser.IfThenElseStatementContext ctx) {
        gastBuilder.addIfStatement(ctx, ctx.expression().getText(), false);
    }

    @Override
    public void exitIfThenElseStatement(Java8Parser.IfThenElseStatementContext ctx) {
        gastBuilder.exitIfStatement();
    }

    @Override
    public void enterIfThenElseStatementNoShortIf(Java8Parser.IfThenElseStatementNoShortIfContext ctx) {
        gastBuilder.addIfStatement(ctx, ctx.expression().getText(), false);
    }

    @Override
    public void exitIfThenElseStatementNoShortIf(Java8Parser.IfThenElseStatementNoShortIfContext ctx) {
        gastBuilder.exitIfStatement();
    }

    @Override
    public void enterElseStatement(Java8Parser.ElseStatementContext ctx) {
        gastBuilder.enterElseStatement(ctx);
    }

    @Override
    public void exitElseStatement(Java8Parser.ElseStatementContext ctx) {
        gastBuilder.exitElseIfOrElseStatement();
    }

    @Override
    public void enterElseIfStatement(Java8Parser.ElseIfStatementContext ctx) {
        gastBuilder.addIfStatement(ctx, ctx.expression().getText(), true);
    }

    @Override
    public void exitElseIfStatement(Java8Parser.ElseIfStatementContext ctx) {
        gastBuilder.exitElseIfOrElseStatement();
    }

    @Override
    public void enterElseIfStatementNoShortIf(Java8Parser.ElseIfStatementNoShortIfContext ctx) {
        gastBuilder.addIfStatement(ctx, ctx.expression().getText(), true);
    }

    @Override
    public void exitElseIfStatementNoShortIf(Java8Parser.ElseIfStatementNoShortIfContext ctx) {
        gastBuilder.exitElseIfOrElseStatement();
    }

    @Override
    public void enterThrowStatement(Java8Parser.ThrowStatementContext ctx) {
        gastBuilder.addThrowException(ctx);
    }

    @Override
    public void exitThrowStatement(Java8Parser.ThrowStatementContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterWhileStatement(Java8Parser.WhileStatementContext ctx) {
        gastBuilder.addConditionalStatement(ctx);
    }

    @Override
    public void exitWhileStatement(Java8Parser.WhileStatementContext ctx) {
        gastBuilder.exitConditionalStatement();
    }

    @Override
    public void enterWhileStatementNoShortIf(Java8Parser.WhileStatementNoShortIfContext ctx) {
        gastBuilder.addConditionalStatement(ctx);
    }

    @Override
    public void exitWhileStatementNoShortIf(Java8Parser.WhileStatementNoShortIfContext ctx) {
        gastBuilder.exitConditionalStatement();
    }

    @Override
    public void enterDoStatement(Java8Parser.DoStatementContext ctx) {
        gastBuilder.addConditionalStatement(ctx);
    }

    @Override
    public void exitDoStatement(Java8Parser.DoStatementContext ctx) {
        gastBuilder.exitConditionalStatement();
    }

    @Override
    public void enterBasicForStatement(Java8Parser.BasicForStatementContext ctx) {
        gastBuilder.addConditionalStatement(ctx);
    }

    @Override
    public void exitBasicForStatement(Java8Parser.BasicForStatementContext ctx) {
        gastBuilder.exitConditionalStatement();
    }

    @Override
    public void enterBasicForStatementNoShortIf(Java8Parser.BasicForStatementNoShortIfContext ctx) {
        gastBuilder.addConditionalStatement(ctx);
    }

    @Override
    public void exitBasicForStatementNoShortIf(Java8Parser.BasicForStatementNoShortIfContext ctx) {
        gastBuilder.exitConditionalStatement();
    }

    @Override
    public void enterExpressionStatement(Java8Parser.ExpressionStatementContext ctx) {
        gastBuilder.addGenericStatement(ctx);
    }

    @Override
    public void exitExpressionStatement(Java8Parser.ExpressionStatementContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterReturnStatement(Java8Parser.ReturnStatementContext ctx) {
        gastBuilder.addReturnStatement(ctx);
    }

    @Override
    public void exitReturnStatement(Java8Parser.ReturnStatementContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterConstructorDeclaration(Java8Parser.ConstructorDeclarationContext ctx) {
        gastBuilder.addFunction(ctx, ctx.constructorDeclarator().simpleTypeName().Identifier().getText(), ctx.constructorDeclarator().simpleTypeName().Identifier().getText());
    }

    @Override
    public void exitConstructorDeclaration(Java8Parser.ConstructorDeclarationContext ctx) {
        gastBuilder.exitFunctionOrMethodDeclaration();
    }

    @Override
    public void enterResource(Java8Parser.ResourceContext ctx) {
        if (ctx.unannType() != null && ctx.variableDeclaratorId() != null) {
            gastBuilder.addAssignment(ctx);
            gastBuilder.addVariable(ctx, ctx.variableDeclaratorId().Identifier().getText(), ctx.unannType().getText());
        } else {
            gastBuilder.addGenericStatement(ctx);
        }
    }

    @Override
    public void exitResource(Java8Parser.ResourceContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterTryStatement(Java8Parser.TryStatementContext ctx) {
        gastBuilder.addTryCatch(ctx);
    }

    @Override
    public void exitTryStatement(Java8Parser.TryStatementContext ctx) {
        gastBuilder.exitTryCatchBlock();
    }

    @Override
    public void enterCatchClause(Java8Parser.CatchClauseContext ctx) {
        gastBuilder.enterCatchBlock();
    }

    @Override
    public void exitCatchClause(Java8Parser.CatchClauseContext ctx) {
        gastBuilder.exitCatchBlock();
    }


    @Override
    public void exitRelationalExpression(Java8Parser.RelationalExpressionContext ctx){
        if(ctx.GE() != null){
            gastBuilder.evaluateRelationalExpression(ctx, ctx.GE().getText());
        } else if(ctx.GT() != null){
            gastBuilder.evaluateRelationalExpression(ctx, ctx.GT().getText());
        } else if(ctx.LE() != null){
            gastBuilder.evaluateRelationalExpression(ctx, ctx.LE().getText());
        } else if(ctx.LT() != null){
            gastBuilder.evaluateRelationalExpression(ctx, ctx.LT().getText());
        } else if(ctx.INSTANCEOF() != null){
            gastBuilder.evaluateRelationalExpression(ctx, ctx.INSTANCEOF().getText());
        }
        System.out.println("Exiting relational expr");
    }

    @Override
    public void exitMultiplicativeExpression(Java8Parser.MultiplicativeExpressionContext ctx){
        if(ctx.MUL() != null){
            gastBuilder.evaluateMultiplicativeExpression(ctx, ctx.MUL().getText());
        } else if(ctx.DIV() != null){
            gastBuilder.evaluateMultiplicativeExpression(ctx, ctx.DIV().getText());
        } else if(ctx.MOD() != null){
            gastBuilder.evaluateMultiplicativeExpression(ctx, ctx.MOD().getText());
        }
        System.out.println("Exiting multiplicative expr");
    }

    @Override
    public void exitEqualityExpression(Java8Parser.EqualityExpressionContext ctx){
        if(ctx.EQUAL() != null){
            gastBuilder.evaluateEqualityExpression(ctx, ctx.EQUAL().getText());
        } else if(ctx.NOTEQUAL() != null){
            gastBuilder.evaluateEqualityExpression(ctx, ctx.NOTEQUAL().getText());
        }
        System.out.println("Exiting equality expr");
    }

    @Override
    public void exitAdditiveExpression(Java8Parser.AdditiveExpressionContext ctx){
        if(ctx.ADD() != null){
            gastBuilder.evaluateAdditiveExpression(ctx, ctx.ADD().getText());
        } else if(ctx.SUB() != null){
            gastBuilder.evaluateAdditiveExpression(ctx, ctx.SUB().getText());
        }
        System.out.println("Exiting additive expr");
    }
}
