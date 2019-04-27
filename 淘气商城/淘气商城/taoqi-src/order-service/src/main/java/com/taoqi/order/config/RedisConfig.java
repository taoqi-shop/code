package com.taoqi.order.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @作者：刘时明
 * @时间：2019/4/22-9:21
 * @作用：
 */
@Configuration
public class RedisConfig
{
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private int port;
    @Value("${redis.poolMaxldle}")
    private int maxldle;
    @Value("${redis.password}")
    private String password;
    @Value("${redis.timeout}")
    private int timeout;
    @Value("${redis.poolMaxTotal}")
    private int maxTotal;
    @Value("${redis.poolMaxWait}")
    private int maxWait;
    @Value("${redis.data}")
    private int data;

    @Bean
    public JedisPoolConfig initRedisPoolConfig()
    {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(maxldle);
        config.setMaxTotal(maxTotal);
        config.setMaxWaitMillis(maxWait * 1000);
        return config;
    }

    @Bean
    public JedisPool initRedisPool()
    {
        JedisPool pool = new JedisPool(initRedisPoolConfig(), host, port, timeout);
        return pool;
    }
}
