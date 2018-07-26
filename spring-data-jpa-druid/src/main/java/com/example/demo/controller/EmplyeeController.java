package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmplyeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/save")
	public String saveEmployee(@RequestParam String employeeName,@RequestParam String employeeGender) {
    	//这里模拟接收到了一个employee实体
		Employee emp = new Employee();
    	emp.setEmployeeName(employeeName);
    	emp.setEmployeegGender(employeeGender);
    	//保存
		employeeService.save(emp);
		return "保存成功！";
	}
	@RequestMapping(value="/findById")
	public String findById(@RequestParam String id) {
		return employeeService.findById(id).toString();
	}
//	@RequestMapping(value="/updateNameById")
//	public String updateNameById(String name,String id) {
//		employeeService.updateEmployeeNameById(id, name);
//		return "更新完成";
//	}
	@RequestMapping(value="/deleteById")
	public String deleteById(String id) {
		employeeService.deleteById(id);
		return "删除成功！";
	}
	@RequestMapping(value="/count")
	public int count() {
		return employeeService.count();
	}
}
