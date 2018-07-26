package com.example.demo;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Log4j2Controller {
	//private static Logger logger = LogManager.getLogger(SpringbootLog4j2Application.class);
	@RequestMapping(value="/setLog")
	public String setLog(HttpServletRequest request,HttpServletResponse response) {
		try {
			throw new NullPointerException("产生空指针！");
		} catch (Exception e) {
			LoggerUtil.setErrorLog(getClass(), "空指针异常", e);
			return "发生错误了！";
		}
	}
}
