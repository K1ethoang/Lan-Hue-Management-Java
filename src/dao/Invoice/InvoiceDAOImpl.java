package dao.Invoice;

import java.sql.*;
import dao.DBConnection;
import dao.Party.PartyDAOImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.DetailInvoiceModel;
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

    public boolean insert(InvoiceModel invoice, List<DetailInvoiceModel> list) {
        boolean isOk = false;
        Connection con = DBConnection.getConnection();
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;

        Double total = 0.0;
        try {
            con.setAutoCommit(false); // Disable autocommit

            // Bước 1: Thêm dữ liệu vào bảng Invoice
            invoice.setTotal(total);
            String insertInvoice = "INSERT INTO Invoice(`Time`, Total, PartyID) VALUES (?, ?, ?)";
            ps1 = con.prepareStatement(insertInvoice, Statement.RETURN_GENERATED_KEYS);
            // Thiết lập các tham số cho câu lệnh SQL
            ps1.setTimestamp(1, invoice.getTime());
            ps1.setDouble(2, invoice.getTotal());
            ps1.setInt(3, invoice.getParty().getID());
            ps1.executeUpdate();

            // Lấy InvoiceID của bản ghi Invoice vừa chèn
            rs = ps1.getGeneratedKeys();
            int invoiceID = 0;
            if (rs.next()) {
                invoiceID = rs.getInt(1);
            }

            // Bước 2: Thêm dữ liệu vào bảng DetailInvoice
            String insertDetailInvoice = "INSERT INTO DetailInvoice(DishName, Unit_Price, Number, Amount, InvoiceID) VALUES (?, ?, ?, ?, ?)";
            ps2 = con.prepareStatement(insertDetailInvoice);
            // Thiết lập các tham số cho câu lệnh SQL
            for (int i = 0; i < list.size(); i++) {
                total += list.get(i).getAmount();

                ps2.setString(1, list.get(i).getDishName());
                ps2.setDouble(2, list.get(i).getUnit_Price());
                ps2.setInt(3, list.get(i).getNumber());
                ps2.setDouble(4, list.get(i).getAmount());
                ps2.setInt(5, invoiceID);

                ps2.executeUpdate();
            }

            // Bước 3: Cập nhật lại trường Total trong bảng Invoice
            String updateInvoice = "UPDATE Invoice SET Total = ? WHERE InvoiceID = ?";
            PreparedStatement ps3 = con.prepareStatement(updateInvoice);
// Thiết lập các tham số cho câu lệnh SQL
            ps3.setDouble(1, total);
            ps3.setInt(2, invoiceID);
            ps3.executeUpdate();

            con.commit(); // Commit thay đổi vào cơ sở dữ liệu
            isOk = true;

        } catch (Exception e) {
            // Xử lý exception (rollback, log, ...)
            try {
                if (con != null) {
                    con.rollback(); // Rollback thay đổi nếu có lỗi
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // Đóng kết nối và giải phóng tài nguyên
            try {
                if (ps1 != null) {
                    ps1.close();
                }
                if (ps2 != null) {
                    ps2.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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
