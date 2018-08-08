package com.dkd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Many;

import com.dkd.entity.Clazz;
@Mapper
public interface ClazzMapper {
	
    @Insert("insert into clazz (name) values (#{name})")
    @Options(useGeneratedKeys = true,keyProperty = "id")//根据数据库自动生成id
    public void insertClazz(Clazz clazz);
    
    //一对1    1查询
    @Select("select * from clazz where id=#{id}")
    public Clazz selectClazz(int id);
    
    
    //一对多     一查询
    @Select("select * from clazz where id=#{id}")
    @Results({
        //@Result(id=true,property="id",column="id"),                          //一般这种数据库字段和实体属性字段一样的不需要写出
        //@Result(property="name",column="name"),                              //因此只需要专门定义关联的list实体即可
        @Result(property="studentList",column="id",javaType=List.class,        //这里要注意的是javaType  要和Clazz实体中的对应
        many=@Many(select="com.dkd.mapper.StudentMapper.selectStudentByClazz"))//这里使用many注解表明查询出的为多个对象，对应查询的方法
    })
    public Clazz selectClazzAndStudents(int id);

}
