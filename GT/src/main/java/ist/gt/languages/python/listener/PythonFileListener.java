package ist.gt.languages.python.listener;

import java.util.ArrayList;

import ist.gt.gastBuilder.GastBuilder;
import ist.gt.languages.python.parser.PythonParser;
import ist.gt.languages.python.parser.PythonParserBaseListener;
import ist.gt.model.Expression;
import lombok.Data;

@Data
public class PythonFileListener extends PythonParserBaseListener {

    private final GastBuilder gastBuilder;
    private boolean negativeNumberFound = false;
    private int insertedExpression = 0;
    private boolean classDefFound = false;
    private String className;
    private boolean initFound = false;
    private String functionName;
    private boolean attributeAccessFound = false;
    private ArrayList<String> attributeAccessNames = new ArrayList<>();
    private boolean classInstanceCreation = false;
    private boolean lambdaFunctionDetected = false;

    public PythonFileListener(String filename) {
        gastBuilder = new GastBuilder(filename);
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
        if(ctx.LAMBDA() != null){
            gastBuilder.addLambdaFunction(ctx);
            lambdaFunctionDetected = true;
        } else if(ctx.logical_test() != null && !ctx.logical_test().isEmpty()){
            /* The second expression analyses cases where the last statement (eg. FunctionCall)
             * extends Expression, so instanceof returns true in 1st expression, but 
             * it is not an Expression.
             */
            if(!gastBuilder.getStatements().isEmpty() && (!(gastBuilder.getStatements().peek() instanceof Expression) 
            || (gastBuilder.getStatements().peek() instanceof Expression 
                && gastBuilder.getStatements().peek().getClass() != Expression.class))){
                insertedExpression++;
                gastBuilder.addExpression(ctx);
            }
        }
    }

    @Override
    public void exitTest(PythonParser.TestContext ctx) {
        if(ctx.LAMBDA() != null){
            lambdaFunctionDetected = false;
            gastBuilder.exitLambdaFunction();
        } else if(insertedExpression > 0 && !ctx.logical_test().isEmpty()){
            insertedExpression--;
            gastBuilder.exitStatementOrExpression();
        }
    }

    @Override
    public void enterFuncdef(PythonParser.FuncdefContext ctx) {
        if(!gastBuilder.nameBelongsToClass(ctx.name().getText())){
            gastBuilder.addFunction(ctx, ctx.name().getText());
            functionName = ctx.name().getText();
            if(ctx.name().getText().equals("__init__")){
                initFound = true;
            } else{
                initFound = false;
            }
        }
        className = null;
        classDefFound = false;
    }

    @Override
    public void exitFuncdef(PythonParser.FuncdefContext ctx) {
        functionName = "";
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
        classDefFound = true;
        className = ctx.name().getText();
    }

    @Override
    public void exitClassdef(PythonParser.ClassdefContext ctx) {
        gastBuilder.exitClass();
    }

    @Override
    public void enterExpr(PythonParser.ExprContext ctx) {
        if(ctx.ADD() != null){
            gastBuilder.addExpressionOperator(ctx.ADD().getText());
        } else if(ctx.MINUS() != null){
            gastBuilder.addExpressionOperator(ctx.MINUS().getText());
        } else if(ctx.STAR() != null){
            gastBuilder.addExpressionOperator(ctx.STAR().getText());
        } else if(ctx.DIV() != null){
            gastBuilder.addExpressionOperator(ctx.DIV().getText());
        } else if(ctx.MOD() != null){
            gastBuilder.addExpressionOperator(ctx.MOD().getText());
        }
    }

    @Override
    public void enterExprlist(PythonParser.ExprlistContext ctx) {
        gastBuilder.addExpression(ctx);
    }

    @Override
    public void exitExprlist(PythonParser.ExprlistContext ctx) {
        gastBuilder.trackExpressionValue();
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterAssign_part(PythonParser.Assign_partContext ctx) {
        gastBuilder.addExpression(ctx);
    }

    @Override
    public void exitAssign_part(PythonParser.Assign_partContext ctx) {
        gastBuilder.trackExpressionValue();
        gastBuilder.exitStatementOrExpression();

        if(ctx.ADD_ASSIGN() != null){
            gastBuilder.addAssignmentOperator("+=");
        } else if (ctx.DIV_ASSIGN() != null){
            gastBuilder.addAssignmentOperator("/=");
        } else if(ctx.MOD_ASSIGN() != null){
            gastBuilder.addAssignmentOperator("%=");
        } else if(ctx.MULT_ASSIGN() != null){
            gastBuilder.addAssignmentOperator("*=");
        } else if(ctx.SUB_ASSIGN() != null){
            gastBuilder.addAssignmentOperator("-=");
        } else if(ctx.ASSIGN() != null){
            gastBuilder.addAssignmentOperator("=");
        }
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
        if(classDefFound){
            if(className != null && !className.equals(ctx.getText())){
                gastBuilder.addAttributeToClass(ctx, ctx.getText());
                gastBuilder.addClassAttributeToAssignment(ctx.getText());
            }
        } else if(attributeAccessFound && functionName.equals("__init__") && 
        !ctx.getText().equals("self")){
            gastBuilder.addAttributeToClass(ctx, ctx.getText());
            gastBuilder.addClassAttributeToAssignment(ctx.getText());
            attributeAccessFound = false;
        } 
        else{
            if(!attributeAccessNames.isEmpty() && attributeAccessNames.contains(ctx.getText())){
                attributeAccessNames.remove(ctx.getText());
                return;
            }
            if(!classInstanceCreation && (functionName == null || !functionName.equals(ctx.getText()))){
                gastBuilder.addVariable(ctx, ctx.getText());
            }

        }
    }

    @Override
    public void enterTrue_false(PythonParser.True_falseContext ctx) {
        gastBuilder.addConstant(ctx, ctx.getText(), "boolean");
    }

    @Override
    public void enterString_literal(PythonParser.String_literalContext ctx) {
        String rmvQuotes = ctx.getText().substring(1, ctx.getText().length()-1).replace("\"\"", "\"");
        gastBuilder.addConstant(ctx, rmvQuotes, "String");
    }

    @Override
    public void enterNumber(PythonParser.NumberContext ctx){
        if(negativeNumberFound){
            gastBuilder.addConstant(ctx, "-" + ctx.getText(), "double");
            negativeNumberFound = false;
        } else{
            gastBuilder.addConstant(ctx, ctx.getText(), "double");
        }
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
    public void enterMethod_chain(PythonParser.Method_chainContext ctx){
        if(ctx.trailer() != null && !ctx.trailer().isEmpty()){
            if(ctx.trailer(0).method_call() != null){
                gastBuilder.addMethodCall(ctx);
            } else if(ctx.trailer(0).attribute_access() != null){
                attributeAccessFound = true;
                if(!initFound){
                    gastBuilder.addVariable(ctx, ctx.getText());
                    gastBuilder.accessedAttribute();
                }
                attributeAccessNames.add(ctx.atom().getText());
                for(int i = 0; i < ctx.trailer().size(); i++){
                    if(ctx.trailer(i).attribute_access() != null){
                        attributeAccessNames.add(ctx.trailer(i).attribute_access().getText().replace(".", ""));
                    }
                }
            } else if (ctx.trailer(0).arguments() != null && ctx.trailer(0).arguments().OPEN_PAREN() != null){
                if(gastBuilder.nameBelongsToClass(ctx.atom().getText())){
                    gastBuilder.trackClassReference(ctx.atom().getText());
                    classInstanceCreation = true;
                } else{
                    gastBuilder.addFunctionCall(ctx, ctx.atom().getText());
                    functionName = ctx.atom().getText();
                }
            }
        }
    }

    @Override
    public void exitMethod_chain(PythonParser.Method_chainContext ctx){
        if(ctx.trailer() != null && !ctx.trailer().isEmpty()){
            if(ctx.trailer(0).method_call() != null){
                gastBuilder.exitStatementOrExpression();
            } else if(ctx.trailer(0).attribute_access() != null){
                attributeAccessFound = false;
                attributeAccessNames.clear();
            } else if (ctx.trailer(0).arguments() != null && ctx.trailer(0).arguments().OPEN_PAREN() != null){
                if(!classInstanceCreation){
                    gastBuilder.exitStatementOrExpression();
                    functionName = "";
                } else{
                    classInstanceCreation = false;
                }
            }
        }
    }

    @Override
    public void enterMethod_call(PythonParser.Method_callContext ctx) {
        gastBuilder.addFunctionCall(ctx, ctx.name().getText());
        functionName = ctx.name().getText();
    }

    @Override
    public void exitMethod_call(PythonParser.Method_callContext ctx) {
        gastBuilder.exitStatementOrExpression();
        functionName = "";
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
        if(ctx.assign_part() != null){
            gastBuilder.checkIfLeftSideIsExpr();
            gastBuilder.trackLeftVariableValue();
            //Used in situations where assignment has +=, -=, *=, /=, %=
            gastBuilder.modifyAssignmentWithOperator();
            gastBuilder.exitStatementOrExpression();
        } else {
            gastBuilder.exitStatementOrExpression();
        }
    }

    @Override
    public void enterWith_stmt(PythonParser.With_stmtContext ctx) {
        gastBuilder.addGenericStatement(ctx);
    }

    @Override
    public void exitWith_stmt(PythonParser.With_stmtContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterComparison(PythonParser.ComparisonContext ctx){
        if(ctx.LESS_THAN() != null){
            gastBuilder.addExpressionOperator(ctx.LESS_THAN().getText());
        } else if(ctx.GREATER_THAN() != null){
            gastBuilder.addExpressionOperator(ctx.GREATER_THAN().getText());
        } else if (ctx.LT_EQ() != null){
            gastBuilder.addExpressionOperator(ctx.LT_EQ().getText());
        } else if (ctx.GT_EQ() != null){
            gastBuilder.addExpressionOperator(ctx.GT_EQ().getText());
        } else if(ctx.EQUALS() != null){
            gastBuilder.addExpressionOperator(ctx.EQUALS().getText());
        } else if(ctx.NOT_EQ_2() != null){
            gastBuilder.addExpressionOperator(ctx.NOT_EQ_2().getText());
        }
    }

    @Override
    public void enterAtom(PythonParser.AtomContext ctx){
        if(ctx.MINUS() != null){
            negativeNumberFound = true;
        }
    }

    @Override
    public void enterVarargslist(PythonParser.VarargslistContext ctx){
        if(lambdaFunctionDetected){
            for(int i = 0; i < ctx.vardef_parameters().size(); i++){
                gastBuilder.addParametersToLambdaFunction(ctx, ctx.vardef_parameters(i).getText());
            }
        }
    }
}
