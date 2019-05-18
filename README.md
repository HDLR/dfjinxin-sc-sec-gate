# dfjinxin-fast  Spring Cloud and Spring Cloud Alibaba
# 架构图
![image.png](
https://github.com/HDLR/dfjinxin-sc-sec/blob/master/dfjinxin-monitor/software/imag/dfjinxin-sc-sec技术栈图形.jpg
)

自己在本机上装redis或者有可访问的redis

一、服务注册中心nacos
![image.png](
https://github.com/HDLR/dfjinxin-sc-sec/blob/master/dfjinxin-monitor/software/imag/1.jpg
)
初始化数据库，ag_nacos.sql
将nacos.zip解压，nacos默认连接的mysql数据库账号密码是root/123456，如需修改，在nacos\conf\application.properties中修改
![image.png](
https://github.com/HDLR/dfjinxin-sc-sec/blob/master/dfjinxin-monitor/software/imag/2.jpg
)
启动：在bin中执行cmd命令.\startup.cmd -m standalone
访问路径http://localhost:8848，账号密码nacos/nacos
![image.png](
https://github.com/HDLR/dfjinxin-sc-sec/blob/master/dfjinxin-monitor/software/imag/3.jpg
)
![image.png](
https://github.com/HDLR/dfjinxin-sc-sec/blob/master/dfjinxin-monitor/software/imag/4.jpg
)

