package experimentalEvaluationTests.FlaskApps;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VFATests {
    private static TaintSpecification spec = new TaintSpecification(); 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Python/Flask-Apps/VulnerableFlaskApp";

    public VFATests(){
        settings = new Settings();
        settings.setFileExtension("py");
        settings.setSpecification(spec);
        settings.setFramework("Flask");
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void vulnerableFlaskApp() throws Exception{
        spec.setSensitiveFunctions(List.of(new FuncDefinition("add", "db"), 
        new FuncDefinition("filter_by", "User"), new FuncDefinition("get", "Customer"), 
        new FuncDefinition("execute", "db"), new FuncDefinition("save", "f")));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("secure_filename")));
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.vulnerabilitiesInReport, 8);
    }
}
