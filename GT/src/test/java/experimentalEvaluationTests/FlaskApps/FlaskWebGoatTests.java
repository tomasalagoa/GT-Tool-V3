package experimentalEvaluationTests.FlaskApps;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlaskWebGoatTests {
    private static TaintSpecification spec = new TaintSpecification(); 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Python/Flask-Apps/FlaskWebGoat";

    public FlaskWebGoatTests(){
        settings = new Settings();
        settings.setFileExtension("py");
        settings.setSpecification(spec);
        settings.setFramework("Flask");
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void flaskWebGoatApp() throws Exception{
        spec.setSensitiveFunctions(List.of(new FuncDefinition("query_db"), 
        new FuncDefinition("run", "subprocess"), new FuncDefinition("write")));
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.vulnerabilitiesInReport, 6);
    }
}
