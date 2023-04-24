package org.example.rabbitMQ.controller;

import org.example.rabbitMQ.service.RabbitMQSender;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/send")
public class SendController {

    @Autowired
    private RabbitMQSender sender;

    @GetMapping("/sendMessage")
    public String sendMessage(@RequestParam("message") String message){




        sender.send(new Message(message.getBytes(StandardCharsets.UTF_8)));


        return message;
    }
}
