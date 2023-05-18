package model;

import utils.Helper;

/**
 *
 * @author kieth
 */
public class OrderModel extends DishModel {

    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getDishName() + " ; " + Helper.formatPriceToDisplay(price);
    }

}
