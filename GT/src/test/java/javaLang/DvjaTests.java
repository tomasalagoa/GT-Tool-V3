package javaLang;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DvjaTests {

    private TaintSpecification spec;
    private final Settings settings;
    private final String DirectoryPath = "src/test/resources/javalang/dvja";

    public DvjaTests() {
        settings = new Settings();
        settings.setFileExtension("java");
    }


    @BeforeEach
    public void setUp() {
        spec = new TaintSpecification(new FuncDefinition("search"), new ArrayList<>(),
                List.of(new FuncDefinition("getResultList", "Query")));
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }


    @Test
    public void UserAction() throws Exception {
        spec.setFileName("UserAction.java");
        spec.setTaintedAttributes(List.of("login"));
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }
}
