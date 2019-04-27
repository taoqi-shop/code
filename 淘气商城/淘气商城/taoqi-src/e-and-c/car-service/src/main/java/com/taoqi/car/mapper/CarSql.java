package com.taoqi.car.mapper;


import java.util.List;
import java.util.Map;

public class CarSql {

    public String  test(Map<String,Object> map){
        String sql = "delete from t_car where id in (";
        StringBuilder sb = new StringBuilder(sql);
        List<Integer> list = (List<Integer>) map.get("list");
        for(Integer i :list){
            sb.append(i+",");
        }
        sb.delete(sb.length()-1,sb.length());
        sb.append(")");
        return sb.toString();
    }
}
