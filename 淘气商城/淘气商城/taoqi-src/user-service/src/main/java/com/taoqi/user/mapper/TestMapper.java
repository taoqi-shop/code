package com.taoqi.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import java.util.Map;

/**
 * @作者：刘时明
 * @时间：2019/4/18-15:49
 * @作用：
 */
@Mapper
public interface TestMapper
{
    @Select({"call getType(#{id,jdbcType=INTEGER,mode=IN})"})
//    @Results({
//            @Result(property = "1",column = "1"),
//            @Result(property = "id",column = "id")
//        })
    @Options(statementType = StatementType.CALLABLE)
    Object getType(int id);
}
