package dao.Order;

import dao.DBConnection;
import dao.Dish.DishDAOImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.DishModel;
import model.OrderModel;
import model.RoleModel;

/**
 *
 * @author kieth
 */
public class OrderDAOImpl implements OrderDAO {

    public static OrderModel getInstance() {
        return new OrderModel();
    }

    @Override
    public List<OrderModel> getList(int partyID) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT o.DishID, d.DishName, o.price FROM `order`o, dish d\n"
                    + "WHERE d.DishID = o.DishID AND o.partyID = ?";
            List<OrderModel> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, partyID);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                DishModel dish = new DishModel();
                dish.setDishID(rs.getInt("DishID"));
                dish.setDishName(rs.getString("DishName"));

                OrderModel order = new OrderModel();

                order.setDish(dish);
                order.setPrice(rs.getDouble("price"));

                list.add(order);
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
