package com.taoqi.test.test;

import java.sql.*;

/**
 * @作者：刘时明
 * @时间：2019/4/16-11:30
 * @作用：
 */
public class JDBCTest
{
    public static void main(String[] args) throws SQLException,ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taoqi?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=false&serverTimezone=GMT","root","root");

//        PreparedStatement ps=conn.prepareStatement("select * from t_json");
//        ResultSet rs=ps.executeQuery();
//        while (rs.next())
//        {
//            System.out.println(rs.getString(1));
//            System.out.println(rs.getString(2));
//        }

        test(conn,1);
    }

    private static void test(Connection conn,int id) throws SQLException
    {
        CallableStatement call=conn.prepareCall("call getType(?)");
        call.setInt(1,id);
        boolean hashResult= call.execute();
        ResultSet rs = call.getResultSet();
        while (rs.next())
        {
            System.out.println(rs.getString(1));
        }
        System.out.println("----");
        while (true)
        {
            if(hashResult)
            {
                rs = call.getResultSet();
                while (rs.next())
                {
                    System.out.println(rs.getString(1));
                    System.out.println(rs.getString(2));
                }
            }else
            {
                if (call.getUpdateCount() == -1)
                {
                    break;
                }
            }
            hashResult = call.getMoreResults();
        }
    }
}
