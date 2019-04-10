package com.taoqi.evaluate.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @作者：刘时明
 * @时间：2019/4/4-13:52
 * @作用：响应的Result模板
 */
public class ResultUtil
{
    public static Map<String, Object> succes()
    {
        return result(200, "操作成功", null);
    }

    public static Map<String, Object> succes(String msg)
    {
        return result(200, msg, null);
    }

    public static Map<String, Object> succes(Object data)
    {
        return result(200, "操作成功", data);
    }

    public static Map<String, Object> error()
    {
        return result(500, "操作失败", null);
    }

    public static Map<String, Object> error(String msg)
    {
        return result(500, msg, null);
    }

    public static Map<String, Object> error(Object data)
    {
        return result(500, "操作失败", data);
    }

    public static Map<String, Object> result(int code, String msg, Object data)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }
}
