package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import ist.gt.gastBuilder.ValueTrackingInterface;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.ParserRuleContext;


@Data
@NoArgsConstructor
public class Assignment extends Statement {
    private Expression left;
    private Expression right;
    private String operator;

    public Assignment(ParserRuleContext ctx) {
        super(ctx);
    }

    public Assignment(ParserRuleContext ctx, Variable variable) {
        super(ctx);
        this.left = variable;
    }

    @Override
    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }

    public void addValue(ValueTrackingInterface tracker) {
        tracker.track(this);
    }


}
