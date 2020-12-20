package javaLang.simplevariabletaint;

import java.sql.Connection;
import java.sql.SQLException;

public class Simple_Variable_Taint {

    public void method(String id) throws SQLException {
        String sql = "SELECT username FROM users WHERE id=" + id;

        Connection conn1 = null;
        conn1.createStatement();


        conn1.createStatement().executeQuery(sql).toString();
    }
}