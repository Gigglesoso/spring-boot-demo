package cst.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cst.annotation.MethodTime;

@RequestMapping(value = "/test")
@RestController
public class TestController {
	
	@RequestMapping(value = "/log")
	@MethodTime(module="TestModule",stringType = "json")
	public String test() throws InterruptedException {
		Thread.sleep(1000);
		return "ok";
	}
	
}
