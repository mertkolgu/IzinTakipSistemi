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
import java.util.ArrayList;
/**
 *
 * @author Mert
 * 1421012072 Mert Kolğu
 * 1421012034 Emre Küçük
 */
public class Kullanicilar {

    VeritabaniBaglanti vb = new VeritabaniBaglanti();
    ArrayList<Kullanicilar> liste = new ArrayList<>();
    PreparedStatement ps;
    ResultSet rs;
    private String k_kadi;
    private String k_sifre;
    private String k_tcno;
    private String k_sicilno;
    private String k_ad;
    private String k_soyad;
    private String k_tel;
    private String k_cinsiyet;
    private String k_dogumtarihi;
    private String k_sehir;
    private String k_kayitno;
    private String k_birim;
    private String k_pozisyon;

    public boolean kullaniciEkle(Kullanicilar kullaniciEkle) {
        try {
            vb.baglan();
            String sorgu = "insert into kullanici "
                    + "(kadi, sifre, tcno, sicilno, ad, soyad, tel, cinsiyet, dogumtarihi, sehir, kayitno, birim, pozisyon)"
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = vb.con.prepareStatement(sorgu);
            ps.setString(1, kullaniciEkle.getK_kadi());
            ps.setString(2, kullaniciEkle.getK_sifre());
            ps.setString(3, kullaniciEkle.getK_tcno());
            ps.setString(4, kullaniciEkle.getK_sicilno());
            ps.setString(5, kullaniciEkle.getK_ad());
            ps.setString(6, kullaniciEkle.getK_soyad());
            ps.setString(7, kullaniciEkle.getK_tel());
            ps.setString(8, kullaniciEkle.getK_cinsiyet());
            ps.setString(9, kullaniciEkle.getK_dogumtarihi());
            ps.setString(10, kullaniciEkle.getK_sehir());
            ps.setString(11, kullaniciEkle.getK_kayitno());
            ps.setString(12, kullaniciEkle.getK_birim());
            ps.setString(13, kullaniciEkle.getK_pozisyon());
            ps.execute();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean kullaniciGuncelle(Kullanicilar kullaniciGuncelle) {
        try {
            vb.baglan();
            String sorgu = "update kullanici set kadi = ?, sifre = ?, sicilno = ?, "
                    + "ad = ?, soyad = ?, tel = ?, cinsiyet = ?, dogumtarihi = ?, sehir = ?, "
                    + "kayitno = ?, birim = ?, pozisyon = ? where tcno = ?";
            ps = vb.con.prepareStatement(sorgu);
            ps.setString(1, kullaniciGuncelle.getK_kadi());
            ps.setString(2, kullaniciGuncelle.getK_sifre());
            ps.setString(3, kullaniciGuncelle.getK_sicilno());
            ps.setString(4, kullaniciGuncelle.getK_ad());
            ps.setString(5, kullaniciGuncelle.getK_soyad());
            ps.setString(6, kullaniciGuncelle.getK_tel());
            ps.setString(7, kullaniciGuncelle.getK_cinsiyet());
            ps.setString(8, kullaniciGuncelle.getK_dogumtarihi());
            ps.setString(9, kullaniciGuncelle.getK_sehir());
            ps.setString(10, kullaniciGuncelle.getK_kayitno());
            ps.setString(11, kullaniciGuncelle.getK_birim());
            ps.setString(12, kullaniciGuncelle.getK_pozisyon());
            ps.setString(13, kullaniciGuncelle.getK_tcno());
            ps.execute();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean kullaniciSil(Kullanicilar kullaniciSil) {
        try {
            vb.baglan();
            String sorgu = "delete from kullanici " + "where tcno = ?";
            ps = vb.con.prepareStatement(sorgu);
            ps.setString(1, kullaniciSil.getK_tcno());
            ps.execute();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public ArrayList<Kullanicilar> kullaniciListele() throws SQLException {
        try {
            vb.baglan();
            String sorgu = "select * from kullanici";
            ps = vb.con.prepareStatement(sorgu);
            rs = ps.executeQuery();
            while (rs.next()) {
                Kullanicilar kullaniciList = new Kullanicilar();
                kullaniciList.setK_tcno(rs.getString(1));
                kullaniciList.setK_sicilno(rs.getString(2));
                kullaniciList.setK_kadi(rs.getString(3));
                kullaniciList.setK_sifre(rs.getString(4));
                kullaniciList.setK_ad(rs.getString(5));
                kullaniciList.setK_soyad(rs.getString(6));
                kullaniciList.setK_tel(rs.getString(7));
                kullaniciList.setK_cinsiyet(rs.getString(8));
                kullaniciList.setK_dogumtarihi(rs.getString(9));
                kullaniciList.setK_sehir(rs.getString(10));
                kullaniciList.setK_kayitno(rs.getString(11));
                kullaniciList.setK_birim(rs.getString(12));
                kullaniciList.setK_pozisyon(rs.getString(13));
                liste.add(kullaniciList);
            }
        } catch (SQLException ex) {
            System.out.println("Hata \n" + ex);
        }
        return liste;
    }    
    
    public String getK_kadi() {
        return k_kadi;
    }

    public void setK_kadi(String k_kadi) {
        this.k_kadi = k_kadi;
    }

    public String getK_sifre() {
        return k_sifre;
    }

    public void setK_sifre(String k_sifre) {
        this.k_sifre = k_sifre;
    }

    public String getK_tcno() {
        return k_tcno;
    }

    public void setK_tcno(String k_tcno) {
        this.k_tcno = k_tcno;
    }

    public String getK_sicilno() {
        return k_sicilno;
    }

    public void setK_sicilno(String k_sicilno) {
        this.k_sicilno = k_sicilno;
    }

    public String getK_ad() {
        return k_ad;
    }

    public void setK_ad(String k_ad) {
        this.k_ad = k_ad;
    }

    public String getK_soyad() {
        return k_soyad;
    }

    public void setK_soyad(String k_soyad) {
        this.k_soyad = k_soyad;
    }

    public String getK_tel() {
        return k_tel;
    }

    public void setK_tel(String k_tel) {
        this.k_tel = k_tel;
    }

    public String getK_cinsiyet() {
        return k_cinsiyet;
    }

    public void setK_cinsiyet(String k_cinsiyet) {
        this.k_cinsiyet = k_cinsiyet;
    }

    public String getK_dogumtarihi() {
        return k_dogumtarihi;
    }

    public void setK_dogumtarihi(String k_dogumtarihi) {
        this.k_dogumtarihi = k_dogumtarihi;
    }

    public String getK_sehir() {
        return k_sehir;
    }

    public void setK_sehir(String k_sehir) {
        this.k_sehir = k_sehir;
    }

    public String getK_kayitno() {
        return k_kayitno;
    }

    public void setK_kayitno(String k_kayitno) {
        this.k_kayitno = k_kayitno;
    }

    public String getK_birim() {
        return k_birim;
    }

    public void setK_birim(String k_birim) {
        this.k_birim = k_birim;
    }

    public String getK_pozisyon() {
        return k_pozisyon;
    }

    public void setK_pozisyon(String k_pozisyon) {
        this.k_pozisyon = k_pozisyon;
    }
}
