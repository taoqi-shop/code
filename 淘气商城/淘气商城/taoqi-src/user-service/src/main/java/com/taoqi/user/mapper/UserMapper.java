package com.taoqi.user.mapper;

import com.taoqi.base.domain.User;
import com.taoqi.user.mapper.property.UserProperty;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @作者：刘时明
 * @时间：2019/4/8-8:48
 * @作用：
 */
@Mapper
public interface UserMapper
{
    @Insert("insert into t_user(nick_name,user_name,pass_word,salt,phone,stat) values(#{nickName},#{userName},#{passWord},#{salt},#{phone},#{stat})")
    int saveUser(User user);

    @Select("select * from t_user limit #{page},#{size}")
    List<User> getUserAll(@Param("page") int page,@Param("size") int size);

    @Select("select * from t_user where user_name=#{name}")
    User getUserByUserName(String name);

    @DeleteProvider(type = UserProperty.class,method = "delete")
    int deleteAll(List<String> list);
}
