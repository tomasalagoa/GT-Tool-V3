package ist.gt.settings;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class TaintSpecification {
    private String fileName;
    private FuncDefinition function;
    private List<String> taintedVarsOrArgs = new ArrayList<>();
    private List<FuncDefinition> sensitiveFunctions = new ArrayList<>();
    private List<FuncDefinition> sanitizationFunctions = new ArrayList<>();
    private List<String> taintedAttributes = new ArrayList<>();
    private boolean returnTaintedIfTaintedSource;
    private boolean allFiles;
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


    public boolean isMethod() {
        return function.getType() != null;
    }

    public boolean isRootSpecification() {
        return function == null;
    }
}
