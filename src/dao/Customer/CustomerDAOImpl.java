package dao.Customer;

import dao.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.CustomerModel;

/**
 *
 * @author Admin
 */
public class CustomerDAOImpl implements CustomerDAO {
    
    public static CustomerDAOImpl getInstance() {
        return new CustomerDAOImpl();
    }
    
    @Override
    public List<CustomerModel> getList() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM customer";
            
            List<CustomerModel> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                CustomerModel customer = new CustomerModel();
                
                customer.setID(rs.getInt("CustomerID"));
                customer.setName(rs.getString("Name"));
                customer.setPhoneNumber(rs.getString("PhoneNumber"));
                customer.setSex(rs.getBoolean("Sex"));
                customer.setCitizenNumber(rs.getString("UN_CitizenNumber"));
                customer.setAddress(rs.getString("Address"));
                
                list.add(customer);
            }
            ps.close();
            rs.close();
            con.close();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    @Override
    public CustomerModel getByID(int ID) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM customer WHERE CustomerID = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ID + "");
            
            ResultSet rs = ps.executeQuery();
            
            CustomerModel customer = null;
            if (rs.next()) {
                customer = new CustomerModel();
                customer.setID(rs.getInt("CustomerID"));
                customer.setName(rs.getString("Name"));
                customer.setPhoneNumber(rs.getString("PhoneNumber"));
                customer.setSex(rs.getBoolean("Sex"));
                customer.setCitizenNumber(rs.getString("UN_CitizenNumber"));
                customer.setAddress(rs.getString("Address"));
            }
            
            ps.close();
            rs.close();
            con.close();
            return customer;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println(CustomerDAOImpl.getInstance().getByID(1));
    }
}
