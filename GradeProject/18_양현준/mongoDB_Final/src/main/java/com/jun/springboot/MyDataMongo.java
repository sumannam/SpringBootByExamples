package com.jun.springboot;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class MyDataMongo {
	@Id

	private String id;
	
	private String name;
	private String eMail;
	private String phonenumber;
	private String result;
	private Date date;
	
	private int age;
	private double tall;
	private double weight;
	private double bmi;
	
	
	public MyDataMongo(String name, String eMail, String phonenumber,int age ,double tall, double weight) {

		super();
		this.name = name;
		this.eMail = eMail;
		this.phonenumber = phonenumber;
		this.age = age;
		this.tall = tall;
		this.weight = weight;
		this.date = new Date();	

		double tallCM = tall / 100.0;
		this.bmi = Math.round((weight / (tallCM * tallCM))*10)/10.0;
		
		this.result = result;
		result = "";
		
		if (bmi <= 18.4) {
			result += "당신은 저체중 입니다. 좀찌세요.";
		}
		else if (bmi >= 18.5 && bmi <= 24.9) {
			result += "당신은 정상체중 입니다.";
		}
		else if (bmi >= 25 && bmi <= 29.9) {
			result += "당신은 과체중 입니다.";
		}
		else if (bmi >= 30) {
			result += "당신은 비만입니다. 살빼세요.";
		}
		else {
			result += "키와 몸무게를 다시한번 확인해주세요.";
		}		
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
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
	public double getTall() {
		return tall;
	}
	public void setTall(double tall) {
		this.tall = tall;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getBmi() {
		return bmi;
	}
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
}
