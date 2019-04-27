package com.taoqi.order.utils;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @作者：刘时明
 * @时间：2019/4/22-9:26
 * @作用：
 */
public class LuaScriptUtil
{
    private static Map<Object, byte[]> shaMap = new HashMap<>();

    public static Object runScript(String lua, Jedis jedis, List<byte[]> keyList, List<byte[]> value)
    {
            // 如果脚本未加载则加载
        if (!shaMap.containsKey(lua))
        {
            byte[] bytes = lua.getBytes();
            byte[] sha = jedis.scriptLoad(bytes);
            shaMap.put(lua, sha);
        }
        return jedis.evalsha(shaMap.get(lua), keyList, value);
    }
}
