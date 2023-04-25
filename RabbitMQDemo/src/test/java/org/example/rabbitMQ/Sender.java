package org.example.rabbitMQ;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Test
    public void providerSender(){
        rabbitTemplate.convertAndSend("kiritQueue","hello,spring amqp!");

    }
}
