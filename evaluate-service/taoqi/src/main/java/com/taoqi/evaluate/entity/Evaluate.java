package com.taoqi.evaluate.entity;

public class Evaluate {

	// 评论编号
	private long id;

	// 用户编号
	private long user_id;

	// 订单编号
	private long order_id;

	// 回复编号
	private long reply_id;

	// 评分星星
	private long star;

	// 评论/回复内容
	private String info;

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
	 * @return the order_id
	 */
	public long getOrder_id() {
		return order_id;
	}

	/**
	 * @param order_id the order_id to set
	 */
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	/**
	 * @return the reply_id
	 */
	public long getReply_id() {
		return reply_id;
	}

	/**
	 * @param reply_id the reply_id to set
	 */
	public void setReply_id(long reply_id) {
		this.reply_id = reply_id;
	}

	/**
	 * @return the star
	 */
	public long getStar() {
		return star;
	}

	/**
	 * @param star the star to set
	 */
	public void setStar(long star) {
		this.star = star;
	}

	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Evaluate [id=" + id + ", user_id=" + user_id + ", order_id=" + order_id + ", reply_id=" + reply_id
				+ ", star=" + star + ", info=" + info + "]";
	}

	
}
