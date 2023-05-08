package view.customer;

import dao.Customer.CustomerDAOImpl;
import dao.DBConnection;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import model.CustomerModel;
import view.component.scroll.ScrollBarCus;
import static view.customer.CustomerJPanel.gCurrentID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class AddCustomerView extends javax.swing.JFrame {

    CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();

    public AddCustomerView() {
        initComponents();
        // set vertical and horizontal scroll bar
        ScrollBarCus sb = new ScrollBarCus();
        sb.setOrientation(JScrollBar.HORIZONTAL);
        this.setLocationRelativeTo(null);
        this.setTitle("Thêm Khách Hàng");
        TF_customerID.setEditable(false);
        setTextFieldID();
//        gListRole = RoleDAOImpl.getInstance().getList();
    }

    // isSee == false thì các dữ liệu ở trạng thái chỉ đc xem, k đc chỉnh sửa
    // Xem chi tiết: iSee == false
    // Chỉnh sửa: isSee == true; 
    // hơi nguocje ngược xíu nha
    public AddCustomerView(CustomerModel _customerModel, boolean isSee) {
        initComponents();
        // set vertical and horizontal scroll bar
        ScrollBarCus sb = new ScrollBarCus();
        sb.setOrientation(JScrollBar.HORIZONTAL);
        this.setLocationRelativeTo(null);

        setData(_customerModel, isSee);
        // set button

        if (isSee == false) {
            saveBtn2.setVisible(false);
        }
    }

    // add customer
    boolean insertCustomer() {
        CustomerModel customer = new CustomerModel();
        customer.setID(Integer.parseInt(TF_customerID.getText()));
        customer.setName(TF_NameCustomer.getText());
        if (rdoNam.isSelected()) {
            customer.setSex(1);
        } else if (rdoNu.isSelected()) {
            customer.setSex(0);
        }
        customer.setPhoneNumber(FTF_phoneNumber.getText());
        customer.setCitizenNumber(FTF_CCCD.getText());
        customer.setAddress(panelLocation1.getAddress());

        return customerDAOImpl.insert(customer);
    }

    // UPDATE CUSTOMER
    public boolean updateCustomer() {
        CustomerModel customer = new CustomerModel();
        customer.setID(Integer.parseInt(TF_customerID.getText()));
        customer.setName(TF_NameCustomer.getText());
        if (rdoNam.isSelected()) {
            customer.setSex(1);
        } else if (rdoNu.isSelected()) {
            customer.setSex(0);
        }
        customer.setPhoneNumber(FTF_phoneNumber.getText());
        customer.setCitizenNumber(FTF_CCCD.getText());
        customer.setAddress(panelLocation1.getAddress());

        return customerDAOImpl.update(customer);
    }

    // delete CUSTOMER
    public boolean deleteCustomer() {
        int customerID = Integer.parseInt(TF_customerID.getText());
        return customerDAOImpl.delete(customerID);
    }

    private void setData(CustomerModel _customerModel, boolean isSee) {
        this.setTitle("Xem Khách Hàng");
        TF_customerID.setText(_customerModel.getID() + "");
        TF_NameCustomer.setText(_customerModel.getName());
        if (_customerModel.isSex() == 1) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        FTF_phoneNumber.setText(_customerModel.getPhoneNumber());
        FTF_CCCD.setText(_customerModel.getCitizenNumber());
        panelLocation1.setAddress(_customerModel.getAddress());

        setFieldEnable(isSee);
    }

    private void setFieldEnable(boolean bool) {
        TF_NameCustomer.setEditable(bool);
        FTF_phoneNumber.setEditable(bool);
        FTF_CCCD.setEditable(bool);
        TF_customerID.setEditable(false);
        panelLocation1.setEnable(bool);
    }

    private void setTextFieldID() {
        TF_customerID.setText(gCurrentID + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrGender = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TF_customerID = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        panelCustomer = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        TF_NameCustomer = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        FTF_phoneNumber = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        FTF_CCCD = new javax.swing.JFormattedTextField();
        panelLocation1 = new view.component.PanelLocation();
        bottom2 = new javax.swing.JPanel();
        saveBtn2 = new rojeru_san.complementos.RSButtonHover();
        cancelBtn2 = new rojeru_san.complementos.RSButtonHover();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm khách hàng");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jPanel5.setLayout(new java.awt.GridLayout(1, 2));

        jLabel4.setText("ID (*)");
        jPanel5.add(jLabel4);

        TF_customerID.setEditable(false);
        TF_customerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_customerIDActionPerformed(evt);
            }
        });
        jPanel5.add(TF_customerID);

        jPanel3.add(jPanel5);

        jPanel6.setLayout(new java.awt.GridLayout(1, 3));

        jLabel7.setText("Giới tính:");
        jPanel6.add(jLabel7);

        btnGrGender.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");
        jPanel6.add(rdoNam);

        btnGrGender.add(rdoNu);
        rdoNu.setText("Nữ");
        jPanel6.add(rdoNu);

        jPanel3.add(jPanel6);

        jPanel1.add(jPanel3);

        panelCustomer.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panelCustomer.setLayout(new java.awt.GridLayout(3, 2, 0, 10));

        jLabel8.setText("Tên khách hàng (*)");
        panelCustomer.add(jLabel8);
        panelCustomer.add(TF_NameCustomer);

        jLabel9.setText("SĐT liên hệ (*)");
        panelCustomer.add(jLabel9);

        try {
            FTF_phoneNumber.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("0## ### ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        panelCustomer.add(FTF_phoneNumber);

        jLabel10.setText("Căn cước công dân (CMND) (*):");
        panelCustomer.add(jLabel10);

        try {
            FTF_CCCD.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("### # ## ######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        panelCustomer.add(FTF_CCCD);

        jPanel1.add(panelCustomer);
        jPanel1.add(panelLocation1);

        bottom2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        saveBtn2.setText("Lưu");
        saveBtn2.setBackground(new java.awt.Color(10, 77, 104));
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

        cancelBtn2.setText("Hủy");
        cancelBtn2.setBackground(new java.awt.Color(10, 77, 104));
        cancelBtn2.setColorHover(new java.awt.Color(14, 112, 152));
        cancelBtn2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelBtn2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelBtn2.setPreferredSize(new java.awt.Dimension(110, 40));
        cancelBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelBtn2MouseClicked(evt);
            }
        });
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public rojeru_san.complementos.RSButtonHover getBtnSave() {
        return saveBtn2;
    }

    private void saveBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtn2ActionPerformed

//        int a = JOptionPane.showConfirmDialog(null, "Bạn có lưu hay không ?", "Select", JOptionPane.YES_NO_OPTION);
//        if (a == 0) {
        if (insertCustomer() == true || updateCustomer() == true) {
            JOptionPane.showMessageDialog(this, "Lưu thành công !");
            dispose();
            CustomerJPanel customerJpn = new CustomerJPanel();
            System.out.println("1");
            customerJpn.clearTable();
            System.out.println("2");

            customerJpn.setCustomerTable();
            System.out.println("");
        } else {
            JOptionPane.showMessageDialog(this, "Bạn vui lòng nhập đầy đủ dữ liệu !");
        }

//        }
    }//GEN-LAST:event_saveBtn2ActionPerformed

    private void cancelBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBtn2MouseClicked
        this.dispose();
    }//GEN-LAST:event_cancelBtn2MouseClicked

    private void cancelBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelBtn2ActionPerformed

    private void TF_customerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_customerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_customerIDActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddCustomerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCustomerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCustomerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCustomerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCustomerView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField FTF_CCCD;
    private javax.swing.JFormattedTextField FTF_phoneNumber;
    private javax.swing.JTextField TF_NameCustomer;
    private javax.swing.JTextField TF_customerID;
    private javax.swing.JPanel bottom2;
    private javax.swing.ButtonGroup btnGrGender;
    private rojeru_san.complementos.RSButtonHover cancelBtn2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel panelCustomer;
    private view.component.PanelLocation panelLocation1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private rojeru_san.complementos.RSButtonHover saveBtn2;
    // End of variables declaration//GEN-END:variables
}
