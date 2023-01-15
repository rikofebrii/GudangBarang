/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author JAR
 */
public class koneksi {
    private static Connection conn;
    
    private static Properties propert = new Properties();
    
    public static Connection getKoneksi() throws SQLException{
        if(conn == null){
            try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Berhasil Koneksi");
            }catch(ClassNotFoundException ex){
            System.out.println ("Gagal Koneksi"+ex);
            }
            
            String url ="jdbc:mysql://localhost:3306/gudang_barang";
            conn = (Connection) DriverManager.getConnection(url,"root","");
        }
        return conn;
        
        
    }
    /*
    private static Connection conn;
    
    private static Properties propert = new Properties();
    
    public static Connection getKoneksi() throws SQLException{
        if(conn == null){
            try{
                propert.load(new FileInputStream("C:\\Users\\JAR\\Documents\\NetBeansProjects\\gudangBarang\\src\\database\\konfigurasiDatabase.properties"));
            } catch (IOException ex){
                System.err.println("Error Mengambil File"+ex); 
                System.err.println("Error Membaca File"+ex); 
            }
            
            conn = (Connection) DriverManager.getConnection(propert.getProperty("jdbc.url"),propert.getProperty("jdbc.username"),propert.getProperty("jdbc.password"));
        }
        return conn;
        
        
    }
    /*
    public static void main(String[] args) throws SQLException{
        if(getKoneksi().equals(conn)){
            System.out.println("Sukses Terkoneksi");
        }
    }*/ 
}
