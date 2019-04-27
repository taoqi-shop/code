package com.taoqi.base.domain;

import java.io.Serializable;

/**
 * @作者：刘时明
 * @时间：2019/4/4-15:04
 * @作用：角色实体
 */
public class Role implements Serializable
{
    private Long id;
    private String role;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    @Override
    public String toString()
    {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
