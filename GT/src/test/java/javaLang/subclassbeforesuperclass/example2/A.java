package javaLang.subclassbeforesuperclass.example2;

public class A extends C{
    private String name;
    private int number;

    A(String name, int number, int count){
        super(count);
        this.name = name;
        this.number = number;
    }
}
