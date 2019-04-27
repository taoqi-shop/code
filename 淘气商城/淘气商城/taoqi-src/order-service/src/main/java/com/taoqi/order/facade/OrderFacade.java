package com.taoqi.order.facade;

import com.taoqi.base.domain.Order;
import com.taoqi.order.redis.JRedisTemplate;
import com.taoqi.order.utils.LuaScriptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者：刘时明
 * @时间：2019/4/22-9:14
 * @作用：
 */
@Component
public class OrderFacade
{
    @Autowired
    private JRedisTemplate template;

    private static final String BUY_LUA = "local target='taoqi_product_'..KEYS[1]\n"
            + "local stock=tonumber(redis.call('hget',target,'stock'))\n"
            + "local num=tonumber(ARGV[2])\n"
            + "if stock-num<0 then\n"
            + "return 0\n"
            + "end\n"
            + "stock=stock-num\n"
            + "redis.call('hset',target,'stock',tostring(stock))\n"
            + "redis.call('rpush','order',ARGV[1])\n"
            + "if stock==0 then\n"
            + "return 2\n"
            + "end\n"
            + "return 1";

    public long buy(Order order)
    {
        /**
         * 参数:
         * key 商品id
         * value 订单缩略 购买数量
         */
        List<byte[]> keys = new ArrayList<>();
        keys.add(String.valueOf(order.getProductId()).getBytes());
        List<byte[]> values = new ArrayList<>();
        // 用户ID + 商品ID + Count + 时间
        values.add((order.getUserId() + "-" + order.getProductId() + "-" + order.getCount() + "-" + System.currentTimeMillis()).getBytes());
        // Count
        values.add(String.valueOf(order.getCount()).getBytes());
        Jedis jedis=template.getJedis();
        try
        {
            Object result = LuaScriptUtil.runScript(BUY_LUA, jedis, keys, values);
            return (Long) result;
        }finally
        {
            template.close(jedis);
        }
    }
}
