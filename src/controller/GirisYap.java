/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.VeritabaniBaglanti;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mert
 * 1421012072 Mert Kolğu
 * 1421012034 Emre Küçük
 */
public class GirisYap {

    ResultSet rs = null;
    PreparedStatement ps;

    public boolean girisYap(String kadi, String sifre) throws SQLException {
        VeritabaniBaglanti vb = new VeritabaniBaglanti();
        vb.baglan();
        String sorgu = "select sifre from kullanici where kadi = ?";
        ps = vb.con.prepareCall(sorgu);
        ps.setString(1, kadi);
        rs = ps.executeQuery();
        while (rs.next()) {
            String pw = rs.getString("sifre");
            if (pw.equals(sifre)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
