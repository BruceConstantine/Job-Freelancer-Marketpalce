<h1>Day 1</h1>
 Cart: **<i>UserID, ItemID</i>**, Item_quantity, Item_price, Total_price, Date.<br/>
 Order :OrderID, **<i>UserID, Item_ID</i>**, Order_quantity, Order_price, Total_price, Order_date<br/><br/>
 

## (*为主键)4个表，订单，购物车，订单记录，用户地址
- Order(<i>**Order_ID(int),Product_ID(int)**</i>，Username(VARCHAR20),Product_Quantity(int))
- Cart(<i>**Username(VARCHAR20),Product_ID(int）**</i>,Product_Quantity(int),Date(Timestamp))
- order_record(<i>**Username(VARCHAR20),Order_ID(int)**</i>,Total_Price(double),Order_Date(Timestamp),Status(int),Address(Text))
- address(<i>**Username(VARCHAR20),Address_ID(int)**</i>,Address(Text)) 

粗体是主键，所有全都是not null
<h1>-------分配-------- </h1>


<h3>林青</h3>
物品加入购物车
修改购物车

<h3>jiasen</h3>
提交
取消订单
修改地址

<h3>周一飞</h3>
浏览历史订单
选择性支付
