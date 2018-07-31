package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 该例子实现怎么在springboot中使用html文件。
 * 1.pom.xml文件中添加springboot可以使用静态页面的依赖spring-boot-starter-thymeleaf
 * 2.在配置文件中指定静态资源加载地址
 * 3.写相应的controller,指定需要加载的页面，在map中包含前台要加载的数据即可。
 */
@SpringBootApplication
public class SpringbootStaticHtmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStaticHtmlApplication.class, args);
	}
}
