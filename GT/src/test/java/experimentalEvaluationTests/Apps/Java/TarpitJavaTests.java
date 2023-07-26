package experimentalEvaluationTests.Apps.Java;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarpitJavaTests {
    private static TaintSpecification spec; 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Java/Apps/Tarpit";

    public TarpitJavaTests(){}

    @BeforeEach
    public void setUp(){
        settings = new Settings();
        spec = new TaintSpecification();
        settings.setFileExtension("java");
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void file_uploader() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "FileUploader"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("write")));
        spec.setFileName("FileUploader.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void insider() throws Exception {
        spec.setFunction(new FuncDefinition("doGet", "Insider"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec"), new FuncDefinition("executeQuery"), new FuncDefinition("println")));
        spec.setFileName("Insider.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 2);
    }

    @Test
    public void login_handler_servlet() throws Exception {
        spec.setFunction(new FuncDefinition("doPost", "LoginHandlerServlet"));
        spec.setTaintedVarsOrArgs(List.of("req", "resp"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("login")));
        spec.setFileName("LoginHandlerServlet.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void order_processor() throws Exception {
        spec.setFunction(new FuncDefinition("doGet", "OrderProcessor"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("send")));
        spec.setFileName("OrderProcessor.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void order_status() throws Exception {
        spec.setFunction(new FuncDefinition("doGet", "OrderStatus"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("OrderStatus.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void servlet_tarpit() throws Exception {
        spec.setFunction(new FuncDefinition("doGet", "ServletTarPit"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("getDocument"), new FuncDefinition("eval"), 
            new FuncDefinition("executeQuery"), new FuncDefinition("addCookie")));
        spec.setFileName("ServletTarPit.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 4);
    }

    @Test
    public void unzipper() throws Exception {
        spec.setFunction(new FuncDefinition("unzipFile", "Unzipper"));
        spec.setTaintedVarsOrArgs(List.of("zipFileWithAbsolutePath", "destination"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("delete"), 
            new FuncDefinition("createDirectory")));
        spec.setFileName("Unzipper.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 5);
    }
}