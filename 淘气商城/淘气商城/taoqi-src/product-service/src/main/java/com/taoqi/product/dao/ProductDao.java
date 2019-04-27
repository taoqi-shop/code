package com.taoqi.product.dao;

import com.taoqi.product.domain.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @作者：刘时明
 * @时间：2019/4/24-13:55
 * @作用：
 */
@Repository
public interface ProductDao extends JpaRepository<Product, Long>
{
    List<Product> getAllByShelf(Pageable pageable, Integer shelf);

    @Query(value = "SELECT * FROM (SELECT * ,ROUND(RAND()) AS newno FROM t_product WHERE shelf=1 GROUP BY id)AS t ORDER BY t.newno asc LIMIT 6",nativeQuery = true)
    List<Product> like();

    List<Product> getAllByTypeIdAndShelf(Pageable pageable, long typeId, Integer shelf);
}
