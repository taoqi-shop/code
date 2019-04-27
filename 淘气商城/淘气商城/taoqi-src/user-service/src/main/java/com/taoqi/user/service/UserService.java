package com.taoqi.user.service;

import com.taoqi.base.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @作者：刘时明
 * @时间：2019/4/4-14:10
 * @作用：
 */
public interface UserService
{
    Map<String,Object> reg(User user);

    Map<String,Object> get(int page,int size);
}
