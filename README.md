# 项目重点说明
## 要求
- Deadline: 4.22
- Format: **Singal .zip/.rar File** (包含NetBeans Project & Report:<b>WORD||PDF</b>)
- 简述: 制作一个web应用并部署在虚拟机上（JavaEE Container & 数据库自选）
- 开发环境: NetBeans
- 技术要求: 主要部分必须由 EJB; Entity Class; JSF 实现

## 分数分布

1. **成功部署**						                           | ***10分***
2. 应用(是否完成所有的要求; **代码注释质量**; 代码风格 )  | 15分
3. **报告中指出怎么用技术解决安全问题**			            | 8分
4. **报告中指出测试应用的安全性能**			                | 7分




<h1>### Hi guys, please write your idea on the README.MD ###<h1/>
<h1> 翻译：嘿 老铁们， 写下你们的灵感 可以关于任何的灵感， 留下你的建议我们的下次会议会以此展开讨论<h1/>
# Actors:

<h5>Jason 的想法： 1. 是否可以让用户查看自己的购买历史， 如果可以的话可以在建个记录的table 2017/3/29<h5/>
<h5>2. 建议在数据库中加入图片的存储路径<h5/>
<h5>3. 建议一周内完成数据库的建立和实际操作（增删改查）<h5/>
<h5>4. 探究 Server如何实现<h5/>
<h5>5. 虚拟机。。<h5/>
<h5>6. 继续探讨project要求 2017/3/31<h5/>
<span style="color:red"> 小伙子有想法很好 。</span>

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
            – provide search by{
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
    ~ Product :   <i><b>ProductID</b></i>,  ProductName, ,Quantity<br/>
    ~ User    :   <i><b>UserID</b></i>, UserName,psd ,Address, phoneNumber, Email,UserMSG (500 VarChar), UserType<br/>
    ~ Order   :   <i><b>OrderID,  UserID</b></i> ProductID_List<br/>
  
  
# Back-end
  * 
  * 
  
# Fore-End
  
