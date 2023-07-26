package experimentalEvaluationTests.Apps.Java;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaVulnerableLabTests {
    private static TaintSpecification spec = new TaintSpecification(); 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Java/Apps/Java-Vulnerable-Lab";

    public JavaVulnerableLabTests(){}

    @BeforeEach
    public void setUp(){
        settings = new Settings();
        spec = new TaintSpecification();
        settings.setFileExtension("java");
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }
    
    @Test
    public void add_page() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "AddPage"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("delete"), 
            new FuncDefinition("write")));
        spec.setFileName("AddPage.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 2);
    }

    @Test
    public void email_check() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "EmailCheck"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("EmailCheck.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void forward_me() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "ForwardMe"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("getRequestDispatcher")));
        spec.setFileName("ForwardMe.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void login_validator() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "LoginValidator"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("LoginValidator.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void open() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "Open"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("sendRedirect")));
        spec.setFileName("Open.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void register() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "Register"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeUpdate")));
        spec.setFileName("Register.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 2);
    }

    @Test
    public void send_message() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "SendMessage"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeUpdate")));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString")));
        spec.setFileName("SendMessage.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void username_check() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "UsernameCheck"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("UsernameCheck.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void xpath_query() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "XPathQuery"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("compile")));
        spec.setFileName("XPathQuery.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }
}