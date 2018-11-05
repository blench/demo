package com.foxconn.demo.bean;


/***
 * 用户类
 * 包含用户名，密码，性别，年龄，电话号码字段
 * username,pwd,gender,age,tel
 * @author yk
 *
 */
public class User {
	
	private String username;
	private String pwd;
	private String gender;
	private Integer age;
	private String tel;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public User(String username, String pwd, String gender, Integer age, String tel) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.gender = gender;
		this.age = age;
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", pwd=" + pwd + ", gender=" + gender + ", age=" + age + ", tel=" + tel
				+ "]";
	}
	
	
}
