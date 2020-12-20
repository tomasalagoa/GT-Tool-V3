package javaLang.cleantaint;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Clean_Variable_Taint {

    public void method(String id) throws SQLException {
        String sql = "SELECT username FROM users WHERE id=" + id;
        sql = "asda";
        Connection conn1 = null;
        ResultSet res = conn1.createStatement().executeQuery(sql);
    }
}