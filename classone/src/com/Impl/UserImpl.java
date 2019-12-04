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
			//获取数据库连接权限
			Connection conn = DBUtil.getConnetion();
			//System.out.println(conn);
			//预编译
			String sql = "select * from users";
			PreparedStatement ps  = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();//查询
			
			while(rs.next()){
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setId(rs.getInt("id"));
				user.setAge(rs.getInt("age"));
				list.add(user);
			}
			/*while(rs.next()){
				System.out.println("用户名:"+rs.getString("username")+"年龄:"+rs.getInt("age"));
			}*/
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public User selectUserById(Integer id) {
		
		try {
			Connection conn = DBUtil.getConnetion();
			//预编译，？中不一定是什么。写了问号一定要赋值。
			String sql = "select * from users where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			//在？中放东西,第一个数字指的是给第1个问号赋值，第二个指赋的值。
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			//ps.executeUpdate(); 增删改查
			User user = new User();
			if(rs.next()){
				//把数据库中找到的数据放到user类中的username中
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
			
				
			ResultSet rs = ps.executeQuery();//查询
			
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
