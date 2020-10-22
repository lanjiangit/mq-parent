package com.demo.mq.common.eo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lanjian
 * @version 1.0
 * @date 2020/10/22 17:19
 */
@Data
public class OrderEo implements Serializable {
    private String orderNo;
    
    private Date createTime;
}
