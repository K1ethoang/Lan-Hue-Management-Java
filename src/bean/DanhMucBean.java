package bean;

import javax.swing.JLabel;
import javax.swing.JPanel;
import view.component.LabelGoogleIcon;

/**
 *
 * @author Admin
 */
public class DanhMucBean {

    private String kind;
    private JPanel jpn;
    private LabelGoogleIcon jlb;

    public DanhMucBean(String kind, JPanel jpn, LabelGoogleIcon jlb) {
        this.kind = kind;
        this.jpn = jpn;
        this.jlb = jlb;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }

    public JLabel getJlb() {
        return jlb;
    }

    public void setJlb(LabelGoogleIcon jlb) {
        this.jlb = jlb;
    }

}
