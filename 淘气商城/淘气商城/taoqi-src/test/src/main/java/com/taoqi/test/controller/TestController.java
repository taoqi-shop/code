package com.taoqi.test.controller;

import com.taoqi.test.producer.MqMessageProducer;
import com.taoqi.test.producer.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @作者：刘时明
 * @时间：2019/4/15-13:22
 * @作用：
 */
@RestController
public class TestController
{
    @Autowired
    private MqMessageProducer mqMessageProducer;
    @Autowired
    private OrderProducer orderProducer;

    @GetMapping("send1")
    public Object send1()
    {
        orderProducer.sendMsg("Hello");
        return "ok";
    }

    @GetMapping("send2")
    public Object send2()
    {
        mqMessageProducer.sendMsg("Hello");
        return "ok";
    }
}
