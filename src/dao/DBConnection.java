package dao;

import java.sql.*;

public class DBConnection {

    private static final String url = "jdbc:mysql://localhost:3306/lanhuemanagement";
    private static final String username = "root";
    private static final String password = "130320030348753499mysql";

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
    
    public static void main(String[] args) throws SQLException {
        Connection con = getConnection();
        System.err.println(con.toString());
        con.close();
    }
}
