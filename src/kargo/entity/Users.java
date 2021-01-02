/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kargo.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ysnak
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Users {
    
    List<User> User;

    public Users() {
        this.User = new ArrayList();
    }

    public Users(List<User> User) {
        this.User = User;
    }

    public List<User> getUser() {
        return User;
    }

    public void setUser(List<User> User) {
        this.User = User;
    }
    
    
}
