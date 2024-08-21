package javaLang.subclassbeforesuperclass.example1;

public class A extends B{
    private String name;
    private int number;

    A(String name, int number, boolean truth, String sumn, int count){
        super(truth, sumn, count);
        this.name = name;
        this.number = number;
    }

    public void method(int id){
        A a = new A("Sabotage", 89, true, "Sinking", id);
        B b = new B(false, "Those Days", 22);

        sensitiveSink(a.finalCountdown);
        sensitiveSink(b);
        sensitiveSink(a);
    }

    public void sensitiveSink(Object o){}
}
