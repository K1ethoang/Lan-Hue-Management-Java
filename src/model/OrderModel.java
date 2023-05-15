package model;

/**
 *
 * @author kieth
 */
public class OrderModel {

    private DishModel dish;
    private double price;

    public DishModel getDish() {
        return dish;
    }

    public void setDish(DishModel dish) {
        this.dish = dish;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderModel{" + "dish=" + dish + ", price=" + price + '}';
    }

}
