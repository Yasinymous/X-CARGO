/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kargo.USER;


import java.io.BufferedReader;
import XML.Kargo.Kargo;
import XML.Kargo.KargoTakip;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import kargo.customer.customer;
import kargo.entity.User;
import kargo.entity.Users;
import kargo.entity.XMLUtils;
import kargo.giris.giris;


public class user extends AnchorPane {

    
    
    @FXML
    private TextField profil_UserName , profil_LastName , profil_Name;
    
    @FXML
    private TextField sAdress1, rAdress1, rName1, sName1, pay1, sizes,
            cargoid1; 
    @FXML
    private Label msg1;
    
    @FXML
    private TextField lastpass, newpass, newpass1;
     
    @FXML
     
    private TextField searchcargo;
    
    
    @FXML
    
    private User selectUser;
    private Users user;
    private XMLUtils<Users> Users;
 
   
    
    private KargoTakip kargoTakip;
    
    private XMLUtils<KargoTakip> root;
     
     public user(User user) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("user.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        this.selectUser =  user;
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        this.Users = new XMLUtils(Users.class);
        this.user = Users.lists("user"); 
        
        
        this.root = new XMLUtils(KargoTakip.class);
        this.kargoTakip = root.lists("Kargo");
 
        try {
            FileReader reader = new FileReader(new File("kargo_ıd.TXT"));
            String line;

            BufferedReader br = new BufferedReader(reader);

            while ((line = br.readLine()) != null) {
                
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(customer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        this.profil_LastName.setText(user.getLastName());
        this.profil_Name.setText(user.getFirstName());
        this.profil_UserName.setText(user.getUserName());
            
        
    }

     
    @FXML
    private void initialize() {
    }
    
 
    @FXML
    void search(ActionEvent event) {
        if (isControlcargo()){
            Kargo kargo = new Kargo();
              List<Kargo> Kargo = FXCollections.observableArrayList(kargoTakip.getKargo()).filtered(t
                    -> (t.getUID() == null ? this.searchcargo.getText().trim() == null : t.getUID().equals(this.searchcargo.getText().trim())));
           if (!Kargo.isEmpty()) {
                Kargo activeKargo = Kargo.get(0);
                System.out.println("Giriş Başarılı");
                System.out.println(activeKargo.getUID());
                this.msg1.setText("Found");
                this.cargoid1.setText(activeKargo.getUID());
             
                this.sAdress1.setText(activeKargo.getGonderen().getAdres()+"/"
                +activeKargo.getGonderen().getIlce()+"/"+activeKargo.getGonderen().getIl());
                
                this.sName1.setText(activeKargo.getGonderen().getAdi()
                +" "+activeKargo.getGonderen().getSoyadi());
                
                this.rAdress1.setText(activeKargo.getAlici().getAdres()+"/"
                +activeKargo.getAlici().getIlce()+"/"+activeKargo.getAlici().getIl());
                
                this.rName1.setText(activeKargo.getAlici().getAdi()
                +" "+activeKargo.getAlici().getSoyadi());
                
                this.sizes.setText(activeKargo.getBilgiler().getGenislik()+"/"
                +activeKargo.getBilgiler().getUzunluk()+"/"+activeKargo.getBilgiler().getYukseklik());
                
                this.pay1.setText(""+activeKargo.getBilgiler().getFiyat());
          
                
       
            } else {
                System.out.println("Giriş Başarısız");
                this.msg1.setText("Not Found");
            }
        } else {
            System.out.println("Tüm bilgileri giriniz.");
            this.msg1.setText("Null");
            
        }
    }
            
    
    private boolean isControlcargo() {
            return (this.searchcargo.getText() != null && !"".equals(this.searchcargo.getText()));
        } 
  
            

       
      @FXML
    void nameapply(ActionEvent event) {
        
          if (userControl()) {
            
            this.selectUser.setFirstName(profil_Name.getText().trim());
            this.selectUser.setLastName(profil_LastName.getText().trim());   
            this.Users.write(this.user, "User");
            System.out.println("go");
        } else {
              System.out.println("Boş");
        }

    }
    
     @FXML
    void passapply(ActionEvent event) {
     if (userControlpass()) {
         
            this.selectUser.setPassword(newpass1.getText().trim());
            
            this.Users.write(this.user, "User");
            System.out.println("Başarılı");
        } else {
              System.out.println("Boş");
        }

    }
      
    private boolean userControl(){
        return (profil_Name.getText() != null && !"".equals(profil_Name.getText()))
                && (profil_LastName.getText() != null && !"".equals(profil_LastName.getText()));
    
   
}
    private boolean userControlpass(){
        return (lastpass.getText() == null ? selectUser.getPassword() != null : !lastpass.getText().equals(selectUser.getPassword()))
                && (newpass.getText() != null && !"".equals(newpass.getText()))
                && (newpass1.getText() != null && !"".equals(newpass1.getText()))
                && (newpass1.getText() != newpass.getText());
    
   
}
    
    
    @FXML
    void logout(ActionEvent event) {
        giris g = new giris();
        this.getScene().setRoot(g);
    }
}
