package com.taoqi.evaluate.entity;

import java.sql.Timestamp;

public class Order {

	// 订单编号
	private long id;

	// 用户编号
	private long user_id;

	// 商品编号
	private long product_id;

	// 商品数量
	private Integer count;

	// 总价
	private float sun;

	// 订单是否被删除（1：已删除；0：未删除）
	private Integer del;

	// 订单状态（0：未受理；1：已发货；2：已签收）
    private Integer stat;
  

	// 订单时间
    private Timestamp time;


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
	 * @return the user_id
	 */
	public long getUser_id() {
		return user_id;
	}


	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}


	/**
	 * @return the product_id
	 */
	public long getProduct_id() {
		return product_id;
	}


	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}


	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}


	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}


	/**
	 * @return the sun
	 */
	public float getSun() {
		return sun;
	}


	/**
	 * @param sun the sun to set
	 */
	public void setSun(float sun) {
		this.sun = sun;
	}


	/**
	 * @return the del
	 */
	public Integer getDel() {
		return del;
	}


	/**
	 * @param del the del to set
	 */
	public void setDel(Integer del) {
		this.del = del;
	}


	/**
	 * @return the stat
	 */
	public Integer getStat() {
		return stat;
	}


	/**
	 * @param stat the stat to set
	 */
	public void setStat(Integer stat) {
		this.stat = stat;
	}


	/**
	 * @return the time
	 */
	public Timestamp getTime() {
		return time;
	}


	/**
	 * @param time the time to set
	 */
	public void setTime(Timestamp time) {
		this.time = time;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [id=" + id + ", user_id=" + user_id + ", product_id=" + product_id + ", count=" + count + ", sun="
				+ sun + ", del=" + del + ", stat=" + stat + ", time=" + time + "]";
	}

	
}
