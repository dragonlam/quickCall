package com.quickcall.model;

public class User {

	private int id;
	private String name;
	private String phone;
	private String plan;
	private String note;
	
	public User() {
	}
	
	public User(String name, String phone, String plan, String note) {
		this.name = name;
		this.phone = phone;
		this.plan = plan;
		this.note = note;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
