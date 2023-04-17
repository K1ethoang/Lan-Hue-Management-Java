/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.KhachHangDAO;
import dao.KhachHangDAOImpl;
import java.util.List;
import model.KhachHang;

/**
 *
 * @author Admin
 */
public class KhachHangServiceImpl implements KhachHangService{
    private KhachHangDAO khachHangDAO = null;

    public KhachHangServiceImpl() {
        khachHangDAO = new KhachHangDAOImpl();
    }
    
    @Override
    public List<KhachHang> getList() {
        return khachHangDAO.getList();
    }
    
}
