package jaspertutorial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.WindowConstants;
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

        try {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResourceAsStream("/jaspertutorial/jasperReportBillLanHue.jasper"));
            JasperPrint jp = JasperFillManager.fillReport(jasperReport, parameters, con);

            JasperViewer.viewReport(jp, false);
//            JasperExportManager.exportReportToPdfFile(jp, "C:/printJasperReport/reportBill.pdf");

        } catch (JRException ex) {
            Logger.getLogger(Print.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
