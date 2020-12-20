package ist.gt.model;


import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import lombok.Data;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.List;

@Data
public class TryCatch extends Statement {

    private CodeBlock tryBlock = new CodeBlock();
    private List<CodeBlock> catchBlock = new ArrayList<>();
    private CodeBlock finallyBlock = new CodeBlock();

    public TryCatch(ParserRuleContext ctx) {
        super(ctx);
    }

    @Override
    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }
}
