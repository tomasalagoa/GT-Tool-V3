package ist.gt.gastBuilder;

import ist.gt.model.Class;
import ist.gt.model.*;
import ist.gt.util.Util;
import lombok.Data;

import org.antlr.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.Stack;

@Data
public class GastBuilder {

    private final Stack<Statement> statements = new Stack<>();
    private Function currentFunction;
    private Stack<CodeBlock> codeBlocks = new Stack<>();
    private Stack<IfStatement> ifStatements = new Stack<>();
    private final File file;
    private final Stack<Class> classes = new Stack<>();
    private final Stack<TryCatch> tryCatches = new Stack<>();

    private <E> void popIfNotEmpty(Stack<E> stack) {
        if (!stack.empty())
            stack.pop();
    }

    public void addImportedFile(String fileName) {
        file.getImportedFiles().add(Util.removeQuotes(fileName));
    }

    private void processExpression(Expression expression) {
        if (!statements.empty())
            statements.peek().accept(new ExpressionVisitor(expression));
    }

    public void exitFunctionOrMethodDeclaration() {
        currentFunction = file.getRootFunc();
        popIfNotEmpty(codeBlocks);
    }

    public void exitConditionalStatement() {
        popIfNotEmpty(codeBlocks);
        popIfNotEmpty(statements);
    }

    public void enterElseStatement(ParserRuleContext ctx) {
        ifStatements.peek().getElseBlock().setLine(ctx.start.getLine());
        codeBlocks.push(ifStatements.peek().getElseBlock());
    }

    public void exitElseIfOrElseStatement() {
        popIfNotEmpty(codeBlocks);
    }

    public void exitIfStatement() {
        ifStatements.pop();
        exitConditionalStatement();
    }

    public void exitStatementOrExpression() {
        popIfNotEmpty(statements);
    }

    public void exitClass() {
        classes.pop();
    }

    public GastBuilder(String filename) {
        file = new File(filename);
        currentFunction = file.getRootFunc();
        codeBlocks.push(file.getRootFunc().getCodeBlock());
    }

    public void enterCatchBlock() {
        popIfNotEmpty(codeBlocks);
        CodeBlock block = new CodeBlock();
        tryCatches.peek().getCatchBlock().add(block);
        codeBlocks.push(block);
    }

    public void exitCatchBlock() {
        popIfNotEmpty(codeBlocks);
    }

    public void exitTryCatchBlock() {
        tryCatches.pop();
    }


    public FunctionCall addFunctionCall(ParserRuleContext ctx, String name) {
        var functionCall = new FunctionCall(ctx, name);
        processExpression(functionCall);
        statements.push(functionCall);
        return functionCall;
    }


    public void addExpression(ParserRuleContext ctx) {
        Expression expression = new Expression(ctx);
        processExpression(expression);
        statements.push(expression);
    }


    public Assignment addAssignment(ParserRuleContext ctx) {
        Assignment assignment = new Assignment(ctx);
        codeBlocks.peek().getStatements().add(assignment);
        statements.push(assignment);
        return assignment;
    }


    public ReturnStatement addReturnStatement(ParserRuleContext ctx) {
        ReturnStatement stmt = new ReturnStatement(ctx);
        codeBlocks.peek().getStatements().add(stmt);
        statements.push(stmt);
        return stmt;
    }


    public Variable addVariable(ParserRuleContext ctx, String name) {
        Variable var = new Variable(ctx, name);
        //Update var's tracked value info in case the variable was
        //already analysed
        if(currentFunction.getVariables().containsKey(var.getName())){
            var = currentFunction.getVariables().get(var.getName());
        }
        //In case a parameter's value is overriden (with an assignment), we will
        //not know its type unless we retrieve it 
        else if(!currentFunction.getVariables().containsKey(var.getName()) &&
        currentFunction.getParameters().containsKey(var.getName())){
            var = currentFunction.getParameters().get(var.getName());
        }
        currentFunction.getVariables().putIfAbsent(var.getName(), var);
        processExpression(var);
        return var;
    }


    public Variable addVariable(ParserRuleContext ctx, String name, String type) {
        Variable var = addVariable(ctx, name);
        var.setType(type);
        return var;
    }

    public Parameter addParameter(ParserRuleContext ctx, String name) {
        Parameter param = new Parameter(ctx, name);
        statements.clear();
        currentFunction.getParameters().put(param.getName(), param);
        return param;
    }

    public Variable addParameter(ParserRuleContext ctx, String name, String type) {
        Parameter parameter = addParameter(ctx, name);
        parameter.setType(type);
        return parameter;
    }

    public Constant addConstant(ParserRuleContext ctx, String value, String type) {
        var constant = new Constant(ctx, value, type);
        processExpression(constant);
        return constant;
    }


    public Function addFunction(ParserRuleContext ctx, String name) {
        var function = new Function(name, ctx);
        currentFunction = function;
        statements.clear();
        codeBlocks.push(function.getCodeBlock());
        if (classes.empty())
            file.getFunctions().put(function.getName(), function);
        else
            classes.peek().getMethods().put(function.getName(), function);
        return function;
    }


    public Function addFunction(ParserRuleContext ctx, String name, String returnType) {
        var function = addFunction(ctx, name);
        function.setReturnType(returnType);
        return function;
    }


    public Class addClass(ParserRuleContext ctx, String name) {
        var aClass = new Class(ctx, name);
        statements.clear();
        file.getClasses().put(aClass.getName(), aClass);
        classes.push(aClass);
        return aClass;
    }

    public Class addClass(ParserRuleContext ctx, String name, String superClass) {
        var aClass = addClass(ctx, name);
        aClass.setSuperClass(superClass);
        return aClass;
    }


    public IfStatement addIfStatement(ParserRuleContext ctx, String condition, boolean isElseIf) {
        var ifStatement = new IfStatement(ctx, condition, isElseIf);
        if (ifStatement.isElseIf()) {
            ifStatements.peek().getElseIfs().add(ifStatement);
        } else {
            ifStatements.push(ifStatement);
            codeBlocks.peek().getStatements().add(ifStatement);
        }
        setConditionalStmt(ifStatement);
        return ifStatement;
    }


    public void addConditionalStatement(ParserRuleContext ctx) {
        var conditionalStatement = new ConditionalStatement(ctx);
        codeBlocks.peek().getStatements().add(conditionalStatement);
        setConditionalStmt(conditionalStatement);
    }


    public GenericStatement addGenericStatement(ParserRuleContext ctx) {
        var statement = new GenericStatement(ctx);
        codeBlocks.peek().getStatements().add(statement);
        statements.push(statement);
        return statement;
    }

    private void setConditionalStmt(ConditionalStatement stmt) {
        codeBlocks.push(stmt.getCodeBlock());
        statements.push(stmt);
    }


    public NewExpression addNewExpression(ParserRuleContext ctx, String className) {
        NewExpression newExpression = new NewExpression(ctx, className);
        processExpression(newExpression);
        statements.push(newExpression);
        return newExpression;
    }


    public AttributeAccess addAttributeAccess(ParserRuleContext ctx, String identifier) {
        AttributeAccess attributeAccess = new AttributeAccess(ctx, identifier);
        processExpression(attributeAccess);
        statements.push(attributeAccess);
        return attributeAccess;
    }


    public MethodCallExpression addMethodCall(ParserRuleContext ctx) {
        var methodCall = new MethodCallExpression(ctx);
        processExpression(methodCall);
        statements.push(methodCall);
        return methodCall;
    }


    public ThrowException addThrowException(ParserRuleContext ctx) {
        ThrowException throwException = new ThrowException(ctx);
        codeBlocks.peek().getStatements().add(throwException);
        statements.push(throwException);
        return throwException;
    }


    public TryCatch addTryCatch(ParserRuleContext ctx) {
        var tryCatch = new TryCatch(ctx);
        codeBlocks.peek().getStatements().add(tryCatch);
        codeBlocks.push(tryCatch.getTryBlock());
        tryCatches.push(tryCatch);
        return tryCatch;
    }


    public Attribute addAttribute(ParserRuleContext ctx, String name) {
        var attribute = new Attribute(ctx, name);
        classes.peek().getAttributes().put(attribute.getName(), attribute);
        processExpression(attribute);
        statements.push(attribute);
        return attribute;
    }

    public Attribute addAttribute(ParserRuleContext ctx, String name, String type) {
        var attribute = addAttribute(ctx, name);
        attribute.setType(type);
        return attribute;
    }

    
    /* NEW FUNCTIONS FOR VALUE TRACKING (Java only for now)
    */
    //TODO Verify if it is possible to make the code cleaner later
    public void evaluateRelationalExpression(ParserRuleContext ctx, String operator){
        Expression expression = (Expression) statements.pop();
        Expression expr1 = expression.getMembers().get(0);
        Expression expr2 = expression.getMembers().get(1);
        Boolean result;
        Double value, anotherValue;

        if(expr1.getTrackedValue() == null || expr2.getTrackedValue() == null){
            statements.push(expression);
            return;
        }

        switch(operator){
            case ">":
                //Do something
                System.out.println("GT Expression");
                value = expr1.getType().equals("char") ? (char)expr1.getTrackedValue().toCharArray()[1] : Double.valueOf(expr1.getTrackedValue());
                anotherValue = expr2.getType().equals("char") ? (char)expr2.getTrackedValue().toCharArray()[1] : Double.valueOf(expr2.getTrackedValue());
                result = value > anotherValue;
                expression.setTrackedValue(result.toString());
                expression.setType("boolean");
                statements.push(expression);
                return;
            case ">=":
                //Do something
                System.out.println("GE Expression");
                value = expr1.getType().equals("char") ? (char)expr1.getTrackedValue().toCharArray()[1] : Double.valueOf(expr1.getTrackedValue());
                anotherValue = expr2.getType().equals("char") ? (char)expr2.getTrackedValue().toCharArray()[1] : Double.valueOf(expr2.getTrackedValue());
                result = value >= anotherValue;
                expression.setTrackedValue(result.toString());
                expression.setType("boolean");
                statements.push(expression);
                return;
            case "<":
                //Do something
                System.out.println("LT Expression");
                value = expr1.getType().equals("char") ? (char)expr1.getTrackedValue().toCharArray()[1] : Double.valueOf(expr1.getTrackedValue());
                anotherValue = expr2.getType().equals("char") ? (char)expr2.getTrackedValue().toCharArray()[1] : Double.valueOf(expr2.getTrackedValue());
                result = value < anotherValue;
                expression.setTrackedValue(result.toString());
                expression.setType("boolean");
                statements.push(expression);
                return;
            case "<=":
                //Do something
                System.out.println("LE Expression");
                value = expr1.getType().equals("char") ? (char)expr1.getTrackedValue().toCharArray()[1] : Double.valueOf(expr1.getTrackedValue());
                anotherValue = expr2.getType().equals("char") ? (char)expr2.getTrackedValue().toCharArray()[1] : Double.valueOf(expr2.getTrackedValue());
                result = value <= anotherValue;
                expression.setTrackedValue(result.toString());
                expression.setType("boolean");
                statements.push(expression);
                return;
            //TODO Should I care about this one? Instanceof seems a tough nut to crack
            case "instanceof":
                //Do something
                System.out.println("INSTANCEOF Expression");
                statements.push(expression);
                return;
            default:
                System.out.println("Unknown Relational operator: " + operator);
                return;
        }
    
    }


    public void evaluateMultiplicativeExpression(ParserRuleContext ctx, String operator){
        Expression expression = (Expression) statements.pop();
        Expression expr1 = expression.getMembers().get(0);
        Expression expr2 = expression.getMembers().get(1);
        Double result, value, anotherValue;

        if(expr1.getTrackedValue() == null || expr2.getTrackedValue() == null){
            statements.push(expression);
            return;
        }

        switch(operator){
            case "*":
                //Do something
                System.out.println("MUL Expression");
                value = expr1.getType().equals("char") ? (char)expr1.getTrackedValue().toCharArray()[1] : Double.valueOf(expr1.getTrackedValue());
                anotherValue = expr2.getType().equals("char") ? (char)expr2.getTrackedValue().toCharArray()[1] : Double.valueOf(expr2.getTrackedValue());
                result = value * anotherValue;
                expression.setTrackedValue(result.toString());
                expression.setType("double");
                statements.push(expression);
                return;
            case "/":
                //Do something
                System.out.println("DIV Expression");
                value = expr1.getType().equals("char") ? (char)expr1.getTrackedValue().toCharArray()[1] : Double.valueOf(expr1.getTrackedValue());
                anotherValue = expr2.getType().equals("char") ? (char)expr2.getTrackedValue().toCharArray()[1] : Double.valueOf(expr2.getTrackedValue());
                result = value / anotherValue;
                expression.setTrackedValue(result.toString());
                expression.setType("double");
                statements.push(expression);
                return;
            case "%":
                //Do something
                System.out.println("MOD Expression");
                value = expr1.getType().equals("char") ? (char)expr1.getTrackedValue().toCharArray()[1] : Double.valueOf(expr1.getTrackedValue());
                anotherValue = expr2.getType().equals("char") ? (char)expr2.getTrackedValue().toCharArray()[1] : Double.valueOf(expr2.getTrackedValue());
                result = value % anotherValue;
                expression.setTrackedValue(result.toString());
                expression.setType("double");
                statements.push(expression);
                return;
            default:
                System.out.println("Unknown Multiplicative operator: " + operator);
                return;
        }
    }


    public void evaluateAdditiveExpression(ParserRuleContext ctx, String operator){
        Expression expression = (Expression) statements.pop();
        Expression expr1 = expression.getMembers().get(0);
        Expression expr2 = expression.getMembers().get(1);
        Double value, anotherValue;
        Object result = null;
        String type = null;

        if(expr1.getTrackedValue() == null || expr2.getTrackedValue() == null){
            statements.push(expression);
            return;
        }

        switch(operator){
            case "+":
                //Do something
                System.out.println("ADD Expression");
                if((expr1.getType().equals("int") ||
                expr1.getType().equals("double") || expr1.getType().equals("char")) && 
                (expr2.getType().equals("int") || expr2.getType().equals("double") ||
                expr2.getType().equals("char"))){
                    value = expr1.getType().equals("char") ? (char)expr1.getTrackedValue().toCharArray()[1] : Double.valueOf(expr1.getTrackedValue());
                    anotherValue = expr2.getType().equals("char") ? (char)expr2.getTrackedValue().toCharArray()[1] : Double.valueOf(expr2.getTrackedValue());
                    result = value + anotherValue;
                    type = "double"; 
                } else if(expr1.getType().equals("String") || expr2.getType().equals("String")){
                    result = expr1.getTrackedValue() + expr2.getTrackedValue();
                    System.out.println(result.toString());
                    type = "String";
                } else {
                    statements.push(expression);
                    return;
                }

                expression.setTrackedValue(result.toString());
                expression.setType(type);
                statements.push(expression);
                return;
            case "-":
                //Do something
                System.out.println("SUB Expression");
                value = expr1.getType().equals("char") ? (char)expr1.getTrackedValue().toCharArray()[1] : Double.valueOf(expr1.getTrackedValue());
                anotherValue = expr2.getType().equals("char") ? (char)expr2.getTrackedValue().toCharArray()[1] : Double.valueOf(expr2.getTrackedValue());    
                result = value - anotherValue;
                expression.setTrackedValue(result.toString());
                expression.setType("double");
                statements.push(expression);
                return;
            default:
                System.out.println("Unknown Additive operator: " + operator);
                return;
        }
    }


    public void evaluateEqualityExpression(ParserRuleContext ctx, String operator){
        Expression expression = (Expression) statements.pop();
        Expression expr1 = expression.getMembers().get(0);
        Expression expr2 = expression.getMembers().get(1); 
        Object result;
        double epsilon = 0.000001d;

        if(expr1.getTrackedValue() == null || expr2.getTrackedValue() == null){
            statements.push(expression);
            return;
        }

        switch(operator){
            case "==":
                System.out.println("EQUALS");
                if((expr1.getType().equals("int") ||
                expr1.getType().equals("double") || expr1.getType().equals("char")) && 
                (expr2.getType().equals("int") || expr2.getType().equals("double") ||
                expr2.getType().equals("char"))){
                    Double value, anotherValue;
                    value = expr1.getType().equals("char") ? 
                    (char)expr1.getTrackedValue().toCharArray()[1] : 
                    Double.valueOf(expr1.getTrackedValue());
                    anotherValue = expr2.getType().equals("char") ? 
                    (char)expr2.getTrackedValue().toCharArray()[1] : 
                    Double.valueOf(expr2.getTrackedValue());
                    result = Math.abs(value - anotherValue) < epsilon;
                } else if(expr1.getType().equals("boolean") && expr2.getType().equals("boolean")){
                    result = Boolean.valueOf(expr1.getTrackedValue()) == Boolean.valueOf(expr2.getTrackedValue());
                } else if(expr1.getType().equals("String") && expr2.getType().equals("String")){
                    result = expr1.getTrackedValue().equals(expr2.getTrackedValue());
                } else {
                    statements.push(expression);
                    return;
                }
                expression.setTrackedValue(result.toString());
                expression.setType("boolean");
                statements.push(expression);
                return;
            case "!=":
                System.out.println("NOTEQUALS");
                if((expr1.getType().equals("int") ||
                expr1.getType().equals("double") || expr1.getType().equals("char")) && 
                (expr2.getType().equals("int") || expr2.getType().equals("double") ||
                expr2.getType().equals("char"))){
                    Double value, anotherValue;
                    value = expr1.getType().equals("char") ? 
                    (char)expr1.getTrackedValue().toCharArray()[1] : 
                    Double.valueOf(expr1.getTrackedValue());
                    anotherValue = expr2.getType().equals("char") ? 
                    (char)expr2.getTrackedValue().toCharArray()[1] : 
                    Double.valueOf(expr2.getTrackedValue());
                    result = Math.abs(value - anotherValue) >= epsilon;
                } else if(expr1.getType().equals("boolean") && expr2.getType().equals("boolean")){
                    result = Boolean.valueOf(expr1.getTrackedValue()) != Boolean.valueOf(expr2.getTrackedValue());
                } else if(expr1.getType().equals("String") && expr2.getType().equals("String")){
                    result = !expr1.getTrackedValue().equals(expr2.getTrackedValue());
                } else {
                    statements.push(expression);
                    return;
                }
                expression.setTrackedValue(result.toString());
                expression.setType("boolean");
                statements.push(expression);
                return;
            default:
                System.out.println("Unknown Equality operator: " + operator);
                statements.push(expression);
                return;
        }
    }


    public void trackLeftVariableValue(){
        //Updating left variable value in assignment and in current function
        Assignment assignment = (Assignment) statements.pop();
        if(assignment.getRight() != null){
            Variable tmpVar = (Variable) assignment.getLeft();
            Variable var = currentFunction.getVariables().get(tmpVar.getName());
            var.setTrackedValue(assignment.getRight().getTrackedValue());
            currentFunction.getVariables().replace(var.getName(), var);
            assignment.setLeft(var);
        }
        statements.push(assignment);
    }


    public void trackExpressionValue(){
        Expression expression = (Expression) statements.pop();
        //Most likely this expression only has one element
        if(expression.getTrackedValue() == null && expression.getMembers().size() == 1){
            expression.setTrackedValue(expression.getMembers().get(0).getTrackedValue());
            expression.setType(expression.getMembers().get(0).getType());
        }
        statements.push(expression);
    }
}
