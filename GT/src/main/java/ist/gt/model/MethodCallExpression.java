package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import lombok.Data;
import org.antlr.v4.runtime.ParserRuleContext;

@Data
public class MethodCallExpression extends Expression {
    private Expression source; //could be method call expression

    private String currentType;

    @Override
    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }

    public MethodCallExpression(ParserRuleContext ctx) {
        super(ctx);
    }
}
