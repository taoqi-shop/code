package com.taoqi.car.mapper;

import com.taoqi.base.domain.Car;
import com.taoqi.base.domain.VCar;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CarMapper {

    /**
     * 用户查询所有购物车
     *
     * @param userId 用户编号
     * @return 购物车对象集合
     */
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "product_id", property = "productId"),
            @Result(column = "shop_name",property = "shopName")
    })
    @Select("select * from v_car where user_id=#{id}")
    List<VCar> findCar(@Param("id") long userId);

    /**
     * 根据购物车编号删除购物车
     * @param carId 购物车编号
     * @return  0/1   1:添加成功；2：添加失败
     */
    @Delete("delete from t_car where id=#{id}")
    int deleteById(@Param("id") long carId);

    /**
     * 清空购物车
     *
     * @param userId  用户编号
     * @return  1/0，1:删除成功；2：删除失败 ；
     */
    @Delete("delete from t_car where user_id=#{id}")
    int deleteAllbyId(@Param("id") long userId);

    /**
     * 添加购物车
     * @param car  购物车对象
     * @return  0/1   1:添加成功；2：添加失败
     */
    @Insert("insert into t_car(user_id,product_id,price,count,sku) values(user_id=#{userId},product_id=#{productId},`count`=#{count},sku=#{sku})")
    int addCar (Car car);


    /**
     *   修改购物车信息
     * @param sku 规格
     * @param count 数量
     * @param carId 购物车编号
     * @return 0/1 1：更新成功； 2：更新失败
     */
    @Update("update t_car set sku= #{sku},`count`= #{count} where id = #{id}")
    int updateCar(@Param("sku") String sku,
                  @Param("count") int count,
                  @Param("id") long carId);

    @DeleteProvider(type=CarSql.class , method = "test")
    int deletebatch(List<Integer> list);
}
