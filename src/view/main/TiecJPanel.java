package view.main;

public class TiecJPanel extends javax.swing.JPanel {

    public TiecJPanel() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        top = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        searchBtn = new rojerusan.RSButtonHover();
        center = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new view.component.Table();
        bottom = new javax.swing.JPanel();
        seeBtn = new rojeru_san.complementos.RSButtonHover();
        addBtn = new rojeru_san.complementos.RSButtonHover();
        editBtn = new rojeru_san.complementos.RSButtonHover();
        removeBtn = new rojeru_san.complementos.RSButtonHover();
        paymentBtn = new rojeru_san.complementos.RSButtonHover();

        setBackground(new java.awt.Color(249, 245, 231));
        setMinimumSize(new java.awt.Dimension(1017, 576));
        setPreferredSize(new java.awt.Dimension(1017, 576));
        setLayout(new java.awt.BorderLayout());

        top.setBackground(getBackground());

        searchPanel.setLayout(new javax.swing.BoxLayout(searchPanel, javax.swing.BoxLayout.LINE_AXIS));

        searchField.setBackground(new java.awt.Color(255, 255, 255));
        searchField.setForeground(new java.awt.Color(0, 0, 0));
        searchField.setText("Tìm kiếm");
        searchField.setCaretColor(new java.awt.Color(0, 0, 0));
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchPanel.add(searchField);

        searchBtn.setBackground(new java.awt.Color(148, 175, 159));
        searchBtn.setText("Tìm");
        searchBtn.setColorHover(new java.awt.Color(187, 214, 184));
        searchBtn.setPreferredSize(new java.awt.Dimension(80, 60));
        searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBtnMouseClicked(evt);
            }
        });
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        searchPanel.add(searchBtn);

        javax.swing.GroupLayout topLayout = new javax.swing.GroupLayout(top);
        top.setLayout(topLayout);
        topLayout.setHorizontalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topLayout.setVerticalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        add(top, java.awt.BorderLayout.NORTH);

        center.setBackground(getBackground());

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table1);

        javax.swing.GroupLayout centerLayout = new javax.swing.GroupLayout(center);
        center.setLayout(centerLayout);
        centerLayout.setHorizontalGroup(
            centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
            .addGroup(centerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        centerLayout.setVerticalGroup(
            centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(center, java.awt.BorderLayout.CENTER);

        bottom.setBackground(new java.awt.Color(232, 160, 191));

        seeBtn.setBackground(new java.awt.Color(148, 175, 159));
        seeBtn.setText("Xem");
        seeBtn.setColorHover(new java.awt.Color(187, 214, 184));
        seeBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        seeBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seeBtn.setPreferredSize(new java.awt.Dimension(70, 40));
        seeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seeBtnMouseClicked(evt);
            }
        });
        seeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeBtnActionPerformed(evt);
            }
        });
        bottom.add(seeBtn);

        addBtn.setBackground(new java.awt.Color(148, 175, 159));
        addBtn.setText("Thêm");
        addBtn.setColorHover(new java.awt.Color(187, 214, 184));
        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addBtn.setPreferredSize(new java.awt.Dimension(70, 40));
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
        bottom.add(addBtn);

        editBtn.setBackground(new java.awt.Color(148, 175, 159));
        editBtn.setText("Sửa");
        editBtn.setColorHover(new java.awt.Color(187, 214, 184));
        editBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editBtn.setPreferredSize(new java.awt.Dimension(70, 40));
        editBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtnMouseClicked(evt);
            }
        });
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });
        bottom.add(editBtn);

        removeBtn.setBackground(new java.awt.Color(244, 80, 80));
        removeBtn.setText("Xóa");
        removeBtn.setColorHover(new java.awt.Color(246, 118, 118));
        removeBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        removeBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        removeBtn.setPreferredSize(new java.awt.Dimension(70, 40));
        removeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeBtnMouseClicked(evt);
            }
        });
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });
        bottom.add(removeBtn);

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
        bottom.add(paymentBtn);

        add(bottom, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseClicked
//        System.out.println(this.getParent());
    }//GEN-LAST:event_searchBtnMouseClicked

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBtnActionPerformed

    private void paymentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentBtnActionPerformed

    private void paymentBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentBtnMouseClicked

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeBtnActionPerformed

    private void removeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_removeBtnMouseClicked

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editBtnActionPerformed

    private void editBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_editBtnMouseClicked

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addBtnActionPerformed

    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addBtnMouseClicked

    private void seeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seeBtnActionPerformed

    private void seeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seeBtnMouseClicked

    }//GEN-LAST:event_seeBtnMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover addBtn;
    private javax.swing.JPanel bottom;
    private javax.swing.JPanel center;
    private rojeru_san.complementos.RSButtonHover editBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private rojeru_san.complementos.RSButtonHover paymentBtn;
    private rojeru_san.complementos.RSButtonHover removeBtn;
    private rojerusan.RSButtonHover searchBtn;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel searchPanel;
    private rojeru_san.complementos.RSButtonHover seeBtn;
    private view.component.Table table1;
    private javax.swing.JPanel top;
    // End of variables declaration//GEN-END:variables
}
