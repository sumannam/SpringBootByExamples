package com.shin.springboot;

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
	@Column(nullable = false)
	private Integer num;
	@Column(nullable = true)
	private Integer java;
	@Column(nullable = true)
	private Integer spring;
	@Column(nullable = true)
	private Integer db;


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

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getJava() {
		return java;
	}

	public void setJava(Integer java) {
		this.java = java;
	}

	public Integer getDb() {
		return db;
	}

	public void setDb(Integer db) {
		this.db = db;
	}

	public Integer getSpring() {
		return spring;
	}

	public void setSpring(Integer spring) {
		this.spring = spring;
	}

}