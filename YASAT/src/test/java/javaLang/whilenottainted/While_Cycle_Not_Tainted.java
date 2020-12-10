package javaLang.whilenottainted;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class While_Cycle_Not_Tainted {

    public void method(String id) throws SQLException {
        String sql = "SELECT username FROM users WHERE id=";
        Connection conn1 = null;
        while (true) {
            ResultSet res = conn1.createStatement().executeQuery(sql);
        }

    }
}