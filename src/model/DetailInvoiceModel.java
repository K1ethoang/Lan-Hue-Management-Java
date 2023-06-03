
package model;

public class DetailInvoiceModel {
    private int DetailInvoiceID;
    private String DishName;
    private Double Unit_Price;
    private int Number;
    private Double Amount;
    private int InvoiceID;

    public int getDetailInvoiceID() {
        return DetailInvoiceID;
    }

    public void setDetailInvoiceID(int DetailInvoiceID) {
        this.DetailInvoiceID = DetailInvoiceID;
    }

    public String getDishName() {
        return DishName;
    }

    public void setDishName(String DishName) {
        this.DishName = DishName;
    }

    public Double getUnit_Price() {
        return Unit_Price;
    }

    public void setUnit_Price(Double Unit_Price) {
        this.Unit_Price = Unit_Price;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double Amount) {
        this.Amount = Amount;
    }

    public int getInvoiceID() {
        return InvoiceID;
    }

    public void setInvoiceID(int InvoiceID) {
        this.InvoiceID = InvoiceID;
    }

    @Override
    public String toString() {
        return "DetailInvoiceModel{" + "DetailInvoiceID=" + DetailInvoiceID + ", DishName=" + DishName + ", Unit_Price=" + Unit_Price + ", Number=" + Number + ", Amount=" + Amount + ", InvoiceID=" + InvoiceID + '}';
    }    
    
}
