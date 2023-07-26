package experimentalEvaluationTests.Apps.Python;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VulnerableTornadoTests {
    private static TaintSpecification spec; 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Python/Apps/VulnerableTornado";

    public VulnerableTornadoTests(){}

    @BeforeEach
    public void setUp(){
        settings = new Settings();
        spec = new TaintSpecification();
        settings.setFileExtension("py");
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void server_post() throws Exception{
        spec.setFunction(new FuncDefinition("post", "UploadHandler"));
        spec.setTaintedVarsOrArgs(List.of("self"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("open"),
            new FuncDefinition("write")));
        spec.setFileName("server.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 2);
    }

    @Test
    public void server_get() throws Exception{
        spec.setFunction(new FuncDefinition("get", "SearchHandler"));
        spec.setTaintedVarsOrArgs(List.of("self"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("render")));
        spec.setFileName("server.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void server_userspost() throws Exception{
        spec.setFunction(new FuncDefinition("post", "UsersHandler"));
        spec.setTaintedVarsOrArgs(List.of("self"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("server.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void server_serverpost() throws Exception{
        spec.setFunction(new FuncDefinition("post", "ServerHandler"));
        spec.setTaintedVarsOrArgs(List.of("self"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("read")));
        spec.setFileName("server.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }
}
