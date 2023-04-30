package model;

import java.util.Date;
import java.sql.Time;

public class PartyModel {

    private int partyID;
    private String partyName;
    private int tableNumber;
    private Date date;
    private Time time;
    private String location;
    private String typeParty;
    private String happenStatus;
    private String paymentStatus;
    private String note;
    private CustomerModel customer;

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public String getTypeParty() {
        return typeParty;
    }

    public void setTypeParty(String typeParty) {
        this.typeParty = typeParty;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getPartyID() {
        return partyID;
    }

    public void setPartyID(int partyID) {
        this.partyID = partyID;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getHappenStatus() {
        return happenStatus;
    }

    public void setHappenStatus(String happenStatus) {
        this.happenStatus = happenStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "PartyModel{" + "partyID=" + partyID + ", partyName=" + partyName + ", tableNumber=" + tableNumber + ", time=" + time + ", location=" + location + ", typeParty=" + typeParty + ", happenStatus=" + happenStatus + ", paymentStatus=" + paymentStatus + ", note=" + note + ", customer=" + customer + '}';
    }

}
