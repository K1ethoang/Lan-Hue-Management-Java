package icon;

import java.awt.Color;
import javax.swing.JLabel;
import jiconfont.swing.IconFontSwing;

public class LabelAwesomeIcon extends JLabel {

    private FontAwesome awesomeIcon;

    private float iconSize = 16;
    private Color iconColor = Color.yellow;

    public FontAwesome getAwesomeIcon() {
        return awesomeIcon;
    }

    public void setAwesomeIcon(FontAwesome awesomeIcon) {
        this.awesomeIcon = awesomeIcon;
        initIcon();

    }

    public float getIconSize() {
        return iconSize;
    }

    public void setIconSize(float iconSize) {
        this.iconSize = iconSize;
        initIcon();

    }

    public Color getIconColor() {
        return iconColor;
    }

    public void setIconColor(Color iconColor) {
        this.iconColor = iconColor;
        initIcon();
    }

    private void initIcon() {
        if (awesomeIcon != null) {
            IconFontSwing.register(FontAwesome.getIconFont());
            setIcon(IconFontSwing.buildIcon(awesomeIcon, iconSize, iconColor));
        }

    }
}
