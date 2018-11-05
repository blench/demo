package com.foxconn.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foxconn.demo.bean.User;
import com.foxconn.demo.dao.UserMapper;
import com.foxconn.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userMapper.insertUser(user);
	}

	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		userMapper.deleteUser(username);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userMapper.updateUser(user);
	}

	public User getUser(String username) {
		// TODO Auto-generated method stub
		return userMapper.queryUserByUsername(username);
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userMapper.queryAllUsers();
	}

	public void deleteUserBatch(List<User> list) {
		// TODO Auto-generated method stub
		userMapper.deleteUserBatch(list);
	}

}
