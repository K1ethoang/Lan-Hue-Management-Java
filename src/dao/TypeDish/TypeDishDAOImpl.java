
package dao.TypeDish;

import dao.DBConnection;
import java.util.List;
import model.TypeDishModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;



public class TypeDishDAOImpl implements TypeDishDAO{
    
    public static TypeDishDAOImpl getInstance() {
        return new TypeDishDAOImpl();
    }
    
    @Override
    public List<TypeDishModel> getList() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM typedish;";
            List<TypeDishModel> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                TypeDishModel typeDish = new TypeDishModel();
                typeDish.setTypeDishID(rs.getInt("TypeDishID"));
                typeDish.setUN_TypeName(rs.getString("UN_TypeName"));

                list.add(typeDish);
            }
            ps.close();
            rs.close();
            con.close();
            return list;
        } catch (Exception ex) {

        }
        return null;
    }

    @Override
    public TypeDishModel getByID(int ID) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM typedish WHERE TypeDishID = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ID + "");

            ResultSet rs = ps.executeQuery();

            TypeDishModel typeDishModel = null;
            if (rs.next()) {
                typeDishModel = new TypeDishModel();
                typeDishModel.setTypeDishID(rs.getInt("TypeDishID"));
                typeDishModel.setUN_TypeName(rs.getString("UN_TypeName"));
            }

            ps.close();
            rs.close();
            con.close();
            return typeDishModel;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }
    
}
