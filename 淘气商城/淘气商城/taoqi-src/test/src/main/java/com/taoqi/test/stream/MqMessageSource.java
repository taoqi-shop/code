package com.taoqi.test.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @作者：刘时明
 * @时间：2019/4/16-9:01
 * @作用：
 */
public interface MqMessageSource
{
    String TEST_OUT_PUT = "testOutPut";

    @Output(TEST_OUT_PUT)
    MessageChannel testOutPut();
}
