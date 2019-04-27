package com.taoqi.gateway.util;

import com.taoqi.gateway.config.AuthConfig;
import io.jsonwebtoken.*;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.List;

public class JwtUtil
{
    /**
     * 解密jwt
     *
     * @param jwt
     * @return
     */
    public static Claims parseJWT(String jwt)
    {
        // 签名秘钥，和生成的签名的秘钥一模一样
        SecretKey key = generalKey();
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).getBody();
        return claims;
    }

    /**
     * 加密
     *
     * @return
     */
    public static SecretKey generalKey()
    {
        String stringKey = AuthConfig.JWT_SECRET;
        // 本地的密码解码
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        // 根据给定的字节数组使用AES加密算法构造一个密钥
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    public static boolean isAuth(List<String> arr, String auth)
    {
        for (String s:arr)
        {
            if(s.equals(auth))
            {
                return true;
            }
        }
        return false;
    }

//    private static Map<String, Object> getClaims(String jwt)
//    {
//        Map<String, Object> map = new HashMap<>();
//        try
//        {
//            Claims claims = JwtUtil.parseJWT(jwt);
//            String temp = claims.getSubject();
//            Gson gson=new Gson();
//            UserInfo user = gson.fromJson(temp, UserInfo.class);
//            map.put("code", 1);
//            map.put("user", user);
//            for (Map.Entry e : claims.entrySet())
//            {
//                map.put(e.getKey().toString(), e.getValue());
//            }
//        } catch (ExpiredJwtException e1)
//        {
//            System.err.println("jwt超时");
//            map.put("code", 0);
//        } catch (Exception e2)
//        {
//            System.err.println("jwt错误");
//            map.put("code", -1);
//        }
//        return map;
//    }
}
