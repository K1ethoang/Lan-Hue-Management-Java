package dao.Order;

import java.util.List;
import model.OrderModel;

/**
 *
 * @author kieth
 */
public interface OrderDAO {

    public List<OrderModel> getList(int partyID);
}
