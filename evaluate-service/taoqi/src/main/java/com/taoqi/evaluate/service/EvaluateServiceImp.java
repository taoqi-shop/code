package com.taoqi.evaluate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.taoqi.evaluate.entity.Evaluate;
import com.taoqi.evaluate.entity.VEvaluate;
import com.taoqi.evaluate.mapper.EvaluateMapper;

public class EvaluateServiceImp implements EvaluateService {

	@Autowired
	EvaluateMapper mapper;
	
	@Override
	public List<VEvaluate> touristfind(long priductid) {
		return mapper.touristfind(priductid);
	}

	@Override
	public List<VEvaluate> shopfind(long orderid) {
		return mapper.shopfind(orderid);
	}

	@Override
	public List<VEvaluate> adminfind() {
		return mapper.adminfind();
	}

	@Override
	public int addevaluate(Evaluate evaluate) {
		return mapper.addevaluate(evaluate);
	}

	@Override
	public int deleteevaluate(long id) {
		return mapper.deleteevaluate(id);
	}

}
