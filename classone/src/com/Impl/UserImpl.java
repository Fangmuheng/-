package com.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bao.UserInterface;
import com.classone.DBUtil;
import com.pojo.User;

public class UserImpl implements UserInterface{
	public List<User> list = new ArrayList<User>();

	public List<User> selectUserAll() {
		try{
			//��ȡ���ݿ�����Ȩ��
			Connection conn = DBUtil.getConnetion();
			//System.out.println(conn);
			//Ԥ����
			String sql = "select * from users";
			PreparedStatement ps  = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();//��ѯ
			
			while(rs.next()){
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setId(rs.getInt("id"));
				user.setAge(rs.getInt("age"));
				list.add(user);
			}
			/*while(rs.next()){
				System.out.println("�û���:"+rs.getString("username")+"����:"+rs.getInt("age"));
			}*/
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public User selectUserById(Integer id) {
		
		try {
			Connection conn = DBUtil.getConnetion();
			//Ԥ���룬���в�һ����ʲô��д���ʺ�һ��Ҫ��ֵ��
			String sql = "select * from users where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			//�ڣ��зŶ���,��һ������ָ���Ǹ���1���ʺŸ�ֵ���ڶ���ָ����ֵ��
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			//ps.executeUpdate(); ��ɾ�Ĳ�
			User user = new User();
			if(rs.next()){
				//�����ݿ����ҵ������ݷŵ�user���е�username��
				user.setUsername(rs.getString("username"));
				user.setAge(rs.getInt("age"));
				user.setPassword(rs.getString("password"));
				user.setId(rs.getInt("id"));
			}
			
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void addUser(User u) {
		
		try {
			Connection conn = DBUtil.getConnetion();
			String sql = "insert into users (username,password,age) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(3, u.getAge());
			ps.setString(1, u.getUsername());
			ps.setString(2,u.getPassword());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(Integer id) {
		
		try {
			Connection conn = DBUtil.getConnetion();
			String sql = "delete from users where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateUser(User u) {
		
		try {
			Connection conn = DBUtil.getConnetion();
			String sql = "update users set username=?,password=?,age=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setInt(3, u.getAge());
			ps.setInt(4, u.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean loginSelect(User u) {
		
		try {
			Connection conn = DBUtil.getConnetion();
			String sql = "select * from users where username=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<User> selectUserByPart(User u) {
		
		try {
			Connection conn = DBUtil.getConnetion();
			String sql;
			PreparedStatement ps;
			

			if(u.getAge()==null){
				sql = "select * from users where username like ? ";
				ps  = conn.prepareStatement(sql);
				ps.setString(1, "%"+u.getUsername()+"%");
			}else if(u.getUsername()==null){
				sql = "select * from users where age=?";
				ps  = conn.prepareStatement(sql);
				ps.setInt(1,u.getAge());
			}else{
				sql = "select * from users where age=? and username like ?";
				ps  = conn.prepareStatement(sql);
				ps.setInt(1,u.getAge());
				ps.setString(2, "%"+u.getUsername()+"%");
			}
			
				
			ResultSet rs = ps.executeQuery();//��ѯ
			
			while(rs.next()){
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setId(rs.getInt("id"));
				user.setAge(rs.getInt("age"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
