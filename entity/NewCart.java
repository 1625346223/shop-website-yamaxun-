package com.hwua.entity;

public class NewCart {
	private long hp_id;
	private String hp_name;
	private int hp_stock;
	private String hp_file_name;
	private double hp_price;
	private int quantity;
	public NewCart() {
		super();
	}
	public NewCart(long hp_id, String hp_name, int hp_stock, String hp_file_name, double hp_price, int quantity) {
		super();
		this.hp_id = hp_id;
		this.hp_name = hp_name;
		this.hp_stock = hp_stock;
		this.hp_file_name = hp_file_name;
		this.hp_price = hp_price;
		this.quantity = quantity;
	}
	public long getHp_id() {
		return hp_id;
	}
	public void setHp_id(long hp_id) {
		this.hp_id = hp_id;
	}
	public String getHp_name() {
		return hp_name;
	}
	public void setHp_name(String hp_name) {
		this.hp_name = hp_name;
	}
	public int getHp_stock() {
		return hp_stock;
	}
	public void setHp_stock(int hp_stock) {
		this.hp_stock = hp_stock;
	}
	public String getHp_file_name() {
		return hp_file_name;
	}
	public void setHp_file_name(String hp_file_name) {
		this.hp_file_name = hp_file_name;
	}
	public double getHp_price() {
		return hp_price;
	}
	public void setHp_price(double hp_price) {
		this.hp_price = hp_price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "NewCart [hp_id=" + hp_id + ", hp_name=" + hp_name + ", hp_stock=" + hp_stock + ", hp_file_name="
				+ hp_file_name + ", hp_price=" + hp_price + ", quantity=" + quantity + "]";
	}
	
	
}
