package view.main;

import bean.DanhMucBean;
import controller.ChuyenManHinhController;
import java.util.ArrayList;
import java.util.List;

public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();

        setTitle("QUẢN LÍ TIỆC LAN HUỆ");
        // chuyển màn hình view
        ChuyenManHinhController controller = new ChuyenManHinhController(jpnView);
        controller.setView(jpnBangDieuKhien, jlbBangDieuKhien);

        List<DanhMucBean> listItem = new ArrayList<>();
        listItem.add(new DanhMucBean("BangDieuKhien", jpnBangDieuKhien, jlbBangDieuKhien));
        listItem.add(new DanhMucBean("KhachHang", jpnKhachHang, jlbKhachHang));
        listItem.add(new DanhMucBean("NhanVien", jpnNhanVien, jlbNhanVien));
        listItem.add(new DanhMucBean("ThucDon", jpnThucDon, jlbThucDon));
        listItem.add(new DanhMucBean("DatTiec", jpnDatTiec, jlbDatTiec));
        listItem.add(new DanhMucBean("DoanhThu", jpnDoanhThu, jlbDoanhThu));
        listItem.add(new DanhMucBean("TaiKhoan", jpnTaiKhoan, jlbTaiKhoan));
        listItem.add(new DanhMucBean("DangXuat", jpnDangXuat, jlbDangXuat));

        controller.setEvent(listItem);
    }

    @SuppressWarnings("unchecked")
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
        jpnDoanhThu = new javax.swing.JPanel();
        jlbDoanhThu = new view.component.LabelGoogleIcon();
        jpnKhachHang = new javax.swing.JPanel();
        jlbKhachHang = new view.component.LabelGoogleIcon();
        jpnDangXuat = new javax.swing.JPanel();
        jlbDangXuat = new view.component.LabelGoogleIcon();
        jpnTaiKhoan = new javax.swing.JPanel();
        jlbTaiKhoan = new view.component.LabelGoogleIcon();
        jpnBangDieuKhien = new javax.swing.JPanel();
        jlbBangDieuKhien = new view.component.LabelGoogleIcon();
        jPanel10 = new javax.swing.JPanel();
        labelGoogleIcon1 = new view.component.LabelGoogleIcon();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 719, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
        );

        jpnMenu.setBackground(new java.awt.Color(102, 102, 102));

        jpnNhanVien.setBackground(new java.awt.Color(102, 102, 102));
        jpnNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnNhanVien.setPreferredSize(new java.awt.Dimension(216, 60));

        jlbNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        jlbNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbNhanVien.setText("  NHÂN VIÊN");
        jlbNhanVien.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbNhanVien.setGoogleIcon(icon.GoogleMaterialDesignIcons.PEOPLE);
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

        jlbThucDon.setForeground(new java.awt.Color(255, 255, 255));
        jlbThucDon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbThucDon.setText("  THỰC ĐƠN");
        jlbThucDon.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbThucDon.setGoogleIcon(icon.GoogleMaterialDesignIcons.IMPORT_CONTACTS);
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

        jlbDatTiec.setForeground(new java.awt.Color(255, 255, 255));
        jlbDatTiec.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbDatTiec.setText("  TIỆC");
        jlbDatTiec.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbDatTiec.setGoogleIcon(icon.GoogleMaterialDesignIcons.SHOPPING_CART);
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

        jpnDoanhThu.setBackground(new java.awt.Color(102, 102, 102));
        jpnDoanhThu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnDoanhThu.setPreferredSize(new java.awt.Dimension(216, 60));

        jlbDoanhThu.setForeground(new java.awt.Color(255, 255, 255));
        jlbDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbDoanhThu.setText("  DOANH THU");
        jlbDoanhThu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbDoanhThu.setGoogleIcon(icon.GoogleMaterialDesignIcons.ACCOUNT_BALANCE_WALLET);
        jlbDoanhThu.setIconColor(new java.awt.Color(255, 255, 255));
        jlbDoanhThu.setIconSize(26.0F);

        javax.swing.GroupLayout jpnDoanhThuLayout = new javax.swing.GroupLayout(jpnDoanhThu);
        jpnDoanhThu.setLayout(jpnDoanhThuLayout);
        jpnDoanhThuLayout.setHorizontalGroup(
            jpnDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnDoanhThuLayout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addComponent(jlbDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnDoanhThuLayout.setVerticalGroup(
            jpnDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jpnKhachHang.setBackground(new java.awt.Color(102, 102, 102));
        jpnKhachHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnKhachHang.setPreferredSize(new java.awt.Dimension(216, 60));

        jlbKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        jlbKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbKhachHang.setText("  KHÁCH HÀNG");
        jlbKhachHang.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbKhachHang.setGoogleIcon(icon.GoogleMaterialDesignIcons.CONTACT_PHONE);
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

        jpnDangXuat.setBackground(new java.awt.Color(102, 102, 102));
        jpnDangXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnDangXuat.setPreferredSize(new java.awt.Dimension(216, 60));

        jlbDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        jlbDangXuat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbDangXuat.setText("  ĐĂNG XUẤT");
        jlbDangXuat.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbDangXuat.setGoogleIcon(icon.GoogleMaterialDesignIcons.INPUT);
        jlbDangXuat.setIconColor(new java.awt.Color(255, 255, 255));
        jlbDangXuat.setIconSize(26.0F);

        javax.swing.GroupLayout jpnDangXuatLayout = new javax.swing.GroupLayout(jpnDangXuat);
        jpnDangXuat.setLayout(jpnDangXuatLayout);
        jpnDangXuatLayout.setHorizontalGroup(
            jpnDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnDangXuatLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnDangXuatLayout.setVerticalGroup(
            jpnDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jpnTaiKhoan.setBackground(new java.awt.Color(102, 102, 102));
        jpnTaiKhoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnTaiKhoan.setPreferredSize(new java.awt.Dimension(216, 60));

        jlbTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        jlbTaiKhoan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbTaiKhoan.setText("  TÀI KHOẢN");
        jlbTaiKhoan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbTaiKhoan.setGoogleIcon(icon.GoogleMaterialDesignIcons.ACCOUNT_BALANCE);
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

        jlbBangDieuKhien.setForeground(new java.awt.Color(255, 255, 255));
        jlbBangDieuKhien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbBangDieuKhien.setText("  BẢNG ĐIỀU KHIÊN");
        jlbBangDieuKhien.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbBangDieuKhien.setGoogleIcon(icon.GoogleMaterialDesignIcons.STORAGE);
        jlbBangDieuKhien.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jlbBangDieuKhien.setIconColor(new java.awt.Color(255, 255, 255));
        jlbBangDieuKhien.setIconSize(30.0F);
        jlbBangDieuKhien.setPreferredSize(new java.awt.Dimension(216, 60));

        javax.swing.GroupLayout jpnBangDieuKhienLayout = new javax.swing.GroupLayout(jpnBangDieuKhien);
        jpnBangDieuKhien.setLayout(jpnBangDieuKhienLayout);
        jpnBangDieuKhienLayout.setHorizontalGroup(
            jpnBangDieuKhienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnBangDieuKhienLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
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
            .addComponent(jpnDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
            .addComponent(jpnDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
            .addComponent(jpnThucDon, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
            .addComponent(jpnNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
            .addComponent(jpnKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
            .addComponent(jpnDatTiec, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
            .addComponent(jpnTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
            .addComponent(jpnBangDieuKhien, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
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
                .addComponent(jpnDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(102, 102, 255));

        labelGoogleIcon1.setForeground(new java.awt.Color(255, 255, 255));
        labelGoogleIcon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelGoogleIcon1.setText("QUẢN LÝ LAN HUỆ");
        labelGoogleIcon1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelGoogleIcon1.setGoogleIcon(icon.GoogleMaterialDesignIcons.RESTAURANT);
        labelGoogleIcon1.setIconColor(new java.awt.Color(255, 255, 255));
        labelGoogleIcon1.setIconSize(40.0F);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Xin Chào, Kiệt");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(labelGoogleIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(labelGoogleIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnRootLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel10;
    private view.component.LabelGoogleIcon jlbBangDieuKhien;
    private view.component.LabelGoogleIcon jlbDangXuat;
    private view.component.LabelGoogleIcon jlbDatTiec;
    private view.component.LabelGoogleIcon jlbDoanhThu;
    private view.component.LabelGoogleIcon jlbKhachHang;
    private view.component.LabelGoogleIcon jlbNhanVien;
    private view.component.LabelGoogleIcon jlbTaiKhoan;
    private view.component.LabelGoogleIcon jlbThucDon;
    private javax.swing.JPanel jpnBangDieuKhien;
    private javax.swing.JPanel jpnDangXuat;
    private javax.swing.JPanel jpnDatTiec;
    private javax.swing.JPanel jpnDoanhThu;
    private javax.swing.JPanel jpnKhachHang;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnNhanVien;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnTaiKhoan;
    private javax.swing.JPanel jpnThucDon;
    private javax.swing.JPanel jpnView;
    private view.component.LabelGoogleIcon labelGoogleIcon1;
    // End of variables declaration//GEN-END:variables
}
