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

                customer.setCustomerID(rs.getInt("CustomerID"));
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

    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        System.out.println(customerDAO.getList());
    }
}
