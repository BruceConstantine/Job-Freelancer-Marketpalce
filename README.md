# 项目重点说明
## 要求
- Deadline: 4.22
- Format: **Singal .zip/.rar File** (包含NetBeans Project & Report:<b>WORD||PDF</b>)
- �?�?: 制作�?个web应用并部署在虚拟机上（JavaEE Container & 数据库自选）
- �?发环�?: NetBeans
- �?术要�?: 主要部分必须�? EJB; Entity Class; JSF 实现
2222ss
## 分数分布

1. **成功部署**						                           | ***10�?***
2. 应用(是否完成�?有的要求; **代码注释质量**; 代码风格 )  | 15�?
3. **报告中指出�?�么用技术解决安全问�?**			            | 8�?
4. **报告中指出测试应用的安全性能**			                | 7�?


## 文档格式
### 避免安全问题: **Top 10 vulnerabilities**
明确地说明如何的避免安全问题：用了什么techniques,怎么用的
+ 注入
+ 跨站脚本攻击
+ 功能级访问控制缺�?
+ 跨站请求伪�??
+ etc. etc...

*�?:写作要一目了�?*

### 测试的步�?
用截屏加解释的方�?,来讲述如何确保该web应用的安全�?�的�?

### 部署问题
+ 必须部署到JavaEE Server�?
+ 并且**要在文档中清楚扼要地说明如何部署�?**

# 要求Server部署在UL ECE的VMware的虚拟机�?
- 联系**<http>eoin.oconnell@ul.ie</http>**部署虚拟�?(�?好提前一周，免得这货又有事不在UL...)
- 或�?�部署在自己的电脑上，具体还真不清楚。�?��?��??**回去好好看看，问问�?? 回去好好看看，问问�?? 回去好好看看，问问�?�重要的事情说三�?**





# Hi guys, please write your idea on the README.MD 

# 翻译：嘿 老铁们， 写下你们的灵�? 可以关于任何的灵感， 留下你的建议我们的下次会议会以此展开讨论 
## Jason 的想法：
1. 是否可以让用户查看自己的购买历史�? 如果可以的话可以在建个记录的table 2017/3/29
2. 建议在数据库中加入图片的存储路径
3. 建议�?周内完成数据库的建立和实际操作（增删改查�?
4. 探究 Server如何实现
5. 虚拟机�?��??
6. 继续探讨project要求 

*2017/3/31*
## ZHIKANG :
- 每一个功能分散成�?�?.java文件,便于修改和�?�师查看 
	*i.e. 像是JJ的project: �?个类（或文件）只写出�?个spec中要求的功能*
- 注意安全问题: 要对用户输入的所有信息进行合理的验证，避免输入注入以及跨站脚�?
  
*2017/4/1*

<hr/>

# Actors:

  1.Clients
    
    * Browse products
    * Search productes 
         - by {
          1. ID 
          2. Name
        }   
        &&  Display the results.
    * Add/Remove products into/from CART
    * Edit Clients' Profile
        # NAME
        # CustomerID        
          ~ Name and ID are taken from Customer table
        # Message to other users
        # View profiles from other users 
            �? provide search by{
                1. name 
                2.ID
              }
        # Check out/cancel current order
        
        
        
  2.Adminitors

    * add new product
    * delete product
    * change product stock number



# User-case 
* customers cancel their order, the database should remain unchanged.


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


  
# Back-end
  * 
  * 
  
# Fore-End
  
