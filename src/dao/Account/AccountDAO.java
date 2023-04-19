package dao.Account;

import model.AccountModel;

/**
 *
 * @author kieth
 */
public interface AccountDAO {

    public AccountModel login(String user, String pass);
}
