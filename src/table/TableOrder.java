
package table;

import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.DishModel;
import model.PartyModel;


public class TableOrder {

    public TableOrder() {
    }
    
    public void setOrderDetailsToTable(List<DishModel> listOrder, PartyModel party, view.component.table.Table tableOrder) {
//        DefaultTableModel model;
//        try {
//            int rows = listOrder.size();
//            if (rows > 0) {
//                for (int i = 0; i < rows; i++) {
//                    DishModel dishOrder = listOrder.get(i);
//                    
//               
//                    
//                    String dishName = dishOrder.getDishName();
//                    Double dishPrice = dishOrder.getPrice();
//                    int tableNumber = party.getTableNumber();
//                    Double sumMoney = dishPrice * tableNumber;
//
//                    Object[] obj = {i+1, dishName, dishPrice, tableNumber, sumMoney};
//                    model = (DefaultTableModel) tableOrder.getModel();
//                    model.addRow(obj);
//
//                }
//            }
//            else if(rows == 0){
//                model = (DefaultTableModel) tableOrder.getModel();
//            }
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
        DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
        model.setRowCount(0); // Xóa bỏ các dòng cũ trên bảng

        int rows = listOrder.size();
        for (int i = 0; i < rows; i++) {
            DishModel dishOrder = listOrder.get(i);

            String dishName = dishOrder.getDishName();
            Double dishPrice = dishOrder.getPrice();
            int tableNumber = party.getTableNumber();
            
            Double sumMoney = dishPrice * tableNumber;
            
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
            String formattedSumMoney = decimalFormat.format(sumMoney);

            Object[] obj = {i + 1, dishName, dishPrice, tableNumber, formattedSumMoney};
            model.addRow(obj);
        }
    }
}
