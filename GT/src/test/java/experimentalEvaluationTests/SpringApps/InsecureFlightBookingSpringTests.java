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

}
