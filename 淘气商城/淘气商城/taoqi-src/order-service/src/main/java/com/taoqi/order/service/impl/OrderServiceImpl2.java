package com.taoqi.order.service.impl;

import com.taoqi.order.mapper.OrderMapper;
import com.taoqi.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.domain.Order;


import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Order> selectAll(){
        List<Order> orderList =  orderMapper.find();
        return  orderList;
    }

    @Override
    public List<Order> selectUser() {
        List<Order> orderUserList = orderMapper.findUserOrder();
        return orderUserList;
    }

    @Override
    public List<Order> selectUserUnship() {
        List<Order> orderUserList1 = orderMapper.findUserUnshipOrder();
        return orderUserList1;
    }

    @Override
    public List<Order> selectUserShip() {
        List<Order> orderUserList2 = orderMapper.findUserShipOrder();
        return orderUserList2;
    }

    @Override
    public List<Order> selectUserSigning() {
        List<Order> orderUserList3 = orderMapper.findUserSigningOrder();
        return orderUserList3;
    }

    @Override
    public List<Order> selectUserUnpay() {
        List<Order> orderUserList4 = orderMapper.findUserUnpayOrder();
        return orderUserList4;
    }

    @Override
    public List<Order> findUserUnpayOrder() {
        return null;
    }

    @Override
    public List<Order> selectShopUnship(long shopId) {
        List<Order> orderShopList = orderMapper.findShopUnshipOrder(shopId);
        return orderShopList;
    }

    @Override
    public List<Order> selectShopShip(long shopId) {
        List<Order> orderShopList1 = orderMapper.findShopShipOrder(shopId);
        return orderShopList1;
    }

    @Override
    public int addOrder(long userId, long productId, int count,String[] sku, float sum) {
        int n = orderMapper.addOrder(userId,productId,count,sku,sum);
        return 0;
    }

    @Override
    public int  updateOrder(long id) {
        int n = orderMapper.updateOrder(id);
        return n;
    }

    @Override
    public int updateOrder1(long id) {
        int n = orderMapper.updateOrder(id);
        return n;
    }

    @Override
    public int changeOrder(long id) {
        int n = orderMapper.changeOrder(id);
        return n;
    }

    @Override
    public int Order(long id) {
        int n = orderMapper.changeOrder(id);
        return n;
    }
}
