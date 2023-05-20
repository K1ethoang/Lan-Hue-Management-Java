
package table;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.DishModel;
import model.PartyModel;


public class TableOrder {

    public TableOrder() {
    }
    
    public void setOrderDetailsToTable(List<DishModel> listOrder, PartyModel party, view.component.table.Table tableOrder) {
        System.out.println(listOrder.get(0));
        DefaultTableModel model;
        try {
            int rows = listOrder.size();
            if (rows > 0) {
                for (int i = 0; i < rows; i++) {
                    DishModel dishOrder = listOrder.get(i);
                    
               
                    
                    String dishName = dishOrder.getDishName();
                    Double dishPrice = dishOrder.getPrice();
                    int tableNumber = party.getTableNumber();
                    Double sumMoney = dishPrice * tableNumber;

                    Object[] obj = {i+1, dishName, dishPrice, tableNumber, sumMoney};
                    model = (DefaultTableModel) tableOrder.getModel();
                    model.addRow(obj);

                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}
