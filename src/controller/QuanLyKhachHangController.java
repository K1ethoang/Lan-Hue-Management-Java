///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package controller;
//
//import dao.KhachHangDAOImpl;
//import java.util.List;
//import javax.swing.JButton;
//import javax.swing.JPanel;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableModel;
//import model.KhachHang;
//import service.KhachHangService;
//import service.KhachHangServiceImpl;
//import uitility.ClassTableModel;
//import javafx.scene.control;
//
///**
// *
// * @author Admin
// */
//public class QuanLyKhachHangController {
//    private JPanel jpnView;
//    private JButton btnAdd;
//    private JTextField jtfSearch;
//    
//    private KhachHangService khachHangService = null;
//
//    private String[] listColumn = {"ID", "Họ và tên", "Số điện thoại", "CCCD", "Địa chỉ"};
//    
//    private Tablẻ<TableModel> rowSorter = null;
//    
//    public QuanLyKhachHangController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
//        this.jpnView = jpnView;
//        this.btnAdd = btnAdd;
//        this.jtfSearch = jtfSearch;
//        
//        this.khachHangService = new KhachHangServiceImpl();
//    }
//    public void setDateToTable(){
//        List<KhachHang> listItem = khachHangService.getList();
//        
//        DefaultTableModel model = new ClassTableModel().setTableKhachHang(listItem, listColumn);
//        JTable table = new JTable(model);
//    }
//    
//}
