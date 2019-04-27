package com.taoqi.base.domain;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @作者：刘时明
 * @时间：2019/4/4-13:59
 * @作用：订单实体
 */
@Data
public class Order implements Serializable
{
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private Float sum;
    private Integer flag;
    private Integer stat;
    private String sku;
    private Timestamp time;
}
