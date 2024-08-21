private static final TaintSpecification spec = new TaintSpecification(new FuncDefinition("main"), 
    List.of("id"), List.of(new FuncDefinition("sensitiveSink")), List.of(new FuncDefinition("sanitize")));
private final static Settings settings = new Settings();
private final static String DirectoryPath = "C:\\Users\\diogo\\Desktop\\MEIC-T\\2Ano\\Tese\\MasterDissertation\\GT-Tool-V2\\GT\\src\\test\\java\\javaLang";

settings.setFileExtension("java");
spec.setFileName("ThisReplacement.java");
spec.getFunction().setType(spec.getFileName().replace(".java", ""));
settings.setSpecification(spec);
AstConverter.analyse(DirectoryPath + "\\thisreplacementexample", settings);