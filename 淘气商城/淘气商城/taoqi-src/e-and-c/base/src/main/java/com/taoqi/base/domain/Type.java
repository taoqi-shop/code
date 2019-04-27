package com.taoqi.base.domain;

import java.io.Serializable;

/**
 * @作者：刘时明
 * @时间：2019/4/4-14:50
 * @作用：分类实体
 */
public class Type implements Serializable
{
    private Long id;
    private Long parent;
    private String name;
    private Integer flag;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getParent()
    {
        return parent;
    }

    public void setParent(Long parent)
    {
        this.parent = parent;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getFlag()
    {
        return flag;
    }

    public void setFlag(Integer flag)
    {
        this.flag = flag;
    }

    @Override
    public String toString()
    {
        return "Type{" +
                "id=" + id +
                ", parent=" + parent +
                ", name='" + name + '\'' +
                ", flag=" + flag +
                '}';
    }
}
