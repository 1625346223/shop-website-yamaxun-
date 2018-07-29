package com.hwua.entity;

public class Product {
	private String hp_id;
	private String hp_name;
	private String hp_description;
	private String hp_price;
	private String hp_stock;
	private String hpc_id;
	private String hpc_child_id;
	private String hp_file_name;
	
	public Product() {
		super();
	}

	public Product(String hp_name, String hp_description, String hp_price, String hp_stock, String hpc_id,
			String hpc_child_id, String hp_file_name) {
		super();
		this.hp_name = hp_name;
		this.hp_description = hp_description;
		this.hp_price = hp_price;
		this.hp_stock = hp_stock;
		this.hpc_id = hpc_id;
		this.hpc_child_id = hpc_child_id;
		this.hp_file_name = hp_file_name;
	}

	
	public Product(String hp_id, String hp_name, String hp_description, String hp_price, String hp_stock,
			String hpc_id, String hpc_child_id, String hp_file_name) {
		super();
		this.hp_id = hp_id;
		this.hp_name = hp_name;
		this.hp_description = hp_description;
		this.hp_price = hp_price;
		this.hp_stock = hp_stock;
		this.hpc_id = hpc_id;
		this.hpc_child_id = hpc_child_id;
		this.hp_file_name = hp_file_name;
	}

	public String getHp_id() {
		return hp_id;
	}

	public void setHp_id(String hp_id) {
		this.hp_id = hp_id;
	}

	public String getHp_name() {
		return hp_name;
	}

	public void setHp_name(String hp_name) {
		this.hp_name = hp_name;
	}

	public String getHp_description() {
		return hp_description;
	}

	public void setHp_description(String hp_description) {
		this.hp_description = hp_description;
	}

	public String getHp_price() {
		return hp_price;
	}

	public void setHp_price(String hp_price) {
		this.hp_price = hp_price;
	}

	public String getHp_stock() {
		return hp_stock;
	}

	public void setHp_stock(String hp_stock) {
		this.hp_stock = hp_stock;
	}

	public String getHpc_id() {
		return hpc_id;
	}

	public void setHpc_id(String hpc_id) {
		this.hpc_id = hpc_id;
	}

	public String getHpc_child_id() {
		return hpc_child_id;
	}

	public void setHpc_child_id(String hpc_child_id) {
		this.hpc_child_id = hpc_child_id;
	}

	public String getHp_file_name() {
		return hp_file_name;
	}

	public void setHp_file_name(String hp_file_name) {
		this.hp_file_name = hp_file_name;
	}

	@Override
	public String toString() {
		return "Product [hp_id=" + hp_id + ", hp_name=" + hp_name + ", hp_description=" + hp_description + ", hp_price="
				+ hp_price + ", hp_STOCKstock=" + hp_stock + ", hpc_id=" + hpc_id + ", hpc_child_id="
				+ hpc_child_id + ", hp_file_name=" + hp_file_name + "]";
	}

	
}
