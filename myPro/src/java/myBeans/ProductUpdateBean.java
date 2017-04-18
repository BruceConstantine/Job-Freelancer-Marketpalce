/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myBeans;

import dataBeans.*;
import JDBC.ProductJDBC; 
import java.beans.*;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.*;
import javax.ejb.EJB;
import javax.faces.bean.*;
import javax.inject.Named;

/**
 *
 * @author Natalija
 */

@ManagedBean(name = "productBean")
@SessionScoped
public class ProductUpdateBean implements Serializable  { 
    
    ProductJDBC productJDBC ; 
    
    Integer productID ; 
    public String productName;
    private int typeID;
    private int quantity;
    private float price;
    private int size;
    private String productMSG;
    
    private List<Product> productsAll; 
    /**
     * Creates a new instance of myManagedBean
     */
    
    public ProductUpdateBean() throws SQLException {
        productJDBC = new ProductJDBC();
        readProductsAllFromDB();
   }

    public ProductUpdateBean( Integer productID, String productName, int typeID, int quantity, float price, int size, String productMSG) throws SQLException {
        this.productJDBC = new ProductJDBC();
        this.productID = productID;
        this.productName = productName;
        this.typeID = typeID;
        this.quantity = quantity;
        this.price = price;
        this.size = size;
        this.productMSG = productMSG;
        readProductsAllFromDB();
    }
    private void readProductsAllFromDB() throws SQLException{
        this.productsAll = productJDBC.getAllProducts();
    }

    public void addNewProduct( String productName, int typeID, int quantity, float price, int size, String productMSG) throws SQLException {
       productsAll.add(new Product (productName, typeID, quantity, price, size, productMSG));
       productJDBC.InsertNewProduct( productName, typeID, quantity, price, size, productMSG);
    } 
    
    public void removeProduct(Product  p) throws SQLException {
        productsAll.remove(p);
        productJDBC.deleteProduct( p.getProductID() );        
    }
 
    
    public void saveProducts() throws SQLException {
        for (Product p : this.productsAll) {
            p.setCanEdit(false);
            productJDBC.modifyQuantityofProduct(p.getProductID(), p.getQuantity());
        }
    } 
     
    public void editProduct(Product p) {
        p.setCanEdit(true);
    }
    
//    public void cancelEdit(Product p) {
//        p.setCanEdit(false);
//    } 
     
    public List<Product > getProductByName(String productName) {
        ArrayList<Product > result = new ArrayList<>();
        // find all friends with given surname and add to result
        for (Product p : productsAll) {
            if (p.getProductName().compareTo(productName) == 0) {
                result.add(p);
            }
        }
        return result;
    }

//    /**
//     * Sorts the collection of friends by surname
//     */
//    public void sortBySurname() {
//        Collections.sort(friends);
//    }
//
//    /**
//     * Sorts the collection of friends by name
//     */
//    public void sortByFirstname() {
//        Collections.sort(friends, new FirstnameSorter());
//    }
//
//    /**
//     * Sorts the collection of friends by age
//     */
//    public void sortByAge() {
//        Collections.sort(friends, new AgeSorter());
//    }

    /**
     * Method to add a new friend to the collection. values will be taken
     * from attributes
     */ 

    /**
     * removes a person from the collection
     * @param p Person to be removed
     */
     
     
     
     
     
     
     
     
     
     
     
    /*Getter and Setter*/
    public ProductJDBC getProductJDBC() {
        return productJDBC;
    }

    public void setProductJDBC(ProductJDBC productJDBC) {
        this.productJDBC = productJDBC;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getProductMSG() {
        return productMSG;
    }

    public void setProductMSG(String productMSG) {
        this.productMSG = productMSG;
    }

    public List<Product> getProductsAll() {
        return productsAll;
    }

    public void setProductsAll(List<Product> productsAll) {
        this.productsAll = productsAll;
    }
     
     
     
}
    