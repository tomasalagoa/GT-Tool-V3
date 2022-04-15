package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.ParserRuleContext;

@Data
@NoArgsConstructor
public class Constant extends Expression {
    public Constant(ParserRuleContext ctx, Object value, String type) {
        super(ctx, value.toString(), type);
        this.value = value;
        this.trackedValue = value.toString();
    }

    public Object value;
    public String trackedValue;

    @Override
    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }
}
