package com.demo.mq.provider.config;

import lombok.Data;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lanjian
 * @version 1.0
 * @date 2020/10/19 15:33
 */
@Data
@Configuration
public class RabbitMqConfig {
    /**
     * 交换器名称
     */
    @Value("${rabbitmq.provider.exchange}")
    private String exchange;
    /**
     * 路由键
     */
    @Value("${rabbitmq.provider.routingKey}")
    private String routingKey;
    
    private String queueName = "directDemo";
    
    @Bean
    public Queue queue() {
        return new Queue(queueName,true);
    }

    /**
     * 针对消费者配置
     * 1. 设置交换机类型
     * 2. 将队列绑定到交换机
     FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
     HeadersExchange ：通过添加属性key-value匹配
     DirectExchange:按照routingkey分发到指定队列
     TopicExchange:多关键字匹配
     */
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchange);
    }
    
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(this.queue()).to(this.exchange()).with(routingKey);
    }
}
