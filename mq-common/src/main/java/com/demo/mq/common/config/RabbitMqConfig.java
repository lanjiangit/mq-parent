package com.demo.mq.common.config;

import com.demo.mq.common.constant.RabbitMqConstant;
import lombok.Data;
import org.springframework.amqp.core.*;
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
    @Bean
    public Queue stockQueue() {
        /**
         * 队列名称
         * 是否持久化队列
         */
        return new Queue(RabbitMqConstant.StockQueue,true);
    }
    //@Bean
    //public Queue logisticsQueue() {
    //    return new Queue(RabbitMqConstant.LogisticsQueue,false);
    //}
    //@Bean
    //public Queue pushQueue() {
    //    return new Queue(RabbitMqConstant.PushQueue,false);
    //}

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
    public DirectExchange directExchange() {
        return new DirectExchange(RabbitMqConstant.OrderDirectExchange,false,false);
    }
    
    //@Bean
    //public FanoutExchange fanoutExchange() {
    //    return new FanoutExchange(RabbitMqConstant.OrderFanoutExchange);
    //}
    //
    //@Bean
    //public TopicExchange topicExchange() {
    //    return new TopicExchange(RabbitMqConstant.OrderTopicExchange);
    //}
    
    @Bean
    public Binding directStockBinding() {
        return BindingBuilder.bind(this.stockQueue()).to(this.directExchange()).with(RabbitMqConstant.OrderDirectStockRoutingKey);
    }
    //@Bean
    //public Binding directLogisticsBinding() {
    //    return BindingBuilder.bind(this.logisticsQueue()).to(this.fanoutExchange());
    //}
    //@Bean
    //public Binding directPushBinding() {
    //    return BindingBuilder.bind(this.pushQueue()).to(this.topicExchange()).with("order.topic.*.*");
    //}
}
