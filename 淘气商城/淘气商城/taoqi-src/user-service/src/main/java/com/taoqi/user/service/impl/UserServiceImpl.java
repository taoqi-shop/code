package com.taoqi.user.service.impl;

import com.taoqi.base.domain.User;
import com.taoqi.base.utils.MD5Util;
import com.taoqi.base.utils.ResultUtil;
import com.taoqi.user.mapper.UserMapper;
import com.taoqi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @作者：刘时明
 * @时间：2019/4/4-14:10
 * @作用：
 */
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper mapper;

    @Override
    public Map<String,Object> reg(User user)
    {
        User temp=mapper.getUserByUserName(user.getUserName());
        if(temp!=null)
        {
            return ResultUtil.error("该用户名已经存在了");
        }
        String salt= UUID.randomUUID().toString().substring(0,5);
        user.setStat(0);
        user.setSalt(salt);
        String passWord=MD5Util.md5(user.getPassWord(),salt);
        user.setPassWord(passWord);
        if(mapper.saveUser(user)==1)
        {
            return ResultUtil.succes("注册成功");
        }
        return ResultUtil.error("注册失败");
    }

    @Override
    public Map<String, Object> get(int page, int size)
    {
        return ResultUtil.succes(mapper.getUserAll(page,size));
    }
}
