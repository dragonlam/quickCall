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
	
	 //�����ļ�
	
	 
	
	public Connection getCon()throws Exception{
		props.load(in);
		 //��ȡ��Ϣ
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
