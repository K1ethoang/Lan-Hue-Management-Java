
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

public class Print {
    public Print(String customerID, Connection con){
        
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("cusID", customerID);
        
        try {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResourceAsStream("/jaspertutorial/jasperReportBill.jasper"));
            
            JasperPrint jp = JasperFillManager.fillReport(jasperReport, parameters, con);
            
//            JasperViewer.viewReport(jp, true);
//            JasperExportManager.exportReportToPdf(jp, new FileOutputStream(new File("C:/printJasperReport/reportBill.pdf")));

//            File file = new File("C:/printJasperReport/report.pdf");
//            FileOutputStream outputStream = new FileOutputStream(file);
//            JasperExportManager.exportReportToPdf(jp, outputStream);
            JasperExportManager.exportReportToPdfFile(jp, "C:/printJasperReport/reportBill.pdf");

        } catch (JRException ex) {
            Logger.getLogger(Print.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
