package com.taoqi.order.controller;

import com.taoqi.order.service.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import com.taoqi.order.service.impl.OrderServiceImpl;
import utils.domain.Order;

import java.util.List;

@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    OrderServiceImpl orderServiceImpl;

    /**
     * 系统管理员查询所有订单
     * @   9
     */
    @GetMapping("/getList")
    public List<Order> getList() {
        return  orderServiceImpl.selectAll();
    }

    /**
     *用户查看自己的订单
     * @return
     */
    @GetMapping("/getUserList")
    public List<Order> getListUserOrder(){
        return orderServiceImpl.selectUser();
    }

    /**
     * 用户查看待发货的所有订单
     * @return
     */
    @GetMapping("/getUserList1")
    public List<Order> getListUserUnshipOrder(){
        return orderServiceImpl.selectUserUnship();
    }

    /**
     * 用户查看待签收的订单
     * @return
     */
    @GetMapping("/getUserList2")
    public List<Order> getListUserShipOrder(){
        return orderServiceImpl.selectUserShip();
    }

    /**
     * 用户查看已签收的订单
     * @return
     */
    @GetMapping("/getUserList3")
    public List<Order> getListUserSigningOrder(){
        return orderServiceImpl.selectUserSigning();
    }

//    /**
//     * 用户查看待付款的订单
//     * @return
//     */
//    @GetMapping("/getUserList4")
//    public List<Order> getListUserUnpayOrder(){
//        return orderServiceImpl.selectUserUnpay();
//    }
//
//    /**
//     * 用户付款
//     */
//    @PutMapping("/putUserList")
//    public List<Order> putListUserUnpayOrder(){
//        return orderServiceImpl.selectUserUnpay();
//    }

    /**
     * 商铺查看所有未发货商品的订单
     * @param shopId
     * @return
     */
    @GetMapping("/getShopList")
    public List<Order> getListShopUnshipOrder( int shopId){
        return orderServiceImpl.selectShopUnship(shopId);
    }

    /**
     * 商铺查看所有已发货商品的订单
     * @param shopId
     * @return
     */
    @GetMapping("/getShopList1")
    public List<Order> getListShopShipOrder(int shopId){
        return orderServiceImpl.selectShopShip(shopId);
    }

    /**
     * 用户添加一条订单
     * @return
     */
    @PostMapping("/postAddOrder")
    public int postAddOrder(long userId,long productId,int count,String[] sku,float sum){
        return orderServiceImpl.addOrder(userId,productId,count,sku,sum);
    }

    /**
     * 系统根据商铺的的发货修改处理标记
     * @return
     */
    @PostMapping("/putUpdateOrder")
    public int putUpdateOrder(@PathVariable(name = "id") int id ){
        return orderServiceImpl.updateOrder(id);
    }

    /**
     * 系统根据用户的签收修改处理标记
     * @return
     */
    @PostMapping("/putUpdateOrder1")
    public int putUpdateOrder1(@PathVariable(name = "id") int id ){
        return orderServiceImpl.updateOrder1(id);
    }

    /**
     * 用户删除订单，系统便修改删除标记，用户之后便不能查询到
     * @return
     */
    @PostMapping("/putChangeOrder/{id}")
    public int postChangeOrder(@PathVariable(name = "id") int id ){
        System.out.println(id);
        return orderServiceImpl.changeOrder(id);
    }

    /**
     * 系統删除订单，系统便修改删除标记，用户之后便不能查询到
     * @return
     */
    @PostMapping("/putDelectOrder/{id}")
    public int postDelectOrder(@PathVariable(name = "id") int id ){
        System.out.println(id);
        return orderServiceImpl.changeOrder(id);
    }
}
