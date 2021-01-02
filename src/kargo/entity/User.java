/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kargo.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author ysnak
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    
    private String UserName;
    private String Password;
    private String FirstName;
    private String LastName;
    private boolean status;

    public User() {
    }

    public User(String UserName, String Password, String FirstName, String LastName, boolean status) {
        this.UserName = UserName;
        this.Password = Password;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.status = status;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return this.UserName;
    }
    
}
