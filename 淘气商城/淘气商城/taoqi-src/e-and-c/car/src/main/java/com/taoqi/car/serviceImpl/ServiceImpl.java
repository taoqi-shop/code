package com.taoqi.car.serviceImpl;

import com.taoqi.base.domain.Car;
import com.taoqi.car.mapper.CarMapper;
import com.taoqi.car.service.Service;
import com.taoqi.car.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    @Autowired
    CarMapper carMapper;

    @Override
    public Map<String, Object> findServiceCar(long userId) {
        return ResultUtil.succes(carMapper.findCar(userId));
    }

    @Override
    public Map<String, Object> deleteServiceCarById(long carId) {

        String msg;
        if (1 == carMapper.deleteById(carId)) {
            msg = "操作成功";
            return ResultUtil.succes(msg);
        } else {
            msg = "操作失败";
            return ResultUtil.error(msg);
        }
    }

    @Override
    public Map<String, Object> deleteServiceCar(long userId) {

        String msg;
        if(1== carMapper.deleteAllbyId(userId)){
            msg = "操作成功";
            return ResultUtil.succes(msg);
        }else{
            msg = "操作失败";
            return  ResultUtil.error(msg);
        }
    }

    @Override
    public Map<String, Object> addServiceCar(Car car) {

        String msg;
        if(1== carMapper.addCar(car)){
            msg = "操作成功";
            return ResultUtil.succes(msg);
        }else{
            msg = "操作失败";
            return ResultUtil.error(msg);
        }
    }

    @Override
    public Map<String, Object> updateServiceCar(String sku, int count, long carId) {

        String msg;
        if(1==carMapper.updateCar(sku,count,carId)){
            msg = "操作成功";
            return ResultUtil.succes(msg);
        }else{
            msg = "操作失败";
            return  ResultUtil.error(msg);
        }
    }
    @Override
    public Map<String, Object> deletebatch(List<Integer> list){
        String msg;
        List<Integer> a = new ArrayList<>();
        for (Integer i:list) {
            a.add(i);
        }
        for( int i = 0;i<a.size();i++){
            if (a.get(i)==0) {
                list.remove(a.get(i));
            }
        }
        System.out.println(list);
        if(1==carMapper.deletebatch(list)){
            msg = "操作成功";
            return ResultUtil.succes(msg);
        }else{
            msg = "操作失败";
            return  ResultUtil.error(msg);
        }
    }
}
