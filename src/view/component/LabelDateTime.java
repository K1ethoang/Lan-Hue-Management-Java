package view.component;

import java.awt.Graphics;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

import javax.swing.Timer;

public class LabelDateTime extends JLabel {

    private static final long serialVersionUID = 1L;

    public LabelDateTime() {
        super();
        Timer timer = new Timer(1000, e -> {
            Date now = new Date();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String dateTimeString = df.format(now);
            setText(dateTimeString);
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
