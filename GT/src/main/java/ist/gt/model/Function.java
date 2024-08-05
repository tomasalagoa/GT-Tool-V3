package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.antlr.v4.misc.OrderedHashMap;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Data
@NoArgsConstructor

public class Function extends Element {

    @NonNull
    private String name;
    private OrderedHashMap<String, Variable> parameters = new OrderedHashMap<>();
    private Map<String, Variable> variables = new HashMap<>();
    private CodeBlock codeBlock = new CodeBlock();
    private String returnType;
    private Variable thisVar = new Variable();

    public Function(String functionName) {
        this.name = functionName;
    }

    public Function(String functionName, ParserRuleContext ctx) {
        super(ctx);
        this.name = Objects.requireNonNullElse(functionName, "lambda");
    }

    public Function(ParserRuleContext ctx, @NonNull String name, String returnType) {
        super(ctx);
        this.name = name;
        this.returnType = returnType;
    }

    @Override
    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }
}
