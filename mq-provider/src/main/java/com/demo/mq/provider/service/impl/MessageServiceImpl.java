package com.demo.mq.provider.service.impl;

import com.demo.mq.common.eo.MessageEo;
import com.demo.mq.provider.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lanjian
 * @version 1.0
 * @date 2020/10/23 11:02
 */
@Slf4j
@Service
public class MessageServiceImpl implements IMessageService{
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @Override
    public void sendMessage(String exchange, MessageEo messageEo) {
        
    }

    @Override
    public void sendMessage(String exchange, String routingKey, MessageEo messageEo) {
        log.info("开始发送消息" + messageEo.getBody());
        rabbitTemplate.convertAndSend(exchange,routingKey,messageEo.toString());
    }
    
}
