package com.demo.mq.provider.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author lanjian
 * @version 1.0
 * @date 2020/10/23 11:15
 */
@Slf4j
@Component
public class ConfirmCallbackImpl implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init(){
        // 指定调用 confirm 方法的对象,该对象必须实现RabbitTemplate.ConfirmCallback接口,且一个 RabbitTemplate 实例只能指定一个对象
        // returnedMessage 方法同理
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }
    /**
     * 消息发送到exchange,确认是否成功的回调方法
     * @param data
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData data, boolean ack, String cause) {
        log.info(" 回调id: {}", data);
        if (ack) {
            log.info("消息成功发送");
        } else {
            log.info("消息发送失败:" + cause);
        }
    }

    /**
     * 消息发送到exchange,但进入queue失败时,回调的方法
     * @param message 消息体
     * @param replyCode 应答码
     * @param replyText 应答内容
     * @param exchange 交换器
     * @param routingKey 路由键
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.info("消息无法到达queue,请检查配置......");
        log.info("replyCode: " + replyCode);
        log.info("replyText: " + replyText);
        log.info("exchange: " + exchange);
        log.info("routingKey: " + routingKey);
        log.info("message: " + message);
    }
}
