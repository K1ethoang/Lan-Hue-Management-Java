
package jaspertutorial;

import dao.DBConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

public class JASPERTUTORIAL {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/lanhuemanagement";
            Connection con = DBConnection.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JASPERTUTORIAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
