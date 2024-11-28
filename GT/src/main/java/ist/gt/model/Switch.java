package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import ist.gt.gastBuilder.ValueTrackingInterface;
import ist.gt.util.Util;
import lombok.Data;

import java.util.ArrayList;
import java.util.Stack;

@Data
public class Switch extends Statement{

    private Expression condition;
    private boolean hadBreak = false;

    /**
     * This variable holds a collection of mappings, from expressions to codeBlocks
     * The logic behind it is supposed to help deal with fallthrough cases and is explained in addCase
     */
    private Stack<Util.Pair<ArrayList<Expression>, CodeBlock>> cases = new Stack<>();

    /**
     * @param cond the condition for a new case
     * This function adds a new case to the stack, the logic for fallthrough and breaks is also added here
     */
    public void addCase(Expression cond){
        // First case or had a break in the previous case
        if (cases.isEmpty() || hadBreak) {
            ArrayList<Expression> conds = new ArrayList<>();
            conds.add(cond);
            Util.Pair<ArrayList<Expression>, CodeBlock> pair = new Util.Pair<>(conds, new CodeBlock());
            cases.push(pair);
            hadBreak = false;
        } else if (cases.peek().value() == null) {
            // The previous case(s) had no code, so we just add the new condition to the existing list
            cases.peek().key().add(cond);
        } else if (cases.peek().value() != null) {
            // The previous case(s) had some code, so we have to duplicate the list of conditions and add the new one
            // to the list.
            ArrayList<Expression> conds = new ArrayList<>(cases.peek().key());
            conds.add(cond);
            Util.Pair<ArrayList<Expression>, CodeBlock> pair = new Util.Pair<>(conds, new CodeBlock());
            cases.push(pair);
        }
    }

    public void addStatement(Statement stmt) {
        cases.peek().value().getStatements().add(stmt);
    }

    public void breakInCase() {
        hadBreak = true;
    }

    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }

    @Override
    public void addValue(ValueTrackingInterface tracker) {
        // Nothing to track
    }
}