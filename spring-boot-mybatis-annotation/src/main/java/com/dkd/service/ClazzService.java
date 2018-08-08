package com.dkd.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkd.entity.Clazz;
import com.dkd.mapper.ClazzMapper;

@Service
public class ClazzService {
	
	@Autowired
	private ClazzMapper clazzMapper;
	
	/**
	 * 插入方法
	 * @param clazz
	 */
	public void insertClazz(Clazz clazz) {
		clazzMapper.insertClazz(clazz);
	}
	
	//一对多关联查询
	public Clazz selectClazzAndStudents(int id) {
		return clazzMapper.selectClazzAndStudents(id);
	}
}
