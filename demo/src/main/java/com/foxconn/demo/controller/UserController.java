package com.foxconn.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foxconn.demo.bean.User;
import com.foxconn.demo.service.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public ResponseBody saveUser(@Validated User user)
	{
		return null;
	}
}
