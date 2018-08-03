package com.dkd.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dkd.entity.Employee;
/**
 * @author Administrator
 *
 */
@Mapper
public interface EmployeeMapper {
	
	//这里没有设置实体属性和数据库字段的对应关系，所以查询时默认值是一样的，字段不相同的值为null
    @Select("SELECT * FROM EMPLOYEE WHERE ID = #{id}")
    Employee findById(@Param("id") String id);
    
    @Insert("INSERT INTO EMPLOYEE(id, employeeName, employeeGender) VALUES(#{id}, #{employeeName}, #{employeeGender})")
    int insert(Employee emp);
    
    @Delete("DELETE FROM EMPLOYEE WHERE ID = #{id}")
    int deleteById(String id);
    
    @Update("UPDATE EMPLOYEE SET employeeName = #{employeeName}, employeeGender = #{employeeGender}")
    int update(Employee emp);
}
