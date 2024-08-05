package ist.gt.languages.java.listener;

import ist.gt.gastBuilder.GastBuilder;
import ist.gt.languages.java.parser.Java8Parser;
import ist.gt.languages.java.parser.Java8ParserBaseListener;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class JavaFileListener extends Java8ParserBaseListener {

    private boolean wasConditionalExpr;
    private boolean wasAssignmentNeeded;
    private boolean negativeNumberFound = false;
    private boolean lambdaFunctionDetected = false;
    private boolean wasVarDecl = false;
    private boolean genStmtInserted = false;
    private boolean collectionFound = false;
    private boolean classInMethodCallSource = false;
    private String switchExpression = "";
    private int totalSwitchCases;
    private int casesBuilt = 0;
    private final GastBuilder gastBuilder;

    public JavaFileListener(String filename) {
        gastBuilder = new GastBuilder(filename);
    }

    @Override
    public void enterNormalClassDeclaration(Java8Parser.NormalClassDeclarationContext ctx) {
        if(ctx.superclass() != null){
            gastBuilder.addClass(ctx, ctx.Identifier().getText(), ctx.superclass().classType().getText());
        } else{
            gastBuilder.addClass(ctx, ctx.Identifier().getText());
        }
        
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
            gastBuilder.addConstant(ctx, ctx.getText(), "boolean");
        } else if(ctx.IntegerLiteral() != null){
            if(this.negativeNumberFound){
                gastBuilder.addConstant(ctx, "-" + ctx.getText(), "int");
                this.negativeNumberFound = false;
            } else {
                gastBuilder.addConstant(ctx, ctx.getText(), "int");
            }
        } else if(ctx.FloatingPointLiteral() != null){
            if(this.negativeNumberFound){
                gastBuilder.addConstant(ctx, "-" + ctx.getText(), "double");
                this.negativeNumberFound = false;
            } else{
                gastBuilder.addConstant(ctx, ctx.getText(), "double");
            }
        } else if(ctx.CharacterLiteral() != null){
            gastBuilder.addConstant(ctx, ctx.getText(), "char");
        } else if(ctx.StringLiteral() != null){
            //Remove quotes from ctx text due to the appearance of double quotes later on
            String rmvQuotes = ctx.getText().substring(1, ctx.getText().length()-1).replace("\"\"", "\"");
            gastBuilder.addConstant(ctx, rmvQuotes, "String");
        } else if(ctx.NullLiteral() != null){
            gastBuilder.addConstant(ctx, ctx.getText(), null);
        }
        
    }

    /** 
     * This rule is mainly used to catch negative numbers as literals. The reason for this is
     * because if, e.g, we do int num = -1, what reaches the LiteralContext above is only 1, the
     * - is used in this rule and -1 never reaches LiteralContext. So with this, we are advising
     * a "counter" to know when the number should've been negative.
     */
    @Override
    public void enterUnaryExpression(Java8Parser.UnaryExpressionContext ctx){
        if(ctx.SUB() != null){
            String str = ctx.getText();

            negativeNumberFound = str.matches("-\\d+\\.?\\d*");
        }
    }

    @Override
    public void enterConditionalExpression(Java8Parser.ConditionalExpressionContext ctx) {
        if(ctx.QUESTION() != null && ctx.COLON() != null){
            gastBuilder.addIfStatement(ctx, ctx.getText(), false);
            gastBuilder.addExpression(ctx);
        }
    }

    @Override
    public void exitConditionalExpression(Java8Parser.ConditionalExpressionContext ctx) {
        if(ctx.QUESTION() != null && ctx.COLON() != null){
            gastBuilder.buildConditionalExpressionAsIfStatement();
            gastBuilder.exitStatementOrExpression();
            gastBuilder.exitIfStatement();
        }
    }

    @Override
    public void enterExpression(Java8Parser.ExpressionContext ctx) {
        gastBuilder.addExpression(ctx);
    }

    @Override
    public void exitExpression(Java8Parser.ExpressionContext ctx) {
        if(!gastBuilder.getStatements().isEmpty()){
            gastBuilder.trackExpressionValue();
            gastBuilder.exitStatementOrExpression();
        }
    }


    @Override
    public void enterLocalVariableDeclaration(Java8Parser.LocalVariableDeclarationContext ctx) {
        gastBuilder.addVariable(ctx, ctx.variableDeclaratorList().variableDeclarator(0).variableDeclaratorId().Identifier().getText(), ctx.unannType().getText());
    }

    @Override
    public void enterLocalVariableDeclarationStatement(Java8Parser.LocalVariableDeclarationStatementContext ctx) {
        gastBuilder.addAssignment(ctx);
        wasVarDecl = true;
    }

    @Override
    public void exitLocalVariableDeclarationStatement(Java8Parser.LocalVariableDeclarationStatementContext ctx) {
        if(!gastBuilder.getStatements().isEmpty()){
            gastBuilder.trackLeftVariableValue();
            //Used in situations where assignment has +=, -=, *=, /=, %=
            gastBuilder.modifyAssignmentWithOperator();
            gastBuilder.exitStatementOrExpression();
            wasVarDecl = false;
            if(genStmtInserted){
                genStmtInserted = false;
                gastBuilder.exitStatementOrExpression();
            }
        }
    }

    @Override
    public void enterExpressionName(Java8Parser.ExpressionNameContext ctx) {
        boolean accessedAttribute = false;
        boolean isGenStmt = false;
        if (ctx.ambiguousName() != null) {
            /* This function will be used, primarily, because with a Generic Statement GT will lose some
             * information about an attribute access. */
            isGenStmt = gastBuilder.isGenericStatement();
            gastBuilder.addVariable(ctx, ctx.ambiguousName().Identifier().getText() + "." + ctx.Identifier().getText());
            accessedAttribute = true;
        }
  
        if(isGenStmt){
            gastBuilder.exitStatementOrExpression();
        }
        if(accessedAttribute){
            //New function to help with attribute value tracking
            gastBuilder.accessedAttribute();
        } else{
            gastBuilder.addVariable(ctx, ctx.Identifier().getText());
        }
    }

    @Override
    public void enterMethodInvocation_lf_primary(Java8Parser.MethodInvocation_lf_primaryContext ctx) {
        if(ctx.DOT() != null){
            gastBuilder.addMethodCall(ctx);
            gastBuilder.rearrangeMethodClassWithClassSource();
        }
        gastBuilder.addFunctionCall(ctx, ctx.Identifier().getText());
    }

    @Override
    public void exitMethodInvocation_lf_primary(Java8Parser.MethodInvocation_lf_primaryContext ctx) {
        gastBuilder.exitStatementOrExpression();
        if(ctx.DOT() != null){
            gastBuilder.exitStatementOrExpression();
        }

    }

    @Override
    public void enterMethodInvocation_lfno_primary(Java8Parser.MethodInvocation_lfno_primaryContext ctx) {
        if (ctx.typeName() != null) {
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
        if(ctx.typeName() != null){
            gastBuilder.exitStatementOrExpression();
            gastBuilder.exitStatementOrExpression();
        } else{
            gastBuilder.exitStatementOrExpression();
        }
    }

    @Override
    public void enterMethodInvocation(Java8Parser.MethodInvocationContext ctx) {
        if(ctx.SUPER() != null){
            gastBuilder.addSuperMethodCall(ctx, ctx.Identifier().getText(), false);
            return;
        }

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
            // "this" is stored in primary
            if(ctx.primary() != null){
                if(ctx.primary().getText().equals("this")){
                    gastBuilder.addVariable(ctx, ctx.primary().getText());
                } else{
                    // This most certaintly could be a case of (new SomeClass()).someMethod()
                    this.classInMethodCallSource = true;
                }
            }
            gastBuilder.addFunctionCall(ctx, ctx.Identifier().getText());
        }
    }

    @Override
    public void exitMethodInvocation(Java8Parser.MethodInvocationContext ctx) {
        if(ctx.SUPER() != null){
            gastBuilder.exitStatementOrExpression();
        }
        
        if (ctx.methodName() != null) {
            gastBuilder.exitStatementOrExpression();
        } else if (ctx.typeName() != null) {
            gastBuilder.exitStatementOrExpression();
            gastBuilder.exitStatementOrExpression();
        } else{
            if(this.classInMethodCallSource){
                gastBuilder.rearrangeMethodClassWithClassSource();
                this.classInMethodCallSource = false;
            }
            gastBuilder.exitStatementOrExpression();
            gastBuilder.exitStatementOrExpression();
        }
    }

    @Override
    public void enterPrimary(Java8Parser.PrimaryContext ctx) {
        if(ctx.getText().matches("this\\.[a-zA-Z0-9_]+") || 
        ctx.getText().matches("this\\.[a-zA-Z0-9_]+\\.[a-zA-Z0-9_()]+")){
            List<String> members = Arrays.asList(ctx.getText().split("\\."));
            gastBuilder.addVariable(ctx, members.get(0));
            gastBuilder.addSelectedAttributeToThis(members.get(1));
        }
    }

    @Override
    public void enterClassInstanceCreationExpression(Java8Parser.ClassInstanceCreationExpressionContext ctx) {
        if(ctx.Identifier(0).getText().equals("ArrayList") || 
            ctx.Identifier(0).getText().equals("LinkedList") ||
            ctx.Identifier(0).getText().equals("HashMap") ||
            ctx.Identifier(0).getText().equals("Stack") ||
            ctx.Identifier(0).getText().equals("HashSet")){
            collectionFound = true;
        } else{
            gastBuilder.addFunctionCall(ctx, ctx.Identifier(0).getText());
            gastBuilder.trackClassReference(ctx.Identifier(0).getText());
        }
    }

    @Override
    public void exitClassInstanceCreationExpression(Java8Parser.ClassInstanceCreationExpressionContext ctx) {
        if(collectionFound){
            gastBuilder.collectionInitFound();
            collectionFound = false;
        } else{
            gastBuilder.exitStatementOrExpression();
        }
    }

    @Override
    public void enterClassInstanceCreationExpression_lf_primary(Java8Parser.ClassInstanceCreationExpression_lf_primaryContext ctx) {
        if(ctx.Identifier().getText().equals("ArrayList") || 
            ctx.Identifier().getText().equals("LinkedList") ||
            ctx.Identifier().getText().equals("HashMap") ||
            ctx.Identifier().getText().equals("Stack") ||
            ctx.Identifier().getText().equals("HashSet")){
            collectionFound = true;
        } else{
            gastBuilder.addFunctionCall(ctx, ctx.Identifier().getText());
            gastBuilder.trackClassReference(ctx.Identifier().getText());
        }
    }

    @Override
    public void exitClassInstanceCreationExpression_lf_primary(Java8Parser.ClassInstanceCreationExpression_lf_primaryContext ctx) {
        if(collectionFound){
            gastBuilder.collectionInitFound();
            collectionFound = false;
        } else{
            gastBuilder.exitStatementOrExpression();
        }

    }

    @Override
    public void enterClassInstanceCreationExpression_lfno_primary(Java8Parser.ClassInstanceCreationExpression_lfno_primaryContext ctx) {
        if(ctx.Identifier(0).getText().equals("ArrayList") || 
            ctx.Identifier(0).getText().equals("LinkedList") ||
            ctx.Identifier(0).getText().equals("HashMap") ||
            ctx.Identifier(0).getText().equals("Stack") ||
            ctx.Identifier(0).getText().equals("HashSet")){
            collectionFound = true;
        } else{
            gastBuilder.addFunctionCall(ctx, ctx.Identifier(0).getText());
            gastBuilder.trackClassReference(ctx.Identifier(0).getText());
        }
    }

    @Override
    public void exitClassInstanceCreationExpression_lfno_primary(Java8Parser.ClassInstanceCreationExpression_lfno_primaryContext ctx) {
        if(collectionFound){
            gastBuilder.collectionInitFound();
            collectionFound = false;
        } else{
            gastBuilder.exitStatementOrExpression();
        }
    }

    @Override
    public void enterFieldDeclaration(Java8Parser.FieldDeclarationContext ctx) {
        for(int i = 0; i < ctx.variableDeclaratorList().variableDeclarator().size(); i++){
            gastBuilder.addAttribute(ctx, ctx.variableDeclaratorList().variableDeclarator(i).variableDeclaratorId().getText(), ctx.unannType().getText());
            if(ctx.variableDeclaratorList().variableDeclarator(i).ASSIGN() != null){
                gastBuilder.addAttributeTrackedValue(
                    ctx.variableDeclaratorList().variableDeclarator(i).variableDeclaratorId().getText(), 
                    ctx.unannType().getText(),
                    ctx.variableDeclaratorList().variableDeclarator(i).variableInitializer().getText());
            }
        }
    }

    @Override
    public void enterAssignment(Java8Parser.AssignmentContext ctx) {
        gastBuilder.addAssignment(ctx);
        if(ctx.leftHandSide().getText().matches("this\\.[a-zA-Z0-9_]+")){
            List<String> members = Arrays.asList(ctx.leftHandSide().getText().split("\\."));
            gastBuilder.addVariable(ctx, members.get(0));
            gastBuilder.addSelectedAttributeToThis(members.get(1));
        } else{
            gastBuilder.addVariable(ctx.leftHandSide(), ctx.leftHandSide().getText());
        }
    }

    @Override
    public void exitAssignment(Java8Parser.AssignmentContext ctx) {
        gastBuilder.trackLeftVariableValue();
        //Used in situations where assignment has +=, -=, *=, /=, %=
        gastBuilder.modifyAssignmentWithOperator();
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

    //for(Variable variable : variables)
    @Override
    public void enterEnhancedForStatement(Java8Parser.EnhancedForStatementContext ctx){
        gastBuilder.addConditionalStatement(ctx);
        gastBuilder.addAssignment(ctx);
        gastBuilder.addVariable(ctx, ctx.variableDeclaratorId().getText(), ctx.unannType().getText());
    }

    @Override
    public void exitEnhancedForStatement(Java8Parser.EnhancedForStatementContext ctx){
        gastBuilder.exitStatementOrExpression();
        gastBuilder.exitConditionalStatement();
    }

    @Override
    public void enterEnhancedForStatementNoShortIf(Java8Parser.EnhancedForStatementNoShortIfContext ctx){
        gastBuilder.addConditionalStatement(ctx);
    }

    @Override
    public void exitEnhancedForStatementNoShortIf(Java8Parser.EnhancedForStatementNoShortIfContext ctx){
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
        gastBuilder.addConstructorToClass(ctx.constructorDeclarator().simpleTypeName().Identifier().getText());
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
    public void enterFinally_(Java8Parser.Finally_Context ctx){
        gastBuilder.enterFinallyBlock();
    }

    @Override
    public void exitFinally_(Java8Parser.Finally_Context ctx){
        gastBuilder.exitFinallyBlock();
    }

    /**
     * Switch case statement here will function like a If-ElseIf-Else statement.
     * This allows the tool to reuse the model (as a switch case isn't that different
     * from an if-else) and to also reuse code of a similar logic already implemented!
     */
    @Override
    public void enterSwitchStatement(Java8Parser.SwitchStatementContext ctx){
        this.switchExpression = ctx.expression().getText();
        gastBuilder.addExpression(ctx);
    }

    @Override
    public void exitSwitchStatement(Java8Parser.SwitchStatementContext ctx){
        gastBuilder.exitElseIfOrElseStatement();
            while(this.casesBuilt > 1){
                gastBuilder.exitElseIfOrElseStatement();
                this.casesBuilt--;
            }
            this.casesBuilt = 0;
            gastBuilder.exitIfStatement();
    
        gastBuilder.exitStatementOrExpression();
    }

    @Override
    public void enterSwitchLabel(Java8Parser.SwitchLabelContext ctx){
        if(ctx.CASE() != null){
            gastBuilder.addIfStatement(ctx, ctx.constantExpression().getText(), this.casesBuilt != 0);
            this.casesBuilt++;
        } else if(ctx.DEFAULT() != null){
            gastBuilder.enterElseStatement(ctx);
        }
    }

    @Override
    public void exitSwitchLabel(Java8Parser.SwitchLabelContext ctx){
        if(ctx.CASE() != null){
            if(this.casesBuilt == 1){
                //if statement for first case
                gastBuilder.finishExpressionForCase(false);
            } else{
                //else if statement for subsequent cases
                gastBuilder.finishExpressionForCase(true);
            }
        } 
    }

    /*==================================================================* 
     *      New functions for value tracking (Java only for now)        *
     *==================================================================*/
    /**
     * @function exitRelationalExpression
     * 
     * Checks if the parser sent a relational expression by verifying if it 
     * possesses one of the following operators: <, <=, >, >=. Instanceof is not
     * supported at the moment.
     */
    @Override
    public void exitRelationalExpression(Java8Parser.RelationalExpressionContext ctx){
        if(ctx.GE() != null){
            gastBuilder.addExpressionOperator(ctx.GE().getText());
        } else if(ctx.GT() != null){
            gastBuilder.addExpressionOperator(ctx.GT().getText());
        } else if(ctx.LE() != null){
            gastBuilder.addExpressionOperator(ctx.LE().getText());
        } else if(ctx.LT() != null){
            gastBuilder.addExpressionOperator(ctx.LT().getText());
        } else if(ctx.INSTANCEOF() != null){
            gastBuilder.addExpressionOperator(ctx.INSTANCEOF().getText());
        }
    }

    /**
     * @function exitMultiplicativeExpression
     * 
     * Checks if the parser sent a multiplicative expression by verifying if it 
     * possesses one of the following operators: *, /, %.
     */
    @Override
    public void exitMultiplicativeExpression(Java8Parser.MultiplicativeExpressionContext ctx){
        if(ctx.MUL() != null){
            gastBuilder.addExpressionOperator(ctx.MUL().getText());
        } else if(ctx.DIV() != null){
            gastBuilder.addExpressionOperator(ctx.DIV().getText());
        } else if(ctx.MOD() != null){
            gastBuilder.addExpressionOperator(ctx.MOD().getText());
        }
    }

    /**
     * @function exitEqualityExpression
     * 
     * Checks if the parser sent an equality expression by verifying if it 
     * possesses one of the following operators: ==, !=.
     */
    @Override
    public void exitEqualityExpression(Java8Parser.EqualityExpressionContext ctx){
        if(ctx.EQUAL() != null){
            gastBuilder.addExpressionOperator(ctx.EQUAL().getText());
        } else if(ctx.NOTEQUAL() != null){
            gastBuilder.addExpressionOperator(ctx.NOTEQUAL().getText());
        }
    }

    /**
     * @function exitAdditiveExpression
     * 
     * Checks if the parser sent an additive expression by verifying if it 
     * possesses one of the following operators: +, -.
     */
    @Override
    public void exitAdditiveExpression(Java8Parser.AdditiveExpressionContext ctx){
        if(ctx.ADD() != null){
            gastBuilder.addExpressionOperator(ctx.ADD().getText());
        } else if(ctx.SUB() != null){
            gastBuilder.addExpressionOperator(ctx.SUB().getText());
        }
    }
    
    /**
     * @function exitPreIncrementExpression
     * 
     * Checks if the parser sent a pre-increment expression, e.g, ++x or y = ++x.
     */
    @Override
    public void exitPreIncrementExpression(Java8Parser.PreIncrementExpressionContext ctx){
        if(ctx.INC() != null){
            if(wasVarDecl){
                gastBuilder.createGenStatementForIncDecExpression(ctx);
                genStmtInserted = true;
            }
            gastBuilder.normalIncrementDecrementExpression(ctx, "+", "pre");
        }
    }

    /**
     * @function exitPreDecrementExpression
     * 
     * Checks if the parser sent a pre-decrement expression, e.g, --x or y = --x.
     */
    @Override
    public void exitPreDecrementExpression(Java8Parser.PreDecrementExpressionContext ctx){
        if(ctx.DEC() != null){
            if(wasVarDecl){
                gastBuilder.createGenStatementForIncDecExpression(ctx);
                genStmtInserted = true;
            }
            gastBuilder.normalIncrementDecrementExpression(ctx, "-", "pre");
        }
    }

    /**
     * @function exitPostIncrementExpression
     * 
     * Checks if the parser sent a post-increment expression, e.g, x++.
     */
    @Override
    public void exitPostIncrementExpression(Java8Parser.PostIncrementExpressionContext ctx){
        if(ctx.INC() != null){
            gastBuilder.normalIncrementDecrementExpression(ctx, "+", "post");
        }
    }

    /**
     * @function exitPostDecrementExpression
     * 
     * Checks if the parser sent a post-decrement expression, e.g, x--.
     */
    @Override
    public void exitPostDecrementExpression(Java8Parser.PostDecrementExpressionContext ctx){
        if(ctx.DEC() != null){
            gastBuilder.normalIncrementDecrementExpression(ctx, "-", "post");
        }
    }

    /**
     * @function exitPostIncrementExpression_lf_postfixExpression
     * 
     * Checks if the parser sent a post-increment expression used in an
     * assignment, e.g, y = x++.
     */
    @Override
    public void exitPostIncrementExpression_lf_postfixExpression(Java8Parser.
    PostIncrementExpression_lf_postfixExpressionContext ctx){
        if(ctx.INC() != null){
            if(wasVarDecl){
                gastBuilder.createGenStatementForIncDecExpression(ctx);
                genStmtInserted = true;
            }
            gastBuilder.assignmentIncrementDecrementExpression(ctx, "+", "post");
        }
    }

    /**
     * @function exitPostDecrementExpression_lf_postfixExpression
     * 
     * Checks if the parser sent a post-decrement expression used in an
     * assignment, e.g, y = x--.
     */
    @Override
    public void exitPostDecrementExpression_lf_postfixExpression(Java8Parser.
    PostDecrementExpression_lf_postfixExpressionContext ctx){
        if(ctx.DEC() != null){
            if(wasVarDecl){
                gastBuilder.createGenStatementForIncDecExpression(ctx);
                genStmtInserted = true;
            }
            gastBuilder.assignmentIncrementDecrementExpression(ctx, "-", "post");
        }
    }

    /**
     * @function exitAssignmentOperator
     * 
     * Checks the operator associated with the current Assignment being analyzed.
     * The operators supported are: +=, -=, *=, /=, %= and =.
     */
    @Override
    public void exitAssignmentOperator(Java8Parser.AssignmentOperatorContext ctx){
        if(ctx.ASSIGN() != null){
            gastBuilder.addAssignmentOperator("=");    
        } else if (ctx.ADD_ASSIGN() != null){
            gastBuilder.addAssignmentOperator("+=");
        } else if(ctx.SUB_ASSIGN() != null){
            gastBuilder.addAssignmentOperator("-=");
        } else if(ctx.MUL_ASSIGN() != null){
            gastBuilder.addAssignmentOperator("*=");
        } else if(ctx.DIV_ASSIGN() != null){
            gastBuilder.addAssignmentOperator("/=");
        } else if(ctx.MOD_ASSIGN() != null){
            gastBuilder.addAssignmentOperator("%=");
        }
    }

    /**
     * @function enterLambdaExpression
     * 
     * Checks if we are dealing with a lambda function. The flag 
     * lambdaFunctionDetected will be used @function enterInferredFormalParameterList.
     */
    @Override
    public void enterLambdaExpression(Java8Parser.LambdaExpressionContext ctx){
        if(ctx.ARROW() != null){
            gastBuilder.addLambdaFunction(ctx);
            lambdaFunctionDetected = true;
        }
    }

    /**
     * @function exitLambdaExpression
     * 
     * After analyzing the lambda function, the system is returned to its normal
     * state (all flags regarding lambda functions are turned to false).
     */
    @Override
    public void exitLambdaExpression(Java8Parser.LambdaExpressionContext ctx){
        lambdaFunctionDetected = false;
        gastBuilder.exitLambdaFunction();
    }

    /**
     * @function enterInferredFormalParameterList
     * 
     * Mainly used for lambda functions. Represents its parameters in a list, so
     * to get them, an iteration through it is needed.
     */
    @Override
    public void enterInferredFormalParameterList(Java8Parser.InferredFormalParameterListContext ctx){
        if(lambdaFunctionDetected){
            for(int i = 0; i < ctx.Identifier().size(); i++){
                gastBuilder.addParametersToLambdaFunction(ctx, ctx.Identifier(i).getText());
            }
        }
    }

    /** 
     * @function enterExplicitConstructorInvocation
     * Distiguishes between the super() function and the this() function used in constructors.
     **/
    @Override
    public void enterExplicitConstructorInvocation(Java8Parser.ExplicitConstructorInvocationContext ctx){
        if(ctx.SUPER() != null){
            gastBuilder.addGenericStatement(ctx);
            gastBuilder.addSuperOrThisInConstructor(ctx, true);
        } else if(ctx.THIS() != null){
            gastBuilder.addGenericStatement(ctx);
            gastBuilder.addSuperOrThisInConstructor(ctx, false);
        }
    }

    @Override
    public void exitExplicitConstructorInvocation(Java8Parser.ExplicitConstructorInvocationContext ctx){
        if(ctx.SUPER() != null){
            gastBuilder.exitStatementOrExpression();
            gastBuilder.exitStatementOrExpression();
        } else if(ctx.THIS() != null){
            gastBuilder.exitStatementOrExpression();
            gastBuilder.exitStatementOrExpression();
        }
    }
}