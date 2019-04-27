package com.taoqi.test.jdbc;

import java.sql.*;

/**
 * @作者：刘时明
 * @时间：2019/4/23-13:44
 * @作用：
 */
public class DBUtil
{
    static
    {
        try
        {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    //获取node1上的数据库连接
    public static Connection getNode1Connection()
    {
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/node1?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=false&serverTimezone=GMT", "root", "root");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return conn;
    }

    //获取node1上的数据库连接
    public static Connection getNode2Connection()
    {
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/node2?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=false&serverTimezone=GMT", "root", "root");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return conn;
    }

    //关闭连接
    public static void close(ResultSet rs, Statement st, Connection conn)
    {
        try
        {
            if (rs != null)
            {
                rs.close();
            }
            if (st != null)
            {
                st.close();
            }
            if (conn != null)
            {
                conn.close();
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
