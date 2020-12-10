package ist.yasat.model;

import ist.yasat.gastBuilder.AstBuilderVisitorInterface;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.antlr.v4.misc.OrderedHashMap;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor

public class Function extends Element {

    @NonNull
    private String name;
    private OrderedHashMap<String, Variable> parameters = new OrderedHashMap<>();
    private Map<String, Variable> variables = new HashMap<>();
    private CodeBlock codeBlock = new CodeBlock();
    private String returnType;

    public Function(@NonNull String functionName) {
        this.name = functionName;
    }

    public Function(@NonNull String functionName, ParserRuleContext ctx) {
        super(ctx);
        this.name = functionName;
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
