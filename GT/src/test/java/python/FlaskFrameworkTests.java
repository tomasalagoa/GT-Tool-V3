package python;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlaskFrameworkTests {
    private TaintSpecification spec;
    private final Settings settings;
    private final String DirectoryPath = "src/test/resources/python/flaskApps/";

    public FlaskFrameworkTests(){
        settings = new Settings();
        settings.setFileExtension("py");
    }

    @BeforeEach
    public void setUp(){
        spec = new TaintSpecification();
        settings.setSpecification(spec);
        settings.setFramework("Flask");
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void extremelyVulnerableFlaskApp() throws Exception{
        spec.setSensitiveFunctions(List.of(new FuncDefinition("merge", "session"), 
        new FuncDefinition("filter", "session"), new FuncDefinition("update"), 
        new FuncDefinition("get", "session"), new FuncDefinition("add", "session"), 
        new FuncDefinition("delete", "session"), new FuncDefinition("where", "session"),
        new FuncDefinition("execute", "session")));
        AstConverter.analyse(DirectoryPath + "routes", settings);
        assertEquals(AstConverter.vulnerabilitiesInReport, 12);
    }

    @Test
    public void anilVulnerableFlaskApp() throws Exception{
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
        new FuncDefinition("check_output", "subprocess"), new FuncDefinition("open"), 
        new FuncDefinition("write", "file"), new FuncDefinition("search", "re")));
        AstConverter.analyse(DirectoryPath + "anil-VulnerableFlaskApp", settings);
        assertEquals(AstConverter.vulnerabilitiesInReport, 6);
    }
}
