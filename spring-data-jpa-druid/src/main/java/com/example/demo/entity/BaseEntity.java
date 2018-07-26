package com.example.demo.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
/**
 * 所有的实体的父类
 * @author Administrator
 *
 */
@MappedSuperclass
public class BaseEntity {
	
	@Id
	@Column(name="ID")
	private String id;
	
	@PrePersist
	private void preInsert() {
		setId(UUID.randomUUID().toString());//这里使用写的id生成类生成
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
