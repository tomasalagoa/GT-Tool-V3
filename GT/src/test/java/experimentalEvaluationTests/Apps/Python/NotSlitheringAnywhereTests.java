package experimentalEvaluationTests.Apps.Python;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotSlitheringAnywhereTests {
    private static TaintSpecification spec; 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Python/Apps/NotSlitheringAnywhere";

    public NotSlitheringAnywhereTests(){}

    @BeforeEach
    public void setUp(){
        settings = new Settings();
        spec = new TaintSpecification();
        settings.setFileExtension("py");
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void routes_posts_add() throws Exception{
        spec.setFunction(new FuncDefinition("posts_add"));
        spec.setGlobalTaintVariableRegex(List.of("request", "session"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("filter_by"),
            new FuncDefinition("add")));
        spec.setFileName("routes.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 2);
    }

    @Test
    public void routes_posts() throws Exception{
        spec.setFunction(new FuncDefinition("posts"));
        spec.setGlobalTaintVariableRegex(List.of("request"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("filter")));
        spec.setFileName("routes.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void routes_people() throws Exception{
        spec.setFunction(new FuncDefinition("people"));
        spec.setGlobalTaintVariableRegex(List.of("request"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("routes.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void routes_people_id() throws Exception{
        spec.setFunction(new FuncDefinition("people_by_id"));
        spec.setTaintedVarsOrArgs(List.of("uid"));
        spec.setGlobalTaintVariableRegex(List.of("request"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("routes.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void routes_register() throws Exception{
        spec.setFunction(new FuncDefinition("register"));
        spec.setGlobalTaintVariableRegex(List.of("request"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("add")));
        spec.setFileName("routes.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void routes_login() throws Exception{
        spec.setFunction(new FuncDefinition("login"));
        spec.setGlobalTaintVariableRegex(List.of("request"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("filter_by")));
        spec.setFileName("routes.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }
}
