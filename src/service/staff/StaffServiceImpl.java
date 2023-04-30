/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.staff;

import dao.Staff.StaffDAO;
import dao.Staff.StaffDAOImpl;
import java.util.List;
import model.StaffModel;

/**
 *
 * @author Admin
 */
public class StaffServiceImpl implements StaffService{
    private StaffDAO staffDAO = null;

    public StaffServiceImpl() {
        staffDAO = new StaffDAOImpl();
    }
    
    @Override
    public List<StaffModel> getList() {
        return staffDAO.getList();
    }
    
}
