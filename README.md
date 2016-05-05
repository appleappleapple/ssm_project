# Spring+SpringMVC+Mybatis+Maven+MySql框架搭建与分页实例   #
**1. 工程运行环境**  
JDK:1.6  
TOMCAT7  
Windows7/Eclipse luna  
对应博文：[http://blog.csdn.net/evankaka/article/details/49452201](http://blog.csdn.net/evankaka/article/details/49452201)     
打开方式:打开Eclipse,选择File->import->Existing Maven Project,找到项目的pom文件，导入即可。（注意，要安装好Maven,建议直接下一个java ee版本的eclipse,它集成了maven）  
**2. 后台使用到的框架**  
Spring+SpringMVC+Mybatis+Maven  
日志使用：logback  
数据库使用:Mysql  
后台分页使用：PageHelp(与Mybatis一起使用)  
**3. 前台使用**  
框架：Bootstarp+JSP  
**4. 数据源配置**  
数据库配置修改  
请修改POM.XML中的profiles里的内容，将jdbc_url、jdbc_username、jdbc_password修改成自己的，示例如下：     
`<jdbc_driverClassName>com.mysql.jdbc.Driver</jdbc_driverClassName>`      
`<jdbc_url>jdbc:mysql://localhost:3306/learning</jdbc_url>`  
`<jdbc_username>root</jdbc_username>`  
`<jdbc_password>christmas</jdbc_password>`   
      
**5. 建表语句**   
    CREATE DATABASE learning;  
    USE learning;  
    CREATE TABLE `t_user` (  
       `USER_ID` int(11) NOT NULL AUTO_INCREMENT,  
      `USER_NAME` char(30) NOT NULL,  
      `USER_PASSWORD` char(10) NOT NULL,  
      `USER_EMAIL` char(30) NOT NULL,  
      PRIMARY KEY (`USER_ID`),  
      KEY `IDX_NAME` (`USER_NAME`)  
    ) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8  

**6. 数据插入**  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (1, '林炳文', '1234567@', 'ling20081005@126.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (2, 'evan', '123', 'fff@126.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (3, 'kaka', 'cadg', 'fwsfg@126.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (4, 'simle', 'cscs', 'fsaf@126.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (5, 'arthur', 'csas', 'fsaff@126.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (6, '小德', 'yuh78', 'fdfas@126.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (7, '小小', 'cvff', 'fsaf@126.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (8, '林林之家', 'gvv', 'lin@126.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (9, '林炳文Evankaka', 'dfsc', 'ling2008@126.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (10, 'apple', 'uih6', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (11, 'apple', 'tgggg', '43qt@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (12, 'apple', 'ggg', '14e23@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (13, 'apple', 'gg', '122@qq.com');    
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (14, 'apple', 'dsv', '34r@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (15, 'apple', 'vvfdz', '456@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (16, 'apple', 'vz', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (17, 'apple', 'zvz', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (18, 'apple', 'dvs', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (19, 'apple', 'czvcx', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (20, 'apple', 'xvzczv', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (21, 'apple', 'cz', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (22, 'apple', 'cxz', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (23, 'apple', 'czv', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (24, 'apple', 'C', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (25, 'apple', 'dfdsf', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (26, 'apple', 'vvf', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (27, 'apple', '45', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (28, 'apple', '5677', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (29, 'apple', '8', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (30, 'apple', '8', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (31, 'apple', '0h', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (32, 'apple', 'vf', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (33, 'apple', 'sfd', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (34, 'apple', '5yh', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (35, 'apple', 'bdf', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (36, 'apple', 'gers', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (37, 'apple', '89', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (38, 'apple', '5t', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (39, 'apple', 'gse', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (40, 'apple', 'gs', 'ff@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (41, 'apple', 'bs', '4454@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (42, 'apple', 'fs', '3445@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (43, 'apple', 'bs', '354@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (44, 'apple', 'fsd', '567@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (45, 'apple', 'sd', '45567@qq.com');  
    INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES (46, 'apple', 'gs', '456@qq.com');  
   
