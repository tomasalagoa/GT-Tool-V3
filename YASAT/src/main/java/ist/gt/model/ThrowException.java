package ist.yasat.model;

import ist.yasat.gastBuilder.AstBuilderVisitorInterface;
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
}
