package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import ist.gt.languages.java.parser.Java8Parser;
import ist.gt.util.Util;
import lombok.Data;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;

@Data
public class ForLoop extends Element{

    private Expression condition;
    private Expression update;

    private CodeBlock block;

    public ForLoop(ParserRuleContext ctx) {
       super(ctx);
    }

    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }
}