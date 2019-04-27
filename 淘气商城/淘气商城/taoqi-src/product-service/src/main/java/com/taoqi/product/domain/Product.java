package com.taoqi.product.domain;

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
@Entity
@Table(name = "t_Product")
public class Product implements Serializable
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name = "type_id")
    private Long typeId;
    @Column(name = "shop_id")
    private Long shopId;
    private String name;
    private String info;
    @Column(name = "img_src")
    private String imgSrc;
    private Integer stock;
    private Float price;
    private Timestamp time;
    private Integer shelf;
}
