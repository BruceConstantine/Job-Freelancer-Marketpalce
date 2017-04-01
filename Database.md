# Data base
## 有想法就在这里修改
<i> 数据库表结构 </i>
  * Table Content (Formalazation)
    <br/>
  
    <i>(Primary Key)</i><br/>
    ~ Product :	  **ProductID**, ProductName, TypeID, Quantity<br/>
    ~ TypeProduct: **<i>TypeID</i>**, TypeText<br/>
    ~ User : **<i>UserID</i>**, UserName,psd ,Address, phoneNumber, Email,UserMSG (500 VarChar), UserType(0,1)<br/>
  old //  ~ Cart: **<i>UserID, ItemID</i>**, Item_quantity, Item_price, Total_price, Date.<br/>
  old // ~ Order :OrderID, **<i>UserID, Item_ID</i>**, Order_quantity, Order_price, Total_price, Order_date<br/><br/>
  
  <h2>new #(*为主键)4个表，订单，购物车，订单记录，用户地址</h2>

Ordering(*order_id,*item_ID，user_id,product_quantitity)

Cart(*user_id,*item_id,item_quantity,date)

order_record(*user_id,*order_id,total_price,order_date,status,address)

Userid_Addressid(*user_id,*address_id,address) 


(E.G.)	123456,000002,1,2,PACKING,null,140,4.99,144.99,21/03/2017,London
	123458,000002,2,2,SHIPPED,null,140,4.99,144.99,21/03/2017,London
	123457,000002,3,2,SHIPPED,null,140,4.99,144.99,21/03/2017,London
	123459,000002,3,2,ACCEPT,null,140,4.99,144.99,21/03/2017,London
