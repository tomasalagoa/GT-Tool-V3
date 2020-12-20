package javaLang.whiletainted;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class While_Cycle_Tainted {

    public void method(String id) throws SQLException {
        String sql = "SELECT username FROM users WHERE id=";
        while (true) {
            Connection conn1 = null;
            ResultSet res = conn1.createStatement().executeQuery(sql);
            sql = sql + id;
        }
    }
}