private static final TaintSpecification spec = new TaintSpecification(new FuncDefinition("method"), List.of("id"), List.of(new FuncDefinition("executeQuery")), List.of(new FuncDefinition("sanitize")));
private final static Settings settings = new Settings();
private final static String DirectoryPath = "C:\\Users\\diogo\\Desktop\\MEIC-T\\2Ano\\Tese\\MasterDissertation\\GT-Tool-V2\\GT\\src\\test\\java\\javaLang";

settings.setFileExtension("java");
spec.setFileName("Experiments.java");
spec.getFunction().setType(spec.getFileName().replace(".java", ""));
settings.setSpecification(spec);
AstConverter.analyse(DirectoryPath + "\\experiments", settings);
System.out.println("Success");

"Este teste possui 5 vulnerabilidades no total. 4 são reportadas porque o AstConverter não mete vulneralidades repetidas que é o que acontece com uma função lambda. É reportada essa vulnerabilidade 1 vez mas ela é encontrada sempre que possível."
