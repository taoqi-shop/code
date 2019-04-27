package com.taoqi.test.jdbc;

import java.sql.Connection;

/**
 * @作者：刘时明
 * @时间：2019/4/23-13:47
 * @作用：
 */
public class XADemo
{
    public static void main(String[] args)
    {
        //获取连接
        Connection node1Conn = DBUtil.getNode1Connection();
        Connection node2Conn = DBUtil.getNode2Connection();

        System.out.println(node1Conn+","+node2Conn);
    }
}
