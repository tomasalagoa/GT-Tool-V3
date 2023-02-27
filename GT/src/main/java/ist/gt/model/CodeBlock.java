package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.List;

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
    private String returnType;
    private String returnTrackedValue;
    private Class returnClassReference;

    @Override
    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }
}
