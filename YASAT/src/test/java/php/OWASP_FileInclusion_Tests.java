package php;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OWASP_FileInclusion_Tests {
    private TaintSpecification spec;
    private final Settings settings;
    private final String DirectoryPath = "src/test/resources/php/OWASP/FileInclusion";

    public OWASP_FileInclusion_Tests() {
        settings = new Settings();
        settings.setFileExtension("php");
    }


    @BeforeEach
    public void setUp() {
        spec = new TaintSpecification();
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
        spec.setSensitiveFunctions(List.of(new FuncDefinition("include")));
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void One() throws Exception {
        spec.setFileName("lvl1.php");
        spec.setTaintedVarsOrArgs(List.of("$_GET['file']"));
        AstConverter.analyse(DirectoryPath + "/1/lvl1.php", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void Two() throws Exception {
        spec.setFileName("lvl2.php");
        spec.setTaintedVarsOrArgs(List.of("$_GET['file']"));
        AstConverter.analyse(DirectoryPath + "/2/lvl2.php", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void Three() throws Exception {
        spec.setFileName("lvl3.php");
        spec.setTaintedVarsOrArgs(List.of("$_GET['file']"));
        AstConverter.analyse(DirectoryPath + "/3/lvl3.php", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void Four() throws Exception {
        spec.setFileName("lvl4.php");
        spec.setTaintedVarsOrArgs(List.of("$_GET['file']"));
        AstConverter.analyse(DirectoryPath + "/4/lvl4.php", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

}
