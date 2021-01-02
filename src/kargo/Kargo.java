/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kargo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

import kargo.giris.giris;


/**
 *
 * @author ysnak
 */
public class Kargo extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        giris giris = new giris();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(giris);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setMaxWidth(900);
        stage.show();
       
       /* 
        Users users = new Users();
        users.getUser().add(new User("admin", "admin", "Admin", "Admin", true));
        users.getUser().add(new User("user", "user", "User", "User", false));
        XMLUtils<Users> util = new XMLUtils(Users.class);
        util.write(users, "user");
        */
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
