# 说明

本项目为一个简单的 spark 连接 hive 的项目

# 环境构建
- 配置JDK: file -> project structure -> library -> add jdk
- 配置SDK: file -> project structure -> library -> add SDK
- 配置Maven: file -> settings -> Build,Execution,Deployment -> Maven

# 配置要求
- core-site.xml 替换为自己的集群配置文件
- hdfs-site.xml 替换为自己的集群配置文件
- hive-site.xml 替换为自己的集群配置文件

# 运行
mvn clean package
