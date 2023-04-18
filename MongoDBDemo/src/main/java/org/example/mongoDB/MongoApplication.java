package org.example.mongoDB;

import org.example.feign.client.MysqlClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(clients = MysqlClient.class)
public class MongoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class,args);
    }
}
