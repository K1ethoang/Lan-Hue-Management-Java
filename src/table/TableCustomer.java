/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.CustomerModel;
import model.PartyModel;

/**
 *
 * @author Admin
 */
public class TableCustomer {

    public TableCustomer() {
    }
    
    public void setCustomerDetailsToTable(List<CustomerModel> listCustomer, view.component.table.Table tableCustomer){
        System.out.println(listCustomer.get(0));
        DefaultTableModel model;
        try{ 
            int rows = listCustomer.size();
            if (rows > 0) {
                for (int i = 0; i < rows; i++) {
                    CustomerModel customer = listCustomer.get(i);
                    int customerID = customer.getCustomerID();
                    String customerName = customer.getName();  
                    String customerSDT = customer.getPhoneNumber();
                    String sex = customer.isSex() == true ? "Nam" : "Nữ";
                    String customerCCCD = customer.getCitizenNumber();
                    String customerAddress = customer.getAddress();
                    
                    System.out.println(customer);
                    Object[] obj = {customerID, customerName, customerSDT, sex, customerCCCD, customerAddress};
                    model = (DefaultTableModel) tableCustomer.getModel();
                    model.addRow(obj);
                    
                }
            }          
        } catch (Exception ex){
            ex.printStackTrace();
        }
        
    }
}
