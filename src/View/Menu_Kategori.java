/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class Menu_Kategori extends javax.swing.JPanel {

    Connection conn = controller.koneksi.getKoneksi();
    ResultSet rs = null;
    PreparedStatement pst = null;
    int xx, xy;
    private DefaultTableModel tabmode;
    String Lokasi;
    Object[] Baris = {"NIK Petugas", "Nama Pasien", "Tanggal Lahir", "Jenis Kelamin", "Telepon", "Alamat", "Tanggal Datang"};

    public Menu_Kategori() {
        initComponents();
        Locale locale = new Locale("id", "ID");
        Locale.setDefault(locale);
        kosong();
        aktif();
        //autonumber();
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
        txtKategori.requestFocus();
        tabmode = new DefaultTableModel(null, Baris);
        tabelkategori.setModel(tabmode);
    }

    protected void kosong() {
        txtKategori.setText("");
    }

    protected void datatable() {
        Object[] Baris = {"Id Kategori", "Nama Kategori"};
        tabmode = new DefaultTableModel(null, Baris);
        String cariitem = txtCari.getText();

        try {
            String sql = "SELECT * FROM kategori_produk where nama_kategori like '%" + cariitem + "%' order by id_kategori asc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                tabmode.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2)
                });
            }
            tabelkategori.setModel(tabmode);
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
        tabelkategori = new Custom.Custom_JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_firstpage = new Custom.Custom_JButtonRounded();
        btn_before = new Custom.Custom_JButtonRounded();
        btn_after = new Custom.Custom_JButtonRounded();
        btn_lastpage = new Custom.Custom_JButtonRounded();
        cb_halaman = new Custom.Custom_JComboBox();
        jLabel4 = new javax.swing.JLabel();
        bTambah = new Custom.Custom_JButtonRounded();
        bHapus = new Custom.Custom_JButtonRounded();
        bBatal = new Custom.Custom_JButtonRounded();
        txtCari = new Custom.Custom_JTextFieldRounded();
        jLabel2 = new javax.swing.JLabel();
        bCari = new Custom.Custom_JButtonRounded();
        Cetak = new Custom.Custom_JButtonRounded();
        pn_Add = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        bsimpan = new Custom.Custom_JButtonRounded();
        bbatal = new Custom.Custom_JButtonRounded();
        txtKategori = new Custom.Custom_JTextFieldRounded();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        pn_Main.setBackground(new java.awt.Color(255, 255, 255));
        pn_Main.setPreferredSize(new java.awt.Dimension(1028, 658));
        pn_Main.setLayout(new java.awt.CardLayout());

        pn_View.setBackground(new java.awt.Color(255, 255, 255));
        pn_View.setPreferredSize(new java.awt.Dimension(1028, 658));

        tabelkategori.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelkategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelkategoriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelkategori);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Data Daftar Kategori");

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
                .addContainerGap(323, Short.MAX_VALUE))
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

        bTambah.setBackground(new java.awt.Color(0, 153, 255));
        bTambah.setForeground(new java.awt.Color(255, 255, 255));
        bTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Add.png"))); // NOI18N
        bTambah.setText("TAMBAH");
        bTambah.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        bHapus.setBackground(new java.awt.Color(255, 204, 0));
        bHapus.setForeground(new java.awt.Color(255, 255, 255));
        bHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Delete.png"))); // NOI18N
        bHapus.setText("HAPUS");
        bHapus.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        bBatal.setBackground(new java.awt.Color(0, 204, 153));
        bBatal.setForeground(new java.awt.Color(255, 255, 255));
        bBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Cancel.png"))); // NOI18N
        bBatal.setText("BATAL");
        bBatal.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        bBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatalActionPerformed(evt);
            }
        });

        txtCari.setForeground(new java.awt.Color(102, 102, 102));
        txtCari.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Master Data > Kategori");
        jLabel2.setPreferredSize(new java.awt.Dimension(176, 19));

        bCari.setBackground(new java.awt.Color(255, 102, 102));
        bCari.setForeground(new java.awt.Color(255, 255, 255));
        bCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Cancel.png"))); // NOI18N
        bCari.setText("CARI");
        bCari.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        bCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariActionPerformed(evt);
            }
        });

        Cetak.setBackground(new java.awt.Color(153, 153, 153));
        Cetak.setForeground(new java.awt.Color(255, 255, 255));
        Cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cetakputih.png"))); // NOI18N
        Cetak.setText("CETAK");
        Cetak.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        Cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CetakActionPerformed(evt);
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
                        .addComponent(bTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Cetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(bTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        pn_Main.add(pn_View, "card2");

        pn_Add.setBackground(new java.awt.Color(255, 255, 255));
        pn_Add.setPreferredSize(new java.awt.Dimension(1028, 658));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Tambah Data Kategori");

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

        bbatal.setBackground(new java.awt.Color(0, 204, 153));
        bbatal.setForeground(new java.awt.Color(255, 255, 255));
        bbatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon Cancel.png"))); // NOI18N
        bbatal.setText("BATAL");
        bbatal.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });

        txtKategori.setForeground(new java.awt.Color(102, 102, 102));
        txtKategori.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        txtKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKategoriActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Nama Kategori");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Master Data > Kategori");

        javax.swing.GroupLayout pn_AddLayout = new javax.swing.GroupLayout(pn_Add);
        pn_Add.setLayout(pn_AddLayout);
        pn_AddLayout.setHorizontalGroup(
            pn_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_AddLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pn_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_AddLayout.createSequentialGroup()
                        .addGroup(pn_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_AddLayout.createSequentialGroup()
                                .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bbatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13))
                        .addContainerGap(790, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_AddLayout.createSequentialGroup()
                        .addGroup(pn_AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_AddLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)))
                        .addGap(20, 20, 20))))
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
                    .addComponent(bsimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bbatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(643, 643, 643))
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

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        pn_Main.removeAll();
        pn_Main.add(pn_Add);
        pn_Main.repaint();
        pn_Main.revalidate();
    }//GEN-LAST:event_bTambahActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "hapus", "konfirmasidialog", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String sql = "delete from kategori_produk where nama_kategori ='" + txtKategori.getText() + "'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong();
                txtKategori.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "data gagal dihapus" + e);
            }
            datatable();
        }
    }//GEN-LAST:event_bHapusActionPerformed

    private void bBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bBatalActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        String jenis = null;
        String sql = "insert into kategori_produk values (null,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtKategori.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            kosong();
            txtKategori.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal disimpan" + e);
        }
        datatable();

    }//GEN-LAST:event_bsimpanActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
        pn_Main.removeAll();
        pn_Main.add(pn_View);
        pn_Main.repaint();
        pn_Main.revalidate();
    }//GEN-LAST:event_bbatalActionPerformed

    private void txtKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKategoriActionPerformed

    private void bCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariActionPerformed
        datatable();
    }//GEN-LAST:event_bCariActionPerformed

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            datatable();
        }
    }//GEN-LAST:event_txtCariKeyPressed

    private void tabelkategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelkategoriMouseClicked
        int bar = tabelkategori.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();

        txtKategori.setText(a);
        datatable();
    }//GEN-LAST:event_tabelkategoriMouseClicked


    private void CetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CetakActionPerformed
        try {
            // Path file jrxml dan jasper
            String jrxmlPath = "./src/Report/reportkategori.jrxml";
            String jasperPath = "./src/Report/reportkategori.jasper";

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
    }//GEN-LAST:event_CetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.Custom_JButtonRounded Cetak;
    private Custom.Custom_JButtonRounded bBatal;
    private Custom.Custom_JButtonRounded bCari;
    private Custom.Custom_JButtonRounded bHapus;
    private Custom.Custom_JButtonRounded bTambah;
    private Custom.Custom_JButtonRounded bbatal;
    private Custom.Custom_JButtonRounded bsimpan;
    private Custom.Custom_JButtonRounded btn_after;
    private Custom.Custom_JButtonRounded btn_before;
    private Custom.Custom_JButtonRounded btn_firstpage;
    private Custom.Custom_JButtonRounded btn_lastpage;
    private javax.swing.ButtonGroup btngrp_Jeniskelamin;
    private Custom.Custom_JComboBox cb_halaman;
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pn_Add;
    private javax.swing.JPanel pn_Main;
    private javax.swing.JPanel pn_View;
    private Custom.Custom_JTable tabelkategori;
    private Custom.Custom_JTextFieldRounded txtCari;
    private Custom.Custom_JTextFieldRounded txtKategori;
    // End of variables declaration//GEN-END:variables
}
