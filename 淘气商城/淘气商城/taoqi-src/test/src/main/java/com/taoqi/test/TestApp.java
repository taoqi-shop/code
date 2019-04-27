package com.taoqi.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;

/**
 * @作者：刘时明
 * @时间：2019/4/15-10:45
 * @作用：
 */
@SpringBootApplication
public class TestApp
{
    /**
     * https://www.cnblogs.com/zhixiang-org-cn/p/10093367.html
     * @param args
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println(InetAddress.getLocalHost());
        SpringApplication.run(TestApp.class);
    }
}
