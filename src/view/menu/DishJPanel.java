package view.menu;

import dao.Dish.DishDAOImpl;
import dao.TypeDish.TypeDishDAOImpl;
import java.util.List;
import javax.swing.JScrollBar;
import model.DishModel;
import model.TypeDishModel;
import table.TableDish;
import view.component.scroll.ScrollBarCus;

public class DishJPanel extends javax.swing.JPanel {

    List<DishModel> listDish = DishDAOImpl.getInstance().getList();
    DishModel dishCurrent = new DishModel();
    List<TypeDishModel> gListTypeDish = TypeDishDAOImpl.getInstance().getList();

    public DishJPanel() {
        initComponents();
        // set vertical and horizontal scroll bar
        ScrollPaneTable.setVerticalScrollBar(new ScrollBarCus());
        ScrollBarCus sb = new ScrollBarCus();
        sb.setOrientation(JScrollBar.HORIZONTAL);
        ScrollPaneTable.setHorizontalScrollBar(sb);
        tableDish.fixTable(ScrollPaneTable);

        // set data
        setComboBoxTypeDish();
        setDishTable();
    }

    public void setDishTable() {
        System.out.println(listDish);
        TableDish tb = new TableDish();
        tb.setDishDetailsToTable(listDish, tableDish);
        sumDish.setText("Số lượng: " + listDish.size());
    }

    private void setComboBoxTypeDish() {
        CB_typeDish.removeAllItems();
        for (int i = 0; i < gListTypeDish.size(); i++) {
            CB_typeDish.addItem(gListTypeDish.get(i).getTypeName());
        }
    }

    private void setDishCurrent() {
        int row = tableDish.getSelectedRow();
        DishModel dish = listDish.get(row);

        dishCurrent.setDishID(dish.getDishID());
        dishCurrent.setDishName(dish.getDishName());
        dishCurrent.setPrice(dish.getPrice());
        dishCurrent.setTypeDish(dish.getTypeDish());
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
        paymentBtn1 = new rojeru_san.complementos.RSButtonHover();
        sumDish = new javax.swing.JLabel();
        filter = new javax.swing.JPanel();
        happen = new javax.swing.JPanel();
        labelGoogleIcon2 = new view.component.LabelGoogleIcon();
        CB_typeDish = new javax.swing.JComboBox<>();
        center = new javax.swing.JPanel();
        ScrollPaneTable = new javax.swing.JScrollPane();
        tableDish = new view.component.table.Table();

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
        addBtn.setText("Thêm món");
        addBtn.setToolTipText("Ctrl+N");
        addBtn.setColorHover(new java.awt.Color(187, 214, 184));
        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addBtn.setPreferredSize(new java.awt.Dimension(120, 40));
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
                "ID", "Tên món", "Giá", "Loại"
            }
        ));
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
//        addDish addStaff = new addDish();
//        addStaff.setVisible(true);
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

    private void CB_typeDishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_typeDishActionPerformed
        String curTypeDish = (String) CB_typeDish.getSelectedItem();
        System.out.println(curTypeDish);
    }//GEN-LAST:event_CB_typeDishActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_typeDish;
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
    private rojeru_san.complementos.RSButtonHover paymentBtn1;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JMenuItem removeBtn;
    private javax.swing.JPanel searchAndButton;
    private rojerusan.RSMetroTextPlaceHolder searchField;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JMenuItem seeBtn;
    private javax.swing.JLabel sumDish;
    private view.component.table.Table tableDish;
    private javax.swing.JPanel top;
    // End of variables declaration//GEN-END:variables
}
