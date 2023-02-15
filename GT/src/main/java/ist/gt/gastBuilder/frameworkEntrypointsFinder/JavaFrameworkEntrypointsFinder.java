package ist.gt.gastBuilder.frameworkEntrypointsFinder;

import ist.gt.languages.java.parser.Java8Parser;
import ist.gt.languages.java.parser.Java8ParserBaseListener;
import lombok.Data;

import java.util.HashMap;
import java.util.ArrayList;

@Data
public class JavaFrameworkEntrypointsFinder extends Java8ParserBaseListener{
    private HashMap<String, ArrayList<String>> entrypoints;
    private boolean annotationFound;
    private String functionName;

    public JavaFrameworkEntrypointsFinder() {
        this.entrypoints = new HashMap<>();
        this.annotationFound = false;
    }

    @Override
    public void enterMethodDeclaration(Java8Parser.MethodDeclarationContext ctx) {
        this.functionName = ctx.methodHeader().methodDeclarator().Identifier().getText();
    }

    @Override
    public void exitMethodDeclaration(Java8Parser.MethodDeclarationContext ctx) {
        System.out.println("Ending entrypoint entry");
        System.out.println("-----------------------------------------------------------");
        if(this.annotationFound){
            this.annotationFound = false;
        }
    }

    @Override
    public void enterFormalParameter(Java8Parser.FormalParameterContext ctx) {
        if(this.annotationFound && this.entrypoints.containsKey(this.functionName)){
            System.out.println("Parameter found: " + ctx.variableDeclaratorId().Identifier().getText() + " " + ctx.unannType().getText());
            this.entrypoints.get(this.functionName).add(ctx.variableDeclaratorId().Identifier().getText());
        }
    }

    @Override
    public void enterNormalAnnotation(Java8Parser.NormalAnnotationContext ctx){
        if(ctx.AT() != null && !ctx.elementValuePairList().isEmpty()){
            System.out.println("NormalAnnotation - Found another annotation: " + ctx.getText());
            System.out.println(ctx.typeName().getText());
            System.out.println(ctx.elementValuePairList().getText());
            if(ctx.typeName().getText().equals("RequestMapping") || ctx.typeName().getText().equals("GetMapping")
            || ctx.typeName().getText().equals("PostMapping") || ctx.typeName().getText().equals("PutMapping")
            || ctx.typeName().getText().equals("DeleteMapping")){
                this.annotationFound = true;
                this.entrypoints.put(this.functionName, new ArrayList<>());
            }
        }
    }
}
