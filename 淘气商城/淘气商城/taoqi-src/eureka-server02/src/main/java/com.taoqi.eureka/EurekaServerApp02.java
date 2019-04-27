package com.taoqi.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @作者：刘时明
 * @时间：2019/4/4-13:41
 * @作用：
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApp02
{
    public static void main(String[] args)
    {
        SpringApplication.run(EurekaServerApp02.class);
    }
}
