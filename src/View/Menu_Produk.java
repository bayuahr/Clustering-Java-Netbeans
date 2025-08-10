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
import java.util.HashMap;
import java.util.Locale;
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
public class Menu_Produk extends javax.swing.JPanel {

    Connection conn = controller.koneksi.getKoneksi();
    ResultSet rs = null;
    PreparedStatement pst = null;
    int xx, xy;
    private DefaultTableModel tabmode;
    String Lokasi;
    Object[] Baris = {"Id Produk", "Id Kategori", "Nama Kategori", "Nama Produk", "Harga", "Stok","Rating"};

    public class Kategori {

        private int id;
        private String nama;

        public Kategori(int id, String nama) {
            this.id = id;
            this.nama = nama;
        }

        public int getId() {
            return id;
        }

        public String getNama() {
            return nama;
        }

        // Ini supaya yang tampil di combobox adalah nama kategori
        @Override
        public String toString() {
            return nama;
        }
    }

    /**
     * Creates new form Menu_Dashboard
     */
    public Menu_Produk() {
        initComponents();
        Locale locale = new Locale("id", "ID");
        Locale.setDefault(locale);
        try {
            String sql = "SELECT * FROM kategori_produk order by id_kategori asc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);

            cbKategori.removeAllItems();

            while (hasil.next()) {
                int id = hasil.getInt(1);     // id_kategori
                String nama = hasil.getString(2);   // nama kategori
                Kategori kat = new Kategori(id, nama);
                cbKategori.addItem(kat);
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
        cbKategori.requestFocus();
        tabmode = new DefaultTableModel(null, Baris);
        tabelproduk.setModel(tabmode);
    }

    protected void kosong() {

        txtIdProduk.setText("");
        cbKategori.setSelectedIndex(0);
        txtNamaProduk.setText("");
        txtHargaProduk.setText("");
        txtStok.setText("");
        txtRating.setText("");
    }

    protected void datatable() {
        Object[] Baris = {"Id Produk", "Id Kategori", "Nama Kategori", "Nama Produk", "Harga", "Stok"};
        tabmode = new DefaultTableModel(null, Baris);
        String cariitem = cari.getText();

        try {
            String sql = "SELECT id_produk,k.id_kategori,k.nama_kategori,p.nama_produk,p.harga,p.stok,rating FROM produk p inner join kategori_produk k"
                    + " on p.id_kategori = k.id_kategori where nama_produk like '%" + cariitem + "%' or nama_kategori like'%" + cariitem + "%' "
                    + "order by id_produk asc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                tabmode.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5),
                    hasil.getString(6),
                    hasil.getString(7),});
            }
            tabelproduk.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrp_Jeniskelamin = new javax.swing.ButtonGroup();
        pn_Main = new javax.swing.JPanel();
        pn_View = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelproduk = new Custom.Custom_JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_firstpage = new Custom.Custom_JButtonRounded();
        btn_before = new Custom.Custom_JButtonRounded();
        btn_after = new Custom.Custom_JButtonRounded();
        btn_lastpage = new Custom.Custom_JButtonRounded();
        cb_halaman = new Custom.Custom_JComboBox();
        jLabel4 = new javax.swing.JLabel();
        btnTambah = new Custom.Custom_JButtonRounded();
        btnHapus = new Custom.Custom_JButtonRounded();
        btnBatal = new Custom.Custom_JButtonRounded();
        cari = new Custom.Custom_JTextFieldRounded();
        jLabel2 = new javax.swing.JLabel();
        btncari = new Custom.Custom_JButtonRounded();
        Ctak = new Custom.Custom_JButtonRounded();
        pn_Add = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnSimpan = new Custom.Custom_JButtonRounded();
        custom_JButtonRounded6 = new Custom.Custom_JButtonRounded();
        jLabel13 = new javax.swing.JLabel();
        txtNamaProduk = new Custom.Custom_JTextFieldRounded();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbKategori = new Custom.Custom_JComboBox();
        jLabel17 = new javax.swing.JLabel();
        txtStok = new Custom.Custom_JTextFieldRounded();
        jLabel15 = new javax.swing.JLabel();
        txtIdProduk = new Custom.Custom_JTextFieldRounded();
        txtHargaProduk = new Custom.Custom_JTextFieldRounded();
        jLabel18 = new javax.swing.JLabel();
        txtRating = new Custom.Custom_JTextFieldRounded();

        setLayout(new java.awt.CardLayout());

        pn_Main.setBackground(new java.awt.Color(255, 255, 255));
        pn_Main.setPreferredSize(new java.awt.Dimension(1028, 658));
        pn_Main.setLayout(new java.awt.CardLayout());

        pn_View.setBackground(new java.awt.Color(255, 255, 255));
        pn_View.setPreferredSize(new java.awt.Dimension(1028, 658));

        tabelproduk.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelproduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelprodukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelproduk);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Data Daftar Produk");

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
                .addContainerGap(339, Short.MAX_VALUE))
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

        btnTambah.setBackground(new java.awt.Color(0, 153, 255));
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Add.png"))); // NOI18N
        btnTambah.setText("TAMBAH");
        btnTambah.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(255, 204, 0));
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Delete.png"))); // NOI18N
        btnHapus.setText("HAPUS");
        btnHapus.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setBackground(new java.awt.Color(0, 204, 153));
        btnBatal.setForeground(new java.awt.Color(255, 255, 255));
        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Cancel.png"))); // NOI18N
        btnBatal.setText("BATAL");
        btnBatal.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        cari.setForeground(new java.awt.Color(102, 102, 102));
        cari.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Master Data > Produk");
        jLabel2.setPreferredSize(new java.awt.Dimension(176, 19));

        btncari.setBackground(new java.awt.Color(255, 102, 102));
        btncari.setForeground(new java.awt.Color(255, 255, 255));
        btncari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Cancel.png"))); // NOI18N
        btncari.setText("CARI");
        btncari.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        Ctak.setBackground(new java.awt.Color(153, 153, 153));
        Ctak.setForeground(new java.awt.Color(255, 255, 255));
        Ctak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cetakputih.png"))); // NOI18N
        Ctak.setText("CETAK");
        Ctak.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        Ctak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CtakActionPerformed(evt);
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
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Ctak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btncari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
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
                    .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ctak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        pn_Main.add(pn_View, "card2");

        pn_Add.setBackground(new java.awt.Color(255, 255, 255));
        pn_Add.setPreferredSize(new java.awt.Dimension(1028, 658));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Tambah Data Produk");

        btnSimpan.setBackground(new java.awt.Color(0, 153, 255));
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Save.png"))); // NOI18N
        btnSimpan.setText("SIMPAN");
        btnSimpan.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
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

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Kategori");

        txtNamaProduk.setForeground(new java.awt.Color(102, 102, 102));
        txtNamaProduk.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        txtNamaProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaProdukActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Nama Produk");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Harga Produk");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Master Data > Produk");

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Stok");

        txtStok.setForeground(new java.awt.Color(102, 102, 102));
        txtStok.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        txtStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStokActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Id Produk");

        txtIdProduk.setForeground(new java.awt.Color(102, 102, 102));
        txtIdProduk.setEnabled(false);
        txtIdProduk.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        txtIdProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProdukActionPerformed(evt);
            }
        });

        txtHargaProduk.setForeground(new java.awt.Color(102, 102, 102));
        txtHargaProduk.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        txtHargaProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaProdukActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Rating");

        txtRating.setForeground(new java.awt.Color(102, 102, 102));
        txtRating.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        txtRating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRatingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_AddLayout = new javax.swing.GroupLayout(pn_Add);
        pn_Add.setLayout(pn_AddLayout);
        pn_AddLayout.setHorizontalGroup(
            pn_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_AddLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pn_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRating, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtHargaProduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdProduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_AddLayout.createSequentialGroup()
                        .addGroup(pn_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(pn_AddLayout.createSequentialGroup()
                                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(custom_JButtonRounded6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(pn_AddLayout.createSequentialGroup()
                        .addGroup(pn_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNamaProduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_AddLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 645, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addComponent(cbKategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pn_AddLayout.createSequentialGroup()
                                .addGroup(pn_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(20, 20, 20))
                    .addComponent(txtStok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_AddLayout.createSequentialGroup()
                        .addGroup(pn_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(jLabel15))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pn_AddLayout.setVerticalGroup(
            pn_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_AddLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pn_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_AddLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(pn_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(custom_JButtonRounded6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtIdProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(txtHargaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRating, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
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

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        pn_Main.removeAll();
        pn_Main.add(pn_Add);
        pn_Main.repaint();
        pn_Main.revalidate();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "hapus", "konfirmasidialog", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String sql = "delete from produk where id_produk ='" + txtIdProduk.getText() + "'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong();
                cbKategori.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "data gagal dihapus" + e);
            }
            datatable();
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBatalActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String sql = "insert into produk values (null,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            Kategori selectedKategori = (Kategori) cbKategori.getSelectedItem();
            int idKategori = 1;
            if (selectedKategori != null) {
                idKategori = selectedKategori.getId();
            }

            stat.setInt(1, idKategori);
            stat.setString(2, txtNamaProduk.getText());
            stat.setInt(3, Integer.parseInt(txtHargaProduk.getText()));
            stat.setInt(4, Integer.parseInt(txtStok.getText()));
            stat.setDouble(5, Double.parseDouble(txtRating.getText()));

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            kosong();
            cbKategori.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal disimpan" + e);
        }
        datatable();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void custom_JButtonRounded6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custom_JButtonRounded6ActionPerformed
        pn_Main.removeAll();
        pn_Main.add(pn_View);
        pn_Main.repaint();
        pn_Main.revalidate();
    }//GEN-LAST:event_custom_JButtonRounded6ActionPerformed

    private void txtNamaProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaProdukActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        datatable();
    }//GEN-LAST:event_btncariActionPerformed

    private void cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            datatable();
        }
    }//GEN-LAST:event_cariKeyPressed

    private void tabelprodukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelprodukMouseClicked
        int bar = tabelproduk.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();

        txtIdProduk.setText(a);
        cbKategori.setSelectedItem(b);
        txtNamaProduk.setText(c);
        txtHargaProduk.setText(d);
        txtStok.setText(e);
        txtRating.setText(e);
        datatable();
    }//GEN-LAST:event_tabelprodukMouseClicked

    private void CtakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CtakActionPerformed
        try {
            // Path file jrxml dan jasper
            String jrxmlPath = "./src/Report/reportproduk.jrxml";
            String jasperPath = "./src/Report/reportproduk.jasper";

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
    }//GEN-LAST:event_CtakActionPerformed

    private void txtStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStokActionPerformed

    private void txtIdProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProdukActionPerformed

    private void txtHargaProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaProdukActionPerformed

    private void txtRatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRatingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRatingActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.Custom_JButtonRounded Ctak;
    private Custom.Custom_JButtonRounded btnBatal;
    private Custom.Custom_JButtonRounded btnHapus;
    private Custom.Custom_JButtonRounded btnSimpan;
    private Custom.Custom_JButtonRounded btnTambah;
    private Custom.Custom_JButtonRounded btn_after;
    private Custom.Custom_JButtonRounded btn_before;
    private Custom.Custom_JButtonRounded btn_firstpage;
    private Custom.Custom_JButtonRounded btn_lastpage;
    private Custom.Custom_JButtonRounded btncari;
    private javax.swing.ButtonGroup btngrp_Jeniskelamin;
    private Custom.Custom_JTextFieldRounded cari;
    private Custom.Custom_JComboBox cbKategori;
    private Custom.Custom_JComboBox cb_halaman;
    private Custom.Custom_JButtonRounded custom_JButtonRounded6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pn_Add;
    private javax.swing.JPanel pn_Main;
    private javax.swing.JPanel pn_View;
    private Custom.Custom_JTable tabelproduk;
    private Custom.Custom_JTextFieldRounded txtHargaProduk;
    private Custom.Custom_JTextFieldRounded txtIdProduk;
    private Custom.Custom_JTextFieldRounded txtNamaProduk;
    private Custom.Custom_JTextFieldRounded txtRating;
    private Custom.Custom_JTextFieldRounded txtStok;
    // End of variables declaration//GEN-END:variables
}
