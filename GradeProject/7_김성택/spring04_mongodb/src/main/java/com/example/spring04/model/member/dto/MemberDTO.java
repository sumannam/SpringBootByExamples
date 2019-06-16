package com.example.spring04.model.member.dto;

		/**
		*
		* @fn 		public String get(),set()
		* 
		* @brief 	데이터를 교환
		*
		* @author 	김성택
		* @date 	2019-06-16
		*
		* @param 	몽고db의 레코드
		*
		* @remark 	받아온 데이터를 저장하고 뿌려주는역할을 수행	[2019-06-16; 김성택]
		* 		   	
		**/

public class MemberDTO {
	private String _id;
	private String passwd;
	private String name;
	private String email;
	private String hp;
	private String zipcode;
	private String address1;
	private String address2;

	public MemberDTO() {
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
		/**
		*
		* @fn 		public String toString()
		* 
		* @brief 	데이터를 한번에 교환
		*
		* @author 	김성택
		* @date 	2019-06-16
		*
		*
		* @remark 	받아온 데이터를 한번에 뿌려주는역할을 수행	    [2019-06-16; 김성택]
		* 		   	
		**/
	
	@Override
	public String toString() {
		return "MemberDTO [_id=" + _id + ", passwd=" + passwd + ", name=" + name + ", email=" + email + ", hp=" + hp
				+ ", zipcode=" + zipcode + ", address1=" + address1 + ", address2=" + address2 + "]";
	}
	
}
