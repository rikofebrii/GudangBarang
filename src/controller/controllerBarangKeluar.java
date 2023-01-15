/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.modelBarang;
import model.modelBarangKeluar;
import view.viewBarangKeluar;

/**
 *
 * @author JAR
 */
public class controllerBarangKeluar {
    private modelBarangKeluar mBK;
    private viewBarangKeluar vBK;
    
    public controllerBarangKeluar(viewBarangKeluar vBK){
        this.vBK = vBK;
    }
    
    public void simpanLaporanKeluar(){
        mBK = new modelBarangKeluar();
        mBK.setIdBarangKeluar(vBK.getIdBarangKeluar().getText());
        mBK.setBarangKeluar(vBK.getBarangKeluar().getText());
        mBK.setKodeBarang(vBK.getKodeBarang().getText());
        mBK.setNamaBarang(vBK.getNamaBarang().getText());
        mBK.setBarangMasuk(vBK.getBarangMasuk().getText());
        mBK.setTglExpired(vBK.getExpBarang().getText());
        mBK.setKeteranganKeluar(vBK.getKeteranganKeluar().getText());
        mBK.setJumlahBarangKeluar(Integer.parseInt(vBK.getJumlahBarangKeluar().getText()));
        mBK.setStokBarang(Integer.parseInt(vBK.getStokBarang().getText()));
        
        mBK.simpanLaporanKeluar();
    }
    
    public void bersihkan(){
        // pemanggilan variabel object swing yang ada di view
        vBK.getKodeBarang().setText("");
        vBK.getNamaBarang().setText("");
        vBK.getStokBarang().setText("");
        vBK.getExpBarang().setText("");
        vBK.getBarangMasuk().setText("");
        vBK.getKeteranganBarang().setText("");
        
        vBK.getIdBarangKeluar().setText("");
        vBK.getJumlahBarangKeluar().setText("");
        vBK.getBarangKeluar().setText("yyyy-mm-dd");
        vBK.getKeteranganKeluar().setText("");
    }
    
        public void bersihkanDataBarang(){
        // pemanggilan variabel object swing yang ada di view
        vBK.getKodeBarang().setText("");
        vBK.getNamaBarang().setText("");
        vBK.getStokBarang().setText("");
        vBK.getExpBarang().setText("");
        vBK.getBarangMasuk().setText("");
        vBK.getKeteranganBarang().setText("");
    }
    
    public void hapusLaporanKeluar(){
        mBK = new modelBarangKeluar();
        mBK.setIdBarangKeluar(vBK.getIdBarangKeluar().getText());
        
        mBK.hapusLaporanKeluar();
        bersihkan();
        kontrolButton();
    }
    
        public void kontrolButton(){
        vBK.getSimpanBT().setEnabled(true);
        vBK.getHapusBT().setEnabled(false);
        vBK.getCariData().setEnabled(true);
        vBK.getBatalBT().setEnabled(true);
    }
    
    public void kontrolButtonDua(){
        vBK.getSimpanBT().setEnabled(false);
        vBK.getHapusBT().setEnabled(true);
        vBK.getCariData().setEnabled(false);
        vBK.getBatalBT().setEnabled(true);
    }
}
