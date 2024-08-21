package experimentalEvaluationTests.Apps.Java;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebGoatUpdatedTests {
    private static TaintSpecification spec = new TaintSpecification(); 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Java/Apps/WebGoat-Updated/sqlinjection";

    public WebGoatUpdatedTests(){}

    @BeforeEach
    public void setUp(){
        settings = new Settings();
        spec = new TaintSpecification();
        settings.setFileExtension("java");
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void sql_injection_lesson2() throws Exception{
        spec.setFunction(new FuncDefinition("completed", "SqlInjectionLesson2"));
        spec.setTaintedVarsOrArgs(List.of("query"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("SqlInjectionLesson2.java");
        AstConverter.analyse(DirectoryPath + "/introduction/lesson2", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void sql_injection_lesson3() throws Exception{
        spec.setFunction(new FuncDefinition("completed", "SqlInjectionLesson3"));
        spec.setTaintedVarsOrArgs(List.of("query"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeUpdate"), 
            new FuncDefinition("executeQuery")));
        spec.setFileName("SqlInjectionLesson3.java");
        AstConverter.analyse(DirectoryPath + "/introduction/lesson3", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void sql_injection_lesson4() throws Exception{
        spec.setFunction(new FuncDefinition("completed", "SqlInjectionLesson4"));
        spec.setTaintedVarsOrArgs(List.of("query"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setFileName("SqlInjectionLesson4.java");
        AstConverter.analyse(DirectoryPath + "/introduction/lesson4", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 2);
    }

    @Test
    public void sql_injection_lesson5() throws Exception{
        spec.setFunction(new FuncDefinition("completed", "SqlInjectionLesson5"));
        spec.setTaintedVarsOrArgs(List.of("query"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("SqlInjectionLesson5.java");
        AstConverter.analyse(DirectoryPath + "/introduction/lesson5", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void sql_injection_lesson5a() throws Exception{
        spec.setFunction(new FuncDefinition("completed", "SqlInjectionLesson5a"));
        spec.setTaintedVarsOrArgs(List.of("account", "operator", "injection"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("SqlInjectionLesson5a.java");
        AstConverter.analyse(DirectoryPath + "/introduction/lesson5a", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void sql_injection_lesson5b() throws Exception{
        spec.setFunction(new FuncDefinition("completed", "SqlInjectionLesson5b"));
        spec.setTaintedVarsOrArgs(List.of("userid", "login_count", "request"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("SqlInjectionLesson5b.java");
        AstConverter.analyse(DirectoryPath + "/introduction/lesson5b", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void sql_injection_lesson8() throws Exception{
        spec.setFunction(new FuncDefinition("completed", "SqlInjectionLesson8"));
        spec.setTaintedVarsOrArgs(List.of("name", "auth_tan"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("SqlInjectionLesson8.java");
        AstConverter.analyse(DirectoryPath  + "/introduction/lesson8", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void sql_injection_lesson9() throws Exception{
        spec.setFunction(new FuncDefinition("completed", "SqlInjectionLesson9"));
        spec.setTaintedVarsOrArgs(List.of("name", "auth_tan"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("SqlInjectionLesson9.java");
        AstConverter.analyse(DirectoryPath  + "/introduction/lesson9", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void sql_injection_lesson10() throws Exception{
        spec.setFunction(new FuncDefinition("completed", "SqlInjectionLesson10"));
        spec.setTaintedVarsOrArgs(List.of("action_string"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("SqlInjectionLesson10.java");
        AstConverter.analyse(DirectoryPath  + "/introduction/lesson10", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void sql_injection_lesson6a() throws Exception{
        spec.setFunction(new FuncDefinition("completed", "SqlInjectionLesson6a"));
        spec.setTaintedVarsOrArgs(List.of("userid_6a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("SqlInjectionLesson6a.java");
        AstConverter.analyse(DirectoryPath + "/advanced/lesson6a", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void sql_injection_lesson6b() throws Exception{
        spec.setFunction(new FuncDefinition("completed", "SqlInjectionLesson6b"));
        spec.setTaintedVarsOrArgs(List.of("userid_6b"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("SqlInjectionLesson6b.java");
        AstConverter.analyse(DirectoryPath + "/advanced/lesson6b", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void sql_injection_challenge() throws Exception{
        spec.setFunction(new FuncDefinition("registerNewUser", "SqlInjectionChallenge"));
        spec.setTaintedVarsOrArgs(List.of("username_reg", "email_reg", "password_reg"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery"), 
            new FuncDefinition("execute")));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("SqlInjectionChallenge.java");
        AstConverter.analyse(DirectoryPath + "/advanced/challenge", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void sql_injection_challenge_login() throws Exception{
        spec.setFunction(new FuncDefinition("login", "SqlInjectionChallengeLogin"));
        spec.setTaintedVarsOrArgs(List.of("username_login", "password_login"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery"), 
            new FuncDefinition("execute")));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("SqlInjectionChallengeLogin.java");
        AstConverter.analyse(DirectoryPath + "/advanced/challengeLogin", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }
}
