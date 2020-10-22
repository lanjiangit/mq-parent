package com.demo.mq.common.constant;

/**
 * @author lanjian
 * @version 1.0
 * @date 2020/10/22 15:24
 */
public class RabbitMqConstant {
    private RabbitMqConstant(){
        throw new IllegalStateException("非法访问");
    }
    
    /**
     * 订单定向mq交换器
     */
    public static final String OrderDirectExchange = "OrderDirectExchange";
    /**
     * 订单广播mq交换器
     */
    public static final String OrderFanoutExchange = "OrderFanoutExchange";
    /**
     * 订单主题mq交换器
     */
    public static final String OrderTopicExchange = "OrderTopicExchange";
    
    /**
     * 订单定向库存路由键
     */
    public static final String OrderDirectStockRoutingKey = "order.direct.stock.routingKey";
    /**
     * 订单广播库存路由键
     */
    public static final String OrderFanoutStockRoutingKey = "order.fanout.stock.routingKey";
    /**
     * 订单主题库存路由键
     */
    public static final String OrderTopicStockRoutingKey = "order.topic.stock.routingKey";

    /**
     * 库存队列
     */
    public static final String StockQueue = "StockQueue";
    /**
     * 物流队列
     */
    public static final String LogisticsQueue = "LogisticsQueue";
    /**
     * 推送队列
     */
    public static final String PushQueue = "PushQueue";

}
