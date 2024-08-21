package experimentalEvaluationTests.FlaskApps;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EVFATests {
    private static TaintSpecification spec = new TaintSpecification(); 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Python/Flask-Apps/EVFA/routes";

    public EVFATests(){
        settings = new Settings();
        settings.setFileExtension("py");
        settings.setSpecification(spec);
        settings.setFramework("Flask");
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void extremelyVulnerableFlaskApp() throws Exception{
        spec.setSensitiveFunctions(List.of(new FuncDefinition("merge", "session"), 
        new FuncDefinition("filter", "session"), 
        new FuncDefinition("get", "session"), new FuncDefinition("add", "session"), 
        new FuncDefinition("delete", "session"), new FuncDefinition("where", "session"),
        new FuncDefinition("execute", "session")));
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.vulnerabilitiesInReport, 12);
    }
}
