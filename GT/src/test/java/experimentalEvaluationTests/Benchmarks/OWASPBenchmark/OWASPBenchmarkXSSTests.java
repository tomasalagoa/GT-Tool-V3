package experimentalEvaluationTests.Benchmarks.OWASPBenchmark;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OWASPBenchmarkXSSTests {
    private static TaintSpecification spec; 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Java/Benchmarks/OWASP-Benchmark/XSS";

    public OWASPBenchmarkXSSTests(){}

    @BeforeEach
    public void setUp(){
        settings = new Settings();
        spec = new TaintSpecification();
        settings.setFileExtension("java");
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void benchmark_test00013() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00013"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("format")));
        spec.setFileName("BenchmarkTest00013.java");
        AstConverter.analyse(DirectoryPath + "/test00013", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00014() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00014"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("format")));
        spec.setFileName("BenchmarkTest00014.java");
        AstConverter.analyse(DirectoryPath + "/test00014", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00030() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00030"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("printf")));
        spec.setFileName("BenchmarkTest00030.java");
        AstConverter.analyse(DirectoryPath + "/test00030", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00036() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00036"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("write")));
        spec.setFileName("BenchmarkTest00036.java");
        AstConverter.analyse(DirectoryPath + "/test00036", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00041() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00041"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("write")));
        spec.setFileName("BenchmarkTest00041.java");
        AstConverter.analyse(DirectoryPath + "/test00041", settings);
        //FN because of the if(param == null) and if(param != null) impossible path. It is what it is
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00047() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00047"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("format")));
        spec.setFileName("BenchmarkTest00047.java");
        AstConverter.analyse(DirectoryPath + "/test00047", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00049() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00049"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("write")));
        spec.setFileName("BenchmarkTest00049.java");
        AstConverter.analyse(DirectoryPath + "/test00049", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00144() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00144"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("format")));
        spec.setFileName("BenchmarkTest00144.java");
        AstConverter.analyse(DirectoryPath + "/test00144", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00147() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00147"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("format")));
        spec.setFileName("BenchmarkTest00147.java");
        AstConverter.analyse(DirectoryPath + "/test00147", settings);
        //This vulnerability is a FP due to ArrayList
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00150() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00150"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("printf")));
        spec.setFileName("BenchmarkTest00150.java");
        AstConverter.analyse(DirectoryPath + "/test00150", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00155() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00155"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("println")));
        spec.setFileName("BenchmarkTest00155.java");
        AstConverter.analyse(DirectoryPath + "/test00155", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00275() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00275"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("print")));
        spec.setFileName("BenchmarkTest00275.java");
        AstConverter.analyse(DirectoryPath + "/test00275", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00277() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00277"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("print")));
        spec.setFileName("BenchmarkTest00277.java");
        AstConverter.analyse(DirectoryPath + "/test00277", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00282() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00282"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("printf")));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("encodeForHTML")));
        spec.setFileName("BenchmarkTest00282.java");
        AstConverter.analyse(DirectoryPath + "/test00282", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00285() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00285"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("println")));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("encodeForHTML")));
        spec.setFileName("BenchmarkTest00285.java");
        AstConverter.analyse(DirectoryPath + "/test00285", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00287() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00287"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("write")));
        spec.setFileName("BenchmarkTest00287.java");
        AstConverter.analyse(DirectoryPath + "/test00287", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00290() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00290"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("write")));
        spec.setFileName("BenchmarkTest00290.java");
        AstConverter.analyse(DirectoryPath + "/test00290", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00292() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00292"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("write")));
        spec.setFileName("BenchmarkTest00292.java");
        AstConverter.analyse(DirectoryPath + "/test00292", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00301() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00301"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("write")));
        spec.setFileName("BenchmarkTest00301.java");
        AstConverter.analyse(DirectoryPath + "/test00301", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00377() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00377"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("format")));
        spec.setFileName("BenchmarkTest00377.java");
        AstConverter.analyse(DirectoryPath + "/test00377", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00382() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00382"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("printf")));
        spec.setFileName("BenchmarkTest00382.java");
        AstConverter.analyse(DirectoryPath + "/test00382", settings);
        //FN because of the if(param == null) and if(param != null) impossible path. It is what it is
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00385() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00385"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("printf")));
        spec.setFileName("BenchmarkTest00385.java");
        AstConverter.analyse(DirectoryPath + "/test00385", settings);
        //FN because of the if(param == null) path. It is what it is
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00388() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00388"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("println")));
        spec.setFileName("BenchmarkTest00388.java");
        AstConverter.analyse(DirectoryPath + "/test00388", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00390() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00390"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("println")));
        spec.setFileName("BenchmarkTest00390.java");
        AstConverter.analyse(DirectoryPath + "/test00390", settings);
        //FN because of the if(param == null) and if(param != null) impossible path. It is what it is
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00395() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00395"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("write")));
        spec.setFileName("BenchmarkTest00395.java");
        AstConverter.analyse(DirectoryPath + "/test00395", settings);
        //FN because of the if(param == null) and if(param != null) impossible path. It is what it is
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00467() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00467"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("format")));
        spec.setFileName("BenchmarkTest00467.java");
        AstConverter.analyse(DirectoryPath + "/test00467", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00470() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00470"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("print")));
        spec.setFileName("BenchmarkTest00470.java");
        AstConverter.analyse(DirectoryPath + "/test00470", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00475() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00475"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("println")));
        spec.setFileName("BenchmarkTest00475.java");
        AstConverter.analyse(DirectoryPath + "/test00475", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00477() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00477"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("println")));
        spec.setFileName("BenchmarkTest00477.java");
        AstConverter.analyse(DirectoryPath + "/test00477", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00492() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00492"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("write")));
        spec.setFileName("BenchmarkTest00492.java");
        AstConverter.analyse(DirectoryPath + "/test00492", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }
}
