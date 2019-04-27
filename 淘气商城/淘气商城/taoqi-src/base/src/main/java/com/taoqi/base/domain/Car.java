package com.taoqi.base.domain;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @作者：刘时明
 * @时间：2019/4/8-16:12
 * @作用：购物车实体
 */
@Data
public class Car implements Serializable
{
    private Long id;
    private Long userId;
    private Long productId;
    private Float price;
    private Integer count;
    private String sku;
    private Timestamp time;
}
