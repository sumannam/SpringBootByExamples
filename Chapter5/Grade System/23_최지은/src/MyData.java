package com.example.demo;

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
	private Integer id;

	@Column(length = 50, nullable = false)
	private String name;
	@Column(length = 200, nullable = true)
	private Integer java;
	@Column(nullable = true)
	private Integer spring;

	@Column(nullable = true)
	private Integer databasc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getJava() {
		return java;
	}

	public void setJava(Integer java) {
		this.java = java;
	}

	public Integer getSpring() {
		return spring;
	}

	public void setSpring(Integer spring) {
		this.spring = spring;
	}

	public Integer getDatabasc() {
		return databasc;
	}

	public void setDatabasc(Integer databasc) {
		this.databasc = databasc;
	}
}