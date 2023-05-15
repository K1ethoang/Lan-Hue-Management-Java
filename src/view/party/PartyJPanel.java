package view.party;

import dao.Party.PartyDAOImpl;
import dao.TypeParty.TypePartyDAOImpl;
import java.awt.PopupMenu;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JScrollBar;
import view.component.scroll.ScrollBarCus;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.HappenStatusModel;
import model.PartyModel;
import model.PaymentStatusModel;
import model.TypePartyModel;
import table.TableParty;
import utils.Helper;

public class PartyJPanel extends javax.swing.JPanel {
    
    List<PartyModel> gListParty = null;
    PartyModel gPartyCurrent = new PartyModel();
    
    private TableRowSorter<TableModel> rowSorter;
    
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
        
        setPartyTable();
        setComboBoxTypeParty();
    }
    
    void filterCheckBoxListHappenStatus(List<RowFilter<Object, Object>> filters, int happenStatusFilterIndex) {
        List<String> selectedStatuses = new ArrayList<>();
        if (happenWait.isSelected()) {
            selectedStatuses.add("Sắp tới");
        }
        if (happenNow.isSelected()) {
            selectedStatuses.add("Đang tổ chức");
        }
        if (happenDone.isSelected()) {
            selectedStatuses.add("Đã xong");
        }
        
        RowFilter<Object, Object> filter = RowFilter.orFilter(selectedStatuses.stream()
                .map(status -> RowFilter.regexFilter("(?i)" + status, happenStatusFilterIndex))
                .collect(Collectors.toList()));
        filters.add(filter);
//        sorter.setRowFilter(filter);
//        tableParty.setRowSorter(sorter);
    }
    
    void filterCheckBoxListPaymentStatus(List<RowFilter<Object, Object>> filters, int paymentStatusFilterIndex) {
        List<String> selectedStatuses = new ArrayList<>();
        if (paymentYes.isSelected()) {
            selectedStatuses.add("Xong");
        }
        if (paymentNo.isSelected()) {
            selectedStatuses.add("Chưa");
        }
        
        RowFilter<Object, Object> filter = RowFilter.orFilter(selectedStatuses.stream()
                .map(status -> RowFilter.regexFilter("(?i)" + status, paymentStatusFilterIndex))
                .collect(Collectors.toList()));
        
        System.out.println("filter happen: " + filter);
        filters.add(filter);
    }
    
    public void searchAndFilter() {
        String text = searchField.getText();
        String curTypeParty = (String) comboBoxTypeParty.getSelectedItem();
        
        int typePartyFilterIndex = 2;
        int happenStatusFilterIndex = 9;
        int paymentStatusFilterIndex = 10;
        
        List<RowFilter<Object, Object>> filters = new ArrayList<>();
        
        if (text.trim().length() == 0) {
            if (curTypeParty.equals("Tất cả")) {
                // nếu không có tk nào được chọn
                if (happenWait.isSelected() == false && happenNow.isSelected() == false && happenDone.isSelected() == false && paymentNo.isSelected() == false && paymentYes.isSelected() == false) {
                    rowSorter.setRowFilter(null);
                    return;
                } else { // nếu ít nhất 1 tk đc chọn 
                    if (paymentNo.isSelected() == false && paymentYes.isSelected() == false) { // nếu paymentstatus không có tk đc chọn
                        filterCheckBoxListHappenStatus(filters, happenStatusFilterIndex);
                        rowSorter.setRowFilter(RowFilter.andFilter(filters));
                        return;
                        
                    } else {
                        filterCheckBoxListHappenStatus(filters, happenStatusFilterIndex);
                        filterCheckBoxListPaymentStatus(filters, paymentStatusFilterIndex);
                    }
                    
                }
            } else {
                filters.add(RowFilter.regexFilter(curTypeParty, typePartyFilterIndex));
                // nếu không có tk nào đc chọn
                if (happenWait.isSelected() == false && happenNow.isSelected() == false && happenDone.isSelected() == false && paymentNo.isSelected() == false && paymentYes.isSelected() == false) {
                    rowSorter.setRowFilter(RowFilter.regexFilter(curTypeParty, typePartyFilterIndex));
                    return;
                } else { // có ít nhất 1 tk được chọn
                    if (paymentNo.isSelected() == false && paymentYes.isSelected() == false) { // nếu paymentstatus không có tk đc chọn
                        filterCheckBoxListHappenStatus(filters, happenStatusFilterIndex);
                        rowSorter.setRowFilter(RowFilter.andFilter(filters));
                        return;
                        
                    } else {
                        filterCheckBoxListHappenStatus(filters, happenStatusFilterIndex);
                        filterCheckBoxListPaymentStatus(filters, paymentStatusFilterIndex);
                    }
                }
            }
        } else {
            filters.add(RowFilter.regexFilter("(?i)" + text));
            if (curTypeParty.equals("Tất cả")) {
                if (happenWait.isSelected() == false && happenNow.isSelected() == false && happenDone.isSelected() == false && paymentNo.isSelected() == false && paymentYes.isSelected() == false) {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                    return;
                } else { // có ít nhất 1 tk được chọn
                    if (paymentNo.isSelected() == false && paymentYes.isSelected() == false) { // nếu paymentstatus không có tk đc chọn
                        filterCheckBoxListHappenStatus(filters, happenStatusFilterIndex);
                        rowSorter.setRowFilter(RowFilter.andFilter(filters));
                        return;
                        
                    } else {
                        filterCheckBoxListHappenStatus(filters, happenStatusFilterIndex);
                        filterCheckBoxListPaymentStatus(filters, paymentStatusFilterIndex);
                    }
                }
            } else {
                filters.add(RowFilter.regexFilter(curTypeParty, typePartyFilterIndex));
                if (happenWait.isSelected() == false && happenNow.isSelected() == false && happenDone.isSelected() == false && paymentNo.isSelected() == false && paymentYes.isSelected() == false) {
                    rowSorter.setRowFilter(RowFilter.andFilter(filters));
                    return;
                } else { // có ít nhất 1 tk được chọn
                    if (paymentNo.isSelected() == false && paymentYes.isSelected() == false) { // nếu paymentstatus không có tk đc chọn
                        filterCheckBoxListHappenStatus(filters, happenStatusFilterIndex);
                        rowSorter.setRowFilter(RowFilter.andFilter(filters));
                        return;
                    } else {
                        filterCheckBoxListHappenStatus(filters, happenStatusFilterIndex);
                        filterCheckBoxListPaymentStatus(filters, paymentStatusFilterIndex);
                    }
                }
            }
        }
        
        rowSorter.setRowFilter(RowFilter.andFilter(filters));
    }
    
    private void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tableParty.getModel();
        model.setRowCount(0);
    }
    
    private void setPartyTable() {
        gListParty = PartyDAOImpl.getInstance().getList();
        TableParty tb = new TableParty();
        tb.setPartyDetailsToTable(gListParty, tableParty);
        
        rowSorter = new TableRowSorter<>(tableParty.getModel());
        tableParty.setRowSorter(rowSorter);
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchAndFilter();
                sumParty.setText("Số lượng: " + rowSorter.getViewRowCount() + "");
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                searchAndFilter();
                sumParty.setText("Số lượng: " + rowSorter.getViewRowCount() + "");
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        });
        
        sumParty.setText("Số lượng: " + rowSorter.getViewRowCount() + "");
        
    }
    
    private void setComboBoxTypeParty() {
        comboBoxTypeParty.removeAllItems();
        List<TypePartyModel> list = TypePartyDAOImpl.getInstance().getList();
        comboBoxTypeParty.addItem("Tất cả");
        for (int i = 0; i < list.size(); i++) {
            comboBoxTypeParty.addItem(list.get(i).getName());
        }
    }
    
    private int getIndexPartySelected() {
        int row = tableParty.getSelectedRow();
        return row;
    }
    
    private void setCurrentParty() {
        int row = tableParty.getSelectedRow();
        gPartyCurrent = gListParty.get(row);
    }
    
    private void printDialogErrorSelectParty() {
        JOptionPane.showMessageDialog(this, "Tiệc không hợp lệ", "Thông báo", JOptionPane.ERROR_MESSAGE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        seeBtn = new javax.swing.JMenu();
        seePartyBtn = new javax.swing.JMenuItem();
        seeMenuBtn = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        editBtn = new javax.swing.JMenu();
        editPartyBtn = new javax.swing.JMenuItem();
        editMenuBtn = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        selectDishBtn = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        removeBtn = new javax.swing.JMenuItem();
        top = new javax.swing.JPanel();
        searchAndButton = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        searchField = new rojerusan.RSMetroTextPlaceHolder();
        button = new javax.swing.JPanel();
        addBtn = new rojeru_san.complementos.RSButtonHover();
        printBill = new rojeru_san.complementos.RSButtonHover();
        paymentBtn = new rojeru_san.complementos.RSButtonHover();
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

        popupMenu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                popupMenuPopupMenuWillBecomeVisible(evt);
            }
        });

        seeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/image/Search.png"))); // NOI18N
        seeBtn.setText("Xem");

        seePartyBtn.setText("Tiệc");
        seePartyBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        seePartyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seePartyBtnActionPerformed(evt);
            }
        });
        seeBtn.add(seePartyBtn);

        seeMenuBtn.setText("Món ăn");
        seeMenuBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        seeMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeMenuBtnActionPerformed(evt);
            }
        });
        seeBtn.add(seeMenuBtn);

        popupMenu.add(seeBtn);
        popupMenu.add(jSeparator4);

        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/image/Edit.png"))); // NOI18N
        editBtn.setText("Chỉnh sửa");

        editPartyBtn.setText("Tiệc");
        editPartyBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editPartyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPartyBtnActionPerformed(evt);
            }
        });
        editBtn.add(editPartyBtn);

        editMenuBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editMenuBtn.setText("Món ăn");
        editMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMenuBtnActionPerformed(evt);
            }
        });
        editBtn.add(editMenuBtn);

        popupMenu.add(editBtn);
        popupMenu.add(jSeparator2);

        selectDishBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        selectDishBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/image/Numbered list.png"))); // NOI18N
        selectDishBtn.setText("Chọn món ăn");
        selectDishBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectDishBtnActionPerformed(evt);
            }
        });
        popupMenu.add(selectDishBtn);
        popupMenu.add(jSeparator3);

        removeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/image/Delete.png"))); // NOI18N
        removeBtn.setText("Xóa");
        removeBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        searchField.setBorderColor(new java.awt.Color(10, 77, 104));
        searchField.setBotonColor(new java.awt.Color(0, 0, 0));
        searchField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchField.setForeground(new java.awt.Color(0, 0, 0));
        searchField.setPhColor(new java.awt.Color(10, 77, 104));
        searchField.setPlaceholder("Tìm kiếm");
        searchField.setToolTipText("Nhấn Enter để tìm");
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

        addBtn.setText("Thêm tiệc");
        addBtn.setBackground(new java.awt.Color(148, 175, 159));
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

        printBill.setText("Xem hóa đơn");
        printBill.setBackground(new java.awt.Color(10, 77, 104));
        printBill.setColorHover(new java.awt.Color(14, 112, 152));
        printBill.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        printBill.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        printBill.setPreferredSize(new java.awt.Dimension(130, 40));
        printBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBillActionPerformed(evt);
            }
        });
        button.add(printBill);

        paymentBtn.setText("Thanh toán");
        paymentBtn.setBackground(new java.awt.Color(10, 77, 104));
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

        happenWait.setText("Sắp tới");
        happenWait.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        happenWait.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        happenWait.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                happenWaitActionPerformed(evt);
            }
        });
        payment.add(happenWait);

        happenNow.setText("Đang tổ chức");
        happenNow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        happenNow.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        happenNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                happenNowActionPerformed(evt);
            }
        });
        payment.add(happenNow);

        happenDone.setText("Đã xong");
        happenDone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        happenDone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        paymentNo.setText("Chưa");
        paymentNo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paymentNo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        paymentNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentNoActionPerformed(evt);
            }
        });
        happen.add(paymentNo);

        paymentYes.setText("Xong");
        paymentYes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paymentYes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
        searchAndFilter();
        sumParty.setText("Số lượng: " + rowSorter.getViewRowCount() + "");
    }//GEN-LAST:event_comboBoxTypePartyActionPerformed

    private void seeMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeMenuBtnActionPerformed
        try {
            setCurrentParty();
            
            AddPartyMenuView.isPartyMenuEdit = false;
            
            AddPartyMenuView addPartyMenu = new AddPartyMenuView(gPartyCurrent);
            addPartyMenu.setVisible(true);
        } catch (Exception e) {
            printDialogErrorSelectParty();
            
        }
    }//GEN-LAST:event_seeMenuBtnActionPerformed

    private void seePartyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seePartyBtnActionPerformed
        try {
            setCurrentParty();
            
            AddPartyView.isPartyEdit = false;
            
            AddPartyView addPartyMenu = new AddPartyView(gPartyCurrent);
            addPartyMenu.setVisible(true);
        } catch (Exception e) {
            printDialogErrorSelectParty();
        }
    }//GEN-LAST:event_seePartyBtnActionPerformed

    private void selectDishBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectDishBtnActionPerformed
        try {
            setCurrentParty();
            
            AddPartyView addPartyMenu = new AddPartyView(gPartyCurrent);
            addPartyMenu.setVisible(true);
        } catch (Exception e) {
            printDialogErrorSelectParty();
        }
    }//GEN-LAST:event_selectDishBtnActionPerformed

    private void editMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuBtnActionPerformed
        try {
            setCurrentParty();
            
            AddPartyMenuView.isPartyMenuEdit = true;
            
            AddPartyMenuView addPartyMenu = new AddPartyMenuView(gPartyCurrent);
            addPartyMenu.setVisible(true);
        } catch (Exception e) {
            printDialogErrorSelectParty();
            
        }
    }//GEN-LAST:event_editMenuBtnActionPerformed

    private void editPartyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPartyBtnActionPerformed
        try {
            setCurrentParty();
            
            AddPartyView.isPartyEdit = true;
            
            AddPartyView addPartyMenu = new AddPartyView(gPartyCurrent);
            addPartyMenu.setVisible(true);
        } catch (Exception e) {
            printDialogErrorSelectParty();
        }
    }//GEN-LAST:event_editPartyBtnActionPerformed

    private void popupMenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_popupMenuPopupMenuWillBecomeVisible
        try {
            setCurrentParty();
            if (gPartyCurrent.getPaymentStatus().getStatusCode() == PaymentStatusModel.PAID) {
                editBtn.setEnabled(false);
            } else {
                editBtn.setEnabled(true);
                
            }
            
            if (gPartyCurrent.getHappenStatus().getStatusCode() == HappenStatusModel.GOING_ON || gPartyCurrent.getHappenStatus().getStatusCode() == HappenStatusModel.DONE) {
                selectDishBtn.setEnabled(false);
            } else {
                selectDishBtn.setEnabled(true);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_popupMenuPopupMenuWillBecomeVisible

    private void happenWaitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_happenWaitActionPerformed
        searchAndFilter();
        sumParty.setText("Số lượng: " + rowSorter.getViewRowCount() + "");
    }//GEN-LAST:event_happenWaitActionPerformed

    private void printBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_printBillActionPerformed
    
    private void happenNowActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_happenNowActionPerformed
        searchAndFilter();
        sumParty.setText("Số lượng: " + rowSorter.getViewRowCount() + "");
    }// GEN-LAST:event_happenNowActionPerformed

    private void happenDoneActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_happenDoneActionPerformed
        searchAndFilter();
        sumParty.setText("Số lượng: " + rowSorter.getViewRowCount() + "");
    }// GEN-LAST:event_happenDoneActionPerformed

    private void paymentBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_paymentBtnActionPerformed
        String ObjButtons[] = {"Thanh toán", "Hủy"};
        int PromptResult = JOptionPane.showOptionDialog(Helper.getWindow(this), "Xác nhận thanh toán?", "Quản lý tiệc Lan Huệ", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
        if (PromptResult == JOptionPane.YES_OPTION) {
//
        }
        
    }// GEN-LAST:event_paymentBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {
        AddPartyView addParty = new AddPartyView();
        addParty.setVisible(true);
    }
    
    private void paymentNoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_paymentNoActionPerformed
        searchAndFilter();
        sumParty.setText("Số lượng: " + rowSorter.getViewRowCount() + "");
    }// GEN-LAST:event_paymentNoActionPerformed

    private void paymentYesActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_paymentYesActionPerformed
        searchAndFilter();
        sumParty.setText("Số lượng: " + rowSorter.getViewRowCount() + "");
    }// GEN-LAST:event_paymentYesActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_removeBtnActionPerformed
        try {
            setCurrentParty();
            int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa hay không?", "Lựa chọn", JOptionPane.YES_NO_OPTION);
            if (a == 0) {
                if (PartyDAOImpl.getInstance().delete(gPartyCurrent.getID())) {
                    clearTable();
//                    rdoAll.setSelected(true);
                    setPartyTable();
                    JOptionPane.showMessageDialog(this, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa không thành công!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        } catch (Exception e) {
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
    private javax.swing.JMenu editBtn;
    private javax.swing.JMenuItem editMenuBtn;
    private javax.swing.JMenuItem editPartyBtn;
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
    private rojeru_san.complementos.RSButtonHover printBill;
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
