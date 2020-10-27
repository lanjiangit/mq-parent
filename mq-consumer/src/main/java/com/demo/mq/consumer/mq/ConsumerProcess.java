package com.demo.mq.consumer.mq;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 在消费者的监听器里,使用注解生产exchange和queue,并绑定routingKey
 * 在消费者的服务启动时,就会创建对应的bean,生产者可以直接根据exchange和routingKey发送消息
 * 如果在消费者服务起来之前,生产者根据exchange和routingKey发送消息会失败,提示找不到exchange
 * 
 * 消息处理类
 * @author lanjian
 * @version 1.0
 * @date 2020/10/21 11:20
 */
@Slf4j
@Component
@RabbitListener(
    //bindings = {
    //@QueueBinding(value = @Queue(value = RabbitMqConstant.StockQueue,autoDelete = "false"),
    //    exchange = @Exchange(value = RabbitMqConstant.OrderDirectExchange),
    //    key = {RabbitMqConstant.OrderDirectStockRoutingKey}
    //)},
    queues = {"StockQueue"})
public class ConsumerProcess {
    @RabbitHandler
    public void receive(String msg, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        
        // todo 要处理的业务逻辑
        
        /**
         * 手动确认消息,确认之后代表已消费
         * tag: 消息进入channel的唯一标识,自增的序列
         * multiple=true,表示确认所有小于等于tag的消息
         */
        channel.basicAck(tag,false);
        
        /**
         * 手动否认消息,否认之后根据 requeue=true/false 决定是否重新进入队列
         * tag: 消息进入channel的唯一标识,自增的序列
         * multiple=true,表示否认所有小于等于tag的消息
         */
        //channel.basicNack(tag,false,false);
        
        /**
         * 手动拒绝消息,拒绝之后不会重新进入队列
         * tag: 消息进入channel的唯一标识,自增的序列
         * multiple=true,表示拒绝所有小于等于tag的消息
         */
        //channel.basicReject(tag,false);
        
        System.out.println("消费消息: " + msg);
    }
    
}
