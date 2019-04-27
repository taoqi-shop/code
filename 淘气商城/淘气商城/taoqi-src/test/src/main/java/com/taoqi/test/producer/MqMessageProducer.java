package com.taoqi.test.producer;

import com.taoqi.test.stream.MqMessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @作者：刘时明
 * @时间：2019/4/16-9:02
 * @作用：
 */
@EnableBinding(MqMessageSource.class)
public class MqMessageProducer
{
    @Autowired
    @Output(MqMessageSource.TEST_OUT_PUT)
    private MessageChannel channel;

    public void sendMsg(String msg)
    {
        channel.send(MessageBuilder.withPayload(msg).build());
        System.err.println("消息发送成功：" + msg);
    }
}
