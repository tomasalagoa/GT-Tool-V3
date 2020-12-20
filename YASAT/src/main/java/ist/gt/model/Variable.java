package ist.yasat.model;

import ist.yasat.gastBuilder.AstBuilderVisitorInterface;
import lombok.*;
import org.antlr.v4.runtime.ParserRuleContext;


@Data
@NoArgsConstructor
public class Variable extends Expression {
    @NonNull
    private String name;
    private String type;

    public Variable(@NonNull String name) {
        this.name = name;
    }

    public Variable(ParserRuleContext ctx, @NonNull String name) {
        super(ctx);
        this.name = name;
    }

    public Variable(ParserRuleContext ctx, @NonNull String name, String type) {
        super(ctx);
        this.name = name;
        this.type = type;
    }

    public void setType(String type) {
        if (type != null)
            this.type = type;
    }

    @Override
    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }

}
