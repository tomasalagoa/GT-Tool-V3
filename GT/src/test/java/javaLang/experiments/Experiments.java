package javaLang.experiments;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

interface StringFunction{
    String run(String str, String rand);
}


public class Experiments {
    String str;
    int num;

    public void method(String id) throws SQLException {
        Experiments exp = new Experiments();
        StringFunction x = (str, rand) -> {
            executeQuery(str);
            return str;
        };
        Connection conn1 = null;
        exp.str = "Hello" + " World";
        exp.num = 1 + 1;
        exp.num = exp.num * 2;
        exp.num = 10 - exp.num;
        exp.num /= 2;
        exp.num %= 2;
        exp.num *= 10;
        
        double numb = exp.num++;
        numb = exp.num--;
        numb = ++exp.num;
        numb = --exp.num;

        // exp.num == numb == 10

        if(numb < 1){
            numb = 0;
        } else{
            x.run(exp.str + id, exp.str); // vuln
            conn1.createStatement().executeQuery(id); // vuln
        }

        if(exp.num >= 10){
            sensitiveSink(exp); // vuln
        }

        if(exp.num != 10){
            exp.str = "!=";
        } else if(exp.num == 5){
            exp.str = "==";
        } else if(exp.num <= 10){
            exp.str = id;
        } else{
            exp.num = 100;
        }

        if(exp.num < 100){
            sensitiveSink(exp); // vuln
            id = sanitize(id);
            x.run(id, "Hello");
        }

        x.run(exp.str, "World"); // vuln

        methodV2(exp.str, exp.num); // vuln
    }

    public void methodV2(String str, double num){
        if(num >= 10){
            executeQuery(str);
        }
    }

    public String sanitize(String id){
        return id;
    }
    public void executeQuery(String str){}
    public void sensitiveSink(Experiments exp){}
}
