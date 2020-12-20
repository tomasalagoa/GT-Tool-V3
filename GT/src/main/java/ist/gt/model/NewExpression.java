package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import lombok.Data;
import org.antlr.v4.runtime.ParserRuleContext;

@Data
public class NewExpression extends Expression {

    public Class object;
    public String className;
    public NewExpression(ParserRuleContext ctx, String className) {
        super(ctx);
        this.className = className;
    }

    @Override
    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }
}
