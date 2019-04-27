package com.taoqi.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import java.net.InetAddress;

/**
 * @作者：刘时明
 * @时间：2019/4/4-15:19
 * @作用：
 */
@SpringBootApplication
@EnableZuulProxy
public class GatewayApp
{
    public static void main(String[] args) throws Exception
    {
        System.out.println(InetAddress.getLocalHost());
        SpringApplication.run(GatewayApp.class);
    }
}
