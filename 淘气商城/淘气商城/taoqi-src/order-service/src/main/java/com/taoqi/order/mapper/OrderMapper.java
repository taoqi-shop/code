package com.taoqi.order.mapper;

import org.apache.ibatis.annotations.*;
import utils.domain.Order;


import java.util.List;
@Mapper
public interface OrderMapper {
    /**
     * 查询所有订单
     * @return
     */
    @Select("select id,user_id,product_id,count,sku,sum,del,stat,time from t_order")
    @Results({
//            @Result(property = "id",column ="id" ),
            @Result(property = "userId",column ="user_id" ),
            @Result(property="productId",column = "product_id")})
    public List<Order> find();

    /**
     * 用户查看所有订单
     * @return
     */
    @Select("select id,user_id,product_id,count,sku,sum,del,stat,time from t_order where del = '0'")
    public List<Order> findUserOrder();

    /**
     * 用户查看待发货的所有订单
     * @return
     */
    @Select("select id,user_id,product_id,count,sku,sum,del,stat,time from t_order where del = '0' and stat = '0'")
    public List<Order> findUserUnshipOrder();

    /**
     * 用户查看待签收的订单
     * @return
     */
    @Select("select id,user_id,product_id,count,sku,sum,del,stat,time from t_order where del = '0' and stat = '1'")
    public List<Order> findUserShipOrder();

    /**
     * 用户查看已签收的订单
     * @return
     */
    @Select("select id,user_id,product_id,count,sku,sum,del,stat,time from t_order where del = '0' and stat = '2'")
    public List<Order> findUserSigningOrder();

    /**
     * 用户查看待付款的订单
     * @return
     */
    @Select("select id,user_id,product_id,count,sku,sum,del,stat,time from t_order where del = '0' and stat = '3'")
    public List<Order> findUserUnpayOrder();



    /**
     * 商铺查看所有未发货商品的订单
     * @param shopId
     * @return
     */
    @Select("SELECT v_productandshop.shop_id,v_productandshop.name,t_order.id,t_order.user_id,t_order.product_id,\n" +
            "t_order.count,t_order.sku,t_order.sum,t_order.del,t_order.stat,t_order.time FROM t_order,v_productandshop \n" +
            "WHERE t_order.product_id = v_productandshop.id and t_order.stat = '0' and v_productandshop.shop_id =#{shop_id}")
    public List<Order> findShopUnshipOrder(@Param("shop_id") long shopId);

    /**
     * 商铺查看所有已发货商品的订单
     * @param shopId
     * @return
     */
    @Select("SELECT v_productandshop.shop_id,v_productandshop.name,t_order.id,t_order.user_id,t_order.product_id,\n" +
            "t_order.count,t_order.sku,t_order.sum,t_order.del,t_order.stat,t_order.time FROM t_order,v_productandshop \n" +
            "WHERE t_order.product_id = v_productandshop.id and t_order.stat = '1' and v_productandshop.shop_id =#{shop_id}")
    public List<Order> findShopShipOrder(@Param("shop_id") long shopId);

    /**
     * 通过购物车添加一条订单
     * @param userId
     * @param productId
     * @param count
     * @param sum
     * @return
     */
    @Insert("insert into t_order(user_id,product_id,count,sku,sum)values" +
            "(user_id = #{user_id},product_id = #{product_id},count = #{count},sku = #{sku},sum = #{sum})")
    public int addOrder(@Param("user_id")long userId,@Param("product_id") long productId,@Param("count") int count,@Param("sku") String[] sku,@Param("sum") float sum);

    /**
     * 系统根据商铺的的发货修改处理标记
     * @param id
     * @return
     */
    @Update("update t_order set stat = 1 where id =#{id}")
    public int updateOrder(@Param("id") long id);

    /**
     * 系统根据用户的签收修改处理标记
     * @param id
     * @return
     */
        @Update("update t_order set stat = 2 where id =#{id}")
    public int updateOrder1(@Param("id") long id);


    /**
     * 用户删除订单，系统便修改删除标记，用户之后便不能查询到
     * @param id
     * @return
     */
    @Update("update t_order set del = '1' where id = #{id}")
    public int changeOrder(@Param("id") long id);

    /**
     * 系统删除订单，系统便修改删除标记
     * @param id
     * @return
     */
    @Delete("delect t_order set del = '1' where id = #{id}")
    public int delectOrder(@Param("id") long id);
}
