package com.taoqi.evaluate.entity;

import java.sql.Timestamp;

/**
 * @作者：欧阳湘雄
 * @时间：2019/4/10-9:17
 * @作用：商品实体
 */
public class Product 
{
    private Long id;
    private Long typeId;
    private Long shopId;
    private String name;
    private String info;
    private String imgSrc;
    private Float price;
    private Integer stock;
    private Timestamp time;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getTypeId()
    {
        return typeId;
    }

    public void setTypeId(Long typeId)
    {
        this.typeId = typeId;
    }

    public Long getShopId()
    {
        return shopId;
    }

    public void setShopId(Long shopId)
    {
        this.shopId = shopId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getInfo()
    {
        return info;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }

    public String getImgSrc()
    {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc)
    {
        this.imgSrc = imgSrc;
    }

    public Float getPrice()
    {
        return price;
    }

    public void setPrice(Float price)
    {
        this.price = price;
    }

    public Integer getStock()
    {
        return stock;
    }

    public void setStock(Integer stock)
    {
        this.stock = stock;
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
    public String toString()
    {
        return "Product{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", shopId=" + shopId +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", time=" + time +
                '}';
    }
}
