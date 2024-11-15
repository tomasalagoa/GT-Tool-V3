package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import ist.gt.gastBuilder.ValueTrackingInterface;
import lombok.Data;

import java.util.Stack;

@Data
public class Switch extends Statement{

    private Expression condition;
    private Stack<SwitchCase> cases = new Stack<>();
    private int numCases = 0;

    public void addCase(SwitchCase c){
        cases.push(c);
        numCases++;
    }

    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }

    @Override
    public void addValue(ValueTrackingInterface tracker) {
        // Nothing to track
    }
}