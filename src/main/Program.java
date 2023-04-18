package main;

import javax.swing.UIManager;
import view.login.LoginView;

public class Program {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        LoginView loginView = new LoginView();
        loginView.setVisible(true);

    }
}
