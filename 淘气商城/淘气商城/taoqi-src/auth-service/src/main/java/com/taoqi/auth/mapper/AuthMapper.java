package com.taoqi.auth.mapper;

import com.taoqi.base.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;
import java.util.Map;

/**
 * @作者：刘时明
 * @时间：2019/4/9-8:46
 * @作用：
 */
@Mapper
public interface AuthMapper
{
    @Select({"call login(#{name,jdbcType=VARCHAR,mode=IN},#{pass,jdbcType=VARCHAR,mode=IN})"})
//    @Results({
//            @Result(property = "1",column = "1"),
//            @Result(property = "id",column = "id")
//        })
    @Options(statementType = StatementType.CALLABLE)
    Map<String,Object> login(@Param("name") String userName, @Param("pass") String passWord);

    @Select("select role from v_auth where user_id=#{id}")
    List<String> getRolesByUserId(Long id);

    @Select("select id,nick_name as nickName,user_name as userName,imgSrc,phone,address from t_user where user_name=#{userName}")
    User getUserByUserName(String userName);
}
