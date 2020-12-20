package php;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OWASP_SQL_Tests {
    private TaintSpecification spec;
    private final Settings settings;
    private final String DirectoryPath = "src/test/resources/php/OWASP/SQL";

    public OWASP_SQL_Tests() {
        settings = new Settings();
        settings.setFileExtension("php");
    }


    @BeforeEach
    public void setUp() {
        spec = new TaintSpecification();
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
        spec.setSensitiveFunctions(List.of(new FuncDefinition("mysqli_query")));
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void One() throws Exception {
        spec.setFileName("sql1.php");
        spec.setTaintedVarsOrArgs(List.of("$_POST[\"firstname\"]"));
        AstConverter.analyse(DirectoryPath + "/1/sql1.php", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void Two() throws Exception {
        spec.setFileName("sql2.php");
        spec.setTaintedVarsOrArgs(List.of("$_POST['number']"));
        AstConverter.analyse(DirectoryPath + "/2/sql2.php", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void Three() throws Exception {
        spec.setFileName("sql3.php");
        spec.setTaintedVarsOrArgs(List.of("$_POST['number']"));
        AstConverter.analyse(DirectoryPath + "/3/sql3.php", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void Four() throws Exception {
        spec.setFileName("sql4.php");
        spec.setTaintedVarsOrArgs(List.of("$_POST['number']"));
        AstConverter.analyse(DirectoryPath + "/4/sql4.php", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void Five() throws Exception {
        spec.setFileName("sql5.php");
        spec.setTaintedVarsOrArgs(List.of("$_POST['number']"));
        AstConverter.analyse(DirectoryPath + "/5/sql5.php", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void Six() throws Exception {
        spec.setFileName("sql6.php");
        spec.setTaintedVarsOrArgs(List.of("$_GET['number']"));
        AstConverter.analyse(DirectoryPath + "/6/sql6.php", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

}
