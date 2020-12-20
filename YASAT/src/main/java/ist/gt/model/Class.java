package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import lombok.Data;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.HashMap;

@Data
public class Class extends Element {
    private String name;

    public Class(ParserRuleContext ctx, String name) {
        super(ctx);
        this.name = name;
    }

    public Class(ParserRuleContext ctx, String name, String superClass) {
        super(ctx);
        this.name = name;
        this.superClass = superClass;
    }

    private String superClass;

    private HashMap<String, Function> methods = new HashMap<>();
    private HashMap<String, Attribute> attributes = new HashMap<>();

    @Override
    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }


}
