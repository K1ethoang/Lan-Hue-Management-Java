package dao.Customer;

import java.util.List;
import model.CustomerModel;

public interface CustomerDAO {
    public List<CustomerModel> getList();
    public CustomerModel getByID(int id);
    public boolean insert(CustomerModel customer);
    public boolean delete(int id);
}
