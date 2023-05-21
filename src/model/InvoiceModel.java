
package model;

import java.sql.Timestamp;

public class InvoiceModel {
    private int invoiceID;
    private Timestamp time;
    private Double total;
    private PartyModel party;

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public PartyModel getParty() {
        return party;
    }

    public void setParty(PartyModel party) {
        this.party = party;
    }

    @Override
    public String toString() {
        return "InvoiceModel{" + "invoiceID=" + invoiceID + ", time=" + time + ", total=" + total + ", party=" + party + '}';
    }
    
    
}
