package com.falconnect.buffetbee.Modalclass;

public class OrderModel {

	private String order_id;
	private String order_name;
	private String order_status;
	private String order_amount;
	private int order_nos;
	public OrderModel(String order_id, String order_name, String order_status, String order_amount, int order_nos) {
		this.order_id = order_id;
		this.order_name = order_name;
		this.order_status = order_status;
		this.order_amount = order_amount;
		this.order_nos = order_nos;
	}
	public OrderModel() {
	}

	public String getorder_id() {
		return order_id;
	}

	public String getorder_name() {
		return order_name;
	}

	public String getorder_status() {
		return order_status;
	}

	public String getorder_amount() {
		return order_amount;
	}

	public int getorder_nos() {
		return order_nos;
	}

	public void setorder_nos(int order_nos) {
		this.order_nos = order_nos;
	}

	public void setorder_status(String order_status) {
		this.order_status = order_status;
	}

}
