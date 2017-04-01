# Data base

  * Table Content (Formalazation)
    <br/>
  
    <i>(Primary Key)</i><br/>
    ~ Product :	  **ProductID**, ProductName, TypeID, Quantity<br/>
    ~ TypeProduct: **<i>TypeID</i>**, TypeText<br/>
    ~ User : **<i>UserID</i>**, UserName,psd ,Address, phoneNumber, Email,UserMSG (500 VarChar), UserType(0,1)<br/>
    ~ Cart: **<i>UserID, ItemID</i>**, Item_quantity, Item_price, Total_price, Date.<br/>
    ~ Order :OrderID, **<i>UserID, Item_ID</i>**, Order_quantity, Order_price, Total_price, Order_date<br/><br/>
(E.G.)	123456,000002,1,2,PACKING,null,140,4.99,144.99,21/03/2017,London
	123458,000002,2,2,SHIPPED,null,140,4.99,144.99,21/03/2017,London
	123457,000002,3,2,SHIPPED,null,140,4.99,144.99,21/03/2017,London
	123459,000002,3,2,ACCEPT,null,140,4.99,144.99,21/03/2017,London
