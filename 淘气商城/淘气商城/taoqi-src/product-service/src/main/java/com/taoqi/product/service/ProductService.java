package com.taoqi.product.service;

import com.taoqi.product.domain.Product;

import java.util.Map;

/**
 * @作者：刘时明
 * @时间：2019/4/24-13:55
 * @作用：
 */
public interface ProductService
{
    Map<String,Object> get(int page, int size);

    Map<String,Object> get(Long id);

    Map<String,Object> like();

    Map<String,Object> upShelf(Product product);

    Map<String,Object> downShelf(long id);

    Map<String,Object> getByType(int page, int size,long id);
}
