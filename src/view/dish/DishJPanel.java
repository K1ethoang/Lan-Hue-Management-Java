package view.dish;

import dao.Dish.DishDAOImpl;
import dao.TypeDish.TypeDishDAOImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;

import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.table.DefaultTableModel;
import model.DishModel;
import model.TypeDishModel;
import table.TableDish;
import view.component.scroll.ScrollBarCus;

public class DishJPanel extends javax.swing.JPanel {
    
    List<TypeDishModel> gListTypeDish = TypeDishDAOImpl.getInstance().getList();
    List<DishModel> listDish = null;
    DishModel dishCurrent = new DishModel();
    
    private TableRowSorter<TableModel> rowSorter;

    public DishJPanel() {
        List<DishModel> listDish = DishDAOImpl.getInstance().getList();
        initComponents();
        // set vertical and horizontal scroll bar
        ScrollPaneTable.setVerticalScrollBar(new ScrollBarCus());
        ScrollBarCus sb = new ScrollBarCus();
        sb.setOrientation(JScrollBar.HORIZONTAL);
        ScrollPaneTable.setHorizontalScrollBar(sb);
        tableDish.fixTable(ScrollPaneTable);

        // set data
        setDishTable();
        setComboBoxTypeDish();
    }
    
    public void searchAndFilter() {
        String curTypeDish = (String) CB_typeDish.getSelectedItem();
        String text = searchField.getText();
        if (text.trim().length() == 0) {
            if (curTypeDish.equals("Tất cả")) {
                rowSorter.setRowFilter(null); // bộ lọc đặt lại để hiển thị tất cả các hàng trong bảng
            } else {
                if (rowSorter == null) {
                    rowSorter = new TableRowSorter<>(tableDish.getModel());
                    tableDish.setRowSorter(rowSorter);
                }
                rowSorter.setRowFilter(RowFilter.regexFilter(curTypeDish, 3));
            }
        } else {
            if (curTypeDish.equals("Tất cả")) { // nếu chọn vào tất cả => thì hiển thị hàng có giá trị trong bảng chứa từ khóa tìm kiếm
                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
            } else { // nếu chọn vào các loại món ăn -> hiển thị hàng có giá trị là các loại món ăn và chứa từ khóa search text
                List<RowFilter<Object, Object>> filters = new ArrayList<>();
                filters.add(RowFilter.regexFilter("(?i)" + text));
                filters.add(RowFilter.regexFilter(curTypeDish, 3));
                rowSorter.setRowFilter(RowFilter.andFilter(filters));
            }
        }
    }
    
    public void setDishTable() {
        // load data into the table
        listDish = DishDAOImpl.getInstance().getList();
        TableDish tb = new TableDish();
        tb.setDishDetailsToTable(listDish, tableDish);

        // set up the row sorter
        rowSorter = new TableRowSorter<>(tableDish.getModel());
        tableDish.setRowSorter(rowSorter);
        
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchAndFilter();
                setSumDish();
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                searchAndFilter();
                setSumDish();
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                // not used
            }
        });
        
        setSumDish();
    }
    
    private void setSumDish() {
        // cập nhật lại số lượng
        sumDish.setText("Số lượng: " + rowSorter.getViewRowCount() + "");
    }
    
    private void setDishCurrent() {
        listDish = DishDAOImpl.getInstance().getList();
        int viewRowIndex = tableDish.getSelectedRow();
        int row = tableDish.getRowSorter().convertRowIndexToModel(viewRowIndex);
        DishModel dish = listDish.get(row);
        
        dishCurrent.setDishID(dish.getDishID());
        dishCurrent.setDishName(dish.getDishName());
        dishCurrent.setPrice(dish.getPrice());
        dishCurrent.setTypeDish(dish.getTypeDish());
    }
    
    private void setComboBoxTypeDish() {
        CB_typeDish.removeAllItems();
        CB_typeDish.addItem("Tất cả");
        for (int i = 0; i < gListTypeDish.size(); i++) {
            CB_typeDish.addItem(gListTypeDish.get(i).getTypeName());
        }
    }
    
    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tableDish.getModel();
        model.setRowCount(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        editBtn = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        removeBtn = new javax.swing.JMenuItem();
        top = new javax.swing.JPanel();
        searchAndButton = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        searchField = new rojerusan.RSMetroTextPlaceHolder();
        button = new javax.swing.JPanel();
        addBtn = new rojeru_san.complementos.RSButtonHover();
        sumDish = new javax.swing.JLabel();
        filter = new javax.swing.JPanel();
        happen = new javax.swing.JPanel();
        labelGoogleIcon2 = new view.component.LabelGoogleIcon();
        CB_typeDish = new javax.swing.JComboBox<>();
        center = new javax.swing.JPanel();
        ScrollPaneTable = new javax.swing.JScrollPane();
        tableDish = new view.component.table.Table();

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
        addBtn.setText("Thêm món");
        addBtn.setColorHover(new java.awt.Color(187, 214, 184));
        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addBtn.setPreferredSize(new java.awt.Dimension(120, 40));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        button.add(addBtn);

        sumDish.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sumDish.setText("Số lượng: 0");
        button.add(sumDish);

        searchAndButton.add(button);

        top.add(searchAndButton);

        filter.setBackground(getBackground());
        filter.setLayout(new javax.swing.BoxLayout(filter, javax.swing.BoxLayout.Y_AXIS));

        happen.setBackground(getBackground());

        labelGoogleIcon2.setText("Loại món ăn");
        labelGoogleIcon2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        happen.add(labelGoogleIcon2);

        CB_typeDish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_typeDishActionPerformed(evt);
            }
        });
        happen.add(CB_typeDish);

        filter.add(happen);

        top.add(filter);

        add(top, java.awt.BorderLayout.NORTH);

        center.setBackground(getBackground());

        tableDish.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên món", "Giá (Đồng)", "Loại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDish.setComponentPopupMenu(popupMenu);
        tableDish.setShowGrid(true);
        tableDish.getTableHeader().setReorderingAllowed(false);
        ScrollPaneTable.setViewportView(tableDish);

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
                .addComponent(ScrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(center, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        AddDishView addDish = new AddDishView();
        addDish.setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed

    private void CB_typeDishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_typeDishActionPerformed
        searchAndFilter();
        setSumDish();
        

    }//GEN-LAST:event_CB_typeDishActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        try {
            setDishCurrent();
            
            AddDishView.isEditDish = true;
            
            AddDishView addDish = new AddDishView(dishCurrent);
            addDish.setVisible(true);
//            clearTable();
//            setCustomerTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Món ăn không hợp lệ", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        try {
            setDishCurrent();
            int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa hay không ?", "Lựa chọn", JOptionPane.YES_NO_OPTION);
            if (a == 0) {
                if (DishDAOImpl.getInstance().delete(dishCurrent.getDishID())) {
                    clearTable();
                    CB_typeDish.setSelectedItem("Tất cả");
                    setDishTable();
//                    searchAndFilter();
                    
                    JOptionPane.showMessageDialog(this, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa không thành công!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Món ăn không hợp lệ", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_removeBtnActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
//        System.out.println("aaaaa");
//        setDishTable();
    }//GEN-LAST:event_searchFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_typeDish;
    private javax.swing.JScrollPane ScrollPaneTable;
    private rojeru_san.complementos.RSButtonHover addBtn;
    private javax.swing.JPanel button;
    private javax.swing.JPanel center;
    private javax.swing.JMenuItem editBtn;
    private javax.swing.JPanel filter;
    private javax.swing.JPanel happen;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private view.component.LabelGoogleIcon labelGoogleIcon2;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JMenuItem removeBtn;
    private javax.swing.JPanel searchAndButton;
    private rojerusan.RSMetroTextPlaceHolder searchField;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JLabel sumDish;
    private view.component.table.Table tableDish;
    private javax.swing.JPanel top;
    // End of variables declaration//GEN-END:variables
}
