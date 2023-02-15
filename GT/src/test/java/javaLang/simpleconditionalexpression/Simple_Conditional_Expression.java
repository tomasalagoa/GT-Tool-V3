package javaLang.simpleconditionalexpression;

public class Simple_Conditional_Expression {
    public void method(int id){
        int num = 1;

        num = (num > id) ? id : 1;

        executeQuery(num);
    }

    public void executeQuery(int query){}
}