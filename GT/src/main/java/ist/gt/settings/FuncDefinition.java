package ist.gt.settings;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class FuncDefinition {
    //External configuration -> done by user when making tests
    //Internal configuration -> done by the tool automatically
    @NonNull
    //For external configuration: function name;
    private String name;
    //For external/internal configuration: type is file name without extension;
    private String type;
    //For external configuration: allows one to know what are the parameters of the function 
    private List<String> parameters;

    public FuncDefinition(String name, String type){
        this.name = name;
        this.type = type;
        this.parameters = new ArrayList<>();
    }

    public FuncDefinition(String name, List<String> parameters, String type){
        this.name = name;
        this.type = type;
        this.parameters = parameters;
    }
}
