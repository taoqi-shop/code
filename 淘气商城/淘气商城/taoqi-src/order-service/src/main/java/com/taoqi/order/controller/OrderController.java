package com.taoqi.order.controller;

import com.taoqi.base.domain.Order;
import com.taoqi.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;


/**
 * @作者：刘时明
 * @时间：2019/4/19-15:58
 * @作用：
 */
@RestController
@RequestMapping("order")
public class OrderController
{
    @Autowired
    private OrderService service;
    @Autowired
    private ReactiveRedisTemplate template;

    @GetMapping("set")
    public Mono<Object> set(@RequestParam String key, @RequestParam String value)
    {
        return template.opsForValue().set(key, value);
    }

    @GetMapping("get")
    public Mono<Object> get(@RequestParam String key)
    {
        return template.opsForValue().get(key);
    }

    @PostMapping("buy")
    public Mono<Object> buy(@RequestBody Order order)
    {
        System.out.println("接受请求：order="+order);
        // Web Flux
        // Flux<Object> flux=template.execute(RedisScript.of("return 1",Object.class));
        // System.out.println("result="+ flux.next().block());
        return Mono.just(service.buy(order));
    }

    @GetMapping("buy")
    public Mono<Object> buy()
    {
        Order order=new Order();
        order.setCount(2);
        order.setProductId(1l);
        order.setUserId(1l);
        order.setSum(20f);
        order.setStat(1);
        return Mono.just(service.buy(order));
    }

    @PostConstruct
    public void init()
    {
        Jedis jedis=new Jedis("127.0.0.1");
        jedis.select(0);
        for (int i = 1; i < 11; i++)
        {
            jedis.hset("taoqi_product_"+i,"stock","10");
        }
        System.out.println("数据初始化");
        jedis.close();
    }
}
