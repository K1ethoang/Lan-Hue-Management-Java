package view.menu;

import dao.Dish.DishDAOImpl;
import dao.TypeDish.TypeDishDAOImpl;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import model.DishModel;
import model.TypeDishModel;

/**
 *
 * @author kieth
 */
public class addDish extends javax.swing.JFrame {

    List<TypeDishModel> gListTypeDish = null;
    DishModel gCurrentDish = null;

    public addDish() {
        initComponents();

        initTextFieldPrice();

        // set data
        setTextFieldID();
        setComboBoxTypeDish();
    }

    public addDish(DishModel _dishModel) {
        initComponents();

        initTextFieldPrice();

        // set data
        setDataSeeDish(_dishModel);

        // set button
        savePartyBtn.setVisible(false);
    }

    private void initTextFieldPrice() {
        Locale vn = new Locale("vi", "VN");
        NumberFormat dongFormat = NumberFormat.getNumberInstance(vn);

        FTF_price.setFormatterFactory(new DefaultFormatterFactory(
                new NumberFormatter(dongFormat)));
        FTF_price.setValue(50000);
    }

    private void setTextFieldID() {
        TF_dishID.setText(DishDAOImpl.getInstance().getNextID() + "");
    }

    private void setDataSeeDish(DishModel dish) {
        this.setTitle("Xem món ăn");
        TF_dishID.setText(dish.getDishID() + "");
        TF_nameDish.setText(dish.getDishName());
        setFieldEnable(false);
    }

    private void setComboBoxTypeDish() {
        gListTypeDish = TypeDishDAOImpl.getInstance().getList();
        CB_typeDish.removeAllItems();
        for (int i = 0; i < gListTypeDish.size(); i++) {
            CB_typeDish.addItem(gListTypeDish.get(i).getTypeName());
        }
    }

    private void setFieldEnable(boolean bool) {

    }

    @SuppressWarnings("unchecked")
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
        savePartyBtn = new rojeru_san.complementos.RSButtonHover();
        cancelBtn = new rojeru_san.complementos.RSButtonHover();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm món ăn");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        panelCustomer.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panelCustomer.setLayout(new java.awt.GridLayout(4, 2, 0, 10));

        jLabel6.setText("ID (*)");
        panelCustomer.add(jLabel6);

        TF_dishID.setEditable(false);
        panelCustomer.add(TF_dishID);

        jLabel5.setText("Tên món ăn (*)");
        panelCustomer.add(jLabel5);
        panelCustomer.add(TF_nameDish);

        jLabel7.setText("Giá (Đồng) (*)");
        panelCustomer.add(jLabel7);
        panelCustomer.add(FTF_price);

        jLabel8.setText("Loại món ăn (*)");
        panelCustomer.add(jLabel8);

        panelCustomer.add(CB_typeDish);

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

    private void savePartyBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_savePartyBtnActionPerformed

    }// GEN-LAST:event_savePartyBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
    }// GEN-LAST:event_cancelBtnActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(addDish.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addDish.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addDish.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addDish.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addDish().setVisible(true);
            }
        });
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
    private rojeru_san.complementos.RSButtonHover savePartyBtn;
    // End of variables declaration//GEN-END:variables
}
