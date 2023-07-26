package experimentalEvaluationTests.Apps.Python;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DSVPWAPythonTests {
    private static TaintSpecification spec; 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Python/Apps/DSVPWA";

    public DSVPWAPythonTests(){}

    @BeforeEach
    public void setUp(){
        settings = new Settings();
        spec = new TaintSpecification();
        settings.setFileExtension("py");
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void sqli_run() throws Exception{
        spec.setFunction(new FuncDefinition("run", "SQLinjection"));
        spec.setTaintedVarsOrArgs(List.of("self", "handler"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("attacks.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void xss_stored_run() throws Exception{
        spec.setFunction(new FuncDefinition("run", "XSSStored"));
        spec.setTaintedVarsOrArgs(List.of("self", "handler"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("attacks.py");
        AstConverter.analyse(DirectoryPath, settings);
        //1 FP line 92
        assertEquals(AstConverter.report.getVulnerabilities().size(), 2);
    }

    @Test
    public void cmdi_run() throws Exception{
        spec.setFunction(new FuncDefinition("run", "CommandInjection"));
        spec.setTaintedVarsOrArgs(List.of("self", "handler"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("join")));
        spec.setFileName("attacks.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void sessionhijacking_run() throws Exception{
        spec.setFunction(new FuncDefinition("run", "SessionHijacking"));
        spec.setTaintedVarsOrArgs(List.of("self", "handler"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("attacks.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void authbypass_run() throws Exception{
        spec.setFunction(new FuncDefinition("run", "AuthBypass"));
        spec.setTaintedVarsOrArgs(List.of("self", "handler"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("attacks.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 2);
    }

    @Test
    public void xsreqforg_run() throws Exception{
        spec.setFunction(new FuncDefinition("run", "XSRequestForgery"));
        spec.setTaintedVarsOrArgs(List.of("self", "handler"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("attacks.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 2);
    }

    @Test
    public void click_run() throws Exception{
        spec.setFunction(new FuncDefinition("run", "Clickjacking"));
        spec.setTaintedVarsOrArgs(List.of("self", "handler"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute")));
        spec.setFileName("attacks.py");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 2);
    }
}
