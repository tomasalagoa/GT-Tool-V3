package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Expression extends Statement {
    public Expression(ParserRuleContext ctx) {
        super(ctx);
    }

    public Expression(ParserRuleContext ctx, String value){
        super(ctx);
        this.trackedValue = value;
    }

    private List<Expression> members = new ArrayList<>();
    private String trackedValue;

    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }
}
