package com.classone;

import java.sql.Connection;
import java.sql.DriverManager;

//��װ�������ݿ�
public class DBUtil {
	/*
	 * JDBC���ݿ�
	 * 1.����
	 * 2.����Ԫ�� URL USERNAME PASSWORD DRIVER ����
	 * 3.��������
	 */
	private static final String URL="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
	private static final String USERNAME="root";
	private static final String PASSWORD="489342182";
	private static final String DRIVER="com.mysql.jdbc.Driver";
	
	//�������ݿ���Ҫ�Ľӿ�
	private static Connection conn;
	static{
		//��������
		try {
			Class.forName(DRIVER);
			//��ȡ����Ȩ��
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (Exception e) {//Exception�������쳣�ĸ���
			//try���п��ܻ�����쳣��catch������׽����׽�����;���Exception��
			e.printStackTrace();
		}
	}
	public static Connection getConnetion(){
		//����������ݿ��Ȩ��
		return conn;
	}
}
