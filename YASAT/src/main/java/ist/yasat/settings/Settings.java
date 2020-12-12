package ist.yasat.settings;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class Settings {
    private String directory;
    private String fileExtension;
    private int numberOfTimesToAnalyzeCycles = 2;
    private TaintSpecification specification;
}
