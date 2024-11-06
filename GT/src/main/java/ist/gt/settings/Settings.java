package ist.gt.settings;

import lombok.Data;

import java.nio.file.Path;

@Data
public class Settings {
    private String framework;
    private String version;
    private Path directory;
    private String fileExtension;
    private int numberOfTimesToAnalyzeCycles = 2;
    private TaintSpecification specification;
}
