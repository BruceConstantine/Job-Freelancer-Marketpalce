# Glassfish #
下载下来之后解压缩<br/>
里面有一个MySQL的connector，把这个东西放到这个目录里:  ....\payara41\glassfish\domains\domain_goodGlassFish\lib\ext<br/>
其中 domain_goodGlassFish 这个东西是你在NetBeans里引入服务器时建立的domain的名字<br/>
<i>在NetBeans里的Tools菜单里点击Server选项，添加服务器</i>

# Connection pool#
登陆 http://localhost:4848<br/>
先 Create new JDBCConnection Pool<br/> 
再 Create new JDBC Source<br/>
按照图片所示进行配置。<br/>

- 先建立连接池

  ![先建立连接池](/Config_Server_and_ConnectionPool/newJDBCConnectionPool.jpg)<br/>
  
- additional配置
 ![additional配置](/Config_Server_and_ConnectionPool/addional%20Properities.jpg)
 这个很重要<br/>里面的username和password是你数据库的信息。而且driverClass必须要写。

- 成功建立后ping一下
 ![成功建立后ping一下](/Config_Server_and_ConnectionPool/ping.jpg)<br/>

- 再新建一个JDBC的资源_step1
 ![再新建一个JDBC的资源_step1](/Config_Server_and_ConnectionPool/new%20JDBC%20Resource.jpg)<br/>

- 再新建一个JDBC的资源_step2
 ![再新建一个JDBC的资源_step2](/Config_Server_and_ConnectionPool/JDBC资源.jpg)<br/>
<br/>
最后OK了
