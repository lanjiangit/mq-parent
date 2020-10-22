package com.demo.mq.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author lanjian
 * @version 1.0
 * @date 2020/10/16 15:41
 */
@SpringBootApplication
@PropertySource({"classpath:application-mq.properties"})
@ComponentScan({"com.demo.mq.common.config"})
public class ProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApp.class,args);
    }
}
