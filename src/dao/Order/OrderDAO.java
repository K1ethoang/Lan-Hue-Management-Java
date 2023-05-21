package dao.Order;

import java.util.List;
import model.DishModel;

/**
 *
 * @author kieth
 */
public interface OrderDAO {

    public List<DishModel> getListByID(int partyID);

    public boolean insertListByID(List<DishModel> listData, int partyID);

    public boolean deleteListByID(int partyID);

    public boolean isHasMenu(int partyID); //kiểm tra xem đã đặt món chưa
}
