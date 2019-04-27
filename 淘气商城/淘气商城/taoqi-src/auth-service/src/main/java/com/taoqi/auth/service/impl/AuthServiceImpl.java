package com.taoqi.auth.service.impl;

import com.google.gson.Gson;
import com.taoqi.auth.jdbc.AuthDao;
import com.taoqi.auth.mapper.AuthMapper;
import com.taoqi.auth.service.AuthService;
import com.taoqi.auth.utils.JwtUtil;
import com.taoqi.base.domain.User;
import com.taoqi.base.domain.auth.UserInfo;
import com.taoqi.base.utils.ResultUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @作者：刘时明
 * @时间：2019/4/17-14:56
 * @作用：
 */
@Service
public class AuthServiceImpl implements AuthService
{
    @Autowired
    private AuthMapper mapper;
    @Autowired
    private AuthDao dao;

    @Override
    public Map<String, Object> login(String name, String pass)
    {
        User user=dao.login(name,pass);
        if(user==null)
        {
            return ResultUtil.error("登录失败");
        }else
        {
            UserInfo userInfo=new UserInfo();
            userInfo.setId(user.getId());
            userInfo.setUserName(user.getUserName());
            userInfo.setAuth(mapper.getRolesByUserId(user.getId()));
            String jwt=JwtUtil.getJWT(userInfo);
            return ResultUtil.result(200,jwt,user);
        }
    }

    @Override
    public Map<String, Object> check(String jwt)
    {
        try
        {
            Claims claims= JwtUtil.checkJWT(jwt);
            if(claims!=null)
            {
                Map map= (Map) claims.get("user");
                UserInfo userInfo=new UserInfo();
                userInfo.setId(Long.parseLong(map.get("id").toString()));
                userInfo.setUserName(map.get("userName").toString());
                userInfo.setAuth((List<String>) map.get("auth"));
                return ResultUtil.result(200,JwtUtil.getJWT(userInfo),mapper.getUserByUserName(userInfo.getUserName()));
            }
            return ResultUtil.error("身份过期，请重新登录");
        }catch (Exception e)
        {
            return ResultUtil.error("身份过期，请重新登录");
        }
    }
}
