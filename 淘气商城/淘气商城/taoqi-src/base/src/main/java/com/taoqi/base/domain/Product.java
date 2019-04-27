package com.taoqi.base.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @作者：刘时明
 * @时间：2019/4/4-13:59
 * @作用：商品实体
 */
@Data
public class Product implements Serializable
{
    private Long id;
    private Long typeId;
    private Long shopId;
    private String name;
    private String info;
    private String imgSrc;
    private Integer stock;
    private Float price;
    private Timestamp time;
    private Integer shelf;
}
