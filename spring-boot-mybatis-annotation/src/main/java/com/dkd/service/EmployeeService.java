package com.dkd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkd.entity.Employee;
import com.dkd.mapper.EmployeeMapper;
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeMapper mapper;
	
	public Employee findById(String id) {
		return mapper.findById(id);
	}
	
	public void insert(Employee emp) {
		mapper.insert(emp);
	}
	
	public void deleteById(String id) {
		mapper.deleteById(id);
	}
	
	public void update(Employee emp) {
		mapper.update(emp);
	}
}
