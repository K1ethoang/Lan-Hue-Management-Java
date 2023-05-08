package model;

public class StaffModel {

    private int ID;
    private String Name;
    private int sex;
    private String sdt;
    private String cccd;
    private String address;
    private RoleModel role;

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

    public int isSex() {
        return sex;
    }

    public void setSex(int sex) {
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

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "StaffModel{" + "staffID=" + ID + ", Name=" + Name + ", sex=" + sex + ", sdt=" + sdt + ", cccd=" + cccd + ", address=" + address + ", role=" + role + '}';
    }

}
