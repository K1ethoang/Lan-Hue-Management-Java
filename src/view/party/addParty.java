package view.party;

import com.github.lgooddatepicker.components.DatePickerSettings;
import dao.Customer.CustomerDAOImpl;
import dao.TypeParty.TypePartyDAOImpl;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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

    List<CustomerModel> gListCustomer = null;
    List<TypePartyModel> gListTypeParty = null;
    PartyModel gPartyModel = null;
    CustomerModel gCustomerModel = null;

    public addParty() {
        initComponents();

        AutoCompleteDecorator.decorate(comboBoxPhoneNumber);

        setScroll();

        setTextFieldID();
        setComboBoxPhoneNumber();
        setComboBoxTypeParty();
        initDateTimeField();
    }

    public addParty(PartyModel _partyModel) {
        initComponents();

        AutoCompleteDecorator.decorate(comboBoxPhoneNumber);

        setScroll();

        initDateTimeField();

        setDataSeeParty(_partyModel);

        // set button
        savePartyBtn.setVisible(false);

    }

    private void setScroll() {
        ScrollPaneNote.setVerticalScrollBar(new ScrollBarCus());
        ScrollBarCus sb = new ScrollBarCus();
        sb.setOrientation(JScrollBar.HORIZONTAL);
        ScrollPaneNote.setHorizontalScrollBar(sb);
    }

    private void setComboBoxPhoneNumber() {
        gListCustomer = CustomerDAOImpl.getInstance().getList();
        comboBoxPhoneNumber.removeAllItems();
        for (int i = 0; i < gListCustomer.size(); i++) {
            comboBoxPhoneNumber.addItem(gListCustomer.get(i).getPhoneNumber());
        }
    }

    private void initDateTimeField() {
        Locale locale = new Locale("vi");
        // set date

        DatePickerSettings settings = new DatePickerSettings(locale);
        settings.setAllowEmptyDates(false);
        settings.setFormatForDatesCommonEra("EEEE, d MMMM, y");
        settings.setFormatForTodayButton(DateTimeFormatter.ofPattern("d MMMM y", locale));
        TF_date.setSettings(settings);

        // set time
        SP_time.setTimeToNow();

        SP_time.setLocale(Locale.getDefault());

        SP_time.getSettings().setAllowEmptyTimes(false);

        SP_time.getSettings().setDisplaySpinnerButtons(true);

        SP_time.getSettings().setFormatForMenuTimes(DateTimeFormatter.ofPattern("HH:mm", locale));
        SP_time.getSettings().setFormatForDisplayTime(DateTimeFormatter.ofPattern("HH:mm", locale));
    }

    private void setTimeField(Time time) {
        LocalTime localTime = time.toLocalTime();
        SP_time.setTime(localTime);
    }

    private void setDateField(Date date) {
        LocalDate localDate = Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.of("Asia/Ho_Chi_Minh"))
                .toLocalDate();
        TF_date.setDate(localDate);
    }

    private void setTextFieldID() {
        TF_partyID.setText(gCurrentID + "");
    }

    private void setDataSeeParty(PartyModel partyModel) {
        this.setTitle("Xem tiệc");
        TF_partyID.setText(partyModel.getID() + "");
        TF_partyName.setText(partyModel.getPartyName());
        SP_partyNumber.setValue(partyModel.getTableNumber());
        setTimeField(partyModel.getTime());
        setDateField(partyModel.getDate());
        comboBoxTypeParty.addItem(partyModel.getTypeParty().getName());
        textAreaNote.setText(partyModel.getNote());
        panelLocation2.setAddress(partyModel.getLocation());
        panelLocation2.setFullAddress();
        comboBoxPhoneNumber.addItem(partyModel.getCustomer().getPhoneNumber());
        TF_nameCustomer.setText(partyModel.getCustomer().getName());
        setFieldEnable(false);
    }

    private void setComboBoxTypeParty() {
        gListTypeParty = TypePartyDAOImpl.getInstance().getList();
        comboBoxTypeParty.removeAllItems();
        for (int i = 0; i < gListTypeParty.size(); i++) {
            comboBoxTypeParty.addItem(gListTypeParty.get(i).getName());
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        panelCustomer = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxPhoneNumber = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        TF_nameCustomer = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
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
        SP_time = new com.github.lgooddatepicker.components.TimePicker();
        jLabel10 = new javax.swing.JLabel();
        TF_date = new com.github.lgooddatepicker.components.DatePicker();
        panelNote = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        ScrollPaneNote = new javax.swing.JScrollPane();
        textAreaNote = new javax.swing.JTextArea();
        panelLocation2 = new view.component.PanelLocation();
        bottom = new javax.swing.JPanel();
        savePartyBtn = new rojeru_san.complementos.RSButtonHover();
        savePartyBtn1 = new rojeru_san.complementos.RSButtonHover();
        cancelBtn = new rojeru_san.complementos.RSButtonHover();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm tiệc");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Thông tin khách hàng");
        jPanel1.add(jLabel9);

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

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Thông tin tiệc");
        jPanel3.add(jLabel11);

        jPanel2.add(jPanel3);

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
        panelRight.add(SP_time);

        jLabel10.setText("Ngày (*)");
        panelRight.add(jLabel10);
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

        savePartyBtn1.setBackground(new java.awt.Color(10, 77, 104));
        savePartyBtn1.setText("Lưu và chọn món");
        savePartyBtn1.setColorHover(new java.awt.Color(14, 112, 152));
        savePartyBtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        savePartyBtn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        savePartyBtn1.setPreferredSize(new java.awt.Dimension(150, 40));
        savePartyBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePartyBtn1ActionPerformed(evt);
            }
        });
        bottom.add(savePartyBtn1);

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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 969, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
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

    }//GEN-LAST:event_savePartyBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

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

    private void savePartyBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePartyBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_savePartyBtn1ActionPerformed

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
    private com.github.lgooddatepicker.components.TimePicker SP_time;
    private javax.swing.JScrollPane ScrollPaneNote;
    private com.github.lgooddatepicker.components.DatePicker TF_date;
    private javax.swing.JTextField TF_nameCustomer;
    private javax.swing.JTextField TF_partyID;
    private javax.swing.JTextField TF_partyName;
    private javax.swing.JPanel bottom;
    private rojeru_san.complementos.RSButtonHover cancelBtn;
    private javax.swing.JPanel center;
    private javax.swing.JComboBox<String> comboBoxPhoneNumber;
    private javax.swing.JComboBox<String> comboBoxTypeParty;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel panelCustomer;
    private javax.swing.JPanel panelLeft;
    private view.component.PanelLocation panelLocation2;
    private javax.swing.JPanel panelNote;
    private javax.swing.JPanel panelRight;
    private rojeru_san.complementos.RSButtonHover savePartyBtn;
    private rojeru_san.complementos.RSButtonHover savePartyBtn1;
    private javax.swing.JTextArea textAreaNote;
    // End of variables declaration//GEN-END:variables
}
