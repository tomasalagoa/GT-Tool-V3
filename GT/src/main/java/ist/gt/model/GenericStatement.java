package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import ist.gt.gastBuilder.ValueTrackingInterface;
import lombok.Data;
import org.antlr.v4.runtime.ParserRuleContext;

@Data
public class GenericStatement extends Statement {
    private Statement statement;

    public GenericStatement(ParserRuleContext ctx) {
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
