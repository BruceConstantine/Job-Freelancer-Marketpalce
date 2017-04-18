/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myBeans;

import dataBeans.*;
import JDBC.UserJDBC;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException; 
import javax.inject.Named; 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "customerBean")
@SessionScoped
public class UserBean implements Serializable{
    
    private JDBC.UserJDBC  userJDBC ;
    private String userName_searched; 
    private int userID_searched; 
    private String username;
    private String password;
    private int age;
    private String phonenumber;
    private String userMSG;
    private String email;
    
    private List<Customer> customersAll;


    public UserBean(){
        customersAll = new ArrayList<Customer>();
        userJDBC = new UserJDBC();
        
    }
    
    public UserBean(String userName_searched, String username, String password, int age, String phonenumber, String userMSG, String email) {
        this.userName_searched = userName_searched;
        this.username = username;
        this.password = password;
        this.age = age;
        this.phonenumber = phonenumber;
        this.userMSG = userMSG;
        this.email = email;
        customersAll = new ArrayList<Customer>();
        userJDBC = new UserJDBC();
    }

    public int getUserID_searched() {
        return userID_searched;
    }

    public void setUserID_searched(int userID_searched) {
        this.userID_searched = userID_searched;
    }

    public List<Customer> displayAllCustomerTraditional(){ 
       return userJDBC.getAllCustomers();
    }
    
    public String validateUsernamePassword(){
        return userJDBC.validateUsernamePassword(username,password);
    }
    
    public String modifyDetailFromCustomer(String username, String password, int age, String phoneNumber, String userMSG, String email) {
        return userJDBC.modifyDetailFromCustomer(username, password, age, phonenumber, userMSG, email);
    }
    
    public String getUserName_searched() {
        return userName_searched;
    }

    public void setUserName_searched(String userName_searched) {
        this.userName_searched = userName_searched;
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUserMSG(){
        return userMSG;
    }

    public void setUserMSG(String userMSG) {
        this.userMSG = userMSG;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Demonstrates use of Statement class to connect to a database. Uses a
     * "traditional" try-catch mechanism.
     */
    public void setEmail(String email){
        this.email = email;
    }

}