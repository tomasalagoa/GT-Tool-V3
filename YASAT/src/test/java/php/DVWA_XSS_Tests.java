package php;

import ist.yasat.AstConverter;
import ist.yasat.settings.FuncDefinition;
import ist.yasat.settings.Settings;
import ist.yasat.settings.TaintSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DVWA_XSS_Tests {
    private TaintSpecification spec;
    private final Settings settings;
    private final String DirectoryPath = "src/test/resources/php/dvwp/xss_r";

    public DVWA_XSS_Tests() {
        settings = new Settings();
        settings.setFileExtension("php");
    }


    @BeforeEach
    public void setUp() {
        spec = new TaintSpecification();
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
        spec.setSanitizationFunctions(List.of(new FuncDefinition("htmlspecialchars")));
        spec.setTaintedVarsOrArgs(List.of("$_GET['name']"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("echo")));
        spec.setReturnTaintedIfTaintedSource(true);
    }


    @Test
    public void low() throws Exception {
        spec.setFileName("low.php");
        AstConverter.analyse(DirectoryPath + "/low.php", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void medium() throws Exception {
        spec.setFileName("medium.php");
        AstConverter.analyse(DirectoryPath + "/medium.php", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void high() throws Exception {
        spec.setFileName("high.php");
        AstConverter.analyse(DirectoryPath + "/high.php", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void impossible() throws Exception {
        spec.setFileName("impossible.php");
        AstConverter.analyse(DirectoryPath + "/impossible.php", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

}
