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
	private long id;

	@Column(length = 50, nullable = false)
	private String name;
	@Column(length = 200, nullable = true)
	private String code;
	@Column(nullable = true)
	private Integer subject1;
	@Column(nullable = true)
	private Integer subject2;
	@Column(nullable = true)
	private Integer subject3;
	
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

	public String Code() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public Integer getSubject1() {
		return subject1;
	}
	public void setSubject1(Integer subject1) {
		this.subject1 = subject1;
	}

	public Integer getSubject2() {
		return subject2;
	}
	public void setSubject2(Integer subject2) {
		this.subject2 = subject2;
	}
	
	public Integer getSubject3() {
		return subject3;
	}
	public void setSubject3(Integer subject3) {
		this.subject3 = subject3;
	}
}