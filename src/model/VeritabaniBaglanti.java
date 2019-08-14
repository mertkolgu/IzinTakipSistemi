/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Mert
 * 1421012072 Mert Kolğu
 * 1421012034 Emre Küçük
 */
public class VeritabaniBaglanti {

    public Connection con;
    private String url = "jdbc:mysql://localhost:3306/";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String dbname = "izin_takip_sistemi?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String username = "root";
    private String password = "";

    public void baglan() {
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url + dbname, username, password);
            System.out.println("Veritabanı bağlantısı başarılı!");
        } catch (Exception ex) {
            System.out.println("Veritabanına bağlanılamadı! Bağlantıda hata var!\n" + ex);
        }
    }
}
