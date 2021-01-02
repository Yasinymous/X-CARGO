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
public class Alici {
    
    private String Adi;
    private String Soyadi;
    private String Adres;
    private String Ilce;
    private String Il;

    public Alici() {
    }

    public Alici(String Adi, String Soyadi, String Adres, String Ilce, String Il) {
        this.Adi = Adi;
        this.Soyadi = Soyadi;
        this.Adres = Adres;
        this.Ilce = Ilce;
        this.Il = Il;
    }

    public String getAdi() {
        return Adi;
    }

    public void setAdi(String Adi) {
        this.Adi = Adi;
    }

    public String getSoyadi() {
        return Soyadi;
    }

    public void setSoyadi(String Soyadi) {
        this.Soyadi = Soyadi;
    }

    public String getAdres() {
        return Adres;
    }

    public void setAdres(String Adres) {
        this.Adres = Adres;
    }

    public String getIlce() {
        return Ilce;
    }

    public void setIlce(String Ilce) {
        this.Ilce = Ilce;
    }

    public String getIl() {
        return Il;
    }

    public void setIl(String Il) {
        this.Il = Il;
    }
    
    
    
    
}
