package table;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.DishModel;
import utils.Helper;

public class TableDish {

    public TableDish() {
    }

    public void setDishDetailsToTable(List<DishModel> listDish, view.component.table.Table tableDish) {
        System.out.println(listDish.get(0));
        DefaultTableModel model;
        try {
            int rows = listDish.size();
            if (rows > 0) {
                for (int i = 0; i < rows; i++) {
                    DishModel dish = listDish.get(i);
                    int dishID = dish.getDishID();
                    String dishName = dish.getDishName();
                    String dishPrice = Helper.formatPriceToDisplay(dish.getPrice());
                    String typeDish = dish.getTypeDish().getTypeName();

                    Object[] obj = {dishID, dishName, dishPrice, typeDish};
                    model = (DefaultTableModel) tableDish.getModel();
                    model.addRow(obj);

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
