package com.taoqi.car.controller;

import com.taoqi.base.domain.Car;
import com.taoqi.car.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api-car/car")
@CrossOrigin
public class CarController {

    @Autowired
    Service  service;

    @GetMapping("/fcar/{id}")

    public Map<String,Object> getCar(@PathVariable("id") long userId){
        return service.findServiceCar(userId);
    }

    @DeleteMapping("/dcar/{id}")
    public Map<String,Object> deleteCarById(@PathVariable("id") long carId){
        return service.deleteServiceCarById(carId);
    }

    @DeleteMapping("/dacar/{id}")
    public Map<String,Object> deleteAllCar(@PathVariable("id") long userid){
        return service.deleteServiceCar(userid);
    }

    @PostMapping("/acar")
    public Map<String,Object> addCar(Car car){
        return service.addServiceCar(car);
    }

    @DeleteMapping("/batch")
    public Map<String,Object> deletebatch(@RequestBody List<Integer> list){
        return service.deletebatch(list);
    }
}
