package experimentalEvaluationTests.SpringApps;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsecureFlightBookingSpringTests {
    private static TaintSpecification spec = new TaintSpecification(); 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Java/Spring-Apps/Insecure-Flight-Booking";

    public InsecureFlightBookingSpringTests(){}

    @BeforeEach
    public void setUp(){
        settings = new Settings();
        spec = new TaintSpecification();
        settings.setFileExtension("java");
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void VulnadoSpring() throws Exception {
        spec.setSensitiveFunctions(List.of(new FuncDefinition("findByUsername"), 
            new FuncDefinition("findById"), new FuncDefinition("delete"), new FuncDefinition("save"),
            new FuncDefinition("findAllByUser"), new FuncDefinition("saveAndFlush"),
            new FuncDefinition("findFlightByFlightID"), new FuncDefinition("findAllByUserAndCancelledIsFalse"),
            new FuncDefinition("findAllByUserAndCancelledIsTrue"), new FuncDefinition("findFlightByReservations"),
            new FuncDefinition("findAllByReservationsAndArrivalDateTimeAfter"),
            new FuncDefinition("findAllByReservationsAndArrivalDateTimeBetween"),
            new FuncDefinition("findAllByReservationsAndArrivalDateTimeBefore"), 
            new FuncDefinition("findByUserAndFlight"), new FuncDefinition("findByEmail"), 
            new FuncDefinition("findByGuestAndFlight"), new FuncDefinition("findOneByEmailAndId"),
            new FuncDefinition("deleteById")));
        settings.setFramework("Spring");
        AstConverter.analyse(DirectoryPath, settings);
        //11 + 32 (30 - 3FN (2 if-else and 1 because same name functions :/)) + 42 (35 | 10FN - 6 same name function) + 26
        assertEquals(AstConverter.vulnerabilitiesInReport, 102);
    }

    /*@Test
    public void security_service_implementation_autologin() throws Exception{
        spec.setFunction(new FuncDefinition("autoLogin", "SecurityServiceImplementation"));
        spec.setTaintedVarsOrArgs(List.of("username", "password", "req"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("loadUserByUsername")));
        spec.setFileName("SecurityServiceImplementation.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void user_details_service_implementation_loaduserbyusername() throws Exception{
        spec.setFunction(new FuncDefinition("loadUserByUsername", "UserDetailsServiceImplementation"));
        spec.setTaintedVarsOrArgs(List.of("username"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("findByUsername")));
        spec.setFileName("UserDetailsServiceImplementation.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void user_service_implementation_save() throws Exception{
        spec.setFunction(new FuncDefinition("save", "UserServiceImplementation"));
        spec.setTaintedVarsOrArgs(List.of("user"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("saveAndFlush")));
        spec.setFileName("UserServiceImplementation.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void user_service_implementation_guestsave() throws Exception{
        spec.setFunction(new FuncDefinition("guestSave", "UserServiceImplementation"));
        spec.setTaintedVarsOrArgs(List.of("user"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("save")));
        spec.setFileName("UserServiceImplementation.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void user_service_implementation_findbyusername() throws Exception{
        spec.setFunction(new FuncDefinition("findByUsername", "UserServiceImplementation"));
        spec.setTaintedVarsOrArgs(List.of("username"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("findByUsername")));
        spec.setFileName("UserServiceImplementation.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void user_service_implementation_findbyemail() throws Exception{
        spec.setFunction(new FuncDefinition("findByEmail", "UserServiceImplementation"));
        spec.setTaintedVarsOrArgs(List.of("email"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("findByEmail")));
        spec.setFileName("UserServiceImplementation.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void user_service_implementation_findbyphone() throws Exception{
        spec.setFunction(new FuncDefinition("findByPhone", "UserServiceImplementation"));
        spec.setTaintedVarsOrArgs(List.of("phone"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("findByPhone")));
        spec.setFileName("UserServiceImplementation.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void user_service_implementation_savetoken() throws Exception{
        spec.setFunction(new FuncDefinition("save", "UserServiceImplementation"));
        spec.setTaintedVarsOrArgs(List.of("token"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("save")));
        spec.setFileName("UserServiceImplementation.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void user_service_implementation_isvalidtoken() throws Exception{
        spec.setFunction(new FuncDefinition("isValidToken", "UserServiceImplementation"));
        spec.setTaintedVarsOrArgs(List.of("jwtToken"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("findByJwtToken"),
            new FuncDefinition("findByEmail"), new FuncDefinition("save")));
        spec.setFileName("UserServiceImplementation.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 3);
    }

    @Test
    public void user_service_implementation_savepassword() throws Exception{
        spec.setFunction(new FuncDefinition("savePassword", "UserServiceImplementation"));
        spec.setTaintedVarsOrArgs(List.of("email", "password"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("save"), new FuncDefinition("findByEmail")));
        spec.setFileName("UserServiceImplementation.java");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 2);
    }*/
}
