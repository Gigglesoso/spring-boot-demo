package com.dkd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkd.entity.Clazz;
import com.dkd.entity.Student;
import com.dkd.mapper.StudentMapper;

@Service
public class StudentService {
	
	@Autowired
	private StudentMapper studentMapper;
	
	public void insertStudent(Student student) {
		//模拟数据
		Clazz  clazz = new Clazz();
		clazz.setId(1);
		student.setClazz(clazz);
		//模拟数据
		studentMapper.insertStudent(student);
	}
	
	public Student selectStudent(int id) {
		return studentMapper.selectStudent(id);
	}
}
