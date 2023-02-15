package javaLang.setexample;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExample {
    public void method(String id){
        Set<String> set = new HashSet<>();

        set.add(id);
        set.add("hello");

        Iterator itr = set.iterator();
        String query = "SELECT ...";

        while(itr.hasNext()){
            query += itr.next();
        }

        sensitiveSink(query);
    }

    public void sensitiveSink(String query){}
}
