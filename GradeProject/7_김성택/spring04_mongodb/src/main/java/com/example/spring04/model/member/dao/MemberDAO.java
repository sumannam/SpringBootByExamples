package com.example.spring04.model.member.dao;

import com.example.spring04.model.member.dto.MemberDTO;

/**
*
* @fn 		MemberDTO loginCheck(String userid, String passwd)
* 
* @brief 	로그인체크
*
* @author 	김성택
* @date 	2019-06-16
*
* @param 	String userid, String passwd
*
* @remark 	로그인정보가 일치확인하는 역할수행	[2019-06-16; 김성택]
* 		   	
**/

public interface MemberDAO {
	MemberDTO loginCheck(String userid, String passwd);
	
	/**
	*
	* @fn 		void join(MemberDTO dto)
	* 
	* @brief 	가입
	*
	* @author 	김성택
	* @date 	2019-06-16
	*
	* @param 	MemberDTO dto
	*
	* @remark 	회원가입역할을 수행	[2019-06-16; 김성택]
	* 		   	
	**/
	void join(MemberDTO dto);
}
