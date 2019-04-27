package com.taoqi.base.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @作者：刘时明
 * @时间：2019/4/4-14:50
 * @作用：分类实体
 */
@Data
public class Type implements Serializable
{
    private Long id;
    private Long parent;
    private String name;
    private Integer flag;
}
