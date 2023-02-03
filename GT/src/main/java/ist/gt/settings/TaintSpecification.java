package ist.gt.settings;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class TaintSpecification {
    //External configuration -> done by user when making tests
    //Internal configuration -> done by the tool automatically
    
    //For external configuration: file to analyze
    private String fileName;
    /* For external configuration: corresponding file's known function(s) to analyze 
     * (leave it empty if framework was provided in settings)
     */
    private List<FuncDefinition> functionsToAnalyze = new ArrayList<>();
    /* For internal configuration: given to TaintVisitor to know the function to analyze */
    private FuncDefinition function;
    /* For external configuration: allows TaintVisitor to know what are the tainted variables 
     * of a root function (eg for PHP);
     * For internal configuration: allows TaintVisitor to know what are the tainted variables of a given function
     */
    private List<String> taintedVarsOrArgs = new ArrayList<>();
    /* For external configuration: provided known sensitive functions for vulnerability detection */
    private List<FuncDefinition> sensitiveFunctions = new ArrayList<>();
    /* For external configuration: provided known/used sanitized functions for taint cleaning */
    private List<FuncDefinition> sanitizationFunctions = new ArrayList<>();
    /* For external configuration: provided taint attributes from class in file */
    private List<String> taintedAttributes = new ArrayList<>();
    /* For external configuration: return tainted from a method if it's source is tainted */
    private boolean returnTaintedIfTaintedSource;
    /* For external configuration: simply runs through files (from top of file to bottom) (?)*/
    private boolean allFiles;
    /* For external configuration: global variable(s) regex to taint them (?)*/
    private List<String> globalTaintVariableRegex = new ArrayList<>();


    public TaintSpecification(FuncDefinition function, List<String> taintedArguments, List<FuncDefinition> sensitiveFunctions, List<FuncDefinition> sanitizationFunctions) {
        this.function = function;
        this.taintedVarsOrArgs = taintedArguments;
        this.sensitiveFunctions = sensitiveFunctions;
        this.sanitizationFunctions = sanitizationFunctions;
    }

    public TaintSpecification(FuncDefinition function, List<String> taintedArguments, List<FuncDefinition> sensitiveFunctions) {
        this.function = function;
        this.taintedVarsOrArgs = taintedArguments;
        this.sensitiveFunctions = sensitiveFunctions;
    }

    public TaintSpecification(List<FuncDefinition> functions, List<FuncDefinition> sensitiveFunctions){
        this.functionsToAnalyze = functions;
        this.sensitiveFunctions = sensitiveFunctions;
    }


    public boolean isMethod() {
        return function.getType() != null;
    }

    public boolean isRootSpecification() {
        return function == null;
    }
}
