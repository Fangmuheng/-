package com.test;

import java.sql.*;

import com.bao.UserInterface;
import com.classone.DBUtil;
import com.pojo.User;
import com.Impl.*;

public class Test1 {
	public static void main(String[] args) throws Exception{
		//��ȡ���ݿ�����Ȩ��
		Connection conn = DBUtil.getConnetion();
		//System.out.println(conn);
		//Ԥ����
		String sql = "select * from users";
		PreparedStatement ps  = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();//��ѯ
		/*while(rs.next()){
			System.out.println("�û���:"+rs.getString("username")+"����:"+rs.getInt("age"));
		}
		UserInterface u = new UserImpl();
		System.out.println(u.selectUserAll());*/
		UserInterface u = new UserImpl();
		/*System.out.println(u.selectUserById(2));*/
		/*User user = new User();
		user.setId(6);
		user.setAge(19);
		user.setPassword("489342182");
		user.setUsername("Fangmuheng");
		u.addUser(user);*/
		u.deleteUser(9);
		}
	}
