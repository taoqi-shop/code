package com.taoqi.auth.service;

import java.util.Map;

/**
 * @作者：刘时明
 * @时间：2019/4/17-14:55
 * @作用：
 */
public interface AuthService
{
    Map<String,Object> login(String name,String pass);

    Map<String,Object> check(String jwt);
}
