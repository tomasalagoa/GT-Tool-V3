package python;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PythonTests {
    private TaintSpecification spec;
    private final Settings settings;
    private final String DirectoryPath = "src/test/resources/python/examples/sqli/";

    public PythonTests() {
        settings = new Settings();
        settings.setFileExtension("py");
    }


    @BeforeEach
    public void setUp() {
        spec = new TaintSpecification();
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }


    @Test
    public void sqli1() throws Exception {
        spec.setFunction(new FuncDefinition("execute_query"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setTaintedVarsOrArgs(List.of("name"));
        spec.setFileName("sqli1.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void login() throws Exception {
        spec.setFunction(new FuncDefinition("login"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setTaintedVarsOrArgs(List.of("username", "password"));
        spec.setFileName("sqli1.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void create() throws Exception {
        spec.setFunction(new FuncDefinition("create"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setTaintedVarsOrArgs(List.of("username", "password"));
        spec.setFileName("sqli1.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }


    @Test
    public void password_change() throws Exception {
        spec.setFunction(new FuncDefinition("password_change"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setTaintedVarsOrArgs(List.of("username", "password"));
        spec.setFileName("sqli1.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void get() throws Exception {
        spec.setFunction(new FuncDefinition("get", "User"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setTaintedVarsOrArgs(List.of("id_"));
        spec.setFileName("sqli1.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

     @Test
    public void get_by_username() throws Exception {
        spec.setFunction(new FuncDefinition("get_by_username", "User"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setTaintedVarsOrArgs(List.of("username"));
        spec.setFileName("sqli1.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }
}
