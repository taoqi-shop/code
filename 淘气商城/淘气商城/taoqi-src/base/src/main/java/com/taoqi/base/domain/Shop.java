package com.taoqi.base.domain;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @作者：刘时明
 * @时间：2019/4/4-14:45
 * @作用：店铺实体
 */
@Data
public class Shop implements Serializable
{
    private Long id;
    private Long userId;
    private String name;
    private String info;
    private Timestamp time;
}
