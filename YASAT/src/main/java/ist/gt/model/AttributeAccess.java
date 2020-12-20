package ist.yasat.model;

import ist.yasat.gastBuilder.AstBuilderVisitorInterface;
import lombok.Data;
import org.antlr.v4.runtime.ParserRuleContext;

@Data
public class AttributeAccess extends Expression {
    private String memberName;


    public AttributeAccess(ParserRuleContext ctx, String identifier) {
        super(ctx);
        this.memberName = identifier;
    }

    @Override
    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }
}
