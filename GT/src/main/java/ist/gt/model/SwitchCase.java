package ist.gt.model;

import ist.gt.gastBuilder.AstBuilderVisitorInterface;
import ist.gt.gastBuilder.ValueTrackingInterface;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SwitchCase extends Statement{

    List<Expression> conditions = new ArrayList<>();
    CodeBlock block;

    @Override
    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }

    @Override
    public void addValue(ValueTrackingInterface tracker) {
    // Nothing to track
    }
}
