package python;

import ist.yasat.AstConverter;
import ist.yasat.settings.FuncDefinition;
import ist.yasat.settings.Settings;
import ist.yasat.settings.TaintSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PythonTests {
    private TaintSpecification spec;
    private final Settings settings;
    private final String DirectoryPath = "src/test/resources/python/examples/sqli/";

    public PythonTests() {
        settings = new Settings();
        settings.setFileExtension("py");
    }


    @BeforeEach
    public void setUp() {
        spec = new TaintSpecification(new FuncDefinition("execute_query"), List.of("name"), List.of(new FuncDefinition("execute")));
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }


    @Test
    public void sqli1() throws Exception {
        spec.setFileName("sqli1.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }
}
