package dao.Dish;

import dao.DBConnection;
import dao.TypeDish.TypeDishDAOImpl;
import java.util.List;
import model.DishModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.TypeDishModel;

public class DishDAOImpl implements DishDAO {

    public static DishDAOImpl getInstance() {
        return new DishDAOImpl();
    }

    @Override
    public List<DishModel> getList() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM dish\n"
                    + "ORDER BY DishID ASC;";

            List<DishModel> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                TypeDishModel typeDishModel;
                typeDishModel = TypeDishDAOImpl.getInstance().getByID(rs.getInt("TypeDishID"));

                DishModel dish = new DishModel();
                dish.setDishID(rs.getInt("DishID"));
                dish.setDishName(rs.getString("DishName"));
                dish.setPrice(rs.getDouble("CostPrice"));
                dish.setTypeDish(typeDishModel);

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
    public boolean insert(DishModel dish) {
        boolean isOk = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO dish(DishName, CostPrice, TypeDishID) "
                    + "VALUES (?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dish.getDishName());
            ps.setDouble(2, dish.getPrice());
            ps.setInt(3, dish.getTypeDish().getTypeDishID());

            int rs = ps.executeUpdate();
            if (rs > 0) {
                isOk = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isOk;
    }

    @Override
    public boolean delete(int id) {
        boolean isDelete = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM Dish WHERE DishID = ?";
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
    public boolean update(DishModel dish) {
        boolean isUpdated = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE DISH SET DishName = ?, CostPrice = ?, TypeDishID = ? WHERE DishID = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, dish.getDishName());
            ps.setDouble(2, dish.getPrice());
            ps.setInt(3, dish.getTypeDish().getTypeDishID());
            ps.setInt(4, dish.getDishID());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                isUpdated = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }
}
