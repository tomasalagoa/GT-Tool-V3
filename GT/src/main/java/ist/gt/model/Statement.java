package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.ParserRuleContext;

@NoArgsConstructor
public abstract class Statement extends Taintable {
    public Statement(ParserRuleContext ctx) {
        super(ctx);
    }

    public void accept(AstBuilderVisitorInterface visitor) {

    }
}
