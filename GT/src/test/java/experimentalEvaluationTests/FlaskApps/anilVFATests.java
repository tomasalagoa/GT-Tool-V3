package experimentalEvaluationTests.FlaskApps;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class anilVFATests {
    private static TaintSpecification spec = new TaintSpecification(); 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Python/Flask-Apps/anil-VulnerableFlaskApp";

    public anilVFATests(){
        settings = new Settings();
        settings.setFileExtension("py");
        settings.setSpecification(spec);
        settings.setFramework("Flask");
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void anilVulnerableFlaskApp() throws Exception{
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
        new FuncDefinition("check_output", "subprocess"), new FuncDefinition("open"), 
        new FuncDefinition("write", "file"), new FuncDefinition("search", "re")));
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.vulnerabilitiesInReport, 7);
    }
}
