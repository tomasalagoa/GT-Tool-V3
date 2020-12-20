package ist.gt.settings;

import lombok.Data;

@Data
public class Settings {
    private String directory;
    private String fileExtension;
    private int numberOfTimesToAnalyzeCycles = 2;
    private TaintSpecification specification;
}
