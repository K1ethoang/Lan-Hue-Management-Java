package view.party;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.optionalusertools.DateHighlightPolicy;
import dao.Dish.DishDAOImpl;
import dao.Party.PartyDAOImpl;
import dao.TypeDish.TypeDishDAOImpl;
import java.sql.Time;
import java.text.DateFormatSymbols;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JScrollBar;
import model.CustomerModel;
import model.DishModel;
import model.PartyModel;
import model.TypeDishModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import utils.Helper;
import view.component.scroll.ScrollBarCus;

/**
 *
 * @author kieth
 */
public class AddPartyMenuView extends javax.swing.JFrame {

    protected static boolean isPartyMenuEdit = false;

    List<CustomerModel> gListCustomer = null;
    List<DishModel> gListDish = DishDAOImpl.getInstance().getList();
    List<TypeDishModel> gListTypeDish = TypeDishDAOImpl.getInstance().getList();
    PartyModel gPartyModel = null;
    CustomerModel gCustomerModel = null;

    DefaultListModel dlmSelectedMenuDish = new DefaultListModel();
//    List<DishModel> gCurrentListMenuDish = null;

    public AddPartyMenuView() {

        initComponents();

        setScrollPane();

        AutoCompleteDecorator.decorate(comboBoxPhoneNumber);
        AutoCompleteDecorator.decorate(comboBoxTypeParty);

        // set dat
        initDateTimeField();
        setComboBoxTypeDish();
    }

    public AddPartyMenuView(PartyModel _partyModel) {
        initComponents();
        setScrollPane();

        AutoCompleteDecorator.decorate(comboBoxPhoneNumber);
        AutoCompleteDecorator.decorate(comboBoxTypeParty);

        // set Data
        initDateTimeField();

        setComboBoxTypeDish();
        setDataSeePartyMenu(_partyModel, isPartyMenuEdit);

    }

    private void initDateTimeField() {
        Locale locale = new Locale("vi");
        // set date

        DatePickerSettings settings = new DatePickerSettings(locale);
        settings.setAllowEmptyDates(false);
        settings.setFormatForDatesCommonEra("EEEE, d MMMM, y");
        settings.setFormatForTodayButton(DateTimeFormatter.ofPattern("d MMMM y", locale));
        TF_date.setSettings(settings);

        // set time
        SP_time.setTimeToNow();

        SP_time.setLocale(Locale.getDefault());

        SP_time.getSettings().setAllowEmptyTimes(false);

        SP_time.getSettings().setDisplaySpinnerButtons(true);

        SP_time.getSettings().setFormatForMenuTimes(DateTimeFormatter.ofPattern("HH:mm", locale));
        SP_time.getSettings().setFormatForDisplayTime(DateTimeFormatter.ofPattern("HH:mm", locale));
    }

    private void setScrollPane() {
        jScrollPane1.setVerticalScrollBar(new ScrollBarCus());
        jScrollPane3.setVerticalScrollBar(new ScrollBarCus());
        ScrollBarCus sb = new ScrollBarCus();
        sb.setOrientation(JScrollBar.HORIZONTAL);
        jScrollPane1.setHorizontalScrollBar(sb);
        jScrollPane3.setVerticalScrollBar(new ScrollBarCus());
    }

    private void setComboBoxTypeDish() {
        CB_typeDish.removeAllItems();
        for (int i = 0; i < gListTypeDish.size(); i++) {
            CB_typeDish.addItem(gListTypeDish.get(i).getTypeName());
        }
    }

    private void setDataSeePartyMenu(PartyModel partyModel, boolean isEdit) {
        if (isEdit) {
            this.setTitle("Chỉnh sửa món ăn");
        } else {
            this.setTitle("Xem món ăn");
        }

        setDataInformationParty(partyModel);

        setFieldEnableInformationParty(false);
        setFieldEnableInformationMenu(isEdit);

        // set btn
        savePartyMenuBtn.setVisible(false);
    }

    private void setDataInformationParty(PartyModel partyModel) {
        TF_partyID.setText(partyModel.getID() + "");
        TF_partyName.setText(partyModel.getPartyName());
        SP_partyNumber.setValue(partyModel.getTableNumber());
        setTimeField(partyModel.getTime());
        setDateField(partyModel.getDate());
        comboBoxTypeParty.addItem(partyModel.getTypeParty().getName());
        comboBoxPhoneNumber.addItem(partyModel.getCustomer().getPhoneNumber());
        TF_nameCustomer.setText(partyModel.getCustomer().getName());
    }

    private void setTimeField(Time time) {
        LocalTime localTime = time.toLocalTime();
        SP_time.setTime(localTime);
    }

    private void setDateField(Date date) {
        LocalDate localDate = Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.of("Asia/Ho_Chi_Minh"))
                .toLocalDate();
        TF_date.setDate(localDate);
    }

    private void setFieldEnableInformationParty(boolean bool) {
        TF_partyName.setEditable(bool);
        SP_partyNumber.setEnabled(bool);
        SP_time.setEnabled(bool);
        TF_date.setEnabled(bool);
        comboBoxPhoneNumber.setEditable(bool);
        TF_nameCustomer.setEditable(bool);
    }

    private void setFieldEnableInformationMenu(boolean bool) {
        CB_typeDish.setEnabled(bool);
        addDishBtn.setEnabled(bool);
        removeDishBtn.setEnabled(bool);
        clearDishBtn.setEnabled(bool);
        menuList.setEnabled(bool);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinField2 = new com.toedter.components.JSpinField();
        jPanel11 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        panelCustomer = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxPhoneNumber = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        TF_nameCustomer = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        center = new javax.swing.JPanel();
        panelLeft1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        TF_partyID = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TF_partyName = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        SP_partyNumber = new javax.swing.JSpinner();
        panelRight1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        comboBoxTypeParty = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        SP_time = new com.github.lgooddatepicker.components.TimePicker();
        jLabel16 = new javax.swing.JLabel();
        TF_date = new com.github.lgooddatepicker.components.DatePicker();
        panelMenu = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menuList = new javax.swing.JList<>();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        CB_typeDish = new javax.swing.JComboBox<>();
        addDishBtn = new javax.swing.JButton();
        removeDishBtn = new javax.swing.JButton();
        clearDishBtn = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        selectedMenuList = new javax.swing.JList<>();
        jPanel10 = new javax.swing.JPanel();
        LB_totalPrice = new javax.swing.JLabel();
        TF_totalPrice = new javax.swing.JFormattedTextField();
        bottom = new javax.swing.JPanel();
        savePartyMenuBtn = new rojeru_san.complementos.RSButtonHover();
        cancelBtn = new rojeru_san.complementos.RSButtonHover();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chọn món ăn");
        setResizable(false);

        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Thông tin khách hàng");
        jPanel1.add(jLabel9);

        jPanel2.add(jPanel1);

        panelCustomer.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panelCustomer.setLayout(new java.awt.GridLayout(2, 2, 0, 10));

        jLabel6.setText("SĐT liên hệ (*)");
        panelCustomer.add(jLabel6);

        comboBoxPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxPhoneNumberActionPerformed(evt);
            }
        });
        panelCustomer.add(comboBoxPhoneNumber);

        jLabel5.setText("Khách hàng (*)");
        panelCustomer.add(jLabel5);

        TF_nameCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_nameCustomerActionPerformed(evt);
            }
        });
        panelCustomer.add(TF_nameCustomer);

        jPanel2.add(panelCustomer);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Thông tin tiệc");
        jPanel3.add(jLabel11);

        jPanel2.add(jPanel3);

        center.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 10, 0));
        center.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        panelLeft1.setLayout(new java.awt.GridLayout(3, 2, 0, 10));

        jLabel8.setText("ID");
        panelLeft1.add(jLabel8);

        TF_partyID.setEditable(false);
        TF_partyID.setText("0");
        TF_partyID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_partyIDActionPerformed(evt);
            }
        });
        panelLeft1.add(TF_partyID);

        jLabel12.setText("Tên tiệc (*)");
        panelLeft1.add(jLabel12);

        TF_partyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_partyNameActionPerformed(evt);
            }
        });
        panelLeft1.add(TF_partyName);

        jLabel13.setText("Số bàn (*)");
        panelLeft1.add(jLabel13);

        SP_partyNumber.setEditor(new javax.swing.JSpinner.NumberEditor(SP_partyNumber, ""));
        SP_partyNumber.setValue(2);
        SP_partyNumber.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SP_partyNumberStateChanged(evt);
            }
        });
        panelLeft1.add(SP_partyNumber);

        center.add(panelLeft1);

        panelRight1.setLayout(new java.awt.GridLayout(3, 2, 0, 10));

        jLabel14.setText("Loại tiệc (*)");
        panelRight1.add(jLabel14);

        comboBoxTypeParty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTypePartyActionPerformed(evt);
            }
        });
        panelRight1.add(comboBoxTypeParty);

        jLabel15.setText("Thời gian (*)");
        panelRight1.add(jLabel15);
        panelRight1.add(SP_time);

        jLabel16.setText("Ngày (*)");
        panelRight1.add(jLabel16);
        panelRight1.add(TF_date);

        center.add(panelRight1);

        jPanel2.add(center);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 885, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(panelMenu);
        jPanel2.add(jSeparator1);

        jPanel11.add(jPanel2);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setPreferredSize(new java.awt.Dimension(360, 260));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.Y_AXIS));

        menuList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        menuList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(menuList);

        jPanel6.add(jScrollPane1);

        jPanel5.add(jPanel6, java.awt.BorderLayout.WEST);

        jPanel9.setPreferredSize(new java.awt.Dimension(169, 191));

        CB_typeDish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_typeDishActionPerformed(evt);
            }
        });

        addDishBtn.setText("Thêm >>");
        addDishBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDishBtnActionPerformed(evt);
            }
        });

        removeDishBtn.setText("<< Xóa");
        removeDishBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDishBtnActionPerformed(evt);
            }
        });

        clearDishBtn.setText("Xóa tất cả");
        clearDishBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearDishBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(clearDishBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeDishBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addDishBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addComponent(CB_typeDish, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(CB_typeDish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(addDishBtn)
                .addGap(18, 18, 18)
                .addComponent(removeDishBtn)
                .addGap(18, 18, 18)
                .addComponent(clearDishBtn)
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel8.setPreferredSize(new java.awt.Dimension(360, 260));
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.Y_AXIS));

        selectedMenuList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        selectedMenuList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane3.setViewportView(selectedMenuList);

        jPanel8.add(jScrollPane3);

        jPanel10.setMinimumSize(new java.awt.Dimension(117, 10));
        jPanel10.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel10.setRequestFocusEnabled(false);

        LB_totalPrice.setText("Tổng: ");
        LB_totalPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        TF_totalPrice.setEditable(false);
        TF_totalPrice.setText("0");
        TF_totalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_totalPriceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LB_totalPrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TF_totalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LB_totalPrice)
                    .addComponent(TF_totalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel8.add(jPanel10);

        jPanel5.add(jPanel8, java.awt.BorderLayout.EAST);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel11.add(jPanel4);

        bottom.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        savePartyMenuBtn.setBackground(new java.awt.Color(10, 77, 104));
        savePartyMenuBtn.setText("Lưu");
        savePartyMenuBtn.setColorHover(new java.awt.Color(14, 112, 152));
        savePartyMenuBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        savePartyMenuBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        savePartyMenuBtn.setPreferredSize(new java.awt.Dimension(110, 40));
        savePartyMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePartyMenuBtnActionPerformed(evt);
            }
        });
        bottom.add(savePartyMenuBtn);

        cancelBtn.setBackground(new java.awt.Color(10, 77, 104));
        cancelBtn.setText("Hủy");
        cancelBtn.setColorHover(new java.awt.Color(14, 112, 152));
        cancelBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelBtn.setPreferredSize(new java.awt.Dimension(110, 40));
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        bottom.add(cancelBtn);

        jPanel11.add(bottom);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void savePartyMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePartyMenuBtnActionPerformed
        System.out.println(PartyDAOImpl.getInstance().insert(gPartyModel));
    }//GEN-LAST:event_savePartyMenuBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

//    private double calculatingTotalPriceSelectedDish(double beforeSum, int indexCurrentOfMenuList, boolean isAdd) {
//        double newSum = 0;
//        DishModel dish = gCurrentListMenuDish.get(indexCurrentOfMenuList);
//        if (isAdd) {
//            newSum = beforeSum + dish.getPrice();
//        } else {
//            newSum = beforeSum - dish.getPrice();
//        }
//        return newSum;
//    }

    private void CB_typeDishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_typeDishActionPerformed
        String curTypeDish = (String) CB_typeDish.getSelectedItem();
        DefaultListModel dlmMenuDish = new DefaultListModel();
//        gCurrentListMenuDish.clear();

        for (int i = 0; i < gListDish.size(); i++) {
            DishModel dish = gListDish.get(i);
            if (curTypeDish.equals(dish.getTypeDish().getTypeName())) {
//                gCurrentListMenuDish.add(dish);
                dlmMenuDish.addElement(dish.getDishName() + " - " + Helper.formatPriceToDisplay(dish.getPrice()));

            }
        }
        menuList.setModel(dlmMenuDish);
    }//GEN-LAST:event_CB_typeDishActionPerformed

    private void removeDishBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeDishBtnActionPerformed
        int index = selectedMenuList.getSelectedIndex();
        if (index >= 0) {
            dlmSelectedMenuDish.removeElementAt(index);
            selectedMenuList.setModel(dlmSelectedMenuDish);
        }
    }//GEN-LAST:event_removeDishBtnActionPerformed


    private void addDishBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDishBtnActionPerformed
        int index = menuList.getSelectedIndex();
        if (index >= 0) {
            dlmSelectedMenuDish.addElement(menuList.getSelectedValue());
            selectedMenuList.setModel(dlmSelectedMenuDish);
        }
        System.out.println(selectedMenuList.getModel());

    }//GEN-LAST:event_addDishBtnActionPerformed

    private void clearDishBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDishBtnActionPerformed
        dlmSelectedMenuDish.clear();
        selectedMenuList.setModel(dlmSelectedMenuDish);
    }//GEN-LAST:event_clearDishBtnActionPerformed

    private void TF_totalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_totalPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_totalPriceActionPerformed

    private void comboBoxTypePartyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTypePartyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxTypePartyActionPerformed

    private void SP_partyNumberStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SP_partyNumberStateChanged
        int number = (int) SP_partyNumber.getValue();
        if (number < 2) {
            SP_partyNumber.setValue(2);
        }
    }//GEN-LAST:event_SP_partyNumberStateChanged

    private void TF_partyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_partyNameActionPerformed
        //
    }//GEN-LAST:event_TF_partyNameActionPerformed

    private void TF_partyIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_partyIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_partyIDActionPerformed

    private void TF_nameCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_nameCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_nameCustomerActionPerformed

    private void comboBoxPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxPhoneNumberActionPerformed
        if (gListCustomer != null) {
            gCustomerModel = gListCustomer.get(comboBoxPhoneNumber.getSelectedIndex());
            TF_nameCustomer.setText(gCustomerModel.getName());
        }
    }//GEN-LAST:event_comboBoxPhoneNumberActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AddPartyMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPartyMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPartyMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPartyMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPartyMenuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_typeDish;
    private javax.swing.JLabel LB_totalPrice;
    private javax.swing.JSpinner SP_partyNumber;
    private com.github.lgooddatepicker.components.TimePicker SP_time;
    private com.github.lgooddatepicker.components.DatePicker TF_date;
    private javax.swing.JTextField TF_nameCustomer;
    private javax.swing.JTextField TF_partyID;
    private javax.swing.JTextField TF_partyName;
    private javax.swing.JFormattedTextField TF_totalPrice;
    private javax.swing.JButton addDishBtn;
    private javax.swing.JPanel bottom;
    private rojeru_san.complementos.RSButtonHover cancelBtn;
    private javax.swing.JPanel center;
    private javax.swing.JButton clearDishBtn;
    private javax.swing.JComboBox<String> comboBoxPhoneNumber;
    private javax.swing.JComboBox<String> comboBoxTypeParty;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.components.JSpinField jSpinField2;
    private javax.swing.JList<String> menuList;
    private javax.swing.JPanel panelCustomer;
    private javax.swing.JPanel panelLeft1;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelRight1;
    private javax.swing.JButton removeDishBtn;
    private rojeru_san.complementos.RSButtonHover savePartyMenuBtn;
    private javax.swing.JList<String> selectedMenuList;
    // End of variables declaration//GEN-END:variables
}
