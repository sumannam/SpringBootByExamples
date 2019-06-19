package com.kim.springboot;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class MyDataMongo {
	@Id

	private String id;
	
	private String name;
	private String boardTitle;
	private String boardContent;

	private Date date;
	
	private int pc;
	private int laptop;
	private int monitor;
	private int amount;
	private int discount;
	
	/**
	 *
	 * @fn 		public MyDataMongo()
	 * 
	 * @brief 	데이터 저장
	 *
	 * @author 	김성택
	 * @date 	2019-06-20
	 *
	 * @param	String name, String boardTitle, String boardContent, int pc, int laptop, int monitor
	 *
	 * @remark 	몽고디비에 있는데이터를 가저온다  [2019-06-20; 김성택] \n
	 *
	 */
	
	
	public MyDataMongo(String name, String boardTitle, String boardContent, int pc, int laptop, int monitor) {

		super();
		this.name = name;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.date = new Date();
		this.pc = pc;
		this.laptop = laptop;
		this.monitor = monitor;
		this.amount = pc + laptop + monitor;
		this.discount = amount-=(amount*0.1);
	}
	
	/**
	 *
	 * @fn 		public getId(),setId(id)
	 * 
	 * @brief 	데이터 이동
	 *
	 * @author 	김성택
	 * @date 	2019-06-20
	 *
	 * @param	필드의 모든데이터
	 *
	 * @remark 	필드의 데이터들을 집어넣거나 꺼낼때 쓰는함수이다  [2019-06-20; 김성택] \n
	 *
	 */


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


	public String getBoardTitle() {
		return boardTitle;
	}


	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}


	public String getBoardContent() {
		return boardContent;
	}


	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getPc() {
		return pc;
	}


	public void setPc(int pc) {
		this.pc = pc;
	}


	public int getLaptop() {
		return laptop;
	}


	public void setLaptop(int laptop) {
		this.laptop = laptop;
	}


	public int getMonitor() {
		return monitor;
	}


	public void setMonitor(int monitor) {
		this.monitor = monitor;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getDiscount() {
		return discount;
	}


	public void setDiscount(int discount) {
		this.discount = discount;
	}



}
