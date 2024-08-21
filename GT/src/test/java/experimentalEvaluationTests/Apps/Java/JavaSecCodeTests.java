package experimentalEvaluationTests.Apps.Java;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaSecCodeTests {
    private static TaintSpecification spec = new TaintSpecification(); 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Java/Apps/Java-Sec-Code";

    public JavaSecCodeTests(){}

    @BeforeEach
    public void setUp(){
        settings = new Settings();
        spec = new TaintSpecification();
        settings.setFileExtension("java");
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void file_upload() throws Exception{
        spec.setFunctionsToAnalyze(List.of(new FuncDefinition("singleFileUpload", 
                List.of("file", "redirectAttributes"), "FileUpload"), 
            new FuncDefinition("uploadPicture", List.of("multifile"), "FileUpload")));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("get"), 
            new FuncDefinition("write")));
        spec.setFileName("FileUpload.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.vulnerabilitiesInReport, 5);    
        
    }

    @Test
    public void jwt_token_service() throws Exception{
        spec.setFunctionsToAnalyze(List.of(new FuncDefinition("getUsernameFromToken", 
                List.of("token"), "JwtTokenService"),
            new FuncDefinition("getExpirationDateFromToken", List.of("token"), "JwtTokenService"), 
            new FuncDefinition("isTokenExpired", List.of("token"), "JwtTokenService"),
            new FuncDefinition("isUserLogout", List.of("token"), "JwtTokenService"), 
            new FuncDefinition("generateToken", List.of("authentication"), "JwtTokenService"),
            new FuncDefinition("isValidToken", List.of("token"), "JwtTokenService")));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("findByJwtToken"), 
            new FuncDefinition("withSubject"), new FuncDefinition("findByUsername")));
        spec.setFileName("JwtTokenService.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.vulnerabilitiesInReport, 8);
    }

    @Test
    public void path_traversal() throws Exception{
        spec.setFunctionsToAnalyze(List.of(new FuncDefinition("getImage", 
                List.of("filepath"), "PathTraversal"), 
            new FuncDefinition("getImageSec", List.of("filepath"), "PathTraversal")));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("readAllBytes"), 
            new FuncDefinition("get")));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("pathFilter")));
        spec.setFileName("PathTraversal.java");
        AstConverter.analyse(DirectoryPath, settings);
        //getImageSec is secure but tool will probably warn about 2 vulnerabilities
        assertEquals(AstConverter.vulnerabilitiesInReport, 4);
    }

    @Test
    public void rce() throws Exception{
        spec.setFunctionsToAnalyze(List.of(new FuncDefinition("CommandExec", List.of("cmd"), "Rce"), 
            new FuncDefinition("processBuilder", List.of("cmd"), "Rce"), 
            new FuncDefinition("jsEngine", List.of("jsurl"), "Rce"),
            new FuncDefinition("yarm", List.of("content"), "Rce"), 
            new FuncDefinition("secYarm", List.of("content"), "Rce"), 
            new FuncDefinition("groovyshell", List.of("content"), "Rce")));  
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec"), 
            new FuncDefinition("append"), new FuncDefinition("eval"), 
            new FuncDefinition("evaluate"), new FuncDefinition("load"),
            new FuncDefinition("start")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setFileName("Rce.java");
        AstConverter.analyse(DirectoryPath, settings);
        //secYarm is secure but tool will probably warn about 1 vulnerability
        assertEquals(AstConverter.vulnerabilitiesInReport, 8);
    }

    @Test
    public void spel() throws Exception{
        spec.setFunctionsToAnalyze(List.of(new FuncDefinition("rce", List.of("expression"), "SpEL"), 
            new FuncDefinition("main", List.of("args"), "SpEL")));  
        spec.setSensitiveFunctions(List.of(new FuncDefinition("parseExpression")));
        spec.setFileName("SpEL.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.vulnerabilitiesInReport, 1);
    }

    @Test
    public void sqli() throws Exception{
        spec.setFunctionsToAnalyze(List.of(new FuncDefinition("jdbc_sqli_vul", List.of("username"), "SQLI"), 
            new FuncDefinition("jdbc_sqli_sec", List.of("username"), "SQLI"),
            new FuncDefinition("jdbc_ps_vuln", List.of("username"), "SQLI"), 
            new FuncDefinition("mybatisVuln01", List.of("username"), "SQLI"),
            new FuncDefinition("mybatisVuln02", List.of("username"), "SQLI"), 
            new FuncDefinition("mybatisVuln03", List.of("sort"), "SQLI"), 
            new FuncDefinition("mybatisSec01", List.of("username"), "SQLI"), 
            new FuncDefinition("mybatisSec02", List.of("id"), "SQLI"),
            new FuncDefinition("mybatisOrderBySec04", List.of("sort"), "SQLI")));  
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery"), 
            new FuncDefinition("findByUserNameVuln01"), new FuncDefinition("findByUserNameVuln02"), 
            new FuncDefinition("findByUserNameVuln03"), new FuncDefinition("findByUserName"),
            new FuncDefinition("findById")));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("sqlFilter"), 
            new FuncDefinition("setString")));
        spec.setFileName("SQLI.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.vulnerabilitiesInReport, 7);
    }

    @Test
    public void ssti() throws Exception{
        spec.setFunction(new FuncDefinition("velocity", "SSTI"));  
        spec.setSensitiveFunctions(List.of(new FuncDefinition("evaluate")));
        spec.setTaintedVarsOrArgs(List.of("template"));
        spec.setFileName("SSTI.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void xstream_rce() throws Exception{
        spec.setFunction(new FuncDefinition("parseXml","XStreamRce"));
        spec.setTaintedVarsOrArgs(List.of("request"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("fromXML")));
        spec.setFileName("XStreamRce.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }
}