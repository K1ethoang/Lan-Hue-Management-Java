package view.main;

import bean.DanhMucBean;
import controller.ChuyenManHinhController;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.List;
import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import utils.Helper;
import view.login.LoginView;

public class MainView extends javax.swing.JFrame {

    public MainView() {
        initComponents();
        Helper.setIconImage4JFrame(this);

        logoutBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        minimizeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        setTitle("QUẢN LÍ TIỆC LAN HUỆ");
        // chuyển màn hình view
        ChuyenManHinhController controller = new ChuyenManHinhController(jpnView);
        controller.setView(jpnBangDieuKhien, jlbBangDieuKhien);

        List<DanhMucBean> listItem = new ArrayList<>();
        listItem.add(new DanhMucBean("BangDieuKhien", jpnBangDieuKhien, jlbBangDieuKhien));
        listItem.add(new DanhMucBean("KhachHang", jpnKhachHang, jlbKhachHang));
        listItem.add(new DanhMucBean("NhanVien", jpnNhanVien, jlbNhanVien));
        listItem.add(new DanhMucBean("ThucDon", jpnThucDon, jlbThucDon));
        listItem.add(new DanhMucBean("Tiec", jpnDatTiec, jlbDatTiec));
        listItem.add(new DanhMucBean("TaiKhoan", jpnTaiKhoan, jlbTaiKhoan));

        controller.setEvent(listItem);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jpnView = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        jpnNhanVien = new javax.swing.JPanel();
        jlbNhanVien = new view.component.LabelGoogleIcon();
        jpnThucDon = new javax.swing.JPanel();
        jlbThucDon = new view.component.LabelGoogleIcon();
        jpnDatTiec = new javax.swing.JPanel();
        jlbDatTiec = new view.component.LabelGoogleIcon();
        jpnKhachHang = new javax.swing.JPanel();
        jlbKhachHang = new view.component.LabelGoogleIcon();
        jpnTaiKhoan = new javax.swing.JPanel();
        jlbTaiKhoan = new view.component.LabelGoogleIcon();
        jpnBangDieuKhien = new javax.swing.JPanel();
        jlbBangDieuKhien = new view.component.LabelGoogleIcon();
        topPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelGoogleIcon1 = new view.component.LabelGoogleIcon();
        labelDateTime1 = new view.component.LabelDateTime();
        jPanel1 = new javax.swing.JPanel();
        closeBtn = new view.component.LabelGoogleIcon();
        minimizeBtn = new view.component.LabelGoogleIcon();
        logoutBtn = new view.component.LabelAwesomeIcon();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnRoot.setBackground(new java.awt.Color(249, 245, 231));
        jpnRoot.setPreferredSize(new java.awt.Dimension(1280, 720));

        jpnView.setBackground(new java.awt.Color(249, 245, 231));
        jpnView.setMinimumSize(new java.awt.Dimension(1017, 576));

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 666, Short.MAX_VALUE)
        );

        jpnMenu.setBackground(new java.awt.Color(102, 102, 102));

        jpnNhanVien.setBackground(new java.awt.Color(102, 102, 102));
        jpnNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnNhanVien.setPreferredSize(new java.awt.Dimension(216, 60));

        jlbNhanVien.setBackground(jpnNhanVien.getBackground());
        jlbNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        jlbNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbNhanVien.setText("  NHÂN VIÊN");
        jlbNhanVien.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbNhanVien.setIconColor(new java.awt.Color(255, 255, 255));
        jlbNhanVien.setIconSize(26.0F);

        javax.swing.GroupLayout jpnNhanVienLayout = new javax.swing.GroupLayout(jpnNhanVien);
        jpnNhanVien.setLayout(jpnNhanVienLayout);
        jpnNhanVienLayout.setHorizontalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnNhanVienLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnNhanVienLayout.setVerticalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jpnThucDon.setBackground(new java.awt.Color(102, 102, 102));
        jpnThucDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnThucDon.setPreferredSize(new java.awt.Dimension(216, 60));

        jlbThucDon.setBackground(jpnThucDon.getBackground());
        jlbThucDon.setForeground(new java.awt.Color(255, 255, 255));
        jlbThucDon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbThucDon.setText("  THỰC ĐƠN");
        jlbThucDon.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbThucDon.setIconColor(new java.awt.Color(255, 255, 255));
        jlbThucDon.setIconSize(26.0F);

        javax.swing.GroupLayout jpnThucDonLayout = new javax.swing.GroupLayout(jpnThucDon);
        jpnThucDon.setLayout(jpnThucDonLayout);
        jpnThucDonLayout.setHorizontalGroup(
            jpnThucDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnThucDonLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbThucDon, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnThucDonLayout.setVerticalGroup(
            jpnThucDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbThucDon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jpnDatTiec.setBackground(new java.awt.Color(102, 102, 102));
        jpnDatTiec.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnDatTiec.setPreferredSize(new java.awt.Dimension(216, 60));

        jlbDatTiec.setBackground(jpnDatTiec.getBackground());
        jlbDatTiec.setForeground(new java.awt.Color(255, 255, 255));
        jlbDatTiec.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbDatTiec.setText("  TIỆC");
        jlbDatTiec.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbDatTiec.setIconColor(new java.awt.Color(255, 255, 255));
        jlbDatTiec.setIconSize(26.0F);

        javax.swing.GroupLayout jpnDatTiecLayout = new javax.swing.GroupLayout(jpnDatTiec);
        jpnDatTiec.setLayout(jpnDatTiecLayout);
        jpnDatTiecLayout.setHorizontalGroup(
            jpnDatTiecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnDatTiecLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbDatTiec, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnDatTiecLayout.setVerticalGroup(
            jpnDatTiecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbDatTiec, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jpnKhachHang.setBackground(new java.awt.Color(102, 102, 102));
        jpnKhachHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnKhachHang.setPreferredSize(new java.awt.Dimension(216, 60));

        jlbKhachHang.setBackground(jpnKhachHang.getBackground());
        jlbKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        jlbKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbKhachHang.setText("  KHÁCH HÀNG");
        jlbKhachHang.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbKhachHang.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jlbKhachHang.setIconColor(new java.awt.Color(255, 255, 255));
        jlbKhachHang.setIconSize(26.0F);
        jlbKhachHang.setPreferredSize(new java.awt.Dimension(216, 60));

        javax.swing.GroupLayout jpnKhachHangLayout = new javax.swing.GroupLayout(jpnKhachHang);
        jpnKhachHang.setLayout(jpnKhachHangLayout);
        jpnKhachHangLayout.setHorizontalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnKhachHangLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnKhachHangLayout.setVerticalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jpnTaiKhoan.setBackground(new java.awt.Color(102, 102, 102));
        jpnTaiKhoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnTaiKhoan.setPreferredSize(new java.awt.Dimension(216, 60));

        jlbTaiKhoan.setBackground(jpnTaiKhoan.getBackground());
        jlbTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        jlbTaiKhoan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbTaiKhoan.setText("  TÀI KHOẢN");
        jlbTaiKhoan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbTaiKhoan.setIconColor(new java.awt.Color(255, 255, 255));
        jlbTaiKhoan.setIconSize(26.0F);

        javax.swing.GroupLayout jpnTaiKhoanLayout = new javax.swing.GroupLayout(jpnTaiKhoan);
        jpnTaiKhoan.setLayout(jpnTaiKhoanLayout);
        jpnTaiKhoanLayout.setHorizontalGroup(
            jpnTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnTaiKhoanLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnTaiKhoanLayout.setVerticalGroup(
            jpnTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTaiKhoanLayout.createSequentialGroup()
                .addComponent(jlbTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpnBangDieuKhien.setBackground(new java.awt.Color(102, 102, 102));
        jpnBangDieuKhien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnBangDieuKhien.setPreferredSize(new java.awt.Dimension(216, 60));

        jlbBangDieuKhien.setBackground(jpnBangDieuKhien.getBackground());
        jlbBangDieuKhien.setForeground(new java.awt.Color(255, 255, 255));
        jlbBangDieuKhien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbBangDieuKhien.setText("  BẢNG ĐIỀU KHIỂN");
        jlbBangDieuKhien.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbBangDieuKhien.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jlbBangDieuKhien.setIconColor(new java.awt.Color(255, 255, 255));
        jlbBangDieuKhien.setIconSize(30.0F);
        jlbBangDieuKhien.setPreferredSize(new java.awt.Dimension(216, 60));

        javax.swing.GroupLayout jpnBangDieuKhienLayout = new javax.swing.GroupLayout(jpnBangDieuKhien);
        jpnBangDieuKhien.setLayout(jpnBangDieuKhienLayout);
        jpnBangDieuKhienLayout.setHorizontalGroup(
            jpnBangDieuKhienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnBangDieuKhienLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jlbBangDieuKhien, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnBangDieuKhienLayout.setVerticalGroup(
            jpnBangDieuKhienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbBangDieuKhien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnThucDon, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
            .addComponent(jpnNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
            .addComponent(jpnKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
            .addComponent(jpnDatTiec, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
            .addComponent(jpnTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
            .addComponent(jpnBangDieuKhien, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jpnBangDieuKhien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnThucDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnDatTiec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        topPanel.setBackground(new java.awt.Color(124, 150, 171));
        topPanel.setPreferredSize(new java.awt.Dimension(1280, 54));
        topPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                topPanelMouseDragged(evt);
            }
        });
        topPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                topPanelMousePressed(evt);
            }
        });
        topPanel.setLayout(new java.awt.GridLayout(1, 2));

        jPanel2.setBackground(topPanel.getBackground());

        labelGoogleIcon1.setForeground(new java.awt.Color(255, 255, 255));
        labelGoogleIcon1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelGoogleIcon1.setText("QUẢN LÝ LAN HUỆ");
        labelGoogleIcon1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelGoogleIcon1.setIconColor(new java.awt.Color(255, 255, 255));
        labelGoogleIcon1.setIconSize(40.0F);

        labelDateTime1.setForeground(new java.awt.Color(255, 255, 255));
        labelDateTime1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(labelGoogleIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(labelDateTime1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelGoogleIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDateTime1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        topPanel.add(jPanel2);

        jPanel1.setBackground(topPanel.getBackground());

        closeBtn.setGoogleIcon(icon.GoogleMaterialDesignIcons.CLOSE);
        closeBtn.setIconColor(new java.awt.Color(219, 228, 198));
        closeBtn.setIconSize(32.0F);
        closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeBtnMouseClicked(evt);
            }
        });

        minimizeBtn.setGoogleIcon(icon.GoogleMaterialDesignIcons.REMOVE);
        minimizeBtn.setIconColor(new java.awt.Color(219, 228, 198));
        minimizeBtn.setIconSize(32.0F);
        minimizeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeBtnMouseClicked(evt);
            }
        });

        logoutBtn.setToolTipText("Đăng xuất");
        logoutBtn.setAwesomeIcon(icon.FontAwesome.SIGN_OUT);
        logoutBtn.setIconColor(new java.awt.Color(244, 80, 80));
        logoutBtn.setIconSize(40.0F);
        logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(504, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(minimizeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(closeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15))))
        );

        topPanel.add(jPanel1);

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnRootLayout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        getContentPane().add(jpnRoot, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseClicked
        int option = JOptionPane.showConfirmDialog(this, "Bạn muốn đăng xuất?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (option == ConfirmationCallback.YES) {
            this.dispose();
            LoginView login = new LoginView();
            login.setVisible(true);
        }
    }//GEN-LAST:event_logoutBtnMouseClicked

    private void minimizeBtnMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_minimizeBtnMouseClicked
        this.setState(JFrame.ICONIFIED);
    }// GEN-LAST:event_minimizeBtnMouseClicked

    private void closeBtnMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_closeBtnMouseClicked
        System.exit(0);
    }// GEN-LAST:event_closeBtnMouseClicked

    private void topPanelMouseDragged(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_topPanelMouseDragged
        int gX = evt.getXOnScreen();
        int gY = evt.getYOnScreen();
        this.setLocation(gX - x, gY - y);
    }// GEN-LAST:event_topPanelMouseDragged

    private int x, y;

    private void topPanelMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_topPanelMousePressed
        x = evt.getX();
        y = evt.getY();
    }// GEN-LAST:event_topPanelMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainView mainView = new MainView();
                mainView.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.component.LabelGoogleIcon closeBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private view.component.LabelGoogleIcon jlbBangDieuKhien;
    private view.component.LabelGoogleIcon jlbDatTiec;
    private view.component.LabelGoogleIcon jlbKhachHang;
    private view.component.LabelGoogleIcon jlbNhanVien;
    private view.component.LabelGoogleIcon jlbTaiKhoan;
    private view.component.LabelGoogleIcon jlbThucDon;
    private javax.swing.JPanel jpnBangDieuKhien;
    private javax.swing.JPanel jpnDatTiec;
    private javax.swing.JPanel jpnKhachHang;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnNhanVien;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnTaiKhoan;
    private javax.swing.JPanel jpnThucDon;
    private javax.swing.JPanel jpnView;
    private view.component.LabelDateTime labelDateTime1;
    private view.component.LabelGoogleIcon labelGoogleIcon1;
    private view.component.LabelAwesomeIcon logoutBtn;
    private view.component.LabelGoogleIcon minimizeBtn;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
