# SpringOauth2Demo
spring security oauth2 demo,基于JdbcTokenStore

#### 1.导入sql
#### 2.授权服务器和资源服务器不是同一服务器时，确保DataSource配置相同
#### 3.分别运行AuthorizeApplication和ResourceServerApplication,授权服务器运行于8080端口，资源服务器运行于9090端口
#### 4.浏览器访问http://localhost:8080/oauth/authorize?response_type=code&client_id=test_client&client_secret=admin
#### 5.输入用户名abby,密码admin获取授权码,此用户拥有ADMIN权限。用户名user密码123456的用户有USER权限。
#### 6.在postman中发起post请求localhost:8080/oauth/token?grant_type=authorization_code&code=your_auth_code&client_id=test_client&client_secret=admin获取access_token
#### 7.浏览器访问http://localhost:9090/private?access_token=your_access_token访问被保护的资源。 此处只有ADMIN权限的用户可以访问，USER权限的用户访问将返回403
