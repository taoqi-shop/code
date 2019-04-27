package com.taoqi.car.service;

import com.taoqi.base.domain.Car;

import java.util.List;
import java.util.Map;

public interface Service {

    /**
     *    根据用户编号查询购物车
     *
     * @return   购物车集合
     */
    Map<String, Object> findServiceCar(long userId);

    /**
     *   根据购物车编号删除指定购物车
     * @param carId 购物车编号
     * @return  Map集合  （状态码，消息，数据）
     */
    Map<String, Object> deleteServiceCarById(long carId);

    /**
     *  根据用户编号删除该用户所有购物车信息（清空购物车）
     * @param userId   用户编号
     * @return  Map集合  （状态码，消息，数据）
     */
    Map<String, Object> deleteServiceCar(long userId);

    /**
     *    添加购物车
     * @param car  购物车对象
     * @return  Map集合  （状态码，消息，数据）
     */
    Map<String, Object> addServiceCar(Car car);

    /**
     *    修改购物车信息
     * @param sku  规格
     * @param count  数量
     * @param carId  购物车编号
     * @return  Map集合  （状态码，消息，数据）
     */
    Map<String, Object> updateServiceCar(String sku,int count,long carId);

    /**
     *  批量删除
     * @param list  删除编号的集合
     * @return  Map集合  （状态码，消息，数据）
     */
    Map<String, Object> deletebatch(List<Integer> list);
}
