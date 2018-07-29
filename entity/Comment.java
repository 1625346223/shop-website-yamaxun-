package com.hwua.entity;

public class Comment {
	private long hc_id;
	private String hc_reply;
	private String hc_content;
	private String hc_create_time;
	private String hc_reply_time;
	private String hc_nick_name;
	private String hc_state;
	public Comment() {
		super();
	}
	
	public Comment(String hc_content, String hc_create_time, String hc_nick_name, String hc_state) {
		super();
		this.hc_content = hc_content;
		this.hc_create_time = hc_create_time;
		this.hc_nick_name = hc_nick_name;
		this.hc_state = hc_state;
	}

	

	public Comment(String hc_reply, String hc_content, String hc_create_time, String hc_reply_time, String hc_nick_name,
			String hc_state) {
		super();
		this.hc_reply = hc_reply;
		this.hc_content = hc_content;
		this.hc_create_time = hc_create_time;
		this.hc_reply_time = hc_reply_time;
		this.hc_nick_name = hc_nick_name;
		this.hc_state = hc_state;
	}
	public Comment(long hc_id, String hc_reply, String hc_content, String hc_create_time, String hc_reply_time,
			String hc_nick_name, String hc_state) {
		super();
		this.hc_id = hc_id;
		this.hc_reply = hc_reply;
		this.hc_content = hc_content;
		this.hc_create_time = hc_create_time;
		this.hc_reply_time = hc_reply_time;
		this.hc_nick_name = hc_nick_name;
		this.hc_state = hc_state;
	}
	public long getHc_id() {
		return hc_id;
	}
	public void setHc_id(long hc_id) {
		this.hc_id = hc_id;
	}
	public String getHc_reply() {
		return hc_reply;
	}
	public void setHc_reply(String hc_reply) {
		this.hc_reply = hc_reply;
	}
	public String getHc_content() {
		return hc_content;
	}
	public void setHc_content(String hc_content) {
		this.hc_content = hc_content;
	}
	public String getHc_create_time() {
		return hc_create_time;
	}
	public void setHc_create_time(String hc_create_time) {
		this.hc_create_time = hc_create_time;
	}
	public String getHc_reply_time() {
		return hc_reply_time;
	}
	public void setHc_reply_time(String hc_reply_time) {
		this.hc_reply_time = hc_reply_time;
	}
	public String getHc_nick_name() {
		return hc_nick_name;
	}
	public void setHc_nick_name(String hc_nick_name) {
		this.hc_nick_name = hc_nick_name;
	}
	public String getHc_state() {
		return hc_state;
	}
	public void setHc_state(String hc_state) {
		this.hc_state = hc_state;
	}
	@Override
	public String toString() {
		return "Comment [hc_id=" + hc_id + ", hc_reply=" + hc_reply + ", hc_content=" + hc_content + ", hc_create_time="
				+ hc_create_time + ", hc_reply_time=" + hc_reply_time + ", hc_nick_name=" + hc_nick_name + ", hc_state="
				+ hc_state + "]";
	}
	
	
}
