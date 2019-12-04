package com.classone;

import java.sql.Connection;
import java.sql.DriverManager;

//封装连接数据库
public class DBUtil {
	/*
	 * JDBC数据库
	 * 1.导包
	 * 2.创建元素 URL USERNAME PASSWORD DRIVER 驱动
	 * 3.加载驱动
	 */
	private static final String URL="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
	private static final String USERNAME="root";
	private static final String PASSWORD="489342182";
	private static final String DRIVER="com.mysql.jdbc.Driver";
	
	//连接数据库需要的接口
	private static Connection conn;
	static{
		//加载驱动
		try {
			Class.forName(DRIVER);
			//获取连接权限
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (Exception e) {//Exception是所有异常的父类
			//try中有可能会出现异常，catch用来捕捉，捕捉的类型就是Exception。
			e.printStackTrace();
		}
	}
	public static Connection getConnetion(){
		//获得连接数据库的权限
		return conn;
	}
}
