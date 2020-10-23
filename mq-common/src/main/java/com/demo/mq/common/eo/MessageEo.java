package com.demo.mq.common.eo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lanjian
 * @version 1.0
 * @date 2020/10/23 10:59
 */
@Data
public class MessageEo<T> implements Serializable {
    
    private T body;
}
