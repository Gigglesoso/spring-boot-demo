package com.dkd.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dkd.entity.Employee;
import com.dkd.service.EmployeeService;
/**
 * 最基本的查询
 * @author Administrator
 *
 */
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/findById")
	public Employee findById(String id) {
		return service.findById(id);
	}
	@RequestMapping("/insert")
	public String insert() {
		//模拟生成一个实体开始
		Employee emp = new Employee();
		Random ran = new Random();
		emp.setId("2"+ran.nextInt()+ran.nextInt());
		emp.setEmployeeName("jim"+ran.nextInt());
		emp.setEmployeeGender(ran.nextInt()%2 == 0?"male":"female");
		//模拟生成一个实体结束
		service.insert(emp);
		return "新增成功！";
	}
	@RequestMapping("/deleteById")
	public String deleteById(String id) {
		service.deleteById(id);
		return "删除成功！";
	}
	@RequestMapping("/update")
	public String update() {
		Employee emp = new Employee();
		emp.setId("2-1349581429-1975250112");
		emp.setEmployeeName("newname");
		emp.setEmployeeGender("newgender");
		service.update(emp);
		return "更新成功！";
	}
	//动态查询
	@RequestMapping("/dynamicSearch")
	public List<Employee> dynamicSearch(@RequestBody Employee emp){
		return service.dynamicSearch(emp);
	}
}
