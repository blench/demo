package com.foxconn.demo.bean;

import java.util.HashMap;
import java.util.Map;

public class Msg {
	
	//状态码100表示成功，200表示失败
	private int code;
	
	//提示信息
	private String msg;
	
	private Map<String, Object> extend = new HashMap<String, Object>();
	
	
	public static Msg success()
	{
		Msg msg = new Msg();
		msg.setCode(100);
		msg.setMsg("处理成功");
		return msg;
	}
	
	public static Msg fail()
	{
		Msg msg = new Msg();
		msg.setCode(200);
		msg.setMsg("处理失败");
		return msg;
	}
	
	public Msg add(String key, Object value)
	{
		this.extend.put(key, value);
		return this;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	
	
}
