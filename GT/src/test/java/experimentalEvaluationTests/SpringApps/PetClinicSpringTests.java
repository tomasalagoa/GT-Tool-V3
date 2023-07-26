package experimentalEvaluationTests.SpringApps;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetClinicSpringTests {
    private static TaintSpecification spec = new TaintSpecification(); 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Java/Spring-Apps/Spring-PetClinic";

    public PetClinicSpringTests(){
        settings = new Settings();
        settings.setFileExtension("java");
        settings.setSpecification(spec);
        settings.setFramework("Spring");
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void PetClinicSpring() throws Exception {
        spec.setSensitiveFunctions(List.of(new FuncDefinition("findById", "OwnerRepository"), 
            new FuncDefinition("save"), new FuncDefinition("findByLastName"), 
            new FuncDefinition("findAll")));
        
        AstConverter.analyse(DirectoryPath, settings); 
        assertEquals(AstConverter.vulnerabilitiesInReport, 9);
    }
}
