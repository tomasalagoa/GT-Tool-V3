package ist.gt.languages.solidity.listener;

import ist.gt.gastBuilder.GastBuilder;
import ist.gt.gastBuilder.LiteralOptions;
import ist.gt.languages.java.parser.Java8Parser;
import ist.gt.languages.solidity.parser.SolidityParser;
import ist.gt.languages.solidity.parser.SolidityParserBaseListener;
import lombok.Data;

@Data
public class SolidityFileListener extends SolidityParserBaseListener {
    private final GastBuilder gastBuilder;
    private boolean negativeNumber = false;

    public SolidityFileListener(String filename) {
        gastBuilder = new GastBuilder(filename, GastBuilder.language.SOLIDITY);
    }

    @Override
    public void enterVariableDeclaration(SolidityParser.VariableDeclarationContext ctx) {
        gastBuilder.addVariable(ctx, ctx.identifier().getText(), ctx.typeName().getText());
    }

    @Override
    public void exitVariableDeclaration(SolidityParser.VariableDeclarationContext ctx) {
        gastBuilder.trackLeftVariableValue();
    }

    @Override
    public void enterAddSubOperation(SolidityParser.AddSubOperationContext ctx) {
        gastBuilder.addExpressionOperator(ctx.getText());
    }

    @Override
    public void exitAddSubOperation(SolidityParser.AddSubOperationContext ctx) {
        gastBuilder.trackExpressionValue();
    }

    @Override
    public void enterAssignment(SolidityParser.AssignmentContext ctx) {
        gastBuilder.addAssignment(ctx);
    }

    @Override
    public void exitAssignment(SolidityParser.AssignmentContext ctx) {
        gastBuilder.trackLeftVariableValue();
        //Used in situations where assignment has +=, -=, *=, /=, %=
        gastBuilder.modifyAssignmentWithOperator();
        gastBuilder.exitStatementOrExpression();
    }

    /**
     * @function exitAssignOp
     *
     * Checks the operator associated with the current Assignment being analyzed.
     * The operators supported are: +=, -=, *=, /=, %= and =.
     */
    @Override
    public void exitAssignOp(SolidityParser.AssignOpContext ctx) {
        if (ctx.Assign() != null) {
            gastBuilder.addAssignmentOperator("=");
        } else if (ctx.AssignAdd() != null) {
            gastBuilder.addAssignmentOperator("+=");
        } else if (ctx.AssignSub() != null) {
            gastBuilder.addAssignmentOperator("-=");
        } else if (ctx.AssignMul() != null) {
            gastBuilder.addAssignmentOperator("*=");
        } else if (ctx.AssignDiv() != null) {
            gastBuilder.addAssignmentOperator("/=");
        } else if (ctx.AssignMod() != null) {
            gastBuilder.addAssignmentOperator("%=");
        }
    }



    @Override
    public void enterFunctionDefinition(SolidityParser.FunctionDefinitionContext ctx) {
        gastBuilder.addFunction(ctx, ctx.identifier().getText());
    }

    @Override
    public void exitFunctionDefinition(SolidityParser.FunctionDefinitionContext ctx) {
        gastBuilder.exitFunctionOrMethodDeclaration();
    }

    @Override
    public void enterFunctionCall(SolidityParser.FunctionCallContext ctx) {
        gastBuilder.addFunctionCall(ctx, ctx.getText());
    }

    @Override
    public void exitFunctionCall(SolidityParser.FunctionCallContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterIfStatement(SolidityParser.IfStatementContext ctx) {
        gastBuilder.addIfStatement(ctx, ctx.expression().getText(), false);
    }

    @Override
    public void exitIfStatement(SolidityParser.IfStatementContext ctx) {
        gastBuilder.exitIfStatement();
    }

    @Override
    public void enterLiteral(SolidityParser.LiteralContext ctx) {
        gastBuilder.addLiteral(ctx, new LiteralOptions(this.negativeNumber, false)); //FIXME não sei se é preciso tirar quotes ou não
    }

    @Override
    public void enterExpressionStatement(SolidityParser.ExpressionStatementContext ctx) {
        gastBuilder.addExpression(ctx);
    }

    @Override
    public void exitExpressionStatement(SolidityParser.ExpressionStatementContext ctx) {
        if (!gastBuilder.getStatements().isEmpty()) {
            gastBuilder.trackExpressionValue();
            gastBuilder.exitStatementOrExpression();
        }
    }
}
