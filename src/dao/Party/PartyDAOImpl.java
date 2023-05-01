package dao.Party;

import dao.Customer.CustomerDAOImpl;
import dao.PaymentStatus.PaymentStatusDAOImpl;
import dao.DBConnection;
import dao.HappenStatus.HappenStatusDAOImpl;
import dao.TypeParty.TypePartyDAOImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.CustomerModel;
import model.HappenStatusModel;
import model.PartyModel;
import model.PaymentStatusModel;
import model.TypePartyModel;

public class PartyDAOImpl implements PartyDAO {

    public static PartyDAOImpl getInstance() {
        return new PartyDAOImpl();
    }

    @Override
    public List<PartyModel> getList() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM Party\n"
                    + "ORDER BY PartyID DESC;";
            List<PartyModel> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TypePartyModel typeParty;
                typeParty = TypePartyDAOImpl.getInstance().getByID(rs.getInt("TypePartyID"));

                HappenStatusModel happenStatus;
                happenStatus = HappenStatusDAOImpl.getInstance().getByID(rs.getInt("HappenStatusID"));

                PaymentStatusModel paymentStatus;
                paymentStatus = PaymentStatusDAOImpl.getInstance().getByID(rs.getInt("PaymentStatusID"));

                CustomerModel customer;
                customer = CustomerDAOImpl.getInstance().getByID(rs.getInt("CustomerID"));

                PartyModel party = new PartyModel();
                party.setID(rs.getInt("PartyID"));
                party.setPartyName(rs.getString("PartyName"));
                party.setTableNumber(rs.getInt("TableNumber"));
                party.setDate(rs.getDate("Date"));
                party.setTime(rs.getTime("Time"));
                party.setLocation(rs.getString("Location"));
                party.setNote(rs.getString("Note"));
                party.setTypeParty(typeParty);
                party.setHappenStatus(happenStatus);
                party.setPaymentStatus(paymentStatus);
                party.setCustomer(customer);

                list.add(party);
            }
            ps.close();
            rs.close();
            con.close();
            return list;
        } catch (Exception ex) {
        }
        return null;
    }

    @Override
    public boolean insert(PartyModel party) {
        boolean isOk = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO Party(PartyName, TableNumber, Date, Time, Location, Note, "
                    + "CustomerID, HappenStatusID, PaymentStatusID, TypePartyID)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, party.getPartyName());
            ps.setString(2, party.getTableNumber() + "");
            ps.setString(3, party.getDate() + "");
            ps.setString(4, party.getTime() + "");
            ps.setString(5, party.getLocation() + "");
            ps.setString(6, party.getNote() + "");
            ps.setString(7, party.getCustomer() + "");
            ps.setString(8, party.getHappenStatus() + "");
            ps.setString(9, party.getPartyName() + "");
            ps.setString(10, party.getTypeParty() + "");

            int rs = ps.executeUpdate();
            if (rs >= 0) {
                isOk = true;
            }
            ps.close();
            con.close();
        } catch (Exception e) {
        }
        return isOk;
    }

    public static void main(String[] args) {
        PartyModel party = new PartyModel();
        PartyDAOImpl.getInstance().insert(party);
    }

    @Override
    public boolean delete(int id) {
        boolean isOk = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM Party WHERE PartyID = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id + "");

            int rs = ps.executeUpdate();
            if (rs >= 0) {
                isOk = true;
            }

            ps.close();
            con.close();
        } catch (Exception e) {
        }
        return isOk;
    }

}
