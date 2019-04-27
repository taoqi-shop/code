package com.taoqi.base.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @作者：刘时明
 * @时间：2019/4/8-16:12
 * @作用：购物车实体
 */
public class Car implements Serializable
{
    private Long id;
    private Long userId;
    private Long productId;
    private Float price;
    private Integer count;
    private Timestamp time;
    private String sku;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getProductId()
    {
        return productId;
    }

    public void setProductId(Long productId)
    {
        this.productId = productId;
    }

    public Float getPrice()
    {
        return price;
    }

    public void setPrice(Float price)
    {
        this.price = price;
    }

    public Integer getCount()
    {
        return count;
    }

    public void setCount(Integer count)
    {
        this.count = count;
    }

    public Timestamp getTime()
    {
        return time;
    }

    public void setTime(Timestamp time)
    {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", price=" + price +
                ", count=" + count +
                ", time=" + time +
                ", sku='" + sku + '\'' +
                '}';
    }
}
