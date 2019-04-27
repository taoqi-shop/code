package com.taoqi.base.domain;

public class VEvaluate {

	private long id;
	
	private String nick_name;
	
	private long order_id;
	
	private long reply_id;
	
	private int star;

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
	public int getStar() {
		return star;
	}

	/**
	 * @param star the star to set
	 */
	public void setStar(int star) {
		this.star = star;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VEvaluate [id=" + id + ", nick_name=" + nick_name + ", order_id=" + order_id + ", reply_id=" + reply_id
				+ ", star=" + star + "]";
	}


}
