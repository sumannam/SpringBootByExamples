package com.jin.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mydata")
public class MyData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;

	@Column(length = 50, nullable = false)
	private String name;
	@Column(length = 50, nullable = false)
	private Integer code;
	
	@Column(nullable = true)
	private Integer Java;
	
	@Column(nullable = true)
	private Integer Spring;
	
	@Column(nullable = true)
	private Integer Database;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getJava() {
		return Java;
	}

	public void setJava(Integer java) {
		Java = java;
	}

	public Integer getSpring() {
		return Spring;
	}

	public void setSpring(Integer spring) {
		Spring = spring;
	}

	public Integer getDatabase() {
		return Database;
	}

	public void setDatabase(Integer database) {
		Database = database;
	}


}