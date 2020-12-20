package php;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DVWA_EXEC_Tests {

    private TaintSpecification spec;
    private final Settings settings;
    private final String DirectoryPath = "src/test/resources/php/dvwp/exec";

    public DVWA_EXEC_Tests() {
        settings = new Settings();
        settings.setFileExtension("php");
    }

    @BeforeEach
    public void setUp() {
        spec = new TaintSpecification();
        settings.setSpecification(spec);
        spec.setTaintedVarsOrArgs(List.of("$_REQUEST['ip']"));
        spec.setReturnTaintedIfTaintedSource(true);
        spec.setSensitiveFunctions(List.of(new FuncDefinition("shell_exec")));
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void low() throws Exception {
        spec.setFileName("low.php");
        AstConverter.analyse(DirectoryPath + "/low.php", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 2);
    }

    @Test
    public void medium() throws Exception {
        spec.setFileName("medium.php");
        AstConverter.analyse(DirectoryPath + "/medium.php", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 2);
    }

    @Test
    public void high() throws Exception {
        spec.setFileName("high.php");
        AstConverter.analyse(DirectoryPath + "/high.php", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 2);
    }

    @Test
    public void impossible() throws Exception {
        spec.setFileName("impossible.php");
        AstConverter.analyse(DirectoryPath + "/impossible.php", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }
}
