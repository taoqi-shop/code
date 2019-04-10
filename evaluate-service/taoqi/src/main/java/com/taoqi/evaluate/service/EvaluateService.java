package com.taoqi.evaluate.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.taoqi.evaluate.entity.Evaluate;
import com.taoqi.evaluate.entity.VEvaluate;

/**
 * 评论模块业务逻辑的所有接口
 * 
 * @author 熊熊
 *
 */
public interface EvaluateService {

	/**
	 * 
	 * 游客查询商品评论
	 * 
	 * @param priductid 商品编号
	 * @return 评论集合
	 */
	List<VEvaluate> touristfind(long priductid);

	/**
	 * 店铺查询订单的所有评论
	 * 
	 * @param orderid 订单编号
	 * @return 评论信息集合
	 */
	List<VEvaluate> shopfind(long orderid);

	/**
	 * 系统管理员查询所有评论
	 * 
	 * @return 评论信息集合
	 */
	List<VEvaluate> adminfind();

	/**
	 * 插入评论/ 回复信息
	 * 
	 * @param evaluate 所要插入的评论对象
	 * @return 1/0 (1：成功；2：失败)
	 */
	int addevaluate(Evaluate evaluate);

	/**
	 * 通过评论id删除一条评论信息
	 * 
	 * @param id 评论id
	 * @return 1/0 (1：成功；2：失败)
	 */
	int deleteevaluate(@Param("id") long id);

}
