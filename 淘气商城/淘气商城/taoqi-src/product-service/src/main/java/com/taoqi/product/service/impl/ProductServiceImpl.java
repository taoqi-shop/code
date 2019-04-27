package com.taoqi.product.service.impl;

import com.taoqi.base.utils.ResultUtil;
import com.taoqi.product.domain.Product;
import com.taoqi.product.facade.ProductFacade;
import com.taoqi.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @作者：刘时明
 * @时间：2019/4/24-13:56
 * @作用：
 */
@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductFacade facade;

    @Override
    public Map<String,Object> get(int page, int size)
    {
        return ResultUtil.succes(facade.get(page, size));
    }

    @Override
    public Map<String, Object> get(Long id)
    {
        return ResultUtil.succes(facade.get(id));
    }

    @Override
    public Map<String, Object> like()
    {
        return ResultUtil.succes(facade.like());
    }

    @Override
    public  Map<String,Object> upShelf(Product product)
    {
        product.setShelf(1);
        facade.upShelf(product);
        return ResultUtil.succes("操作成功");
    }

    @Override
    public Map<String, Object> downShelf(long id)
    {
        facade.downShelf(id);
        return ResultUtil.succes("操作成功");
    }

    @Override
    public Map<String, Object> getByType(int page,int size,long id)
    {
        return ResultUtil.succes(facade.getByType(page, size, id));
    }
}
