package com.jun.springboot;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class MyDataMongo {
	@Id

	private String id;
	
	private String name;
	private String eMail;
	private String phonenumber;
	private Date date;
	
	private int age;
	private int tall;
	private int weight;
	private double bmi;
	
	
	public MyDataMongo(String name, String eMail, String phonenumber ,int tall, int weight, double bmi) {

		super();
		this.name = name;
		this.date = new Date();
		this.phonenumber = phonenumber;
		this.eMail = eMail;
		this.tall = tall;
		this.weight = weight;
		this.bmi = weight / (tall*tall);
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


	public String geteMail() {
		return eMail;
	}


	public void seteMail(String eMail) {
		this.eMail = eMail;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getTall() {
		return tall;
	}


	public void setTall(int tall) {
		this.tall = tall;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	public double getBmi() {
		return bmi;
	}


	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

}
