package evaluate.mapper;
import com.taoqi.base.domain.Evaluate;
import com.taoqi.base.domain.VEvaluate;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * 评论模块的业务逻辑
 * 
 * @author 熊熊
 *
 */
@Mapper
public interface EvaluateMapper {

	/**
	 * 游客查询商品订单评论
	 * 
	 * @param productid 商品编号
	 * @return 评论信息集合
	 */
	@Select("select * from v_evaluate where order_id in (select id from t_order where product_id=#{id})")
	List<VEvaluate> touristfind(@Param("id") long productid);

	/**
	 * 店铺查询订单的所有评论
	 * 
	 * @param orderid 订单编号
	 * @return  评论信息集合
	 */
	@Select("select * from v_evaluate where order_id = #{id}")
	List<VEvaluate> shopfind(@Param("id") long orderid);

	/**
	 * 系统管理员查询所有评论
	 * 
	 * @return 评论信息集合
	 */
	@Select("select * from v_evaluate")
	List<VEvaluate> adminfind();

	/**
	 * 插入评论/ 回复信息
	 * 
	 * @param evaluate 所要插入的评论对象
	 * @return 1/0 (1：成功；2：失败)
	 */
	@Insert("insert into t_evaluate(user_id,order_id,reply_id,star,info) values(user_id=#{evaluate.user_id} , order_id=#{evaluate.order_id} , reply_id=#{evaluate.reply_id}, star=#{evaluate.star} , info=#{evaluate.info})")
	int addevaluate(Evaluate evaluate);

	/**
	 * 通过评论id删除一条评论信息
	 * 
	 * @param id 评论id
	 * @return 1/0 (1：成功；2：失败)
	 */
	@Delete("delete from t_evaluate where id=#{id} ")
	int deleteevaluate(@Param("id") long id);

}
