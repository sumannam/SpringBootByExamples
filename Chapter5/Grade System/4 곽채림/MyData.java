package com.kwackchaelim.springboot;

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
	@Column(length = 200, nullable = false)
	private long classnum;
	@Column(nullable = true)
	private Integer java;
	@Column(nullable = true)
	private Integer springboot;
	@Column(nullable = true)
	private Integer database;

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

	public long getClassnum() {
		return classnum;
	}

	public void setClassnum(long classnum) {
		this.classnum = classnum;
	}

	public Integer getJava() {
		return java;
	}

	public void setJava(Integer java) {
		this.java = java;
	}
	
	public Integer getSpringboot() {
		return springboot;
	}

	public void setSpringboot(Integer springboot) {
		this.springboot = springboot;
	}
	
	public Integer getDatabase() {
		return database;
	}

	public void setDatabase(Integer database) {
		this.database = database;
	}

}
