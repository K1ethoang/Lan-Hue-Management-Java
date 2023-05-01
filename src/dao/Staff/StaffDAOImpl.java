package dao.Staff;

import dao.DBConnection;
import java.util.List;
import model.StaffModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StaffDAOImpl implements StaffDAO {

    public static StaffDAOImpl getInstance() {
        return new StaffDAOImpl();
    }

    @Override
    public List<StaffModel> getList() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT *\n"
                    + "FROM staff\n"
                    + "JOIN role ON staff.RoleID = role.RoleID;";

            List<StaffModel> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                StaffModel staff = new StaffModel();

                staff.setID(rs.getInt("StaffID"));
                staff.setName(rs.getString("Name"));
                staff.setSex(rs.getBoolean("Sex"));
                staff.setSdt(rs.getString("PhoneNumber"));
                staff.setCccd(rs.getString("UN_CitizenNumber"));
                staff.setAddress(rs.getString("Address"));
                staff.setRole(rs.getString("RoleName"));

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

}
