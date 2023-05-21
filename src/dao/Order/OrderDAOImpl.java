package dao.Order;

import com.mysql.cj.xdevapi.Statement;
import dao.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DishModel;

/**
 *
 * @author kieth
 */
public class OrderDAOImpl implements OrderDAO {

    public static OrderDAOImpl getInstance() {
        return new OrderDAOImpl();
    }

    @Override
    public List<DishModel> getListByID(int partyID) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT o.DishID, d.DishName, o.price FROM `order`o, dish d\n"
                    + "WHERE d.DishID = o.DishID AND o.partyID = ?";
            List<DishModel> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, partyID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DishModel dish = new DishModel();

                dish.setDishID(rs.getInt("DishID"));
                dish.setDishName(rs.getString("DishName"));

                dish.setPrice(rs.getDouble("price"));

                list.add(dish);
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
    public boolean isHasMenu(int partyID) {
        boolean isExist = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM `Order` WHERE PartyID = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, partyID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                isExist = true;
            }
            ps.close();
            rs.close();
            con.close();
            return isExist;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isExist;
    }

    @Override
    public boolean insertListByID(List<DishModel> listData, int partyID) {
        boolean isOk = false;
        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO `Order`(PartyID, DishID, Price) \n"
                    + "VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            for (DishModel dish : listData) {
                ps.setInt(1, partyID);
                ps.setInt(2, dish.getDishID());
                ps.setDouble(3, dish.getPrice());
                int rs = ps.executeUpdate();
                if (rs > 0) {
                    isOk = true;
                }
            }

            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isOk;
    }

    @Override
    public boolean deleteListByID(int partyID) {
        boolean isOk = false;
        try {
            Connection con = DBConnection.getConnection();

            String sql = "CALL `SP_Clear_All_Order_By_ID` (?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, partyID);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                isOk = true;
            }

            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isOk;
    }

}
