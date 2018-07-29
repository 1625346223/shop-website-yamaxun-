package com.hwua.entity;

public class NewOrderListHead {
	private String ho_create_time;
	private long ho_id;
	private double ho_cost ;
	public NewOrderListHead() {
		super();
	}
	public NewOrderListHead(String ho_create_time, long ho_id, double ho_cost) {
		super();
		this.ho_create_time = ho_create_time;
		this.ho_id = ho_id;
		this.ho_cost = ho_cost;
	}
	public String getHo_create_time() {
		return ho_create_time;
	}
	public void setHo_create_time(String ho_create_time) {
		this.ho_create_time = ho_create_time;
	}
	public long getHo_id() {
		return ho_id;
	}
	public void setHo_id(long ho_id) {
		this.ho_id = ho_id;
	}
	public double getHo_cost() {
		return ho_cost;
	}
	public void setHo_cost(double ho_cost) {
		this.ho_cost = ho_cost;
	}
	@Override
	public String toString() {
		return "NewOderlistHead [ho_create_time=" + ho_create_time + ", ho_id=" + ho_id + ", ho_cost=" + ho_cost + "]";
	}
	
	
}
