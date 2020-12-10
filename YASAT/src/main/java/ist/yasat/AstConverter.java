package ist.yasat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ist.yasat.gastBuilder.TaintVisitor;
import ist.yasat.languages.java.listener.JavaFileListener;
import ist.yasat.languages.java.parser.Java8Lexer;
import ist.yasat.languages.java.parser.Java8Parser;
import ist.yasat.languages.js.listener.JsFileListener;
import ist.yasat.languages.js.parser.JavaScriptLexer;
import ist.yasat.languages.js.parser.JavaScriptParser;
import ist.yasat.languages.php.listener.PhpFileListener;
import ist.yasat.languages.php.parser.PhpLexer;
import ist.yasat.languages.php.parser.PhpParser;
import ist.yasat.languages.python.listener.PythonFileListener;
import ist.yasat.languages.python.parser.PythonLexer;
import ist.yasat.languages.python.parser.PythonParser;
import ist.yasat.model.File;
import ist.yasat.settings.Settings;
import ist.yasat.util.Report;
import ist.yasat.util.Vulnerability;
import lombok.Data;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.time.StopWatch;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Data
public class AstConverter {

    private static final String reportFilePath = "src/main/resources/report.json";

    private static final ObjectMapper jsonMapper = new ObjectMapper();
    public static Report report = new Report();


    private static File convertFile(String filePath) throws Exception {
        Path path = Path.of(filePath);
        var fileExtension = FilenameUtils.getExtension(filePath);

        CharStream input = CharStreams.fromFileName(path.toString());
        ParseTreeWalker walker = new ParseTreeWalker();

        switch (fileExtension) {
            case "php" -> {
                CommonTokenStream tokens = new CommonTokenStream(new PhpLexer(input));
                PhpParser parser = new PhpParser(tokens);
                PhpParser.PhpBlockContext tree = parser.phpBlock();
                var listener = new PhpFileListener(path.getFileName().toString());
                walker.walk(listener, tree);
                return listener.getGastBuilder().getFile();
            }
            case "java" -> {
                CommonTokenStream tokens = new CommonTokenStream(new Java8Lexer(input));
                var tree = new Java8Parser(tokens).compilationUnit();
                var listener = new JavaFileListener(path.getFileName().toString());
                walker.walk(listener, tree);
                return listener.getGastBuilder().getFile();
            }
            case "js" -> {
                CommonTokenStream tokens = new CommonTokenStream(new JavaScriptLexer(input));
                var tree = new JavaScriptParser(tokens).program();
                var listener = new JsFileListener(path.getFileName().toString());
                walker.walk(listener, tree);
                return listener.getGastBuilder().getFile();
            }
            case "py" -> {
                CommonTokenStream tokens = new CommonTokenStream(new PythonLexer(input));
                var tree = new PythonParser(tokens).root();
                var listener = new PythonFileListener(path.getFileName().toString());
                walker.walk(listener, tree);
                return listener.getGastBuilder().getFile();
            }
            default -> throw new Exception("File extension not supported");
        }


    }


    public static List<File> getFilesFromDirectory(String directoryPath, String extension) throws IOException {
        var files = new ArrayList<File>();
        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
            paths.filter(path -> Files.isRegularFile(path) && FilenameUtils.getExtension(path.toString()).equals(extension))
                    .forEach(path -> {
                        try {
                            File file = convertFile(path.toString());
                            file.setPath(path);
                            files.add(file);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
        }
        return files;
    }

    public static void analyseAndProduceReport(String directoryPath, String settingsPath) throws Exception {
        Settings settings = jsonMapper.readValue(new FileInputStream(settingsPath), Settings.class);
        analyseAndProduceReport(directoryPath, settings);
    }

    public static void analyseAndProduceReport(String directoryPath, Settings settings) throws Exception {
        AstConverter.clearReport();
        analyse(directoryPath, settings);
        writeReport();
    }

    public static void analyse(String directoryPath, Settings settings) throws IOException {
        report = new Report();
        StopWatch sw = new StopWatch();
        sw.start();
        List<File> files = getFilesFromDirectory(directoryPath, settings.getFileExtension());
        TaintVisitor taintVisitor = new TaintVisitor(files, settings);
        taintVisitor.start();
        sw.stop();
        report.setTimeToProcessMilliseconds(sw.getTime(TimeUnit.MILLISECONDS));
    }

    private static void addMessage(String message) {
        try (FileWriter fw = new FileWriter(reportFilePath, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(message);
            out.println();
        } catch (IOException e) {
            System.out.println("An error has occurred while trying to append to file");
        }
    }

    public static void addVulnerability(Vulnerability vulnerability) {
        report.getVulnerabilities().add(vulnerability);
    }

    private static void writeReport() {
        try {
            addMessage(jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(report));
        } catch (JsonProcessingException e) {
            System.out.println("An error has occurred while trying to serialize report");
        }
    }

    private static void clearReport() {
        java.io.File f = new java.io.File(reportFilePath);
        if (f.exists() && !f.isDirectory()) {
            try {
                new PrintWriter(reportFilePath).close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
