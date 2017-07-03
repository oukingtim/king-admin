## 项目说明
# king-admin
king-admin是一个前后端分离的基础权限管理后台，前端：angularJs+bootstrap+gulp，后端：spring-boot+mybatis-plus(分java版和kotlin版)

## 项目部署

执行 king-admin.sql

前端：
```
cd king-admin-angularjs

npm install -g gulp cnpm bower

cnpm install

bower install

gulp serve
```
后端：

```
cd king-admin-java  或者 cd king-admin-kotlin

mvn install -Dmaven.test.skip=true
```
运行 KingAdminJavaApplication.java 或者 KingAdminKotlinApplication.kt

## 效果展示

![image](https://github.com/oukingtim/king-admin/blob/master/screenshots/login.png)
![image](https://github.com/oukingtim/king-admin/blob/master/screenshots/home.png)
![image](https://github.com/oukingtim/king-admin/blob/master/screenshots/userlist.png)
![image](https://github.com/oukingtim/king-admin/blob/master/screenshots/user.png)
![image](https://github.com/oukingtim/king-admin/blob/master/screenshots/role.png)
![image](https://github.com/oukingtim/king-admin/blob/master/screenshots/menu.png)
![image](https://github.com/oukingtim/king-admin/blob/master/screenshots/phone1.png)
![image](https://github.com/oukingtim/king-admin/blob/master/screenshots/phone2.png)


