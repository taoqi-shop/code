package com.taoqi.base.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @作者：刘时明
 * @时间：2019/4/4-15:07
 * @作用：推广实体
 */
@Data
public class Spread implements Serializable
{
    private Long id;
    private Long userId;
    private String info;
    private String imgSrc;
    private Float price;
}
