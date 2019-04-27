package com.taoqi.test.consumer;

import com.taoqi.test.stream.MqMessageSource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

/**
 * @作者：刘时明
 * @时间：2019/4/15-15:54
 * @作用：
 */
@EnableBinding(MqMessageSource.class)
public class MqMessageConsumer
{
    @StreamListener(MqMessageSource.TEST_OUT_PUT)
    public void messageInPut(Message<String> message)
    {
        System.err.println("testOutPut通道 消息接收成功：" + message.getPayload());
    }
}
