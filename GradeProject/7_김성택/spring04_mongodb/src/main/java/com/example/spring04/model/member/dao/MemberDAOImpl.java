package com.example.spring04.model.member.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.spring04.model.member.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	//mongodb에 접속하여 명령어를 실행하는 객체
	@Autowired
	private MongoTemplate mongoTemplate;
	//mongodb의 컬렉션(테이블에 해당)
	String COLLECTION_NAME="member";
	
//로그인 체크	
	@Override
	public MemberDTO loginCheck(String userid, String passwd) {
		// _id : Document(레코드에 해당)의 식별자
		Query query=new Query(new Criteria("_id").is(userid)
				.and("passwd").is(passwd));
//mongoTemplate.find(쿼리, 리턴자료형, 컬렉션이름)
//리스트가 리턴되므로 get(0) 첫번째 Document만 리턴		
		List<MemberDTO> list=mongoTemplate.find(query
				, MemberDTO.class,COLLECTION_NAME);
		if(list.size() > 0) {
			return list.get(0);
		}else {
			return null;
		}
	}
//회원가입 처리
	@Override
	public void join(MemberDTO dto) {
		//Document가 생성됨(insert)
		mongoTemplate.insert(dto, COLLECTION_NAME);
	}

}
