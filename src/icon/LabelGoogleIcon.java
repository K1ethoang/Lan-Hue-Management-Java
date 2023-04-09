package icon;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;
import jiconfont.swing.IconFontSwing;

public class LabelGoogleIcon extends JLabel {

    private GoogleMaterialDesignIcons googleIcon;
    private float iconSize = 16;
    private Color iconColor = Color.yellow;

    public GoogleMaterialDesignIcons getGoogleIcon() {
        return googleIcon;
    }

    public void setGoogleIcon(GoogleMaterialDesignIcons googleIcon) {
        this.googleIcon = googleIcon;
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
        if (googleIcon != null) {
            IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
            setIcon(IconFontSwing.buildIcon(googleIcon, iconSize, iconColor));
        }
    }
}
