package com.bao;

import java.util.List;

import com.pojo.User;

public interface UserInterface {
	//��ѯ��������
	//���ص��Ǻܶ��user���list����
	//list�в��ܷ������ַ��������͵����ݣ����԰����ݷ���User���Ȼ���ٰ���Щ�����list�����
	public List<User> selectUserAll();
	//��id����
	public User selectUserById(Integer id);
	//����һ������
	public void addUser(User u);
	
	public void deleteUser(Integer id);
	
	public void updateUser(User u);
	
	//��¼
	public boolean loginSelect(User u);
	
	public List<User> selectUserByPart(User u);
	
}
