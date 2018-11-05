package com.foxconn.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.foxconn.demo.bean.User;

@Service
public interface UserService {
	
	public void saveUser(User user);
	
	public void deleteUser(String username);
	
	public void updateUser(User user);
	
	public User getUser(String username);
	
	public List<User> getAllUsers();
	
	public void deleteUserBatch(List<User> list);
}
