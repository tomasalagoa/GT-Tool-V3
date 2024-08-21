package javaLang.mapexample;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    //Very simple test as maps can contain hundreds (if not thousands) of <key, value> pairs
    public void method(int id){
        Map<String, Integer> mapex = new HashMap<String, Integer>();

        mapex.put("Not Tainted", 15);
        String query;
        mapex.put("Tainted", id);
        mapex.put("Not TaintedV2", 99);

        query = "SELECT FROM ... WHERE value=" + mapex.get("Tainted");
        //Should be a vulnerability regardless of the value that is fetched from Map
        sensitiveSink(query);
    }

    public void sensitiveSink(String query){}
}
