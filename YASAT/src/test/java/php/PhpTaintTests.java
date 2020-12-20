package php;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhpTaintTests {

    private static final TaintSpecification spec = new TaintSpecification(new FuncDefinition("first"), List.of("$id"), List.of(new FuncDefinition("mysql_query")),
            List.of(new FuncDefinition("sanitize")));
    private final Settings settings;
    private final String DirectoryPath = "src/test/java/php";


    public PhpTaintTests() {
        settings = new Settings();
        settings.setFileExtension("php");
        settings.setSpecification(spec);
    }

    @Test
    public void Simple_variable_taint() throws Exception {
        spec.setFileName("Simple_variable_taint.php");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void Clean_variable_taint() throws Exception {
        spec.setFileName("clean_variable_taint.php");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void Retaint_variable() throws Exception {
        spec.setFileName("retaint_variable.php");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void funccall_taint_propagation() throws Exception {
        spec.setFileName("funccall_taint_propagation.php");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void funccall_taint_propagation1() throws Exception {
        spec.setFileName("funccall_taint_propagation1.php");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }


    @Test
    public void funccall_taint_propagation_sanitize_taint() throws Exception {
        spec.setFileName("funccall_taint_propagation_sanitize_taint.php");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void while_cycle_not_tainted() throws Exception {
        spec.setFileName("while_cycle_not_tainted.php");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void while_cycle_tainted() throws Exception {
        spec.setFileName("while_cycle_tainted.php");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void include_files_tainted() throws Exception {
        spec.setFileName("funccall_taint_propagation.php");
        AstConverter.analyse("src/test/java/php/includefilestainted", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }
    @Test
    public void include_files_not_tainted() throws Exception {
        spec.setFileName("funccall_taint_propagation.php");
        AstConverter.analyse("src/test/java/php/includefilesnottainted", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }
}
