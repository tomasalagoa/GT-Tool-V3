package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import ist.gt.gastBuilder.ValueTrackingInterface;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.ParserRuleContext;


@Data
@NoArgsConstructor
public class ReturnStatement extends Statement {
    private Expression expression;

    public ReturnStatement(ParserRuleContext ctx) {
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
