/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import dataBeans.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

/**
 *
 * @author tzk
 */
public class UserJDBC {
    
    private static final String URL = "jdbc:mysql://localhost:3306/amazonsystemdb";
    private static final String USER = "root";
    private static final String PASSWD = "123";
    
    
   public String validateUsernamePassword(String username, String password){
       
        String actionTarget = "login";
    try {
            Connection connect = null;
            Statement stmt = null;
            ResultSet result;
            String data = "Results:\n";
            boolean isValid = false;
            try {
                // connect to db - mrrtake sure derbyclient.jar is added to your project
                connect = DriverManager.getConnection(URL, USER, PASSWD);
                // obtain statement from connection
                stmt = connect.createStatement();
                // execute statement - note DB needs to perform full processing
                // on calling executeQuery
                result = stmt.executeQuery("SELECT Password FROM customer where Username = '"+username+"'");
                // process results
                // while there are results
                while (result.next()) {
                    // get data out - note: index starts at 1 !!!!
                    if(result.getString("Password").equals(password)){
                        isValid = true;                
                        System.out.println(password);
                    }
                    else{
                        FacesContext.getCurrentInstance().addMessage(
                                            null,
                                            new FacesMessage(FacesMessage.SEVERITY_WARN,
                                                            "Incorrect Username and Passowrd",
                                                            "Please enter correct username and Password"));
                    }
                    if(isValid){
                        actionTarget = "home_customer";
                    }
                }
                result = stmt.executeQuery("SELECT Password FROM administer where Username = '"+username+"'");
                // process results
                // while there are results
                while (result.next()) {
                    // get data out - note: index starts at 1 !!!!
                    if(result.getString("Password").equals(password)){
                        isValid = true;                
                        System.out.println(password);
                    }
                    else{
                        FacesContext.getCurrentInstance().addMessage(
                                            null,
                                            new FacesMessage(FacesMessage.SEVERITY_WARN,
                                                            "Incorrect Username and Passowrd",
                                                            "Please enter correct username and Password"));
                    }
                    if(isValid){
                        actionTarget = "home_admin";
                    }
                } 
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
                if (connect != null) {
                    connect.close();
                }
            }

        } catch (SQLException sql) {
            sql.printStackTrace();            
        }
	return actionTarget;
    } 

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        // need two nested try-blocks, as code in finally may throw exception
        try {
            Connection connect = null;
            Statement stmt = null;
            ResultSet result;
            try {
                // connect to db - mrrtake sure derbyclient.jar is added to your project
                connect = DriverManager.getConnection(URL, USER, PASSWD);
                // obtain statement from connection
                stmt = connect.createStatement();
                // execute statement - note DB needs to perform full processing
                // on calling executeQuery
                result = stmt.executeQuery("SELECT * FROM customer");
                // process results
                // while there are results
                while (result.next()) {
                    customers.add( 
                            new Customer( result.getInt(1),result.getString(2), result.getString(3),result.getInt( 4 ),result.getString(5),result.getString(6),result.getString(7))
                    );
                }
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
                if (connect != null) {
                    connect.close();
                }
            }

        } catch (SQLException sql) {
            sql.printStackTrace();
            System.out.println( "Message: " + sql.getMessage());
            System.out.println( "Code: " + sql.getSQLState());
        }
        return customers;
    }

       public void displayARecoredFromCustomer( String userName_searched ) {
        try {
            Connection connect = null;
            Statement stmt = null;
            ResultSet result;
            String data = "Results:\n";
            try {
                // connect to db - mrrtake sure derbyclient.jar is added to your project
                connect = DriverManager.getConnection(URL, USER, PASSWD);
                // obtain statement from connection
                stmt = connect.createStatement();
              
                // execute statement - note DB needs to perform full processing
                // on calling executeQuery
                result = stmt.executeQuery("SELECT * FROM customer where USERNAME='"+userName_searched+"'");
                    
                 // process results
                
                while (result.next()) {
                    // get data out - note: index starts at 1 !!!!
                    data += "\nUserName: " + result.getString(1)+ "\nPassword: "+ result.getCharacterStream(2)+"\nAge: "+ result.getInt(3)+"\nPhoneNumber :"+ result.getString(4)
                            +"\nUserMsg :"+result.getString(5)+"\nEmail :"+ result.getString(6);
                    System.out.println( data);
                }
               
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
                if (connect != null) {
                    connect.close();
                }
            }

        } catch (SQLException sql) {
            //sql.printStackTrace();
            System.out.println(  "Message: " + sql.getMessage());
            System.out.println(  "Code: " + sql.getSQLState());
        }
    }
       
    /**
     * Modifies a given manufacturer entry by updating the email to the given
     * string.<br>
     * NOTE: THIS IS VERY BAD PROGRAMMING AS IT ALLOWS SQL INJECTION ATTACKS
     *
     * @param email - new value for email
     * @return true - at least one row has been modified, false otherwise
     */
    public String modifyDetailFromCustomer(String username, String password, int age, String phoneNumber, String userMSG, String email) {
        String dirction = "#";
        int result = 0;
        // use try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                Statement stmt = connect.createStatement();) {

            // execute statement - note DB needs to perform full processing
            // on calling executeQuery
            // using simple string concatenation for variable data is 
            // !!! A VERY POOR APPROACH AND MOST LIKELY A SQL INJECTION FLAW IS CREATED !!!!
            result = stmt.executeUpdate("UPDATE customer SET Username='"
                    + username + "' WHERE USERNAME = 'joe'");
            result = stmt.executeUpdate("UPDATE customer SET Password='"
                    + password + "' WHERE USERNAME = 'joe'");
            result = stmt.executeUpdate("UPDATE customer SET Age='"
                    + age + "' WHERE USERNAME = 'joe'");
            result = stmt.executeUpdate("UPDATE customer SET UserMSG='"
                    + userMSG + "' WHERE USERNAME = 'joe'");
            result = stmt.executeUpdate("UPDATE customer SET phoneNumber='"
                    + phoneNumber + "' WHERE USERNAME = 'joe'");
            result = stmt.executeUpdate("UPDATE customer SET Email='"
                    + email + "' WHERE USERNAME = 'joe'");
            System.out.println( "Row count = " + result);
            System.out.println( "The following statement" +
                    "has been executed:\n"+
                    "UPDATE customer SET password='"
                    + password + "' WHERE USERNAME = 'joe'");
            // deal with any potential exceptions
            // note: all resources are closed automatically - no need for finally
        } catch (SQLException sql) {
            System.out.println( "Message: " + sql.getMessage());
            System.out.println( "Code: " + sql.getSQLState());
        }
        if( result > 0){
            dirction = "showProfile";
        }
        return dirction;
    }
       
     public boolean insertANewRecordToCustomer(String username,char password,int Age,String phoneNum,String useMSG,String email) {
        String data;
        int result = 0;
        // use try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                Statement stmt = connect.createStatement();) {

            // execute statement - note DB needs to perform full processing
            // on calling executeQuery
            // using simple string concatenation for variable data is 
            // !!! A VERY POOR APPROACH AND MOST LIKELY A SQL INJECTION FLAW IS CREATED !!!!
            result = stmt.executeUpdate(  "Insert into customer(Username,Password,Age,phoneNumber,UserMSG,Email)values('"+
                    username+"' , '" + password+"' , '" + Age+"' , '" + phoneNum+"' , '" + useMSG+"' , '" + email +" ')");
            System.out.println( "Row count = " + result);
            System.out.println( "The following statement" +
                    "has been executed:\n"+
                    "Insert into customer(Username,Password,Age,phoneNumber,UserMSG,Email)values('"+
                    username+"' , '" + password+"' , '" + Age+"' , '" + phoneNum+"' , '" + useMSG+"' , '" + email +" ')");
            // deal with any potential exceptions
            // note: all resources are closed automatically - no need for finally
        } catch (SQLException sql) {
            System.out.println(  "Message: " + sql.getMessage());
            System.out.println( "Code: " + sql.getSQLState());
        }
        return result > 0;
    }
     
       public boolean deleteRecordFromCustomer(String username) {
        String data;
        int result = 0;
        // use try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                Statement stmt = connect.createStatement();) {

            // execute statement - note DB needs to perform full processing
            // on calling executeQuery
            // using simple string concatenation for variable data is 
            // !!! A VERY POOR APPROACH AND MOST LIKELY A SQL INJECTION FLAW IS CREATED !!!!
            result = stmt.executeUpdate("delete from customer where username='"+ username +"'");
            System.out.println( "Row count = " + result);
            System.out.println(  "The following statement" +
                    "has been executed:\n"+
                    "delete from customer where username='"+ username +"'");
            // deal with any potential exceptions
            // note: all resources are closed automatically - no need for finally
        } catch (SQLException sql) {
            System.out.println( "Message: " + sql.getMessage());
            System.out.println( "Code: " + sql.getSQLState());
        }
        return result > 0;
    } 
   
       
           /**
     * Demonstrates use of Statement class to connect to a database. Uses a
     * "traditional" try-catch mechanism.
     */
    public void displayAllAdministerTraditional() {
        // need two nested try-blocks, as code in finally may throw exception
        try {
            Connection connect = null;
            Statement stmt = null;
            ResultSet result;
            String data = "Results:\n";
            try {
                // connect to db - mrrtake sure derbyclient.jar is added to your project
                connect = DriverManager.getConnection(URL, USER, PASSWD);
                // obtain statement from connection
                stmt = connect.createStatement();
                // execute statement - note DB needs to perform full processing
                // on calling executeQuery
                result = stmt.executeQuery("SELECT * FROM administer");
                // process results
                // while there are results
                while (result.next()) {
                    // get data out - note: index starts at 1 !!!!
                    data += "\nUserName: " + result.getString(1)+ "\nPassword: "+ result.getCharacterStream(2);
                    System.out.println( data);
                }
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
                if (connect != null) {
                    connect.close();
                }
            }

        } catch (SQLException sql) {
            //sql.printStackTrace();
            System.out.println( "Message: " + sql.getMessage());
            System.out.println( "Code: " + sql.getSQLState());
        }
    }

       public void displayARecoredFromAdminister(String username) {
        try {
            Connection connect = null;
            Statement stmt = null;
            ResultSet result;
            String data = "Results:\n";
            try {
                // connect to db - mrrtake sure derbyclient.jar is added to your project
                connect = DriverManager.getConnection(URL, USER, PASSWD);
                // obtain statement from connection
                stmt = connect.createStatement();
              
                // execute statement - note DB needs to perform full processing
                // on calling executeQuery
                result = stmt.executeQuery("SELECT * FROM administer where USERNAME='"+ username+"'");
                    
                 // process results
                
                while (result.next()) {
                    // get data out - note: index starts at 1 !!!!
                    data += "\nUserName: " + result.getString(1)+ "\nPassword: "+ result.getCharacterStream(2);
                    System.out.println( data);
                }
               
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
                if (connect != null) {
                    connect.close();
                }
            }

        } catch (SQLException sql) {
            //sql.printStackTrace();
            System.out.println( "Message: " + sql.getMessage());
            System.out.println( "Code " + sql.getSQLState());
        }
    }
       
    /**
     * Modifies a given manufacturer entry by updating the email to the given
     * string.<br>
     * NOTE: THIS IS VERY BAD PROGRAMMING AS IT ALLOWS SQL INJECTION ATTACKS
     *
     * @param email - new value for email
     * @return true - at least one row has been modified, false otherwise
     */
    public boolean modifyDetailFromAdminister(char password) {
        String data;
        int result = 0;
        // use try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                Statement stmt = connect.createStatement();) {

            // execute statement - note DB needs to perform full processing
            // on calling executeQuery
            // using simple string concatenation for variable data is 
            // !!! A VERY POOR APPROACH AND MOST LIKELY A SQL INJECTION FLAW IS CREATED !!!!
            result = stmt.executeUpdate("UPDATE administer SET password='"
                    + password + "' WHERE USERNAME = 'toor'");
            System.out.println( "Row count = " + result);
            System.out.println( "The following statement" +
                    "has been executed:\n"+
                    "UPDATE administer SET password='"
                    + password + "' WHERE USERNAME = 'toor'");
            // deal with any potential exceptions
            // note: all resources are closed automatically - no need for finally
        } catch (SQLException sql) {
            System.out.println( "Message: " + sql.getMessage());
            System.out.println( "Code: " + sql.getSQLState());
        }
        return result > 0;
    }

    
           
     public boolean insertANewRecordToAdminister(String username,char password) {
        String data;
        int result = 0;
        // use try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                Statement stmt = connect.createStatement();) {

            // execute statement - note DB needs to perform full processing
            // on calling executeQuery
            // using simple string concatenation for variable data is 
            // !!! A VERY POOR APPROACH AND MOST LIKELY A SQL INJECTION FLAW IS CREATED !!!!
            result = stmt.executeUpdate(  "Insert into administer(Username,Password)values('"+
                    username+"' , '" + password+" ')");
            System.out.println(  "Row count = " + result);
            System.out.println("The following statement" +
                    "has been executed:\n"+
                    "Insert into customer(Username,Password)values('"+
                    username+"' , '" + password+" ')");
            // deal with any potential exceptions
            // note: all resources are closed automatically - no need for finally
        } catch (SQLException sql) {
            System.out.println( "Message: " + sql.getMessage());
            System.out.println( "Code: " + sql.getSQLState());
        }
        return result > 0;
    }
     
       public boolean deleteRecordFromAdminister(String username) {
        String data;
        int result = 0;
        // use try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                Statement stmt = connect.createStatement();) {

            // execute statement - note DB needs to perform full processing
            // on calling executeQuery
            // using simple string concatenation for variable data is 
            // !!! A VERY POOR APPROACH AND MOST LIKELY A SQL INJECTION FLAW IS CREATED !!!!
            result = stmt.executeUpdate("delete from administer where username='"+ username +"'");
            System.out.println( "Row count = " + result);
            System.out.println( "The following statement" +
                    "has been executed:\n"+
                    "delete from administer where username='"+ username +"'");
            // deal with any potential exceptions
            // note: all resources are closed automatically - no need for finally
        } catch (SQLException sql) {
            System.out.println( "Message: " + sql.getMessage());
            System.out.println( "Code: " + sql.getSQLState());
        }
        return result > 0;
    } 
    
}
