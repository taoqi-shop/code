package com.taoqi.base.domain;

import java.io.Serializable;

/**
 * @作者：刘时明
 * @时间：2019/4/4-13:58
 * @作用：用户实体
 */
public class User implements Serializable
{
    private Long id;
    private String nickName;
    private String userName;
    private String passWord;
    // 密码盐
    private String salt;
    private String imgSrc;
    private Integer stat;
    private String phone;
    private String address;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassWord()
    {
        return passWord;
    }

    public void setPassWord(String passWord)
    {
        this.passWord = passWord;
    }

    public String getSalt()
    {
        return salt;
    }

    public void setSalt(String salt)
    {
        this.salt = salt;
    }

    public String getImgSrc()
    {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc)
    {
        this.imgSrc = imgSrc;
    }

    public Integer getStat()
    {
        return stat;
    }

    public void setStat(Integer stat)
    {
        this.stat = stat;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", salt='" + salt + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", stat=" + stat +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
