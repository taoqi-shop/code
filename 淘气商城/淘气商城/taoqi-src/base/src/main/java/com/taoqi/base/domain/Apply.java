package com.taoqi.base.domain;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @作者：刘时明
 * @时间：2019/4/4-14:57
 * @作用：申请实体
 */
@Data
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
}
