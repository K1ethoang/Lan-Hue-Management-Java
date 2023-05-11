package dao.PaymentStatus;

import dao.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.PaymentStatusModel;

/**
 *
 * @author Admin
 */
public class PaymentStatusDAOImpl implements PaymentStatusDAO {

    public static PaymentStatusDAOImpl getInstance() {
        return new PaymentStatusDAOImpl();
    }

    @Override
    public PaymentStatusModel getByID(int ID) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM PaymentStatus WHERE PaymentStatusID = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ID + "");

            ResultSet rs = ps.executeQuery();

            PaymentStatusModel paymentStatus = null;
            if (rs.next()) {
                paymentStatus = new PaymentStatusModel();
                paymentStatus.setID(rs.getInt("PaymentStatusID"));
                paymentStatus.setStatusCode(rs.getInt("UN_StatusCode"));
                paymentStatus.setStatusName(rs.getString("StatusName"));
            }

            ps.close();
            rs.close();
            con.close();
            return paymentStatus;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public PaymentStatusModel getByStatusCode(int code) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM PaymentStatus WHERE UN_StatusCode = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, code + "");

            ResultSet rs = ps.executeQuery();

            PaymentStatusModel paymentStatus = null;
            if (rs.next()) {
                paymentStatus = new PaymentStatusModel();
                paymentStatus.setID(rs.getInt("PaymentStatusID"));
                paymentStatus.setStatusCode(rs.getInt("UN_StatusCode"));
                paymentStatus.setStatusName(rs.getString("StatusName"));
            }

            ps.close();
            rs.close();
            con.close();
            return paymentStatus;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
