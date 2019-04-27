package com.taoqi.base.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @作者：刘时明
 * @时间：2019/4/4-15:04
 * @作用：角色实体
 */
@Data
public class Role implements Serializable
{
    private Long id;
    private String role;
}
