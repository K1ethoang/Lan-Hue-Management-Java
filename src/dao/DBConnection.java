package dao;

import java.sql.*;

public class DBConnection {

    private static final String url = "jdbc:mysql://localhost:3306/lanhuemanagement";
    private static final String username = "root";
    private static final String password = "23092003";

    public static Connection getConnection() {
        try {
            Connection con = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
