/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KhachHang;

/**
 *
 * @author Admin
 */
public class KhachHangDAOImpl implements KhachHangDAO {

    @Override
    public List<KhachHang> getList() {
        try {
            Connection con = (Connection) DBConnection.getConnection();
            String sql = "SELECT * FROM lanhuemanagement.customer";
            List<KhachHang> list = new ArrayList<>();
//        Statement st = con.createStatement();
//        ResultSet rs =
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setCustomerID(rs.getInt("CustomerID"));
                khachHang.setName(rs.getString("Name"));
                khachHang.setPhoneNumber(rs.getString("PhoneNumber"));
                khachHang.setCitizenNumber(rs.getString("UN_CitizenNumber"));
                khachHang.setAddress(rs.getString("Address"));
        
                list.add(khachHang);
            }
            ps.close();
            rs.close();
            con.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }
    
    public static void main(String[] args) {
        KhachHangDAO khacHangDAO = new KhachHangDAOImpl();
        System.out.println(khacHangDAO.getList());
    }
}
