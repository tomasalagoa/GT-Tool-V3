private final static Settings settings = new Settings();
private final static String DirectoryPath = "C:\\Users\\diogo\\Desktop\\MEIC-T\\2Ano\\Tese\\MasterDissertation\\GT-Tool-V2\\GT\\src\\test\\java\\python";


settings.setFileExtension("py");
TaintSpecification spec = new TaintSpecification();
spec.setFileName("Experiments.py");
spec.setFunction(new FuncDefinition("method"));
spec.setTaintedVarsOrArgs(List.of("id"));
spec.setSensitiveFunctions(List.of(new FuncDefinition("executeQuery")));
spec.setSanitizationFunctions(List.of(new FuncDefinition("sanitize")));
settings.setSpecification(spec);
AstConverter.analyse(DirectoryPath + "\\experiments", settings);
System.out.println("Success");

"Este teste possui 5 vulnerabilidades no total. 3 são reportadas porque o AstConverter não mete vulneralidades repetidas que é o que acontece com uma função lambda. É reportada essa vulnerabilidade 1 vez mas ela é encontrada sempre que possível."