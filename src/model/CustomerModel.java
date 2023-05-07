package model;

public class CustomerModel {

    private int ID;
    private String name;
    private String phoneNumber;
    private int sex;
    private String citizenNumber;
    private String address;

    public CustomerModel() {
    }

    public CustomerModel(int customerID, String name, String phoneNumber, int sex, String citizenNumber, String address) {
        this.ID = customerID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.citizenNumber = citizenNumber;
        this.address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int customerID) {
        this.ID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int isSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getCitizenNumber() {
        return citizenNumber;
    }

    public void setCitizenNumber(String citizenNumber) {
        this.citizenNumber = citizenNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomerModel{" + "customerID=" + ID + ", name=" + name + ", phoneNumber=" + phoneNumber + ", sex=" + sex + ", citizenNumber=" + citizenNumber + ", address=" + address + '}';
    }

}
