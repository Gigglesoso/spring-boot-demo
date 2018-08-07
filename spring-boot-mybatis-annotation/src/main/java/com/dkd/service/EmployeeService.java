package com.dkd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkd.entity.Employee;
import com.dkd.mapper.EmployeeMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeMapper mapper;
	//根据id查询
	public Employee findById(String id) {
		return mapper.findById(id);
	}
	//插入操作
	public void insert(Employee emp) {
		mapper.insert(emp);
	}
	//根据id删除
	public void deleteById(String id) {
		mapper.deleteById(id);
	}
	//更新操作
	public void update(Employee emp) {
		mapper.update(emp);
	}
	//动态查询
	public List<Employee> dynamicSearch(Employee emp){
		return mapper.dynamicSearch(emp);
	}
	//动态更新，根据属性值不为空的才进行更新
	public void dynamicUpdate(Employee emp) {
		mapper.dynamicUpdate(emp);
	}
	/**
	 * 分页动态查询
	 * @param emp
	 * @return
	 */
	public List<Employee> dynamicSearchByPage(Employee emp){
		Page<Employee> pageInfo = PageHelper.startPage(1, 10);//分页插件先调用该方法，传入要分页的方法
		List<Employee> emps = mapper.dynamicSearch(emp);      //查询方法，上述方法的第一个查询方法会被分页
		System.out.println(pageInfo.getPageNum());            //页码
		System.out.println(pageInfo.getPages());              //页数    可以通过pageInfo获得分页的相关信息用来返回给前台
		return emps;
	}
}
