package model;

import java.util.Date;
import java.sql.Time;

public class PartyModel {

    private int ID;
    private String partyName;
    private int tableNumber;
    private Date date;
    private Time time;
    private String location;
    private String note;

    private TypePartyModel typeParty;
    private HappenStatusModel happenStatus;
    private PaymentStatusModel paymentStatus;
    private CustomerModel customer;

    public TypePartyModel getTypeParty() {
        return typeParty;
    }

    public void setTypeParty(TypePartyModel typeParty) {
        this.typeParty = typeParty;
    }

    public HappenStatusModel getHappenStatus() {
        return happenStatus;
    }

    public void setHappenStatus(HappenStatusModel happenStatus) {
        this.happenStatus = happenStatus;
    }

    public PaymentStatusModel getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatusModel paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getID() {
        return ID;
    }

    public void setID(int partyID) {
        this.ID = partyID;
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

}
