package javaLang.subclassbeforesuperclass.example1;

public class B extends C{
    protected boolean theWorld;
    protected String temperance;

    B(boolean truth, String something, int countdown){
        super(countdown);
        this.theWorld = truth;
        this.temperance = something;
    }
}
