package experimentalEvaluationTests.Apps.Java;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TerracottaBankTests {
    private static TaintSpecification spec = new TaintSpecification(); 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Java/Apps/Terracotta-Bank";

    public TerracottaBankTests(){}

    @BeforeEach
    public void setUp(){
        settings = new Settings();
        spec = new TaintSpecification();
        settings.setFileExtension("java");
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void accountservice_findById() throws Exception{
        spec.setFunction(new FuncDefinition("findById", "AccountService"));
        spec.setTaintedVarsOrArgs(List.of("id"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("runQuery")));
        spec.setFileName("AccountService.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void accountservice_findByUsername() throws Exception{
        spec.setFunction(new FuncDefinition("findByUsername", "AccountService"));
        spec.setTaintedVarsOrArgs(List.of("username"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("runQuery")));
        spec.setFileName("AccountService.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void accountservice_findByAccountNumber() throws Exception{
        spec.setFunction(new FuncDefinition("findByAccountNumber", "AccountService"));
        spec.setTaintedVarsOrArgs(List.of("accountNumber"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("runQuery")));
        spec.setFileName("AccountService.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void accountservice_findAll() throws Exception{
        spec.setFunction(new FuncDefinition("findAll", "AccountService"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("runQuery")));
        spec.setFileName("AccountService.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void accountservice_findDefaultAccountForUser() throws Exception{
        spec.setFunction(new FuncDefinition("findDefaultAccountForUser", "AccountService"));
        spec.setTaintedVarsOrArgs(List.of("user"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("runQuery")));
        spec.setFileName("AccountService.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void accountservice_addAccount() throws Exception{
        spec.setFunction(new FuncDefinition("addAccount", "AccountService"));
        spec.setTaintedVarsOrArgs(List.of("account"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("runUpdate")));
        spec.setFileName("AccountService.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void accountservice_makeDeposit() throws Exception{
        spec.setFunction(new FuncDefinition("makeDeposit", "AccountService"));
        spec.setTaintedVarsOrArgs(List.of("account", "check"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("runUpdate"), new FuncDefinition("runQuery")));
        spec.setFileName("AccountService.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 2);
    }

    @Test
    public void accountservice_transferMoney() throws Exception{
        spec.setFunction(new FuncDefinition("transferMoney", "AccountService"));
        spec.setTaintedVarsOrArgs(List.of("from", "to", "amount"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("runUpdate"), new FuncDefinition("runQuery")));
        spec.setFileName("AccountService.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 3);
    }

    @Test
    public void check_lookup_servlet() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "CheckLookupServlet"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("write")));
        spec.setFileName("CheckLookupServlet.java");
        AstConverter.analyse(DirectoryPath, settings);
        //FN because of context.get(CheckService.class).findCheckImage(checkNumber, baos);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void checkservice_addcheck() throws Exception{
        spec.setFunction(new FuncDefinition("addCheck", "CheckService"));
        spec.setTaintedVarsOrArgs(List.of("check"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("runUpdate")));
        spec.setFileName("CheckService.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void checkservice_updatecheckimage() throws Exception{
        spec.setFunction(new FuncDefinition("updateCheckImage", "CheckService"));
        spec.setTaintedVarsOrArgs(List.of("checkNumber", "is"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("write")));
        spec.setFileName("CheckService.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void checkservice_findcheckimage() throws Exception{
        spec.setFunction(new FuncDefinition("findCheckImage", "CheckService"));
        spec.setTaintedVarsOrArgs(List.of("checkNumber", "is"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("write")));
        spec.setFileName("CheckService.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void contact_us_servlet() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "ContactUsServlet"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("runUpdate")));
        spec.setFileName("ContactUsServlet.java");
        AstConverter.analyse(DirectoryPath, settings);
        //FN similar problem to check lookup servlet
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void document_servlet() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "DocumentServlet"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("write", "OutputStream")));
        spec.setFileName("DocumentServlet.java");
        AstConverter.analyse(DirectoryPath, settings);
        //2 FP
        assertEquals(AstConverter.report.getVulnerabilities().size(), 3);
    }

    @Test
    public void employee_login_servlet() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "EmployeeLoginServlet"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("runQuery")));
        spec.setFileName("EmployeeLoginServlet.java");
        AstConverter.analyse(DirectoryPath, settings);
        //FN similar problem as in check lookup servlet and contact us servlet
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void login_servlet() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "LoginServlet"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("runQuery")));
        spec.setFileName("LoginServlet.java");
        AstConverter.analyse(DirectoryPath, settings);
        //2 FN similar problem as in check lookup servlet and contact us servlet
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void make_deposit_servlet() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "MakeDepositServlet"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("runQuery"), 
            new FuncDefinition("runUpdate"), new FuncDefinition("write")));
        spec.setFileName("MakeDepositServlet.java");
        AstConverter.analyse(DirectoryPath, settings);
        //4 FN similar problem as in check lookup servlet and contact us servlet
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void messageservice_findall() throws Exception{
        spec.setFunction(new FuncDefinition("findAll", "MessageService"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("runQuery")));
        spec.setFileName("MessageService.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void messageservice_addmessage() throws Exception{
        spec.setFunction(new FuncDefinition("addMessage", "MessageService"));
        spec.setTaintedVarsOrArgs(List.of("message"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("runUpdate")));
        spec.setFileName("MessageService.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void transfer_money_servlet() throws Exception{
        spec.setFunction(new FuncDefinition("doPost", "TransferMoneyServlet"));
        spec.setTaintedVarsOrArgs(List.of("request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("runQuery"), 
            new FuncDefinition("runUpdate")));
        spec.setFileName("TransferMoneyServlet.java");
        AstConverter.analyse(DirectoryPath, settings);
        //1 FN similar problem as in check lookup servlet and contact us servlet
        assertEquals(AstConverter.report.getVulnerabilities().size(), 2);
    }

    @Test
    public void userservice_adduser() throws Exception{
        spec.setFunction(new FuncDefinition("addUser", "UserService"));
        spec.setTaintedVarsOrArgs(List.of("user"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("runUpdate")));
        spec.setFileName("UserService.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void userservice_findbyusernameandpassword() throws Exception{
        spec.setFunction(new FuncDefinition("findByUsernameAndPassword", "UserService"));
        spec.setTaintedVarsOrArgs(List.of("username", "password"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("runQuery")));
        spec.setFileName("UserService.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }
}
