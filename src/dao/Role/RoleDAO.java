
package dao.Role;

import java.util.List;
import model.RoleModel;


public interface RoleDAO {
    List<RoleModel> getList();
    public RoleModel getByID(int ID);
}
