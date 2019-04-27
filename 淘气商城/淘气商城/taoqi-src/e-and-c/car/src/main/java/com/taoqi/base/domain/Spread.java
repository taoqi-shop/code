package com.taoqi.base.domain;

import java.io.Serializable;

/**
 * @作者：刘时明
 * @时间：2019/4/4-15:07
 * @作用：推广实体
 */
public class Spread implements Serializable
{
    private Long id;
    private Long userId;
    private String info;
    private String imgSrc;
    private Float price;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
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

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    @Override
    public String toString()
    {
        return "Spread{" +
                "id=" + id +
                ", userId=" + userId +
                ", info='" + info + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", price=" + price +
                '}';
    }
}
