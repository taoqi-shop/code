package com.taoqi.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @作者：刘时明
 * @时间：2019/4/4-14:15
 * @作用：
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(ConfigServerApp.class);
    }
}
