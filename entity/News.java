package com.hwua.entity;

public class News {
	private long hn_id;
	private String hn_title;
	private String hn_content;
	private String hn_create_time;
	public News() {
		super();
	}
	public News(String hn_title, String hn_content, String hn_create_time) {
		super();
		this.hn_title = hn_title;
		this.hn_content = hn_content;
		this.hn_create_time = hn_create_time;
	}
	public News(long hn_id, String hn_title, String hn_content, String hn_create_time) {
		super();
		this.hn_id = hn_id;
		this.hn_title = hn_title;
		this.hn_content = hn_content;
		this.hn_create_time = hn_create_time;
	}
	public long getHn_id() {
		return hn_id;
	}
	public void setHn_id(long hn_id) {
		this.hn_id = hn_id;
	}
	public String getHn_title() {
		return hn_title;
	}
	public void setHn_title(String hn_title) {
		this.hn_title = hn_title;
	}
	public String getHn_content() {
		return hn_content;
	}
	public void setHn_content(String hn_content) {
		this.hn_content = hn_content;
	}
	public String getHn_create_time() {
		return hn_create_time;
	}
	public void setHn_create_time(String hn_create_time) {
		this.hn_create_time = hn_create_time;
	}
	@Override
	public String toString() {
		return "News [hn_id=" + hn_id + ", hn_title=" + hn_title + ", hn_content=" + hn_content + ", hn_create_time="
				+ hn_create_time + "]";
	}
	
}
