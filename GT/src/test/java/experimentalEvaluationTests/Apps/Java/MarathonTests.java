package experimentalEvaluationTests.Apps.Java;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarathonTests {
    private static TaintSpecification spec = new TaintSpecification(); 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Java/Apps/Marathon";

    public MarathonTests(){}

    @BeforeEach
    public void setUp(){
        settings = new Settings();
        spec = new TaintSpecification();
        settings.setFileExtension("java");
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void change_password_action() throws Exception{
        spec.setFunction(new FuncDefinition("execute","ChangePasswordAction"));
        spec.setTaintedVarsOrArgs(List.of("mapping", "form", "request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeUpdate")));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("ChangePasswordAction.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void create_account_action() throws Exception{
        spec.setFunction(new FuncDefinition("execute", "CreateAccountAction"));
        spec.setTaintedVarsOrArgs(List.of("mapping", "form", "request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeUpdate")));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString", "PreparedStatement")));
        spec.setFileName("CreateAccountAction.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void delete_all_results_action() throws Exception{
        spec.setFunction(new FuncDefinition("execute", "DeleteAllResultsAction"));
        spec.setTaintedVarsOrArgs(List.of("mapping", "form", "request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeUpdate")));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setLong", "PreparedStatement")));
        spec.setFileName("DeleteAllResultsAction.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void load_dynamic_runner_details_action() throws Exception{
        spec.setFunction(new FuncDefinition("execute", "LoadDynamicRunnerDetailsAction"));
        spec.setTaintedVarsOrArgs(List.of("mapping", "form", "request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeUpdate")));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setLong", "PreparedStatement")));
        spec.setFileName("LoadDynamicRunnerDetailsAction.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void search_runner_action() throws Exception{
        spec.setFunction(new FuncDefinition("execute","SearchRunnerAction"));
        spec.setTaintedVarsOrArgs(List.of("mapping", "form", "request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("SearchRunnerAction.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void show_marathons_action() throws Exception{
        spec.setFunction(new FuncDefinition("execute","ShowMarathonsAction"));
        spec.setTaintedVarsOrArgs(List.of("mapping", "form", "request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("ShowMarathonsAction.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void show_results_action() throws Exception{
        spec.setFunction(new FuncDefinition("execute", "ShowResultsAction"));
        spec.setTaintedVarsOrArgs(List.of("mapping", "form", "request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("ShowResultsAction.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void show_runner_action() throws Exception{
        spec.setFunction(new FuncDefinition("execute", "ShowRunnerAction"));
        spec.setTaintedVarsOrArgs(List.of("mapping", "form", "request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setLong")));
        spec.setFileName("ShowRunnerAction.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void show_runner_attendances_action() throws Exception{
        spec.setFunction(new FuncDefinition("execute", "ShowRunnerAttendancesAction"));
        spec.setTaintedVarsOrArgs(List.of("mapping", "form", "request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString"), 
            new FuncDefinition("setLong")));
        spec.setFileName("ShowRunnerAttendancesAction.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void show_runner_profile_action() throws Exception{
        spec.setFunction(new FuncDefinition("execute", "ShowRunnerProfileAction"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setString"), 
            new FuncDefinition("setLong")));
        spec.setFileName("ShowRunnerProfileAction.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void update_results_action() throws Exception{
        spec.setFunction(new FuncDefinition("execute", "UpdateResultsAction"));
        spec.setTaintedVarsOrArgs(List.of("mapping", "form", "request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery"), 
            new FuncDefinition("executeUpdate")));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setInt"), 
            new FuncDefinition("setLong")));
        spec.setFileName("UpdateResultsAction.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void update_results_via_import_action() throws Exception{
        spec.setFunction(new FuncDefinition("execute", "UpdateResultsViaImportAction"));
        spec.setTaintedVarsOrArgs(List.of("mapping", "form", "request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery"), 
            new FuncDefinition("executeUpdate")));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setInt"), 
            new FuncDefinition("setLong")));
        spec.setFileName("UpdateResultsViaImportAction.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void update_runner_attendances_action() throws Exception{
        spec.setFunction(new FuncDefinition("execute", "UpdateRunnerAttendancesAction"));
        spec.setTaintedVarsOrArgs(List.of("mapping", "form", "request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery"), 
            new FuncDefinition("executeUpdate")));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setLong"), 
        new FuncDefinition("setString")));
        spec.setFileName("UpdateRunnerAttendancesAction.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void update_runner_photo_action() throws Exception{
        spec.setFunction(new FuncDefinition("execute", "UpdateRunnerPhotoAction"));
        spec.setTaintedVarsOrArgs(List.of("mapping", "form", "request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery"), 
            new FuncDefinition("executeUpdate")));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setLong"), 
            new FuncDefinition("setString")));
        spec.setFileName("UpdateRunnerPhotoAction.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void update_runner_photo_via_import_action() throws Exception{
        spec.setFunction(new FuncDefinition("execute", "UpdateRunnerPhotoViaImportAction"));
        spec.setTaintedVarsOrArgs(List.of("mapping", "form", "request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery"), 
            new FuncDefinition("executeUpdate")));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setLong"), 
            new FuncDefinition("setString")));
        spec.setFileName("UpdateRunnerPhotoViaImportAction.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void update_runner_profile_action() throws Exception{
        spec.setFunction(new FuncDefinition("execute", "UpdateRunnerProfileAction"));
        spec.setTaintedVarsOrArgs(List.of("mapping", "form", "request", "response"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery"), 
            new FuncDefinition("executeUpdate")));
        spec.setSanitizationFunctions(List.of(new FuncDefinition("setLong"), 
            new FuncDefinition("setString"), new FuncDefinition("setDate")));
        spec.setFileName("UpdateRunnerProfileAction.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void has_runner_finished() throws Exception{
        spec.setFunction(new FuncDefinition("hasRunnerFinished", "RunnerDAO"));
        spec.setTaintedVarsOrArgs(List.of("runner"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("RunnerDAO.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }
}
