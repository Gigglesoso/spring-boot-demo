package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author Administrator
 * @desc   通过spring-data-redis向redis中存值或者
 */
@RestController
public class SpringDataRedisController {
	
	@Autowired
	private StringRedisTemplate template;
	
	@RequestMapping("/setValue")
	public String setValue() {
		ValueOperations<String, String> opsForValue = template.opsForValue();
		opsForValue.set("value", "test");
		return "赋值成功！";
	}
	@RequestMapping("/getValue")
	public String getValue() {
		ValueOperations<String, String> opsForValue = template.opsForValue();
		Long startTime = System.currentTimeMillis();
		String str="";
		try {
			for (int i = 0; i < 4000; i++) {
				str = opsForValue.get("value");				
			}			
			long endtime = System.currentTimeMillis();
			System.out.println("取值成功，耗时:"+(endtime-startTime)+"ms");
			return "取值成功,值为:"+str+"耗时:"+(endtime-startTime)+"ms";
		} catch (Exception e) {
			e.printStackTrace();
			long endTime = System.currentTimeMillis();		
			System.out.println("取值失败，耗时:"+(endTime-startTime)+"ms");
			return "取值失败,耗时:"+(endTime-startTime)+"ms";
		}
		
	}
}
