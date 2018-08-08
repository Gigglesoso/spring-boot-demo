package com.dkd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dkd.entity.Clazz;
import com.dkd.service.ClazzService;

@RestController
public class ClazzController {
	
	@Autowired
	private ClazzService clazzService;
	
	@RequestMapping(value = "/insertClazz")
	public String inserClazz(@RequestBody Clazz clazz) {
		clazzService.insertClazz(clazz);
		return "插入成功！";
	}
	
	//一对多  关联查询
	@RequestMapping(value = "/selectClazzAndStudents")
	public Clazz selectClazzAndStudents(@RequestBody Clazz clazz) {
		return clazzService.selectClazzAndStudents(clazz.getId());
	}
}
