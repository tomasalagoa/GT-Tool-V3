package javaLang;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaTaintTests {

    private static final TaintSpecification spec = new TaintSpecification(
        new FuncDefinition("method"), List.of("id"), List.of(
            new FuncDefinition("executeQuery"), new FuncDefinition("sensitiveSink")), 
            List.of(new FuncDefinition("sanitize")));
    private Settings settings;
    private final String DirectoryPath = "src/test/java/javaLang";


    public JavaTaintTests() {
        settings = new Settings();
        settings.setFileExtension("java");
        settings.setSpecification(spec);
    }

    @Test
    public void Simple_variable_taint() throws Exception {
        spec.setFileName("Simple_Variable_Taint.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "/simplevariabletaint", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void Clean_variable_taint() throws Exception {
        spec.setFileName("Clean_Variable_Taint.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "/cleantaint", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void Retaint_variable() throws Exception {
        spec.setFileName("Retaint_variable.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "/retaintvariable", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void funccall_taint_propagation() throws Exception {
        spec.setFileName("Funccall_Taint_Propagation.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "/funccallpropagation", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void funccall_taint_propagation1() throws Exception {
        spec.setFileName("Funccall_Taint_Propagation1.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "/funccallpropagation1", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }


    @Test
    public void funccall_taint_propagation_sanitize_taint() throws Exception {
        spec.setFileName("Funccall_Taint_Propagation_Sanitize_Taint.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "/funccallpropagationsanitize", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void while_cycle_not_tainted() throws Exception {
        spec.setFileName("While_Cycle_Not_Tainted.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "/whilenottainted", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void while_cycle_tainted() throws Exception {
        spec.setFileName("While_Cycle_Tainted.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "/whiletainted", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void include_files_tainted() throws Exception {
        spec.setFileName("Funccall_Taint_Propagation_Ex.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "/includefilestainted", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void include_files_not_tainted() throws Exception {
        spec.setFileName("Funccall_Taint_Propagation_Ex.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "/includefilesnottainted", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }
}
