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
    public void save(String name,String gender) {
    	Employee emp = new Employee();
    	emp.setName(name);
    	emp.setGender(gender);
    	employeeRepository.save(emp);
    }
    //查找
    public Employee findById(String id) {
    	Optional<Employee> emp = employeeRepository.findById(id);
    	return emp.get();
    }
    //更新指定字段
    public void updateNameById(String id,String name) {
    	employeeRepository.updateNameById(name, id);
    }
    //删除方法
    public void deleteById(String id) {
    	employeeRepository.deleteById(id);
    }
    public int count() {
    	return (int) employeeRepository.count();
    }
    
}
