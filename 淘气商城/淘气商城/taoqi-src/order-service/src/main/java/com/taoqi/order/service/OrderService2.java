package com.taoqi.order.service;

import org.springframework.stereotype.Service;
import utils.domain.Order;

import java.util.List;

public interface OrderService {
    /**
     * 查询所有订单
     * @return
     */
    public List<Order> selectAll();
    /**
     * 用户查看所有订单
     * @return
     */
    public List<Order> selectUser();
    /**
     * 用户查看待发货的所有订单
     * @return
     */
    public List<Order> selectUserUnship();
    /**
     * 用户查看待签收的订单
     * @return
     */
    public List<Order> selectUserShip();
    /**
     * 用户查看已签收的订单
     * @return
     */
    public List<Order> selectUserSigning();
    /**
     * 用户查看待付款的订单
     * @return
     */
    public List<Order> selectUserUnpay();
    public List<Order> findUserUnpayOrder();
    /**
     * 商铺查看所有未发货商品的订单
     * @param shopId
     * @return
     */
    public List<Order> selectShopUnship(long shopId);
    /**
     * 商铺查看所有已发货商品的订单
     * @param shopId
     * @return
     */
    public List<Order> selectShopShip(long shopId);
    /**
     * 通过购物车添加一条订单
     * @param userId
     * @param productId
     * @param count
     * @param sum
     * @return
     */
    public int  addOrder(long userId,long productId,int count,String[] sku,float sum);
    /**
     * 商铺的的发货
     * @param id
     * @return
     */
    public int  updateOrder(long id);
    /**
     *用户的签收
     * @param id
     * @return
     */
    public int  updateOrder1(long id);

    /**
     * 用户删除订单，系统便修改删除标记，用户之后便不能查询到
     * @param id
     * @return
     */
    public int changeOrder(long id);

    /**
     * 系統删除订单，系统便修改删除标记，用户之后便不能查询到
     * @param id
     * @return
     */
    public int Order(long id);
}
