package com.taoqi.base.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @作者：刘时明
 * @时间：2019/4/4-14:45
 * @作用：店铺实体
 */
public class Shop implements Serializable
{
    private Long id;
    private Long userId;
    private String name;
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
        return "Shop{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", time=" + time +
                '}';
    }
}
