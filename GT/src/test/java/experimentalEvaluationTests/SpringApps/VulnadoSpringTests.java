package experimentalEvaluationTests.SpringApps;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VulnadoSpringTests {
    private static TaintSpecification spec = new TaintSpecification(); 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Java/Spring-Apps/Vulnado";

    public VulnadoSpringTests(){
        settings = new Settings();
        settings.setFileExtension("java");
        settings.setSpecification(spec);
        settings.setFramework("Spring");
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void VulnadoSpring() throws Exception {
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery", "Statement"), 
            new FuncDefinition("executeUpdate", "Statement"), new FuncDefinition("connect", "Jsoup"), 
            new FuncDefinition("start", "ProcessBuilder")));
        
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.vulnerabilitiesInReport, 4);
    }
}
