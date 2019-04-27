package com.taoqi.base.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @作者：刘时明
 * @时间：2019/4/4-13:58
 * @作用：用户实体
 */
@Data
public class User implements Serializable
{
    private Long id;
    private String nickName;
    private String userName;
    private String passWord;
    // 密码盐
    private String salt;
    private String imgSrc;
    private Integer stat;
    private String phone;
    private String address;
}
