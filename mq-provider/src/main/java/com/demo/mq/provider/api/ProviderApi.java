package com.demo.mq.provider.api;

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
@RestController
@RequestMapping("/provider")
public class ProviderApi {
    @Autowired
    private RabbitTemplate template;
    @RequestMapping("/send/{msg}")
    public String send(@PathVariable("msg") String msg){
        template.convertAndSend("testDemo",msg);
        System.out.println("发送消息成功" + msg);
        return msg;
    }
}
