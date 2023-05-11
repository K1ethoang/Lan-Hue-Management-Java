package dao.Dish;

import java.util.List;
import model.DishModel;

public interface DishDAO {

    public List<DishModel> getList();

    public boolean insert(DishModel dish);

    public boolean delete(int id);

    public boolean update(DishModel dish);
}
