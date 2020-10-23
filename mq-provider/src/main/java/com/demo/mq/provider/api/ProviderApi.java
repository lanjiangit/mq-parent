package com.demo.mq.provider.api;

import com.demo.mq.common.constant.RabbitMqConstant;
import com.demo.mq.common.eo.OrderEo;
import com.demo.mq.common.eo.MessageEo;
import com.demo.mq.provider.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author lanjian
 * @version 1.0
 * @date 2020/10/16 15:42
 */
@Slf4j
@RestController
@RequestMapping("/provider")
public class ProviderApi {
    @Autowired
    private IMessageService messageService;

    @GetMapping("/send/{msg}")
    public String send(@PathVariable("msg") String msg){
        OrderEo eo = new OrderEo();
        eo.setCreateTime(new Date());
        eo.setOrderNo(msg);
        MessageEo<OrderEo> messageEo = new MessageEo<>();
        messageEo.setBody(eo);
        messageService.sendMessage(RabbitMqConstant.OrderDirectExchange,RabbitMqConstant.OrderDirectStockRoutingKey,messageEo);
        return msg;
    }

}
