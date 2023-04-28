package service.customer;

import dao.Customer.CustomerDAO;
import dao.Customer.CustomerDAOImpl;
import java.util.List;
import model.CustomerModel;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO = null;

    public CustomerServiceImpl() {
        customerDAO = new CustomerDAOImpl();
    }

    @Override
    public List<CustomerModel> getList() {
        return customerDAO.getList();
    }

}
