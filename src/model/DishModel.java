
package model;

public class DishModel {
    private int dishID;
    private String dishName;
    private Double price;
    private TypeDishModel typeDish;

    public int getDishID() {
        return dishID;
    }

    public void setDishID(int dishID) {
        this.dishID = dishID;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TypeDishModel getTypeDish() {
        return typeDish;
    }

    public void setTypeDish(TypeDishModel typeDish) {
        this.typeDish = typeDish;
    }

    @Override
    public String toString() {
        return "DishModel{" + "dishID=" + dishID + ", dishName=" + dishName + ", price=" + price + ", typeDishID=" + typeDish + '}';
    }

}
