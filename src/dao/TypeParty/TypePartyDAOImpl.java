package dao.TypeParty;

import dao.DBConnection;
import java.util.List;
import model.TypePartyModel;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author kieth
 */
public class TypePartyDAOImpl implements TypePartyDAO {

    public static TypePartyDAOImpl getInstance() {
        return new TypePartyDAOImpl();
    }

    @Override
    public List<TypePartyModel> getList() {
        try {
            Connection con = DBConnection.getConnection();
            List<TypePartyModel> list = new ArrayList<>();
            String sql = "SELECT * FROM TypeParty";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                TypePartyModel typePartyModel = new TypePartyModel();
                typePartyModel.setID(rs.getInt("TypePartyID"));
                typePartyModel.setName(rs.getString("UN_TypeName"));
                list.add(typePartyModel);
            }
            ps.close();
            rs.close();
            con.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public TypePartyModel getByID(int ID) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM TypeParty WHERE TypePartyID = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ID + "");

            ResultSet rs = ps.executeQuery();

            TypePartyModel typePartyModel = null;
            if (rs.next()) {
                typePartyModel = new TypePartyModel();
                typePartyModel.setID(rs.getInt("TypePartyID"));
                typePartyModel.setName(rs.getString("UN_TypeName"));
            }

            ps.close();
            rs.close();
            con.close();
            return typePartyModel;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
