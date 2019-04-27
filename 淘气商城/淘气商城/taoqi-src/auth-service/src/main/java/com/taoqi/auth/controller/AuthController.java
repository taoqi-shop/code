package com.taoqi.auth.controller;

import com.taoqi.auth.jdbc.AuthDao;
import com.taoqi.auth.service.AuthService;
import com.taoqi.base.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @作者：刘时明
 * @时间：2019/4/9-8:44
 * @作用：
 */
@RestController
@RequestMapping("auth")
public class AuthController
{
    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public Object login(@RequestParam String name,@RequestParam String pass)
    {
        if(name!=null&&pass!=null)
        {
            return authService.login(name, pass);
        }else
        {
            return ResultUtil.error("参数错误");
        }
    }

    @PostMapping("check")
    public Object check(@RequestParam String jwt)
    {
        if(jwt!=null)
        {
            return authService.check(jwt);
        }else
        {
            return ResultUtil.error("参数错误");
        }
    }

    @Autowired
    private AuthDao dao;

    @GetMapping("test/{id}")
    public Object test(@PathVariable int id)
    {
        dao.getType(id);
        return "ok";
    }
}
