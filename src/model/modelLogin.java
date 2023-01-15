/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.koneksi;
import gudangbarang.app_utama;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author JAR
 */
public class modelLogin {
    private String usernameLoginModel;
    private String passwordLoginModel;

    public String getUsernameLoginModel() {
        return usernameLoginModel;
    }

    public void setUsernameLoginModel(String usernameLoginModel) {
        this.usernameLoginModel = usernameLoginModel;
    }

    public String getPasswordLoginModel() {
        return passwordLoginModel;
    }

    public void setPasswordLoginModel(String passwordLoginModel) {
        this.passwordLoginModel = passwordLoginModel;
    }
    
    public void userLogin(){
        String sql = "SELECT * FROM user WHERE username = '"+getUsernameLoginModel()+"' AND password ='"+getPasswordLoginModel()+"'";
        try{
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            eksekusi.execute(sql);
            ResultSet rs = eksekusi.executeQuery(sql);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Login Succesfull","Login Success", 1);
                    new app_utama().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "Login Failed", 2);
                }
       } catch (SQLException x) {
             JOptionPane.showMessageDialog(null,"Login Gagal" + x);
        }
    }
}
