package view.component;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author kieth
 */
public class PanelLocation extends javax.swing.JPanel {

    public PanelLocation() {
        initComponents();
        AutoCompleteDecorator.decorate(comboBoxDistrict);
        AutoCompleteDecorator.decorate(comboBoxWard);
        setFullAddress();
    }

    public void setEnable(boolean bool) {
        comboBoxDistrict.setEnabled(bool);
        comboBoxWard.setEnabled(bool);
        textFieldAddress.setEditable(bool);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        comboBoxProvince = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        comboBoxDistrict = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        comboBoxWard = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        textFieldAddress = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        LB_location = new javax.swing.JLabel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setLayout(new java.awt.GridLayout(4, 2, 0, 10));

        jLabel8.setText("Tỉnh/Thành phố (*)");
        jPanel3.add(jLabel8);

        comboBoxProvince.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tỉnh Đồng Nai" }));
        jPanel3.add(comboBoxProvince);

        jLabel9.setText("Quận/Huyện (*)");
        jPanel3.add(jLabel9);

        comboBoxDistrict.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thành phố Biên Hòa", "Thành phố Long Khánh", "Huyện Tân Phú", "Huyện Vĩnh Cửu", "Huyện Định Quán", "Huyện Trảng Bom", "Huyện Thống Nhất", "Huyện Cẩm Mỹ", "Huyện Long Thành", "Huyện Xuân Lộc", "Huyện Nhơn Trạch" }));
        comboBoxDistrict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxDistrictActionPerformed(evt);
            }
        });
        jPanel3.add(comboBoxDistrict);

        jLabel10.setText("Phường/Xã (*)");
        jPanel3.add(jLabel10);

        comboBoxWard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxWardActionPerformed(evt);
            }
        });
        jPanel3.add(comboBoxWard);

        jLabel11.setText("Số nhà (*)");
        jPanel3.add(jLabel11);

        textFieldAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldAddressKeyTyped(evt);
            }
        });
        jPanel3.add(textFieldAddress);

        add(jPanel3);

        LB_location.setText("Địa chỉ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(LB_location, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(26, Short.MAX_VALUE)
                    .addComponent(LB_location)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    public void setProvince(String s) {
        comboBoxProvince.removeAllItems();
        comboBoxProvince.addItem(s);

    }

    public void setDistrict(String s) {
        comboBoxDistrict.removeAllItems();
        comboBoxDistrict.addItem(s);

    }

    public void setWard(String s) {
        comboBoxWard.removeAllItems();
        comboBoxWard.addItem(s);

    }

    public void setAddress(String s) {
        textFieldAddress.setText(s);
    }

    public void setFullAddress() {
        LB_location.setText(getAddress() + ", " + getWard() + ", " + getDistrict() + ", " + getProvince());
    }

    public String getProvince() {
        return (String) comboBoxProvince.getSelectedItem();
    }

    public String getDistrict() {
        return (String) comboBoxDistrict.getSelectedItem();
    }

    public String getWard() {
        return (String) comboBoxWard.getSelectedItem();
    }

    public String getAddress() {
        return (String) textFieldAddress.getText();
    }

    public String getFullAddress() {
        return (String) LB_location.getText();
    }


    private void comboBoxDistrictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxDistrictActionPerformed
        String district = (String) comboBoxDistrict.getSelectedItem();
        setFullAddress();

        if (district.equals("Thành phố Biên Hòa")) {
            comboBoxWard.removeAllItems();
            comboBoxWard.addItem("Phường Trảng Dài");
            comboBoxWard.addItem("Phường Tân Phong");
            comboBoxWard.addItem("Phường Tân Biên");
            comboBoxWard.addItem("Phường Hố Nai");
            comboBoxWard.addItem("Phường Tân Hòa");
            comboBoxWard.addItem("Phường Tân Hiệp");
            comboBoxWard.addItem("Phường Bửu Long");
            comboBoxWard.addItem("Phường Tân Tiến");
            comboBoxWard.addItem("Phường Tam Hiệp");
            comboBoxWard.addItem("Phường Long Bình");
            comboBoxWard.addItem("Phường Quang Vinh");
            comboBoxWard.addItem("Phường Tân Mai");
            comboBoxWard.addItem("Phường Thống Nhất");
            comboBoxWard.addItem("Phường Trung Dũng");
            comboBoxWard.addItem("Phường Tam Hòa");
            comboBoxWard.addItem("Phường Hòa Bình");
            comboBoxWard.addItem("Phường Quyết Thắng");
            comboBoxWard.addItem("Phường Thanh Bình");
            comboBoxWard.addItem("Phường Bình Đa");
            comboBoxWard.addItem("Phường An Bình");
            comboBoxWard.addItem("Phường Bửu Hòa");
            comboBoxWard.addItem("Phường Long Bình Tân");
            comboBoxWard.addItem("Phường Tân Vạn");
            comboBoxWard.addItem("Phường Tân Hạnh");
            comboBoxWard.addItem("Phường Hiệp Hòa");
            comboBoxWard.addItem("Phường Hóa An");
            comboBoxWard.addItem("Phường An Hòa");
            comboBoxWard.addItem("Phường Tam Phước");
            comboBoxWard.addItem("Phường Phước Tân");
            comboBoxWard.addItem("Xã Long Hưng");
        } else if (district.equals("Thành phố Long Khánh")) {
            comboBoxWard.removeAllItems();
            comboBoxWard.addItem("Phường Xuân Trung");
            comboBoxWard.addItem("Phường Xuân Thanh");
            comboBoxWard.addItem("Phường Xuân Bình");
            comboBoxWard.addItem("Phường Xuân An");
            comboBoxWard.addItem("Phường Xuân Hoà");
            comboBoxWard.addItem("Phường Phú Bình");
            comboBoxWard.addItem("Xã Bình Lộc");
            comboBoxWard.addItem("Xã Bảo Quang");
            comboBoxWard.addItem("Phường Suối Tre");
            comboBoxWard.addItem("Phường Bảo Vinh");
            comboBoxWard.addItem("Phường Xuân Lập");
            comboBoxWard.addItem("Phường Bàu Sen");
            comboBoxWard.addItem("Xã Bàu Trâm");
            comboBoxWard.addItem("Phường Xuân Tân");
            comboBoxWard.addItem("Xã Hàng Gòn");

        } else if (district.equals("Huyện Tân Phú")) {
            comboBoxWard.removeAllItems();
            comboBoxWard.addItem("Thị trấn Tân Phú");
            comboBoxWard.addItem("Xã Dak Lua");
            comboBoxWard.addItem("Xã Nam Cát Tiên");
            comboBoxWard.addItem("Xã Phú An");
            comboBoxWard.addItem("Xã Núi Tượng");
            comboBoxWard.addItem("Xã Tà Lài");
            comboBoxWard.addItem("Xã Phú Lập");
            comboBoxWard.addItem("Xã Phú Sơn");
            comboBoxWard.addItem("Xã Phú Thịnh");
            comboBoxWard.addItem("Xã Thanh Sơn");
            comboBoxWard.addItem("Xã Phú Trung");
            comboBoxWard.addItem("Xã Phú Xuân");
            comboBoxWard.addItem("Xã Phú Lộc");
            comboBoxWard.addItem("Xã Phú Lâm");
            comboBoxWard.addItem("Xã Phú Bình");
            comboBoxWard.addItem("Xã Phú Thanh");
            comboBoxWard.addItem("Xã Trà Cổ");
            comboBoxWard.addItem("Xã Phú Điền");

        } else if (district.equals("Huyện Vĩnh Cửu")) {
            comboBoxWard.removeAllItems();
            comboBoxWard.addItem("Thị trấn Vĩnh An");
            comboBoxWard.addItem("Xã Phú Lý");
            comboBoxWard.addItem("Xã Trị An");
            comboBoxWard.addItem("Xã Tân An");
            comboBoxWard.addItem("Xã Vĩnh Tân");
            comboBoxWard.addItem("Xã Bình Lợi");
            comboBoxWard.addItem("Xã Thạnh Phú");
            comboBoxWard.addItem("Xã Thiện Tân");
            comboBoxWard.addItem("Xã Tân Bình");
            comboBoxWard.addItem("Xã Bình Hòa");
            comboBoxWard.addItem("Xã Mã Đà");
            comboBoxWard.addItem("Xã Hiếu Liêm");

        } else if (district.equals("Huyện Định Quán")) {
            comboBoxWard.removeAllItems();
            comboBoxWard.addItem("Thị trấn Định Quán");
            comboBoxWard.addItem("Xã Thanh Sơn");
            comboBoxWard.addItem("Xã Phú Tân");
            comboBoxWard.addItem("Xã Phú Vinh");
            comboBoxWard.addItem("Xã Phú Lợi");
            comboBoxWard.addItem("Xã Phú Hòa");
            comboBoxWard.addItem("Xã Ngọc Định");
            comboBoxWard.addItem("Xã La Ngà");
            comboBoxWard.addItem("Xã Gia Canh");
            comboBoxWard.addItem("Xã Phú Ngọc");
            comboBoxWard.addItem("Xã Phú Cường");
            comboBoxWard.addItem("Xã Túc Trưng");
            comboBoxWard.addItem("Xã Phú Túc");
            comboBoxWard.addItem("Xã Suối Nho");

        } else if (district.equals("Huyện Trảng Bom")) {
            comboBoxWard.removeAllItems();
            comboBoxWard.addItem("Thị trấn Trảng Bom");
            comboBoxWard.addItem("Xã Thanh Bình");
            comboBoxWard.addItem("Xã Cây Gáo");
            comboBoxWard.addItem("Xã Bàu Hàm");
            comboBoxWard.addItem("Xã Sông Thao");
            comboBoxWard.addItem("Xã Sông Trầu");
            comboBoxWard.addItem("Xã Đông Hoà");
            comboBoxWard.addItem("Xã Bắc Sơn");
            comboBoxWard.addItem("Xã Hố Nai 3");
            comboBoxWard.addItem("Xã Tây Hoà");
            comboBoxWard.addItem("Xã Bình Minh");
            comboBoxWard.addItem("Xã Trung Hoà");
            comboBoxWard.addItem("Xã Đồi 61");
            comboBoxWard.addItem("Xã Hưng Thịnh");
            comboBoxWard.addItem("Xã Quảng Tiến");
            comboBoxWard.addItem("Xã Giang Điền");
            comboBoxWard.addItem("Xã An Viễn");

        } else if (district.equals("Huyện Thống Nhất")) {
            comboBoxWard.removeAllItems();
            comboBoxWard.addItem("Xã Gia Tân 1");
            comboBoxWard.addItem("Xã Gia Tân 2");
            comboBoxWard.addItem("Xã Gia Tân 3");
            comboBoxWard.addItem("Xã Gia Kiệm");
            comboBoxWard.addItem("Xã Quang Trung");
            comboBoxWard.addItem("Xã Bàu Hàm 2");
            comboBoxWard.addItem("Xã Hưng Lộc");
            comboBoxWard.addItem("Xã Lộ 25");
            comboBoxWard.addItem("Xã Xuân Thiện");
            comboBoxWard.addItem("Thị trấn Dầu Giây");

        } else if (district.equals("Huyện Cẩm Mỹ")) {
            comboBoxWard.removeAllItems();
            comboBoxWard.addItem("Xã Sông Nhạn");
            comboBoxWard.addItem("Xã Xuân Quế");
            comboBoxWard.addItem("Xã Nhân Nghĩa");
            comboBoxWard.addItem("Xã Xuân Đường");
            comboBoxWard.addItem("Thị trấn Long Giao");
            comboBoxWard.addItem("Xã Xuân Mỹ");
            comboBoxWard.addItem("Xã Thừa Đức");
            comboBoxWard.addItem("Xã Bảo Bình");
            comboBoxWard.addItem("Xã Xuân Bảo");
            comboBoxWard.addItem("Xã Xuân Tây");
            comboBoxWard.addItem("Xã Xuân Đông");
            comboBoxWard.addItem("Xã Sông Ray");
            comboBoxWard.addItem("Xã Lâm San");

        } else if (district.equals("Huyện Long Thành")) {
            comboBoxWard.removeAllItems();
            comboBoxWard.addItem("Thị trấn Long Thành");
            comboBoxWard.addItem("Xã An Phước");
            comboBoxWard.addItem("Xã Bình An");
            comboBoxWard.addItem("Xã Long Đức");
            comboBoxWard.addItem("Xã Lộc An");
            comboBoxWard.addItem("Xã Bình Sơn");
            comboBoxWard.addItem("Xã Tam An");
            comboBoxWard.addItem("Xã Cẩm Đường");
            comboBoxWard.addItem("Xã Long An");
            comboBoxWard.addItem("Xã Bàu Cạn");
            comboBoxWard.addItem("Xã Long Phước");
            comboBoxWard.addItem("Xã Phước Bình");
            comboBoxWard.addItem("Xã Tân Hiệp");
            comboBoxWard.addItem("Xã Phước Thái");

        } else if (district.equals("Huyện Xuân Lộc")) {
            comboBoxWard.removeAllItems();
            comboBoxWard.addItem("Thị trấn Gia Ray");
            comboBoxWard.addItem("Xã Xuân Bắc");
            comboBoxWard.addItem("Xã Suối Cao");
            comboBoxWard.addItem("Xã Xuân Thành");
            comboBoxWard.addItem("Xã Xuân Thọ");
            comboBoxWard.addItem("Xã Xuân Trường");
            comboBoxWard.addItem("Xã Xuân Hòa");
            comboBoxWard.addItem("Xã Xuân Hưng");
            comboBoxWard.addItem("Xã Xuân Tâm");
            comboBoxWard.addItem("Xã Suối Cát");
            comboBoxWard.addItem("Xã Xuân Hiệp");
            comboBoxWard.addItem("Xã Xuân Phú");
            comboBoxWard.addItem("Xã Xuân Định");
            comboBoxWard.addItem("Xã Bảo Hoà");
            comboBoxWard.addItem("Xã Lang Minh");

        } else if (district.equals("Huyện Nhơn Trạch")) {
            comboBoxWard.removeAllItems();
            comboBoxWard.addItem("Xã Phước Thiền");
            comboBoxWard.addItem("Xã Long Tân");
            comboBoxWard.addItem("Xã Đại Phước");
            comboBoxWard.addItem("Thị trấn Hiệp Phước");
            comboBoxWard.addItem("Xã Phú Hữu");
            comboBoxWard.addItem("Xã Phú Hội");
            comboBoxWard.addItem("Xã Phú Thạnh");
            comboBoxWard.addItem("Xã Phú Đông");
            comboBoxWard.addItem("Xã Long Thọ");
            comboBoxWard.addItem("Xã Vĩnh Thanh");
            comboBoxWard.addItem("Xã Phước Khánh");
            comboBoxWard.addItem("Xã Phước An");

        }
    }//GEN-LAST:event_comboBoxDistrictActionPerformed

    private void textFieldAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldAddressKeyTyped
        setFullAddress();
    }//GEN-LAST:event_textFieldAddressKeyTyped

    private void comboBoxWardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxWardActionPerformed
        setFullAddress();
    }//GEN-LAST:event_comboBoxWardActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LB_location;
    private javax.swing.JComboBox<String> comboBoxDistrict;
    private javax.swing.JComboBox<String> comboBoxProvince;
    private javax.swing.JComboBox<String> comboBoxWard;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField textFieldAddress;
    // End of variables declaration//GEN-END:variables
}
