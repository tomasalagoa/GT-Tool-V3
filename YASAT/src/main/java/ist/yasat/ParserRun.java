package ist.yasat;

public class ParserRun {

    public static void main(String[] args) throws Exception {
//        AstConverter.analyseAndProduceReport("src/main/resources/example/AnotherDir/LoginServlet.java", "src/main/resources/settings.json");
        AstConverter.analyseAndProduceReport("C:/Users/mihail/Desktop/Tese/WebGoat/webgoat-lessons/cross-site-scripting/src/main/java/org/owasp/webgoat/xss/CrossSiteScriptingLesson5a.java",
                "src/main/resources/settings.json");
//        AstConverter.analyseAndProduceReport("src/main/resources/example/example1.php", "src/main/resources/settingsphp.json");
        System.out.println("Success");

//        AstConverter.convertDirectory("src/main/resources/example", "java");
    }
}
