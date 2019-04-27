package com.taoqi.base.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @作者：刘时明
 * @时间：2019/4/4-13:59
 * @作用：订单实体
 */
public class Order implements Serializable
{
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private Float sum;
    private Integer flag;
    private Integer stat;
    private Timestamp time;

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

    public Integer getCount()
    {
        return count;
    }

    public void setCount(Integer count)
    {
        this.count = count;
    }

    public Float getSum()
    {
        return sum;
    }

    public void setSum(Float sum)
    {
        this.sum = sum;
    }

    public Integer getFlag()
    {
        return flag;
    }

    public void setFlag(Integer flag)
    {
        this.flag = flag;
    }

    public Integer getStat()
    {
        return stat;
    }

    public void setStat(Integer stat)
    {
        this.stat = stat;
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
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", count=" + count +
                ", sum=" + sum +
                ", flag=" + flag +
                ", stat=" + stat +
                ", time=" + time +
                '}';
    }
}
