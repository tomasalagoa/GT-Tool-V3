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
        if(this.annotationFound){
            this.annotationFound = false;
        }
    }

    @Override
    public void enterFormalParameter(Java8Parser.FormalParameterContext ctx) {
        if(this.annotationFound && this.entrypoints.containsKey(this.functionName)){
            this.entrypoints.get(this.functionName).add(ctx.variableDeclaratorId().Identifier().getText());
        }
    }

    @Override
    public void enterNormalAnnotation(Java8Parser.NormalAnnotationContext ctx){
        if(ctx.AT() != null && this.functionName != null){
            isAnnotationValid(ctx.typeName().getText());
        }
    }

    @Override
    public void enterMarkerAnnotation(Java8Parser.MarkerAnnotationContext ctx){
        if(ctx.AT() != null && this.functionName != null){
            isAnnotationValid(ctx.typeName().getText());
        }
    }

    @Override
    public void enterSingleElementAnnotation(Java8Parser.SingleElementAnnotationContext ctx){
        if(ctx.AT() != null && this.functionName != null){
            isAnnotationValid(ctx.typeName().getText());
        }
    }

    public void isAnnotationValid(String annotationName){
        if(annotationName.equals("RequestMapping") || annotationName.equals("GetMapping")
        || annotationName.equals("PostMapping") || annotationName.equals("PutMapping")
        || annotationName.equals("DeleteMapping")){
            this.annotationFound = true;
            this.entrypoints.putIfAbsent(this.functionName, new ArrayList<>());
        }
    }

}
