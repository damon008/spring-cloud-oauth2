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

2. curl command test: 

密码模式:

curl -i -X POST -d "username=admin&password=123456&grant_type=password&client_id=provider-service&client_secret=provider-service-123" http://localhost:5555/oauth-cas/oauth/token

curl -i -H "Accept: application/json" -H "Authorization:bearer 4efa1fef-f8dc-407c-92df-78b705681707" -X GET http://localhost:5555/provider-service/api/user/getCurrentUser

http://localhost:5555/provider-service/api/user/auth/admin?access_token=9f8017bd-8063-4be5-8cbb-7c0d697136e7


授权码模式:
1. 获取授权码
Get:

http://localhost:5555/oauth-cas/oauth/authorize?response_type=code&client_id=provider-service&redirect_uri=http://localhost:2001/login

http://localhost:5555/oauth-cas/oauth/authorize?response_type=code&client_id=provider-service&redirect_uri=http://localhost:2001/login&scope=all

http://localhost:2000/oauth/authorize?response_type=code&client_id=provider-service&redirect_uri=http://localhost:2001/login&scope=all

2. 根据code获取access_token
Post:

curl -i -X POST -d "grant_type=authorization_code&code=qtSioj&client_id=provider-service&client_secret=provider-service-123&redirect_uri=http://localhost:2001/login" http://localhost:2000/oauth/token

{"access_token":"a2af3f0b-27da-41b8-90c0-3bd2a1ed0421","token_type":"bearer","refresh_token":"91c22287-aa24-4305-95cf-38f7903865f3","expires_in":3283,"scope":"all"}

3. 拿到token获取用户信息
有几种方式：头部携带，或直接传token

curl -i -H "Accept: application/json" -H "Authorization:bearer a2af3f0b-27da-41b8-90c0-3bd2a1ed0421" -X GET http://localhost:2001/api/user/getCurrentUser

http://localhost:2001/api/user/getCurrentUser?access_token=a2af3f0b-27da-41b8-90c0-3bd2a1ed0421

4.刷新token

curl -i -X POST -d "grant_type=refresh_token&refresh_token=91c22287-aa24-4305-95cf-38f7903865f3&client_id=provider-service&client_secret=provider-service-123" http://localhost:2000/oauth/token

### 本次提供基于网关的限流功能、基于阿里相关组件实现 LB，基于Oauth2实现统一鉴权认证，以及基于 Ribbon 的 LB 、基于Hystrix 的熔断机制等

#### 参与贡献

## 欢迎关注

![输入图片说明](https://images.gitee.com/uploads/images/2020/0414/104902_aa07fda5_1459921.jpeg "qrcode_for_gh_5f5844a6d00e_344.jpg")
