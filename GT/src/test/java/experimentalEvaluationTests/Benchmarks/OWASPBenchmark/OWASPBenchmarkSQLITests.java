package experimentalEvaluationTests.Benchmarks.OWASPBenchmark;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OWASPBenchmarkSQLITests {
    private static TaintSpecification spec; 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Java/Benchmarks/OWASP-Benchmark/SQL_Injection";

    public OWASPBenchmarkSQLITests(){}

    @BeforeEach
    public void setUp(){
        settings = new Settings();
        spec = new TaintSpecification();
        settings.setFileExtension("java");
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void benchmark_test00008() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00008"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("BenchmarkTest00008.java");
        AstConverter.analyse(DirectoryPath + "/test00008", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00018() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00018"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeUpdate")));
        spec.setFileName("BenchmarkTest00018.java");
        AstConverter.analyse(DirectoryPath + "/test00018", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00025() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00025"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("queryForObject")));
        spec.setFileName("BenchmarkTest00025.java");
        AstConverter.analyse(DirectoryPath + "/test00025", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00032() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00032"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("BenchmarkTest00032.java");
        AstConverter.analyse(DirectoryPath + "/test00032", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00037() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00037"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("BenchmarkTest00037.java");
        AstConverter.analyse(DirectoryPath + "/test00037", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00043() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00043"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeUpdate")));
        spec.setFileName("BenchmarkTest00043.java");
        AstConverter.analyse(DirectoryPath + "/test00043", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00052() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00052"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("BenchmarkTest00052.java");
        AstConverter.analyse(DirectoryPath + "/test00052", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00100() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00100"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("BenchmarkTest00100.java");
        AstConverter.analyse(DirectoryPath + "/test00100", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00101() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00101"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("BenchmarkTest00101.java");
        AstConverter.analyse(DirectoryPath + "/test00101", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00107() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00107"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("BenchmarkTest00107.java");
        AstConverter.analyse(DirectoryPath + "/test00107", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00110() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00110"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("BenchmarkTest00110.java");
        AstConverter.analyse(DirectoryPath + "/test00110", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00112() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00112"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeUpdate")));
        spec.setFileName("BenchmarkTest00112.java");
        AstConverter.analyse(DirectoryPath + "/test00112", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00115() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00115"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeUpdate")));
        spec.setFileName("BenchmarkTest00115.java");
        AstConverter.analyse(DirectoryPath + "/test00115", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00190() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00190"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("BenchmarkTest00190.java");
        AstConverter.analyse(DirectoryPath + "/test00190", settings);
        //This vulnerability is a FP due to ArrayList
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00193() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00193"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("BenchmarkTest00193.java");
        AstConverter.analyse(DirectoryPath + "/test00193", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00196() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00196"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("BenchmarkTest00196.java");
        AstConverter.analyse(DirectoryPath + "/test00196", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00197() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00197"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("query")));
        spec.setFileName("BenchmarkTest00197.java");
        AstConverter.analyse(DirectoryPath + "/test00197", settings);
        //This vulnerability is a FP due to ArrayList
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00200() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00200"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("batchUpdate")));
        spec.setFileName("BenchmarkTest00200.java");
        AstConverter.analyse(DirectoryPath + "/test00200", settings);
        //This vulnerability is a FP due to ArrayList
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00201() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00201"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("batchUpdate")));
        spec.setFileName("BenchmarkTest00201.java");
        AstConverter.analyse(DirectoryPath + "/test00201", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00205() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00205"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeUpdate")));
        spec.setFileName("BenchmarkTest00205.java");
        AstConverter.analyse(DirectoryPath + "/test00205", settings);
        //This vulnerability is a FP due to ArrayList
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00329() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00329"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("BenchmarkTest00329.java");
        AstConverter.analyse(DirectoryPath + "/test00329", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00330() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00330"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("BenchmarkTest00330.java");
        AstConverter.analyse(DirectoryPath + "/test00330", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00335() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00335"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("BenchmarkTest00335.java");
        AstConverter.analyse(DirectoryPath + "/test00335", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00337() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00337"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("queryForObject")));
        spec.setFileName("BenchmarkTest00337.java");
        AstConverter.analyse(DirectoryPath + "/test00337", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00341() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00341"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("batchUpdate")));
        spec.setFileName("BenchmarkTest00341.java");
        AstConverter.analyse(DirectoryPath + "/test00341", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00344() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00344"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("BenchmarkTest00344.java");
        AstConverter.analyse(DirectoryPath + "/test00344", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00432() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00432"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("queryForList")));
        spec.setFileName("BenchmarkTest00432.java");
        AstConverter.analyse(DirectoryPath + "/test00432", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00433() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00433"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("queryForList")));
        spec.setFileName("BenchmarkTest00433.java");
        AstConverter.analyse(DirectoryPath + "/test00433", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void benchmark_test00437() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00437"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("BenchmarkTest00437.java");
        AstConverter.analyse(DirectoryPath + "/test00437", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void benchmark_test00440() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "BenchmarkTest00440"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("outputUpdateComplete")));
        spec.setFileName("BenchmarkTest00440.java");
        AstConverter.analyse(DirectoryPath + "/test00440", settings);
        //This vulnerability is a FP due to Map
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }
}
