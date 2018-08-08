package com.dkd.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.One;

import com.dkd.entity.Clazz;
import com.dkd.entity.Student;
@Mapper
public interface StudentMapper {
	
    @Insert("insert into student (name,clazz_id) values(#{name},#{clazz.id})")
    @Options(useGeneratedKeys=true,keyProperty="id")
    public void insertStudent(Student student);
    
    //一对1     一查询  
    @Select("select * from student where id=#{id}")
    @Results({
        @Result(id=true,property="id",column="id"),
        @Result(property="name",column="name"),
        @Result(property="clazz",column="clazz_id",javaType=Clazz.class,
        one=@One(select="com.dkd.mapper.ClazzMapper.selectClazz"))
    })
    public Student selectStudent(int id);
    
    //一对多   多查询
    //这里对应使用班级查询时关联查询学生的方法，使用的班级id查询，返回list
    @Select("select * from student where clazz_id=#{id}")
    public List<Student> selectStudentByClazz(int id);
}
