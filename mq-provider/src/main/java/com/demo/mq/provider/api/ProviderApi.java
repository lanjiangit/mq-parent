package com.demo.mq.provider.api;

import com.demo.mq.provider.config.RabbitMqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lanjian
 * @version 1.0
 * @date 2020/10/16 15:42
 */
@Slf4j
@RestController
@RequestMapping("/provider")
public class ProviderApi implements RabbitTemplate.ConfirmCallback {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RabbitMqConfig rabbitMqConfig;
    
    @RequestMapping("/send/{msg}")
    public String send(@PathVariable("msg") String msg){
        rabbitTemplate.convertAndSend(rabbitMqConfig.getQueueName(),msg);
        System.out.println("发送消息成功" + msg);
        return msg;
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info(" 回调id:" + correlationData);
        if (ack) {
            log.info("消息成功消费");
        } else {
            log.info("消息消费失败:" + cause);
        }

    }
}
