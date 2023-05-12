package view.customer;

import dao.Customer.CustomerDAOImpl;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import model.CustomerModel;
import view.component.scroll.ScrollBarCus;
import utils.Helper;

public class AddCustomerView extends javax.swing.JFrame {

    public static boolean isEditCustomer = false;

    public AddCustomerView() {
        initComponents();
        Helper.setIconImage4JFrame(this);

        // set vertical and horizontal scroll bar
        ScrollBarCus sb = new ScrollBarCus();
        sb.setOrientation(JScrollBar.HORIZONTAL);
    }

    // isEditCustomer == true thì các dữ liệu ở trạng chỉnh sửa
    // Chỉnh sửa: isEditCustomer == true; 
    // Xem chi tiết: isEditCustomer == false
    public AddCustomerView(CustomerModel _customerModel) {
        initComponents();
        Helper.setIconImage4JFrame(this);

        // set vertical and horizontal scroll bar
        ScrollBarCus sb = new ScrollBarCus();
        sb.setOrientation(JScrollBar.HORIZONTAL);

        setData(_customerModel, isEditCustomer);
    }

    private String getPhoneNumber() {
        return Helper.replaceInString(FTF_phoneNumber.getText(), " ", "");
    }

    private String getCitizenNumber() {
        return Helper.replaceInString(FTF_CCCD.getText(), " ", "");
    }

    // add customer
    boolean insertCustomer() {
        CustomerModel customer = new CustomerModel();
        customer.setName(TF_NameCustomer.getText().trim());
        if (rdoNam.isSelected()) {
            customer.setSex(1);
        } else if (rdoNu.isSelected()) {
            customer.setSex(0);
        }

        customer.setPhoneNumber(getPhoneNumber());
        customer.setCitizenNumber(getCitizenNumber());

        customer.setAddress(panelLocation1.getFullAddress());
        System.out.println(customer);
        return CustomerDAOImpl.getInstance().insert(customer);
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

        customer.setPhoneNumber(getPhoneNumber());
        customer.setCitizenNumber(getCitizenNumber());

        customer.setAddress(panelLocation1.getFullAddress());

        return CustomerDAOImpl.getInstance().update(customer);
    }

    private void setData(CustomerModel _customerModel, boolean isEditCustomer) {
        if (isEditCustomer) {
            this.setTitle("Chỉnh sửa thông tin khách hàng");

        } else {
            this.setTitle("Xem thông tin khách hàng");
            saveBtn2.setVisible(false);

        }

        TF_customerID.setText(_customerModel.getID() + "");
        TF_NameCustomer.setText(_customerModel.getName());

        if (_customerModel.getSex() == 1) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }

        FTF_phoneNumber.setText(_customerModel.getPhoneNumber());
        FTF_CCCD.setText(_customerModel.getCitizenNumber());
        panelLocation1.setAll(_customerModel.getAddress());

        setFieldEnable(isEditCustomer);
    }

    private void setFieldEnable(boolean bool) {
        rdoNam.setEnabled(bool);
        rdoNu.setEnabled(bool);
        TF_NameCustomer.setEditable(bool);
        FTF_phoneNumber.setEditable(bool);
        FTF_CCCD.setEditable(bool);
        panelLocation1.setEnable(bool);
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
        jPanel5.add(TF_customerID);

        jPanel3.add(jPanel5);

        jPanel6.setLayout(new java.awt.GridLayout(1, 3));

        jLabel7.setText("Giới tính:");
        jPanel6.add(jLabel7);

        btnGrGender.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");
        rdoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNamActionPerformed(evt);
            }
        });
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

        TF_NameCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_NameCustomerActionPerformed(evt);
            }
        });
        panelCustomer.add(TF_NameCustomer);

        jLabel9.setText("SĐT liên hệ (*)");
        panelCustomer.add(jLabel9);

        try {
            FTF_phoneNumber.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("0### ### ###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        FTF_phoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FTF_phoneNumberActionPerformed(evt);
            }
        });
        panelCustomer.add(FTF_phoneNumber);

        jLabel10.setText("Số  căn cước công dân (*):");
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void saveBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtn2ActionPerformed

        boolean isEditOk = false, isInsertOk = false;

        try {
            if (isEditCustomer) {
                isEditOk = updateCustomer();
            } else {
                isInsertOk = insertCustomer();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isInsertOk) {
            JOptionPane.showMessageDialog(this, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else if (isEditOk) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng kiểm tra lại thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_saveBtn2ActionPerformed

    private void cancelBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtn2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBtn2ActionPerformed

    private void FTF_phoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FTF_phoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FTF_phoneNumberActionPerformed

    private void TF_NameCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_NameCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_NameCustomerActionPerformed

    private void rdoNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNamActionPerformed

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
            java.util.logging.Logger.getLogger(AddCustomerView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCustomerView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCustomerView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCustomerView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
