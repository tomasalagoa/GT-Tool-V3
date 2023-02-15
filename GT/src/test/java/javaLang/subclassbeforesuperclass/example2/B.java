package javaLang.subclassbeforesuperclass.example2;

public class B extends A{
    protected boolean theWorld;
    protected String temperance;

    B(String name, int number, boolean truth, String sumn, int count){
        super(name, number, count);
        this.theWorld = truth;
        this.temperance = sumn;
    }

    public void method(int id){
        A a = new A("Lounge Act", 7, id);
        B b = new B("Sabotage", 89, false, "Those Days", 22);

        sensitiveSink(a.finalCountdown);
        sensitiveSink(b);
        sensitiveSink(a);
    }

    public void sensitiveSink(Object o){}
}