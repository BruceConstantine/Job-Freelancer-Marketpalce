<h1>Day 1</h1>
 Cart: **<i>UserID, ItemID</i>**, Item_quantity, Item_price, Total_price, Date.<br/>
 Order :OrderID, **<i>UserID, Item_ID</i>**, Order_quantity, Order_price, Total_price, Order_date<br/><br/>


<h2>#(*为主键)4个表，订单，购物车，订单记录，用户地址</h2>

Ordering(*order_id,*item_ID，user_id,product_quantitity)

Cart(*user_id,*item_id,item_quantity,date)

order_record(*user_id,*order_id,total_price,order_date,status,address)

Userid_Addressid(*user_id,*address_id,address)  


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
