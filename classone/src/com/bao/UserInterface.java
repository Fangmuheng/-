package com.bao;

import java.util.List;

import com.pojo.User;

public interface UserInterface {
	//查询所有数据
	//返回的是很多个user类的list集合
	//list中不能放又有字符又有整型的数据，所以把数据放在User类里，然后再把这些类放在list集合里。
	public List<User> selectUserAll();
	//按id查找
	public User selectUserById(Integer id);
	//增加一条数据
	public void addUser(User u);
	
	public void deleteUser(Integer id);
	
	public void updateUser(User u);
	
	//登录
	public boolean loginSelect(User u);
	
	public List<User> selectUserByPart(User u);
	
}
