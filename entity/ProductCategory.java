package com.hwua.entity;

public class ProductCategory {
	private long hpc_id;
	private String  hpc_name;
	private long hpc_parent_id;
	public ProductCategory() {
		super();
	}
	public ProductCategory(String hpc_name) {
		super();
		this.hpc_name = hpc_name;
	}
	public ProductCategory(long hpc_id, String hpc_name) {
		super();
		this.hpc_id = hpc_id;
		this.hpc_name = hpc_name;
	}
	public ProductCategory(long hpc_id, String hpc_name, long hpc_parent_id) {
		super();
		this.hpc_id = hpc_id;
		this.hpc_name = hpc_name;
		this.hpc_parent_id = hpc_parent_id;
	}
	public long getHpc_id() {
		return hpc_id;
	}
	public void setHpc_id(long hpc_id) {
		this.hpc_id = hpc_id;
	}
	public String getHpc_name() {
		return hpc_name;
	}
	public void setHpc_name(String hpc_name) {
		this.hpc_name = hpc_name;
	}
	
	public long getHpc_parent_id() {
		return hpc_parent_id;
	}
	public void setHpc_parent_id(long hpc_parent_id) {
		this.hpc_parent_id = hpc_parent_id;
	}
	@Override
	public String toString() {
		return "ProductCategory [hpc_id=" + hpc_id + ", hpc_name=" + hpc_name + ", hpc_parent_id=" + hpc_parent_id
				+ "]";
	}
	
	
}
