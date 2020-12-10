package ist.yasat.model;

import ist.yasat.gastBuilder.AstBuilderVisitorInterface;
import lombok.Data;
import lombok.NonNull;
import org.antlr.v4.runtime.ParserRuleContext;

@Data
public class Attribute extends Variable {

    public Attribute(ParserRuleContext ctx, @NonNull String name) {
        super(ctx, name);
    }

    public Attribute(ParserRuleContext ctx, @NonNull String name, String type) {
        super(ctx, name, type);
    }

    private Expression value;

    @Override
    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }
}
