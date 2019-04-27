package com.taoqi.base.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @作者：刘时明
 * @时间：2019/4/4-14:19
 * @作用：
 */
public class MD5Util
{
    private static final String ALGORITHM = "md5";

    /**
     * md5加密方法
     *
     * @param str  密码
     * @param salt 密码盐
     * @return
     */
    public static String md5(String str, String salt)
    {
        // 加密之后所得字节数组
        str = str + salt;
        byte[] bytes = null;
        try
        {
            // 获取MD5算法实例 得到一个md5的消息摘要
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            //添加要进行计算摘要的信息
            md.update(str.getBytes());
            //得到该摘要
            bytes = md.digest();
        } catch (NoSuchAlgorithmException e)
        {
            System.out.println("加密算法: " + ALGORITHM + " 不存在: ");
        }
        return null == bytes ? null : BytesConvertToHexString(bytes);
    }

    public static String BytesConvertToHexString(byte[] bytes)
    {
        StringBuffer sb = new StringBuffer();
        for (byte aByte : bytes)
        {
            String s = Integer.toHexString(0xff & aByte);
            if (s.length() == 1)
            {
                sb.append("0" + s);
            } else
            {
                sb.append(s);
            }
        }
        return sb.toString();
    }
}
