package js;

import ist.yasat.AstConverter;
import ist.yasat.settings.FuncDefinition;
import ist.yasat.settings.Settings;
import ist.yasat.settings.TaintSpecification;
import ist.yasat.util.PropertySafe;
import ist.yasat.util.Util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VulnerableNodeTests {
    private TaintSpecification spec;
    private final Settings settings;
    private final String DirectoryPath = "src/test/resources/js/vulnerable-node/SQLI/";

    public VulnerableNodeTests() {
        settings = new Settings();
        settings.setFileExtension("js");
    }


    @BeforeEach
    public void setUp() {
        spec = new TaintSpecification(new FuncDefinition("do_auth"), List.of("username", "password"), List.of(new FuncDefinition("one")));
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }


    @Test
    public void sqli1() throws Exception {
        spec.setFileName("sqli1.js");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }
}
