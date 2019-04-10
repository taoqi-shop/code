package com.taoqi.evaluate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taoqi.evaluate.entity.Evaluate;
import com.taoqi.evaluate.service.EvaluateService;
import com.taoqi.evaluate.utils.ResultUtil;

@RestController
public class EvaluateController {

	@Autowired
	EvaluateService service;

	@GetMapping("evaluate/uget/{priductid}")
	public Object getTouristEvaluate(@PathVariable("priductid") long priductid) {
		return ResultUtil.succes(service.touristfind(priductid));
	}

	@GetMapping("evaluate/sget/{orderid}")
	public Object getShopEvaluate(@PathVariable("orderid") long orderid) {
		return ResultUtil.succes(service.shopfind(orderid));
	}

	@GetMapping("evaluate/get")
	public Object getAdminEvaluate() {
		return ResultUtil.succes(service.adminfind());
	}

	@PostMapping("evaluate/add")
	public Object AddEvaluate(@RequestBody Evaluate evaluate) {

		String msg;
		int eva = service.addevaluate(evaluate);
		if (eva == 1) {
			msg = "操作成功";
			return ResultUtil.succes(msg);
		} else {
			msg = "操作失败";
			return ResultUtil.error(msg);
		}
	}

	@PostMapping("evaluate/delete")
	public Object DeleteEvaluate(long id) {
		String msg;
		int eva = service.deleteevaluate(id);
		if(eva==1) {
			msg = "操作成功";
			return ResultUtil.succes(msg);
		}else {
			msg = "操作成功";
			return ResultUtil.error(msg);
		}
	}
}
