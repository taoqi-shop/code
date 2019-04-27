package com.taoqi.order.service.impl;

import com.taoqi.base.domain.Order;
import com.taoqi.order.facade.OrderFacade;
import com.taoqi.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @作者：刘时明
 * @时间：2019/4/22-9:12
 * @作用：
 */
@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderFacade facade;

    @Override
    public long buy(Order order)
    {
        // 门面模式
        return facade.buy(order);
    }
}
