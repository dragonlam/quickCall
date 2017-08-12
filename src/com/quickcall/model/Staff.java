package com.quickcall.model;

public class Staff {
	
	private int id;
	private String staffName;
	private String password;
	
	public Staff(String staffName, String password) {
		super();
		this.staffName = staffName;
		this.password = password;
	}

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
