package com.jin.springboot;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class MyDataMongo {
	@Id

	private String id;
	
	private String code;
	private String name;
	private Date date;

	private int Java;
	private int SpringBoot;
	private int DataBase;
	private int Amount;
	private int Average;

	public MyDataMongo(String name, String code, int Java, int SpringBoot, int DataBase) {

		super();
		this.name = name;
		this.code = code;
		this.date = new Date();
		this.Java = Java;
		this.SpringBoot = SpringBoot;
		this.DataBase = DataBase;
		this.Amount = Java + SpringBoot + DataBase;
		this.Average = Amount / 3;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getJava() {
		return Java;
	}

	public void setJava(int java) {
		Java = java;
	}

	public int getSpringBoot() {
		return SpringBoot;
	}

	public void setSpringBoot(int springBoot) {
		SpringBoot = springBoot;
	}

	public int getDataBase() {
		return DataBase;
	}

	public void setDataBase(int dataBase) {
		DataBase = dataBase;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public int getAverage() {
		return Average;
	}

	public void setAverage(int average) {
		Average = average;
	}

}
