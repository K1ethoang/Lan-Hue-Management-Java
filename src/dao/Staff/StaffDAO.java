
package dao.Staff;

import java.util.List;
import model.StaffModel;

public interface StaffDAO {
    public List<StaffModel> getList();

    public int getNextID();
    
    public boolean insert(StaffModel staff);
    
    public boolean delete(int id);
    
    public boolean update(StaffModel staff);
}
