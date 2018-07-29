package com.hwua.entity;

public class NewOrderListBody {
	private long hp_id;
	private String hp_file_name;
	private String hp_name;
	private double hp_price;
	private int hod_quantity;
	private long ho_id;
	public NewOrderListBody() {
		super();
	}
	
	public NewOrderListBody(long hp_id, String hp_file_name, String hp_name, double hp_price, int hod_quantity,
			long ho_id) {
		super();
		this.hp_id = hp_id;
		this.hp_file_name = hp_file_name;
		this.hp_name = hp_name;
		this.hp_price = hp_price;
		this.hod_quantity = hod_quantity;
		this.ho_id = ho_id;
	}

	public long getHp_id() {
		return hp_id;
	}
	public void setHp_id(long hp_id) {
		this.hp_id = hp_id;
	}
	public String getHp_file_name() {
		return hp_file_name;
	}
	public void setHp_file_name(String hp_file_name) {
		this.hp_file_name = hp_file_name;
	}
	public String getHp_name() {
		return hp_name;
	}
	public void setHp_name(String hp_name) {
		this.hp_name = hp_name;
	}
	public double getHp_price() {
		return hp_price;
	}
	public void setHp_price(double hp_price) {
		this.hp_price = hp_price;
	}
	public int getHod_quantity() {
		return hod_quantity;
	}
	public void setHod_quantity(int hod_quantity) {
		this.hod_quantity = hod_quantity;
	}
	
	public long getHo_id() {
		return ho_id;
	}

	public void setHo_id(long ho_id) {
		this.ho_id = ho_id;
	}

	@Override
	public String toString() {
		return "NewOrderlistBody [hp_id=" + hp_id + ", hp_file_name=" + hp_file_name + ", hp_name=" + hp_name
				+ ", hp_price=" + hp_price + ", hod_quantity=" + hod_quantity + ", ho_id=" + ho_id + "]";
	}

	
}
