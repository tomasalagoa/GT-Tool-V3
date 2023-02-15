package javaLang.stackexample;

import java.util.Stack;
//The problem with a Stack is that a tainted object can be placed and removed later, leading to false positive...
public class StackExample {

    public void method(int id){
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(id);

        sensitiveSink("Select..." + stack.pop());

    }

    public void sensitiveSink(String query){}
    
}
