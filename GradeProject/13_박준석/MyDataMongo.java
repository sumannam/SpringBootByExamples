package com.example.demo;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class MyDataMongo {
	@Id
	private String id;
	
	private String name;
	private String classNum;
	private int sub1;
	private int sub2;
	private int sub3;
	private int sum;
	private double avg;
	private Date date;

	public MyDataMongo(String name, String classNum, int sub1, int sub2, int sub3, int sum, double avg) {
		super();
		this.name = name;
		this.classNum = classNum;
		this.sub1= sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
		this.sum = sum;
		this.avg = avg;
		this.date = new Date();
	}

	public int getSub1() {
		return sub1;
	}

	public int getSub2() {
		return sub2;
	}

	public int getSub3() {
		return sub3;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getClassNum() {
		return classNum;
	}

	public int getSum() {
		return sum;
	}

	public double getAvg() {
		return avg;
	}

	public Date getDate() {
		return date;
	}
	
	

	
}
