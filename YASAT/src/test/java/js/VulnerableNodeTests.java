package js;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VulnerableNodeTests {
    private TaintSpecification spec;
    private final Settings settings;
    private final String DirectoryPath = "src/test/resources/js/vulnerable-node/SQLI/";

    public VulnerableNodeTests() {
        settings = new Settings();
        settings.setFileExtension("js");
    }


    @BeforeEach
    public void setUp() {
        spec = new TaintSpecification();
        settings.setSpecification(spec);
        spec.setReturnTaintedIfTaintedSource(true);
    }


    @Test
    public void do_auth() throws Exception {
        spec.setFunction(new FuncDefinition("do_auth"));
        spec.setTaintedVarsOrArgs(List.of("username", "password"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("one")));
        spec.setFileName("sqli1.js");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void list_products() throws Exception {
        spec.setFunction(new FuncDefinition("list_products"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("many")));
        spec.setFileName("sqli1.js");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 0);
    }

    @Test
    public void getProduct() throws Exception {
        spec.setFunction(new FuncDefinition("getProduct"));
        spec.setTaintedVarsOrArgs(List.of("product_id"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("one")));
        spec.setFileName("sqli1.js");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void search() throws Exception {
        spec.setFunction(new FuncDefinition("search"));
        spec.setTaintedVarsOrArgs(List.of("query"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("many")));
        spec.setFileName("sqli1.js");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void purchase() throws Exception {
        spec.setFunction(new FuncDefinition("purchase"));
        spec.setTaintedVarsOrArgs(List.of("cart"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("one")));
        spec.setFileName("sqli1.js");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }

    @Test
    public void get_purcharsed() throws Exception {
        spec.setFunction(new FuncDefinition("get_purcharsed"));
        spec.setTaintedVarsOrArgs(List.of("username"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("many")));
        spec.setFileName("sqli1.js");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }


    @Test
    public void findUserById() throws Exception {
        spec.setFunction(new FuncDefinition("findUserById", "UsersModel"));
        spec.setTaintedVarsOrArgs(List.of("parameter"));
        spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
        spec.setFileName("sqli1.js");
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.report.getVulnerabilities().size(), 1);
    }
}
