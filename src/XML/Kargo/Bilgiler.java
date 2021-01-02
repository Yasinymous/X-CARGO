/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XML.Kargo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author ysnak
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Bilgiler {
    
    private double Uzunluk;
    private double Genislik;
    private double Yukseklik;
    private double Fiyat;


    public Bilgiler() {
    }
    
    
    public Bilgiler(double Uzunluk, double Genislik, double Yukseklik, double Fiyat) {
        this.Uzunluk = Uzunluk;
        this.Genislik = Genislik;
        this.Yukseklik = Yukseklik;
        this.Fiyat = Fiyat;

    }

    public double getUzunluk() {
        return Uzunluk;
    }

    public void setUzunluk(double Uzunluk) {
        this.Uzunluk = Uzunluk;
    }

    public double getGenislik() {
        return Genislik;
    }

    public void setGenislik(double Genislik) {
        this.Genislik = Genislik;
    }

    public double getYukseklik() {
        return Yukseklik;
    }

    public void setYukseklik(double Yukseklik) {
        this.Yukseklik = Yukseklik;
    }

    public double getFiyat() {
        return Fiyat;
    }

    public void setFiyat(double Fiyat) {
        this.Fiyat = Fiyat;
    }


    
}
