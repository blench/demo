package demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.foxconn.demo.bean.PageInfo;
import com.foxconn.demo.bean.User;
import com.foxconn.demo.dao.UserMapper;
import com.foxconn.demo.service.UserService;

/**
 * mybatis mapper�ӿڲ���
 * @author yk
 *
 */
@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class UserMapperTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void testInsert()
	{
		User user = new User("zhangsan2", "123456", "男", 18, "13978907654");
		for(int i = 1; i < 1000; i++)
		{
			User usert = new User("zhangsan" + i, "123456", i%2==0?"男":"女", i%2==0?18:20, "15678905678");
			userMapper.insertUser(usert);
		}
//		int i = userMapper.insertUser(user);
//		System.out.println("i"+i);
	}
	
	@Test
	public void testQueryUserByUsername()
	{
		String username = "zhangsan2";
		User user = userService.getUser(username);
		System.out.println(user);
		System.out.println(user.getGender());
	}
	
	@Test
	public void testDeleteUser()
	{
		String username = "zhangsan1";
		int i = userMapper.deleteUser(username);
		System.out.println("i: "+i);
	}
	
	@Test
	public void testupdateUser()
	{
		String username = "zhangsan";
		User user = userMapper.queryUserByUsername(username);
		user.setAge(20);
		user.setGender("Ů");
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
	
	@Test
	public void testQueryUserByLimit()
	{
		List<User> users = userMapper.queryUserByLimit(0, 5);
		for(User user : users)
		{
			System.out.println(user);
		}
		
	}
	
	@Test
	public void testPage()
	{
		long count = userMapper.countUsers();
		PageInfo pageInfo = new PageInfo(2,(int)count);
		/**
		 * 注意这里userMapper查询的实际上是以startIndex每一页的起始下表开始查询
		 * 首页查询currentPage=1
		 * 尾页查询currentPage=totalPage
		 * 上一页startIndex-pageSize
		 * 下一页startIndex+pageSize
		 */
		List<User> users = userMapper.queryUserByLimit(pageInfo.getStartIndex(), pageInfo.getPageSize());
		pageInfo.setRecord(users);
		for(User user : users)
		{
			System.out.println(user);
		}
		System.out.println(pageInfo.getCurrentPageNum()+ " " + pageInfo.getTotalPage() 
		+" "+ pageInfo.getStartIndex() + " " + pageInfo.getEndPage() + " " + pageInfo.getTotalRecords());
		
	}
}
