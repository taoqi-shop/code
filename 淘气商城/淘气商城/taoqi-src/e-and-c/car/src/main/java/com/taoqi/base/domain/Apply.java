package com.taoqi.base.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @作者：刘时明
 * @时间：2019/4/4-14:57
 * @作用：申请实体
 */
public class Apply implements Serializable
{
    private Long id;
    private Long userId;
    private Long audit;
    private String name;
    private String info;
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

    public Long getAudit()
    {
        return audit;
    }

    public void setAudit(Long audit)
    {
        this.audit = audit;
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
        return "Apply{" +
                "id=" + id +
                ", userId=" + userId +
                ", audit=" + audit +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", flag=" + flag +
                ", stat=" + stat +
                ", time=" + time +
                '}';
    }
}
