package com.taoqi.evaluate.entity;

public class User {

	// 用户编号
	private long id;

	// 用户昵称
	private String nick_name;

	// 用户名
	private String user_name;

	// 用户密码
	private String pass_word;

	// 用户头像地址
	private String imgSrc;

	// 密码盐
	private String Salt;

	// 电话
	private String phone;

	// 地址
	private String address;

	// 角色
	private long stat;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the nick_name
	 */
	public String getNick_name() {
		return nick_name;
	}

	/**
	 * @param nick_name the nick_name to set
	 */
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * @return the pass_word
	 */
	public String getPass_word() {
		return pass_word;
	}

	/**
	 * @param pass_word the pass_word to set
	 */
	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}

	/**
	 * @return the imgSrc
	 */
	public String getImgSrc() {
		return imgSrc;
	}

	/**
	 * @param imgSrc the imgSrc to set
	 */
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	/**
	 * @return the salt
	 */
	public String getSalt() {
		return Salt;
	}

	/**
	 * @param salt the salt to set
	 */
	public void setSalt(String salt) {
		Salt = salt;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the stat
	 */
	public long getStat() {
		return stat;
	}

	/**
	 * @param stat the stat to set
	 */
	public void setStat(long stat) {
		this.stat = stat;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", nick_name=" + nick_name + ", user_name=" + user_name + ", pass_word=" + pass_word
				+ ", imgSrc=" + imgSrc + ", Salt=" + Salt + ", phone=" + phone + ", address=" + address + ", stat="
				+ stat + "]";
	}

	
}
