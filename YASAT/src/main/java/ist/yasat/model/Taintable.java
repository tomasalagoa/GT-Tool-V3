package ist.yasat.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.ParserRuleContext;


@Data
@NoArgsConstructor
public abstract class Taintable extends Element {

    public Taintable(ParserRuleContext ctx) {
        super(ctx);
    }

    private boolean isTainted;
}
