package com.dkd.entity;

import java.util.List;

public class Clazz {
	
    public int id;
    
    public String name;
    
    public List<Student> studentList;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
    
    
}
