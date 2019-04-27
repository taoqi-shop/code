package com.taoqi.order.tasks;

import com.taoqi.order.redis.JRedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * @作者：刘时明
 * @时间：2019/4/22-9:40
 * @作用：
 */
@Component
public class OrderTask
{
    private static final String KEY="order";
    @Autowired
    private JRedisTemplate template;

    @Scheduled(fixedRate = 1000 * 10)
    public void saveOrder()
    {
        System.out.println("开始写入订单数据：");
        Jedis jedis=null;
        try
        {
            jedis=template.getJedis();
            Long len=jedis.llen(KEY);
            if(len==0)
            {
                System.out.println("无订单");
            }else
            {
                // String temp=jedis.lpop(KEY);
                System.out.println(len+"条订单");
            }
        }finally
        {
            template.close(jedis);
        }
    }
}
