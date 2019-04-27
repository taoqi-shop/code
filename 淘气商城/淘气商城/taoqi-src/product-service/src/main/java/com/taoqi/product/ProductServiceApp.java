package com.taoqi.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @作者：刘时明
 * @时间：2019/4/24-13:54
 * @作用：
 */
@SpringBootApplication
public class ProductServiceApp
{
    public static void main(String[] args)
    {
        /**
         * 原子性
         * 有序性
         * 可见性
         */
        SpringApplication.run(ProductServiceApp.class);
    }
}

