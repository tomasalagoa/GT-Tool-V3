package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import ist.gt.gastBuilder.ValueTrackingInterface;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.ParserRuleContext;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ConditionalStatement extends Statement {

    private String condition;
    private Expression expression = new Expression();
    private CodeBlock codeBlock = new CodeBlock();

    public ConditionalStatement(ParserRuleContext ctx, String condition) {
        super(ctx);
        this.condition = condition;
    }

    public boolean isFullyExplored() {
        return codeBlock.isFullyExplored();
    }

    public ConditionalStatement(ParserRuleContext ctx) {
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
