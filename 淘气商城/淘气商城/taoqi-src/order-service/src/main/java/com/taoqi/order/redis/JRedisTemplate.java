package com.taoqi.order.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.Future;

/**
 * @作者：刘时明
 * @时间：2019/2/28-9:34
 * @作用：
 */
@Component
public class JRedisTemplate
{
    @Autowired
    private JedisPool jedisPool;
    @Value("${redis.data}")
    private int data;

    @Async
    public void set(String key, String value)
    {
        Jedis jedis = null;
        try
        {
            jedis = jedisPool.getResource();
            jedis.select(data);
            jedis.set(key, value);
        } finally
        {
            close(jedis);
        }
    }

    @Async
    public Future<String> get(String key)
    {
        Jedis jedis = null;
        try
        {
            jedis = jedisPool.getResource();
            jedis.select(data);
            return new AsyncResult<>(jedis.get(key));
        } finally
        {
            close(jedis);
        }
    }

    public void close(Jedis jedis)
    {
        if (jedis != null)
        {
            jedis.close();
        }
    }

    public Jedis getJedis()
    {
        return jedisPool.getResource();
    }
}
