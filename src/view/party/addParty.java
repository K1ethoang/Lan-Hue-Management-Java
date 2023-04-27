package view.party;

import java.util.List;
import javax.swing.JScrollBar;
import model.CustomerModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import service.customer.CustomerServiceImpl;
import view.component.scroll.ScrollBarCus;

/**
 *
 * @author kieth
 */
public class addParty extends javax.swing.JFrame {

    List<CustomerModel> listCustomer = new CustomerServiceImpl().getList();
    CustomerModel customerModel = null;

    public addParty() {
        initComponents();

        AutoCompleteDecorator.decorate(comboBoxCustomer);
        // set vertical and horizontal scroll bar
        ScrollPaneNote.setVerticalScrollBar(new ScrollBarCus());
        ScrollBarCus sb = new ScrollBarCus();
        sb.setOrientation(JScrollBar.HORIZONTAL);
        ScrollPaneNote.setHorizontalScrollBar(sb);
        setComboBoxCustomer();
    }

    private void setComboBoxCustomer() {
        comboBoxCustomer.removeAllItems();
        for (int i = 0; i < listCustomer.size(); i++) {
            comboBoxCustomer.addItem(listCustomer.get(i).getName());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinField2 = new com.toedter.components.JSpinField();
        jPanel2 = new javax.swing.JPanel();
        center = new javax.swing.JPanel();
        panelLeft = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TF_partyID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TF_partyName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        SP_partyNumber = new com.toedter.components.JSpinField();
        panelRight = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        panelNote = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        ScrollPaneNote = new javax.swing.JScrollPane();
        textAreaNote = new javax.swing.JTextArea();
        panelLocation2 = new view.component.PanelLocation();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        addBtn = new rojeru_san.complementos.RSButtonHover();
        panelCustomer = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        comboBoxCustomer = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        TF_phoneNumber = new javax.swing.JTextField();
        bottom = new javax.swing.JPanel();
        saveBtn = new rojeru_san.complementos.RSButtonHover();
        cancelBtn = new rojeru_san.complementos.RSButtonHover();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm tiệc");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        center.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 10, 0));
        center.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        panelLeft.setLayout(new java.awt.GridLayout(3, 2, 0, 10));

        jLabel1.setText("ID");
        panelLeft.add(jLabel1);

        TF_partyID.setText("123");
        TF_partyID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TF_partyID.setEnabled(false);
        panelLeft.add(TF_partyID);

        jLabel2.setText("Tên tiệc (*)");
        panelLeft.add(jLabel2);

        TF_partyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_partyNameActionPerformed(evt);
            }
        });
        panelLeft.add(TF_partyName);

        jLabel3.setText("Số bàn (*)");
        panelLeft.add(jLabel3);

        SP_partyNumber.setValue(2);
        panelLeft.add(SP_partyNumber);

        center.add(panelLeft);

        panelRight.setLayout(new java.awt.GridLayout(3, 2, 0, 10));

        jLabel7.setText("Loại tiệc (*)");
        panelRight.add(jLabel7);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panelRight.add(jComboBox1);

        jLabel4.setText("Thời gian (*)");
        panelRight.add(jLabel4);

        jSpinner2.setModel(new javax.swing.SpinnerDateModel());
        jSpinner2.setEditor(new javax.swing.JSpinner.DateEditor(jSpinner2, "HH:mm"));
        panelRight.add(jSpinner2);

        jLabel10.setText("Ngày (*)");
        panelRight.add(jLabel10);

        jDateChooser1.setDateFormatString("dd-MM-yyyy");
        panelRight.add(jDateChooser1);

        center.add(panelRight);

        jPanel2.add(center);

        panelNote.setLayout(new java.awt.GridLayout(1, 2, 0, 10));

        jLabel8.setText("Ghi chú");
        panelNote.add(jLabel8);

        textAreaNote.setColumns(30);
        textAreaNote.setLineWrap(true);
        textAreaNote.setRows(30);
        ScrollPaneNote.setViewportView(textAreaNote);

        panelNote.add(ScrollPaneNote);

        jPanel2.add(panelNote);

        panelLocation2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 0, 0));
        jPanel2.add(panelLocation2);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Thông tin khách hàng");
        jPanel1.add(jLabel9);

        addBtn.setBackground(new java.awt.Color(148, 175, 159));
        addBtn.setText("Thêm khách hàng");
        addBtn.setToolTipText("Ctrl+N");
        addBtn.setColorHover(new java.awt.Color(187, 214, 184));
        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addBtn.setPreferredSize(new java.awt.Dimension(150, 40));
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBtnMouseClicked(evt);
            }
        });
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addBtn);

        jPanel2.add(jPanel1);

        panelCustomer.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panelCustomer.setLayout(new java.awt.GridLayout(2, 2, 0, 10));

        jLabel5.setText("Khách hàng (*)");
        panelCustomer.add(jLabel5);

        comboBoxCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCustomerActionPerformed(evt);
            }
        });
        panelCustomer.add(comboBoxCustomer);

        jLabel6.setText("SĐT liên hệ (*)");
        panelCustomer.add(jLabel6);

        TF_phoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_phoneNumberActionPerformed(evt);
            }
        });
        panelCustomer.add(TF_phoneNumber);

        jPanel2.add(panelCustomer);

        bottom.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        saveBtn.setBackground(new java.awt.Color(10, 77, 104));
        saveBtn.setText("Lưu");
        saveBtn.setColorHover(new java.awt.Color(14, 112, 152));
        saveBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saveBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveBtn.setPreferredSize(new java.awt.Dimension(110, 40));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        bottom.add(saveBtn);

        cancelBtn.setBackground(new java.awt.Color(10, 77, 104));
        cancelBtn.setText("Hủy");
        cancelBtn.setColorHover(new java.awt.Color(14, 112, 152));
        cancelBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelBtn.setPreferredSize(new java.awt.Dimension(110, 40));
        cancelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelBtnMouseClicked(evt);
            }
        });
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        bottom.add(cancelBtn);

        jPanel2.add(bottom);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TF_partyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_partyNameActionPerformed
        //
    }//GEN-LAST:event_TF_partyNameActionPerformed

    private void TF_phoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_phoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_phoneNumberActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveBtnActionPerformed

    private void cancelBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBtnMouseClicked
        this.dispose();
    }//GEN-LAST:event_cancelBtnMouseClicked

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addBtnMouseClicked

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addBtnActionPerformed

    private void comboBoxCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCustomerActionPerformed
        customerModel = listCustomer.get(comboBoxCustomer.getSelectedIndex());
        TF_phoneNumber.setText(customerModel.getPhoneNumber());
    }//GEN-LAST:event_comboBoxCustomerActionPerformed

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
            java.util.logging.Logger.getLogger(addParty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addParty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addParty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addParty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addParty().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.components.JSpinField SP_partyNumber;
    private javax.swing.JScrollPane ScrollPaneNote;
    private javax.swing.JTextField TF_partyID;
    private javax.swing.JTextField TF_partyName;
    private javax.swing.JTextField TF_phoneNumber;
    private rojeru_san.complementos.RSButtonHover addBtn;
    private javax.swing.JPanel bottom;
    private rojeru_san.complementos.RSButtonHover cancelBtn;
    private javax.swing.JPanel center;
    private javax.swing.JComboBox<String> comboBoxCustomer;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.toedter.components.JSpinField jSpinField2;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JPanel panelCustomer;
    private javax.swing.JPanel panelLeft;
    private view.component.PanelLocation panelLocation2;
    private javax.swing.JPanel panelNote;
    private javax.swing.JPanel panelRight;
    private rojeru_san.complementos.RSButtonHover saveBtn;
    private javax.swing.JTextArea textAreaNote;
    // End of variables declaration//GEN-END:variables
}
