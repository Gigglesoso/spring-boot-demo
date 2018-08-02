package com.dkd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloException {
	@RequestMapping(value = "/hello")
	public String hello() throws Exception {
		throw new Exception("发生异常！");
	}
}
