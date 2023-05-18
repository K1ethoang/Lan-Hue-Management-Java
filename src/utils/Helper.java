package utils;

import java.awt.Component;
import java.awt.Image;
import java.awt.Taskbar;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.sql.Time;
import java.util.Arrays;
import java.util.Currency;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import main.Program;

/**
 *
 * @author kieth
 */
public class Helper {

    public static String formatDateToPrint(Date date) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return (String) df.format(date);
    }

    public static String formatDateToSet(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return (String) df.format(date);
    }

    public static String formatTimeToSet(Time time) {
        DateFormat df = new SimpleDateFormat("hh:mm:ss");
        return (String) df.format(time);
    }

    public static String getMonth(Date date) {
        DateFormat df = new SimpleDateFormat("MM");
        return (String) df.format(date);
    }

    public static String formatPriceToDisplay(double number) {
        // Create a new Locale
        Locale vn = new Locale("vi", "VN");
        // Create a formatter given the Locale
        NumberFormat dongFormat = NumberFormat.getCurrencyInstance(vn);
        // Format the Number into a Currency String
        String s = dongFormat.format(number);
        return s;
    }

    public static String replaceInString(String s, String target, String replacement) {
        if (s != null) {
            return (String) s.replace(target, replacement);
        }
        return null;
    }

    public static void setIconImage4JFrame(Window window) {
        // set Icon => JFrame
        try {
            var image = new ImageIcon(Objects.requireNonNull(Program.class.getResource("../resources/restaurant-96.png")));
            window.setIconImage(image.getImage());
            if (System.getProperty("os.name").startsWith("Mac") || System.getProperty("os.name").startsWith("Darwin")) {
                Taskbar taskbar = Taskbar.getTaskbar();
                try {
                    taskbar.setIconImage(image.getImage());
                } catch (final UnsupportedOperationException e) {
                    System.out.println("Can't set taskbar icon.");
                } catch (final SecurityException e) {
                    System.out.println("Warning. Can't set taskbar icon due to security exceptions.");
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    public static JFrame getWindow(Component component) {
        JFrame frame = (JFrame) SwingUtilities.windowForComponent(component);
        return frame;
    }

    public static void setQuestionBeforeClose(Window window) {
        window.addWindowListener(new java.awt.event.WindowAdapter() {

            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                String ObjButtons[] = {"Thoát", "Hủy"};
                int PromptResult = JOptionPane.showOptionDialog(window, "Bạn thực sự muốn thoát?", "Quản lý tiệc Lan Huệ", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
                if (PromptResult == JOptionPane.YES_OPTION) {
                    window.dispose();
                }

            }
        });
    }
}
