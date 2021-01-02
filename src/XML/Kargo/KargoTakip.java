/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package XML.Kargo;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ysnak
 */

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class KargoTakip {
    
    List<Kargo> Kargo;

    public KargoTakip() {
        this.Kargo = new ArrayList();
    }

    public KargoTakip(List<Kargo> Kargo) {
        this.Kargo = Kargo;
    }

    public List<Kargo> getKargo() {
        return Kargo;
    }

    public void setKargo(List<Kargo> Kargo) {
        this.Kargo = Kargo;
    }
    
    
    
    
}
