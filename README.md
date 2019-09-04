## 项目地址

[https://github.com/1067649786/advertisement](https://github.com/1067649786/advertisement)

## 广告系统应该需要实现的最基本功能

1. 广告投放系统：既然是广告系统，一定得有广告数据，数据当然是由广告主或代理商投放，那么，也就需要有个投放广告的平台，这就是广告投放系统

2. 广告检索系统：媒体方对广告系统发起请求，广告系统能够检索符合要求的广告数据，这就是广告检索系统的核心功能。

## 广告系统架构图

![](http://47.103.196.106:8080/upload/20190904_06482994.png)

## 项目运用到的技术

项目只设计了广告系统的后端部分，主要架构是基于springboot2.0.4.RELEASE+spring cloud Finchley.RELEASE+springboot JPA，数据库使用MySQL8.0，项目中还运用了kafka。

## 项目模块说明

![](http://47.103.196.106:8080/upload/20190904_06561610.png)

ad-eureka：服务注册与服务发现<br>
ad-gateway：网关，所有的请求和响应都会通过<br>
ad-service：广告实现服务<br>
ad-common：通用代码定义、配置定义，统一异常处理，统一的响应处理<br>
ad-dashboard：熔断监控部分<br>
ad-search：广告检索<br>
ad-sponsor：广告投放<br>
