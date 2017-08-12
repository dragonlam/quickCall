package com.quickcall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.quickcall.model.Staff;

public class StaffDao {
	
	/**
	 * 登陆验证֤
	 * @param con
	 * @param staff
	 * @return
	 * @throws Exception
	 */
	public Staff login(Connection con,Staff staff) throws Exception{
		Staff resultUser=null;
		String sql="select * from t_staff where staffName=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, staff.getStaffName());
		pstmt.setString(2, staff.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			resultUser=new Staff();
			resultUser.setId(Integer.parseInt(rs.getString("Id")));
			resultUser.setStaffName(rs.getString("staffName"));
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;
	}

}
