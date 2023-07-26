package experimentalEvaluationTests.Benchmarks.OWASPBenchmark;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OWASPBenchmarkCommandInjectionTests {
    private static TaintSpecification spec; 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Java/Benchmarks/OWASP-Benchmark/Command_Injection";

    public OWASPBenchmarkCommandInjectionTests(){}

    @BeforeEach
    public void setUp(){
        settings = new Settings();
        spec = new TaintSpecification();
        settings.setFileExtension("java");
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void benchmark_test00006() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00006"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("start")));
        spec.setFileName("BenchmarkTest00006.java");
        AstConverter.analyse(DirectoryPath + "/test00006", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00007() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00007"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setFileName("BenchmarkTest00007.java");
        AstConverter.analyse(DirectoryPath + "/test00007", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00015() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00015"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("start")));
        spec.setFileName("BenchmarkTest00015.java");
        AstConverter.analyse(DirectoryPath + "/test00015", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00017() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00017"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setFileName("BenchmarkTest00017.java");
        AstConverter.analyse(DirectoryPath  + "/test00017", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00090() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00090"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setFileName("BenchmarkTest00090.java");
        AstConverter.analyse(DirectoryPath  + "/test00090", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00093() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00093"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setFileName("BenchmarkTest00093.java");
        AstConverter.analyse(DirectoryPath + "/test00093", settings);
        //This vulnerability is a FP due to ArrayList
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00158() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00158"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("start")));
        spec.setFileName("BenchmarkTest00158.java");
        AstConverter.analyse(DirectoryPath + "/test00158", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00171() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00171"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setFileName("BenchmarkTest00171.java");
        AstConverter.analyse(DirectoryPath + "/test00171", settings);
        //This vulnerability is a FP due to Map
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00172() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00172"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setFileName("BenchmarkTest00172.java");
        AstConverter.analyse(DirectoryPath + "/test00172", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00175() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00175"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setFileName("BenchmarkTest00175.java");
        AstConverter.analyse(DirectoryPath + "/test00175", settings);
        //This vulnerability is a FP due to Map
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00293() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00293"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("start")));
        spec.setFileName("BenchmarkTest00293.java");
        AstConverter.analyse(DirectoryPath + "/test00293", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00295() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00295"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("start")));
        spec.setFileName("BenchmarkTest00295.java");
        AstConverter.analyse(DirectoryPath + "/test00295", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00303() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00303"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setFileName("BenchmarkTest00303.java");
        AstConverter.analyse(DirectoryPath + "/test00303", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00306() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00306"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setFileName("BenchmarkTest00306.java");
        AstConverter.analyse(DirectoryPath + "/test00306", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00396() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00396"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("start")));
        spec.setFileName("BenchmarkTest00396.java");
        AstConverter.analyse(DirectoryPath + "/test00396", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00407() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00407"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setFileName("BenchmarkTest00407.java");
        AstConverter.analyse(DirectoryPath + "/test00407", settings);
        //FN because of the if(param == null) and if(param != null) path. It is what it is
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00410() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00410"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setFileName("BenchmarkTest00410.java");
        AstConverter.analyse(DirectoryPath + "/test00410", settings);
        //This vulnerability is a FP due to Map
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00481() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00481"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("start")));
        spec.setFileName("BenchmarkTest00481.java");
        AstConverter.analyse(DirectoryPath + "/test00481", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00495() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00495"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setFileName("BenchmarkTest00495.java");
        AstConverter.analyse(DirectoryPath + "/test00495", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00500() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00500"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setFileName("BenchmarkTest00500.java");
        AstConverter.analyse(DirectoryPath + "/test00500", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }
}
