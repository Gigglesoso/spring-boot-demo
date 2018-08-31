package com.dkd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	//登录页面路由
	@RequestMapping("/login")
	public String userLogin() {
		return "login";
	}
	//登录成功后路由
	@RequestMapping("/loginSuccess")
	public String loginSuccess() {
		return "login-success";
	}
	//登录失败跳转的页面
	 @RequestMapping("/loginError")
	 public String loginError(){
	     return "login-error";
	 }
}
