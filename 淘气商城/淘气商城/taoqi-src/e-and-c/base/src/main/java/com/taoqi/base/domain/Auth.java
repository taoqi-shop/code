package com.taoqi.base.domain;

import java.io.Serializable;

/**
 * @作者：刘时明
 * @时间：2019/4/4-15:05
 * @作用：权限实体
 */
public class Auth implements Serializable
{
    private Long userId;
    private Long roleId;

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    @Override
    public String toString()
    {
        return "Auth{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
