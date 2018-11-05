package com.foxconn.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foxconn.demo.bean.User;
import com.foxconn.demo.service.impl.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	/**
	 * ÓÃ»§×¢²á
	 * @param user
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/user", method=RequestMethod.POST)
	@ResponseBody
	public ResponseBody saveUser(@Validated User user, BindingResult result)
	{
		if(result.hasErrors())
		{
			List<FieldError> fieldErrors = result.getFieldErrors();
			for(FieldError error : fieldErrors)
			{
				System.out.println("´íÎó£º" + error.getField());
				System.out.println(" " + error.getDefaultMessage());
			}
		}
		else{
			userServiceImpl.saveUser(user);
			
		}
		return null;
	}
}
