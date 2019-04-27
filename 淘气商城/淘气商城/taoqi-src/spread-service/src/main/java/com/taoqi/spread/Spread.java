/**
 * 
 */
package com.taoqi.spread;

/**
 *@author coco 
 *@date 2019年4月8日  
 *
 */
public class Spread {
	
	private int id;
	private int userid;
	private String info;
	private String imgsrc;
	private float price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public Spread(int id, int userid, String info, String imgsrc, float price) {
		super();
		this.id = id;
		this.userid = userid;
		this.info = info;
		this.imgsrc = imgsrc;
		this.price = price;
	}
	public Spread() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Spread(int userid, String info, String imgsrc, float price) {
		super();
		this.userid = userid;
		this.info = info;
		this.imgsrc = imgsrc;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Spread [id=" + id + ", userid=" + userid + ", info=" + info + ", imgsrc=" + imgsrc + ", price=" + price
				+ "]";
	}
	
	

}
