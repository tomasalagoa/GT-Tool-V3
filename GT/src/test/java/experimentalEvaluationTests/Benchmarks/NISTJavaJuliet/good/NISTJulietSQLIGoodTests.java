package experimentalEvaluationTests.Benchmarks.NISTJavaJuliet.good;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NISTJulietSQLIGoodTests {
    private static TaintSpecification spec; 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Java/Benchmarks/NIST-Juliet-Java/SQLInjection/s01";

    public NISTJulietSQLIGoodTests(){}

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
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__connect_tcp_execute_01"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__connect_tcp_execute_01.java");
        AstConverter.analyse(DirectoryPath + "/connect_tcp/test01", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void connecttcp_test10() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__connect_tcp_executeBatch_10"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__connect_tcp_executeBatch_10.java");
        AstConverter.analyse(DirectoryPath + "/connect_tcp/test10", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void connecttcp_test45() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__connect_tcp_executeQuery_45"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__connect_tcp_executeQuery_45.java");
        AstConverter.analyse(DirectoryPath + "/connect_tcp/test45", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void connecttcp_test67() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__connect_tcp_executeUpdate_67a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__connect_tcp_executeUpdate_67a.java");
        AstConverter.analyse(DirectoryPath + "/connect_tcp/test67", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void consolereadline_test05() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__console_readLine_prepareStatement_05"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__console_readLine_prepareStatement_05.java");
        AstConverter.analyse(DirectoryPath + "/console_readLine/test05", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void consolereadline_test15() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__console_readLine_execute_15"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__console_readLine_execute_15.java");
        AstConverter.analyse(DirectoryPath + "/console_readLine/test15", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void consolereadline_test51() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__console_readLine_executeBatch_51a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__console_readLine_executeBatch_51a.java");
        AstConverter.analyse(DirectoryPath + "/console_readLine/test51", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void consolereadline_test71() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__console_readLine_executeQuery_71a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__console_readLine_executeQuery_71a.java");
        AstConverter.analyse(DirectoryPath + "/console_readLine/test71", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void database_test06() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__database_executeUpdate_06"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("ResultSet"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__database_executeUpdate_06.java");
        AstConverter.analyse(DirectoryPath + "/database/test06", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void database_test16() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__database_prepareStatement_16"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("ResultSet"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__database_prepareStatement_16.java");
        AstConverter.analyse(DirectoryPath + "/database/test16", settings);
        /**
         * Because we have an IfStatement inside a ConditionalStatement (while/for), it will
         * taint IO in line 306 and rerun (2nd iteration) the while cycle with IO propagating its taintedness which 
         * results in this FP!
         */
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void database_test61() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__database_execute_61a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("ResultSet"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__database_execute_61a.java");
        AstConverter.analyse(DirectoryPath + "/database/test61", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void database_test75() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__database_executeBatch_75a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("ResultSet", "ByteArrayOutputStream"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__database_executeBatch_75a.java");
        AstConverter.analyse(DirectoryPath + "/database/test75", settings);
        //FP here because of GoodSource to BadSink and saying ByteArray is untrusted :/
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void environment_test07() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__Environment_executeQuery_07"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setGlobalTaintVariableRegex(List.of("System"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__Environment_executeQuery_07.java");
        AstConverter.analyse(DirectoryPath + "/environment/test07", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void environment_test17() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__Environment_executeUpdate_17"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setGlobalTaintVariableRegex(List.of("System"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__Environment_executeUpdate_17.java");
        AstConverter.analyse(DirectoryPath + "/environment/test17", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void environment_test53() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__Environment_prepareStatement_53a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setGlobalTaintVariableRegex(List.of("System"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__Environment_prepareStatement_53a.java");
        AstConverter.analyse(DirectoryPath + "/environment/test53", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void file_test10() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__File_execute_10"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__File_execute_10.java");
        AstConverter.analyse(DirectoryPath + "/file/test10", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void file_test21() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__File_executeBatch_21"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__File_executeBatch_21.java");
        AstConverter.analyse(DirectoryPath + "/file/test21", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void file_test67() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__File_executeQuery_67a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__File_executeQuery_67a.java");
        AstConverter.analyse(DirectoryPath + "/file/test67", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void file_test81() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__File_executeUpdate_81a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__File_executeUpdate_81a.java");
        AstConverter.analyse(DirectoryPath + "/file/test81", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void getcookies_test15() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__getCookies_Servlet_prepareStatement_15"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__getCookies_Servlet_prepareStatement_15.java");
        AstConverter.analyse(DirectoryPath + "/getCookies/test15", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void getcookies_test22() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__getCookies_Servlet_execute_22a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__getCookies_Servlet_execute_22a.java");
        AstConverter.analyse(DirectoryPath + "/getCookies/test22", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void getcookies_test71() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__getCookies_Servlet_executeBatch_71a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__getCookies_Servlet_executeBatch_71a.java");
        AstConverter.analyse(DirectoryPath + "/getCookies/test71", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void getparameter_test16() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__getParameter_Servlet_executeQuery_16"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__getParameter_Servlet_executeQuery_16.java");
        AstConverter.analyse(DirectoryPath + "/getParameter/test16", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void getparameter_test31() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__getParameter_Servlet_executeUpdate_31"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__getParameter_Servlet_executeUpdate_31.java");
        AstConverter.analyse(DirectoryPath + "/getParameter/test31", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void getparameter_test75() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__getParameter_Servlet_prepareStatement_75a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setUntrustedDataSources(List.of("ByteArrayOutputStream"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__getParameter_Servlet_prepareStatement_75a.java");
        AstConverter.analyse(DirectoryPath + "/getParameter/test75", settings);
        //FP here because of GoodSource to BadSink and saying ByteArray is untrusted :/
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void getquery_test17() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__getQueryString_Servlet_execute_17"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__getQueryString_Servlet_execute_17.java");
        AstConverter.analyse(DirectoryPath + "/getQueryString/test17", settings);
        /**
         * Because we have an IfStatement inside a ConditionalStatement (while/for), it will
         * taint IO in line 202 and rerun (2nd iteration) the for cycle with IO propagating its taintedness which 
         * results in this FP!
         */
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void getquery_test41() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__getQueryString_Servlet_executeBatch_41"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__getQueryString_Servlet_executeBatch_41.java");
        AstConverter.analyse(DirectoryPath + "/getQueryString/test41", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void getquery_test81() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__getQueryString_Servlet_executeQuery_81a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__getQueryString_Servlet_executeQuery_81a.java");
        AstConverter.analyse(DirectoryPath + "/getQueryString/test81", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void listentcp_test01() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__listen_tcp_executeUpdate_01"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__listen_tcp_executeUpdate_01.java");
        AstConverter.analyse(DirectoryPath + "/listen_tcp/test01", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void listentcp_test21() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__listen_tcp_prepareStatement_21"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__listen_tcp_prepareStatement_21.java");
        AstConverter.analyse(DirectoryPath + "/listen_tcp/test21", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void listentcp_test45() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__listen_tcp_execute_45"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__listen_tcp_execute_45.java");
        AstConverter.analyse(DirectoryPath + "/listen_tcp/test45", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void propertiesfile_test06() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__PropertiesFile_executeBatch_06"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("Properties"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__PropertiesFile_executeBatch_06.java");
        AstConverter.analyse(DirectoryPath + "/propertiesfile/test06", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void propertiesfile_test31() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__PropertiesFile_executeQuery_31"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("Properties"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__PropertiesFile_executeQuery_31.java");
        AstConverter.analyse(DirectoryPath + "/propertiesfile/test31", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void propertiesfile_test53() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__PropertiesFile_executeUpdate_53a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("Properties"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__PropertiesFile_executeUpdate_53a.java");
        AstConverter.analyse(DirectoryPath + "/propertiesfile/test53", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void property_test05() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__Property_prepareStatement_05"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setGlobalTaintVariableRegex(List.of("System"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__Property_prepareStatement_05.java");
        AstConverter.analyse(DirectoryPath + "/property/test05", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void property_test22() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__Property_execute_22a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setGlobalTaintVariableRegex(List.of("System"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__Property_execute_22a.java");
        AstConverter.analyse(DirectoryPath + "/property/test22", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void property_test51() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__Property_executeBatch_51a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setGlobalTaintVariableRegex(List.of("System"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__Property_executeBatch_51a.java");
        AstConverter.analyse(DirectoryPath + "/property/test51", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void urlconnection_test07() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__URLConnection_executeQuery_07"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__URLConnection_executeQuery_07.java");
        AstConverter.analyse(DirectoryPath + "/url_connection/test07", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void urlconnection_test41() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__URLConnection_executeUpdate_41"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__URLConnection_executeUpdate_41.java");
        AstConverter.analyse(DirectoryPath + "/url_connection/test41", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void urlconnection_test61() throws Exception{
        spec.setFunction(new FuncDefinition("good", "CWE89_SQL_Injection__URLConnection_prepareStatement_61a"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("execute"), 
            new FuncDefinition("executeBatch"), new FuncDefinition("executeQuery"),
            new FuncDefinition("executeUpdate")));
        spec.setUntrustedDataSources(List.of("BufferedReader"));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CWE89_SQL_Injection__URLConnection_prepareStatement_61a.java");
        AstConverter.analyse(DirectoryPath + "/url_connection/test61", settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }
}
