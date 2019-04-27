package com.taoqi.test.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @作者：刘时明
 * @时间：2019/4/16-9:10
 * @作用：
 */
public interface OrderSource
{
    String ORDER_OUT_PUT = "orderOutPut";

    @Output(ORDER_OUT_PUT)
    MessageChannel orderOutPut();
}
