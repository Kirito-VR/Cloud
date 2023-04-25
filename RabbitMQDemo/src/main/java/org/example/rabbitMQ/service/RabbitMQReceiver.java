package org.example.rabbitMQ.service;

import org.example.rabbitMQ.util.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQReceiver {

    @RabbitListener(queues = "kiritQueue")
    public void receive(Message message){
        System.out.println("Received Message:" + message.getText());
    }
}
