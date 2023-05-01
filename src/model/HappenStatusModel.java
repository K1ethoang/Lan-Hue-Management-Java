package model;

/**
 *
 * @author Admin
 */
public class HappenStatusModel {

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
        return "HappenStatusModel{" + "ID=" + ID + ", statusCode=" + statusCode + ", statusName=" + statusName + '}';
    }
}
