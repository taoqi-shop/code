/**
 * 
 */
package com.taoqi.spread.service;

import java.util.List;

import com.taoqi.spread.Spread;
import com.taoqi.spread.vo.VSpread;

/**
 *@author coco 
 *@date 2019年4月11日  
 *
 */
public interface SpreadService {
	
	/**
	 * 前三竞价信息
	 * @return
	 */
	List<VSpread> loadListThree();
	
	/**
	 * 所有竞价信息
	 * @return
	 */
	List<VSpread> loadListall();
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	int deleteid(int id);
	
	/**
	 * 删除前三
	 * 
	 * @return
	 */
	int deletethree();
	
	/**
	 * 提交竞价
	 * @param userid
	 * @param info
	 * @param imgsrc
	 * @param price
	 * @return
	 */
	int addSpread(int userid,String info,String imgsrc,float price);


}
