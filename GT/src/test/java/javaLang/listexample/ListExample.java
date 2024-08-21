package javaLang.listexample;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    
    public void method(int id){
        List<Integer> list = new ArrayList<Integer>();
        
        list.add(id);
        list.add(10);
        String query = "SELECT FROM ... WHERE id=" + list.get(0) + " and num= " + list.get(1);
        sensitiveSink(query); 
    }

    public void sensitiveSink(String query){}
}
