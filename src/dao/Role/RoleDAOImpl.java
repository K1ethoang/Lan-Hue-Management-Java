
package dao.Role;

import dao.DBConnection;
import java.util.List;
import model.RoleModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class RoleDAOImpl implements RoleDAO{

    @Override
    public List<RoleModel> getList() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM role;";
            List<RoleModel> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                RoleModel role = new RoleModel();
                role.setRoleID(rs.getInt("RoleID"));
                role.setRoleName(rs.getString("RoleName"));

                list.add(role);
            }
            ps.close();
            rs.close();
            con.close();
            return list;
        } catch (Exception ex) {
            
        }
        return null;
    }
    
    
}
