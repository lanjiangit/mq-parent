package com.demo.mq.consumer.api;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lanjian
 * @version 1.0
 * @date 2020/10/16 15:56
 */
@RestController
@RequestMapping("/consumer")
@RabbitListener(queues = {"testDemo"})
public class ConsumerApi {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @RequestMapping("/receive")
    @RabbitHandler
    public void receive(String msg){
        System.out.println(msg);
    }
}
