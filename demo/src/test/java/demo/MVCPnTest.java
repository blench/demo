package demo;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.foxconn.demo.bean.PageInfo;
import com.foxconn.demo.bean.User;

@RunWith(value=SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
public class MVCPnTest {
	
	@Autowired
	WebApplicationContext context;
	
	MockMvc mockMvc;
	
	@Before
	public void init()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception
	{
		//模拟请求拿到返回值
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users").param("pn", "1")).andReturn();
		
		//请求域中会有pageInfo的数据
		MockHttpServletRequest request = result.getRequest();
		PageInfo pi = (PageInfo) request.getAttribute("pageInfo");
		System.out.println(pi==null);
		/*
		System.out.println("总记录数：" + pi.getTotalRecords());
		System.out.println("总页码数：" + pi.getTotalPage());
		System.out.println("当前页码数：" + pi.getCurrentPageNum());
		int[] num = pi.getNavNum();
		for(int i : num)
		{
			System.out.println(i + " ");
		}
		List<User> record = pi.getRecord();
		for(User user : record)
		{
			System.out.println(user);
		}*/
	}
}
