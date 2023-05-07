package dao.Dish;

import java.util.List;
import model.DishModel;

public interface DishDAO {

    public List<DishModel> getList();
    public int getNextID();
}
