package ist.gt.languages.js.listener;

import ist.gt.gastBuilder.GastBuilder;
import ist.gt.languages.js.parser.JavaScriptParser;
import ist.gt.languages.js.parser.JavaScriptParserBaseListener;
import ist.gt.model.Assignment;
import ist.gt.model.Expression;
import ist.gt.util.Util;

import java.util.Arrays;

import lombok.Data;

@Data
public class JsFileListener extends JavaScriptParserBaseListener {

    private final GastBuilder gastBuilder;
    private boolean lambdaFunctionDetected = false;
    private boolean negativeNumberFound = false;
    private boolean insertedExpression = false;
    private boolean assignmentExpression = false;
    private boolean attributeAccessExpression = false;
    //These 2 are mainly used for pre/post increment-decrement assignment expressions
    private boolean wasAssignmentFound = false;
    private boolean genericStatementInserted = false;
    /* This is used for normal pre/post increment-decrement expressions where
     * GenericStatement is parsed by the Parser (and not inserted by the tool) */
    private boolean genericStatementParsed = false;
    private boolean constructorFound = false;
    //When accessing a variable, the Parser will send the same variable twice which can cause unwanted behavior
    private boolean variableAttributeAccess = false;
    private String variableAccessName = "";

    public JsFileListener(String filename) {
        gastBuilder = new GastBuilder(filename);
    }

    @Override
    public void enterLiteral(JavaScriptParser.LiteralContext ctx) {
        if (ctx.BooleanLiteral() != null) {
            gastBuilder.addConstant(ctx, ctx.getText(), "boolean");
        } else if (ctx.StringLiteral() != null) {
            //Remove quotes from ctx text due to the appearance of double quotes later on
            String rmvQuotes = ctx.getText().substring(1, ctx.getText().length() - 1).replace("\"\"", "\"");
            gastBuilder.addConstant(ctx, rmvQuotes, "string");
        } else if (ctx.NullLiteral() != null) {
            gastBuilder.addConstant(ctx, ctx.getText(), "null");
        } else if (ctx.numericLiteral() != null) {
            if (negativeNumberFound) {
                gastBuilder.addConstant(ctx, "-" + ctx.getText(), "double");
                negativeNumberFound = false;
            } else {
                gastBuilder.addConstant(ctx, ctx.getText(), "double");
            }
        } else if (ctx.TemplateStringLiteral() != null || ctx.RegularExpressionLiteral() != null) {
            String rmvQuotes = ctx.getText().substring(1, ctx.getText().length() - 1).replace("\"\"", "\"");
            gastBuilder.addConstant(ctx, rmvQuotes, "string");
        }
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
        if (ctx.propertyName().getText().equals("constructor")) {
            constructorFound = true;
        }
    }

    @Override
    public void exitMethodDefinition(JavaScriptParser.MethodDefinitionContext ctx) {
        gastBuilder.exitFunctionOrMethodDeclaration();
        if (constructorFound) {
            constructorFound = false;
        }
    }

    @Override
    public void enterGenericExpression(JavaScriptParser.GenericExpressionContext ctx) {
        /* To avoid adding an Expression to another existing Expression (has unnecessary cases)*/
        if (!(gastBuilder.getStatements().peek() instanceof Expression)) {
            gastBuilder.addExpression(ctx);
            insertedExpression = true;
        }

        if (ctx.Plus() != null) {
            gastBuilder.addExpressionOperator(ctx.Plus().getText());
        } else if (ctx.Minus() != null) {
            if (ctx.singleExpression().size() == 1) {
                negativeNumberFound = true;
            } else {
                gastBuilder.addExpressionOperator(ctx.Minus().getText());
            }
        } else if (ctx.Multiply() != null) {
            gastBuilder.addExpressionOperator(ctx.Multiply().getText());
        } else if (ctx.Divide() != null) {
            gastBuilder.addExpressionOperator(ctx.Divide().getText());
        } else if (ctx.Modulus() != null) {
            gastBuilder.addExpressionOperator(ctx.Modulus().getText());
        } else if (ctx.LessThan() != null) {
            gastBuilder.addExpressionOperator(ctx.LessThan().getText());
        } else if (ctx.MoreThan() != null) {
            gastBuilder.addExpressionOperator(ctx.MoreThan().getText());
        } else if (ctx.LessThanEquals() != null) {
            gastBuilder.addExpressionOperator(ctx.LessThanEquals().getText());
        } else if (ctx.GreaterThanEquals() != null) {
            gastBuilder.addExpressionOperator(ctx.GreaterThanEquals().getText());
        } else if (ctx.Equals_() != null) {
            gastBuilder.addExpressionOperator(ctx.Equals_().getText());
        } else if (ctx.NotEquals() != null) {
            gastBuilder.addExpressionOperator(ctx.NotEquals().getText());
        }
    }

    @Override
    public void exitGenericExpression(JavaScriptParser.GenericExpressionContext ctx) {
        if (ctx.PlusPlus() != null) {
            /* GenericStatemet is called for x++/x--/++x/--x but not for, e.g,  y = x++,
             * so it's important to add it in that last case as well */
            if (!genericStatementParsed) {
                gastBuilder.createGenStatementForIncDecExpression(ctx);
                genericStatementInserted = true;
            }

            if (ctx.getText().matches("\\+\\+[a-zA-Z0-9_]+?\\.?[a-zA-Z0-9_]+")) {
                if (wasAssignmentFound) {
                    gastBuilder.assignmentIncrementDecrementExpression(ctx, "+", "pre");
                } else {
                    gastBuilder.switchGenStatementForIncDecExpression(false);
                    gastBuilder.normalIncrementDecrementExpression(ctx, "+", "pre");
                    gastBuilder.switchGenStatementForIncDecExpression(true);
                }
            } else if (ctx.getText().matches("[a-zA-Z0-9_]+?\\.?[a-zA-Z0-9_]+\\+\\+")) {
                if (wasAssignmentFound) {
                    gastBuilder.assignmentIncrementDecrementExpression(ctx, "+", "post");
                } else {
                    gastBuilder.switchGenStatementForIncDecExpression(false);
                    gastBuilder.normalIncrementDecrementExpression(ctx, "+", "post");
                    gastBuilder.switchGenStatementForIncDecExpression(true);
                }
            }

        } else if (ctx.MinusMinus() != null) {
            /* GenericStatemet is called for x++/x--/++x/--x but not for, e.g,  y = x++,
             * so it's important to add it in that last case as well */
            if (!genericStatementParsed) {
                gastBuilder.createGenStatementForIncDecExpression(ctx);
                genericStatementInserted = true;
            }

            if (ctx.getText().matches("--[a-zA-Z0-9_]+?\\.?[a-zA-Z0-9_]+")) {
                if (wasAssignmentFound) {
                    gastBuilder.assignmentIncrementDecrementExpression(ctx, "-", "pre");
                } else {
                    gastBuilder.switchGenStatementForIncDecExpression(false);
                    gastBuilder.normalIncrementDecrementExpression(ctx, "-", "pre");
                    gastBuilder.switchGenStatementForIncDecExpression(true);
                }
            } else if (ctx.getText().matches("[a-zA-Z0-9_]+?\\.?[a-zA-Z0-9_]+--")) {
                if (wasAssignmentFound) {
                    gastBuilder.assignmentIncrementDecrementExpression(ctx, "-", "post");
                } else {
                    gastBuilder.switchGenStatementForIncDecExpression(false);
                    gastBuilder.normalIncrementDecrementExpression(ctx, "-", "post");
                    gastBuilder.switchGenStatementForIncDecExpression(true);
                }
            }
        }

        if (insertedExpression) {
            gastBuilder.trackExpressionValue();
            gastBuilder.exitStatementOrExpression();
            insertedExpression = false;
        }
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
        if (!variableAttributeAccess) {
            if (!gastBuilder.getStatements().isEmpty() && gastBuilder.getStatements().peek() instanceof Assignment) {
                Assignment assignment = (Assignment) gastBuilder.getStatements().pop();
                if (assignment.getLeft() == null) {
                    gastBuilder.getStatements().push(assignment);
                    gastBuilder.addVariable(ctx, ctx.identifier().getText());
                    //Add Expression on right side
                    gastBuilder.addExpression(ctx);
                    this.assignmentExpression = true;
                } else if (assignment.getRight() != null) {
                    gastBuilder.getStatements().push(assignment);
                    gastBuilder.addVariable(ctx, ctx.identifier().getText());
                } else {
                    gastBuilder.getStatements().push(assignment);
                    gastBuilder.addExpression(ctx);
                    this.assignmentExpression = true;
                    gastBuilder.addVariable(ctx, ctx.identifier().getText());
                }
            } else {
                gastBuilder.addVariable(ctx, ctx.identifier().getText());
            }
        } else if (ctx.identifier().getText().equals(variableAccessName)) {
            variableAccessName = "";
            variableAttributeAccess = false;
        }
    }

    @Override
    public void enterAssignmentExpression(JavaScriptParser.AssignmentExpressionContext ctx) {
        gastBuilder.addAssignment(ctx);
        wasAssignmentFound = true;
    }

    @Override
    public void exitAssignmentExpression(JavaScriptParser.AssignmentExpressionContext ctx) {
        if (!gastBuilder.getStatements().isEmpty()) {
            if (this.assignmentExpression) {
                gastBuilder.trackExpressionValue();
                gastBuilder.exitStatementOrExpression();
                this.assignmentExpression = false;
            }

            gastBuilder.checkIfLeftSideIsExpr();
            gastBuilder.trackLeftVariableValue();
            //Used in situations where assignment has +=, -=, *=, /=, %=
            gastBuilder.modifyAssignmentWithOperator();

            gastBuilder.exitStatementOrExpression();
            //Remove inserted GenericStatement from Stack
            if (wasAssignmentFound && genericStatementInserted) {
                gastBuilder.exitStatementOrExpression();
                genericStatementInserted = false;
            }
            wasAssignmentFound = false;
        }
    }

    @Override
    public void enterAssignable(JavaScriptParser.AssignableContext ctx) {
        if (!variableAttributeAccess) {
            if (!gastBuilder.getStatements().isEmpty() && gastBuilder.getStatements().peek() instanceof Assignment) {
                Assignment assignment = (Assignment) gastBuilder.getStatements().pop();
                if (assignment.getLeft() == null) {
                    gastBuilder.getStatements().push(assignment);
                    gastBuilder.addVariable(ctx, ctx.identifier().getText());
                    //Add Expression on right side
                    gastBuilder.addExpression(ctx);
                    this.assignmentExpression = true;
                } else if (assignment.getRight() != null) {
                    gastBuilder.getStatements().push(assignment);
                    gastBuilder.addVariable(ctx, ctx.identifier().getText());
                } else {
                    gastBuilder.getStatements().push(assignment);
                    gastBuilder.addExpression(ctx);
                    this.assignmentExpression = true;
                    gastBuilder.addVariable(ctx, ctx.identifier().getText());
                }
            } else {
                gastBuilder.addVariable(ctx, ctx.identifier().getText());
            }
        } else if (ctx.identifier().getText().equals(variableAccessName)) {
            variableAccessName = "";
            variableAttributeAccess = false;
        }
    }

    @Override
    public void enterVariableDeclaration(JavaScriptParser.VariableDeclarationContext ctx) {
        gastBuilder.addAssignment(ctx);
        wasAssignmentFound = true;
    }

    @Override
    public void exitVariableDeclaration(JavaScriptParser.VariableDeclarationContext ctx) {
        if (!gastBuilder.getStatements().isEmpty()) {
            if (this.assignmentExpression) {
                gastBuilder.trackExpressionValue();
                gastBuilder.exitStatementOrExpression();
                this.assignmentExpression = false;
            }
            gastBuilder.checkIfLeftSideIsExpr();
            gastBuilder.trackLeftVariableValue();
            //Used in situations where assignment has +=, -=, *=, /=, %=
            gastBuilder.modifyAssignmentWithOperator();
            gastBuilder.exitStatementOrExpression();
            //Remove inserted GenericStatement from Stack
            if (wasAssignmentFound && genericStatementInserted) {
                gastBuilder.exitStatementOrExpression();
                genericStatementInserted = false;
            }
            wasAssignmentFound = false;
        }
    }

    @Override
    public void enterFormalParameterArg(JavaScriptParser.FormalParameterArgContext ctx) {
        if (!lambdaFunctionDetected) {
            gastBuilder.addParameter(ctx, ctx.assignable().getText());
        }
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
        if (!gastBuilder.getStatements().isEmpty()) {
            gastBuilder.trackExpressionValue();
            gastBuilder.exitStatementOrExpression();
        }
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
        if (constructorFound) {
            gastBuilder.addAttributeToClass(ctx, ctx.identifierName().getText());
            gastBuilder.addClassAttributeToAssignment(ctx.identifierName().getText());
        }
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
    public void enterAttribute(JavaScriptParser.AttributeContext ctx) {
        gastBuilder.addAttribute(ctx, ctx.propertyName().getText());
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
        if (ctx.Dot() != null) {
            if (!ctx.functionCall().isEmpty()) {
                gastBuilder.addMethodCall(ctx);
                gastBuilder.addVariable(ctx, ctx.singleExpression().getText());
            } else if (!ctx.attributeAccess().isEmpty()) {
                if (!ctx.singleExpression().getText().equals("this")) {
                    if (!(gastBuilder.getStatements().peek() instanceof Expression)) {
                        gastBuilder.addExpression(ctx);
                        this.attributeAccessExpression = true;
                    }
                    gastBuilder.addVariable(ctx, ctx.singleExpression().getText());
                    gastBuilder.addVariable(ctx, ctx.attributeAccess(0).identifierName().getText());
                    variableAttributeAccess = true;
                    variableAccessName = ctx.singleExpression().getText();
                }

                if (constructorFound) {
                    gastBuilder.addAttributeToClass(ctx, ctx.attributeAccess(0).identifierName().getText());
                    gastBuilder.addClassAttributeToAssignment(ctx.attributeAccess(0).identifierName().getText());
                } else {
                    gastBuilder.accessedAttribute();
                }
            }
        } else {
            gastBuilder.addExpression(ctx);
        }
    }

    @Override
    public void exitArgumentsExpression(JavaScriptParser.ArgumentsExpressionContext ctx) {
        if (ctx.Dot() != null) {
            if (!ctx.functionCall().isEmpty()) {
                gastBuilder.exitStatementOrExpression();
            } else if (!ctx.attributeAccess().isEmpty()) {
                if (!ctx.singleExpression().getText().equals("this")) {
                    if (this.attributeAccessExpression) {
                        gastBuilder.exitStatementOrExpression();
                        this.attributeAccessExpression = false;
                    }
                }
            }
        } else {
            gastBuilder.exitStatementOrExpression();
        }
    }

    /**
     * @function exitAssignmentOperator
     *
     * Checks the operator associated with the current Assignment being analyzed.
     * The operators supported are: +=, -=, *=, /=, %= and =.
     */
    @Override
    public void exitAssignmentOperator(JavaScriptParser.AssignmentOperatorContext ctx) {
        if (ctx.PlusAssign() != null) {
            gastBuilder.addAssignmentOperator("+=");
        } else if (ctx.MinusAssign() != null) {
            gastBuilder.addAssignmentOperator("-=");
        } else if (ctx.MultiplyAssign() != null) {
            gastBuilder.addAssignmentOperator("*=");
        } else if (ctx.DivideAssign() != null) {
            gastBuilder.addAssignmentOperator("/=");
        } else if (ctx.ModulusAssign() != null) {
            gastBuilder.addAssignmentOperator("%=");
        }
    }

    /**
     * @function enterArrowFunction
     *
     * Checks if we are dealing with a lambda function. The flag 
     * lambdaFunctionDetected will be used @function enterFormalParameterList.
     */
    @Override
    public void enterArrowFunction(JavaScriptParser.ArrowFunctionContext ctx) {
        if (ctx.ARROW() != null) {
            if (!(gastBuilder.getStatements().peek() instanceof Expression)) {
                gastBuilder.addExpression(ctx);
            }
            gastBuilder.addLambdaFunction(ctx);
            lambdaFunctionDetected = true;
        }
    }

    /**
     * @function exitArrowFunction
     *
     * After analyzing the lambda function, the system is returned to its normal
     * state (all flags regarding lambda functions are turned to false).
     */
    @Override
    public void exitArrowFunction(JavaScriptParser.ArrowFunctionContext ctx) {
        lambdaFunctionDetected = false;
        gastBuilder.exitLambdaFunction();
        if (gastBuilder.getStatements().peek() instanceof Expression && !this.assignmentExpression) {
            gastBuilder.exitStatementOrExpression();
        }
    }

    /**
     * @function enterFormalParameterList
     *
     * Mainly used for lambda functions. Represents its parameters in a list, so
     * to get them, an iteration through it is needed.
     */
    @Override
    public void enterFormalParameterList(JavaScriptParser.FormalParameterListContext ctx) {
        if (lambdaFunctionDetected) {
            for (int i = 0; i < ctx.formalParameterArg().size(); i++) {
                gastBuilder.addParametersToLambdaFunction(ctx, ctx.formalParameterArg(i).getText());
            }
        }
    }

    @Override
    public void enterExpressionStatement(JavaScriptParser.ExpressionStatementContext ctx) {
        gastBuilder.addGenericStatement(ctx);
        genericStatementParsed = true;
    }

    @Override
    public void exitExpressionStatement(JavaScriptParser.ExpressionStatementContext ctx) {
        gastBuilder.exitStatementOrExpression();
        genericStatementParsed = false;
    }

    @Override
    public void enterNewExpression(JavaScriptParser.NewExpressionContext ctx) {
        String className = Arrays.asList(ctx.singleExpression().getText().split("\\(")).getFirst();
        gastBuilder.addExpression(ctx);
        gastBuilder.trackClassReference(className);
    }

    @Override
    public void exitNewExpression(JavaScriptParser.NewExpressionContext ctx) {
        gastBuilder.exitStatementOrExpression();
    }
}
