package com.taoqi.test.consumer;

import com.taoqi.test.stream.OrderSource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

/**
 * @作者：刘时明
 * @时间：2019/4/16-9:12
 * @作用：
 */
@EnableBinding(OrderSource.class)
public class OrderConsumer
{
    @StreamListener(OrderSource.ORDER_OUT_PUT)
    public void messageInPut(Message<String> message)
    {
        System.err.println("orderOutPut通道 消息接收成功：" + message.getPayload());
    }
}
