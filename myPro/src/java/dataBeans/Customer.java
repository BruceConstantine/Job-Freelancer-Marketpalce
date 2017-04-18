/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBeans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author tzk 
    */
 
public class Customer implements Serializable {
 
    // required field for Serializable
    private static final long serialVersionUID = 1;
 
    private Integer id;
    private String username;
    private String password;
    private int age;
    private String phoneNumber;
    private String userMSG;
    private String email;
    
    
    public Customer() {
        this.id = 0;
        this.username ="" ;
        this.password = "";
        this.age = 0;
        this.phoneNumber = ""; 
        this.userMSG = "";
        this.email = "";
    }

    public Customer(Integer id) {
        this.id = id;
        this.username ="" ;
        this.password = "";
        this.age = 0;
        this.phoneNumber = ""; 
        this.userMSG = "";
        this.email = "";
    }

    public Customer(Integer id, String username, String password, int age, String phoneNumber, String userMSG, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber; 
        this.userMSG = userMSG;
        this.email = email;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserMSG() {
        return userMSG;
    }

    public void setUserMSG(String userMSG) {
        this.userMSG = userMSG;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dataBeans.Customer[ id=" + id + " ]";
    }
    
}
 