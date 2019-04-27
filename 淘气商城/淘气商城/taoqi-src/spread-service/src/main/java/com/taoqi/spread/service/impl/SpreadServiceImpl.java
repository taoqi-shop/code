/**
 * 
 */
package com.taoqi.spread.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taoqi.spread.Spread;
import com.taoqi.spread.mapper.SpreadMapper;
import com.taoqi.spread.service.SpreadService;
import com.taoqi.spread.vo.VSpread;

/**
 *@author coco 
 *@date 2019年4月11日  
 *
 */
@Service
public class SpreadServiceImpl implements SpreadService{
	
	@Autowired
	SpreadMapper mapper;

	
	@Override
	public List<VSpread> loadListThree() {
		
		return mapper.listThree();
	}

	
	@Override
	public List<VSpread> loadListall() {
		
		return mapper.listAllSpread();
	}



	@Override
	public int deletethree() {
		
		return mapper.deleteThreeSpread();
	}

	
	
	@Override
	public int deleteid(int id) {
		
		return mapper.deleteSpreadById(id);
	}

	
	
	@Override
	public int addSpread(int userid, String info, String imgsrc, float price) {
		
		return mapper.insertSpread(userid, info, imgsrc, price);
	}


	

}
