
package dataBeans;
 
import java.beans.*;
import java.io.Serializable;
import java.sql.SQLException;

/**
 *
 * @author tzk 
    */
 
public class Product implements Serializable {
 
    // required field for Serializable
    private static final long serialVersionUID = 1;
  
    private Integer productID;
    private String productName;   
    private int typeID;
    private int quantity;
    private float price;
    private int size;
    private String productDescribe;
    private boolean canEdit;

    public Product() throws SQLException{
        this.productID = JDBC.ProductJDBC.getMaxProductID();
        this.productName = "";
        this.typeID = 0;
        this.quantity = 0;
        this.price = 0;
        this.size = 0;
        this.productDescribe = "";
        canEdit = false;
    }
    
    public Product(Integer productID){
        this.productID = productID;
        this.productName = "";
        this.typeID = 0;
        this.quantity = 0;
        this.price = 0;
        this.size = 0;
        this.productDescribe = "";
        canEdit = false;
    }
    
     public Product( String productName, int typeID, int quantity, float price, int size, String productDescribe) throws SQLException {
        this.productID = JDBC.ProductJDBC.getMaxProductID();
        this.productName = productName;
        this.typeID = typeID;
        this.quantity = quantity;
        this.price = price;
        this.size = size;
        this.productDescribe = productDescribe;
        canEdit = false;
    }
    
    public Product(Integer productID, String productName, int typeID, int quantity, float price, int size, String productDescribe) {
        this.productID = productID;
        this.productName = productName;
        this.typeID = typeID;
        this.quantity = quantity;
        this.price = price;
        this.size = size;
        this.productDescribe = productDescribe;
        canEdit = false;
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

    public String getProductDescribe() {
        return productDescribe;
    }

    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe;
    }

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }
    
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) productID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if (this.productID != other.productID){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dataBeans.Customer[ id=" + productID + " ]";
    }
    
}
 