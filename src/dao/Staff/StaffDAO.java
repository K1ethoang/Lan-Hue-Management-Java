
package dao.Staff;

import java.util.List;
import model.StaffModel;

public interface StaffDAO {
    public List<StaffModel> getList();
    
    public boolean insert(StaffModel staff);
    
    public boolean delete(int id);
}
