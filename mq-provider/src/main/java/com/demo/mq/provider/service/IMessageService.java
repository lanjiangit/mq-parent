package com.demo.mq.provider.service;

import com.demo.mq.common.eo.MessageEo;

/**
 * @Author: lanjian
 * @Description:
 * @Date: Create in 10:56 2020/10/23
 */
public interface IMessageService {
    /**
     * 发送消息
     * @param exchange 交换器
     * @param messageEo 消息体
     */
    void sendMessage(String exchange, MessageEo messageEo);

    /**
     * 发送消息
     * @param exchange 交换器
     * @param routingKey 路由键
     * @param messageEo 消息体
     */
    void sendMessage(String exchange, String routingKey, MessageEo messageEo);
}
