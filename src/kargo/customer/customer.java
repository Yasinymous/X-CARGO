
package kargo.customer;

import BIN.ControlUtil;
import XML.Kargo.Alici;
import XML.Kargo.Bilgiler;
import XML.Kargo.Gonderen;
import XML.Kargo.Kargo;
import XML.Kargo.KargoTakip;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import kargo.entity.User;
import kargo.entity.Users;
import kargo.entity.XMLUtils;
import kargo.giris.giris;

/**
 *
 * @author ysnak
 */
public class customer extends AnchorPane {

    @FXML
    private ListView<Kargo> list;
    
    @FXML
    private ListView<User> list1;

    @FXML
    private TextField sName, sLastname, sAdress, sProvince, sDisc,
            rName, rLastName, rAdress, rProviince, rDisc, leng,
            width, height, pay;

    @FXML
    private TextField sAdress1, sProvince1, sDisc1, rAdress1, rProvince1, rdisc1,
            rName1, rLastname1, sName1, sLastname1, pay1, leng1, width1, height1
            ;

    @FXML
    private TextField username, userlastname, userıd, editname, editlastname, userpass;

    @FXML
    private Label msg, msg1, userapplymsg, useraddmsg;
    
  

    @FXML
    private TextField searchcargo;

    
    private User selectUser;
    private Users user;
    private XMLUtils<Users> Users;
    
    private Kargo selectCargo;
    private KargoTakip kargoTakip;
    private XMLUtils<KargoTakip> root;

    public customer() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customer.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
   
        }

        this.Users = new XMLUtils(Users.class);
        this.user = Users.lists("user");
        

        
        this.root = new XMLUtils(KargoTakip.class);
        this.kargoTakip = root.lists("Kargo");

        this.width.setTextFormatter(ControlUtil.OnlyDouble());
        this.leng.setTextFormatter(ControlUtil.OnlyDouble());
        this.height.setTextFormatter(ControlUtil.OnlyDouble());
        this.pay.setTextFormatter(ControlUtil.OnlyDouble());

        width.textProperty().addListener((observable, oldValue, newValue) -> {
            this.pay.setText("" + hesapla());
        });

        leng.textProperty().addListener((observable, oldValue, newValue) -> {
            this.pay.setText("" + hesapla());
        });

        height.textProperty().addListener((observable, oldValue, newValue) -> {
            this.pay.setText("" + hesapla());
        });

        Kargo kargo = new Kargo();
        ObservableList<Kargo> Kargo = FXCollections.observableList(this.kargoTakip.getKargo());
        Kargo.forEach((t) -> {
            list.getItems().add(t);
        });

        list.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            customer.this.searchcargo.setText(newValue.toString());
            search((ActionEvent) getOnMouseClicked());
            this.selectCargo = newValue;
            
        });

        
        User user = new User();
        ObservableList<User> User = FXCollections.observableList(this.user.getUser());
        User.forEach((t) -> {
            list1.getItems().add(t);
        });

        list1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            customer.this.userıd.setText(newValue.toString());    
            customer.this.selectUser = newValue;
            customer.this.editname.setText(this.selectUser.getFirstName());
            customer.this.editlastname.setText(this.selectUser.getLastName());
            customer.this.userpass.setText(this.selectUser.getPassword());
        });
      

        
        
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
           
    }
    



    @FXML
    private void initialize() {
    }

    @FXML
    void add(ActionEvent event) {
        if (isControl()) {
            Kargo kargo = new Kargo();
            kargo.setUID("YSN-5561-" + (this.kargoTakip.getKargo().size() + 1));
            kargo.setGonderen(new Gonderen(sName.getText().trim(), sLastname.getText().trim(),
                    sAdress.getText().trim(), sProvince.getText().trim(),
                    sDisc.getText().trim()));
            kargo.setAlici(new Alici(rName.getText().trim(), rLastName.getText().trim(),
                    rAdress.getText().trim(), rProviince.getText().trim(),
                    rDisc.getText().trim()));
            double w = Double.valueOf(width.getText());
            double l = Double.valueOf(leng.getText());
            double h = Double.valueOf(height.getText());
            double p = (w * l * h) * 1.2;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            kargo.setBilgiler(new Bilgiler(w, l, h, p));
            this.kargoTakip.getKargo().add(kargo);
            this.root.write(this.kargoTakip, "Kargo");
            this.msg.setText("Registration Successful");
        } else {
            this.msg.setText("Please Fill All The Fields !!");
        }
    }

    @FXML
    void apply(ActionEvent event) {
        if (isControlcargoapply()) {
       
            this.selectCargo.setGonderen(new Gonderen(sName1.getText().trim(), sLastname1.getText().trim(),
                    sAdress1.getText().trim(), sDisc1.getText().trim(), sProvince1.getText().trim()));
            this.selectCargo.setAlici(new Alici(rName1.getText().trim(), rLastname1.getText().trim(),
                    rAdress1.getText().trim(), rdisc1.getText().trim(), rProvince1.getText().trim()));
            double w = Double.valueOf(width1.getText());
            double l = Double.valueOf(leng1.getText());
            double h = Double.valueOf(height1.getText());
            double p = (w * l * h) * 1.2;
            this.selectCargo.setBilgiler(new Bilgiler(w, l, h, p));
            
            this.root.write(this.kargoTakip, "Kargo");
            this.msg1.setText("Apply");

        }
    }

    @FXML
    void delete(ActionEvent event) {
        this.kargoTakip.getKargo().remove(this.selectCargo);
        this.root.write(this.kargoTakip, "Kargo");
        this.msg.setText("Delete Successful");
        this.list.getItems().remove(this.selectCargo);
        // temizleme methodu yazıcam
        if (!this.list.getItems().isEmpty()) {
            this.list.getSelectionModel().selectFirst();
        }
    }

    
    
    @FXML
    void search(ActionEvent event) {
        if (isControlcargo()) {
           
            Kargo kargo = new Kargo();
            List<Kargo> Kargo = FXCollections.observableArrayList(kargoTakip.getKargo()).filtered(t
                    -> (t.getUID() == null ? this.searchcargo.getText().trim() == null : t.getUID().equals(this.searchcargo.getText().trim())));
            if (!Kargo.isEmpty()) {
                Kargo activeKargo = Kargo.get(0);

                this.sName1.setText(activeKargo.getGonderen().getAdi());
                this.sLastname1.setText(activeKargo.getGonderen().getSoyadi());
                this.sAdress1.setText(activeKargo.getGonderen().getAdres());
                this.sProvince1.setText(activeKargo.getGonderen().getIl());
                this.sDisc1.setText(activeKargo.getGonderen().getIlce());

                this.rName1.setText(activeKargo.getAlici().getAdi());
                this.rLastname1.setText(activeKargo.getAlici().getSoyadi());
                this.rAdress1.setText(activeKargo.getAlici().getAdres());
                this.rProvince1.setText(activeKargo.getAlici().getIl());
                this.rdisc1.setText(activeKargo.getAlici().getIlce());

                this.pay1.setText("" + activeKargo.getBilgiler().getFiyat());
                this.leng1.setText("" + activeKargo.getBilgiler().getUzunluk());
                this.width1.setText("" + activeKargo.getBilgiler().getGenislik());
                this.height1.setText("" + activeKargo.getBilgiler().getYukseklik());
                this.msg1.setText("Found");

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
  

    private boolean isControlcargoapply() {
        return ((sName1.getText() != null && !"".equals(sName1.getText()))
                && (sLastname1.getText() != null && !"".equals(sLastname1.getText()))
                && (sAdress1.getText() != null && !"".equals(sAdress1.getText()))
                && (sDisc1.getText() != null && !"".equals(sDisc1.getText()))
                && (sProvince1.getText() != null && !"".equals(sProvince1.getText()))
                && (rName1.getText() != null && !"".equals(rName1.getText()))
                && (rLastname1.getText() != null && !"".equals(rLastname1.getText()))
                && (rAdress1.getText() != null && !"".equals(rAdress1.getText()))
                && (rdisc1.getText() != null && !"".equals(rdisc1.getText()))
                && (rProvince1.getText() != null && !"".equals(rProvince1.getText()))
                && (leng1.getText() != null && !"".equals(leng1.getText()))
                && (width1.getText() != null && !"".equals(width1.getText()))
                && (height1.getText() != null && !"".equals(height1.getText())));

    }

    @FXML
    void logout(ActionEvent event) {
        giris g = new giris();
        this.getScene().setRoot(g);

    }

    @FXML
    void useradd(ActionEvent event) {
        
         if (userControl()) {
            User user = new User();
            user.setUserName("user" + (this.user.getUser().size() + 1));
            user.setPassword("user" + (this.user.getUser().size() + 1));
            user.setFirstName(this.username.getText().trim());
            user.setLastName(this.userlastname.getText().trim());
            user.setStatus(false);
                            
            this.user.getUser().add(user);
            this.Users.write(this.user, "User");
            this.useraddmsg.setText("Registration Successful");
        } else {
            this.useraddmsg.setText("Please Fill All The Fields !!");
        }
    }
        
        
        
    

    @FXML
    void userapply(ActionEvent event) {
        
         if (isControlcargouserapply()) {
       
            this.selectUser.setFirstName(editname.getText().trim());
            this.selectUser.setLastName(editlastname.getText().trim());
            this.selectUser.setPassword(userpass.getText().trim());
        
            this.Users.write(this.user, "User");
            this.userapplymsg.setText("Apply");

        }


    }

    @FXML
    void userdelete(ActionEvent event) {
        this.user.getUser().remove(this.selectUser);
        this.Users.write(this.user, "User");
        this.userapplymsg.setText("Delete Successful");
        this.list1.getItems().remove(this.selectUser);
        // temizleme methodu yazıcam
        if (!this.list1.getItems().isEmpty()) {
            this.list1.getSelectionModel().selectFirst();
        }
    }
    
 
    

    private boolean userControl() {
        return (username.getText() != null && !"".equals(username.getText()))
                && (userlastname.getText() != null && !"".equals(userlastname.getText()));

    }
    
    private boolean isControlcargouserapply() {
        return (editname.getText() != null && !"".equals(editname.getText()))
                && (userpass.getText() != null && !"".equals(userpass.getText()))
                && (editlastname.getText() != null && !"".equals(editlastname.getText()));

    }

    private boolean isControl() {
        return (sName.getText() != null && !"".equals(sName.getText()))
                && (sLastname.getText() != null && !"".equals(sLastname.getText()))
                && (sAdress.getText() != null && !"".equals(sAdress.getText()))
                && (sDisc.getText() != null && !"".equals(sDisc.getText()))
                && (sProvince.getText() != null && !"".equals(sProvince.getText()))
                && (rName.getText() != null && !"".equals(rName.getText()))
                && (rLastName.getText() != null && !"".equals(rLastName.getText()))
                && (rAdress.getText() != null && !"".equals(rAdress.getText()))
                && (rDisc.getText() != null && !"".equals(rDisc.getText()))
                && (rProviince.getText() != null && !"".equals(rProviince.getText()))
                && (leng.getText() != null && !"".equals(leng.getText()))
                && (width.getText() != null && !"".equals(width.getText()))
                && (height.getText() != null && !"".equals(height.getText()));

    }

    private double hesapla() {
        if (!"".equals(this.width.getText()) && !"".equals(this.leng.getText())
                && !"".equals(this.height.getText())) {
            double w = Double.valueOf(width.getText());
            double l = Double.valueOf(leng.getText());
            double h = Double.valueOf(width.getText());
            double p = (w * l * h) * 1.2;
            return p;
        }
        return 0;
    }

   
    
}
