package dao.Invoice;

import java.sql.*;
import dao.DBConnection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kieth
 */
public class InvoiceDAOImpl implements InvoiceDAO {

    public static InvoiceDAOImpl getInstance() {
        return new InvoiceDAOImpl();
    }

    @Override
    public Map<Integer, Double> getRevenueByMonthAtNowYear() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "CALL `SP_Get_Revenue_By_Month_At_Now_Year`";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Map<Integer, Double> map = new HashMap<>();
            while (rs.next()) {
                int month = rs.getInt("Month");
                double revenue = rs.getDouble("Revenue");

                map.put(month, revenue);
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
