package ist.gt.model;


import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class IfStatement extends ConditionalStatement {

    private boolean elseIf;
    private List<IfStatement> elseIfs = new ArrayList<>();


    private CodeBlock elseBlock = new CodeBlock();

    public IfStatement(ParserRuleContext ctx, String condition) {
        super(ctx, condition);
    }

    public IfStatement(ParserRuleContext ctx, String condition, boolean isElseIf) {
        super(ctx, condition);
        elseIf = isElseIf;
    }

    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }

}
