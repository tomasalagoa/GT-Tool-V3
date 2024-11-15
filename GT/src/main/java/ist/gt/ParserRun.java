package ist.gt;

import java.nio.file.Path;
import java.util.List;

import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

public class ParserRun {
    private static final TaintSpecification spec = new TaintSpecification(
            new FuncDefinition("method"),
            List.of("id"),
            List.of(new FuncDefinition("executeQuery")),
            List.of(new FuncDefinition("sanitize")));
    private final static Settings settings = new Settings();
    private final static Path DirectoryPath = Path.of("src", "test", "java", "javaLang");

    public static void main(String[] args) throws Exception {
        settings.setFileExtension("java");
        spec.setFileName("Experiment.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        settings.setSpecification(spec);
        AstConverter.analyse(DirectoryPath.resolve("switchCase"), settings);
        System.out.println("Success");
    }
}
