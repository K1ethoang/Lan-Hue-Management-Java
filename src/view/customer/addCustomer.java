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

public class addCustomer extends javax.swing.JFrame {

    CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
    CustomerJPanel cusJpn = new CustomerJPanel();
    boolean isSex = true;

    public addCustomer() {
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
    public addCustomer(CustomerModel _customerModel, boolean isSee) {
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
    private boolean insertCustomer() {
        CustomerModel customer = new CustomerModel();
        customer.setID(Integer.parseInt(TF_customerID.getText()));
        customer.setName(TF_NameCustomer.getText());
        if (rdoNam.isSelected()) {
            customer.setSex(1);
        } else if (rdoNu.isSelected()) {
            customer.setSex(0);
        }
        customer.setPhoneNumber(TF_phoneNumber.getText());
        customer.setCitizenNumber(TF_CCCD.getText());
        customer.setAddress(panelLocation2.getAddress());

//        System.out.println(customer);
        return customerDAOImpl.insert(customer);
    }

    // UPDATE CUSTOMER
    private boolean updateCustomer() {
        CustomerModel customer = new CustomerModel();
        customer.setID(Integer.parseInt(TF_customerID.getText()));
        customer.setName(TF_NameCustomer.getText());
        if (rdoNam.isSelected()) {
            customer.setSex(1);
        } else if (rdoNu.isSelected()) {
            customer.setSex(0);
        }
        customer.setPhoneNumber(TF_phoneNumber.getText());
        customer.setCitizenNumber(TF_CCCD.getText());
        customer.setAddress(panelLocation2.getAddress());

        return customerDAOImpl.update(customer);
    }

    // delete CUSTOMER
    public boolean deleteCustomer() {
        int customerID = Integer.parseInt(TF_customerID.getText());
        return customerDAOImpl.delete(customerID);
    }

    private void setData(CustomerModel _customerModel, boolean isSee) {
        this.setTitle("Xem Khách Hàng");
        System.out.println(_customerModel.isSex());
        TF_customerID.setText(_customerModel.getID() + "");
        TF_NameCustomer.setText(_customerModel.getName());
        if (_customerModel.isSex() == 1) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        TF_phoneNumber.setText(_customerModel.getPhoneNumber());
        TF_CCCD.setText(_customerModel.getCitizenNumber());
        panelLocation2.setAddress(_customerModel.getAddress());

        setFieldEnable(isSee);
    }

    private void setFieldEnable(boolean bool) {
        TF_NameCustomer.setEditable(bool);
        TF_phoneNumber.setEditable(bool);
        TF_CCCD.setEditable(bool);
        TF_customerID.setEditable(false);
        panelLocation2.setEnable(bool);
    }

    private void setTextFieldID() {
        TF_customerID.setText(gCurrentID + "");
    }

    private void setCheckBoxSex() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrGender = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        panelLocation2 = new view.component.PanelLocation();
        panelStaff = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TF_phoneNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TF_NameCustomer = new javax.swing.JTextField();
        TF_CCCD = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TF_customerID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        bottom2 = new javax.swing.JPanel();
        saveBtn2 = new rojeru_san.complementos.RSButtonHover();
        cancelBtn2 = new rojeru_san.complementos.RSButtonHover();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelLocation2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 0, 0));

        panelStaff.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panelStaff.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Tên khách hàng (*)");
        panelStaff.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 298, 22));

        jLabel6.setText("SĐT liên hệ (*)");
        panelStaff.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 42, 298, 22));

        TF_phoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_phoneNumberActionPerformed(evt);
            }
        });
        panelStaff.add(TF_phoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 42, 300, -1));

        jLabel3.setText("Căn cước công dân (CMND) (*):");
        panelStaff.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 210, -1));

        TF_NameCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_NameCustomerActionPerformed(evt);
            }
        });
        panelStaff.add(TF_NameCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 10, 300, -1));
        panelStaff.add(TF_CCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 74, 300, -1));

        jLabel1.setText("ID (*)");

        TF_customerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_customerIDActionPerformed(evt);
            }
        });

        jLabel2.setText("Giới tính:");

        btnGrGender.add(rdoNam);
        rdoNam.setText("Nam");

        btnGrGender.add(rdoNu);
        rdoNu.setText("Nữ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TF_customerID, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(rdoNam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdoNu)
                .addContainerGap(151, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_customerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bottom2, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelLocation2, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(panelStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(panelLocation2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(bottom2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TF_phoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_phoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_phoneNumberActionPerformed

    private void saveBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtn2ActionPerformed

        // STATUS: ADD
//        int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu hay không ?", "Select", JOptionPane.YES_NO_OPTION);
//        if((insertCustomer() == true && a == 0) || (updateCustomer() == true && a == 0)){
//            cusJpn.setCustomerTable(); // xét lại table
//            setVisible(false); // tắt mà hình add
//            cusJpn.setVisible(true); // 
//        }
//        else{
//            JOptionPane.showMessageDialog(this, "Bạn vui lòng nhập đầy đủ dữ liệu");
//        }
        int a = JOptionPane.showConfirmDialog(null, "Bạn có lưu hay không ?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            System.out.println("add: " + insertCustomer());
            System.out.println("update: " + updateCustomer());
            if (insertCustomer() == true || updateCustomer() == true) {
                JOptionPane.showMessageDialog(this, "Lưu thành công !");
                cusJpn.setCustomerTable(); // xét lại table
                setVisible(false); // tắt mà hình add
                cusJpn.setVisible(true); // 
//                clearTable();
//                setCustomerTable();
            } //            else if(updateCustomer() == true){
            //                JOptionPane.showMessageDialog(this, "Chỉnh sửa thành công !");
            //                cusJpn.setCustomerTable(); // xét lại table
            //                setVisible(false); // tắt mà hình add
            //                cusJpn.setVisible(true); // 
            //            }
            else {
                JOptionPane.showMessageDialog(this, "Bạn vui lòng nhập đầy đủ dữ liệu !");
            }

        }

        //STATUS: DELETE
    }//GEN-LAST:event_saveBtn2ActionPerformed

    private void cancelBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBtn2MouseClicked
        this.dispose();
    }//GEN-LAST:event_cancelBtn2MouseClicked

    private void cancelBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelBtn2ActionPerformed

    private void TF_NameCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_NameCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_NameCustomerActionPerformed

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
            java.util.logging.Logger.getLogger(addCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TF_CCCD;
    private javax.swing.JTextField TF_NameCustomer;
    private javax.swing.JTextField TF_customerID;
    private javax.swing.JTextField TF_phoneNumber;
    private javax.swing.JPanel bottom2;
    private javax.swing.ButtonGroup btnGrGender;
    private rojeru_san.complementos.RSButtonHover cancelBtn2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private view.component.PanelLocation panelLocation2;
    private javax.swing.JPanel panelStaff;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private rojeru_san.complementos.RSButtonHover saveBtn2;
    // End of variables declaration//GEN-END:variables
}
