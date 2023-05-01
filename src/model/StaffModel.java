package model;

public class StaffModel {

    private int ID;
    private String Name;
    private boolean sex;
    private String sdt;
    private String cccd;
    private String address;
    private String role;

    public StaffModel() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int staffID) {
        this.ID = staffID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "StaffModel{" + "staffID=" + ID + ", Name=" + Name + ", sex=" + sex + ", sdt=" + sdt + ", cccd=" + cccd + ", address=" + address + ", role=" + role + '}';
    }

}
