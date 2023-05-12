
package model;

public class PersonModel {
    private int ID;
    private String name;
    private String phoneNumber;
    private int sex;
    private String citizenNumber;
    private String address;

    public PersonModel() {
        
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public int getSex() {
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
        return "PersonModel{" + "ID=" + ID + ", name=" + name + ", phoneNumber=" + phoneNumber + ", sex=" + sex + ", citizenNumber=" + citizenNumber + ", address=" + address + '}';
    }
    
    
}
