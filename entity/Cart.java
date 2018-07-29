package com.hwua.entity;

public class Cart {
	private long id;
	private long pid;
	private int quantity;
	private long userid;
	public Cart() {
		super();
	}
	
	public Cart(long pid, long userid) {
		super();
		this.pid = pid;
		this.userid = userid;
	}

	public Cart(long pid, int quantity, long userid) {
		super();
		this.pid = pid;
		this.quantity = quantity;
		this.userid = userid;
	}

	public Cart(long id, long pid, int quantity, long userid) {
		super();
		this.id = id;
		this.pid = pid;
		this.quantity = quantity;
		this.userid = userid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "BuyCart [id=" + id + ", pid=" + pid + ", quantity=" + quantity + ", userid=" + userid + "]";
	}
	
	
	
}
