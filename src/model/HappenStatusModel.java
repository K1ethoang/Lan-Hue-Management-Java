package model;

public class HappenStatusModel {

    // set constant
    public static final int COMING_SOON = 0; // Sắp tới
    public static final int GOING_ON = 1; // Đang tổ chức
    public static final int DONE = 2; // Đã xong

    private int ID;
    private int statusCode;
    private String statusName;

    public HappenStatusModel(int ID, int statusCode, String statusName) {
        this.ID = ID;
        this.statusCode = statusCode;
        this.statusName = statusName;
    }

    public HappenStatusModel() {

    }

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
        return "HappenStatusModel{" + "ID=" + ID + ", statusCode=" + statusCode + ", statusName=" + statusName + '}';
    }
}
