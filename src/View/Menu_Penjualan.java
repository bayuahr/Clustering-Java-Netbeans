/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author neubr
 */
public class Menu_Penjualan extends javax.swing.JPanel {

    public class Produk {

        private int id;
        private String nama;
        private int harga;

        public Produk(int id, String nama, int harga) {
            this.id = id;
            this.nama = nama;
            this.harga = harga;
        }

        public int getId() {
            return id;
        }

        public String getNama() {
            return nama;
        }

        public int getHarga() {
            return harga;
        }

        // Ini supaya yang tampil di combobox adalah nama kategori
        @Override
        public String toString() {
            return nama;
        }
    }

    Connection conn = controller.koneksi.getKoneksi();
    ResultSet rs = null;
    PreparedStatement pst = null;
    int xx, xy;
    private DefaultTableModel tabmode;
    String Lokasi;
    Object[] Baris = {"Id Penjualan", "Nama Produk", "Tanggal", "Qty", "Total"};

    public Menu_Penjualan() {
        initComponents();
        Locale locale = new Locale("id", "ID");
        Locale.setDefault(locale);
        try {
            String sql = "SELECT * FROM produk order by id_produk asc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);

            cbProduk.removeAllItems();

            while (hasil.next()) {
                int id = hasil.getInt(1);     // id
                String nama = hasil.getString(3);   // nama
                int harga = hasil.getInt(4);

                Menu_Penjualan.Produk kat = new Menu_Penjualan.Produk(id, nama, harga);
                cbProduk.addItem(kat);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil: " + e);
        }
        kosong();
        aktif();
        datatable();
    }

    private static Connection koneksi;

    public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
                String url;
                url = "jdbc:mysql://localhost:3306/clustering_java";
                String username = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, username, password);
            } catch (SQLException t) {
                JOptionPane.showMessageDialog(null, "error koneksi");
            }
        }
        return koneksi;
    }

    static Object getConnection() {
        throw new UnsupportedOperationException("Not yet implementation");
    }

    protected void aktif() {
        cbProduk.requestFocus();
        tabmode = new DefaultTableModel(null, Baris);
        tabelpenjualan.setModel(tabmode);
    }

    protected void kosong() {
        txtIdPenjualan.setText("");
        cbProduk.setSelectedIndex(0);
        txtTanggal.setText("");
        txtHarga.setText("");
        txtQry.setText("");
        txtTotal.setText("");
    }

    protected void datatable() {
        Object[] Baris = {"Id Penjualan", "Nama Produk", "Tanggal", "Qty", "Total"};
        tabmode = new DefaultTableModel(null, Baris);
        String cariitem = txcari.getText();

        try {
            String sql = "select id_penjualan,p.nama_produk,tanggal,qty,total from penjualan pe inner join produk p on p.id_produk = pe.id_produk  "
                    + "where p.nama_produk like '%" + cariitem + "%' order by id_penjualan asc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                tabmode.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5),});
            }
            tabelpenjualan.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrp_Jeniskelamin = new javax.swing.ButtonGroup();
        dateChooser1 = new com.raven.datechooser.DateChooser();
        dateChooser2 = new com.raven.datechooser.DateChooser();
        pn_Main = new javax.swing.JPanel();
        pn_View = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelpenjualan = new Custom.Custom_JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_firstpage = new Custom.Custom_JButtonRounded();
        btn_before = new Custom.Custom_JButtonRounded();
        btn_after = new Custom.Custom_JButtonRounded();
        btn_lastpage = new Custom.Custom_JButtonRounded();
        cb_halaman = new Custom.Custom_JComboBox();
        jLabel4 = new javax.swing.JLabel();
        custom_JButtonRounded1 = new Custom.Custom_JButtonRounded();
        bhapus = new Custom.Custom_JButtonRounded();
        custom_JButtonRounded3 = new Custom.Custom_JButtonRounded();
        txcari = new Custom.Custom_JTextFieldRounded();
        jLabel2 = new javax.swing.JLabel();
        bcari = new Custom.Custom_JButtonRounded();
        custom_JButtonRounded4 = new Custom.Custom_JButtonRounded();
        pn_Add = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        bsimpan = new Custom.Custom_JButtonRounded();
        custom_JButtonRounded6 = new Custom.Custom_JButtonRounded();
        txtIdPenjualan = new Custom.Custom_JTextFieldRounded();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtTanggal = new Custom.Custom_JTextFieldRounded();
        jLabel17 = new javax.swing.JLabel();
        txtHarga = new Custom.Custom_JTextFieldRounded();
        jLabel18 = new javax.swing.JLabel();
        txtQry = new Custom.Custom_JTextFieldRounded();
        jLabel19 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new Custom.Custom_JTextFieldRounded();
        cbProduk = new Custom.Custom_JComboBox();

        dateChooser1.setTextRefernce(txtTanggal);

        setLayout(new java.awt.CardLayout());

        pn_Main.setBackground(new java.awt.Color(255, 255, 255));
        pn_Main.setPreferredSize(new java.awt.Dimension(1028, 658));
        pn_Main.setLayout(new java.awt.CardLayout());

        pn_View.setBackground(new java.awt.Color(255, 255, 255));
        pn_View.setPreferredSize(new java.awt.Dimension(1028, 658));

        tabelpenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelpenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelpenjualanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelpenjualan);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Data Daftar Penjualan");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btn_firstpage.setBackground(new java.awt.Color(255, 0, 0));
        btn_firstpage.setForeground(new java.awt.Color(255, 255, 255));
        btn_firstpage.setText("First Page");
        btn_firstpage.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        btn_firstpage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstpageActionPerformed(evt);
            }
        });

        btn_before.setBackground(new java.awt.Color(255, 0, 0));
        btn_before.setForeground(new java.awt.Color(255, 255, 255));
        btn_before.setText("<");
        btn_before.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        btn_before.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_beforeActionPerformed(evt);
            }
        });

        btn_after.setBackground(new java.awt.Color(255, 0, 0));
        btn_after.setForeground(new java.awt.Color(255, 255, 255));
        btn_after.setText(">");
        btn_after.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        btn_after.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_afterActionPerformed(evt);
            }
        });

        btn_lastpage.setBackground(new java.awt.Color(255, 0, 0));
        btn_lastpage.setForeground(new java.awt.Color(255, 255, 255));
        btn_lastpage.setText("Last Page");
        btn_lastpage.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        btn_lastpage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastpageActionPerformed(evt);
            }
        });

        cb_halaman.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cb_halaman.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "8", "16", "32", "64" }));
        cb_halaman.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel4.setText("Halaman of halaman");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addComponent(btn_firstpage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_before, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_halaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_after, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_lastpage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(341, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(442, 442, 442))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_halaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_after, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_before, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_firstpage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_lastpage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        custom_JButtonRounded1.setBackground(new java.awt.Color(0, 153, 255));
        custom_JButtonRounded1.setForeground(new java.awt.Color(255, 255, 255));
        custom_JButtonRounded1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Add.png"))); // NOI18N
        custom_JButtonRounded1.setText("TAMBAH");
        custom_JButtonRounded1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        custom_JButtonRounded1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custom_JButtonRounded1ActionPerformed(evt);
            }
        });

        bhapus.setBackground(new java.awt.Color(255, 204, 0));
        bhapus.setForeground(new java.awt.Color(255, 255, 255));
        bhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Delete.png"))); // NOI18N
        bhapus.setText("HAPUS");
        bhapus.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        custom_JButtonRounded3.setBackground(new java.awt.Color(0, 204, 153));
        custom_JButtonRounded3.setForeground(new java.awt.Color(255, 255, 255));
        custom_JButtonRounded3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Cancel.png"))); // NOI18N
        custom_JButtonRounded3.setText("BATAL");
        custom_JButtonRounded3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        custom_JButtonRounded3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custom_JButtonRounded3ActionPerformed(evt);
            }
        });

        txcari.setForeground(new java.awt.Color(102, 102, 102));
        txcari.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        txcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txcariActionPerformed(evt);
            }
        });
        txcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txcariKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Master Data > Penjualan");
        jLabel2.setPreferredSize(new java.awt.Dimension(176, 19));

        bcari.setBackground(new java.awt.Color(255, 102, 102));
        bcari.setForeground(new java.awt.Color(255, 255, 255));
        bcari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Cancel.png"))); // NOI18N
        bcari.setText("CARI");
        bcari.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });

        custom_JButtonRounded4.setBackground(new java.awt.Color(153, 153, 153));
        custom_JButtonRounded4.setForeground(new java.awt.Color(255, 255, 255));
        custom_JButtonRounded4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cetakputih.png"))); // NOI18N
        custom_JButtonRounded4.setText("CETAK");
        custom_JButtonRounded4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        custom_JButtonRounded4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custom_JButtonRounded4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_ViewLayout = new javax.swing.GroupLayout(pn_View);
        pn_View.setLayout(pn_ViewLayout);
        pn_ViewLayout.setHorizontalGroup(
            pn_ViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ViewLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pn_ViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_ViewLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_ViewLayout.createSequentialGroup()
                        .addComponent(custom_JButtonRounded1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(custom_JButtonRounded3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(custom_JButtonRounded4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                        .addComponent(txcari, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addComponent(jScrollPane1))
                .addGap(20, 20, 20))
        );
        pn_ViewLayout.setVerticalGroup(
            pn_ViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ViewLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pn_ViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(pn_ViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(custom_JButtonRounded1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bhapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(custom_JButtonRounded3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txcari, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(custom_JButtonRounded4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        pn_Main.add(pn_View, "card2");

        pn_Add.setBackground(new java.awt.Color(255, 255, 255));
        pn_Add.setPreferredSize(new java.awt.Dimension(1028, 658));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Tambah Data Penjualan");

        bsimpan.setBackground(new java.awt.Color(0, 153, 255));
        bsimpan.setForeground(new java.awt.Color(255, 255, 255));
        bsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Save.png"))); // NOI18N
        bsimpan.setText("SIMPAN");
        bsimpan.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        custom_JButtonRounded6.setBackground(new java.awt.Color(0, 204, 153));
        custom_JButtonRounded6.setForeground(new java.awt.Color(255, 255, 255));
        custom_JButtonRounded6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Cancel.png"))); // NOI18N
        custom_JButtonRounded6.setText("BATAL");
        custom_JButtonRounded6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        custom_JButtonRounded6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custom_JButtonRounded6ActionPerformed(evt);
            }
        });

        txtIdPenjualan.setForeground(new java.awt.Color(102, 102, 102));
        txtIdPenjualan.setEnabled(false);
        txtIdPenjualan.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        txtIdPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdPenjualanActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Id Penjualan");

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Produk");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Tanggal");

        txtTanggal.setForeground(new java.awt.Color(102, 102, 102));
        txtTanggal.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        txtTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTanggalActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Harga");

        txtHarga.setForeground(new java.awt.Color(102, 102, 102));
        txtHarga.setEnabled(false);
        txtHarga.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        txtHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Qty");

        txtQry.setForeground(new java.awt.Color(102, 102, 102));
        txtQry.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        txtQry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQryActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Total");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Master Data > Penjualan");

        txtTotal.setForeground(new java.awt.Color(102, 102, 102));
        txtTotal.setEnabled(false);
        txtTotal.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        cbProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProdukActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_AddLayout = new javax.swing.GroupLayout(pn_Add);
        pn_Add.setLayout(pn_AddLayout);
        pn_AddLayout.setHorizontalGroup(
            pn_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_AddLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pn_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_AddLayout.createSequentialGroup()
                        .addGroup(pn_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel16)
                            .addGroup(pn_AddLayout.createSequentialGroup()
                                .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(custom_JButtonRounded6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13))
                        .addContainerGap(786, Short.MAX_VALUE))
                    .addGroup(pn_AddLayout.createSequentialGroup()
                        .addGroup(pn_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_AddLayout.createSequentialGroup()
                        .addGroup(pn_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbProduk, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTanggal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHarga, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIdPenjualan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtQry, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pn_AddLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 600, Short.MAX_VALUE)
                                .addComponent(jLabel6)))
                        .addGap(20, 20, 20))))
        );
        pn_AddLayout.setVerticalGroup(
            pn_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_AddLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pn_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addGroup(pn_AddLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(pn_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(bsimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(custom_JButtonRounded6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQry, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        pn_Main.add(pn_Add, "card2");

        add(pn_Main, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btn_firstpageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstpageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_firstpageActionPerformed

    private void btn_beforeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_beforeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_beforeActionPerformed

    private void btn_afterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_afterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_afterActionPerformed

    private void btn_lastpageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastpageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_lastpageActionPerformed

    private void custom_JButtonRounded1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custom_JButtonRounded1ActionPerformed
        pn_Main.removeAll();
        pn_Main.add(pn_Add);
        pn_Main.repaint();
        pn_Main.revalidate();
    }//GEN-LAST:event_custom_JButtonRounded1ActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "hapus", "konfirmasidialog", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String sql = "delete from penjualan where id_penjualan='" + txtIdPenjualan.getText() + "'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong();
                txtIdPenjualan.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "data gagal dihapus" + e);
            }
            datatable();
        }
    }//GEN-LAST:event_bhapusActionPerformed

    private void custom_JButtonRounded3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custom_JButtonRounded3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custom_JButtonRounded3ActionPerformed

    private void txcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txcariActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        String sql = "insert into penjualan values (null,?,?,?,?)";
        try {
            int idProduk = 1;
            Produk selectedKategori = (Produk) cbProduk.getSelectedItem();

            if (selectedKategori != null) {
                idProduk = selectedKategori.getId();
            }
            SimpleDateFormat sdfInput = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdfInput.parse(txtTanggal.getText());
            String mysqlDate = sdfOutput.format(date);
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, idProduk);
            stat.setString(2,mysqlDate);
            stat.setInt(3, Integer.parseInt(txtQry.getText()));
            stat.setInt(4, Integer.parseInt(txtTotal.getText()));

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            kosong();
            cbProduk.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal disimpan" + e);
        } catch (ParseException ex) {
            Logger.getLogger(Menu_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
        datatable();

    }//GEN-LAST:event_bsimpanActionPerformed

    private void custom_JButtonRounded6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custom_JButtonRounded6ActionPerformed
        pn_Main.removeAll();
        pn_Main.add(pn_View);
        pn_Main.repaint();
        pn_Main.revalidate();
    }//GEN-LAST:event_custom_JButtonRounded6ActionPerformed

    private void txtIdPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPenjualanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdPenjualanActionPerformed

    private void txtTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTanggalActionPerformed

    private void txtHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaActionPerformed

    private void txtQryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQryActionPerformed
        int harga = Integer.parseInt(txtHarga.getText());
        int qty = Integer.parseInt(txtQry.getText());
        txtTotal.setText(String.valueOf(harga * qty));
    }//GEN-LAST:event_txtQryActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        datatable();
    }//GEN-LAST:event_bcariActionPerformed

    private void txcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txcariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            datatable();
        }
    }//GEN-LAST:event_txcariKeyPressed

    private void tabelpenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpenjualanMouseClicked
        int bar = tabelpenjualan.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();

        txtIdPenjualan.setText(a);
        txtTanggal.setText(c);
        txtQry.setText(d);
        txtTotal.setText(e);
        datatable();
    }//GEN-LAST:event_tabelpenjualanMouseClicked

    private void custom_JButtonRounded4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custom_JButtonRounded4ActionPerformed
        try {
            // Path file jrxml dan jasper
            String jrxmlPath = "./src/Report/reportpenjualan.jrxml";
            String jasperPath = "./src/Report/reportpenjualan.jasper";

            // Compile jrxml ke jasper (auto jika ada perubahan)
            JasperCompileManager.compileReportToFile(jrxmlPath, jasperPath);

            // Parameter untuk report (kosong kalau tidak ada)
            HashMap<String, Object> parameter = new HashMap<>();
            parameter.put("IMAGE_PATH", "./src/Image/Kopken.png"); // relative path

            // Isi laporan dengan data dari koneksi database
            JasperPrint print = JasperFillManager.fillReport(jasperPath, parameter, conn);

            // Tampilkan report
            JasperViewer.viewReport(print, false);

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Gagal membuat laporan: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_custom_JButtonRounded4ActionPerformed

    private void cbProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProdukActionPerformed
        // TODO add your handling code here:
        Produk selectedKategori = (Produk) cbProduk.getSelectedItem();

        if (selectedKategori != null) {
            txtHarga.setText(String.valueOf(selectedKategori.getHarga()));
        }
    }//GEN-LAST:event_cbProdukActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.Custom_JButtonRounded bcari;
    private Custom.Custom_JButtonRounded bhapus;
    private Custom.Custom_JButtonRounded bsimpan;
    private Custom.Custom_JButtonRounded btn_after;
    private Custom.Custom_JButtonRounded btn_before;
    private Custom.Custom_JButtonRounded btn_firstpage;
    private Custom.Custom_JButtonRounded btn_lastpage;
    private javax.swing.ButtonGroup btngrp_Jeniskelamin;
    private Custom.Custom_JComboBox cbProduk;
    private Custom.Custom_JComboBox cb_halaman;
    private Custom.Custom_JButtonRounded custom_JButtonRounded1;
    private Custom.Custom_JButtonRounded custom_JButtonRounded3;
    private Custom.Custom_JButtonRounded custom_JButtonRounded4;
    private Custom.Custom_JButtonRounded custom_JButtonRounded6;
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pn_Add;
    private javax.swing.JPanel pn_Main;
    private javax.swing.JPanel pn_View;
    private Custom.Custom_JTable tabelpenjualan;
    private Custom.Custom_JTextFieldRounded txcari;
    private Custom.Custom_JTextFieldRounded txtHarga;
    private Custom.Custom_JTextFieldRounded txtIdPenjualan;
    private Custom.Custom_JTextFieldRounded txtQry;
    private Custom.Custom_JTextFieldRounded txtTanggal;
    private Custom.Custom_JTextFieldRounded txtTotal;
    // End of variables declaration//GEN-END:variables
}
