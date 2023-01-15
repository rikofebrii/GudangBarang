/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import database.koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JAR
 */
public class viewListDataBarang extends javax.swing.JFrame {

    /** Creates new form viewListDataBarang */
    private viewBarangKeluar vBK;
    private DefaultTableModel model;
    //inisialisasi variabel untuk menyimpan query ke database
    private String sql = "";
    public viewListDataBarang(viewBarangKeluar vBK) {
        initComponents();
        
        this.vBK = vBK;
        model = new DefaultTableModel();
        viewListDataBarang.setModel(model);
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Stok");
        model.addColumn("Tgl Expired");
        model.addColumn("Tgl Barang Masuk");
        model.addColumn("Keterangan");
        
        tampilDataBarang();
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
    
    private void cariDataBarang(String data){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        /*kondisi pengecekan apakah yang dicari itu
        seluruh data barang atau salah satu saja*/
        
        if(data.equals("")){
            sql = "select * from barang";
        } else sql = " select * from barang where nama_barang LIKE '"+data+"%'"
                + "or kd_barang like '%"+data+"%'"
                + "or stok like '%"+data+"%'"
                + "or tgl_exp like '%"+data+"%'"
                + "or barang_masuk like '%"+data+"%'";//Like menggunakan % untuk pencarian pada bahasa SQL
    
        try {
            Statement stat = (Statement)koneksi.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            //proses pengambilan data hasil query
            while(res.next()){
                Object[] hasil;
                hasil = new Object[6];
            
                hasil[0] = res.getString("kd_barang");
                hasil[1] = res.getString("nama_barang");
                hasil[2] = res.getString("stok");
                hasil[3] = res.getString("tgl_exp");
                hasil[4] = res.getString("barang_masuk");
                hasil[5] = res.getString("keterangan");
                
                model.addRow(hasil);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(viewListDataBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        viewListDataBarang = new javax.swing.JTable();
        namaBarang = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ExpAsc = new javax.swing.JButton();
        ExpDesc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        viewListDataBarang.setBackground(new java.awt.Color(255, 255, 51));
        viewListDataBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        viewListDataBarang.setSelectionBackground(new java.awt.Color(102, 102, 255));
        viewListDataBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewListDataBarangMouseClicked(evt);
            }
        });
        jScrollPane.setViewportView(viewListDataBarang);

        namaBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                namaBarangKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Daftar Barang");

        jLabel2.setText("Cari Data Barang");

        ExpAsc.setText(" Exp  ↗ ");
        ExpAsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpAscActionPerformed(evt);
            }
        });

        ExpDesc.setText(" Exp   ↙ ");
        ExpDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpDescActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
                        .addComponent(ExpAsc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ExpDesc)
                        .addGap(0, 44, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ExpAsc)
                            .addComponent(ExpDesc))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewListDataBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewListDataBarangMouseClicked
        // TODO add your handling code here:
        int listX = viewListDataBarang.getSelectedRow();
        vBK.getKodeBarang().setText(viewListDataBarang.getValueAt(listX,0).toString());
        vBK.getNamaBarang().setText(viewListDataBarang.getValueAt(listX,1).toString());
        vBK.getStokBarang().setText(viewListDataBarang.getValueAt(listX,2).toString());
        vBK.getExpBarang().setText(viewListDataBarang.getValueAt(listX,3).toString());
        vBK.getBarangMasuk().setText(viewListDataBarang.getValueAt(listX,4).toString());
        vBK.getKeteranganBarang().setText(viewListDataBarang.getValueAt(listX,5).toString());
        
        // jika table diklik maka akan diclose
        dispose();
    }//GEN-LAST:event_viewListDataBarangMouseClicked

    private void namaBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namaBarangKeyPressed
        // TODO add your handling code here:
        cariDataBarang(namaBarang.getText());
    }//GEN-LAST:event_namaBarangKeyPressed

    private void ExpAscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpAscActionPerformed
        tampilDataBarangTglExpASC();
    }//GEN-LAST:event_ExpAscActionPerformed

    private void ExpDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpDescActionPerformed
        tampilDataBarangTglExpDESC();
    }//GEN-LAST:event_ExpDescActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExpAsc;
    private javax.swing.JButton ExpDesc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTextField namaBarang;
    private javax.swing.JTable viewListDataBarang;
    // End of variables declaration//GEN-END:variables

}
