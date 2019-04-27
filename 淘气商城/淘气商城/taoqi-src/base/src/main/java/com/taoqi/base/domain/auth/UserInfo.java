package com.taoqi.base.domain.auth;

import lombok.Data;

import java.util.List;

/**
 * @作者：刘时明
 * @时间：2019/4/24-11:06
 * @作用：
 */
@Data
public class UserInfo
{
    private Long id;
    private String userName;
    private List<String> auth;
}
