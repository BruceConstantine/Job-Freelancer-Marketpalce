/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import dataBeans.Customer;
import dataBeans.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author MEIYU_QI
 */
public class ProductJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/amazonsystemdb";
    private static final String USER = "root";
    private static final String PASSWD = "123";
    
    public static int getMaxProductID() throws SQLException{
        Connection connect = null;
        Statement stmt = null;
        ResultSet result;
        int maxID = -1;
        try {
            // connect to db - mrrtake sure derbyclient.jar is added to your project
            connect = DriverManager.getConnection(URL, USER, PASSWD);
            // obtain statement from connection
            stmt = connect.createStatement();
            // execute statement - note DB needs to perform full processing
            // on calling executeQuery
            result = stmt.executeQuery("SELECT *  FROM product");
            // process results
            // while there are results
            while(result.next()){
                int temp_int = result.getInt("ProductID");
                if( maxID <  temp_int  )
                    maxID =  temp_int ;
            } 
        }
        catch(SQLException e){e.printStackTrace();}
        finally {
            if (stmt != null) {
                stmt.close();
            }
            if (connect != null) {
                connect.close();
            }
        }
        return  maxID;
    }
    
    public  List<Product>  getAllProducts() throws SQLException{
        List<Product> products = new ArrayList<Product>();
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
            result = stmt.executeQuery("SELECT * FROM product");
            // process results
            // while there are results
            while (result.next()) {
                products.add( 
                        new Product(result.getInt(1),
                                result.getString(2), 
                                result.getInt(3),
                                result.getInt(4), 
                                result.getFloat(5), 
                                result.getInt(6),
                                result.getString(7))
                ); 
            }
        }
        catch(SQLException e){e.printStackTrace();}
        finally {
            if (stmt != null) {
                stmt.close();
            }
            if (connect != null) {
                connect.close();
            }
        } 
        return products;
    }
    
    public void displayAllProductType(){
        String data = "";
        try{
         // Connection con = DriverManager.getConnection(URL);
        Connection con = DriverManager.getConnection(URL, USER, PASSWD);
        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM producttype");
        
        while(result.next()){
             data += "Product Type Id "+ result.getString(1)+" Product type name: "+ result.getString(2);
             JOptionPane.showMessageDialog(null, data);
        }
        }
        catch(Exception e){
            e.printStackTrace();
            //System.out.println("connection error");
        }
    }
    
    public void displayProductById(int Id){
        String data = "";
        try{
         // Connection con = DriverManager.getConnection(URL);
        Connection con = DriverManager.getConnection(URL, USER, PASSWD);
        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM product where ProductID = "+Id);
        
        while(result.next()){
             data += "Product ID "+ result.getString(1)+" Product Name: "+ result.getString(2);
             JOptionPane.showMessageDialog(null, data);
        }
        }
        catch(Exception e){
            e.printStackTrace();
            //System.out.println("connection error");
        }
    }
     public void displayProductByName(String name){
        String data = "";
        try{
         // Connection con = DriverManager.getConnection(URL);
        Connection con = DriverManager.getConnection(URL, USER, PASSWD);
        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM product where ProductName = "+ name);
        
        while(result.next()){
             data += "Product ID "+ result.getString(1)+" Product Name: "+ result.getString(2);
             JOptionPane.showMessageDialog(null, data);
        }
        }
        catch(Exception e){
            e.printStackTrace();
            //System.out.println("connection error");
        }
     }
        
    public boolean isExistProduct( String productName) throws SQLException{
        boolean exist = false; 
        Connection con = null;
        Statement stmt = null;
        ResultSet result = null;
        try{
            // Connection con = DriverManager.getConnection(URL);
            con = DriverManager.getConnection(URL, USER, PASSWD);
            stmt = con.createStatement();
            result = stmt.executeQuery("SELECT COUNT(*) AS total FROM product where ProductName = '"+ productName+"'");
            result.next();
            if(result.getInt("total") > 0)
                exist = true;   
        }
        catch(Exception e){
            e.printStackTrace();
            //System.out.println("connection error");
        }
        finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } 
        return exist;
    } 
     
    public boolean InsertNewProduct(String ProductName,int TypeID,int Quantity,float Price,int Size, String ProductDescribe) throws SQLException {
        if(isExistProduct(ProductName)){
            System.out.println(" Product alridy exist.");
            return false;
        }
        int ProductID = ProductJDBC.getMaxProductID() + 1;
        int result = 0;
        Statement stmt = null;
        Connection connect = null;
        // use try with resource
        try {
            connect = DriverManager.getConnection(URL, USER, PASSWD); 
            stmt = connect.createStatement();
            result = stmt.executeUpdate(  "INSERT INTO Product(ProductID, ProductName, TypeID, Quantity, Price,  Size, ProductDescribe ) " +" VALUES("+ ProductID+" , '" + ProductName+"' , " + TypeID+" , " + Quantity+" , " + Price +" , " + Size+ ",'" + ProductDescribe +"')");
        } catch (SQLException sql) {
           sql.printStackTrace(); 
        }
        finally {
            if (stmt != null) {
                stmt.close();
            }
            if (connect != null) {
                connect.close();
            }
        } 
        return result > 0;         
    }
        
    public boolean deleteProduct(int ProductID) throws SQLException {
        String data;
        int result = 0;
        Statement stmt = null;
        Connection connect = null;
        // use try with resource
        try {
            connect = DriverManager.getConnection(URL, USER, PASSWD); 
            stmt = connect.createStatement();
            result = stmt.executeUpdate("delete from product where ProductID='"+ ProductID +"'");
        } catch (SQLException sql) {
           sql.printStackTrace(); 
        }
        finally {
            if (stmt != null) {
                stmt.close();
            }
            if (connect != null) {
                connect.close();
            }
        } 
        return result > 0;
    } 
   
    
public boolean modifyQuantityofProduct(int ProductID, int Quantity) throws SQLException {
         int result = 0;
         Statement stmt = null;
         Connection connect = null; 
        // use try with resource
        try {
             connect= DriverManager.getConnection(URL, USER, PASSWD);
             stmt = connect.createStatement();
                result = stmt.executeUpdate("UPDATE Product SET Quantity='"
                    + Quantity + "' WHERE ProductID =" + ProductID);
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        finally {
            if (stmt != null) {
                stmt.close();
            }
            if (connect != null) {
                connect.close();
            }
        }
        return result > 0;
    }

}
