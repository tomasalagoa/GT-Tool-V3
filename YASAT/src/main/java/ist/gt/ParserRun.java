package ist.yasat;

public class ParserRun {

    public static void main(String[] args) throws Exception {
//        AstConverter.analyseAndProduceReport("src/main/resources/example/AnotherDir/LoginServlet.java", "src/main/resources/settings.json");
        AstConverter.analyseAndProduceReport("YASAT/src/main/resources/settingsphp.json");
//        AstConverter.analyseAndProduceReport("src/main/resources/example/example1.php", "src/main/resources/settingsphp.json");
        System.out.println("Success");

//        AstConverter.convertDirectory("src/main/resources/example", "java");
    }
}
