package javaLang.constructorexample;
@SuppressWarnings("All")
public class ConstructorExample extends ConstructorA{
    private String str;
    private int age;

    public ConstructorExample(String str, int age, String something){
        super(something);
        this.str = str;
        this.age = age;
    }
    
    public void method(int id){
        ConstructorExample constr = new ConstructorExample("LMAO", id, "ROFL");
        executeQuery(constr);
    }

    public void executeQuery(ConstructorExample c){}
}
