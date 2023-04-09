package dao;
import java.sql.*;
public class Conection {

    private static final String url = "jdbc:mysql://localhost:3306/lanhuemanagement";
    private static final String username = "root";
    private static final String password = "23092003";

    public static void getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("");
        } catch (Exception e) {
        }
    }
}
