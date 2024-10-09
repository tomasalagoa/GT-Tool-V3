package javaLang;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VulnadoTests {

    private TaintSpecification spec;
    private final Settings settings;
    private final String DirectoryPath = "src/test/resources/javalang/vulnado";

    public VulnadoTests() {
        settings = new Settings();
        settings.setFileExtension("java");
    }


    @BeforeEach
    public void setUp() {
        spec = new TaintSpecification(new FuncDefinition("login"), List.of("input"),
                List.of(new FuncDefinition("executeQuery", "Statement"), new FuncDefinition("executeUpdate", "Statement")));
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }


    @Test
    public void LoginController() throws Exception {
        spec.setFileName("LoginController.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void ssrf() throws Exception {
        spec.setFileName("LinksController.java");
        spec.setFunction(new FuncDefinition("links"));
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("connect", "Jsoup")));
        spec.setTaintedVarsOrArgs(List.of("url"));
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void cowsay() throws Exception {
        spec.setFileName("CowController.java");
        spec.setFunction(new FuncDefinition("cowsay"));
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("start", "ProcessBuilder")));
        spec.setTaintedVarsOrArgs(List.of("input"));
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }
}
