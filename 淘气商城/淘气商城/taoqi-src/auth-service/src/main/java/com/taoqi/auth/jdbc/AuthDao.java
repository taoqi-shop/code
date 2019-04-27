package com.taoqi.auth.jdbc;

import com.taoqi.base.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @作者：刘时明
 * @时间：2019/4/9-9:36
 * @作用：
 */
@Component
public class AuthDao
{
    @Autowired
    private SqlSessionFactory factory;

    public User login(String name,String pass)
    {
        Map<String,Object> map=new HashMap<>();
        try(SqlSession sqlSession= factory.openSession();
            Connection connection=sqlSession.getConnection();
            CallableStatement cs = connection.prepareCall("{call login(?,?)}"))
        {
           cs.setString(1,name);
           cs.setString(2,pass);
           boolean hashResult= cs.execute();
           String[] arr={"code","user"};
           int index=0;
           while (true)
           {
               //判断本次循环是否为数据集
               if (hashResult)
               {
                   ResultSet rs = cs.getResultSet();
                   while (rs.next())
                   {
                       switch (index)
                       {
                           case 0:
                               index++;
                           break;
                           case 1:
                               map.put(arr[index-1],rs.getString(1));
                               index++;
                               break;
                           case 2:
                               if(map.get("code").toString().equals("1"))
                               {
                                   User user=new User();
                                   user.setId(rs.getLong(1));
                                   user.setNickName(rs.getString(2));
                                   user.setUserName(rs.getString(3));
                                   user.setPassWord(rs.getString(4));
                                   user.setImgSrc(rs.getString(5));
                                   user.setSalt(rs.getString(6));
                                   user.setPhone(rs.getString(7));
                                   user.setAddress(rs.getString(8));
                                   user.setStat(rs.getInt(9));
                                   map.put(arr[index-1],user);
                                   return user;
                               }else
                               {
                                   return null;
                               }
                           default:
                               break;
                       }
                   }
                   rs.close();
               } else {
                   if (cs.getUpdateCount() == -1)
                   {
                       break;
                   }
               }
               hashResult = cs.getMoreResults();
           }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public void getType(int id)
    {
        List<String> list=new ArrayList<>();
        try(SqlSession sqlSession= factory.openSession();
            Connection connection=sqlSession.getConnection();
            CallableStatement call=connection.prepareCall("call getType(?)"))
        {
            call.setInt(1,id);
            boolean hashResult= call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next())
            {
                System.out.println(rs.getString(1));
            }
            while (true)
            {
                if(hashResult)
                {
                    rs = call.getResultSet();
                    while (rs.next())
                    {
                        list.add(rs.getString(2));
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

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("list="+list);
    }
}
