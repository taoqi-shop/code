/**
 * 
 */
package com.taoqi.spread.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.taoqi.spread.Spread;
import com.taoqi.spread.vo.VSpread;

/**
 *@author coco 
 *@date 2019年4月8日  
 *
 */
@Mapper
public interface SpreadMapper {
	
	/**
	 * 查看所有竞标商家
	 * @return
	 */
	@Select("select id,user_id as userId,user_name as userName,name,info,imgsrc,price from v_spread")
	List<VSpread> listAllSpread();
	
	/**
	 * 查询竞标价格前三的商家
	 * @return list
	 */
	//第一个参数指定第一个返回记录行的偏移量，第二个参数指定返回记录行的最大数目。初始记录行的偏移量是 0(而不是 1)。
	@Select("select * from v_spread order by price desc limit 0,3")
	List<VSpread> listThree();
	
	/**
	 * 商家竞价信息
	 * @param userid 用户id
	 * @param info 推广信息
	 * @param imgsrc 图片
	 * @param price 价格
	 */
	@Insert("insert into t_spread(user_id,info,imgsrc,price) values(#{userid},#{info},#{imgsrc},#{price})")
	int insertSpread(@Param("userid")int userid,
			          @Param("info")String info,
			          @Param("imgsrc")String imgsrc,
			          @Param("price")float price);
	
	/**
	 * 根据id删除竞价信息
	 * @param id 竞价信息id
	 * @return
	 */
	@Delete("delete from t_spread where id=#{id}")
	int deleteSpreadById(@Param("id") int id);
	
	/**
	 * 删除轮播上的商家信息
	 */
	@Delete("delete from t_spread where id IN(select t.id from (select * from t_spread order by price DESC limit 0,3)AS t)")
	int deleteThreeSpread();


	

}
