package ist.gt.gastBuilder.frameworkEntrypointsFinder;

import org.antlr.v4.runtime.tree.ParseTreeWalker;
import ist.gt.languages.java.parser.Java8Parser.CompilationUnitContext;
import ist.gt.languages.python.parser.PythonParser.RootContext;
import lombok.Data;

import java.util.HashMap;
import java.util.ArrayList;

@Data
public class FrameworkEntrypointsFinder {
    private HashMap<String, ArrayList<String>> entrypoints;
    /* Allows the solution to scale to other frameworks/global variables that may appear.
     * Works for Python for now. */
    private ArrayList<String> globalTaintedVariables;

    public FrameworkEntrypointsFinder(){
        this.entrypoints = new HashMap<>();
        this.globalTaintedVariables = new ArrayList<>();
    }

    public void useJavaFrameworkEntrypointsFinder(String frameworkName, String selectedFileName, String currentFile, ParseTreeWalker walker, CompilationUnitContext tree){
        JavaFrameworkEntrypointsFinder frameListener = new JavaFrameworkEntrypointsFinder();
        switch(frameworkName){
            case "Spring":
                if(selectedFileName != null){
                    if(selectedFileName.equals(currentFile)){
                        System.out.println("Checking entrypoints of Java file: " + selectedFileName);
                        walker.walk(frameListener, tree);
                        saveEntrypoints(frameListener.getEntrypoints());
                        return;
                    } else{
                        return;
                    }
                } else {
                    System.out.println("Checking entrypoints of all directory Java files");
                    walker.walk(frameListener, tree);
                    saveEntrypoints(frameListener.getEntrypoints());
                    return;
                }
            

            default:
                System.out.println("Framework " + frameworkName + " is not supported. Current supported frameworks: Spring for Java, Flask for Python.");
                return;
        }
    }

    public void usePythonFrameworkEntrypointsFinder(String frameworkName, String selectedFileName, String currentFile, ParseTreeWalker walker, RootContext tree){
        PythonFrameworkEntrypointsFinder frameListener = new PythonFrameworkEntrypointsFinder();
        switch(frameworkName){
            case "Flask":
                if(selectedFileName != null){
                    if(selectedFileName.equals(currentFile)){
                        System.out.println("Checking entrypoints of Python file: " + selectedFileName);
                        walker.walk(frameListener, tree);
                        saveEntrypoints(frameListener.getEntrypoints());
                        saveGlobalTaintedVariables(frameListener.getGlobalTaintedVariables());
                        return;
                    } else{
                        return;
                    }
                } else {
                    System.out.println("Checking entrypoints of all directory Python files");
                    walker.walk(frameListener, tree);
                    saveEntrypoints(frameListener.getEntrypoints());
                    saveGlobalTaintedVariables(frameListener.getGlobalTaintedVariables());
                    return;
                }
            

            default:
                System.out.println("Framework " + frameworkName + " is not supported. Current supported frameworks: Spring for Java, Flask for Python.");
                return;
        }
    }

    public void saveEntrypoints(HashMap<String, ArrayList<String>> entrypointsFound){
        if(!entrypointsFound.isEmpty()){
            this.entrypoints = entrypointsFound;
        }
    }

    public void saveGlobalTaintedVariables(ArrayList<String> globalTaintedVariablesFound){
        if(!globalTaintedVariablesFound.isEmpty()){
            this.globalTaintedVariables = globalTaintedVariablesFound;
        }
    }

    public void cleanUp(){
        this.entrypoints.clear();
        this.globalTaintedVariables.clear();
    }


}
