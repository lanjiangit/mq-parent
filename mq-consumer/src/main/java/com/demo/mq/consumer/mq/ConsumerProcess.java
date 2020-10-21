package com.demo.mq.consumer.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息处理类
 * @author lanjian
 * @version 1.0
 * @date 2020/10/21 11:20
 */
@Slf4j
@Component
@RabbitListener(queues = {"${rabbitmq.provider.queue}"})
public class ConsumerProcess {
    @RabbitHandler
    public void receive(String msg){
        log.info("消费消息: {}",msg);
    }
    
}
