package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import lombok.Data;

import java.util.HashMap;

@Data
public class Switch extends Element{

    private Expression condition;
    private HashMap<Expression, CodeBlock> cases;

    public void addCase(Expression condition, CodeBlock block) {
        if (!cases.containsKey(condition)) {
            cases.put(condition, block);
        } else {
            System.err.println("Condition: " + condition + " already exists");
        }
    }

    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }
}