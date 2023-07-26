package experimentalEvaluationTests.Benchmarks.NISTJavaJuliet;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NISTJulietCMDITests {
    private static TaintSpecification spec; 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Java/Benchmarks/NIST-Juliet-Java/Command_Injection";

    public NISTJulietCMDITests(){}

    @BeforeEach
    public void setUp(){
        settings = new Settings();
        spec = new TaintSpecification();
        settings.setFileExtension("java");
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void connecttcp_test01() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__connect_tcp_01"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setFileName("CWE78_OS_Command_Injection__connect_tcp_01.java");
        AstConverter.analyse(DirectoryPath + "/connect_tcp/test01", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void connecttcp_test10() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__connect_tcp_10"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setFileName("CWE78_OS_Command_Injection__connect_tcp_10.java");
        AstConverter.analyse(DirectoryPath + "/connect_tcp/test10", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void connecttcp_test45() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__connect_tcp_45"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setFileName("CWE78_OS_Command_Injection__connect_tcp_45.java");
        AstConverter.analyse(DirectoryPath + "/connect_tcp/test45", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void connecttcp_test67() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__connect_tcp_67a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setFileName("CWE78_OS_Command_Injection__connect_tcp_67a.java");
        AstConverter.analyse(DirectoryPath + "/connect_tcp/test67", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void consolereadline_test05() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__console_readLine_05"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setFileName("CWE78_OS_Command_Injection__console_readLine_05.java");
        AstConverter.analyse(DirectoryPath + "/console_readLine/test05", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void consolereadline_test15() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__console_readLine_15"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setFileName("CWE78_OS_Command_Injection__console_readLine_15.java");
        AstConverter.analyse(DirectoryPath + "/console_readLine/test15", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void consolereadline_test51() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__console_readLine_51a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setFileName("CWE78_OS_Command_Injection__console_readLine_51a.java");
        AstConverter.analyse(DirectoryPath + "/console_readLine/test51", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void consolereadline_test71() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__console_readLine_71a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setFileName("CWE78_OS_Command_Injection__console_readLine_71a.java");
        AstConverter.analyse(DirectoryPath + "/console_readLine/test71", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void database_test06() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__database_06"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("ResultSet"));
        spec.setFileName("CWE78_OS_Command_Injection__database_06.java");
        AstConverter.analyse(DirectoryPath + "/database/test06", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void database_test16() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__database_16"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec"),
        new FuncDefinition("executeQuery")));
        spec.setUntrustedDataSources(List.of("ResultSet"));
        spec.setFileName("CWE78_OS_Command_Injection__database_16.java");
        AstConverter.analyse(DirectoryPath + "/database/test16", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void database_test61() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__database_61a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("ResultSet"));
        spec.setFileName("CWE78_OS_Command_Injection__database_61a.java");
        AstConverter.analyse(DirectoryPath + "/database/test61", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void database_test75() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__database_75a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("ResultSet", "ByteArrayOutputStream"));
        spec.setFileName("CWE78_OS_Command_Injection__database_75a.java");
        AstConverter.analyse(DirectoryPath + "/database/test75", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void environment_test07() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__Environment_07"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setGlobalTaintVariableRegex(List.of("System"));
        spec.setFileName("CWE78_OS_Command_Injection__Environment_07.java");
        AstConverter.analyse(DirectoryPath + "/environment/test07", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void environment_test17() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__Environment_17"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setGlobalTaintVariableRegex(List.of("System"));
        spec.setFileName("CWE78_OS_Command_Injection__Environment_17.java");
        AstConverter.analyse(DirectoryPath + "/environment/test17", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void environment_test53() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__Environment_53a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setGlobalTaintVariableRegex(List.of("System"));
        spec.setFileName("CWE78_OS_Command_Injection__Environment_53a.java");
        AstConverter.analyse(DirectoryPath + "/environment/test53", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void file_test10() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__File_10"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setFileName("CWE78_OS_Command_Injection__File_10.java");
        AstConverter.analyse(DirectoryPath + "/file/test10", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void file_test21() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__File_21"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setFileName("CWE78_OS_Command_Injection__File_21.java");
        AstConverter.analyse(DirectoryPath + "/file/test21", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void file_test67() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__File_67a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setFileName("CWE78_OS_Command_Injection__File_67a.java");
        AstConverter.analyse(DirectoryPath + "/file/test67", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void file_test81() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__File_81a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setFileName("CWE78_OS_Command_Injection__File_81a.java");
        AstConverter.analyse(DirectoryPath + "/file/test81", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void getcookies_test15() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__getCookies_Servlet_15"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setFileName("CWE78_OS_Command_Injection__getCookies_Servlet_15.java");
        AstConverter.analyse(DirectoryPath + "/getCookies/test15", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void getcookies_test22() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__getCookies_Servlet_22a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setFileName("CWE78_OS_Command_Injection__getCookies_Servlet_22a.java");
        AstConverter.analyse(DirectoryPath + "/getCookies/test22", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void getcookies_test71() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__getCookies_Servlet_71a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setFileName("CWE78_OS_Command_Injection__getCookies_Servlet_71a.java");
        AstConverter.analyse(DirectoryPath + "/getCookies/test71", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void getparameter_test16() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__getParameter_Servlet_16"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setFileName("CWE78_OS_Command_Injection__getParameter_Servlet_16.java");
        AstConverter.analyse(DirectoryPath + "/getParameter/test16", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void getparameter_test31() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__getParameter_Servlet_31"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setFileName("CWE78_OS_Command_Injection__getParameter_Servlet_31.java");
        AstConverter.analyse(DirectoryPath + "/getParameter/test31", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void getparameter_test75() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__getParameter_Servlet_75a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setUntrustedDataSources(List.of("ByteArrayOutputStream"));
        spec.setFileName("CWE78_OS_Command_Injection__getParameter_Servlet_75a.java");
        AstConverter.analyse(DirectoryPath + "/getParameter/test75", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void getquery_test17() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__getQueryString_Servlet_17"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setFileName("CWE78_OS_Command_Injection__getQueryString_Servlet_17.java");
        AstConverter.analyse(DirectoryPath + "/getQueryString/test17", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void getquery_test41() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__getQueryString_Servlet_41"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setFileName("CWE78_OS_Command_Injection__getQueryString_Servlet_41.java");
        AstConverter.analyse(DirectoryPath + "/getQueryString/test41", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void getquery_test81() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__getQueryString_Servlet_81a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setFileName("CWE78_OS_Command_Injection__getQueryString_Servlet_81a.java");
        AstConverter.analyse(DirectoryPath + "/getQueryString/test81", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void listentcp_test01() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__listen_tcp_01"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setFileName("CWE78_OS_Command_Injection__listen_tcp_01.java");
        AstConverter.analyse(DirectoryPath + "/listen_tcp/test01", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void listentcp_test21() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__listen_tcp_21"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setFileName("CWE78_OS_Command_Injection__listen_tcp_21.java");
        AstConverter.analyse(DirectoryPath + "/listen_tcp/test21", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void listentcp_test45() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__listen_tcp_45"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setFileName("CWE78_OS_Command_Injection__listen_tcp_45.java");
        AstConverter.analyse(DirectoryPath + "/listen_tcp/test45", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void propertiesfile_test06() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__PropertiesFile_06"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("Properties"));
        spec.setFileName("CWE78_OS_Command_Injection__PropertiesFile_06.java");
        AstConverter.analyse(DirectoryPath + "/propertiesfile/test06", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void propertiesfile_test31() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__PropertiesFile_31"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("Properties"));
        spec.setFileName("CWE78_OS_Command_Injection__PropertiesFile_31.java");
        AstConverter.analyse(DirectoryPath + "/propertiesfile/test31", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void propertiesfile_test53() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__PropertiesFile_53a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("Properties"));
        spec.setFileName("CWE78_OS_Command_Injection__PropertiesFile_53a.java");
        AstConverter.analyse(DirectoryPath + "/propertiesfile/test53", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void property_test05() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__Property_05"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setGlobalTaintVariableRegex(List.of("System"));
        spec.setFileName("CWE78_OS_Command_Injection__Property_05.java");
        AstConverter.analyse(DirectoryPath + "/property/test05", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void property_test22() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__Property_22a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setGlobalTaintVariableRegex(List.of("System"));
        spec.setFileName("CWE78_OS_Command_Injection__Property_22a.java");
        AstConverter.analyse(DirectoryPath + "/property/test22", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void property_test51() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__Property_51a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setGlobalTaintVariableRegex(List.of("System"));
        spec.setFileName("CWE78_OS_Command_Injection__Property_51a.java");
        AstConverter.analyse(DirectoryPath + "/property/test51", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void urlconnection_test07() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__URLConnection_07"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setFileName("CWE78_OS_Command_Injection__URLConnection_07.java");
        AstConverter.analyse(DirectoryPath + "/url_connection/test07", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void urlconnection_test41() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__URLConnection_41"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setFileName("CWE78_OS_Command_Injection__URLConnection_41.java");
        AstConverter.analyse(DirectoryPath + "/url_connection/test41", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void urlconnection_test61() throws Exception{
        spec.setFunction(new FuncDefinition("bad", "CWE78_OS_Command_Injection__URLConnection_61a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("exec")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setFileName("CWE78_OS_Command_Injection__URLConnection_61a.java");
        AstConverter.analyse(DirectoryPath + "/url_connection/test61", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }
}
