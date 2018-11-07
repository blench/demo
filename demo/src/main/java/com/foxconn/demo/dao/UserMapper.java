package com.foxconn.demo.dao;

import java.util.List;
import java.util.concurrent.Delayed;

import org.apache.ibatis.annotations.Param;

import com.foxconn.demo.bean.User;

/**
 * 操作用户的接口
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
	
	public boolean userLogin(User user);
	
	public List<User> queryUserByLimit(@Param("startPage")int startPage, @Param("endPage")int endPage);
}
