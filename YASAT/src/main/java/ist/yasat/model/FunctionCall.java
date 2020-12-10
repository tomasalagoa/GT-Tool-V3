package ist.yasat.model;

import ist.yasat.gastBuilder.AstBuilderVisitorInterface;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.antlr.v4.runtime.ParserRuleContext;

@Data
@NoArgsConstructor

public class FunctionCall extends Expression {
    @NonNull
    private String functionName;
    private String returnType;

    public FunctionCall(ParserRuleContext ctx, @NonNull String functionName) {
        super(ctx);
        this.functionName = functionName;
    }

    @Override
    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }
}
