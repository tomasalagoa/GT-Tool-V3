package ist.gt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ist.gt.gastBuilder.TaintVisitor;
import ist.gt.gastBuilder.frameworkEntrypointsFinder.FrameworkEntrypointsFinder;
import ist.gt.languages.java.listener.JavaFileListener;
import ist.gt.languages.java.parser.Java8Lexer;
import ist.gt.languages.java.parser.Java8Parser;
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
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.time.StopWatch;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Data
public class AstConverter {

    private static final String REPORT_FIELD_NAME = "reportFilePath";
    private static final Path ASTCONVERTER_SETTINGS_FILEPATH = Paths.get("src", "main", "resources", "astconverter-settings.json");
    private static Path reportFilePath;

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
    private static List<String> taintedAttributes;
    private static String fileNameForTaintedAttributes;

    /**
     * @function convertFile
     * Converts a given file's code into an AST which will then be converted into a GAST
     * in order for GT to analyse it and find vulnerabilities.
     **/
    private static File convertFile(String filePath) throws IOException {
        Path path = Path.of(filePath);
        var fileExtension = FilenameUtils.getExtension(filePath);

        CharStream input = CharStreams.fromFileName(path.toString());
        ParseTreeWalker walker = new ParseTreeWalker();
        System.out.println("Processing file: " + path.getFileName().toString());
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
                if (isUsingFramework) {
                    fef.useJavaFrameworkEntrypointsFinder(frameworkName, fileName,
                            path.getFileName().toString(), walker, tree);
                    saveEntrypoints(path.getFileName().toString(), fef.getEntrypoints());
                    fef.cleanUp();
                }
                var listener = new JavaFileListener(path.getFileName().toString());
                if (path.getFileName().toString().equals(fileNameForTaintedAttributes)) {
                    listener.getGastBuilder().setTaintedAttributes(taintedAttributes);
                }

                if (!analyzedClasses.isEmpty()) {
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
                if (!analyzedClasses.isEmpty()) {
                    listener.getGastBuilder().setAnalyzedClasses(analyzedClasses);
                }
                walker.walk(listener, tree);
                analyzedClasses = listener.getGastBuilder().getAnalyzedClasses();
                return listener.getGastBuilder().getFile();
            }
            case "py" -> {
                CommonTokenStream tokens = new CommonTokenStream(new PythonLexer(input));
                var tree = new PythonParser(tokens).root();
                if (isUsingFramework) {
                    fef.usePythonFrameworkEntrypointsFinder(frameworkName, fileName,
                            path.getFileName().toString(), walker, tree);
                    saveEntrypoints(path.getFileName().toString(), fef.getEntrypoints());
                    saveGlobalTaintedVariables(path.getFileName().toString(), fef.getGlobalTaintedVariables());
                    fef.cleanUp();
                }
                var listener = new PythonFileListener(path.getFileName().toString());
                if (path.getFileName().toString().equals(fileNameForTaintedAttributes)) {
                    listener.getGastBuilder().setTaintedAttributes(taintedAttributes);
                }

                if (!analyzedClasses.isEmpty()) {
                    listener.getGastBuilder().setAnalyzedClasses(analyzedClasses);
                }
                walker.walk(listener, tree);
                analyzedClasses = listener.getGastBuilder().getAnalyzedClasses();
                return listener.getGastBuilder().getFile();
            }
            default -> throw new RuntimeException("File extension not supported");
        }
    }

    /**
     * @function getFilesFromDirectory
     * Based on the path to the directory, as well as the extension of the files to analyse,
     * GT will pass each file to the converter so their code can be analysed.
     **/
    public static List<File> getFilesFromDirectory(Path directoryPath, String extension) throws IOException {
        var files = new ArrayList<File>();
        try (Stream<Path> paths = Files.walk(directoryPath)) {
            paths.filter(path -> Files.isRegularFile(path) && FilenameUtils.getExtension(path.toString()).equals(extension))
                    .forEach(path -> {
                        try {
                            File file = convertFile(path.toString());
                            file.setPath(path);
                            files.add(file);
                        } catch (IOException e) {
                            // e.printStackTrace();
                            System.err.println("There was an issue opening the provided file: " + path);
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

    /**
     * @function analyse
     * ASTConverter's main function. Connects a given language parser (and GastBuilder)
     * with the TaintVisitor.
     **/
    public static void analyse(Path directoryPath, Settings settings) throws IOException {
        report = new Report();
        StopWatch sw = new StopWatch();
        setUpAstConverter();
        if (settings.getFramework() != null) {
            isUsingFramework = true;
            frameworkName = settings.getFramework();
            //Add the option of searching for entrypoint in a single file
            if (settings.getSpecification().getFileName() != null) {
                fileName = settings.getSpecification().getFileName();
            }
        } else {
            isUsingFramework = false;
        }

        if (!settings.getSpecification().getTaintedAttributes().isEmpty()) {
            taintedAttributes = new ArrayList<>(settings.getSpecification().getTaintedAttributes());
            fileNameForTaintedAttributes = settings.getSpecification().getFileName();
        }

        sw.start();
        List<File> files = getFilesFromDirectory(directoryPath, settings.getFileExtension());

        if (isUsingFramework || !settings.getSpecification().getFunctionsToAnalyze().isEmpty()) {
            showEntrypoints();
            entrypointsAnalysis(settings, files);
        } else {
            startTaintVisitorAnalysis(settings, files);
            report.setFileName(settings.getSpecification().getFileName());
            if (settings.getSpecification().getFunction() != null) {
                report.setAnalyzedFunctionName(settings.getSpecification().getFunction().getName());
            }

            if (!unknownMethodsLines.isEmpty() && !report.getVulnerabilities().isEmpty()) {
                createUnknownMethodWarningMessage();
            }
        }

        sw.stop();
        report.setTimeToProcessMilliseconds(sw.getTime(TimeUnit.MILLISECONDS));
        writeReport();
    }

    private static void addMessage(String message) {
        try (FileWriter fw = new FileWriter(String.valueOf(reportFilePath), true);
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
        java.io.File f = new java.io.File(String.valueOf(reportFilePath));
        if (f.exists() && !f.isDirectory()) {
            try {
                new PrintWriter(String.valueOf(reportFilePath)).close();
            } catch (FileNotFoundException e) {
                // e.printStackTrace();
                System.err.println("Could not find file: " + reportFilePath);
            } catch (SecurityException se) {
                System.err.println("Cannot write to file: " + reportFilePath);
            }
        }
    }

    public static void addUnknownMethodsLines(int lineNum) {
        if (!unknownMethodsLines.contains(lineNum)) {
            unknownMethodsLines.add(lineNum);
        }
    }

    /**
     * @function saveEntrypoints
     * Saves all the entrypoints in a given file found by FrameworkEntrypointsFinder
     * for further analysis.
     **/
    public static void saveEntrypoints(String file, HashMap<String, ArrayList<String>> entrypoints) {
        if (!entrypoints.isEmpty()) {
            filesEntrypoints.put(file, new HashMap<>(entrypoints));
        }
    }

    /**
     * @function saveGlobalTaintedVariables
     * Same logic as saveEntrypoints but for global variables found in a given file.
     **/
    public static void saveGlobalTaintedVariables(String file, ArrayList<String> globalTaintedVariables) {
        if (!globalTaintedVariables.isEmpty()) {
            filesGlobalTaintedVariables.put(file, new ArrayList<>(globalTaintedVariables));
        }
    }

    /**
     * @function entrypointsAnalysis
     * Analyses every entrypoint found in every given file or every entrypoint provided by
     * the user. After each analysis, its results are written in a report.
     **/
    public static void entrypointsAnalysis(Settings settings, List<File> files) {
        if (isUsingFramework) {
            for (String file : filesEntrypoints.keySet()) {
                HashMap<String, ArrayList<String>> entrypoints = filesEntrypoints.get(file);
                for (String functionName : entrypoints.keySet()) {
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.println("Going to inspect function " + functionName + "  from file " + file);
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
        } else {
            for (FuncDefinition funcDef : settings.getSpecification().getFunctionsToAnalyze()) {
                System.out.println("Checking function " + funcDef.getName());
                settings.getSpecification().setFunction(funcDef);
                settings.getSpecification().setTaintedVarsOrArgs(funcDef.getParameters());
                startTaintVisitorAnalysis(settings, files);
                addReportEntry(settings.getSpecification().getFileName(), funcDef.getName());
            }
        }
    }

    /**
     * @function startTaintVisitorAnalysis
     * Auxiliary function of starting up TaintVisitor. Here to avoid code repetition.
     **/
    public static void startTaintVisitorAnalysis(Settings settings, List<File> files) {
        TaintVisitor taintVisitor = new TaintVisitor(files, settings);
        taintVisitor.setAnalyzedClasses(analyzedClasses);
        taintVisitor.start();
    }

    /**
     * @function addReportEntry
     * Gives a detailed entry regarding the function that was analysed: what framework
     * it is a part of, its name, if it encountered unknown methods (unreachable code),
     * vulnerabilities found (if any) and the name of the file it belongs to.
     **/
    public static void addReportEntry(String file, String functionName) {
        if (isUsingFramework) {
            report.setFrameworkMessage("This is a report on " + frameworkName + " framework analysis. Please note the processed time is on the last entry");
        }
        report.setAnalyzedFunctionName(functionName);
        report.setFileName(file);
        if (!unknownMethodsLines.isEmpty() && !report.getVulnerabilities().isEmpty()) {
            createUnknownMethodWarningMessage();
            unknownMethodsLines.clear();
        }
        writeReport();
        vulnerabilitiesInReport += report.getVulnerabilities().size();
        report = new Report();
    }

    /**
     * @function createUnknownMethodWarningMessage
     * Auxiliary function. Simply creates an unknown method warning message with the lines' number
     * where it found one.
     **/
    private static void createUnknownMethodWarningMessage() {
        StringBuilder warning = new StringBuilder();
        if (unknownMethodsLines.size() == 1) {
            warning.append("An unknown method/function (i.e method/function with an unreachable code block) with tainted argument(s) has been found in line ").append(unknownMethodsLines.getFirst()).append(".");
        } else {
            Collections.sort(unknownMethodsLines);
            warning.append("Unknown methods/functions (i.e method/function with an unreachable code block) with tainted argument(s) have been found in lines ");
            for (int i = 0; i < unknownMethodsLines.size(); i++) {
                if (i == unknownMethodsLines.size() - 1) {
                    warning.append(unknownMethodsLines.get(i)).append(".");
                } else {
                    warning.append(unknownMethodsLines.get(i)).append(" - ");
                }
            }
        }

        warning.append(" As the tool's current unknown method detection is a bit simplified, please check if");
        warning.append(" the vulnerabilities that arose from that detection are true vulnerabilities.");

        report.setUnknownMethodWarning(warning.toString());
    }

    /**
     * @function getFunctionType
     * Auxiliary function. Checks if a given file exists and if that file possesses the current
     * function to analyse. If it does and that file possesses a class, then the function type will
     * be the same as the name of the file (without the extension). If not, no type is given.
     **/
    public static String getFunctionType(String fileName, List<File> files, String functionName, String extension) {
        for (File file : files) {
            if (file.getName().matches(fileName)) {
                if (!file.getClasses().isEmpty() &&
                        file.getClasses().get(fileName.replace(extension, "")).getMethods().containsKey(functionName)) {
                    return fileName.replace(extension, "");
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    /**
     * @function showEntrypoints
     * Auxiliary function. Provides information in the terminal regarding the entrypoints
     * that were found + what file they belong to.
     **/
    public static void showEntrypoints() {
        System.out.println("================================================");
        for (String file : filesEntrypoints.keySet()) {
            Map<String, ArrayList<String>> entrypoints = filesEntrypoints.get(file);
            System.out.println("Entrypoints found in file " + file);
            for (String functionName : entrypoints.keySet()) {
                System.out.println("Function: " + functionName);
            }
            System.out.println("================================================");
        }
    }

    /**
     * @function setUpAstConverter
     * Auxiliary function. In multiple unit tests, AstConverter's information could be reused
     * which is not intended. This function cleans up the AstConverter every time it is used.
     **/
    public static void setUpAstConverter() {
        try {
            JsonNode reportFilePathNode =
                    jsonMapper.readTree(
                            new BufferedInputStream(
                                    new FileInputStream(ASTCONVERTER_SETTINGS_FILEPATH.toString()))
                    ).get(REPORT_FIELD_NAME);
            if (reportFilePathNode != null) {
                reportFilePath = Paths.get(reportFilePathNode.asText());
            } else { // User provided a valid JSON with no reportFilePath field
                try {
                    reportFilePath = Paths.get(Files.createTempDirectory("reports").toString(), "report.json");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            try {
                reportFilePath = Paths.get(Files.createTempDirectory("reports").toString(), "report.json");
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
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
