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
    private ArrayList<Assignment> initializations;
    private Expression update;
    private ArrayList<Variable> localVariables;
    private CodeBlock block;

    public ForLoop(ParserRuleContext ctx) {
       super(ctx);
       initializations = new ArrayList<>();
       localVariables = new ArrayList<>();
       // Java
       if (Util.callMethodIfExists(ctx, "forInit") != null) {
          for (var a :
                  ((Java8Parser.BasicForStatementContext)ctx).forInit().localVariableDeclaration().variableDeclaratorList().variableDeclarator()) {
              initializations.add(new Assignment(a));
          }
       }
    }

    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }
}