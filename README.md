# dfjinxin-fast  Spring Cloud and Spring Cloud Alibaba
# 架构图
![image.png](
https://github.com/HDLR/dfjinxin-sc-sec/blob/master/dfjinxin-monitor/software/imag/dfjinxin-sc-sec技术栈图形.jpg
)

自己在本机上装redis或者有可访问的redis

一、服务注册中心nacos
<br>
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

二、dfjinxin-monitor系统监控模块

![image.png](
https://github.com/HDLR/dfjinxin-sc-sec/blob/master/dfjinxin-monitor/software/imag/5.jpg
)

在DfjinxinMonitorApplication.java类点击右键启动就行

![image.png](
https://github.com/HDLR/dfjinxin-sc-sec/blob/master/dfjinxin-monitor/software/imag/7.jpg
)

![image.png](
https://github.com/HDLR/dfjinxin-sc-sec/blob/master/dfjinxin-monitor/software/imag/6.jpg
)


三、网关dfjinxin-gate

![image.png](
https://github.com/HDLR/dfjinxin-sc-sec/blob/master/dfjinxin-monitor/software/imag/8.jpg
)

在DfjinxinGateApplication.java上点击右键启动即可

四、正式后台管理dfjinxin-fast

![image.png](
https://github.com/HDLR/dfjinxin-sc-sec/blob/master/dfjinxin-monitor/software/imag/9.jpg
)

创建数据库dfjinxin-fast，执行dfjinxin-fast.sql

![image.png](
https://github.com/HDLR/dfjinxin-sc-sec/blob/master/dfjinxin-monitor/software/imag/10.jpg
)

在dfjinxin-fast中的DfjinxinFastApplication.java类上点击右键启动，数据账号密码如果不是默认的root/123456，可在配置文件中修改

![image.png](
https://github.com/HDLR/dfjinxin-sc-sec/blob/master/dfjinxin-monitor/software/imag/11.jpg
)

五、前端dfjinxin-fast-vue

![image.png](
https://github.com/HDLR/dfjinxin-sc-sec/blob/master/dfjinxin-monitor/software/imag/12.jpg
)

在dfjinxin-fast-vue工程路径下执行yarn install安装所有依赖，执行npm install也可以，但最好还是yarn，后期统一一下，以免造成不必要的麻烦。虽然大致相同，但多少还是有细微差异。
安装完依赖后执行yarn serve启动前端工程

以上的内容全部操作完成后可以登录系统，http://localhost:8001/#/login，初始化账号密码admin/admin。

![image.png](
https://github.com/HDLR/dfjinxin-sc-sec/blob/master/dfjinxin-monitor/software/imag/13.jpg
)

![image.png](
https://github.com/HDLR/dfjinxin-sc-sec/blob/master/dfjinxin-monitor/software/imag/14.jpg
)

分别为nacos注册中心、sentinel卫兵、admin后台系统监控

还有zikpin日志追踪，安装使用可以查看官网https://zipkin.io/pages/quickstart.html。

sentinel卫兵、admin后台系统监控，zikpin日志追踪都是系统监控管理的模块，可以不安装启动，不影响系统的使用。
但nacos注册中心和redis必须安装启动。
