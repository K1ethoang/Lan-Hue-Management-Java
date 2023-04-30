
package service.role;

import dao.Role.RoleDAO;
import dao.Role.RoleDAOImpl;
import java.util.List;
import model.RoleModel;

public class RoleServiceImpl implements RoleService{
    
    private RoleDAO roleDAO = null;

    public RoleServiceImpl() {
        roleDAO = new RoleDAOImpl();
    }
    @Override
    public List<RoleModel> getList() {
        return roleDAO.getList();
    }
    
}
