package com.taoqi.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @作者：刘时明
 * @时间：2019/4/19-15:55
 * @作用：
 */
@SpringBootApplication
@EnableScheduling
public class OrderServiceApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(OrderServiceApp.class);
    }
}
