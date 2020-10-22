package com.demo.mq.consumer.mq;

import com.demo.mq.common.constant.RabbitMqConstant;
import com.demo.mq.common.eo.OrderEo;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 消息处理类
 * @author lanjian
 * @version 1.0
 * @date 2020/10/21 11:20
 */
@Slf4j
@Component
@RabbitListener(queues = {RabbitMqConstant.StockQueue})
public class ConsumerProcess {
    @RabbitHandler
    public void receive(OrderEo msg, Channel channel, Message message) throws IOException {
        System.out.println("消费消息: " + msg);
        // 消息消费改为手动应答
        //channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
    }
    
}
