package com.taoqi.base.domain;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @作者：刘时明
 * @时间：2019/4/4-15:02
 * @作用：评价实体
 */
@Data
public class Evaluate implements Serializable
{
    private Long id;
    private Long userId;
    private Long productId;
    private Long replyId;
    private Integer star;
    private String info;
    private Timestamp time;
}
