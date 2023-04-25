package org.example.rabbitMQ.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class RabbitmqConfig {

    @Autowired
    private Environment env;
//    @Bean
//    public ConnectionFactory connectionFactory(){
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
//        connectionFactory.setHost(env.getProperty("spring.rabbitmq.host"));
//        connectionFactory.setPort(Integer.parseInt(env.getProperty("spring.rabbitmq.port")));
//        connectionFactory.setUsername(env.getProperty("spring.rabbitmq.username"));
//        connectionFactory.setPassword(env.getProperty("spring.rabbitmq.password"));
//        return connectionFactory;
//    }
//
//    // RabbitMQ是核心类，用于接受Rabbit发来的信息和发送信息给RabbitMQ，属于客户端
//    @Bean
//    public RabbitTemplate rabbitTemplate(){
//        // 建立对象转化信息，将java对象转为信息；
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
//
//        //
//        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
//        return rabbitTemplate;
//    }

    @Bean
    public Queue queue(){
        return new Queue(env.getProperty("spring.rabbitmq.queue"),true,false,false);
    }

    @Bean
    public Exchange myExchange(){
        return ExchangeBuilder.directExchange(env.getProperty("spring.rabbitmq.exchange")).durable(true).build();
    }
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(myExchange()).with("").noargs();
    }


}
