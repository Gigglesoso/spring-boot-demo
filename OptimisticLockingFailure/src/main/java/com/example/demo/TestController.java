package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController	
public class TestController {
	@Autowired
	private  TestService testService;
	
	@RequestMapping("/test")
	public String testService(Map<String,Integer> map) {
		try {
			if(null == map.get("attempts")) {
				map.put("attempts", 0);
			}
			return testService.test();
		} catch (Exception e) {
			if(e instanceof Exception) {//这里可以根据要捕获的异常进行尝试，如果是乐观锁异常则捕获
			//if(e instanceof StaleObjectStateException || e instanceof ObjectOptimisticLockingFailureException) {
				if((Integer)map.get("attempts") <= 3) {
					map.put("attempts", (Integer)map.get("attempts")+1);
					return testService(map);
				}
			}
			return "error";
		}
	}
}
