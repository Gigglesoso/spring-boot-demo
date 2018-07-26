package com.example.demo.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

@MappedSuperclass
public class BaseEntity {
	
	@Id
	@Column(name="id")
	private String id;
	
	@PrePersist
	private void preInsert() {
		setId(UUID.randomUUID().toString());
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
