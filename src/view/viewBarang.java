/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.controllerBarang;
import database.koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JAR
 */
public class viewBarang extends javax.swing.JInternalFrame {

    /**
     * Creates new form viewBarang
     */
    private controllerBarang cB;
    
    private DefaultTableModel model;
    
    public viewBarang() {
        initComponents();
        
        cB = new controllerBarang(this);
        model = new DefaultTableModel();
        tabelBarang.setModel(model);
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Stok");
        model.addColumn("Tanggal Expired");
        model.addColumn("Tgl Barang Masuk");
        model.addColumn("Keterangan");
        
        tampilDataBarang();
        cB.kontrolButton();
    }

    public JTextField getKodeBarangView(){
        return kodeBarang;
    }

    public JTextField getNamaBarangView(){
        return namaBarang;
    }

    public JTextField getTglExpiredView(){
        return expBarang;
    }

    public JTextField getStokBarangView(){
        return stokBarang;
    }

    public JTextArea getKeteranganBarangView(){
        return keteranganBarang;
    }
    
    public JButton getTombolSimpan(){
        return tombolSimpan;
    }
    
    public JButton getTombolHapus(){
        return tombolHapus;
    }
    
    public JButton getTombolEdit(){
        return tombolUbah;
    }
    
    public JButton getTombolBatal(){
        return tombolBatal;
    }

    public JTextField getBarangMasukView() {
        return barangMasuk;
    }
    
    private void tampilDataBarang(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String sql = "SELECT * FROM barang";
        
        try {
            Statement stat = (Statement) koneksi.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()){
                // Mengambil hasil query variabel sql
                Object[] hasil;
                hasil = new Object[6];
                //karena ada 6 filed ditabel pelanggan
                hasil[0] = res.getString("kd_barang");
                hasil[1] = res.getString("nama_barang");
                hasil[2] = res.getString("stok");
                hasil[3] = res.getString("tgl_exp");
                hasil[4] = res.getString("barang_masuk");
                hasil[5] = res.getString("keterangan");
                
                model.addRow(hasil);
            }
        } catch (SQLException ex) {
            Logger.getLogger(viewBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void tampilDataBarangTglExpDESC(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String sql = "SELECT * FROM barang ORDER BY tgl_exp DESC";
        
        try {
            Statement stat = (Statement) koneksi.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()){
                // Mengambil hasil query variabel sql
                Object[] hasil;
                hasil = new Object[6];
                //karena ada 6 filed ditabel pelanggan
                hasil[0] = res.getString("kd_barang");
                hasil[1] = res.getString("nama_barang");
                hasil[2] = res.getString("stok");
                hasil[3] = res.getString("tgl_exp");
                hasil[4] = res.getString("barang_masuk");
                hasil[5] = res.getString("keterangan");
                
                model.addRow(hasil);
            }
        } catch (SQLException ex) {
            Logger.getLogger(viewBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void tampilDataBarangTglExpASC(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String sql = "SELECT * FROM barang ORDER BY tgl_exp ASC";
        
        try {
            Statement stat = (Statement) koneksi.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()){
                // Mengambil hasil query variabel sql
                Object[] hasil;
                hasil = new Object[6];
                //karena ada 6 filed ditabel pelanggan
                hasil[0] = res.getString("kd_barang");
                hasil[1] = res.getString("nama_barang");
                hasil[2] = res.getString("stok");
                hasil[3] = res.getString("tgl_exp");
                hasil[4] = res.getString("barang_masuk");
                hasil[5] = res.getString("keterangan");
                
                model.addRow(hasil);
            }
        } catch (SQLException ex) {
            Logger.getLogger(viewBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ambilDataTabel(){
        int index = tabelBarang.getSelectedRow();
        
        //mengambil nilai dari tabel
        String kode = String.valueOf(tabelBarang.getValueAt(index, 0));
        String nama = String.valueOf(tabelBarang.getValueAt(index, 1));
        String stok = String.valueOf(tabelBarang.getValueAt(index, 2));
        String exp = String.valueOf(tabelBarang.getValueAt(index, 3));
        String masuk = String.valueOf(tabelBarang.getValueAt(index, 4));
        String keterangan = String.valueOf(tabelBarang.getValueAt(index, 5));
        
        // Mengisi nilai ke textfield
        kodeBarang.setText(kode);
        namaBarang.setText(nama);
        expBarang.setText(exp);
        stokBarang.setText(stok);
        barangMasuk.setText(masuk);
        keteranganBarang.setText(keterangan);
        
        cB.kontrolButtonDua();
        kodeBarang.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tombolBatal = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        kodeBarang = new javax.swing.JTextField();
        ExpAsc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        keteranganBarang = new javax.swing.JTextArea();
        stokBarang = new javax.swing.JTextField();
        ExpDesc = new javax.swing.JButton();
        namaBarang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        expBarang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tombolUbah = new javax.swing.JButton();
        tombolSimpan = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        barangMasuk = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 51));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Menu Inventaris Barang");

        tombolBatal.setBackground(new java.awt.Color(235, 168, 58));
        tombolBatal.setText("Batal");
        tombolBatal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tombolBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolBatalActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Inventaris Barang");

        jLabel4.setText("Stok");

        ExpAsc.setText(" Exp  ↗ ");
        ExpAsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpAscActionPerformed(evt);
            }
        });

        keteranganBarang.setColumns(20);
        keteranganBarang.setRows(5);
        jScrollPane1.setViewportView(keteranganBarang);

        ExpDesc.setText(" Exp   ↙ ");
        ExpDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpDescActionPerformed(evt);
            }
        });

        jLabel6.setText("Kode Barang");

        jLabel5.setText("Tanggal Exp");

        jLabel1.setText("Nama Barang");

        expBarang.setText("yyyy-mm-dd");

        jLabel2.setText("Keterangan");

        tombolUbah.setBackground(new java.awt.Color(51, 51, 255));
        tombolUbah.setText("Ubah");
        tombolUbah.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tombolUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolUbahActionPerformed(evt);
            }
        });

        tombolSimpan.setBackground(new java.awt.Color(168, 228, 177));
        tombolSimpan.setText("Simpan");
        tombolSimpan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tombolSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolSimpanActionPerformed(evt);
            }
        });

        tombolHapus.setBackground(new java.awt.Color(255, 51, 51));
        tombolHapus.setText("Hapus");
        tombolHapus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tombolHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHapusActionPerformed(evt);
            }
        });

        tabelBarang.setBackground(new java.awt.Color(255, 255, 51));
        tabelBarang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelBarang.setSelectionBackground(new java.awt.Color(102, 102, 255));
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelBarang);

        jLabel7.setText("Tanggal Barang Masuk");

        barangMasuk.setText("yyyy-mm-dd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(kodeBarang)
                                            .addComponent(namaBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
                                    .addComponent(jLabel6))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(stokBarang)
                                    .addComponent(expBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(barangMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(tombolBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tombolHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(tombolUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)
                        .addComponent(tombolSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ExpAsc)
                        .addGap(31, 31, 31)
                        .addComponent(ExpDesc)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tombolBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tombolHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tombolUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tombolSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ExpAsc)
                            .addComponent(ExpDesc)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(kodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(stokBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(expBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(barangMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombolBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolBatalActionPerformed
        // TODO add your handling code here:
        cB.bersihkan();
        cB.kontrolButton();
        tampilDataBarang();
    }//GEN-LAST:event_tombolBatalActionPerformed

    private void ExpAscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpAscActionPerformed
        tampilDataBarangTglExpASC();
    }//GEN-LAST:event_ExpAscActionPerformed

    private void ExpDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpDescActionPerformed
        tampilDataBarangTglExpDESC();
    }//GEN-LAST:event_ExpDescActionPerformed

    private void tombolUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbahActionPerformed
        // TODO add your handling code here:
        cB.updateData();
        tampilDataBarang(); // Refresh tabel saat update
    }//GEN-LAST:event_tombolUbahActionPerformed

    private void tombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpanActionPerformed
        // TODO add your handling code here:
        cB.simpan();
        tampilDataBarang();
    }//GEN-LAST:event_tombolSimpanActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
        // TODO add your handling code here:
        cB.deleteData();
        tampilDataBarang();
    }//GEN-LAST:event_tombolHapusActionPerformed

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        // TODO add your handling code here:
        ambilDataTabel();
    }//GEN-LAST:event_tabelBarangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExpAsc;
    private javax.swing.JButton ExpDesc;
    private javax.swing.JTextField barangMasuk;
    private javax.swing.JTextField expBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea keteranganBarang;
    private javax.swing.JTextField kodeBarang;
    private javax.swing.JTextField namaBarang;
    private javax.swing.JTextField stokBarang;
    private javax.swing.JTable tabelBarang;
    private javax.swing.JButton tombolBatal;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolSimpan;
    private javax.swing.JButton tombolUbah;
    // End of variables declaration//GEN-END:variables
}
