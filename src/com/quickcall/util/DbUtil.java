package com.quickcall.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbUtil {

	private String dbUrl=null;
	private String dbUserName=null;
	private String dbPassword=null;
	private String jdbcName=null;
	
	Properties props = new Properties();
	InputStream in = DbUtil.class.getResourceAsStream("/mysql.properties");
	
	 //加载文件
	
	 
	
	public Connection getCon()throws Exception{
		props.load(in);
		 //读取信息
		dbUrl = props.getProperty("dbUrl");
		dbUserName = props.getProperty("dbUserName");
		dbPassword = props.getProperty("dbPassword");
		jdbcName = props.getProperty("jdbcName");
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		return con;
	}
	
	public void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}
	
}
