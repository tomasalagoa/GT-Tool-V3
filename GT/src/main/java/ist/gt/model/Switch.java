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

    /**
     * This variable holds a collection of mappings, from expressions to codeBlocks
     * The logic behind it is supposed to help deal with fallthrough cases and is explained in addCase
     */
    private Stack<Util.Pair<ArrayList<Expression>, CodeBlock>> cases = new Stack<>();

    public void addCase(Expression cond){
        // First case
        if (cases.isEmpty()){
            ArrayList<Expression> conds = new ArrayList<>();
            conds.add(cond);
            Util.Pair<ArrayList<Expression>, CodeBlock> pair = new Util.Pair<>(conds, null);
            cases.push(pair);
        } else if (cases.peek().value() == null) {
            // The previous case(s) had no code, so we just add the new condition to the existing list
            cases.peek().key().add(cond);
        } else if (cases.peek().value() != null) {
            // The previous case(s) had some code, so we have to duplicate the list of conditions and add the new one
            // to the list.
            ArrayList<Expression> conds = new ArrayList<>(cases.peek().key());
            conds.add(cond);
            Util.Pair<ArrayList<Expression>, CodeBlock> pair = new Util.Pair<>(conds, null);
        }
    }

    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }

    @Override
    public void addValue(ValueTrackingInterface tracker) {
        // Nothing to track
    }
}