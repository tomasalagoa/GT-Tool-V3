package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import ist.gt.gastBuilder.ValueTrackingInterface;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Expression extends Statement {
    public Expression(ParserRuleContext ctx) {
        super(ctx);
    }

    public Expression(ParserRuleContext ctx, String value, String type) {
        super(ctx);
        this.trackedValue = value;
        this.type = type;
    }

    public Expression(ParserRuleContext ctx, String type) {
        super(ctx);
        this.type = type;
    }

    private List<Expression> members = new ArrayList<>();
    private String trackedValue;
    private String operator;
    //Mostly used for Constants & Variables, helping in value tracking
    private String type;
    //In case Variable will need to reference a class
    private Class classReference;
    private String selectedAttribute;
    //In case it will need to store a lambda function
    private Function lambdaFunc;
    //In case a Collection (List, Set, Map, etc) is used (going for List support for now)
    private boolean isCollection = false;

    public void setType(String type) {
        if (type != null)
            this.type = type;
    }

    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }

    @Override
    public void addValue(ValueTrackingInterface tracker) {
        tracker.track(this);
    }
}
