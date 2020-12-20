package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
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
}
