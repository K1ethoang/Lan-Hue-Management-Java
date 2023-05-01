package view.party;

import dao.Customer.CustomerDAOImpl;
import dao.Party.PartyDAOImpl;
import dao.TypeParty.TypePartyDAOImpl;
import java.util.List;
import javax.swing.JScrollBar;
import model.CustomerModel;
import model.PartyModel;
import model.TypePartyModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import view.component.scroll.ScrollBarCus;
import static view.party.PartyJPanel.gCurrentID;

/**
 *
 * @author kieth
 */
public class addParty extends javax.swing.JFrame {

    List<CustomerModel> gListCustomer = CustomerDAOImpl.getInstance().getList();
    List<TypePartyModel> listTypeParty = TypePartyDAOImpl.getInstance().getList();
    PartyModel gPartyModel = null;
    CustomerModel gCustomerModel = null;

    public addParty() {
        initComponents();

        AutoCompleteDecorator.decorate(comboBoxPhoneNumber);
        // set vertical and horizontal scroll bar
        ScrollPaneNote.setVerticalScrollBar(new ScrollBarCus());
        ScrollBarCus sb = new ScrollBarCus();
        sb.setOrientation(JScrollBar.HORIZONTAL);
        ScrollPaneNote.setHorizontalScrollBar(sb);

        setTextFieldID();
        setComboBoxPhoneNumber();
        setComboBoxTypeParty();
    }

    public addParty(PartyModel _partyModel) {
        initComponents();

        AutoCompleteDecorator.decorate(comboBoxPhoneNumber);
        // set vertical and horizontal scroll bar
        ScrollPaneNote.setVerticalScrollBar(new ScrollBarCus());
        ScrollBarCus sb = new ScrollBarCus();
        sb.setOrientation(JScrollBar.HORIZONTAL);
        ScrollPaneNote.setHorizontalScrollBar(sb);

        setDataSeeParty(_partyModel);

        // set button
        addCusBtn.setVisible(false);
        savePartyBtn.setVisible(false);

    }

    private void setComboBoxPhoneNumber() {
        comboBoxPhoneNumber.removeAllItems();
        for (int i = 0; i < gListCustomer.size(); i++) {
            comboBoxPhoneNumber.addItem(gListCustomer.get(i).getPhoneNumber());
        }
    }

    private void setTextFieldID() {
        TF_partyID.setText(gCurrentID + "");
    }

    private void setDataSeeParty(PartyModel partyModel) {
        this.setTitle("Xem tiệc");
        TF_partyID.setText(partyModel.getID() + "");
        TF_partyName.setText(partyModel.getPartyName());
        SP_partyNumber.setValue(partyModel.getTableNumber());
        comboBoxTypeParty.addItem(partyModel.getTypeParty().getName());
        textAreaNote.setText(partyModel.getNote());
        panelLocation2.setAddress(partyModel.getLocation());
        panelLocation2.setFullAddress();
        comboBoxPhoneNumber.addItem(partyModel.getCustomer().getPhoneNumber());
        TF_nameCustomer.setText(partyModel.getCustomer().getName());
        setFieldEnable(false);
    }

    private void setComboBoxTypeParty() {
        comboBoxTypeParty.removeAllItems();
        for (int i = 0; i < listTypeParty.size(); i++) {
            comboBoxTypeParty.addItem(listTypeParty.get(i).getName());
        }
    }

    private void setFieldEnable(boolean bool) {
        TF_partyName.setEditable(bool);
        SP_partyNumber.setEnabled(bool);
        SP_time.setEnabled(bool);
        TF_date.setEnabled(bool);
        textAreaNote.setEditable(bool);
        comboBoxPhoneNumber.setEditable(bool);
        TF_nameCustomer.setEditable(bool);
        panelLocation2.setEnable(bool);
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
        comboBoxTypeParty = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        SP_time = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        TF_date = new com.toedter.calendar.JDateChooser();
        panelNote = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        ScrollPaneNote = new javax.swing.JScrollPane();
        textAreaNote = new javax.swing.JTextArea();
        panelLocation2 = new view.component.PanelLocation();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        addCusBtn = new rojeru_san.complementos.RSButtonHover();
        panelCustomer = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxPhoneNumber = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        TF_nameCustomer = new javax.swing.JTextField();
        bottom = new javax.swing.JPanel();
        savePartyBtn = new rojeru_san.complementos.RSButtonHover();
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

        TF_partyID.setEditable(false);
        TF_partyID.setText("0");
        TF_partyID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_partyIDActionPerformed(evt);
            }
        });
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

        comboBoxTypeParty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTypePartyActionPerformed(evt);
            }
        });
        panelRight.add(comboBoxTypeParty);

        jLabel4.setText("Thời gian (*)");
        panelRight.add(jLabel4);

        SP_time.setModel(new javax.swing.SpinnerDateModel());
        SP_time.setEditor(new javax.swing.JSpinner.DateEditor(SP_time, "HH:mm"));
        panelRight.add(SP_time);

        jLabel10.setText("Ngày (*)");
        panelRight.add(jLabel10);

        TF_date.setDateFormatString("dd-MM-yyyy");
        panelRight.add(TF_date);

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

        addCusBtn.setBackground(new java.awt.Color(148, 175, 159));
        addCusBtn.setText("Thêm khách hàng");
        addCusBtn.setToolTipText("Ctrl+N");
        addCusBtn.setColorHover(new java.awt.Color(187, 214, 184));
        addCusBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addCusBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addCusBtn.setPreferredSize(new java.awt.Dimension(150, 40));
        addCusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCusBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addCusBtn);

        jPanel2.add(jPanel1);

        panelCustomer.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panelCustomer.setLayout(new java.awt.GridLayout(2, 2, 0, 10));

        jLabel6.setText("SĐT liên hệ (*)");
        panelCustomer.add(jLabel6);

        comboBoxPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxPhoneNumberActionPerformed(evt);
            }
        });
        panelCustomer.add(comboBoxPhoneNumber);

        jLabel5.setText("Khách hàng (*)");
        panelCustomer.add(jLabel5);

        TF_nameCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_nameCustomerActionPerformed(evt);
            }
        });
        panelCustomer.add(TF_nameCustomer);

        jPanel2.add(panelCustomer);

        bottom.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        savePartyBtn.setBackground(new java.awt.Color(10, 77, 104));
        savePartyBtn.setText("Lưu");
        savePartyBtn.setColorHover(new java.awt.Color(14, 112, 152));
        savePartyBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        savePartyBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        savePartyBtn.setPreferredSize(new java.awt.Dimension(110, 40));
        savePartyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePartyBtnActionPerformed(evt);
            }
        });
        bottom.add(savePartyBtn);

        cancelBtn.setBackground(new java.awt.Color(10, 77, 104));
        cancelBtn.setText("Hủy");
        cancelBtn.setColorHover(new java.awt.Color(14, 112, 152));
        cancelBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelBtn.setPreferredSize(new java.awt.Dimension(110, 40));
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

    private void TF_nameCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_nameCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_nameCustomerActionPerformed

    private void savePartyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePartyBtnActionPerformed
        System.out.println(PartyDAOImpl.getInstance().insert(gPartyModel));
    }//GEN-LAST:event_savePartyBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void addCusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCusBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addCusBtnActionPerformed

    private void comboBoxPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxPhoneNumberActionPerformed
        if (gListCustomer != null) {
            gCustomerModel = gListCustomer.get(comboBoxPhoneNumber.getSelectedIndex());
            TF_nameCustomer.setText(gCustomerModel.getName());
        }
    }//GEN-LAST:event_comboBoxPhoneNumberActionPerformed

    private void comboBoxTypePartyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTypePartyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxTypePartyActionPerformed

    private void TF_partyIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_partyIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_partyIDActionPerformed

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
    private javax.swing.JSpinner SP_time;
    private javax.swing.JScrollPane ScrollPaneNote;
    private com.toedter.calendar.JDateChooser TF_date;
    private javax.swing.JTextField TF_nameCustomer;
    private javax.swing.JTextField TF_partyID;
    private javax.swing.JTextField TF_partyName;
    private rojeru_san.complementos.RSButtonHover addCusBtn;
    private javax.swing.JPanel bottom;
    private rojeru_san.complementos.RSButtonHover cancelBtn;
    private javax.swing.JPanel center;
    private javax.swing.JComboBox<String> comboBoxPhoneNumber;
    private javax.swing.JComboBox<String> comboBoxTypeParty;
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
    private javax.swing.JPanel panelCustomer;
    private javax.swing.JPanel panelLeft;
    private view.component.PanelLocation panelLocation2;
    private javax.swing.JPanel panelNote;
    private javax.swing.JPanel panelRight;
    private rojeru_san.complementos.RSButtonHover savePartyBtn;
    private javax.swing.JTextArea textAreaNote;
    // End of variables declaration//GEN-END:variables
}
