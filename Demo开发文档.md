## Cloud_Demo开发文档

> 本文档是写于为Cloud_Demo项目而编写的文档

| 时间      | 编写人      | 版本   | 版本号 | 审核人      |
| --------- | ----------- | ------ | ------ | ----------- |
| 2023/4/17 | 陈权(Kirit) | init   | v1.0   | 陈权(kirit) |
| 2023/5/8  | 陈权(Kirit) | update | v2.0   | 陈权(kirit) |
|           |             |        |        |             |



### 服务列表

| 服务名        | 服务对象                         | 端口 | 维护人      |
| ------------- | -------------------------------- | ---- | ----------- |
| mysql-server  | 用于调用Mysql数据库练习          | 6669 | 陈权(Kirit) |
| mongo-server  | 用于调用mongoDB数据库练习        | 6666 | 陈权(Kirit) |
| redis-server  | 用于调用redis数据库练习          | 6671 | 陈权(Kirit) |
| rabbit-server | 用于调用rabbit消息队列练习的模块 | 6668 | 陈权(Kirit) |
| cloud-server  | Eureka服务注册中心               | 6670 | 陈权(Kirit) |



### 服务配置

| 中间件  | url:port                                                     | 部分配置       | 密码         |
| ------- | ------------------------------------------------------------ | -------------- | ------------ |
| mysql   | jdbc:mysql://localhost:3306/demo?userUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8&allowMultiQueries=true | username:root; | quectel@2022 |
| redis   | localhost:6379                                               |                | 无           |
| mongodb | localhost:27017                                              |                | 无           |
| eureka  | localhost:6670                                               |                | 无           |

```yml
# Eureka统一配置格式
eureka:
  client: #将客户端注册到 eureka 服务列表内
    service-url:
      defaultZone: http://localhost:6670/eureka/  #这个地址是 7001注册中心在 application.yml 中暴露出来额注册地址 （单机版）
  instance:
    instance-id: spring-cloud-MongoDB-server #自定义服务名称信息
    prefer-ip-address: true  #显示访问路径的 ip 地址
```



### 问题总结

- BaseMapper属于于tk.mybatis包，切勿使用mybatis-plus
- 像entity类对照数据库的类需要@AllArgsConstructors、@Data；使用@Builder能够更好的构建对象
- general-core包不能随便导入，否则会报各种错。因为配置信息还没搞懂，所以直接越过公司的包，选择BaseMapper
- 测试类，需要加上@RunWith(SpringRunner.class);@SpringBootTest；其依赖分别为junit\spring-boot-starter-test
- 构建entity等类，属性类型如果选择int,建议替换成Integer封装类，这样tk.mybatis不会出现通过主键查询报错的情况
- 调用Feign的时候需要在启动类使用@EnableFeignClients(clients = {"xxx.xxx.xx写的对应调用的feign类名"})
- 注册中心使用@EnableEurekaClient，依赖 org.springframework.cloud.netflix.eureka