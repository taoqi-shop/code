package com.taoqi.product.controller;

import com.taoqi.product.domain.Product;
import com.taoqi.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @作者：刘时明
 * @时间：2019/4/24-14:00
 * @作用：
 */
@RestController
@RequestMapping("product")
public class ProductController
{
    @Autowired
    private ProductService service;

    @GetMapping("get")
    public Object get(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size)
    {
        return service.get(page, size);
    }

    @GetMapping("get/{id}")
    public Object get(@PathVariable long id)
    {
        return service.get(id);
    }

    @GetMapping("like")
    public Object like()
    {
        return service.like();
    }

    @PostMapping("upShelf")
    public Object upShelf(@RequestBody Product product)
    {
        return service.upShelf(product);
    }

    @PostMapping("upShelf/{id}")
    public Object downShelf(@PathVariable long id)
    {
        return service.downShelf(id);
    }

    @GetMapping("type/{id}")
    public Object getByType(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @PathVariable long id)
    {
        return service.getByType(page, size, id);
    }
}
