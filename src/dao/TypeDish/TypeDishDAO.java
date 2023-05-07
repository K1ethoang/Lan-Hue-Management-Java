/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.TypeDish;

import java.util.List;
import model.TypeDishModel;

/**
 *
 * @author Admin
 */
public interface TypeDishDAO {
    public List<TypeDishModel> getList();
    public TypeDishModel getByID(int ID);
}
