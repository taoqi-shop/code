package com.taoqi.base.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @作者：刘时明
 * @时间：2019/4/4-15:05
 * @作用：权限实体
 */
@Data
public class Auth implements Serializable
{
    private Long userId;
    private Long roleId;
}
