package com.example.demo.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Employee;
/**
 * @author Administrator
 *	CrudRepository提供了基本的crud操作需要的方法，具体可以参照源码，可以直接调用
 *  CrudReposity中没有更新方法，直接更新实体会使空属性为空，更新方法需要自定义。
 */
public interface EmployeeRepository extends  CrudRepository<Employee, String>{
	  @Modifying       //表示当前是更新方法
	  @Transactional   //在dao接口上执行更新删除操作时需要加该注解实现事务控制
	  @Query("update  employee e set e.EMPLOYEE_NAME=?1 where e.ID=?2")
	  public void updateNameById(String name,String id);
//    以下方法是CrudReposity暴露的方法，还有很多。Service层可以直接调用	
//	  <S extends T> S save(S entity);      
//
//	  Optional<T> findById(ID primaryKey); 
//
//	  Iterable<T> findAll();               
//
//	  long count();                        
//
//	  void delete(T entity);               
//
//	  boolean existsById(ID primaryKey);  
}
