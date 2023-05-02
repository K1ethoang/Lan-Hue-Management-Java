
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

public class DishDAOImpl implements DishDAO{
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
                dish.setPrice(rs.getDouble("Price"));
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
    
    
}
