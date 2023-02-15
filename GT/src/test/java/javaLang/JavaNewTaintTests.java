package javaLang;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaNewTaintTests {

    private static TaintSpecification spec = new TaintSpecification(
        new FuncDefinition("method"), List.of("id"), List.of(
            new FuncDefinition("executeQuery"), new FuncDefinition("sensitiveSink")), 
            List.of(new FuncDefinition("sanitize"))); 
    private Settings settings;
    private final String DirectoryPath = "src/test/java/javaLang";


    public JavaNewTaintTests() {
        settings = new Settings();
        settings.setFileExtension("java");
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void constructor_example_tainted() throws Exception {
        spec.setFileName("ConstructorExample.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "/constructorexample", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void experiments_tainted() throws Exception {
        spec.setFileName("Experiments.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "/experiments", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 4);
    }

    @Test
    public void heritage_example_tainted() throws Exception {
        spec.setFileName("Cat.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "/heritageexample", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void list_example_tainted() throws Exception {
        spec.setFileName("ListExample.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "/listexample", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void map_example_tainted() throws Exception {
        spec.setFileName("MapExample.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "/mapexample", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void set_example_tainted() throws Exception {
        spec.setFileName("SetExample.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "/setexample", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void simple_conditional_expression_tainted() throws Exception {
        spec.setFileName("Simple_Conditional_Expression.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "/simpleconditionalexpression", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void simple_if_taint_propagation_tainted() throws Exception {
        spec.setFileName("Simple_If_Taint_Propagation.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "/simpleiftaintpropagation", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 2);
    }

    @Test
    public void stack_example_tainted() throws Exception {
        spec.setFileName("StackExample.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "/stackexample", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void subclass_before_superclass_example1_tainted() throws Exception {
        spec.setFileName("A.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "/subclassbeforesuperclass/example1", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 2);
    }
}
