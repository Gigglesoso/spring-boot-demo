package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entity.Employee;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    //新增方法
    public void save(Employee employee) {
    	employeeRepository.save(employee);
    }
    //查找
    public Employee findById(String id) {
    	Optional<Employee> emp = employeeRepository.findById(id);
    	return emp.get();
    }
    //删除方法
    public void deleteById(String id) {
    	employeeRepository.deleteById(id);
    }
    public int count() {
    	return (int) employeeRepository.count();
    }
    
}
