
package jaspertutorial;

//import com.lowagie.text.Font;
import dao.DBConnection;
//import java.awt.GraphicsEnvironment;
//import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

public class JASPERTUTORIAL {
    
//    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("path/to/SegoeUI.ttf")));

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/lanhuemanagement";
            Connection con = DBConnection.getConnection();
            
            String child = "2";
            new Print(child, con);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JASPERTUTORIAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
