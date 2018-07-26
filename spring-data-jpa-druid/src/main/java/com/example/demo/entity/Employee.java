package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee{
	
	@Column(nullable=false,length=50,name="ID")
	private String id;
	@Column(length=32,name="EMPLOYEE_NAME")
	private String employeeName;
	
	@Column(length=10,name="EMPLOYEE_GENDER")
	private String employeegGender;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeegGender() {
		return employeegGender;
	}

	public void setEmployeegGender(String employeegGender) {
		this.employeegGender = employeegGender;
	}

	

	
	
}
