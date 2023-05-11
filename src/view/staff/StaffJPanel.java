package view.staff;

import dao.Role.RoleDAOImpl;
import dao.Staff.StaffDAOImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.RoleModel;
import model.StaffModel;
import table.TableStaff;
import view.component.scroll.ScrollBarCus;

public class StaffJPanel extends javax.swing.JPanel {

    List<StaffModel> listStaff = null;
    StaffModel staffCurrent = new StaffModel();

    private TableRowSorter<TableModel> rowSorter;

    public StaffJPanel() {
        List<StaffModel> listStaff = StaffDAOImpl.getInstance().getList();
        initComponents();
        // set vertical and horizontal scroll bar
        ScrollPaneTable.setVerticalScrollBar(new ScrollBarCus());
        ScrollBarCus sb = new ScrollBarCus();
        sb.setOrientation(JScrollBar.HORIZONTAL);
        ScrollPaneTable.setHorizontalScrollBar(sb);
        tableStaff.fixTable(ScrollPaneTable);
        
        setStaffTable();
        
        setComboBoxRole();
        
    }

    public void searchAndFilter() {
        String text = searchField.getText();
        String curRole = (String) comboBoxRole.getSelectedItem();

        int genderFilterIndex = 3;
        int roleFilterIndex = 6;
        List<RowFilter<Object, Object>> filters = new ArrayList<>();

        if (text.trim().length() == 0) {
            if (curRole.equals("Tất cả")) {
                if (rdoAll.isSelected()) {
                    rowSorter.setRowFilter(null);
                    return;
                } else if (rdoFemale.isSelected()) {
                    filters.add(RowFilter.regexFilter("Nữ", genderFilterIndex));
                } else if (rdoMale.isSelected()) {
                    filters.add(RowFilter.regexFilter("Nam", genderFilterIndex));
                }
            } else {
                filters.add(RowFilter.regexFilter(curRole, roleFilterIndex));
                if (rdoFemale.isSelected()) {
                    filters.add(RowFilter.regexFilter("Nữ", genderFilterIndex));
                } else if (rdoMale.isSelected()) {
                    filters.add(RowFilter.regexFilter("Nam", genderFilterIndex));
                }
            }
        } else {
            filters.add(RowFilter.regexFilter("(?i)" + text));
            if (curRole.equals("Tất cả")) {
                if (rdoMale.isSelected()) {
                    filters.add(RowFilter.regexFilter("Nam", genderFilterIndex));
                } else if (rdoFemale.isSelected()) {
                    filters.add(RowFilter.regexFilter("Nữ", genderFilterIndex));
                }
            } else {
                filters.add(RowFilter.regexFilter(curRole, roleFilterIndex));
                if (rdoMale.isSelected()) {
                    filters.add(RowFilter.regexFilter("Nam", genderFilterIndex));
                } else if (rdoFemale.isSelected()) {
                    filters.add(RowFilter.regexFilter("Nữ", genderFilterIndex));
                }
            }
        }

        rowSorter.setRowFilter(RowFilter.andFilter(filters));
    }


    public void setStaffTable() {
        listStaff = StaffDAOImpl.getInstance().getList();
        TableStaff tb = new TableStaff();
        tb.setStaffDetailsToTable(listStaff, tableStaff);

        rowSorter = new TableRowSorter<>(tableStaff.getModel());
        tableStaff.setRowSorter(rowSorter);

        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchAndFilter();
                setSumStaff();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchAndFilter();
                setSumStaff();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        setSumStaff();
    }

    private void setComboBoxRole() {
        comboBoxRole.removeAllItems();
        List<RoleModel> list = RoleDAOImpl.getInstance().getList();
        comboBoxRole.addItem("Tất cả");
        for (int i = 0; i < list.size(); i++) {
            comboBoxRole.addItem(list.get(i).getRoleName());
        }
    }

    private void setSumStaff() {
        sumStaff.setText("Số lượng: " + tableStaff.getRowCount() + "");
    }

    private void setStaffCurrent() {
        int row = tableStaff.getSelectedRow();
        staffCurrent = listStaff.get(row);
    }

    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tableStaff.getModel();
        model.setRowCount(0);
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
        sexGroup = new javax.swing.ButtonGroup();
        top = new javax.swing.JPanel();
        searchAndButton = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        searchField = new rojerusan.RSMetroTextPlaceHolder();
        button = new javax.swing.JPanel();
        addBtn = new rojeru_san.complementos.RSButtonHover();
        sumStaff = new javax.swing.JLabel();
        filter = new javax.swing.JPanel();
        position = new javax.swing.JPanel();
        labelGoogleIcon3 = new view.component.LabelGoogleIcon();
        comboBoxRole = new javax.swing.JComboBox<>();
        happen = new javax.swing.JPanel();
        labelGoogleIcon2 = new view.component.LabelGoogleIcon();
        rdoAll = new javax.swing.JRadioButton();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        center = new javax.swing.JPanel();
        ScrollPaneTable = new javax.swing.JScrollPane();
        tableStaff = new view.component.table.Table();

        seeBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        seeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/image/Search.png"))); // NOI18N
        seeBtn.setText("Xem chi tiết");
        seeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeBtnActionPerformed(evt);
            }
        });
        popupMenu.add(seeBtn);
        popupMenu.add(jSeparator2);

        editBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/image/Edit.png"))); // NOI18N
        editBtn.setText("Chỉnh sửa");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });
        popupMenu.add(editBtn);
        popupMenu.add(jSeparator3);

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
        addBtn.setText("Thêm nhân viên");
        addBtn.setColorHover(new java.awt.Color(187, 214, 184));
        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addBtn.setPreferredSize(new java.awt.Dimension(140, 40));
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

        position.setBackground(getBackground());

        labelGoogleIcon3.setText("Vị trí:");
        labelGoogleIcon3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        position.add(labelGoogleIcon3);

        comboBoxRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxRoleActionPerformed(evt);
            }
        });
        position.add(comboBoxRole);

        filter.add(position);

        happen.setBackground(getBackground());

        labelGoogleIcon2.setText("Giới tính:");
        labelGoogleIcon2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        happen.add(labelGoogleIcon2);

        sexGroup.add(rdoAll);
        rdoAll.setSelected(true);
        rdoAll.setText("Tất cả");
        rdoAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoAllActionPerformed(evt);
            }
        });
        happen.add(rdoAll);

        sexGroup.add(rdoMale);
        rdoMale.setText("Nam");
        rdoMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMaleActionPerformed(evt);
            }
        });
        happen.add(rdoMale);

        sexGroup.add(rdoFemale);
        rdoFemale.setText("Nữ");
        rdoFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoFemaleActionPerformed(evt);
            }
        });
        happen.add(rdoFemale);

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
                .addComponent(ScrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(center, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        AddStaffView addStaff = new AddStaffView();
        addStaff.setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed

    // xử lí sự kiện xem staff
    private void seeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeBtnActionPerformed
        try {
            setStaffCurrent();

            AddStaffView.isEditStaff = false;

            AddStaffView addStaff = new AddStaffView(staffCurrent);
            addStaff.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nhân viên không hợp lệ", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_seeBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        try {
            setStaffCurrent();

            AddStaffView.isEditStaff = true;

            AddStaffView addStaff = new AddStaffView(staffCurrent);
            addStaff.setVisible(true);
//            clearTable();
//            setCustomerTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nhân viên không hợp lệ", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        try {
            setStaffCurrent();
            int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa hay không?", "Lựa chọn", JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.OK_OPTION) {
                if (StaffDAOImpl.getInstance().delete(staffCurrent.getID())) {
                    clearTable();
                    comboBoxRole.setSelectedItem("Tất cả");
                    rdoAll.setSelected(true);
                    setStaffTable();

                    JOptionPane.showMessageDialog(this, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(this, "Xóa không thành công!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nhân viên không hợp lệ", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_removeBtnActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void comboBoxRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxRoleActionPerformed
        searchAndFilter();
        setSumStaff();
    }//GEN-LAST:event_comboBoxRoleActionPerformed

    private void rdoAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoAllActionPerformed
        searchAndFilter();
        setSumStaff();
    }//GEN-LAST:event_rdoAllActionPerformed

    private void rdoMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMaleActionPerformed
        searchAndFilter();
        setSumStaff();
    }//GEN-LAST:event_rdoMaleActionPerformed

    private void rdoFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoFemaleActionPerformed
        searchAndFilter();
        setSumStaff();
    }//GEN-LAST:event_rdoFemaleActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPaneTable;
    private rojeru_san.complementos.RSButtonHover addBtn;
    private javax.swing.JPanel button;
    private javax.swing.JPanel center;
    private javax.swing.JComboBox<String> comboBoxRole;
    private javax.swing.JMenuItem editBtn;
    private javax.swing.JPanel filter;
    private javax.swing.JPanel happen;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private view.component.LabelGoogleIcon labelGoogleIcon2;
    private view.component.LabelGoogleIcon labelGoogleIcon3;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JPanel position;
    private javax.swing.JRadioButton rdoAll;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JMenuItem removeBtn;
    private javax.swing.JPanel searchAndButton;
    private rojerusan.RSMetroTextPlaceHolder searchField;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JMenuItem seeBtn;
    private javax.swing.ButtonGroup sexGroup;
    private javax.swing.JLabel sumStaff;
    private view.component.table.Table tableStaff;
    private javax.swing.JPanel top;
    // End of variables declaration//GEN-END:variables
}
