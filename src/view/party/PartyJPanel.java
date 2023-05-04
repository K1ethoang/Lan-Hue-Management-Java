package view.party;

import dao.Party.PartyDAOImpl;
import dao.TypeParty.TypePartyDAOImpl;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JScrollBar;
import view.component.scroll.ScrollBarCus;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import model.PartyModel;
import model.TypePartyModel;
import table.TableParty;

public class PartyJPanel extends javax.swing.JPanel {

    List<PartyModel> gListParty = null;
    PartyModel gPartyCurrent = new PartyModel();
    protected static int gCurrentID = 0;

    public PartyJPanel() {
        initComponents();
        // set vertical and horizontal scroll bar
        ScrollPaneTable.setVerticalScrollBar(new ScrollBarCus());
        ScrollBarCus sb = new ScrollBarCus();
        sb.setOrientation(JScrollBar.HORIZONTAL);
        ScrollPaneTable.setHorizontalScrollBar(sb);
        tableParty.fixTable(ScrollPaneTable);

        // get data party
        gListParty = PartyDAOImpl.getInstance().getList();
        gCurrentID = gListParty.get(0).getID() + 1;

        setComboBoxTypeParty();
        setPartyTable();

        // set short cut
//        seeBtn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_DOWN_MASK));
    }

    private void setPartyTable() {
        TableParty tb = new TableParty();
        tb.setPartyDetailsToTable(gListParty, tableParty);
        sumParty.setText("Số lượng: " + gListParty.size() + "");

    }

    private void setComboBoxTypeParty() {
        comboBoxTypeParty.removeAllItems();
        List<TypePartyModel> list = TypePartyDAOImpl.getInstance().getList();
        comboBoxTypeParty.addItem("Tất cả");
        for (int i = 0; i < list.size(); i++) {
            comboBoxTypeParty.addItem(list.get(i).getName());
        }
    }

    private void setPartyCurrent(int row) {
        PartyModel party = gListParty.get(row);
        gPartyCurrent = party;
    }

    private int getIndexPartySelected() {
        int row = tableParty.getSelectedRow();
        return row;
    }

    private void printDialogErrorSelectParty() {
        JOptionPane.showMessageDialog(this, "Tiệc không hợp lệ", "Thông báo", JOptionPane.ERROR_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        selectDishBtn = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        seeBtn = new javax.swing.JMenu();
        seePartyBtn = new javax.swing.JMenuItem();
        seeMenuBtn = new javax.swing.JMenuItem();
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
        printMenuBtn = new rojeru_san.complementos.RSButtonHover();
        sumParty = new javax.swing.JLabel();
        filter = new javax.swing.JPanel();
        typeParty = new javax.swing.JPanel();
        labelGoogleIcon3 = new view.component.LabelGoogleIcon();
        comboBoxTypeParty = new javax.swing.JComboBox<>();
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

        selectDishBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        selectDishBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/image/Numbered list.png"))); // NOI18N
        selectDishBtn.setText("Chọn món ăn");
        selectDishBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectDishBtnActionPerformed(evt);
            }
        });
        popupMenu.add(selectDishBtn);
        popupMenu.add(jSeparator4);

        seeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/image/Search.png"))); // NOI18N
        seeBtn.setText("Xem");

        seePartyBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        seePartyBtn.setText("Tiệc");
        seePartyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seePartyBtnActionPerformed(evt);
            }
        });
        seeBtn.add(seePartyBtn);

        seeMenuBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        seeMenuBtn.setText("Món ăn");
        seeMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeMenuBtnActionPerformed(evt);
            }
        });
        seeBtn.add(seeMenuBtn);

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
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

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
        addBtn.setColorHover(new java.awt.Color(187, 214, 184));
        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addBtn.setPreferredSize(new java.awt.Dimension(100, 40));
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
        paymentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentBtnActionPerformed(evt);
            }
        });
        button.add(paymentBtn);

        printMenuBtn.setBackground(new java.awt.Color(10, 77, 104));
        printMenuBtn.setText("In thực đơn");
        printMenuBtn.setColorHover(new java.awt.Color(14, 112, 152));
        printMenuBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        printMenuBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        printMenuBtn.setPreferredSize(new java.awt.Dimension(110, 40));
        button.add(printMenuBtn);

        sumParty.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sumParty.setText("Số lượng: 0");
        button.add(sumParty);

        searchAndButton.add(button);

        top.add(searchAndButton);

        filter.setBackground(getBackground());
        filter.setLayout(new javax.swing.BoxLayout(filter, javax.swing.BoxLayout.Y_AXIS));

        typeParty.setBackground(getBackground());

        labelGoogleIcon3.setText("Loại tiệc:");
        labelGoogleIcon3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        typeParty.add(labelGoogleIcon3);

        comboBoxTypeParty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTypePartyActionPerformed(evt);
            }
        });
        typeParty.add(comboBoxTypeParty);

        filter.add(typeParty);

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
                "ID", "Tên tiệc", "Loại tiệc", "Người đặt", "SĐT", "Số bàn", "Ngày", "Giờ", "Địa điểm", "Trạng thái", "Thanh toán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableParty.setComponentPopupMenu(popupMenu);
        tableParty.setShowGrid(true);
        tableParty.getTableHeader().setReorderingAllowed(false);
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
                .addComponent(ScrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(center, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxTypePartyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTypePartyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxTypePartyActionPerformed

    private void seeMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeMenuBtnActionPerformed
        int row = getIndexPartySelected();
        if (row >= 0) {
            setPartyCurrent(row);
            addPartyMenu addPartyMenu = new addPartyMenu(gPartyCurrent);
            addPartyMenu.setVisible(true);
        } else {
            printDialogErrorSelectParty();
        }
    }//GEN-LAST:event_seeMenuBtnActionPerformed

    private void seePartyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seePartyBtnActionPerformed
        int row = getIndexPartySelected();
        if (row >= 0) {
            setPartyCurrent(row);
            addParty addParty = new addParty(gPartyCurrent);
            addParty.setVisible(true);
        } else {
            printDialogErrorSelectParty();
        }
    }//GEN-LAST:event_seePartyBtnActionPerformed

    private void selectDishBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectDishBtnActionPerformed
        int row = getIndexPartySelected();
        if (row >= 0) {
            setPartyCurrent(row);
            addPartyMenu addPartyMenu = new addPartyMenu(gPartyCurrent);
            addPartyMenu.setVisible(true);
        } else {
            printDialogErrorSelectParty();
        }
    }//GEN-LAST:event_selectDishBtnActionPerformed

    private void paymentBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_paymentBtnActionPerformed
        // TODO add your handling code here:

    }// GEN-LAST:event_paymentBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {
        addParty addParty = new addParty();
        addParty.setVisible(true);
    }

    private void happenNowActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_happenNowActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_happenNowActionPerformed

    private void happenDoneActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_happenDoneActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_happenDoneActionPerformed

    private void paymentNoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_paymentNoActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_paymentNoActionPerformed

    private void paymentYesActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_paymentYesActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_paymentYesActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_removeBtnActionPerformed
        int row = getIndexPartySelected();
        if (row >= 0) {
            PartyModel party = gListParty.get(row);
            int id = party.getID();
            if (PartyDAOImpl.getInstance().delete(id)) {
                JOptionPane.showMessageDialog(this, "Xóa tiệc có ID: " + id + " thành công", "Xóa tiệc", JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showMessageDialog(this, "Có lỗi khi xóa tiệc có ID: " + id, "Xóa tiệc", JOptionPane.ERROR_MESSAGE
                );

            }
        } else {
            printDialogErrorSelectParty();
        }
    }

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_editBtnActionPerformed
        int row = getIndexPartySelected();
        if (row >= 0) {
            // code
        } else {
            printDialogErrorSelectParty();
        }
    }

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_searchFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPaneTable;
    private rojeru_san.complementos.RSButtonHover addBtn;
    private javax.swing.JPanel button;
    private javax.swing.JPanel center;
    private javax.swing.JComboBox<String> comboBoxTypeParty;
    private javax.swing.JMenuItem editBtn;
    private javax.swing.JPanel filter;
    private javax.swing.JPanel happen;
    private javax.swing.JCheckBox happenDone;
    private javax.swing.JCheckBox happenNow;
    private javax.swing.JCheckBox happenWait;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private view.component.LabelGoogleIcon labelGoogleIcon1;
    private view.component.LabelGoogleIcon labelGoogleIcon2;
    private view.component.LabelGoogleIcon labelGoogleIcon3;
    private javax.swing.JPanel payment;
    private rojeru_san.complementos.RSButtonHover paymentBtn;
    private javax.swing.JCheckBox paymentNo;
    private javax.swing.JCheckBox paymentYes;
    private javax.swing.JPopupMenu popupMenu;
    private rojeru_san.complementos.RSButtonHover printMenuBtn;
    private javax.swing.JMenuItem removeBtn;
    private javax.swing.JPanel searchAndButton;
    private rojerusan.RSMetroTextPlaceHolder searchField;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JMenu seeBtn;
    private javax.swing.JMenuItem seeMenuBtn;
    private javax.swing.JMenuItem seePartyBtn;
    private javax.swing.JMenuItem selectDishBtn;
    private javax.swing.JLabel sumParty;
    private view.component.table.Table tableParty;
    private javax.swing.JPanel top;
    private javax.swing.JPanel typeParty;
    // End of variables declaration//GEN-END:variables
}
