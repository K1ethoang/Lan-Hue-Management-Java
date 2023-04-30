package dao.Party;

import dao.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.CustomerModel;
import model.PartyModel;

public class PartyDAOImpl implements PartyDAO {

    @Override
    public List<PartyModel> getList() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT p.*, tp.UN_TypeName AS typeParty, c.name AS customerName, c.phoneNumber as customerPhoneNumber, hp.statusName AS happenName, ps.statusName AS paymentName\n"
                    + "FROM party p\n"
                    + "JOIN customer c ON p.customerID = c.customerID\n"
                    + "JOIN happenStatus hp ON p.HappenStatusID = hp.HappenStatusID\n"
                    + "JOIN paymentStatus ps ON p.PaymentStatusID = ps.PaymentStatusID\n"
                    + "JOIN typeParty tp ON p.typePartyID = tp.typePartyID";
            List<PartyModel> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                CustomerModel customer = new CustomerModel();
                PartyModel party = new PartyModel();

                customer.setName(rs.getString("customerName"));
                customer.setPhoneNumber(rs.getString("customerPhoneNumber"));

                party.setPartyID(rs.getInt("PartyID"));
                party.setPartyName(rs.getString("PartyName"));
                party.setTableNumber(rs.getInt("TableNumber"));
                party.setDate(rs.getDate("TimeDD/mm/yyyy"));
                party.setTime(rs.getTime("Time"));
                party.setLocation(rs.getString("Location"));
                party.setTypeParty(rs.getString("typeParty"));
                party.setHappenStatus(rs.getString("happenName"));
                party.setPaymentStatus(rs.getString("paymentName"));
                party.setNote(rs.getString("Note"));
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
}
