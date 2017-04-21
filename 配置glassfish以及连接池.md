# Glassfish #
下载下来之后解压缩
里面有一个MySQL的connector，把这个东西放到这个目录里:  ....\payara41\glassfish\domains\domain_goodGlassFish\lib\ext
其中 domain_goodGlassFish 这个东西是你在NetBeans里引入服务器时建立的domain的名字

# Connection pool#
登陆 http://localhost:4848
先 Create new JDBCConnection Pool 
再 Create new JDBC Source
按照图片所示进行配置。

