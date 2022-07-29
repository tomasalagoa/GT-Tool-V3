package ist.gt.gastBuilder;

import ist.gt.model.Class;
import ist.gt.model.*;
import ist.gt.util.Util;
import lombok.Data;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

@Data
public class GastBuilder {

    private final Stack<Statement> statements = new Stack<>();
    private Function currentFunction;
    private Stack<CodeBlock> codeBlocks = new Stack<>();
    private Stack<IfStatement> ifStatements = new Stack<>();
    private final File file;
    private final Stack<Class> classes = new Stack<>();
    private ArrayList<Class> analyzedClasses = new ArrayList<>();
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
        //In case a parameter's value is overwriten (with an assignment), we will
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
        analyzedClasses.add(aClass);
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

    /*==================================================================* 
     *      New functions for value tracking (Java only for now)        *
     *==================================================================*/
    /**
     * @function trackClassReference
     * 
     * Updates the expression (which will be a variable) with a reference to the
     * class it is being instantiated with (through @param className ), basically 
     * doing value tracking for class instances. Right now, it is called 
     * whenever a newExpression is used.
     */
     public void trackClassReference(String className){
        NewExpression newExpression = null;
        if(statements.peek() instanceof NewExpression){
            newExpression = (NewExpression) statements.pop();
        }

        Expression expression = (Expression) statements.pop();
        Class trackedClass = new Class(className);
        Class originalClass = null;

        for(Class c : this.classes){
            if(c.getName().equals(className)){
                originalClass = c;
                break;
            }
        }

        if(originalClass != null){
            trackedClass.setSuperClass(originalClass.getSuperClass());
            HashMap<String, Attribute> superclassAttributes = getAllSuperclassesAttributes(
                originalClass.getSuperClass());
            //Needed so that attributes do not share same reference between different instances
            HashMap<String, Attribute> attributes = new HashMap<String, Attribute>();
            for(Attribute attribute : originalClass.getAttributes().values()){
                Attribute newAttribute = createNewAttributeReference(attribute);
                attributes.put(newAttribute.getName(), newAttribute);
            }

            if(superclassAttributes != null){
                for(Attribute attribute : superclassAttributes.values()){
                    attributes.put(attribute.getName(), attribute);
                }
            }
            trackedClass.setAttributes(attributes);
            trackedClass.setMethods(new HashMap<String, Function>(originalClass.getMethods()));

            expression.setClassReference(trackedClass);
            expression.setType(trackedClass.getName());
        }
        
        if(newExpression != null){
            statements.push(newExpression);
        }

        statements.push(expression);
     }

     /**
      * @function getAllSuperclassesAttributes
      * @param superclassName
      * @return HashMap<String, Attribute>
      *
      * Receives the name of a given superclass and returns its attributes + the ones of its
      * superclass (and so on) if applicable.
      */
     public HashMap<String, Attribute> getAllSuperclassesAttributes(String superclassName){
        if(superclassName == null){
            return null;
        } else{
            HashMap<String, Attribute> attributes = new HashMap<String, Attribute>();
            ArrayList<Class> superclasses = new ArrayList<Class>();
            Boolean noMoreSupers = false;
            
            while(!noMoreSupers){
                for(Class c : this.analyzedClasses){
                    if(c.getName().matches(superclassName)){
                        superclasses.add(c);
                        if(c.getSuperClass() != null){
                            superclassName = c.getSuperClass();
                            break;
                        } else{
                            noMoreSupers = true;
                            break;
                        }
                    }
                }
            }

            for(Class c : superclasses){
                for(Attribute attribute : c.getAttributes().values()){
                    Attribute newAttribute = createNewAttributeReference(attribute);
                    attributes.put(newAttribute.getName(), newAttribute);
                }
            }
            return attributes;
        }
     }

     /**
      * @function createNewAttributeReference
      * @param attribute
      * @return Attribute
      *
      * Represents the creation of a new reference for the @param attribute.
      * The goal here is to create a new reference for a given attribute (whenever 
      * a new class instance is created) so that it is not the same as the one stored 
      * in the classes field of GastBuilder.
      */
     public Attribute createNewAttributeReference(Attribute attribute){
        Attribute newAttribute = new Attribute();
        newAttribute.setName(attribute.getName());
        newAttribute.setType(attribute.getType());
        newAttribute.setTainted(attribute.isTainted());
        newAttribute.setLine(attribute.getLine());
        newAttribute.setText(attribute.getText());
        return newAttribute;
     }

    /**
     * @function trackLeftVariableValue
     * 
     * Passes the value in the right side of an assignment to the left side,
     * if the right side exists (i.e could just be an empty variable declaration)
     * or if it has a type meaning its value could be tracked earlier (will be
     * tracked later if not). Also supports attribute accesses in either side of
     * the assignment.
     */
    public void trackLeftVariableValue(){
        Assignment assignment = (Assignment) statements.pop();

        if(assignment.getRight() != null && assignment.getRight().getType() != null){
            Variable var = (Variable) assignment.getLeft();
            //Variable var = currentFunction.getVariables().get(tmpVar.getName());
            //Is the right-side a simple variable?
            if(assignment.getRight().getTrackedValue() != null){
                //Check if left has class reference or not. If it has, update is done at the attribute's value
                if(assignment.getLeft().getClassReference() == null){
                    var.setTrackedValue(assignment.getRight().getTrackedValue());
                    var.setType(assignment.getRight().getType());
                }
                else{
                    String leftAttribute = assignment.getLeft().getSelectedAttribute();
                    var.getClassReference().getAttributes().get(leftAttribute)
                    .setTrackedValue(assignment.getRight().getTrackedValue());
                    
                    var.getClassReference().getAttributes().get(leftAttribute)
                    .setType(assignment.getRight().getType());
                }
            }

            else if(assignment.getRight().getClassReference() != null){
                /*Have to watch out for the following cases: left-side is a simple variable so it becomes 
                 * a class instance if right-side does not access any attribute OR 
                 * left-side still is a simple variable but right-side accesses an attribute OR 
                 * left-side accesses an attribute but right-side doesnt so that attribute is a class instance OR 
                 * left-side & right-side both access an attribute
                 */
                if(assignment.getRight().getSelectedAttribute() == null){
                    if(assignment.getLeft().getClassReference() != null && 
                    assignment.getLeft().getSelectedAttribute() != null){
                        String leftAttribute = assignment.getLeft().getSelectedAttribute();
                        var.getClassReference().getAttributes().get(leftAttribute)
                        .setClassReference(assignment.getRight().getClassReference());
                        
                        var.getClassReference().getAttributes().get(leftAttribute)
                        .setType(assignment.getRight().getType());
                    }
                    else{
                        var.setClassReference(assignment.getRight().getClassReference());
                        var.setType(assignment.getRight().getType());
                    }
                }
                else{
                    if(assignment.getLeft().getClassReference() != null && 
                    assignment.getLeft().getSelectedAttribute() != null){
                        String leftAttribute = assignment.getLeft().getSelectedAttribute();
                        String rightAttribute = assignment.getRight().getSelectedAttribute();
                        var.getClassReference().getAttributes().get(leftAttribute)
                        .setTrackedValue(assignment.getRight().getClassReference()
                        .getAttributes().get(rightAttribute).getTrackedValue());
                        
                        var.getClassReference().getAttributes().get(leftAttribute)
                        .setType(assignment.getRight().getClassReference()
                        .getAttributes().get(rightAttribute).getType());
                    } 
                    else{
                        String rightAttribute = assignment.getRight().getSelectedAttribute();
                        var.setTrackedValue(assignment.getRight().getClassReference()
                        .getAttributes().get(rightAttribute).getTrackedValue());
                        var.setType(assignment.getRight().getClassReference()
                        .getAttributes().get(rightAttribute).getType());
                    }
                }
            }

            if(var.getTrackedValue() != null || var.getClassReference() != null){
                currentFunction.getVariables().replace(var.getName(), var);
                assignment.setLeft(var);
            }
        }
        statements.push(assignment);
    }

    /**
     * @function trackExpressionValue
     * 
     * Updates the value of current Expression. Can only be made if the current
     * Expression does not possess a tracked value (or class reference) yet and if it only has one 
     * element (Variable, Parameter, etc), making it able to immediately get its
     * value in this stage.
    */
    public void trackExpressionValue(){
        Expression expression = (Expression) statements.pop();
        //Most likely this expression only has one element
        if(expression.getMembers().size() == 1){
            if(expression.getTrackedValue() == null && expression.getMembers()
            .get(0).getClassReference() == null){
                expression.setTrackedValue(expression.getMembers().get(0).getTrackedValue());
            } 
            else if(expression.getMembers().get(0).getClassReference() != null && 
                        expression.getClassReference() == null){
                expression.setClassReference(expression.getMembers().get(0).getClassReference());
            }
            expression.setType(expression.getMembers().get(0).getType());
        }

        statements.push(expression);
    }

    /**
     * @function addExpressionOperator
     * @param operator (String)
     * 
     * Gives the @param operator to the current Expression. This auxiliary 
     * function's purpose is to give the current Expression the operator related
     * to the operation it is being used: relational (<, <=, >, >=), 
     * multiplicative (*, /, %), additive (+, -), equality (==, !=) to help in
     * tracking its value in TaintVisitor.
     */ 
    public void addExpressionOperator(String operator){
        Expression expression = (Expression) statements.pop();
        expression.setOperator(operator);
        statements.push(expression);
    }

    /**
     * @function addAssigmentOperator
     * @param operator (String)
     * 
     * Gives the @param operator to the current Assignment. This auxiliary 
     * function's purpose is to simplify the assignments that use the operators:
     * +=, -=, *=, /=, %=, giving it to the current Assignment. More info at
     * @function modifyAssignmentWithOperator.
     */
    public void addAssignmentOperator(String operator){
        Assignment assignment = (Assignment) statements.pop();
        assignment.setOperator(operator);
        statements.push(assignment);
    }

    /** 
     * @function modifyAssignmentWithOperator
     * 
     * This function modifies a given assignment if it possesses one of the
     * following operators: +=, -=, *=, /=, %=. The assignment, for example
     * y += x, is then transformed in an equivalent, for example y = y + x.
    */
    public void modifyAssignmentWithOperator(){
        Assignment assignment = (Assignment) statements.pop();
        if(assignment.getOperator() != null){
            if(assignment.getOperator().equals("=")){
                statements.push(assignment);
                return;
            } else{
                Variable variable = (Variable) assignment.getLeft();
                Expression expression = assignment.getRight();
                expression.getMembers().add(0, variable);

                switch(assignment.getOperator()){
                    case "+=":
                        expression.setOperator("+");
                        break;
                    case "-=":
                        expression.setOperator("-");
                        break;
                    case "*=":
                        expression.setOperator("*");
                        break;
                    case "/=":
                        expression.setOperator("/");
                        break;
                    case "%=":
                        expression.setOperator("%");
                        break;
                    default:
                        statements.push(assignment);
                        return;
                }

                assignment.setRight(expression);
                statements.push(assignment);
            }
        } else {
            statements.push(assignment);
        }
    }

    /**
     * @function normalIncrementDecrementExpression
     * @params ctx (ParserRuleContext), operator (String), condType (String)
     * 
     * This function is used to simplify & transform pre(post)-increments(decrements)
     * when they belong only to an expression (and GenericStatement). This means that they
     * are not used in an Assignment, which is covered in @function 
     * assignmentIncrementDecrementExpression. x++/x--/++x/--x is transformed to
     * x = x +/- 1.
     * The way to know if this does not belong to an Assignment is by analyzing the 
     * stack: if the last element is a GenericStatement then it is only the 
     * expression (x++), if it is an Expression then we are in the Assignment 
     * (y = x++) case.
     */
    public void normalIncrementDecrementExpression(ParserRuleContext ctx, String operator, String condType){
        //This is the case where we have, e.g., x = ++id, so it does not belong in this function.
        if(statements.peek() instanceof Expression){
            assignmentIncrementDecrementExpression(ctx, operator, condType);
            return;
        }
        Expression expression = new Expression(ctx);
        Assignment assignment = new Assignment(ctx);
        Constant constant = new Constant(ctx, "1", "int");
        GenericStatement genStmt = (GenericStatement) statements.pop();
        Variable variable = (Variable) genStmt.getStatement();

        expression.getMembers().add(variable);
        expression.getMembers().add(constant);
        assignment.setLeft(variable);
        expression.setType("int");

        assignment.setRight(expression);
        genStmt.setStatement(assignment);

        switch(operator){
            case "+":
                expression.setOperator("+");
                break;
            case "-":
                expression.setOperator("-");
                break;
            default:
                System.out.println("Invalid operator");
                return;
        }

        statements.push(genStmt);
    }

    /**
     * @function assignmentIncrementDecrementExpression
     * @params ctx (ParserRuleContext), operator (String), condType (String)
     * 
     * This function is used to simplify & transform pre(post)-increments(decrements)
     * when they belong to an Assignment.
     * The @param condType allows the function to identify which type of 
     * increment/decrement it is dealing with.
     * For example, if it has y = x++ then it transforms this to 2 Assignments: 
     * y = x & x = x + 1. If it has y = ++x then it is transformed to: x = x + 1
     * & y = x;
     */
    public void assignmentIncrementDecrementExpression(ParserRuleContext ctx, String operator, String condType){ 
        Expression expression = new Expression(ctx);
        Assignment assignment = new Assignment(ctx);
        Constant constant = new Constant(ctx, "1", "int");
        Expression assignExp = (Expression) statements.pop();
        Assignment assignmentStack = (Assignment) statements.pop();
        GenericStatement genStmt = (GenericStatement) statements.pop();
        Variable variable = (Variable) assignExp.getMembers().get(0);
        
        expression.getMembers().add(variable);
        expression.getMembers().add(constant);
        
        switch(operator){
            case "+":
                expression.setOperator("+");
                break;
            case "-":
                expression.setOperator("-");
                break;
            default:
                //Should never enter here!
                System.out.println("Invalid operator");
                return;
        }
        //x = ++id; -> id = id + 1; x = id;
        if(condType.equals("pre")){
            assignment.setLeft(variable);
            assignment.setRight(expression);
            genStmt.setStatement(assignment);
        
        // x = id++; -> x = id; id = id + 1;
        } else if(condType.equals("post")){
            assignment.setLeft(assignmentStack.getLeft());
            assignment.setRight(assignExp);
            genStmt.setStatement(assignment);

            assignmentStack.setLeft(variable);
            assignmentStack.setRight(expression);
        }

        statements.push(genStmt);
        statements.push(assignmentStack);
        statements.push(assignExp);
    }

    /**
     * @function accessedAttribute
     * 
     * Represents the 3 cases where an attribute will be accessed here: 
     * 1. In the left side of an assignment, and it can be known because the last
     * statement in the statements Stack will be the Assignment object.
     * 2. In the right side of an assignment, and it can be known because the right side
     * is always represented with an Expression so it is enough to check if the statement before
     * is an Assignment or not.
     * 3. In a pre/post-increment/decrement expression, known by the use of GenericStatement in these
     * types of statements.
     */
    public void accessedAttribute(){
        //Attribute access is on the left side of assignment
        if(statements.peek() instanceof Assignment){
            Assignment assignment = (Assignment) statements.pop();
            Variable left = (Variable) assignment.getLeft();
            List<String> members = Arrays.asList(left.getName().split("\\."));

            Variable var = createNewVariableForAttributes(currentFunction.getVariables().get(members.get(0)));
            var.setSelectedAttribute(members.get(1));
            assignment.setLeft(var);
            statements.push(assignment);
        //Attribute access is on the right side of expression
        } else if(statements.peek() instanceof Expression){
            Expression expression = (Expression) statements.pop();
            //Assignment assignment = (Assignment) statements.pop();
            /* 3 here relates to the members that exist in an expression when we have an attribute access,
             * e.g., for someClass.someAttribute it would have Variable (someClass), AttributeAccess, 
             * Variable (someAttribute). So if we have a complex expression (someClass.someAttribute + 
             * anotherClass.anotherAttribute), it would have 4 members (the already parsed someClass and the
             * to-be-parsed anotherClass).
            */
            int newAttributeAddedIdx = expression.getMembers().size() - 3;
            Variable attribute = (Variable) expression.getMembers().get(newAttributeAddedIdx + 2);
            //No need for AttributeAccess & Variable for attribute anymore
            expression.getMembers().remove(newAttributeAddedIdx + 2);
            expression.getMembers().remove(newAttributeAddedIdx + 1);
            
            Variable var = createNewVariableForAttributes((Variable) expression.getMembers().get(newAttributeAddedIdx));
            var.setSelectedAttribute(attribute.getName());
            
            if(newAttributeAddedIdx == 0){
                expression.setSelectedAttribute(attribute.getName());
                expression.getMembers().clear();
                expression.getMembers().add(var);
                expression.setClassReference(expression.getMembers().get(newAttributeAddedIdx).getClassReference());
            } else{
                expression.getMembers().remove(newAttributeAddedIdx);
                expression.getMembers().add(newAttributeAddedIdx, var);
            }
            
            //assignment.setRight(expression);

            //statements.push(assignment);
            statements.push(expression);
        } else if(statements.peek() instanceof GenericStatement){
            GenericStatement genStmt = (GenericStatement) statements.pop();
            Expression expression = (Expression) genStmt.getStatement();
            Variable attribute = (Variable) expression.getMembers().get(2);
            Variable var = createNewVariableForAttributes((Variable) expression.getMembers().get(0));
            var.setSelectedAttribute(attribute.getName());

            genStmt.setStatement(var);
            statements.push(genStmt);
        }
    }

    /**
     * @function createNewVariableForAttributes
     * @return Variable
     * 
     * Receives a variable and returns another reference to that variable with the same
     * information regarding name, type, if it's tainted or not, etc. Used mainly because
     * of class instances to know what attribute was used for that instance in a given statement,
     * without having that information be overwritten to all other references of that variable
     */
    public Variable createNewVariableForAttributes(Variable variable){
        Variable var = new Variable(variable.getName());
        var.setClassReference(variable.getClassReference());
        var.setType(variable.getType());
        var.setLine(variable.getLine());
        var.setTainted(variable.isTainted());
        var.setText(variable.getText());
        return var;
    }

    /**
     * @function isGenericStatement
     * @return boolean
     * 
     * This function is used, primarily for now, for attribute accesses in Generic Statements.
     * The issue being solved here was found regarding pre/post-increment/decrement expressions with
     * attribute acesses. With a Generic Statement, the information regarding attribute accesses is lost
     * and to be able to get that information, this function will instead insert an Expression in the Stack
     * (and in the Generic Statement) to store that information so it can be processed in another function.
     * 
     * It returns true/false based on the fact if GT has a Generic Statement in the Stack or not.
     */
    public boolean isGenericStatement(){
        if(statements.peek() instanceof GenericStatement){
            GenericStatement genStmt = (GenericStatement) statements.pop();
            Expression expression = new Expression();
            genStmt.setStatement(expression);

            statements.push(genStmt);
            statements.push(expression);
            return true;
        } else{
            return false;
        }
    }
}
