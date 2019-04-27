package com.taoqi.base.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @作者：刘时明
 * @时间：2019/4/4-15:02
 * @作用：评价实体
 */
public class Evaluate implements Serializable
{
    private Long id;
    private Long userId;
    private Long productId;
    private Long replyId;
    private Integer star;
    private String info;
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

    public Long getReplyId()
    {
        return replyId;
    }

    public void setReplyId(Long replyId)
    {
        this.replyId = replyId;
    }

    public Integer getStar()
    {
        return star;
    }

    public void setStar(Integer star)
    {
        this.star = star;
    }

    public String getInfo()
    {
        return info;
    }

    public void setInfo(String info)
    {
        this.info = info;
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
        return "Evaluate{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", replyId=" + replyId +
                ", star=" + star +
                ", info='" + info + '\'' +
                ", time=" + time +
                '}';
    }
}
