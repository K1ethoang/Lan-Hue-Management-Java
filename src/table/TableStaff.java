
package table;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.RoleModel;
import model.StaffModel;

public class TableStaff {

    public TableStaff() {
    }
    
    public void setStaffDetailsToTable(List<StaffModel> listStaff, view.component.table.Table tableStaff){
        DefaultTableModel model = null;
        try{ 
            int rows = listStaff.size();
            if (rows > 0) {
                for (int i = 0; i < rows; i++) {
                    StaffModel staff = listStaff.get(i);
                    int staffID = staff.getID();
                    String staffName = staff.getName();  
                    String staffSDT = staff.getSdt();
                    String sex = staff.isSex()== 0 ? "Nữ" : "Nam";
                    String staffCCCD = staff.getCccd();
                    String staffAddress = staff.getAddress();
                    String staffRole = staff.getRole().getRoleName();
                    
                    Object[] obj = {staffID, staffName, staffSDT, sex, staffCCCD, staffAddress, staffRole};
                    model = (DefaultTableModel) tableStaff.getModel();
                    model.addRow(obj);
                    
                }
            }          
        } catch (Exception ex){
            ex.printStackTrace();
        }
        
    }
}
