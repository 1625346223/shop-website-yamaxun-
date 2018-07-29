package com.hwua.entity;

public class OrderDetail {
	private long hod_id;
	private long ho_id;
	private long hp_id;
	private int hod_quantity;
	private double hod_cost;
	public OrderDetail() {
		super();
	}
	public OrderDetail(long ho_id, long hp_id, int hod_quantity, double hod_cost) {
		super();
		this.ho_id = ho_id;
		this.hp_id = hp_id;
		this.hod_quantity = hod_quantity;
		this.hod_cost = hod_cost;
	}
	public OrderDetail(long hod_id, long ho_id, long hp_id, int hod_quantity, double hod_cost) {
		super();
		this.hod_id = hod_id;
		this.ho_id = ho_id;
		this.hp_id = hp_id;
		this.hod_quantity = hod_quantity;
		this.hod_cost = hod_cost;
	}
	public long getHod_id() {
		return hod_id;
	}
	public void setHod_id(long hod_id) {
		this.hod_id = hod_id;
	}
	public long getHo_id() {
		return ho_id;
	}
	public void setHo_id(long ho_id) {
		this.ho_id = ho_id;
	}
	public long getHp_id() {
		return hp_id;
	}
	public void setHp_id(long hp_id) {
		this.hp_id = hp_id;
	}
	public int getHod_quantity() {
		return hod_quantity;
	}
	public void setHod_quantity(int hod_quantity) {
		this.hod_quantity = hod_quantity;
	}
	public double getHod_cost() {
		return hod_cost;
	}
	public void setHod_cost(double hod_cost) {
		this.hod_cost = hod_cost;
	}
	@Override
	public String toString() {
		return "OrderDetail [hod_id=" + hod_id + ", ho_id=" + ho_id + ", hp_id=" + hp_id + ", hod_quantity="
				+ hod_quantity + ", hod_cost=" + hod_cost + "]";
	}
	
}
