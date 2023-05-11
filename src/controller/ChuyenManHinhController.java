package controller;

import bean.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JPanel;
import view.component.LabelGoogleIcon;
import view.main.DashBoardView;
import view.party.PartyJPanel;
import view.customer.CustomerJPanel;
import view.staff.StaffJPanel;
import view.account.AccountJPanel;
import view.dish.DishJPanel;

public class ChuyenManHinhController {

    private JPanel root;
    private String kindSelected = "";

    private List<DanhMucBean> listItem = null;

    public ChuyenManHinhController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnItem, LabelGoogleIcon jlbItem) {
        kindSelected = "BangDieuKhien";
        jpnItem.setBackground(new Color(148, 175, 159));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new DashBoardView());
        root.validate();
        root.repaint();
    }

    public void setEvent(List<DanhMucBean> listItem) {
        this.listItem = listItem;
        for (DanhMucBean item : listItem) {
            item.getJpn().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), (LabelGoogleIcon) item.getJlb()));
        }

    }

    class LabelEvent implements MouseListener {

        private JPanel node;

        private String kind;
        private JPanel jpnItem;
        private LabelGoogleIcon jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, LabelGoogleIcon jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "BangDieuKhien":
                    node = new DashBoardView();
                    break;
                case "KhachHang":
                    node = new CustomerJPanel();
                    break;
                case "NhanVien":
                    node = new StaffJPanel();
                    break;
                case "ThucDon":
                    node = new DishJPanel();
                    break;
                case "Tiec":
                    node = new PartyJPanel();
                    break;
                case "DoanhThu":
                    break;
                case "TaiKhoan":
                    node = new AccountJPanel();
                default:
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (!kindSelected.equals(kind)) {
                kindSelected = kind;
                jpnItem.setBackground(new Color(187, 214, 184));
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(187, 214, 184));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(102, 102, 102));
            }
        }

    }

    private void setChangeBackground(String kind) {
        for (DanhMucBean item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(148, 175, 159));
            } else {
                item.getJpn().setBackground(new Color(102, 102, 102));
            }
        }
    }
}
