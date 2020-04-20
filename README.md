# spring-cloud-oauth2

#### 介绍
Springcloud 结合Oauth2来实现统一鉴权认证

#### 软件架构
软件架构说明


K8S 1.14.9 +

Spring Boot 2.1.13

Spring Cloud Greenwich.SR3

Spring Cloud Alibaba 2.1.1.RELEASE


#### 安装教程

1.  安装 docker、k8s 环境

2.  编写相关的 yaml 文件

3.  使用 k8s 部署资源

#### 使用说明

1. K8S 环境

2. command test: order-servide ---->  admin-web

   curl -i -H "Accept: application/json" -X GET http://10.10.1.80:5555/order-service/api/order/getUserInfo

3. 本次提供基于网关的限流功能、基于阿里相关组件实现 LB，基于Oauth2实现统一鉴权认证，以及基于 Ribbon 的 LB 、基于Hystrix 的熔断机制等

#### 参与贡献

## 欢迎关注

![输入图片说明](https://images.gitee.com/uploads/images/2020/0414/104902_aa07fda5_1459921.jpeg "qrcode_for_gh_5f5844a6d00e_344.jpg")
