package ist.yasat.model;

import ist.yasat.gastBuilder.AstBuilderVisitorInterface;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class CodeBlock extends Element {
    public CodeBlock(ParserRuleContext ctx) {
        super(ctx);
    }

    private List<Statement> statements = new ArrayList<>();
    private boolean hasReturn;
    private boolean isReturnTainted;
    private boolean fullyExplored;

    @Override
    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }
}
