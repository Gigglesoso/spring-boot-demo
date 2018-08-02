package com.dkd.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.dkd.entity.Employee;

@Mapper
public interface EmployeeMapper {
	
    @Select("SELECT * FROM EMPLOYEE WHERE ID = #{id}")
    Employee findById(@Param("id") String id);
}
