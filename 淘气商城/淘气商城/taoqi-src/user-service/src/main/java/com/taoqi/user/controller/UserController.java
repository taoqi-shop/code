package com.taoqi.user.controller;

import com.taoqi.base.domain.User;
import com.taoqi.base.utils.ResultUtil;
import com.taoqi.user.mapper.TestMapper;
import com.taoqi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @作者：刘时明
 * @时间：2019/4/8-8:42
 * @作用：
 */
@RestController
@RequestMapping("user")
public class UserController
{
    @Autowired
    private UserService service;
    @Autowired
    private TestMapper testMapper;

    @PostMapping("reg")
    public Map<String, Object> reg(@RequestBody User user)
    {
        if(user!=null)
        {
            return service.reg(user);
        }else
        {
            return ResultUtil.error("错误参数");
        }
    }

    @GetMapping("get")
    public Map<String, Object> get(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size)
    {
        return service.get(page, size);
    }

    @GetMapping("test/{id}")
    public Object test(@PathVariable int id)
    {
        Object map=testMapper.getType(id);
        System.out.println(map);
        return map;
    }
}
