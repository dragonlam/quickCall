package com.quickcall.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.quickcall.dao.StaffDao;
import com.quickcall.model.Staff;
import com.quickcall.util.DbUtil;
import com.quickcall.util.StringUtil;

public class LoginAction extends ActionSupport implements ServletRequestAware{
	
	private Staff staff;
	private String error;
	
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	


	DbUtil dbUtil=new DbUtil();
	StaffDao staffDao=new StaffDao();
	HttpServletRequest request;
	
	
	@Override
	public String execute() throws Exception {
		// Session
		HttpSession session=request.getSession();
		if(StringUtil.isEmpty(staff.getStaffName())||StringUtil.isEmpty(staff.getPassword())){
			error="用户名或密码为空";
			return ERROR;
		}
		
		Connection con=null;
		try {
			con=dbUtil.getCon();
			Staff currentStaff=staffDao.login(con, staff);
			if(currentStaff==null){
				error="用户名或密码错误";
				return ERROR;
			}else{
				session.setAttribute("currentStaff", currentStaff);
				return "userinfo";
				
				
		
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ERROR;
	}
	
	public String logout() throws Exception {
		//session
		HttpSession session=request.getSession();
		session.removeAttribute("currentUser");
		return "logout";
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
}