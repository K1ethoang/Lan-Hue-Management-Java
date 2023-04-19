package dao.Account;

import java.sql.*;
import dao.DBConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AccountModel;

/**
 *
 * @author kieth
 */
public class AccountDAOImpl implements AccountDAO {

    public static AccountDAOImpl getInstance() {
        return new AccountDAOImpl();
    }

    @Override
    public AccountModel login(String user, String pass) {
        Connection con = (Connection) DBConnection.getConnection();
        String sql = "SELECT * FROM Account WHERE "
                + "UN_Username=? AND "
                + "Password=?";
        AccountModel accountModel = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                accountModel = new AccountModel();
                accountModel.setUsername(rs.getString("UN_Username"));
                accountModel.setPassword(rs.getString("Password"));
                accountModel.setEmail(rs.getString("Email"));

            }
            ps.close();
            con.close();
            return accountModel;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
