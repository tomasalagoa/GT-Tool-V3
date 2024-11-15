package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import lombok.Data;
import org.antlr.v4.runtime.ParserRuleContext;

@Data
public class Loop extends Element{

    private Expression condition;
    private Expression update;

    private CodeBlock block;

    public Loop(ParserRuleContext ctx) {
       super(ctx);
    }

    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }
}