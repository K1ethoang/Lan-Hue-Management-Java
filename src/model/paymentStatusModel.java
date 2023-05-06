package model;

public class PaymentStatusModel {

    // set constant
    public static final int UN_PAID = 0; // Chưa thanh toán
    public static final int PAID = 1; // Đã thanh toán

    private int ID;
    private int statusCode;
    private String statusName;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "PaymentStatusModel{" + "ID=" + ID + ", statusCode=" + statusCode + ", statusName=" + statusName + '}';
    }

}
