package org.example.rabbitMQ.controller;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverListener {

    @RabbitListener(queues = "kiritQueue")
    public void listenSmipleQueueMessage(String msg){
        System.out.println("消息：{" + msg + "}");
    }
}
