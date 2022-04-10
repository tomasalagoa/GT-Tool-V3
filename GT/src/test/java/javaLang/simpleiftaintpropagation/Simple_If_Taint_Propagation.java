package javaLang.simpleiftaintpropagation;

public class Simple_If_Taint_Propagation {

    public void method(String id){
        String taint1;
        String taint2;

        if(taint1.isEmpty()){
            taint1 = "" + id;
        } else {
            taint2 = "" + id;
        }

        executeQuery(taint1);
        executeQuery(taint2);
    }
    
}
