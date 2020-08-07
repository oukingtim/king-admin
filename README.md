## 项目说明
# king-admin
king-admin是一个超酷的前后端分离的基础权限管理后台，前端：angularJs+bootstrap+gulp，后端：spring-boot+mybatis-plus(分java版和kotlin版)

## [项目演示](http://120.78.202.43:8083/)
账号：king
密码：king

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
http://localhost:5000

后端：

```
cd king-admin-java  或者 cd king-admin-kotlin

mvn install -Dmaven.test.skip=true
```
运行 KingAdminJavaApplication.java 或者 KingAdminKotlinApplication.kt

http://localhost:8080

## 注：
java用了lombok注解简化代码，请下载lombok插件
如果不前后端分离部署，可以cd king-admin-angularjs 运行 gulp 命令打包生成static 
然后替换到java或kotlin的resource里


## 效果展示

![](https://p6-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/9162a234640a4734bf5d2d8020803fdb~tplv-k3u1fbpfcp-zoom-1.image)
![](https://p9-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/c9d753d7e6b44e3681824aeab4bd4dc2~tplv-k3u1fbpfcp-zoom-1.image)
![](https://p6-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/db5fef5d57aa4fe293b67861b17f5b38~tplv-k3u1fbpfcp-zoom-1.image)
![](https://p6-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/4f3c1a9a06d749dc82bdbc9cf87a52bf~tplv-k3u1fbpfcp-zoom-1.image)
![](https://p1-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/0ba3ac0c28c8419d874c2115cb14efdf~tplv-k3u1fbpfcp-zoom-1.image)
![](https://p9-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/e710b6b196f94b86b8b21b6a4e58a8d4~tplv-k3u1fbpfcp-zoom-1.image)
![](https://p1-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/ccfcde374a924e04bdc09909522f7268~tplv-k3u1fbpfcp-zoom-1.image)
![](https://p1-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/d2f92e8f586f444b8327dc7cc8e3c0b7~tplv-k3u1fbpfcp-zoom-1.image)


## 鸣谢

[Blur Admin](http://akveo.github.io/blur-admin/)

[mybatis-plus](https://git.oschina.net/baomidou/mybatis-plus)

## License
[MIT](LICENSE.txt) license.


