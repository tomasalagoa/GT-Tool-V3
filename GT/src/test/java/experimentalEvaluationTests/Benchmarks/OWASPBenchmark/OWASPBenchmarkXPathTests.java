package experimentalEvaluationTests.Benchmarks.OWASPBenchmark;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OWASPBenchmarkXPathTests {
    private static TaintSpecification spec = new TaintSpecification(); 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Java/Benchmarks/OWASP-Benchmark/XPath_Injection";

    public OWASPBenchmarkXPathTests(){}

    @BeforeEach
    public void setUp(){
        settings = new Settings();
        spec = new TaintSpecification();
        settings.setFileExtension("java");
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void benchmark_test00116() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00116"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("compile")));
        spec.setFileName("BenchmarkTest00116.java");
        AstConverter.analyse(DirectoryPath + "/test00116", settings);
        //Vulnerability is FP due to Map
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00117() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00117"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("compile")));
        spec.setFileName("BenchmarkTest00117.java");
        AstConverter.analyse(DirectoryPath + "/test00117", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00118() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00118"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("evaluate")));
        spec.setFileName("BenchmarkTest00118.java");
        AstConverter.analyse(DirectoryPath + "/test00118", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00207() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00207"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("evaluate")));
        spec.setFileName("BenchmarkTest00207.java");
        AstConverter.analyse(DirectoryPath + "/test00207", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00442() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00442"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("evaluate")));
        spec.setFileName("BenchmarkTest00442.java");
        AstConverter.analyse(DirectoryPath + "/test00442", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }
}
