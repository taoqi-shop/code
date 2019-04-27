package com.taoqi.auth.utils;

import com.google.gson.Gson;
import com.taoqi.auth.config.AuthConfig;
import com.taoqi.base.domain.auth.UserInfo;
import io.jsonwebtoken.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class JwtUtil
{
    public static String getJWT(UserInfo user)
    {
        return Jwts.builder().setSubject(AuthConfig.SUBJECT)
                .claim("user",user)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+AuthConfig.JWT_TTL))
                .signWith(SignatureAlgorithm.HS256,AuthConfig.JWT_SECRET)
                .compact();
    }

    public static Claims checkJWT(String jwt)
    {
        try
        {
            return Jwts.parser().setSigningKey(AuthConfig.JWT_SECRET).parseClaimsJws(jwt).getBody();
        }catch (Exception e)
        {
            return null;
        }
    }

    public static void main(String[] args)
    {
        UserInfo userInfo=new UserInfo();
        userInfo.setId(1L);
        userInfo.setUserName("hello");
        userInfo.setAuth(new ArrayList<>());
        String jwt=getJWT(userInfo);
        System.out.println(jwt);

        Claims claims=checkJWT(jwt);
        Map map=claims;
        LinkedHashMap temp=(LinkedHashMap)map.get("user");
        System.out.println(temp.entrySet());
    }
}
