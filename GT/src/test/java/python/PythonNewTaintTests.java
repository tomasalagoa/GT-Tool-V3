package python;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PythonNewTaintTests {
    private TaintSpecification spec;
    private final Settings settings;
    private final String DirectoryPath = "src/test/resources/python/";

    public PythonNewTaintTests(){
        settings = new Settings();
        settings.setFileExtension("py");
    }

    @BeforeEach
    public void setUp(){
        spec = new TaintSpecification();
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void login_load_user() throws Exception{
        spec.setFunction(new FuncDefinition("load_user"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("get", "session")));
        spec.setTaintedVarsOrArgs(List.of("user_id"));
        spec.setFileName("login.py");
        AstConverter.analyse(DirectoryPath + "flaskApps/EVFA/routes", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void notes_get_notes_for_user() throws Exception{
        spec.setFunction(new FuncDefinition("get_notes_for_user"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("filter", "session")));
        spec.setTaintedVarsOrArgs(List.of("user_id"));
        spec.setFileName("notes.py");
        AstConverter.analyse(DirectoryPath + "flaskApps/EVFA/utils", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void experiments() throws Exception{
        spec.setFunction(new FuncDefinition("method"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setTaintedVarsOrArgs(List.of("id"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("sanitize")));
        spec.setFileName("Experiments.py");
        AstConverter.analyse("src/test/java/python/experiments", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 3);
    }
}
