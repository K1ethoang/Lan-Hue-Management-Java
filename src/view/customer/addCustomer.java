
package view.customer;

import javax.swing.JScrollBar;
import model.CustomerModel;
import view.component.scroll.ScrollBarCus;

public class addCustomer extends javax.swing.JFrame {
    
    CustomerModel customer = null;
    boolean isSex = true;
    public addCustomer() {
        initComponents();
        // set vertical and horizontal scroll bar
        ScrollBarCus sb = new ScrollBarCus();
        sb.setOrientation(JScrollBar.HORIZONTAL);
        this.setLocationRelativeTo(null);
        this.setTitle("Thêm Khách Hàng");
//        gListRole = RoleDAOImpl.getInstance().getList();
    }
    
    public addCustomer(CustomerModel _customerModel) {
        initComponents();
        // set vertical and horizontal scroll bar
        ScrollBarCus sb = new ScrollBarCus();
        System.out.println("11111");
        sb.setOrientation(JScrollBar.HORIZONTAL);
        this.setLocationRelativeTo(null);

        setData(_customerModel);
        setReadOnly();
        // set button
        saveBtn2.setVisible(false);
    }
    private void setData(CustomerModel _customerModel){
        this.setTitle("Xem Khách Hàng");
        System.out.println(_customerModel.isSex());
        TF_customerID.setText(_customerModel.getID() + "");
        TF_NameCustomer.setText(_customerModel.getName());
        if(_customerModel.isSex()){
            checkNam.setSelected(true);
        }
        else{
            checkNu.setSelected(true);
        }
        TF_phoneNumber.setText(_customerModel.getPhoneNumber());
        TF_CCCD.setText(_customerModel.getCitizenNumber());
        panelLocation2.setAddress(_customerModel.getAddress());
    }
    
    private void setReadOnly() {
        TF_NameCustomer.setEditable(false);
        TF_phoneNumber.setEditable(false);
        TF_CCCD.setEditable(false);
    }
    
    private void setCheckBoxSex() {
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jPanel3 = new javax.swing.JPanel();
        checkNam = new javax.swing.JCheckBox();
        checkNu = new javax.swing.JCheckBox();
        bottom2 = new javax.swing.JPanel();
        saveBtn2 = new rojeru_san.complementos.RSButtonHover();
        cancelBtn2 = new rojeru_san.complementos.RSButtonHover();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        panelStaff.add(TF_phoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 42, 298, -1));

        jLabel3.setText("Căn cước công dân (CMND) (*):");
        panelStaff.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 210, -1));

        TF_NameCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_NameCustomerActionPerformed(evt);
            }
        });
        panelStaff.add(TF_NameCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 10, 300, -1));
        panelStaff.add(TF_CCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 74, 297, -1));

        jLabel1.setText("ID (*)");

        TF_customerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_customerIDActionPerformed(evt);
            }
        });

        jLabel2.setText("Giới tính:");

        checkNam.setText("Nam");
        checkNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkNamActionPerformed(evt);
            }
        });

        checkNu.setText("Nữ");
        checkNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkNuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(checkNam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkNu)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkNam)
                    .addComponent(checkNu))
                .addContainerGap())
        );

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(131, 131, 131))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TF_customerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
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
        // TODO add your handling code here:
    }//GEN-LAST:event_saveBtn2ActionPerformed

    private void cancelBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBtn2MouseClicked
        this.dispose();
    }//GEN-LAST:event_cancelBtn2MouseClicked

    private void cancelBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelBtn2ActionPerformed

    private void checkNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkNamActionPerformed
        boolean check = checkNam.isSelected();
        if(check){
           checkNu.setSelected(false);
           isSex = true; 
       }
    }//GEN-LAST:event_checkNamActionPerformed

    private void checkNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkNuActionPerformed
        // TODO add your handling code here:
        boolean check = checkNu.isSelected();
        if(check){
           checkNam.setSelected(false);
           isSex = false;
       }
    }//GEN-LAST:event_checkNuActionPerformed

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
    private rojeru_san.complementos.RSButtonHover cancelBtn2;
    private javax.swing.JCheckBox checkNam;
    private javax.swing.JCheckBox checkNu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private view.component.PanelLocation panelLocation2;
    private javax.swing.JPanel panelStaff;
    private rojeru_san.complementos.RSButtonHover saveBtn2;
    // End of variables declaration//GEN-END:variables
}
