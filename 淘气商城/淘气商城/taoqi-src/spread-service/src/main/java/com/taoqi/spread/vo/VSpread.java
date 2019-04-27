/**
 * 
 */
package com.taoqi.spread.vo;

/**
 *@author coco 
 *@date 2019年4月15日  
 *
 */
public class VSpread{
	private int id;
	private int userId;
	private String userName;
	private String name;
	private String info;
	private String imgsrc;
	private float price;
	public VSpread() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getImgsrc() {
		return imgsrc;
	}
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "VSpread [id=" + id + ", userId=" + userId + ", userName=" + userName + ", name=" + name + ", info="
				+ info + ", imgsrc=" + imgsrc + ", price=" + price + "]";
	}
	
	
	
	
	

}
