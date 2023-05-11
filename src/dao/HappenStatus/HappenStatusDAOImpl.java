package dao.HappenStatus;

import dao.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.HappenStatusModel;

/**
 *
 * @author Admin
 */
public class HappenStatusDAOImpl implements HappenStatusDAO {

    public static HappenStatusDAOImpl getInstance() {
        return new HappenStatusDAOImpl();
    }

    @Override
    public HappenStatusModel getByID(int ID) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM HappenStatus WHERE HappenStatusID = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ID + "");

            ResultSet rs = ps.executeQuery();

            HappenStatusModel happenStatus = null;
            if (rs.next()) {
                happenStatus = new HappenStatusModel();
                happenStatus.setID(rs.getInt("HappenStatusID"));
                happenStatus.setStatusCode(rs.getInt("UN_StatusCode"));
                happenStatus.setStatusName(rs.getString("StatusName"));
            }

            ps.close();
            rs.close();
            con.close();
            return happenStatus;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public HappenStatusModel getByCodeStatus(int code) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM HappenStatus\n"
                    + "WHERE UN_StatusCode = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, code + "");

            ResultSet rs = ps.executeQuery();

            HappenStatusModel happenStatus = null;
            if (rs.next()) {
                happenStatus = new HappenStatusModel();
                happenStatus.setID(rs.getInt("HappenStatusID"));
                happenStatus.setStatusCode(rs.getInt("UN_StatusCode"));
                happenStatus.setStatusName(rs.getString("StatusName"));
            }

            ps.close();
            rs.close();
            con.close();
            return happenStatus;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
