package javaLang.funccallpropagationsanitize;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Funccall_Taint_Propagation_Sanitize_Taint {

    public void method(String id) throws SQLException {
        String sql = "SELECT username FROM users WHERE id=" + id;

        sql = second(sql, null);
        Connection conn1 = null;

        ResultSet res = conn1.createStatement().executeQuery(sql);
    }

    public String second(String id, String second) {
        return sanitize(id);
    }

    public String sanitize(String input) {
        return input;
    }
}