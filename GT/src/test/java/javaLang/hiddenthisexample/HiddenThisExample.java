package javaLang.hiddenthisexample;

public class HiddenThisExample {
    private int number;
    private String string = "hello";

    public void method(int id){
        number = id;
        methodV2();
    }

    public void methodV2(){
        executeQuery(number);
    }

    public void executeQuery(int num){}
}
