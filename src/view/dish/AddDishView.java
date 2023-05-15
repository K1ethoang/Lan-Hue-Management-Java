package view.dish;

import dao.Dish.DishDAOImpl;
import dao.TypeDish.TypeDishDAOImpl;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import model.DishModel;
import model.TypeDishModel;
import utils.Helper;

/**
 *
 * @author kieth
 */
public class AddDishView extends JFrame {

    public static boolean isEditDish = false;
//    int curID;

    List<TypeDishModel> gListTypeDish = TypeDishDAOImpl.getInstance().getList();
    TypeDishModel gTypeDishModel = null;

    public AddDishView() {
        initComponents();
        Helper.setIconImage4JFrame(this);

        initTextFieldPrice(isEditDish);

        gListTypeDish = TypeDishDAOImpl.getInstance().getList();
        TF_dishID.setEditable(false);
        // set data
        setComboBoxTypeDish();

        Helper.setQuestionBeforeClose(this);
    }

    public AddDishView(DishModel _dishModel) {
        initComponents();
        Helper.setIconImage4JFrame(this);

        initTextFieldPrice(isEditDish);

        setComboBoxTypeDish();
        // set data
        setDataSeeDish(_dishModel, isEditDish);

        Helper.setQuestionBeforeClose(this);
    }

    private void initTextFieldPrice(boolean isEditDish) {
        Locale vn = new Locale("vi", "VN");
        NumberFormat dongFormat = NumberFormat.getNumberInstance(vn);

        FTF_price.setFormatterFactory(new DefaultFormatterFactory(
                new NumberFormatter(dongFormat)));
        if (isEditDish == false) {
            FTF_price.setValue(50000);
        }

    }

    public String getName() {
        String name = TF_nameDish.getText().trim();
        if (name.isEmpty()) {
            return null;
        }
        return name;
    }

    private boolean insertDish() {
        DishModel dish = new DishModel();
        dish.setDishName(getName());

        dish.setPrice(Double.parseDouble(getDishPrice()));

        for (int i = 0; i < gListTypeDish.size(); i++) {
            if (CB_typeDish.getSelectedIndex() == i) {
                dish.setTypeDish(gListTypeDish.get(i));
                break;
            }
        }
        return DishDAOImpl.getInstance().insert(dish);
    }

    private boolean updateDish() {
        DishModel dish = new DishModel();
        dish.setDishID(Integer.parseInt(TF_dishID.getText()));
        dish.setDishName(getName());
        dish.setPrice(Double.parseDouble(getDishPrice()));
        for (int i = 0; i < gListTypeDish.size(); i++) {
            if (CB_typeDish.getSelectedIndex() == i) {
                dish.setTypeDish(gListTypeDish.get(i));
                break;
            }
        }
        return DishDAOImpl.getInstance().update(dish);
    }

    private void setDataSeeDish(DishModel dish, boolean isEditDish) {
        this.setTitle("Chỉnh sửa thông tin món ăn");
        TF_dishID.setText(dish.getDishID() + "");
        TF_nameDish.setText(dish.getDishName());
        FTF_price.setValue(dish.getPrice());
        CB_typeDish.setSelectedItem(dish.getTypeDish().getTypeName());
        setFieldEnable(isEditDish);
    }

    private void setFieldEnable(boolean bool) {
//        TF_dishID.setEditable(false);
        TF_nameDish.setEditable(bool);
        CB_typeDish.setEditable(bool);
        FTF_price.setEditable(bool);
    }

    private void setComboBoxTypeDish() {
        CB_typeDish.removeAllItems();
        for (int i = 0; i < gListTypeDish.size(); i++) {
            CB_typeDish.addItem(gListTypeDish.get(i).getTypeName());
        }
    }

    private String getDishPrice() {
        return Helper.replaceInString(FTF_price.getText(), ".", "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panelCustomer = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        TF_dishID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TF_nameDish = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        FTF_price = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        CB_typeDish = new javax.swing.JComboBox<>();
        bottom = new javax.swing.JPanel();
        saveBtn = new rojeru_san.complementos.RSButtonHover();
        cancelBtn = new rojeru_san.complementos.RSButtonHover();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Thêm món ăn");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        panelCustomer.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panelCustomer.setLayout(new java.awt.GridLayout(4, 2, 0, 10));

        jLabel6.setText("ID (*)");
        panelCustomer.add(jLabel6);

        TF_dishID.setEditable(false);
        TF_dishID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_dishIDActionPerformed(evt);
            }
        });
        panelCustomer.add(TF_dishID);

        jLabel5.setText("Tên món ăn (*)");
        panelCustomer.add(jLabel5);
        panelCustomer.add(TF_nameDish);

        jLabel7.setText("Giá (Đồng) (*)");
        panelCustomer.add(jLabel7);

        FTF_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FTF_priceActionPerformed(evt);
            }
        });
        panelCustomer.add(FTF_price);

        jLabel8.setText("Loại món ăn (*)");
        panelCustomer.add(jLabel8);

        panelCustomer.add(CB_typeDish);

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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TF_dishIDActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_TF_dishIDActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_TF_dishIDActionPerformed

    private void FTF_priceActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_FTF_priceActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_FTF_priceActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_savePartyBtnActionPerformed
        boolean isEditOk = false, isInsertOk = false;

        if (isEditDish) {
            isEditOk = updateDish();
        } else {
            isInsertOk = insertDish();
        }

        if (isInsertOk) {
            JOptionPane.showMessageDialog(this, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else if (isEditOk) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng kiểm tra lại thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }// GEN-LAST:event_savePartyBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelBtnActionPerformed
        String ObjButtons[] = {"Thoát", "Hủy"};
        int PromptResult = JOptionPane.showOptionDialog(this, "Bạn thực sự muốn thoát?", "Quản lý tiệc Lan Huệ", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
        if (PromptResult == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }// GEN-LAST:event_cancelBtnActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddDishView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null,
                            ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDishView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null,
                            ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDishView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null,
                            ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDishView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null,
                            ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
        //            public void run() {
        //                new AddDishView().setVisible(true);
        //            }
        //        });
        //    }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_typeDish;
    private javax.swing.JFormattedTextField FTF_price;
    private javax.swing.JTextField TF_dishID;
    private javax.swing.JTextField TF_nameDish;
    private javax.swing.JPanel bottom;
    private rojeru_san.complementos.RSButtonHover cancelBtn;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelCustomer;
    private rojeru_san.complementos.RSButtonHover saveBtn;
    // End of variables declaration//GEN-END:variables
}
