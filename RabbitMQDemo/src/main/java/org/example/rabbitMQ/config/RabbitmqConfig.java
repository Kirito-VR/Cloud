package org.example.rabbitMQ.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
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

    public static final String QUEUE_INFROM_EMAIL = "queue_inform_email";
    public static final String QUEUE_INFROM_SMS = "queue_infrom_sms";
    public static final String EXCHANGE_TOPICS_INFORM = "exchange_topics_inform";
    public static final String ROUTINGKEY_EMAIL = "inform.#.email.#";
    public static final String ROUTINGKEY_SMS = "inform.#.sms.#";


    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(env.getProperty("spring.rabbitmq.host"));
        connectionFactory.setPort(Integer.parseInt(env.getProperty("spring.rabbitmq.port")));
        connectionFactory.setUsername(env.getProperty("spring.rabbitmq.username"));
        return connectionFactory;
    }

    // RabbitMQ是核心类，用于接受Rabbit发来的信息和发送信息给RabbitMQ，属于客户端
    @Bean
    public RabbitTemplate rabbitTemplate(){
        // 建立对象转化信息，将java对象转为信息；
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());

        //
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Queue queue(){
        return new Queue(env.getProperty("spring.rabbitmq.queue"),false);
    }

}
