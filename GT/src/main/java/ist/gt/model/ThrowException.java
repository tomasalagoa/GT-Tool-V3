package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import ist.gt.gastBuilder.ValueTrackingInterface;
import lombok.Data;
import org.antlr.v4.runtime.ParserRuleContext;

@Data
public class ThrowException extends Statement {
    private Expression expression;

    public ThrowException(ParserRuleContext ctx) {
        super(ctx);
    }

    @Override
    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }

    public void addValue(ValueTrackingInterface tracker) {
        //Nothing to track here
        
    }
}
