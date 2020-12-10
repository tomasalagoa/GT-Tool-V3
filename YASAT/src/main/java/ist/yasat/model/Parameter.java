package ist.yasat.model;

import ist.yasat.gastBuilder.AstBuilderVisitorInterface;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.antlr.v4.runtime.ParserRuleContext;

@EqualsAndHashCode(callSuper = true)
@Data
public class Parameter extends Variable {

    public Parameter(ParserRuleContext ctx, @NonNull String name) {
        super(ctx, name);
    }

    public Parameter(ParserRuleContext ctx, @NonNull String name, String type) {
        super(ctx, name, type);
    }

    @Override
    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }
}
