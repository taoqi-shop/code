package com.taoqi.user.mapper.property;

import java.util.List;
import java.util.Map;

/**
 * @作者：刘时明
 * @时间：2019/4/24-13:19
 * @作用：
 */
public class UserProperty
{
    public String delete(Map<String,Object> map)
    {
        List<Integer> list=(List<Integer>)map.get("list");
        StringBuilder sql=new StringBuilder("delete from t_user where id in(");
        for (Integer str:list)
        {
            sql.append(str+",");
        }
        sql.delete(sql.length()-1,sql.length());
        sql.append(")");
        return sql.toString();
    }
}
