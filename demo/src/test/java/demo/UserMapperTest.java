package demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.foxconn.demo.bean.User;
import com.foxconn.demo.dao.UserMapper;

/**
 * mybatis mapper½Ó¿Ú²âÊÔ
 * @author yk
 *
 */
@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class UserMapperTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void testInsert()
	{
		User user = new User("zhangsan2", "123456", "ÄÐ", 18, "13978907654");
		int i = userMapper.insertUser(user);
		System.out.println("i"+i);
	}
	
	@Test
	public void testQueryUserByUsername()
	{
		String username = "zhangsan2";
		User user = userMapper.queryUserByUsername(username);
		System.out.println(user.getGender());
	}
	
	@Test
	public void testDeleteUser()
	{
		String username = "zhangsan2";
		int i = userMapper.deleteUser(username);
		System.out.println("i: "+i);
	}
	
	@Test
	public void testupdateUser()
	{
		String username = "zhangsan";
		User user = userMapper.queryUserByUsername(username);
		user.setAge(20);
		user.setGender("Å®");
		user.setTel("11111111111");
		int i = userMapper.updateUser(user);
		System.out.println("i: "+i);
	}
	
	@Test
	public void testQueryAllUsers()
	{
		List<User> list = userMapper.queryAllUsers();
		for(User user : list)
		{
			System.out.println(user);
			
		}
	}
	
	@Test
	public void testCountUsers()
	{
		long count = userMapper.countUsers();
		System.out.println(count);
	}
	
	@Test
	public void testDeleteUserBatch()
	{
		List<User> list = userMapper.queryAllUsers();
		
		userMapper.deleteUserBatch(list);
	}
}
