package org.example.mysql;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"org.example.mysql.mapper"})
@ComponentScan(basePackages = {"org.example.mysql"})
@EnableEurekaClient
public class MysqlApplication {
    public static void main(String[] args) {
        SpringApplication.run(MysqlApplication.class,args);
    }
}
