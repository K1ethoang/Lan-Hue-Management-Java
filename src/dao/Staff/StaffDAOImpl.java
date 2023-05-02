package dao.Staff;

import dao.DBConnection;
import dao.Role.RoleDAOImpl;
import java.util.List;
import model.StaffModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.RoleModel;

public class StaffDAOImpl implements StaffDAO {

    public static StaffDAOImpl getInstance() {
        return new StaffDAOImpl();
    }

    @Override
    public List<StaffModel> getList() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM staff\n"
                    + "ORDER BY StaffID DESC;";

            List<StaffModel> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                RoleModel roleModel;
                roleModel = RoleDAOImpl.getInstance().getByID(rs.getInt("RoleID"));
                
                StaffModel staff = new StaffModel();
                staff.setID(rs.getInt("StaffID"));
                staff.setName(rs.getString("Name"));
                staff.setSex(rs.getBoolean("Sex"));
                staff.setSdt(rs.getString("PhoneNumber"));
                staff.setCccd(rs.getString("UN_CitizenNumber"));
                staff.setAddress(rs.getString("Address"));
                staff.setRole(roleModel);

                list.add(staff);
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
    public boolean insert(StaffModel staff) {
        boolean isOk = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO staff(Name, Sex, PhoneNumber, UN_CittizenNumber, Address, RoleID)\n"
                    + "VALUES (?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, staff.getName());
            ps.setString(2, staff.isSex()+ "");
            ps.setString(3, staff.getSdt()+ "");
            ps.setString(4, staff.getCccd()+ "");
            ps.setString(5, staff.getAddress()+ "");
            ps.setString(6, staff.getRole()+ "");

            int rs = ps.executeUpdate();
            if (rs >= 0) {
                isOk = true;
            }
            ps.close();
            con.close();
        } catch (Exception e) {
        }
        return isOk;
    }
    
    public static void main(String[] args) {
        StaffModel staff = new StaffModel();
        StaffDAOImpl.getInstance().insert(staff);
    }
    
    @Override
    public boolean delete(int id) {
        System.out.println("11111");
        return true;
    }
}
