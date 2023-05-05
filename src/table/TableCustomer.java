package table;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.CustomerModel;

public class TableCustomer {

    public TableCustomer() {
    }

    public void setCustomerDetailsToTable(List<CustomerModel> listCustomer, view.component.table.Table tableCustomer) {
        DefaultTableModel model = null;
        try {
            int rows = listCustomer.size();
            if (rows > 0) {
                for (int i = 0; i < rows; i++) {
                    CustomerModel customer = listCustomer.get(i);
                    int customerID = customer.getID();
                    String customerName = customer.getName();
                    String customerSDT = customer.getPhoneNumber();
                    String sex = customer.isSex() == 0 ? "Nữ" : "Nam";
                    String customerCCCD = customer.getCitizenNumber();
                    String customerAddress = customer.getAddress();

                    System.out.println(customer);
                    Object[] obj = {customerID, customerName, customerSDT, sex, customerCCCD, customerAddress};
                    model = (DefaultTableModel) tableCustomer.getModel();
                    model.addRow(obj);

                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
