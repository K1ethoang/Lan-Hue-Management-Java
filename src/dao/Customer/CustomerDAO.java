package dao.Customer;

import java.util.List;
import model.CustomerModel;

public interface CustomerDAO {

    public List<CustomerModel> getList();

    public CustomerModel getByID(int ID);
}
