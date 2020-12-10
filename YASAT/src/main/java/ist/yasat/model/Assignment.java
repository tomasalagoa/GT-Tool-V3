package ist.yasat.model;

import ist.yasat.gastBuilder.AstBuilderVisitorInterface;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.ParserRuleContext;


@Data
@NoArgsConstructor
public class Assignment extends Statement {
    private Expression left;
    private Expression right;

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


}
