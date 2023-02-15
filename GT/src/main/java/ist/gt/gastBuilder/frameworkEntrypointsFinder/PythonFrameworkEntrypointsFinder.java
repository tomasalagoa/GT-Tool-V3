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
            //System.out.println("What's in the import? " + ctx.dotted_name().getText());
            if(ctx.dotted_name().getText().matches("flask")){
                for(int i = 0; i < ctx.import_as_names().import_as_name().size(); i++){
                    //System.out.println("Import as names import num " + i + " " + ctx.import_as_names().import_as_name(i).getText());
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
        //gastBuilder.addFunction(ctx, ctx.name().getText());
        //System.out.println("Found function named: " + ctx.name().getText());
        if(this.annotationFound){
            this.functionName = ctx.name().getText();
            this.entrypoints.put(this.functionName, new ArrayList<>());
        }
    }

    @Override
    public void exitFuncdef(PythonParser.FuncdefContext ctx) {
        //System.out.println("Ending entrypoint entry");
        //System.out.println("-----------------------------------------------------------");
        if(this.annotationFound){
            this.annotationFound = false;
        }
    }

    @Override
    public void enterDef_parameter(PythonParser.Def_parameterContext ctx) {
        //gastBuilder.addParameter(ctx, ctx.named_parameter().name().getText());
        //System.out.println("Found parameter: " + ctx.named_parameter().name().getText());
        if(this.annotationFound && this.entrypoints.containsKey(this.functionName)){
            this.entrypoints.get(this.functionName).add(ctx.named_parameter().name().getText());
        }
    }

    @Override
    public void enterDecorator(PythonParser.DecoratorContext ctx){
        if(ctx.AT() != null){
            //System.out.println("Did I find an annotation?");
            //System.out.println("Name: " + ctx.dotted_name().getText());
            if(ctx.dotted_name().getText().matches("app.route")){
                this.annotationFound = true;
            }
            if(ctx.arglist() != null){
                //System.out.println("ArgList: " + ctx.arglist().getText());
            }
            //System.out.println("---------------------------------------");
        }
    }
}
