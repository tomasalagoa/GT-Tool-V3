package javaLang;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaV2NewTaintTests {
    private static TaintSpecification spec = new TaintSpecification(
        new FuncDefinition("method"), List.of("id"), List.of(
            new FuncDefinition("executeQuery"), new FuncDefinition("sensitiveSink")), 
            List.of(new FuncDefinition("sanitize"))); 
    private Settings settings;
    private final String DirectoryPath = "src/test/java/javaLang";

    public JavaV2NewTaintTests() {
        settings = new Settings();
        settings.setFileExtension("java");
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void subclass_before_superclass_example2_tainted() throws Exception {
        spec.setFileName("B.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "/subclassbeforesuperclass/example2", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 2);
    }

    @Test
    public void return_example() throws Exception {
        spec.setFileName("ReturnExample.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "/returnexample", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 4);
    }

    @Test
    public void hidden_this_example() throws Exception {
        spec.setFileName("HiddenThisExample.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "/hiddenthisexample", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void untrusted_data_source_example() throws Exception {
        spec.setFileName("UntrustedDataSource.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        AstConverter.analyse(DirectoryPath + "/untrusteddatasourceexample", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }
}
