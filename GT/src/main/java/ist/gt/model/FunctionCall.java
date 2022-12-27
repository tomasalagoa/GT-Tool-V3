package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.Objects;

@Data
@NoArgsConstructor

public class FunctionCall extends Expression {
    @NonNull
    private String functionName;
    private String returnType;
    private boolean isSuper;
    private boolean isConstructor;
    //Used mainly for constructor's value tracking
    private Variable hiddenThis = new Variable("this");

    public FunctionCall(ParserRuleContext ctx, String functionName) {
        super(ctx);
        this.functionName = Objects.requireNonNullElse(functionName, "lambda");
        this.isSuper = false;
    }

    @Override
    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }
}
