package javaLang;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VulnadoFrameworkTest {
    private TaintSpecification spec = new TaintSpecification();
    private final Settings settings = new Settings();
    private final String DirectoryPath = "src/test/resources/javaLang/vulnado";

    public VulnadoFrameworkTest(){
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
