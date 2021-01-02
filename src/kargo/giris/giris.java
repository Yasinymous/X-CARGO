/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kargo.giris;

import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import kargo.USER.user;

import kargo.customer.customer;
import kargo.entity.User;
import kargo.entity.Users;
import kargo.entity.XMLUtils;

/**
 *
 * @author ysnak
 */
public class giris extends HBox {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    private Users UserList;
    
    @FXML
    private Label msg;
    
    public giris() {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("giris.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        XMLUtils<Users> util = new XMLUtils(Users.class);
        this.UserList = util.lists("user");
   

    }
    
    

    @FXML
    private void initialize() {
    }

    @FXML
    void login(ActionEvent event) {
        if (isControl()) {
            List<User> user = FXCollections.observableArrayList(UserList.getUser()).filtered(t
                    -> (t.getUserName() == null ? this.username.getText().trim() == null : t.getUserName().equals(this.username.getText().trim()))
                    && (t.getPassword() == null ? this.password.getText().trim() == null : t.getPassword().equals(this.password.getText().trim())));
            if (!user.isEmpty()) {
                User activeUser = user.get(0);
                
                if (activeUser.isStatus()) {
                    customer cus = new customer();
                    this.getScene().setRoot(cus);
                    
                } else {
                    user us = new user(activeUser);
                    this.getScene().setRoot(us);
                    
                }
            } else {
                System.out.println("Giriş Başarısız");
                this.msg.setText("Login Failed");
            }
        } else {
            System.out.println("Tüm bilgileri giriniz.");
            this.msg.setText("Login Failed");
            
        }
    }

    private boolean isControl() {
        return (this.username.getText() != null && !"".equals(this.username.getText()))
                && (this.password.getText() != null && !"".equals(this.password.getText()));
    }
}
