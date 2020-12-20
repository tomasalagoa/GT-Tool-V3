package php;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OWASP_XSS_Tests {
    private TaintSpecification spec;
    private final Settings settings;
    private final String DirectoryPath = "src/test/resources/php/OWASP/XSS";

    public OWASP_XSS_Tests() {
        settings = new Settings();
        settings.setFileExtension("php");
    }


    @BeforeEach
    public void setUp() {
        spec = new TaintSpecification();
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
        spec.setSensitiveFunctions(List.of(new FuncDefinition("echo")));
        spec.setReturnTaintedIfTaintedSource(true);

    }


    @Test
    public void One() throws Exception {
        spec.setFileName("XSS_level1.php");
        spec.setTaintedVarsOrArgs(List.of("$_GET[\"username\"]"));
        AstConverter.analyse(DirectoryPath + "/1/XSS_level1.php", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void Two() throws Exception {
        spec.setFileName("XSS_level2.php");
        spec.setTaintedVarsOrArgs(List.of("$_GET[\"username\"]"));
        AstConverter.analyse(DirectoryPath + "/2/XSS_level2.php", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void Three() throws Exception {
        spec.setFileName("XSS_level3.php");
        spec.setTaintedVarsOrArgs(List.of("$_GET[\"username\"]"));
        AstConverter.analyse(DirectoryPath + "/3/XSS_level3.php", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void Four() throws Exception {
        spec.setFileName("XSS_level4.php");
        spec.setTaintedVarsOrArgs(List.of("$_GET[\"username\"]"));
        AstConverter.analyse(DirectoryPath + "/4/XSS_level4.php", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void Five() throws Exception {
        spec.setFileName("XSS_level5.php");
        spec.setTaintedVarsOrArgs(List.of("$_GET[\"username\"]"));
        AstConverter.analyse(DirectoryPath + "/5/XSS_level5.php", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }


}
