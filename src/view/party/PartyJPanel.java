package view.party;

import dao.DBConnection;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import view.component.scroll.ScrollBarCus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import model.PartyModel;


public class PartyJPanel extends javax.swing.JPanel {

    public PartyJPanel() {
        initComponents();
        // set vertical and horizontal scroll bar
        ScrollPaneTable.setVerticalScrollBar(new ScrollBarCus());
        ScrollBarCus sb = new ScrollBarCus();
        sb.setOrientation(JScrollBar.HORIZONTAL);
        ScrollPaneTable.setHorizontalScrollBar(sb);
        tableParty.fixTable(ScrollPaneTable);
        
        setPartyDetailsToTable();
    }
    DefaultTableModel model;
    public void setPartyDetailsToTable(){
        try{
            Connection con = DBConnection.getConnection();
            String sql ="SELECT *, customer.name AS CustomerName, paymentstatus.StatusName AS PaymentStatusName " +
                        "FROM party " +
                        "JOIN customer ON party.CustomerID = Customer.CustomerID " +
                        "JOIN happenstatus ON party.HappenStatusID = happenstatus.HappenStatusID " +
                        "JOIN paymentstatus ON party.PaymentStatusID = paymentstatus.PaymentStatusID;";
//            List<PartyModel> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
             
            while(rs.next()){
                PartyModel party = new PartyModel();
                
                party.setPartyID(rs.getInt("PartyID"));
                int partyID = party.getPartyID();               
                party.setPartyName(rs.getString("PartyName"));
                String partyName = party.getPartyName();               
                party.setCustomer(rs.getString("CustomerName"));
                String customerName = party.getCustomer();
                party.setSdt(rs.getString("PhoneNumber"));
                String partySDT = party.getSdt();
                party.setTableNumber(rs.getInt("TableNumber"));
                int tableNumber = party.getTableNumber();
                
                party.setTime(rs.getTimestamp("Time"));
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Timestamp time = (Timestamp) party.getTime();
                String formattedTime = dateFormat.format(party.getTime());
//                Timestamp time = (Timestamp) party.getTime();
                
                party.setLocation(rs.getString("Location"));
                String location = party.getLocation();
                party.setHappenStatus(rs.getString("StatusName"));
                String happenStatus = party.getHappenStatus();
                party.setPaymentStatus(rs.getString("PaymentStatusName"));
                String paymentStatus = party.getPaymentStatus();
                
                Object[] obj = {partyID, partyName, customerName, partySDT, tableNumber, time, location, happenStatus, paymentStatus};
                model = (DefaultTableModel) tableParty.getModel();
                model.addRow(obj);
            }
            
        } catch (Exception ex){
            ex.printStackTrace();
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        seeBtn = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        editBtn = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        removeBtn = new javax.swing.JMenuItem();
        top = new javax.swing.JPanel();
        searchAndButton = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        searchField = new rojerusan.RSMetroTextPlaceHolder();
        button = new javax.swing.JPanel();
        addBtn = new rojeru_san.complementos.RSButtonHover();
        paymentBtn = new rojeru_san.complementos.RSButtonHover();
        paymentBtn1 = new rojeru_san.complementos.RSButtonHover();
        sumParty = new javax.swing.JLabel();
        filter = new javax.swing.JPanel();
        payment = new javax.swing.JPanel();
        labelGoogleIcon1 = new view.component.LabelGoogleIcon();
        happenWait = new javax.swing.JCheckBox();
        happenNow = new javax.swing.JCheckBox();
        happenDone = new javax.swing.JCheckBox();
        happen = new javax.swing.JPanel();
        labelGoogleIcon2 = new view.component.LabelGoogleIcon();
        paymentNo = new javax.swing.JCheckBox();
        paymentYes = new javax.swing.JCheckBox();
        center = new javax.swing.JPanel();
        ScrollPaneTable = new javax.swing.JScrollPane();
        tableParty = new view.component.table.Table();

        seeBtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_DOWN_MASK));
        seeBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        seeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/image/Search.png"))); // NOI18N
        seeBtn.setMnemonic('X');
        seeBtn.setText("Xem chi tiết");
        popupMenu.add(seeBtn);
        popupMenu.add(jSeparator2);

        editBtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        editBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/image/Edit.png"))); // NOI18N
        editBtn.setMnemonic('C');
        editBtn.setText("Chỉnh sửa");
        popupMenu.add(editBtn);
        popupMenu.add(jSeparator3);

        removeBtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        removeBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        removeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/image/Delete.png"))); // NOI18N
        removeBtn.setText("Xóa");
        popupMenu.add(removeBtn);

        setBackground(new java.awt.Color(249, 245, 231));
        setMinimumSize(new java.awt.Dimension(1017, 576));
        setPreferredSize(new java.awt.Dimension(1017, 576));
        setLayout(new java.awt.BorderLayout());

        top.setBackground(getBackground());
        top.setLayout(new javax.swing.BoxLayout(top, javax.swing.BoxLayout.Y_AXIS));

        searchAndButton.setBackground(getBackground());
        searchAndButton.setLayout(new javax.swing.BoxLayout(searchAndButton, javax.swing.BoxLayout.LINE_AXIS));

        searchPanel.setBackground(getBackground());

        searchField.setForeground(new java.awt.Color(0, 0, 0));
        searchField.setToolTipText("Nhấn Enter để tìm");
        searchField.setBorderColor(new java.awt.Color(10, 77, 104));
        searchField.setBotonColor(new java.awt.Color(0, 0, 0));
        searchField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchField.setPhColor(new java.awt.Color(10, 77, 104));
        searchField.setPlaceholder("Tìm kiếm");

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        searchAndButton.add(searchPanel);

        button.setBackground(getBackground());

        addBtn.setBackground(new java.awt.Color(148, 175, 159));
        addBtn.setText("Thêm tiệc");
        addBtn.setToolTipText("Ctrl+N");
        addBtn.setColorHover(new java.awt.Color(187, 214, 184));
        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addBtn.setPreferredSize(new java.awt.Dimension(100, 40));
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
        button.add(addBtn);

        paymentBtn.setBackground(new java.awt.Color(10, 77, 104));
        paymentBtn.setText("Thanh toán");
        paymentBtn.setColorHover(new java.awt.Color(14, 112, 152));
        paymentBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        paymentBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        paymentBtn.setPreferredSize(new java.awt.Dimension(110, 40));
        paymentBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paymentBtnMouseClicked(evt);
            }
        });
        paymentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentBtnActionPerformed(evt);
            }
        });
        button.add(paymentBtn);

        paymentBtn1.setBackground(new java.awt.Color(10, 77, 104));
        paymentBtn1.setText("In thực đơn");
        paymentBtn1.setColorHover(new java.awt.Color(14, 112, 152));
        paymentBtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        paymentBtn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        paymentBtn1.setPreferredSize(new java.awt.Dimension(110, 40));
        paymentBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paymentBtn1MouseClicked(evt);
            }
        });
        paymentBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentBtn1ActionPerformed(evt);
            }
        });
        button.add(paymentBtn1);

        sumParty.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sumParty.setText("Số lượng: 0");
        button.add(sumParty);

        searchAndButton.add(button);

        top.add(searchAndButton);

        filter.setBackground(getBackground());
        filter.setLayout(new javax.swing.BoxLayout(filter, javax.swing.BoxLayout.Y_AXIS));

        payment.setBackground(getBackground());

        labelGoogleIcon1.setText("Trạng thái tiệc:");
        labelGoogleIcon1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        payment.add(labelGoogleIcon1);

        happenWait.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        happenWait.setText("Sắp tới");
        happenWait.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        payment.add(happenWait);

        happenNow.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        happenNow.setText("Đang tổ chức");
        happenNow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        happenNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                happenNowActionPerformed(evt);
            }
        });
        payment.add(happenNow);

        happenDone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        happenDone.setText("Đã xong");
        happenDone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        happenDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                happenDoneActionPerformed(evt);
            }
        });
        payment.add(happenDone);

        filter.add(payment);

        happen.setBackground(getBackground());

        labelGoogleIcon2.setText("Thanh toán:");
        labelGoogleIcon2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        happen.add(labelGoogleIcon2);

        paymentNo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        paymentNo.setText("Chưa");
        paymentNo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paymentNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentNoActionPerformed(evt);
            }
        });
        happen.add(paymentNo);

        paymentYes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        paymentYes.setText("Xong");
        paymentYes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paymentYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentYesActionPerformed(evt);
            }
        });
        happen.add(paymentYes);

        filter.add(happen);

        top.add(filter);

        add(top, java.awt.BorderLayout.NORTH);

        center.setBackground(getBackground());

        tableParty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên tiệc", "Người đặt", "SĐT", "Số bàn", "Thời gian", "Địa điểm", "TT tiệc", "Thanh toán"
            }
        ));
        tableParty.setShowGrid(true);
        tableParty.getTableHeader().setReorderingAllowed(false);
        tableParty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablePartyMouseReleased(evt);
            }
        });
        ScrollPaneTable.setViewportView(tableParty);

        javax.swing.GroupLayout centerLayout = new javax.swing.GroupLayout(center);
        center.setLayout(centerLayout);
        centerLayout.setHorizontalGroup(
            centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE)
                .addContainerGap())
        );
        centerLayout.setVerticalGroup(
            centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(center, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void paymentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentBtnActionPerformed

    private void paymentBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentBtnMouseClicked

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addBtnActionPerformed

    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addBtnMouseClicked

    private void paymentBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentBtn1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentBtn1MouseClicked

    private void paymentBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentBtn1ActionPerformed

    private void tablePartyMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePartyMouseReleased
        if (evt.isPopupTrigger()) {
            popupMenu.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tablePartyMouseReleased

    private void happenNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_happenNowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_happenNowActionPerformed

    private void happenDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_happenDoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_happenDoneActionPerformed

    private void paymentNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentNoActionPerformed

    private void paymentYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentYesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentYesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPaneTable;
    private rojeru_san.complementos.RSButtonHover addBtn;
    private javax.swing.JPanel button;
    private javax.swing.JPanel center;
    private javax.swing.JMenuItem editBtn;
    private javax.swing.JPanel filter;
    private javax.swing.JPanel happen;
    private javax.swing.JCheckBox happenDone;
    private javax.swing.JCheckBox happenNow;
    private javax.swing.JCheckBox happenWait;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private view.component.LabelGoogleIcon labelGoogleIcon1;
    private view.component.LabelGoogleIcon labelGoogleIcon2;
    private javax.swing.JPanel payment;
    private rojeru_san.complementos.RSButtonHover paymentBtn;
    private rojeru_san.complementos.RSButtonHover paymentBtn1;
    private javax.swing.JCheckBox paymentNo;
    private javax.swing.JCheckBox paymentYes;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JMenuItem removeBtn;
    private javax.swing.JPanel searchAndButton;
    private rojerusan.RSMetroTextPlaceHolder searchField;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JMenuItem seeBtn;
    private javax.swing.JLabel sumParty;
    private view.component.table.Table tableParty;
    private javax.swing.JPanel top;
    // End of variables declaration//GEN-END:variables
}
