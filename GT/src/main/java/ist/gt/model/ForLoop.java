package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ForLoop extends Element{

    private Expression condition;
    private Expression initialization;
    private Expression advancement;
    private ArrayList<Variable> localVariables;
    private CodeBlock block;

    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }
}
