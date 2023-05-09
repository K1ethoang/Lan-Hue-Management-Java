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
                staff.setSex(rs.getInt("Sex"));
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
    public int getNextID() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT MAX(staffID) + 1 as `nextID` FROM staff";
            int nextID = -1;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nextID = rs.getInt("nextID");
            }
            System.out.println("nextID: " + nextID);
            return nextID;
        } catch (Exception e) {
        }
        return -1;
    }
    
    @Override
    public boolean insert(StaffModel staff) {
        boolean isOk = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO staff(Name, Sex, PhoneNumber, UN_CitizenNumber, Address, RoleID) "
                    + "VALUES (?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, staff.getName());
            ps.setInt(2, staff.isSex());
            ps.setString(3, staff.getSdt());
            ps.setString(4, staff.getCccd());
            ps.setString(5, staff.getAddress());
            ps.setInt(6, staff.getRole().getRoleID());

            int rs = ps.executeUpdate();
            if (rs > 0) {
                isOk = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isOk;
    }
    
    public static void main(String[] args) {
        StaffModel staff = new StaffModel();
        StaffDAOImpl.getInstance().insert(staff);
    }
    
    @Override
    public boolean delete(int id) {
        
        boolean isDelete = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM Staff WHERE StaffID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int rs = ps.executeUpdate();
            if (rs > 0) {
                isDelete = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDelete;
    }

    @Override
    public boolean update(StaffModel staff) {
        boolean isUpdated = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE STAFF SET Name = ?, Sex = ?, PhoneNumber = ?, UN_CitizenNumber = ?, Address = ?, RoleID = ? WHERE StaffID = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            if (!staff.getName().isEmpty() && !staff.getSdt().isEmpty() && (staff.isSex() == 0 || staff.isSex() == 1) && !staff.getCccd().isEmpty() && !staff.getAddress().isEmpty() && !staff.getRole().getRoleName().isEmpty()) {
                ps.setString(1, staff.getName());
                ps.setInt(2, staff.isSex());
                ps.setString(3, staff.getSdt());
                ps.setString(4, staff.getCccd());
                ps.setString(5, staff.getAddress());
                ps.setInt(6, staff.getRole().getRoleID());
                ps.setInt(7, staff.getID());
                int rs = ps.executeUpdate();
                if (rs > 0) {
                    isUpdated = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

}
