package javaLang;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebGoatJavaTests {

    private TaintSpecification spec;
    private final Settings settings;
    private final String DirectoryPath = "src/test/resources/javalang/webgoat/sqlinjection/";

    public WebGoatJavaTests() {
        settings = new Settings();
        settings.setFileExtension("java");
    }

    @BeforeEach
    public void setUp() {
        spec = new TaintSpecification(new FuncDefinition("injectableQuery"), List.of("query"),
                List.of(new FuncDefinition("executeQuery", "Statement"), new FuncDefinition("executeQuery", "PreparedStatement"),
                        new FuncDefinition("executeUpdate","Statement")));
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void WebGoatSqlInjectionLesson2() throws Exception {
        spec.setFileName("SqlInjectionLesson2.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "introduction/lesson2", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void WebGoatSqlInjectionLesson3() throws Exception {
        spec.setFileName("SqlInjectionLesson3.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "introduction/lesson3", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void WebGoatSqlInjectionLesson4() throws Exception {
        spec.setFileName("SqlInjectionLesson4.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        AstConverter.analyse(DirectoryPath + "introduction/lesson4", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 2);
    }

    @Test
    public void WebGoatSqlInjectionLesson5a() throws Exception {
        spec.setFileName("SqlInjectionLesson5a.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        spec.setTaintedVarsOrArgs(List.of("accountName"));
        AstConverter.analyse(DirectoryPath + "introduction/lesson5a", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void WebGoatSqlInjectionLesson5b() throws Exception {
        spec.setFileName("SqlInjectionLesson5b.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        spec.setTaintedVarsOrArgs(List.of("accountName", "login_count"));
        AstConverter.analyse(DirectoryPath + "introduction/lesson5b", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void WebGoatSqlInjectionLesson8() throws Exception {
        spec.setFileName("SqlInjectionLesson8.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        spec.setTaintedVarsOrArgs(List.of("name", "auth_tan"));
        spec.getFunction().setName("injectableQueryConfidentiality");
        AstConverter.analyse(DirectoryPath + "introduction/lesson8", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 2);
    }

    @Test
    public void WebGoatSqlInjectionLesson9() throws Exception {
        spec.setFileName("SqlInjectionLesson9.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        spec.setTaintedVarsOrArgs(List.of("name", "auth_tan"));
        spec.getFunction().setName("injectableQueryIntegrity");
        AstConverter.analyse(DirectoryPath + "introduction/lesson9", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void WebGoatSqlInjectionLesson10() throws Exception {
        spec.setFileName("SqlInjectionLesson10.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        spec.setTaintedVarsOrArgs(List.of("action"));
        spec.getFunction().setName("injectableQueryAvailability");
        AstConverter.analyse(DirectoryPath + "introduction/lesson10", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void WebGoatSqlInjectionAdvancedChallenge() throws Exception {
        spec.setFileName("SqlInjectionChallenge.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        spec.setTaintedVarsOrArgs(List.of("username_reg", "email_reg", "password_reg"));
        spec.getFunction().setName("registerNewUser");
        AstConverter.analyse(DirectoryPath + "advanced/challenge", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }
}
