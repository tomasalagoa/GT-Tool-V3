package experimentalEvaluationTests.Benchmarks.OWASPBenchmark;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OWASPBenchmarkLDAPITests {
    private static TaintSpecification spec; 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Java/Benchmarks/OWASP-Benchmark/LDAP_Injection";

    public OWASPBenchmarkLDAPITests(){}

    @BeforeEach
    public void setUp(){
        settings = new Settings();
        spec = new TaintSpecification();
        settings.setFileExtension("java");
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void benchmark_test00012() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00012"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("search")));
        spec.setFileName("BenchmarkTest00012.java");
        AstConverter.analyse(DirectoryPath + "/test00012", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00021() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00021"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("search")));
        spec.setFileName("BenchmarkTest00021.java");
        AstConverter.analyse(DirectoryPath + "/test00021", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00044() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00044"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("search")));
        spec.setFileName("BenchmarkTest00044.java");
        AstConverter.analyse(DirectoryPath + "/test00044", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00138() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00138"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("search")));
        spec.setFileName("BenchmarkTest00138.java");
        AstConverter.analyse(DirectoryPath + "/test00138", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00139() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00139"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("search")));
        spec.setFileName("BenchmarkTest00139.java");
        AstConverter.analyse(DirectoryPath + "/test00139", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00367() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00367"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("search")));
        spec.setFileName("BenchmarkTest00367.java");
        AstConverter.analyse(DirectoryPath + "/test00367", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }
}
