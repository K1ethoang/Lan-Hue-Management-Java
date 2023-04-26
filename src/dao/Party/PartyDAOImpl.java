/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Party;

import dao.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.PartyModel;

/**
 *
 * @author Admin
 */
public class PartyDAOImpl implements PartyDAO{

    @Override
    public List<PartyModel> getList() {
        try{
            Connection con = DBConnection.getConnection();
            String sql ="SELECT *, customer.name AS CustomerName, paymentstatus.StatusName AS PaymentStatusName " +
                        "FROM party " +
                        "JOIN customer ON party.CustomerID = Customer.CustomerID " +
                        "JOIN happenstatus ON party.HappenStatusID = happenstatus.HappenStatusID " +
                        "JOIN paymentstatus ON party.PaymentStatusID = paymentstatus.PaymentStatusID;";
            List<PartyModel> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql); 
            while(rs.next()){
                PartyModel party = new PartyModel();
                
                party.setPartyID(rs.getInt("PartyID"));        
                party.setPartyName(rs.getString("PartyName"));        
                party.setCustomer(rs.getString("CustomerName"));
                party.setSdt(rs.getString("PhoneNumber"));
                party.setTableNumber(rs.getInt("TableNumber"));
                party.setTime(rs.getTimestamp("Time"));
//                Timestamp time = (Timestamp) party.getTime();  
                party.setLocation(rs.getString("Location"));
                party.setHappenStatus(rs.getString("StatusName"));
                party.setPaymentStatus(rs.getString("PaymentStatusName"));       
                list.add(party);
            }
            ps.close();
            rs.close();
            con.close();
            return list;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        PartyDAO partyDAO = new PartyDAOImpl();
        System.out.println(partyDAO.getList());
    }
}
