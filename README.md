# JettyProject
## Jetty+Jersey+IDEA后端
在IDEA同步代码使用

克隆到本地后确认添加Libraries

右键pom.xml->Maven->Reimport解决依赖关系

pom.xml中的内容不要随意改动

运行`JettyServerStart.java`启动服务器，在浏览器地址栏输入`localhost:8080/dynamic`，显示OK，
输入`localhost:8080/static`，显示静态资源文件，即为成功

`ConnMongoDB.java`为测试连接MongoDB数据库使用，未装数据库可不用理会
