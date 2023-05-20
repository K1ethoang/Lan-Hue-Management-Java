package jaspertutorial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;

//import net.sf.jasperreports.engine.util.JRProperties;
public class Print {

    public Print(int chid, Connection con) {

        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("chid", chid);

//        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
//
//        // In ra danh sách các font chữ
//        for (String font : fonts) {
//            System.out.println(font);
//        }
        try {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResourceAsStream("/jaspertutorial/jasperReportBillLanHue.jasper"));
            JasperPrint jp = JasperFillManager.fillReport(jasperReport, parameters, con);

            JasperViewer.viewReport(jp, true);

            CustomJasperViewer jasperViewer = new CustomJasperViewer(jp, true);
            jasperViewer.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(Print.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
