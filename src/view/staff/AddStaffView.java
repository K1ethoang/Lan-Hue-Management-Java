package view.staff;

import dao.Role.RoleDAOImpl;
import dao.Staff.StaffDAOImpl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import model.RoleModel;
import model.StaffModel;
import utils.Helper;
import view.component.scroll.ScrollBarCus;

/**
 *
 * @author Admin
 */
public class AddStaffView extends javax.swing.JFrame {

    public static boolean isEditStaff = false;

//    StaffModel staffModel = null;
    List<RoleModel> gListRole = RoleDAOImpl.getInstance().getList();
    RoleModel gRoleModel = null;

    StaffDAOImpl staffDAOImpl = new StaffDAOImpl();

    public AddStaffView() {
        initComponents();
        Helper.setIconImage4JFrame(this);

        // set vertical and horizontal scroll bar
        ScrollBarCus sb = new ScrollBarCus();
        sb.setOrientation(JScrollBar.HORIZONTAL);
        this.setLocationRelativeTo(null);

        gListRole = RoleDAOImpl.getInstance().getList();
        TF_staffID.setEditable(false);
        setComboboxRole();

        Helper.setQuestionBeforeClose(this);
    }

    public AddStaffView(StaffModel _staffModel) {
        initComponents();
        Helper.setIconImage4JFrame(this);

        // set vertical and horizontal scroll bar
        ScrollBarCus sb = new ScrollBarCus();
        sb.setOrientation(JScrollBar.HORIZONTAL);
        this.setLocationRelativeTo(null);

        setComboboxRole();

        setData(_staffModel, isEditStaff);

        Helper.setQuestionBeforeClose(this);
    }

    public String getName() {
        String name = TF_NameStaff.getText().trim();
        if (name.isEmpty()) {
            return null;
        }
        return name;
    }

    private String getPhoneNumber() {
        return Helper.replaceInString(FTF_phoneNumber.getText(), " ", "");
    }

    private String getCitizenNumber() {
        return Helper.replaceInString(FTF_CCCD.getText(), " ", "");
    }

    boolean insertStaff() {
        StaffModel staff = new StaffModel();
        staff.setName(getName());
        if (rdoNam.isSelected()) {
            staff.setSex(1);
        } else if (rdoNu.isSelected()) {
            staff.setSex(0);
        }
        staff.setPhoneNumber(getPhoneNumber());
        staff.setCitizenNumber(getCitizenNumber());
        staff.setAddress(panelLocation2.getFullAddress());

        for (int i = 0; i < gListRole.size(); i++) {
            if (comboBoxRole.getSelectedIndex() == i) {
                staff.setRole(gListRole.get(i));
                break;
            }
        }
        return StaffDAOImpl.getInstance().insert(staff);
    }

    public boolean updateStaff() {
        StaffModel staff = new StaffModel();
        staff.setID(Integer.parseInt(TF_staffID.getText()));
        staff.setName(getName());
        if (rdoNam.isSelected()) {
            staff.setSex(1);
        } else if (rdoNu.isSelected()) {
            staff.setSex(0);
        }
        staff.setPhoneNumber(getPhoneNumber());
        staff.setCitizenNumber(getCitizenNumber());
        staff.setAddress(panelLocation2.getFullAddress());

        for (int i = 0; i < gListRole.size(); i++) {
            if (comboBoxRole.getSelectedIndex() == i) {
                staff.setRole(gListRole.get(i));
                break;
            }
        }
        return StaffDAOImpl.getInstance().update(staff);
    }

    public boolean deleteStaff() {
        int staffID = Integer.parseInt(TF_staffID.getText());
        return staffDAOImpl.delete(staffID);
    }

    private void setData(StaffModel _staffModel, boolean isEditStaff) {
        if (isEditStaff) {
            this.setTitle("Chỉnh sửa thông tin nhân viên");
        } else {
            this.setTitle("Xem thông tin nhân viên");
            saveBtn2.setVisible(false);
        }

        TF_staffID.setText(_staffModel.getID() + "");
        comboBoxRole.setSelectedItem(_staffModel.getRole().getRoleName());

        TF_NameStaff.setText(_staffModel.getName());
        FTF_phoneNumber.setText(_staffModel.getPhoneNumber());
        if (_staffModel.getSex() == 1) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        FTF_CCCD.setText(_staffModel.getCitizenNumber());
        panelLocation2.setAll(_staffModel.getAddress());

        setFieldEnable(isEditStaff);
    }

    private void setComboboxRole() {
        comboBoxRole.removeAllItems();
        for (int i = 0; i < gListRole.size(); i++) {
            comboBoxRole.addItem(gListRole.get(i).getRoleName());
        }
    }

    private void setFieldEnable(boolean bool) {
        rdoNam.setEnabled(bool);
        rdoNu.setEnabled(bool);
        TF_NameStaff.setEditable(bool);
        FTF_phoneNumber.setEditable(bool);
        FTF_CCCD.setEditable(bool);
//        TF_staffID.setEditable(false);
        panelLocation2.setEnable(bool);
        comboBoxRole.setEnabled(bool);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sexGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TF_staffID = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        panelStaff = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        TF_NameStaff = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        FTF_phoneNumber = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        FTF_CCCD = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        comboBoxRole = new javax.swing.JComboBox<>();
        panelLocation2 = new view.component.PanelLocation();
        bottom2 = new javax.swing.JPanel();
        saveBtn2 = new rojeru_san.complementos.RSButtonHover();
        cancelBtn2 = new rojeru_san.complementos.RSButtonHover();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm nhân viên");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jPanel5.setLayout(new java.awt.GridLayout(1, 2));

        jLabel1.setText("ID (*)");
        jPanel5.add(jLabel1);

        TF_staffID.setEditable(false);
        TF_staffID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_staffIDActionPerformed(evt);
            }
        });
        jPanel5.add(TF_staffID);

        jPanel2.add(jPanel5);

        jPanel6.setLayout(new java.awt.GridLayout(1, 3));

        jLabel4.setText("Giới tính:");
        jPanel6.add(jLabel4);

        sexGroup.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");
        jPanel6.add(rdoNam);

        sexGroup.add(rdoNu);
        rdoNu.setText("Nữ");
        jPanel6.add(rdoNu);

        jPanel2.add(jPanel6);

        jPanel1.add(jPanel2);

        panelStaff.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panelStaff.setLayout(new java.awt.GridLayout(4, 2, 0, 10));

        jLabel5.setText("Tên nhân viên (*)");
        panelStaff.add(jLabel5);
        panelStaff.add(TF_NameStaff);

        jLabel6.setText("SĐT liên hệ (*)");
        panelStaff.add(jLabel6);

        try {
            FTF_phoneNumber.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("0### ### ###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        panelStaff.add(FTF_phoneNumber);

        jLabel3.setText("Số  căn cước công dân:");
        panelStaff.add(jLabel3);

        try {
            FTF_CCCD.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("### # ## ######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        panelStaff.add(FTF_CCCD);

        jLabel2.setText("Chức vụ (*)");
        panelStaff.add(jLabel2);

        comboBoxRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxRoleActionPerformed(evt);
            }
        });
        panelStaff.add(comboBoxRole);

        jPanel1.add(panelStaff);
        jPanel1.add(panelLocation2);

        bottom2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        saveBtn2.setBackground(new java.awt.Color(10, 77, 104));
        saveBtn2.setText("Lưu");
        saveBtn2.setColorHover(new java.awt.Color(14, 112, 152));
        saveBtn2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saveBtn2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveBtn2.setPreferredSize(new java.awt.Dimension(110, 40));
        saveBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtn2ActionPerformed(evt);
            }
        });
        bottom2.add(saveBtn2);

        cancelBtn2.setBackground(new java.awt.Color(10, 77, 104));
        cancelBtn2.setText("Hủy");
        cancelBtn2.setColorHover(new java.awt.Color(14, 112, 152));
        cancelBtn2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelBtn2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelBtn2.setPreferredSize(new java.awt.Dimension(110, 40));
        cancelBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtn2ActionPerformed(evt);
            }
        });
        bottom2.add(cancelBtn2);

        jPanel1.add(bottom2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtn2ActionPerformed
        if (isEditStaff) {
            String ObjButtons[] = {"Thoát", "Hủy"};
            int PromptResult = JOptionPane.showOptionDialog(this, "Bạn thực sự muốn thoát?", "Quản lý tiệc Lan Huệ", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
            if (PromptResult == JOptionPane.YES_OPTION) {
                this.dispose();
            }
        } else
            this.dispose();
    }//GEN-LAST:event_cancelBtn2ActionPerformed

    private void saveBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtn2ActionPerformed
        boolean isEditOk = false, isInsertOk = false;

        if (isEditStaff) {
            isEditOk = updateStaff();
        } else {
            isInsertOk = insertStaff();
        }

        if (isInsertOk) {
            JOptionPane.showMessageDialog(this, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else if (isEditOk) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng kiểm tra lại thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_saveBtn2ActionPerformed

    private void comboBoxRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxRoleActionPerformed
        if (gListRole != null) {
            gRoleModel = gListRole.get(comboBoxRole.getSelectedIndex());
        }
    }//GEN-LAST:event_comboBoxRoleActionPerformed

    private void TF_staffIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_staffIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_staffIDActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddStaffView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField FTF_CCCD;
    private javax.swing.JFormattedTextField FTF_phoneNumber;
    private javax.swing.JTextField TF_NameStaff;
    private javax.swing.JTextField TF_staffID;
    private javax.swing.JPanel bottom2;
    private rojeru_san.complementos.RSButtonHover cancelBtn2;
    private javax.swing.JComboBox<String> comboBoxRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private view.component.PanelLocation panelLocation2;
    private javax.swing.JPanel panelStaff;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private rojeru_san.complementos.RSButtonHover saveBtn2;
    private javax.swing.ButtonGroup sexGroup;
    // End of variables declaration//GEN-END:variables
}
