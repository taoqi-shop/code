package evaluate.service;

import com.taoqi.base.domain.Evaluate;
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
	 * @param productid 商品编号
	 * @return 评论集合
	 */
	Object touristServicefind(long productid);

	/**
	 * 店铺查询订单的所有评论
	 * 
	 * @param orderid 订单编号
	 * @return 评论信息集合
	 */
	Object shopServicefind(long orderid);

	/**
	 * 系统管理员查询所有评论
	 * 
	 * @return 评论信息集合
	 */
	Object adminServicefind();

	/**
	 * 插入评论/ 回复信息
	 * 
	 * @param evaluate 所要插入的评论对象
	 * @return 1/0 (1：成功；2：失败)
	 */
	Object addServicEevaluate(Evaluate evaluate);

	/**
	 * 通过评论id删除一条评论信息
	 * [
	 * @param id 评论id
	 * @return 1/0 (1：成功；2：失败)
	 */
	Object deleteServiceEvaluate(long id);

}
