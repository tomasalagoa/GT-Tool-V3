package javaLang.funccallpropagation1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Funccall_Taint_Propagation1 {

    public void method(String id) throws SQLException {
        String sql = "SELECT username FROM users WHERE id=" + id;

        sql = second(null, sql);
        Connection conn1 = null;

        ResultSet res = conn1.createStatement().executeQuery(sql);
    }

    public String second(String id, String second) {
        return id;
    }
}