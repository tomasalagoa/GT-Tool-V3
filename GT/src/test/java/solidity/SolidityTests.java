package solidity;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolidityTests {
    private TaintSpecification spec;
    private final Settings settings;
    private final String DirectoryPath = "src/test/resources/solidity/reentrancy_simple/";

    public SolidityTests() {
        settings = new Settings();
        settings.setFileExtension("sol");
    }

    @BeforeEach
    public void setUp() {
        spec = new TaintSpecification();
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void reentrancy() throws Exception {
        spec.setFunction(new FuncDefinition("withdrawBalance"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("value")));
        spec.setTaintedVarsOrArgs(List.of("msg"));
        spec.setFileName("reentrancy_simple.sol");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(1, AstConverter.report.getVulnerabilities().size());
    }
}
