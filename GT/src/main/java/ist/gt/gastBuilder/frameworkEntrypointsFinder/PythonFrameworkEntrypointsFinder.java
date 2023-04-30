package ist.gt.gastBuilder.frameworkEntrypointsFinder;

import ist.gt.languages.python.parser.PythonParser;
import ist.gt.languages.python.parser.PythonParserBaseListener;
import lombok.Data;

import java.util.HashMap;
import java.util.ArrayList;

@Data
public class PythonFrameworkEntrypointsFinder extends PythonParserBaseListener{
    private HashMap<String, ArrayList<String>> entrypoints;
    /* Although it will be, mostly, one global variable tainted, this allows the solution
     * to scale to other frameworks/global variables that may appear. */
    private ArrayList<String> globalTaintedVariables;
    private boolean annotationFound;
    private String functionName;

    public PythonFrameworkEntrypointsFinder(){
        this.globalTaintedVariables = new ArrayList<>();
        this.entrypoints = new HashMap<>();
        this.annotationFound = false;
    }

    @Override
    public void enterFrom_stmt(PythonParser.From_stmtContext ctx){
        if(ctx.IMPORT() != null){
            if(ctx.dotted_name().getText().matches("flask")){
                for(int i = 0; i < ctx.import_as_names().import_as_name().size(); i++){
                    /* request global variable imported from flask could be tainted */
                    if(ctx.import_as_names().import_as_name(i).getText().matches("request")){
                        this.globalTaintedVariables.add(ctx.import_as_names().import_as_name(i).getText());
                    }
                }
            }
        }
    }

    @Override
    public void enterFuncdef(PythonParser.FuncdefContext ctx) {
        if(this.annotationFound){
            this.functionName = ctx.name().getText();
            this.entrypoints.put(this.functionName, new ArrayList<>());
        }
    }

    @Override
    public void exitFuncdef(PythonParser.FuncdefContext ctx) {
        if(this.annotationFound){
            this.annotationFound = false;
        }
    }

    @Override
    public void enterDef_parameter(PythonParser.Def_parameterContext ctx) {
        if(this.annotationFound && this.entrypoints.containsKey(this.functionName)){
            this.entrypoints.get(this.functionName).add(ctx.named_parameter().name().getText());
        }
    }

    @Override
    public void enterDecorator(PythonParser.DecoratorContext ctx){
        if(ctx.AT() != null && ctx.dotted_name().getText().contains(".route")){
            this.annotationFound = true;
        }
    }
}
