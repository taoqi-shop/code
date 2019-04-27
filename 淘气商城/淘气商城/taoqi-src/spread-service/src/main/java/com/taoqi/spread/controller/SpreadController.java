/**
 * 
 */
package com.taoqi.spread.controller;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taoqi.spread.Spread;
import com.taoqi.spread.mapper.SpreadMapper;
import com.taoqi.spread.service.SpreadService;
import com.taoqi.spread.service.impl.SpreadServiceImpl;
import com.taoqi.spread.utils.ResultUtil;
import com.taoqi.spread.vo.VSpread;

/**
 *@author coco 
 *@date 2019年4月8日  
 *
 */
@RestController
@CrossOrigin
public class SpreadController {
	
	@Autowired
	SpreadMapper mapper;
	@Autowired
	SpreadService service;
	
	@GetMapping("/spread/getall")
	public List<VSpread> getAllSpread(){
		List<VSpread> listall = service.loadListall();
		System.out.println("输出成功");
		return listall;
	}
	
	
	@GetMapping("/spread/get")
	public List<VSpread> getThreeSpread(){
		List<VSpread> list = service.loadListThree();
		System.out.println(list);
		return list;
		
	}
	
	@PostMapping("/spread/insert")
	public Map<String, Object> insertSpread(@RequestBody Spread spread){
		
		System.out.println(spread);
		if(service.addSpread(spread.getUserid(), spread.getInfo(), spread.getImgsrc(), spread.getPrice()) == 1) {
			
			
			return ResultUtil.succes();
			
		}else {
			
			return ResultUtil.error();
		}
		
		
	}
	
	
	@PostMapping(value = "/spread/deletebyid/{id}")
	public Map<String, Object> deleteSpreadById(@PathVariable int id) {
		
		if(service.deleteid(id) == 1) {
			
			return ResultUtil.succes();
			
		}else {
			
			return ResultUtil.error();
			
		}
		
		
	}
	
	@GetMapping("/spread/delete")
	public Map<String, Object> deleteSpread() {
		
		if(service.deletethree() == 1) {
			
			return ResultUtil.succes();
			
		}else {
			
			return ResultUtil.error();
		}
		
		
	}
	


}
