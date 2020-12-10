package ist.yasat.model;

import ist.yasat.gastBuilder.AstBuilderVisitorInterface;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.Serializable;


@Data
@NoArgsConstructor
public abstract class Element implements Serializable {

    public Element(ParserRuleContext ctx) {
        this.line = ctx.start.getLine();
        this.text = ctx.getText();
    }

    private int line;
    private String text;

    public abstract void accept(AstBuilderVisitorInterface visitor);
}
