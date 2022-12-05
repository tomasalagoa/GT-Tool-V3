package ist.gt;

import java.util.List;

import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.settings.TaintSpecification;

public class ParserRun {
    private static final TaintSpecification spec = new TaintSpecification(
        new FuncDefinition("method"), List.of("id"), List.of(
            new FuncDefinition("executeQuery")), List.of(
                new FuncDefinition("sanitize")));
    private final static Settings settings = new Settings();
    private final static String DirectoryPath = "C:\\Users\\diogo\\Desktop\\MEIC-T\\2Ano\\Tese\\MasterDissertation\\GT-Tool-V2\\GT\\src\\test\\java\\javaLang";

    public static void main(String[] args) throws Exception {
//        AstConverter.analyseAndProduceReport("src/main/resources/example/AnotherDir/LoginServlet.java", "src/main/resources/settings.json");
//        AstConverter.analyseAndProduceReport("GT\\src\\main\\resources\\settings.json");
//        AstConverter.analyseAndProduceReport("src/main/resources/example/example1.php", "src/main/resources/settingsphp.json");
        settings.setFileExtension("java");
        spec.setFileName("Experiments.java");
        spec.getFunction().setType(spec.getFileName().replace(".java", ""));
        settings.setSpecification(spec);
        AstConverter.analyse(DirectoryPath + "\\experiments", settings);
        System.out.println("Success");

//        AstConverter.convertDirectory("src/main/resources/example", "java");
    }
}
