package com.dkd.provider;


import org.apache.ibatis.jdbc.SQL;

import com.dkd.entity.Employee;
import com.mysql.jdbc.StringUtils;
/**
 * 该类中用来动态拼接sql参数
 * @author Administrator
 *
 */
public class EmployeeSqlProvider {
	
	//动态查询拼接sql
	public String dynamicSearch(Employee emp) {
		SQL sql = new SQL();
		sql.SELECT("*");
		sql.FROM("employee");
		if(!StringUtils.isNullOrEmpty(emp.getEmployeeName())) {
			sql.WHERE("employeeName=#{employeeName}");
		}
		if(!StringUtils.isNullOrEmpty(emp.getEmployeeGender())) {
			sql.WHERE("employeeGender=#{employeeGender}");
		}
		return sql.toString();
	}
	//动态拼接sql,动态更新
	public String dynamicUpdate(Employee emp) {
		return new SQL() {{
			UPDATE("employee");
			SET("id=#{id}");
			if(!StringUtils.isNullOrEmpty(emp.getEmployeeName())) {
				SET("employeeName=#{employeeName}");
			}
			if(!StringUtils.isNullOrEmpty(emp.getEmployeeGender())) {
				SET("employeeGender=#{employeeGender}");
			}
			WHERE("id=#{id}");
		}}.toString();
	}
}
