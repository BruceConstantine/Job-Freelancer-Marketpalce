<h1>Day 1</h1>
 Cart: **<i>UserID, ItemID</i>**, Item_quantity, Item_price, Total_price, Date.<br/>
 Order :OrderID, **<i>UserID, Item_ID</i>**, Order_quantity, Order_price, Total_price, Order_date<br/><br/>
 

## (*为主键)4个表，订单，购物车，订单记录，用户地址
- Ordering(**Urder_ID(int),Product_ID(int)**，User_ID(int),Product_Quantity(int))
- Cart(**User_ID(int),Product_ID(int）**,Product_Quantity(int),Date(date))
- order_record(**User_ID(int),Order_ID(int)**,Total_Price(double),Order_Date(date),Status(int),Address(Text))
- address(**User_ID(int),Address_ID(int)**,Address(Text)) 

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
