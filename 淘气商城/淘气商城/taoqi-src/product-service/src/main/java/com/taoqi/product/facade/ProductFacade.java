package com.taoqi.product.facade;

import com.taoqi.product.dao.ProductDao;
import com.taoqi.product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @作者：刘时明
 * @时间：2019/4/24-15:02
 * @作用：
 */
@Component
public class ProductFacade
{
    private static final String KEY_SUB = "product_";
    @Autowired
    private ProductDao dao;
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate template;

    public List<Product> get(int page, int size)
    {
        String key = KEY_SUB + "page_" + page;
        if (template.hasKey(key) && template.getExpire(key) > 0)
        {
            System.out.println("get(int page, int size) ==> 缓存命中");
            System.out.println(template.getExpire(key));
            List<Product> list = (List<Product>) template.opsForValue().get(key);
            System.out.println("list => " + list);
            return list;
        } else
        {
            Pageable pageable = PageRequest.of(page, size);
            List<Product> list = dao.getAllByShelf(pageable, 1);
            template.opsForValue().set(key, list, 5, TimeUnit.SECONDS);
            return list;
        }
    }

    public Product get(long id)
    {
        String key = KEY_SUB + id;
        if (template.hasKey(key) && template.getExpire(key) != -2)
        {
            System.out.println("get(long id) ==> 缓存命中");
            return (Product) template.opsForValue().get(key);
        } else
        {
            Product product = dao.findById(id).get();
            template.opsForValue().set(key, product, 5, TimeUnit.MINUTES);
            return product;
        }
    }

    public List<Product> like()
    {
        return dao.like();
    }

    public void upShelf(Product product)
    {
        dao.save(product);
    }

    public void downShelf(long id)
    {
        dao.deleteById(id);
        String key = KEY_SUB + id;
        template.delete(key);
    }

    public List<Product> getByType(int page, int size, long id)
    {
        return dao.getAllByTypeIdAndShelf(PageRequest.of(page, size), id,1);
    }
}
