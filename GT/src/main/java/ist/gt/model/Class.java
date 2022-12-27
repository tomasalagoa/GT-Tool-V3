package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import lombok.Data;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.HashMap;
import java.util.ArrayList;

@Data
public class Class extends Element {
    private String name;
    private String superClass;
    private HashMap<String, Function> methods = new HashMap<>();
    private HashMap<String, Attribute> attributes = new HashMap<>();
    private ArrayList<Function> constructors = new ArrayList<>();

    public Class(ParserRuleContext ctx, String name) {
        super(ctx);
        this.name = name;
    }

    public Class(ParserRuleContext ctx, String name, String superClass) {
        super(ctx);
        this.name = name;
        this.superClass = superClass;
    }
    
    //Value tracking constructor (no need for ctx)
    public Class(String name) {
        this.name = name;
    }

    /**
     * @function areAttributesTainted
     * If at least one attribute is tainted, then class object is considered tainted
     */
    public boolean areAttributesTainted(){
        boolean tainted = false;

        for(Attribute attribute : attributes.values()){
            tainted = tainted || attribute.isTainted();
        }

        return tainted;
    }

    @Override
    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }


}
