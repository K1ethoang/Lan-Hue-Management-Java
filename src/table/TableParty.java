package table;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.PartyModel;

public class TableParty {

    public TableParty() {
    }

    public void setPartyDetailsToTable(List<PartyModel> listParty, view.component.table.Table tableParty) {
        System.out.println(listParty.get(0));
        DefaultTableModel model;
        try {
            int rows = listParty.size();
            if (rows > 0) {
                for (int i = 0; i < rows; i++) {
                    PartyModel party = listParty.get(i);
                    int partyID = party.getPartyID();
                    String partyName = party.getPartyName();
                    int tableNumber = party.getTableNumber();
                    Date date = party.getDate();
                    Time time = (Time) party.getTime();
                    String location = party.getLocation();
                    String partyType = party.getTypeParty();
                    String happenStatus = party.getHappenStatus();
                    String paymentStatus = party.getPaymentStatus();

                    String customerName = party.getCustomer().getName();
                    String customerPhoneNumber = party.getCustomer().getPhoneNumber();

                    Object[] obj = {partyID, partyName, partyType, customerName, customerPhoneNumber, tableNumber, date ,time, location, happenStatus, paymentStatus};
                    model = (DefaultTableModel) tableParty.getModel();
                    model.addRow(obj);

                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}
