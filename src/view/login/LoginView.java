package view.login;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import view.main.MainView;

public class LoginView extends javax.swing.JFrame {

    public LoginView() {
        initComponents();
        showPassBtn.setVisible(true);
        hidePassBtn.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftPanel = new javax.swing.JPanel();
        labelGoogleIcon1 = new view.component.LabelGoogleIcon();
        jLabel4 = new javax.swing.JLabel();
        rightPanel = new javax.swing.JPanel();
        passwordField = new javax.swing.JPasswordField();
        usernameField = new javax.swing.JTextField();
        labelAwesomeIcon1 = new view.component.LabelAwesomeIcon();
        labelAwesomeIcon2 = new view.component.LabelAwesomeIcon();
        forgotPasswordBtn = new javax.swing.JLabel();
        closeBtn = new view.component.LabelGoogleIcon();
        resetBtn = new rojeru_san.complementos.RSButtonHover();
        loginBtn = new rojeru_san.complementos.RSButtonHover();
        minimizeBtn = new view.component.LabelGoogleIcon();
        showPassBtn = new view.component.LabelAwesomeIcon();
        hidePassBtn = new view.component.LabelAwesomeIcon();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(650, 350));
        setName("login"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        leftPanel.setBackground(new java.awt.Color(46, 11, 47));
        leftPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                leftPanelMouseDragged(evt);
            }
        });
        leftPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                leftPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                leftPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                leftPanelMousePressed(evt);
            }
        });

        labelGoogleIcon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelGoogleIcon1.setGoogleIcon(icon.GoogleMaterialDesignIcons.RESTAURANT);
        labelGoogleIcon1.setIconColor(new java.awt.Color(255, 255, 255));
        labelGoogleIcon1.setIconSize(100.0F);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Lan Huệ");

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelGoogleIcon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(labelGoogleIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        rightPanel.setBackground(new java.awt.Color(231, 70, 70));
        rightPanel.setForeground(new java.awt.Color(255, 255, 255));
        rightPanel.setAutoscrolls(true);
        rightPanel.setPreferredSize(new java.awt.Dimension(325, 350));
        rightPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        passwordField.setBackground(new java.awt.Color(231, 70, 70));
        passwordField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passwordField.setForeground(new java.awt.Color(255, 255, 255));
        passwordField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        passwordField.setCaretColor(new java.awt.Color(255, 255, 255));
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        rightPanel.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 197, 30));

        usernameField.setBackground(new java.awt.Color(231, 70, 70));
        usernameField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        usernameField.setForeground(new java.awt.Color(255, 255, 255));
        usernameField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        usernameField.setCaretColor(new java.awt.Color(255, 255, 255));
        usernameField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        rightPanel.add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 197, 30));

        labelAwesomeIcon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAwesomeIcon1.setAwesomeIcon(icon.FontAwesome.USER);
        labelAwesomeIcon1.setIconColor(new java.awt.Color(255, 255, 255));
        labelAwesomeIcon1.setIconSize(24.0F);
        rightPanel.add(labelAwesomeIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 30, 30));

        labelAwesomeIcon2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAwesomeIcon2.setAwesomeIcon(icon.FontAwesome.LOCK);
        labelAwesomeIcon2.setIconColor(new java.awt.Color(255, 255, 255));
        labelAwesomeIcon2.setIconSize(24.0F);
        rightPanel.add(labelAwesomeIcon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 30, 30));

        forgotPasswordBtn.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        forgotPasswordBtn.setForeground(new java.awt.Color(255, 255, 255));
        forgotPasswordBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forgotPasswordBtn.setText("Quên mật khẩu?");
        forgotPasswordBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        forgotPasswordBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotPasswordBtnMouseClicked(evt);
            }
        });
        rightPanel.add(forgotPasswordBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));

        closeBtn.setBackground(new java.awt.Color(46, 11, 47));
        closeBtn.setForeground(new java.awt.Color(46, 11, 47));
        closeBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closeBtn.setGoogleIcon(icon.GoogleMaterialDesignIcons.CLOSE);
        closeBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        closeBtn.setIconColor(new java.awt.Color(46, 11, 47));
        closeBtn.setIconSize(32.0F);
        closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeBtnMouseEntered(evt);
            }
        });
        rightPanel.add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        resetBtn.setBackground(new java.awt.Color(46, 11, 47));
        resetBtn.setText("Đặt lại");
        resetBtn.setColorHover(new java.awt.Color(137, 24, 140));
        resetBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });
        rightPanel.add(resetBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 80, 30));

        loginBtn.setBackground(new java.awt.Color(46, 11, 47));
        loginBtn.setText("Đăng nhập");
        loginBtn.setColorHover(new java.awt.Color(137, 24, 140));
        loginBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        loginBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBtnMouseClicked(evt);
            }
        });
        rightPanel.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 110, 30));

        minimizeBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimizeBtn.setGoogleIcon(icon.GoogleMaterialDesignIcons.REMOVE);
        minimizeBtn.setIconColor(new java.awt.Color(46, 11, 47));
        minimizeBtn.setIconSize(32.0F);
        minimizeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeBtnMouseEntered(evt);
            }
        });
        rightPanel.add(minimizeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        showPassBtn.setAwesomeIcon(icon.FontAwesome.EYE_SLASH);
        showPassBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        showPassBtn.setIconColor(new java.awt.Color(255, 255, 255));
        showPassBtn.setIconSize(14.0F);
        showPassBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showPassBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                showPassBtnMouseEntered(evt);
            }
        });
        rightPanel.add(showPassBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, -1, -1));

        hidePassBtn.setAwesomeIcon(icon.FontAwesome.EYE);
        hidePassBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        hidePassBtn.setIconColor(new java.awt.Color(255, 255, 255));
        hidePassBtn.setIconSize(14.0F);
        hidePassBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hidePassBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hidePassBtnMouseEntered(evt);
            }
        });
        rightPanel.add(hidePassBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseEntered
        closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_closeBtnMouseEntered

    private void closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeBtnMouseClicked

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void leftPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftPanelMouseDragged
        setLocationWhendrag(evt);
    }//GEN-LAST:event_leftPanelMouseDragged

    private void leftPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftPanelMousePressed
        this.setCursor(new Cursor(Cursor.MOVE_CURSOR) {
        });
        setXAndYWhenClickPanel(evt);
    }//GEN-LAST:event_leftPanelMousePressed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        usernameField.setText("");
        passwordField.setText("");
    }//GEN-LAST:event_resetBtnActionPerformed

    private void minimizeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeBtnMouseClicked
        this.setExtendedState(LoginView.ICONIFIED);
    }//GEN-LAST:event_minimizeBtnMouseClicked

    private void minimizeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeBtnMouseEntered
        minimizeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_minimizeBtnMouseEntered

    private void showPassBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPassBtnMouseClicked
        showPassBtn.setVisible(false);
        hidePassBtn.setVisible(true);
        passwordField.setEchoChar((char) 0);
    }//GEN-LAST:event_showPassBtnMouseClicked

    private void hidePassBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hidePassBtnMouseClicked
        showPassBtn.setVisible(true);
        hidePassBtn.setVisible(false);
        passwordField.setEchoChar('*');
    }//GEN-LAST:event_hidePassBtnMouseClicked

    private void showPassBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPassBtnMouseEntered
        showPassBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_showPassBtnMouseEntered

    private void hidePassBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hidePassBtnMouseEntered
        hidePassBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_hidePassBtnMouseEntered

    private void forgotPasswordBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPasswordBtnMouseClicked
        JOptionPane.showMessageDialog(this, "Liên hệ admin để lấy lại mật khẩu!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_forgotPasswordBtnMouseClicked

    private void loginBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseClicked
        String usernameValue = this.usernameField.getText();
        char[] password = this.passwordField.getPassword();
        String passwordValue = String.valueOf(password);
        System.out.println(usernameValue + " " + passwordValue);
    }//GEN-LAST:event_loginBtnMouseClicked

    private void leftPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftPanelMouseEntered
        setCursor(new Cursor(Cursor.MOVE_CURSOR));
    }//GEN-LAST:event_leftPanelMouseEntered

    private void leftPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftPanelMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_leftPanelMouseExited

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    private int x, y;

    public void setXAndYWhenClickPanel(MouseEvent evt) {
        x = evt.getX();
        y = evt.getY();
    }

    public void setLocationWhendrag(MouseEvent evt) {
        int gX = evt.getXOnScreen();
        int gY = evt.getYOnScreen();
        this.setLocation(gX - x, gY - y);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.component.LabelGoogleIcon closeBtn;
    private javax.swing.JLabel forgotPasswordBtn;
    private view.component.LabelAwesomeIcon hidePassBtn;
    private javax.swing.JLabel jLabel4;
    private view.component.LabelAwesomeIcon labelAwesomeIcon1;
    private view.component.LabelAwesomeIcon labelAwesomeIcon2;
    private view.component.LabelGoogleIcon labelGoogleIcon1;
    private javax.swing.JPanel leftPanel;
    private rojeru_san.complementos.RSButtonHover loginBtn;
    private view.component.LabelGoogleIcon minimizeBtn;
    private javax.swing.JPasswordField passwordField;
    private rojeru_san.complementos.RSButtonHover resetBtn;
    private javax.swing.JPanel rightPanel;
    private view.component.LabelAwesomeIcon showPassBtn;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
