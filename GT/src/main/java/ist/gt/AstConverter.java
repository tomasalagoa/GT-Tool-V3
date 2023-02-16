package ist.gt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ist.gt.gastBuilder.TaintVisitor;
import ist.gt.gastBuilder.frameworkEntrypointsFinder.FrameworkEntrypointsFinder;
import ist.gt.languages.java.listener.JavaFileListener;
import ist.gt.languages.java.parser.Java8Lexer;
import ist.gt.languages.java.parser.Java8Parser;
import ist.gt.languages.java.parser.Java8Parser.CompilationUnitContext;
import ist.gt.languages.js.listener.JsFileListener;
import ist.gt.languages.js.parser.JavaScriptLexer;
import ist.gt.languages.js.parser.JavaScriptParser;
import ist.gt.languages.php.listener.PhpFileListener;
import ist.gt.languages.php.parser.PhpLexer;
import ist.gt.languages.php.parser.PhpParser;
import ist.gt.languages.python.listener.PythonFileListener;
import ist.gt.languages.python.parser.PythonLexer;
import ist.gt.languages.python.parser.PythonParser;
import ist.gt.model.File;
import ist.gt.model.Class;
import ist.gt.settings.FuncDefinition;
import ist.gt.settings.Settings;
import ist.gt.util.Report;
import ist.gt.util.Vulnerability;

import lombok.Data;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeListener;
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

    private static final String reportFilePath = "C:\\Users\\diogo\\Desktop\\MEIC-T\\2Ano\\Tese\\MasterDissertation\\GT-Tool-V2\\GT\\src\\main\\resources\\report.json";

    private static final ObjectMapper jsonMapper = new ObjectMapper();
    public static Report report = new Report();
    //Propagate analyzed classes between files, especially useful for Java
    private static HashMap<String, Class> analyzedClasses;
    private static ArrayList<Integer> unknownMethodsLines;
    private static boolean isUsingFramework;
    private static String frameworkName;
    private static String fileName;
    private static HashMap<String, HashMap<String, ArrayList<String>>> filesEntrypoints;
    private static HashMap<String, ArrayList<String>> filesGlobalTaintedVariables;
    private static FrameworkEntrypointsFinder fef;
    public static int vulnerabilitiesInReport;

    private static File convertFile(String filePath) throws Exception {
        Path path = Path.of(filePath);
        var fileExtension = FilenameUtils.getExtension(filePath);

        CharStream input = CharStreams.fromFileName(path.toString());
        ParseTreeWalker walker = new ParseTreeWalker();

        switch (fileExtension) {
            case "php" -> {
                CommonTokenStream tokens = new CommonTokenStream(new PhpLexer(input));
                PhpParser parser = new PhpParser(tokens);
                PhpParser.HtmlElementOrPhpBlockContext tree = parser.htmlElementOrPhpBlock();
                var listener = new PhpFileListener(path.getFileName().toString());
                walker.walk(listener, tree);
                return listener.getGastBuilder().getFile();
            }
            case "java" -> {
                CommonTokenStream tokens = new CommonTokenStream(new Java8Lexer(input));
                var tree = new Java8Parser(tokens).compilationUnit();
                if(isUsingFramework){
                    System.out.println(path.getFileName().toString());
                    //getFrameworkStrategy(path.getFileName().toString(), walker, tree);
                    fef.useJavaFrameworkEntrypointsFinder(frameworkName, fileName, 
                        path.getFileName().toString(), walker, tree);
                    saveEntrypoints(path.getFileName().toString(), fef.getEntrypoints());
                    fef.cleanUp();
                    System.out.println("FrameworkEntrypointsFinder for Java has ended!");
                }
                var listener = new JavaFileListener(path.getFileName().toString());
                if(!analyzedClasses.isEmpty()){
                    listener.getGastBuilder().setAnalyzedClasses(analyzedClasses);
                }
                walker.walk(listener, tree);
                analyzedClasses = listener.getGastBuilder().getAnalyzedClasses();
                return listener.getGastBuilder().getFile();
            }
            case "js" -> {
                CommonTokenStream tokens = new CommonTokenStream(new JavaScriptLexer(input));
                var tree = new JavaScriptParser(tokens).program();
                var listener = new JsFileListener(path.getFileName().toString());
                if(!analyzedClasses.isEmpty()){
                    listener.getGastBuilder().setAnalyzedClasses(analyzedClasses);
                }
                walker.walk(listener, tree);
                analyzedClasses = listener.getGastBuilder().getAnalyzedClasses();
                return listener.getGastBuilder().getFile();
            }
            case "py" -> {
                CommonTokenStream tokens = new CommonTokenStream(new PythonLexer(input));
                var tree = new PythonParser(tokens).root();
                if(isUsingFramework){
                    System.out.println(path.getFileName().toString());
                    //getFrameworkStrategy(path.getFileName().toString(), walker, tree);
                    fef.usePythonFrameworkEntrypointsFinder(frameworkName, fileName, 
                        path.getFileName().toString(), walker, tree);
                    saveEntrypoints(path.getFileName().toString(), fef.getEntrypoints());
                    saveGlobalTaintedVariables(path.getFileName().toString(), fef.getGlobalTaintedVariables());
                    fef.cleanUp();
                    System.out.println("FrameworkEntrypointsFinder for Python has ended!");
                }
                var listener = new PythonFileListener(path.getFileName().toString());
                if(!analyzedClasses.isEmpty()){
                    listener.getGastBuilder().setAnalyzedClasses(analyzedClasses);
                }
                walker.walk(listener, tree);
                analyzedClasses = listener.getGastBuilder().getAnalyzedClasses();
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

    public static void analyseAndProduceReport(String settingsPath) throws Exception {
        Settings settings = jsonMapper.readValue(new FileInputStream(settingsPath), Settings.class);
        analyseAndProduceReport(settings);
    }

    public static void analyseAndProduceReport(Settings settings) throws Exception {
        AstConverter.clearReport();
        analyse(settings.getDirectory(), settings);
        writeReport();
    }

    public static void analyse(String directoryPath, Settings settings) throws IOException {
        report = new Report();
        StopWatch sw = new StopWatch();
        setUpAstConverter();
        if(settings.getFramework() != null){
            isUsingFramework = true;
            frameworkName = settings.getFramework();
            //Add the option of searching for entrypoint in a single file
            if(settings.getSpecification().getFileName() != null){
                fileName = settings.getSpecification().getFileName();
            }
        } else{
            isUsingFramework = false;
        }

        sw.start();
        List<File> files = getFilesFromDirectory(directoryPath, settings.getFileExtension());

        if(isUsingFramework || !settings.getSpecification().getFunctionsToAnalyze().isEmpty()){
            showEntrypoints();
            entrypointsAnalysis(settings, files);
        } else{
            startTaintVisitorAnalysis(settings, files);
            report.setFileName(settings.getSpecification().getFileName());
            if(settings.getSpecification().getFunction() != null){
                report.setAnalyzedFunctionName(settings.getSpecification().getFunction().getName());
            }
            //clearReport();
            if(!unknownMethodsLines.isEmpty() && !report.getVulnerabilities().isEmpty()){
                createUnknownMethodWarningMessage();
            }
        }

        sw.stop();
        report.setTimeToProcessMilliseconds(sw.getTime(TimeUnit.MILLISECONDS));
        writeReport();
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

    public static void addUnknownMethodsLines(int lineNum){
        if(!unknownMethodsLines.contains(lineNum)){
            unknownMethodsLines.add(lineNum);
        }
    } 

    /*public static void getFrameworkStrategy(String file, ParseTreeWalker walker, CompilationUnitContext tree){
        JavaFrameworkEntrypointFinder frameListener = new JavaFrameworkEntrypointFinder();
        switch(frameworkName){
            case "Spring":
                if(fileName != null){
                    if(fileName.equals(file)){
                        System.out.println("Checking entrypoints of file: " + fileName);
                        walker.walk(frameListener, tree);
                        saveEntrypoints(file, frameListener);
                        return;
                    } else{
                        return;
                    }
                } else {
                    System.out.println("Checking entrypoints of all directory files");
                    walker.walk(frameListener, tree);
                    saveEntrypoints(file, frameListener);
                    return;
                }
            

            default:
                System.out.println("Framework " + frameworkName + " is not supported. Current supported frameworks: Spring for Java, Flask for Python.");
                return;
        }
    }*/

    public static void saveEntrypoints(String file, HashMap<String, ArrayList<String>> entrypoints){
        if(!entrypoints.isEmpty()){
            filesEntrypoints.put(file, new HashMap<>(entrypoints));
        }
    }

    public static void saveGlobalTaintedVariables(String file, ArrayList<String> globalTaintedVariables){
        if(!globalTaintedVariables.isEmpty()){
            filesGlobalTaintedVariables.put(file, new ArrayList<>(globalTaintedVariables));
        }
    }

    public static void entrypointsAnalysis(Settings settings, List<File> files){
        if(isUsingFramework){
            for(String file : filesEntrypoints.keySet()){
                HashMap<String, ArrayList<String>> entrypoints = filesEntrypoints.get(file);
                for(String functionName : entrypoints.keySet()){
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.println("Going to inspect function " + functionName + " from file " + file);
                    System.out.println("---------------------------------------------------------------------------");
                    settings.getSpecification().setFunction(new FuncDefinition(functionName, 
                        getFunctionType(file, files, functionName, "." + settings.getFileExtension())));
                    settings.getSpecification().setTaintedVarsOrArgs(entrypoints.get(functionName));
                    settings.getSpecification().setFileName(file);
                    settings.getSpecification().setGlobalTaintVariableRegex(filesGlobalTaintedVariables.get(file));
                    startTaintVisitorAnalysis(settings, files);
                    addReportEntry(file, functionName);
                }
            }
        }
        else{
            for(FuncDefinition funcDef : settings.getSpecification().getFunctionsToAnalyze()){
                System.out.println("Checking function " + funcDef.getName());
                settings.getSpecification().setFunction(funcDef);
                settings.getSpecification().setTaintedVarsOrArgs(funcDef.getParameters());
                startTaintVisitorAnalysis(settings, files);
                addReportEntry(settings.getSpecification().getFileName(), funcDef.getName());
            }
        }
    }

    public static void startTaintVisitorAnalysis(Settings settings, List<File> files){
        TaintVisitor taintVisitor = new TaintVisitor(files, settings);
        taintVisitor.setAnalyzedClasses(analyzedClasses);
        taintVisitor.start();
    }

    public static void addReportEntry(String file, String functionName){
        //clearReport();
        if(isUsingFramework){
            report.setFrameworkMessage("This is a report on " + frameworkName + " framework analysis. Please note the processed time is on the last entry");
        }
        report.setAnalyzedFunctionName(functionName);
        report.setFileName(file);
        if(!unknownMethodsLines.isEmpty() && !report.getVulnerabilities().isEmpty()){
            createUnknownMethodWarningMessage();
            unknownMethodsLines.clear();
        }
        writeReport();
        vulnerabilitiesInReport += report.getVulnerabilities().size();
        report = new Report();
    }

    private static void createUnknownMethodWarningMessage(){
        String warning = "";
        if(unknownMethodsLines.size() == 1){
            warning += "An unknown method/function (i.e method/function with an unreachable code block) with tainted argument(s) has been found in line " + unknownMethodsLines.get(0) + ".";
        } else {
            Collections.sort(unknownMethodsLines);
            warning += "Unknown methods/functions (i.e method/function with an unreachable code block) with tainted argument(s) have been found in lines ";
            for(int i = 0; i < unknownMethodsLines.size(); i++){
                if(i == unknownMethodsLines.size() - 1){
                    warning += unknownMethodsLines.get(i) + ".";
                } else{
                    warning += unknownMethodsLines.get(i) + " - ";
                }
            }
        }

        warning += " As the tool's current unknown method detection is a bit simplified, please check if";
        warning += " the vulnerabilities that arised from that detection are true vulnerabilities.";

        report.setUnknownMethodWarning(warning);
    }

    public static String getFunctionType(String fileName, List<File> files, String functionName, String extension){
        for(File file : files){
            if(file.getName().matches(fileName)){
                if(!file.getClasses().isEmpty() && 
                file.getClasses().get(fileName.replace(extension, "")).getMethods().containsKey(functionName)){
                    return fileName.replace(extension, "");
                } else{
                    return null;
                }
            }
        }
        return null;
    }

    public static void showEntrypoints(){
        for(String file : filesEntrypoints.keySet()){
            HashMap<String, ArrayList<String>> entrypoints = filesEntrypoints.get(file);
            System.out.println("Entrypoints found in file " + file);
            for(String functionName : entrypoints.keySet()){
                System.out.println("Function: " + functionName);
            }
            System.out.println("================================================");
        }
    }

    public static void setUpAstConverter(){
        isUsingFramework = false;
        frameworkName = null;
        fileName = null;
        vulnerabilitiesInReport = 0;
        analyzedClasses = new HashMap<>();
        unknownMethodsLines = new ArrayList<>();
        filesEntrypoints = new HashMap<>();
        filesGlobalTaintedVariables = new HashMap<>();
        fef = new FrameworkEntrypointsFinder();
    }
}
