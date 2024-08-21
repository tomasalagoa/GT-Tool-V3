package experimentalEvaluationTests.SpringApps;

import ist.gt.AstConverter;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JPetStoreSpringTests {
    private static TaintSpecification spec = new TaintSpecification(); 
    private Settings settings;
    private final String DirectoryPath = "src/test/resources/Experimental_Evaluation/Java/Spring-Apps/JPetStore";

    public JPetStoreSpringTests(){
        settings = new Settings();
        settings.setFileExtension("java");
        settings.setSpecification(spec);
        settings.setFramework("Spring");
        spec.setReturnTaintedIfTaintedSource(true);
    }

    @Test
    public void JPetStoreSpring() throws Exception {
        spec.setSensitiveFunctions(List.of(new FuncDefinition("insertAccount"),
            new FuncDefinition("insertProfile"), new FuncDefinition("insertSignon"),
            new FuncDefinition("getItem", "itemMapper"), 
            new FuncDefinition("getCategory", "categoryMapper"),
            new FuncDefinition("getProductListByCategory", "productMapper"),
            new FuncDefinition("selectProductList", "productMapper"),
            new FuncDefinition("getProduct", "productMapper"),
            new FuncDefinition("getItemListByProduct", "itemMapper"),
            new FuncDefinition("updateAccount", "accountMapper"), 
            new FuncDefinition("updateProfile", "accountMapper"),
            new FuncDefinition("updateSignon", "accountMapper"), 
            new FuncDefinition("insertOrder", "orderMapper"),
            new FuncDefinition("insertOrderStatus", "orderMapper"),
            new FuncDefinition("getOrdersByUsername", "orderMapper"),
            new FuncDefinition("getOrder", "orderMapper"), 
            new FuncDefinition("getOrderLines", "orderMapper")));
            //FN = 4 (2 happen due to getter/setter being done automatically, and so taint is lost)
            // (2 happens due to anonymous functions, eg, foreach(x -> {code here}))
        AstConverter.analyse(DirectoryPath, settings);
        assertEquals(AstConverter.vulnerabilitiesInReport, 14);
    }
}
