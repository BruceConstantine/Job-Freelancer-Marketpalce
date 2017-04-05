/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myJDBC;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Reiner
 */
public class JDBCConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
    private static final String USER = "root";
    private static final String PASSWD = "6056612w";

    /**
     * Demonstrates use of Statement class to connect to a database. Uses a
     * "traditional" try-catch mechanism.
     */
    public void displayAllCustomerTraditional() {
        // need two nested try-blocks, as code in finally may throw exception
        try {
            Connection connect = null;
            Statement stmt = null;
            ResultSet result;
            String data = "Results:\n";
            try {
                // connect to db - make sure derbyclient.jar is added to your project
                connect = DriverManager.getConnection(URL, USER, PASSWD);
                // obtain statement from connection
                stmt = connect.createStatement();
                // execute statement - note DB needs to perform full processing
                // on calling executeQuery
                result = stmt.executeQuery("Select * from address;");
                // process results
                // while there are results
                while (result.next()) {
                    // get data out - note: index starts at 1 !!!!
                    data += "Id: " + result.getInt(1);
                    JOptionPane.showMessageDialog(null, data);
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
            JOptionPane.showMessageDialog(null, "Message: " + sql.getMessage());
            JOptionPane.showMessageDialog(null, "Code: " + sql.getSQLState());
        }
    }

    /**
     * Demonstrates use of Statement class to connect to a database. Uses a
     * try-with-resource mechanism.
     */
    public void displayAllCustomerTryResource() {
        String data;
        // use try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                Statement stmt = connect.createStatement();) {

            // execute statement - note DB needs to perform full processing
            // on calling executeQuery
            ResultSet result = stmt.executeQuery("SELECT CUSTOMER_ID, NAME FROM CUSTOMER");
            // process results
            // while there are results
            while (result.next()) {
                // get data out - note: index starts at 1 !!!!
                data = "Id: " + result.getInt(1) + "\nName: " + result.getString(2);
                JOptionPane.showMessageDialog(null, data);
            }

            // deal with any potential exceptions
            // note: all resources are closed automatically - no need for finally
        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, "Message: " + sql.getMessage());
            JOptionPane.showMessageDialog(null, "Code: " + sql.getSQLState());
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
    public boolean modifyEntryBadVersion(String email) {
        String data;
        int result = 0;
        // use try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                Statement stmt = connect.createStatement();) {

            // execute statement - note DB needs to perform full processing
            // on calling executeQuery
            // using simple string concatenation for variable data is 
            // !!! A VERY POOR APPROACH AND MOST LIKELY A SQL INJECTION FLAW IS CREATED !!!!
            result = stmt.executeUpdate("UPDATE MANUFACTURER SET EMAIl='"
                    + email + "' WHERE MANUFACTURER_ID = 19986982");
            JOptionPane.showMessageDialog(null, "Row count = " + result);
            JOptionPane.showMessageDialog(null, "The following statement" +
                    "has been executed:\n"+
                    "UPDATE MANUFACTURER SET EMAIl='"
                    + email + "' WHERE MANUFACTURER_ID = 19986982");
            // deal with any potential exceptions
            // note: all resources are closed automatically - no need for finally
        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, "Message: " + sql.getMessage());
            JOptionPane.showMessageDialog(null, "Code: " + sql.getSQLState());
        }
        return result > 0;
    }

    /**
     * Modifies a given manufacturer entry by updating the email to the given
     * string.<br>
     *
     * @param email - new value for email
     * @return - at least one row has been modified, false otherwise
     */
    public boolean modifyEntryPreparedStatement(String email) {
        String data;
        int result = 0;
        // sql string for prepared statement - note the use of the ? for the
        // used parameter (email value)
        String sql = "UPDATE MANUFACTURER SET EMAIl = ? WHERE MANUFACTURER_ID = 19986982";
        // use try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement stmt = connect.prepareStatement(sql);) {

            // set parameter value (note: indicies start with 1)
            stmt.setString(1, email);
            result = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Row count = " + result);
            // deal with any potential exceptions
            // note: all resources are closed automatically - no need for finally
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Message: " + sqlex.getMessage());
            JOptionPane.showMessageDialog(null, "Code: " + sqlex.getSQLState());
        }
        return result > 0;
    }

    /**
     * Demonstrates how to invoke a data definition language statement - this
     * method creates a table
     */
    public void useDDLStatement() {
        String data;
        int result;
        // sql string for prepared statement - note the use of the ? for the
        // used parameter (email value)
        String sql = "CREATE TABLE TEST(ID INTEGER, NAME VARCHAR(30), PRIMARY KEY(ID))";
        // use try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement stmt = connect.prepareStatement(sql);) {

            result = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Row count from create = " + result);
            // deal with any potential exceptions
            // note: all resources are closed automatically - no need for finally
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Message: " + sqlex.getMessage());
            JOptionPane.showMessageDialog(null, "Code: " + sqlex.getSQLState());
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JDBCConnection app = new JDBCConnection();
        JOptionPane.showMessageDialog(null, "Starting Application ...");
        JOptionPane.showMessageDialog(null, "Display all customers ...");
        //app.displayAllCustomerTraditional();
        // alternatively, use try-with-resource
        app.displayAllCustomerTryResource();

        /*JOptionPane.showMessageDialog(null, "Modify entry with string concatenation ...");

        String input = "sss@yyy.com";
        // call bad version without attack
        app.modifyEntryBadVersion(input);
        // call bad version with 'attack' - here we just change the behaviour of
        // the insert statement ... think what potentially can be done ...
        input = "x' WHERE MANUFACTURER_ID<0 --";
        app.modifyEntryBadVersion(input);

        JOptionPane.showMessageDialog(null, "Modify entry with prepared statements ...");
        input = "watch@bird.com";
        app.modifyEntryPreparedStatement(input);

        // try attack again
        input = "x' WHERE MANUFACTURER_ID<0 --";
        app.modifyEntryPreparedStatement(input);
        JOptionPane.showMessageDialog(null, "Use DDL Statement ...");
        // call method with DDL statement
        app.useDDLStatement();*/
        System.exit(0);
    }

}
