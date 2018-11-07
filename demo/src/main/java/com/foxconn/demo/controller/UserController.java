package com.foxconn.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.IOP.ServiceIdHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foxconn.demo.bean.Msg;
import com.foxconn.demo.bean.PageInfo;
import com.foxconn.demo.bean.User;
import com.foxconn.demo.service.UserService;
import com.foxconn.demo.service.impl.UserServiceImpl;

/**
 * �û��������������û�ע�ᣬ�û���¼���û��б��ѯ
 * @author yk
 *
 */
@Controller
public class UserController {
	
	@Autowired
	private UserService userServiceImpl;
	
	/**
	 * �û�ע��
	 * @param user
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String saveUser(@Validated User user, BindingResult result,HttpServletRequest request)
	{
		System.out.println(user==null);
		if(result.hasErrors())
		{
			HashMap<String, Object> map = new HashMap<String, Object>();
			List<FieldError> fieldErrors = result.getFieldErrors();
			for(FieldError error : fieldErrors)
			{
				System.out.println("����" + error.getField());
				System.out.println(" " + error.getDefaultMessage());
				map.put(error.getField(), error.getDefaultMessage());
			}
			request.setAttribute("msg", "ע��ʧ�ܣ����������");
			return "index";
		}
		else{
			userServiceImpl.saveUser(user);
			request.setAttribute("msg", "ע��ɹ���");
			request.setAttribute("user", user);
			return "login";
		}
	}
	
	/**
	 * ����û����Ƿ��Ѿ�����
	 * @param username
	 * @return
	 */
	@RequestMapping(value="/checkUser",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity checkUser(@RequestParam("username")String username)
	{
		System.out.println("username: "+username);
		Map<String, Object> map = new HashMap<String, Object>();
		User user = userServiceImpl.getUser(username);
		System.out.println(user);
		if(user!=null)
		{
			map.put("code", "100");
		}else{
			map.put("code", "200");
		}
		return new ResponseEntity(map,HttpStatus.OK);
	}
	
	/**
	 * �û���¼
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/userLogin", method=RequestMethod.POST)
	@ResponseBody
	public Msg userLogin(@Validated User user,HttpServletRequest request)
	{ 
		
		if(user!=null && userServiceImpl.userLogin(user))
		{
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return Msg.success().add("user", user);
		}else{
			return Msg.fail();
		}
	}
	
	/**
	 *���ݲ���pn,�õ��Ӹ�ҳ�濪ʼ�ļ�¼��
	 * @return
	 */
	@RequestMapping(value="/users")
	@ResponseBody
	public Msg getUsers(@RequestParam(value="pn", defaultValue="1")int pn)
	{
		long totalRecords = userServiceImpl.countUsers();
		System.out.println(totalRecords);
		PageInfo pageInfo = new PageInfo(pn,(int)totalRecords);
		List<User> users = userServiceImpl.queryUserPage(pageInfo.getStartIndex(), pageInfo.getPageSize());
		pageInfo.setRecord(users);
		System.out.println(pageInfo.getStartPage());
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	@RequestMapping(value="/toList")
	public String toList()
	{
		return "list";
	}
	
	/**
	 * ����ʵ������ɾ���͵���ɾ��
	 * @return
	 */
	@RequestMapping(value="/user/{ids}",method=RequestMethod.DELETE)
	public Msg deleteUser(@PathVariable("ids")String ids)
	{
		if(ids.contains("-"))
		{
			List<User> list = new ArrayList<User>();
			list.clear();
			String[] strArr = ids.split("-");
			for(String str : strArr)
			{
				User user = new User();
				user = userServiceImpl.getUser(str);
				list.add(user);
			}
			userServiceImpl.deleteUserBatch(list);
			return Msg.success();
		}else{
			userServiceImpl.deleteUser(ids);
			return Msg.success();
		}
	}
}
