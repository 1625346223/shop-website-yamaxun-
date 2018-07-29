package com.hwua.entity;

public class Order {
	private long ho_id;
	private long ho_user_id;
	private String  ho_user_name;
	private String  ho_user_address;
	private String  ho_create_time;
	private double ho_cost ;
	private int ho_status;
	private int ho_type;
	public Order() {
		super();
	}
	public Order(long ho_user_id, String ho_user_name, String ho_user_address, String ho_create_time, double ho_cost,
			int ho_status, int ho_type) {
		super();
		this.ho_user_id = ho_user_id;
		this.ho_user_name = ho_user_name;
		this.ho_user_address = ho_user_address;
		this.ho_create_time = ho_create_time;
		this.ho_cost = ho_cost;
		this.ho_status = ho_status;
		this.ho_type = ho_type;
	}
	public Order(long ho_id, long ho_user_id, String ho_user_name, String ho_user_address, String ho_create_time,
			double ho_cost, int ho_status, int ho_type) {
		super();
		this.ho_id = ho_id;
		this.ho_user_id = ho_user_id;
		this.ho_user_name = ho_user_name;
		this.ho_user_address = ho_user_address;
		this.ho_create_time = ho_create_time;
		this.ho_cost = ho_cost;
		this.ho_status = ho_status;
		this.ho_type = ho_type;
	}
	public long getHo_id() {
		return ho_id;
	}
	public void setHo_id(long ho_id) {
		this.ho_id = ho_id;
	}
	public long getHo_user_id() {
		return ho_user_id;
	}
	public void setHo_user_id(long ho_user_id) {
		this.ho_user_id = ho_user_id;
	}
	public String getHo_user_name() {
		return ho_user_name;
	}
	public void setHo_user_name(String ho_user_name) {
		this.ho_user_name = ho_user_name;
	}
	public String getHo_user_address() {
		return ho_user_address;
	}
	public void setHo_user_address(String ho_user_address) {
		this.ho_user_address = ho_user_address;
	}
	public String getHo_create_time() {
		return ho_create_time;
	}
	public void setHo_create_time(String ho_create_time) {
		this.ho_create_time = ho_create_time;
	}
	public double getHo_cost() {
		return ho_cost;
	}
	public void setHo_cost(double ho_cost) {
		this.ho_cost = ho_cost;
	}
	public int getHo_status() {
		return ho_status;
	}
	public void setHo_status(int ho_status) {
		this.ho_status = ho_status;
	}
	public int getHo_type() {
		return ho_type;
	}
	public void setHo_type(int ho_type) {
		this.ho_type = ho_type;
	}
	@Override
	public String toString() {
		return "Order [ho_id=" + ho_id + ", ho_user_id=" + ho_user_id + ", ho_user_name=" + ho_user_name
				+ ", ho_user_address=" + ho_user_address + ", ho_create_time=" + ho_create_time + ", ho_cost=" + ho_cost
				+ ", ho_status=" + ho_status + ", ho_type=" + ho_type + "]";
	}
	
	
}
