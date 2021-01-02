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
public class Kargo {

    public static Kargo get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   private String UID;
   private Gonderen Gonderen;
   private Alici Alici;
   private Bilgiler Bilgiler;

    public Kargo() {
    }

    public Kargo(String UID, Gonderen Gonderen, Alici Alici, Bilgiler Bilgiler) {
        this.UID = UID;
        this.Gonderen = Gonderen;
        this.Alici = Alici;
        this.Bilgiler = Bilgiler;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public Gonderen getGonderen() {
        return Gonderen;
    }

    public void setGonderen(Gonderen Gonderen) {
        this.Gonderen = Gonderen;
    }

    public Alici getAlici() {
        return Alici;
    }

    public void setAlici(Alici Alici) {
        this.Alici = Alici;
    }

    public Bilgiler getBilgiler() {
        return Bilgiler;
    }

    public void setBilgiler(Bilgiler Bilgiler) {
        this.Bilgiler = Bilgiler;
    }

    @Override
    public String toString() {
        return this.UID;
    }
   
   
}
