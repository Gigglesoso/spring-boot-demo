package com.dkd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dkd.entity.Student;
import com.dkd.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/insertStudent")
	public String insertStudent(@RequestBody Student student) {
		studentService.insertStudent(student);
		return "插入成功！";
	}
	
	@RequestMapping(value = "/selectStudent")
	public Student selectStudent(@RequestBody Student student) {
		return studentService.selectStudent(student.getId());
	}
}
