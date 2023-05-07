package view.staff;

import dao.Staff.StaffDAOImpl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.StaffModel;
import table.TableStaff;
import view.component.scroll.ScrollBarCus;

public class StaffJPanel extends javax.swing.JPanel {

    StaffModel staffCurrent = new StaffModel();
    protected static int gCurrentID = 0;
    private TableRowSorter<TableModel> rowSorter = null;
    
    public StaffJPanel() {
        List<StaffModel> listStaff = StaffDAOImpl.getInstance().getList();
        initComponents();
        // set vertical and horizontal scroll bar
        ScrollPaneTable.setVerticalScrollBar(new ScrollBarCus());
        ScrollBarCus sb = new ScrollBarCus();
        sb.setOrientation(JScrollBar.HORIZONTAL);
        ScrollPaneTable.setHorizontalScrollBar(sb);
        tableStaff.fixTable(ScrollPaneTable);
        gCurrentID = listStaff.get(0).getID() + 1;
        
        setStaffTable();
    }

    public void setStaffTable() {
        List<StaffModel> listStaff = StaffDAOImpl.getInstance().getList();
        TableStaff tb = new TableStaff();
        tb.setStaffDetailsToTable(listStaff, tableStaff);
        
        rowSorter = new TableRowSorter<>(tableStaff.getModel());
        tableStaff.setRowSorter(rowSorter);
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = searchField.getText();
                if(text.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                }
                else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = searchField.getText();
                if(text.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                }
                else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        sumStaff.setText("Số lượng: " + listStaff.size());
    }

    private void setStaffCurrent() {
        List<StaffModel> listStaff = StaffDAOImpl.getInstance().getList();
        int row = tableStaff.getSelectedRow();
        StaffModel staff = listStaff.get(row);

        staffCurrent.setID(staff.getID());
        staffCurrent.setName(staff.getName());
        staffCurrent.setSdt(staff.getSdt());
        staffCurrent.setSex(staff.isSex());
        staffCurrent.setCccd(staff.getCccd());
        staffCurrent.setAddress(staff.getAddress());
        staffCurrent.setRole(staff.getRole());
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
        sumStaff = new javax.swing.JLabel();
        filter = new javax.swing.JPanel();
        happen = new javax.swing.JPanel();
        labelGoogleIcon2 = new view.component.LabelGoogleIcon();
        paymentNo = new javax.swing.JCheckBox();
        paymentYes = new javax.swing.JCheckBox();
        center = new javax.swing.JPanel();
        ScrollPaneTable = new javax.swing.JScrollPane();
        tableStaff = new view.component.table.Table();

        seeBtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_DOWN_MASK));
        seeBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        seeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/image/Search.png"))); // NOI18N
        seeBtn.setMnemonic('X');
        seeBtn.setText("Xem chi tiết");
        seeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeBtnActionPerformed(evt);
            }
        });
        popupMenu.add(seeBtn);
        popupMenu.add(jSeparator2);

        editBtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        editBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/image/Edit.png"))); // NOI18N
        editBtn.setMnemonic('C');
        editBtn.setText("Chỉnh sửa");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });
        popupMenu.add(editBtn);
        popupMenu.add(jSeparator3);

        removeBtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        removeBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        removeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/image/Delete.png"))); // NOI18N
        removeBtn.setText("Xóa");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });
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
        addBtn.setText("Thêm nhân viên");
        addBtn.setToolTipText("Ctrl+N");
        addBtn.setColorHover(new java.awt.Color(187, 214, 184));
        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addBtn.setPreferredSize(new java.awt.Dimension(140, 40));
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

        sumStaff.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sumStaff.setText("Số lượng: 0");
        button.add(sumStaff);

        searchAndButton.add(button);

        top.add(searchAndButton);

        filter.setBackground(getBackground());
        filter.setLayout(new javax.swing.BoxLayout(filter, javax.swing.BoxLayout.Y_AXIS));

        happen.setBackground(getBackground());

        labelGoogleIcon2.setText("Giới tính:");
        labelGoogleIcon2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        happen.add(labelGoogleIcon2);

        paymentNo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        paymentNo.setText("Nữ");
        paymentNo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paymentNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentNoActionPerformed(evt);
            }
        });
        happen.add(paymentNo);

        paymentYes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        paymentYes.setText("Nam");
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

        tableStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên NV", "SĐT", "Giới tính", "Số CCCD", "Địa chỉ", "Vị trí"
            }
        ));
        tableStaff.setComponentPopupMenu(popupMenu);
        tableStaff.setShowGrid(true);
        tableStaff.getTableHeader().setReorderingAllowed(false);
        ScrollPaneTable.setViewportView(tableStaff);

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
                .addComponent(ScrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(center, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        addStaff addStaff = new addStaff();
        addStaff.setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed


    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addBtnMouseClicked

    private void paymentNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentNoActionPerformed

    private void paymentYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentYesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentYesActionPerformed

    private void tableStaffMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tablePartyMouseReleased
        if (evt.isPopupTrigger()) {
            popupMenu.show(this, evt.getX(), evt.getY());
        }
    }

    // xử lí sự kiện xem staff
    private void seeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeBtnActionPerformed

        try {
            setStaffCurrent();
            System.out.println("---------");
            addStaff addStaff = new addStaff(staffCurrent);
            System.out.println(addStaff);
            addStaff.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nhân viên không hợp lệ", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_seeBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editBtnActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPaneTable;
    private rojeru_san.complementos.RSButtonHover addBtn;
    private javax.swing.JPanel button;
    private javax.swing.JPanel center;
    private javax.swing.JMenuItem editBtn;
    private javax.swing.JPanel filter;
    private javax.swing.JPanel happen;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private view.component.LabelGoogleIcon labelGoogleIcon2;
    private javax.swing.JCheckBox paymentNo;
    private javax.swing.JCheckBox paymentYes;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JMenuItem removeBtn;
    private javax.swing.JPanel searchAndButton;
    private rojerusan.RSMetroTextPlaceHolder searchField;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JMenuItem seeBtn;
    private javax.swing.JLabel sumStaff;
    private view.component.table.Table tableStaff;
    private javax.swing.JPanel top;
    // End of variables declaration//GEN-END:variables
}
