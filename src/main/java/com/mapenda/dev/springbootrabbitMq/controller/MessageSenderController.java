package com.mapenda.dev.springbootrabbitMq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
public class MessageSenderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${dev.exchange.name}")
    private String exchangeName;

    @GetMapping(value = "sendMessage")
    public void sendMessage(@RequestParam final String messageBody) {
        rabbitTemplate.convertAndSend(exchangeName, "*", messageBody);
    }

}
