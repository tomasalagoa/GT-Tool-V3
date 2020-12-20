package javaLang.includefilesnottainted;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Funccall_Taint_Propagation_Ex {

    public void method(String id) throws SQLException {
        String sql = "SELECT username FROM users WHERE id=" + id;

        Secondary second = new Secondary();
        sql = second.second(null, id);
        Connection conn1 = null;

        ResultSet res = conn1.createStatement().executeQuery(sql);
    }
}