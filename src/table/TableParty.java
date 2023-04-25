/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import dao.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.PartyModel;

/**
 *
 * @author Admin
 */
public class TableParty {

    public TableParty() {
    }
    
    public void setPartyDetailsToTable(List<PartyModel> listParty, view.component.table.Table tableParty){
        System.out.println(listParty.get(0));
        DefaultTableModel model;
        try{ 
            int rows = listParty.size();
            if (rows > 0) {
                for (int i = 0; i < rows; i++) {
                    PartyModel party = listParty.get(i);
                    int partyID = party.getPartyID();
                    String partyName = party.getPartyName();  
                    String customerName = party.getCustomer();
                    String partySDT = party.getSdt();
                    int tableNumber = party.getTableNumber();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    String formattedTime = dateFormat.format(party.getTime());
                    Timestamp time = (Timestamp) party.getTime();
                    String location = party.getLocation();
                    String happenStatus = party.getHappenStatus();
                    String paymentStatus = party.getPaymentStatus();
                    
                    Object[] obj = {partyID, partyName, customerName, partySDT, tableNumber, time, location, happenStatus, paymentStatus};
                    model = (DefaultTableModel) tableParty.getModel();
                    model.addRow(obj);
                    
                }
            }          
        } catch (Exception ex){
            ex.printStackTrace();
        }
        
    }
}
