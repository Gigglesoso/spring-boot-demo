package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {
	@RequestMapping("/hello")
	public String helloHtml(HashMap<String, Object> map) {
		map.put("hello", "欢迎进入html页面！");
		return "index";
	}
	@RequestMapping("/getUser")
	public String userHtml(HashMap<String, Object> map) {
		List<User> userList = new ArrayList<User>();
		for(int i=0;i<3;i++) {
			User user = new User();
			user.setName("tom"+i);
			user.setGender("male"+i);
			user.setAddress("TJ"+i);
			userList.add(user);
		}
		map.put("userList", userList);
		return "user";
	}
}
