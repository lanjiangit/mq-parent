package com.demo.mq.consumer.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lanjian
 * @version 1.0
 * @date 2020/10/16 15:56
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerApi {
    @RequestMapping("/receive")
    public void receive(String msg){
        System.out.println(msg);
    }
}
