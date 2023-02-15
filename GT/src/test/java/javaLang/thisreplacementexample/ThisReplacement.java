package javaLang.thisreplacementexample;

public class ThisReplacement {
    private int num;
    private String str;


    public void method(int id){
        this.num = id;
        ThisReplacement rp = new ThisReplacement();
        rp.doSomething(id, "Hello");
        this.doSomething(id, "Salut");
        doSomething(id + 1, "Nihao");
        this.num = this.num + 1;
        this.num++;
        id = --this.num;
    }
    
    public void doSomething(int id, String str){
        this.num = id + 1;
        this.str = str;
    }

    public void main(String[] args){
        ThisReplacement thsRp = new ThisReplacement();
        thsRp.method(5);
        //thsRp.num = 8 & thsRp.str = Nihao;
        String lmao = "LMAO";
    }
}
