/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.koneksi;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author JAR
 */
public class modelBarang {
    private String namaBarangModel;
    private String tglExpiredModel;
    private int stokBarangModel;
    private String keteranganBarangModel;
    private String barangMasukModel;
    // Inisialisasi variable id barang
    private String kodeBarangModel;

    public String getNamaBarangModel() {
        return namaBarangModel;
    }

    public void setNamaBarangModel(String namaBarangModel) {
        this.namaBarangModel = namaBarangModel;
    }

    public String getTglExpiredModel() {
        return tglExpiredModel;
    }

    public void setTglExpiredModel(String tglExpiredModel) {
        this.tglExpiredModel = tglExpiredModel;
    }

    public int getStokBarangModel() {
        return stokBarangModel;
    }

    public void setStokBarangModel(int stokBarangModel) {
        this.stokBarangModel = stokBarangModel;
    }

    
    public String getKeteranganBarangModel() {
        return keteranganBarangModel;
    }

    public void setKeteranganBarangModel(String keteranganBarangModel) {
        this.keteranganBarangModel = keteranganBarangModel;
    }

    public String getKodeBarangModel() {
        return kodeBarangModel;
    }

    public void setKodeBarangModel(String kodeBarangModel) {
        this.kodeBarangModel = kodeBarangModel;
    }

    public String getBarangMasukModel() {
        return barangMasukModel;
    }

    public void setBarangMasukModel(String barangMasukModel) {
        this.barangMasukModel = barangMasukModel;
    }
    
    
    
    public void simpanBarang(){
        // Inisialisasi query untuk insert ke dalam database
        String sql = ("INSERT INTO barang (kd_barang, nama_barang, stok, tgl_exp, barang_masuk, keterangan) "
                + "VALUES ('"+getKodeBarangModel()+"','"+getNamaBarangModel()+"'"
                + ",'"+getStokBarangModel()+"', '"+getTglExpiredModel()+"', '"+getBarangMasukModel()+"', '"+getKeteranganBarangModel()+"') ");
    
        // Inisialisasi prepraredStatment
        try{
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            // Pemberitahuan jika data berhasil disimpan
            JOptionPane.showMessageDialog(null,"Data Berhasil disimpan.");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Data Gagal Disimpan" + ex);
        }
    }
    
    public void deleteBarang(){
        String sql = "DELETE FROM barang WHERE kd_barang = "
                + " '"+getKodeBarangModel()+"'";
        
        try{
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            // Pemberitahuan jika data berhasil dihapus
            JOptionPane.showMessageDialog(null,"Data Berhasil dihapus.");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Data Gagal dihapus" + ex);
        }
    }
    
    public void updateBarang(){
        
        String sql = "UPDATE barang SET nama_barang = '"+getNamaBarangModel()+"'"
                + " ,stok = '"+getStokBarangModel()+"'"
                + " ,tgl_exp = '"+getTglExpiredModel()+"'"
                + " ,barang_masuk = '"+getBarangMasukModel()+"'"
                + " ,keterangan = '"+getKeteranganBarangModel()+"' WHERE kd_barang = '"+getKodeBarangModel()+"'";
                
    
        // Inisialisasi prepraredStatment
        try{
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            // Pemberitahuan jika data berhasil disimpan
            JOptionPane.showMessageDialog(null,"Data Berhasil disimpan.");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Data Gagal Disimpan" + ex);
        }
    }
}
