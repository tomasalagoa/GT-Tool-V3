package experimentalEvaluationTests.Apps.Python;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VulpyTests {
    private static TaintSpecification spec; 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Python/Apps/Vulpy";

    public VulpyTests(){}

    @BeforeEach
    public void setUp(){
        settings = new Settings();
        spec = new TaintSpecification();
        settings.setFileExtension("py");
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void libposts_getposts() throws Exception{
        spec.setFunction(new FuncDefinition("get_posts"));
        spec.setTaintedVarsOrArgs(List.of("username"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("libposts.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void libposts_post() throws Exception{
        spec.setFunction(new FuncDefinition("post"));
        spec.setTaintedVarsOrArgs(List.of("username", "text"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("libposts.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void libuser_login() throws Exception{
        spec.setFunction(new FuncDefinition("login"));
        spec.setTaintedVarsOrArgs(List.of("username", "password"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("libuser.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void libuser_create() throws Exception{
        spec.setFunction(new FuncDefinition("create"));
        spec.setTaintedVarsOrArgs(List.of("username", "password"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("libuser.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void libuser_userlist() throws Exception{
        spec.setFunction(new FuncDefinition("userlist"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("libuser.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void libuser_changepassword() throws Exception{
        spec.setFunction(new FuncDefinition("password_change"));
        spec.setTaintedVarsOrArgs(List.of("username", "password"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("libuser.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void libmfa_mfaenabled() throws Exception{
        spec.setFunction(new FuncDefinition("mfa_is_enabled"));
        spec.setTaintedVarsOrArgs(List.of("username"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("libmfa.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void libmfa_mfaenable() throws Exception{
        spec.setFunction(new FuncDefinition("mfa_enable"));
        spec.setTaintedVarsOrArgs(List.of("username"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("libmfa.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void libmfa_mfagetsecret() throws Exception{
        spec.setFunction(new FuncDefinition("mfa_get_secret"));
        spec.setTaintedVarsOrArgs(List.of("username"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("libmfa.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void libmfa_mfaresetsecret() throws Exception{
        spec.setFunction(new FuncDefinition("mfa_reset_secret"));
        spec.setTaintedVarsOrArgs(List.of("username"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("libmfa.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }
}
