package dao.Invoice;

import java.sql.*;
import dao.DBConnection;
import dao.Party.PartyDAOImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.InvoiceModel;
import model.PartyModel;

/**
 *
 * @author kieth
 */
public class InvoiceDAOImpl implements InvoiceDAO {

    public static InvoiceDAOImpl getInstance() {
        return new InvoiceDAOImpl();
    }

    @Override
    public Map<Integer, Double> getRevenueByMonthAtNowYear() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "CALL `SP_Get_Revenue_By_Month_At_Now_Year`";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Map<Integer, Double> map = new HashMap<>();
            while (rs.next()) {
                int month = rs.getInt("Month");
                double revenue = rs.getDouble("Revenue");

                map.put(month, revenue);
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insert(InvoiceModel invoice) {
        boolean isOk = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO Invoice(Time, Total, PartyID)\n"
                    + "VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTimestamp(1, invoice.getTime());
            ps.setDouble(2, invoice.getTotal());           
            ps.setInt(3, invoice.getParty().getID());

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

    @Override
    public boolean update(InvoiceModel invoice) {
        boolean isUpdated = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE INVOICE SET Time = ?, Total = ?, PartyID = ? WHERE Invoice = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTimestamp(1, invoice.getTime());
            ps.setDouble(2, invoice.getTotal());
            ps.setInt(3, invoice.getParty().getID()); 
            ps.setInt(4, invoice.getInvoiceID());
            int rs = ps.executeUpdate();
            if (rs >= 0) {
                isUpdated = true;
            }
            ps.close();
            con.close();
        } catch (Exception e) {
        }
        return isUpdated;
    }

    @Override
    public List<InvoiceModel> getList() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM Invoice\n"
                    + "ORDER BY InvoiceID DESC;";
            List<InvoiceModel> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                InvoiceModel invoice = InvoiceDAOImpl.getInstance().getByID(rs.getInt("InvoiceID"));
                list.add(invoice);
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
    public InvoiceModel getByID(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM Invoice\n"
                    + "WHERE InvoiceID = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                PartyModel party;
                party = PartyDAOImpl.getInstance().getByID(rs.getInt("PartyID"));

                InvoiceModel invoice = new InvoiceModel();
                invoice.setInvoiceID(rs.getInt("InvoiceID"));
                invoice.setTime(rs.getTimestamp("Time"));
                invoice.setTotal(rs.getDouble("Total"));
                invoice.setParty(party);
                return invoice;
            }
            ps.close();
            rs.close();
            con.close();
        } catch (Exception ex) {
        }
        return null;
    }

}
