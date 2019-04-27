package com.taoqi.auth.config;

/**
 * @作者：刘时明
 * @时间：2019/4/8-16:19
 * @作用：
 */
public class AuthConfig
{
    // 私钥
    public static final String JWT_SECRET = "www.lsm1998.com";
    // 过期时间，毫秒为单位
    public static final long JWT_TTL = 60 * 60 * 1000 * 2;
    // 颁发者签名
    public static final String SUBJECT = "lsm1998";
}
