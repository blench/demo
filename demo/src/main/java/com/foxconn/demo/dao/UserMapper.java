package com.foxconn.demo.dao;

import java.util.List;
import java.util.concurrent.Delayed;

import com.foxconn.demo.bean.User;

/**
 * �����û��Ľӿ�
 * @author yk
 *
 */
public interface UserMapper {
	
	public int insertUser(User user);
	
	public int deleteUser(String username);
	
	public int updateUser(User user);
	
	public List<User> queryAllUsers();
	
	public User queryUserByUsername(String username);
	
	public long countUsers();

	public int deleteUserBatch(List<User> list);
	
}
