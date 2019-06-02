package com.example.demo;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.repositories.MyDataMongoRepository;

@Controller
public class HeloController  {
	
	@Autowired
	MyDataMongoRepository repository;
	
	
	/**	
	 * @brief 모든 성적 관리 데이터를 몽고 DB로 부터 불러오고 템플릿으로 표현 하는 메소드
	 * 
	 * @author Park
	 * @date   2019-06-01 Saturdays
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView main(ModelAndView mav) {
		mav.setViewName("main");
		Iterable<MyDataMongo> list = repository.findAll();		//모든 성적관리 데이터를 구현된 list에 담는다. 
		mav.addObject("datalist", list);				//addObject로 구현객체 list를 datalist로 템플릿 페이지 표현한다.
		return mav;
	}
	
	
	/**
	 * @brief 이름, 학번, 성적 데이터를 입력 받는 페이지를 나타내는 메소드
	 */
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public ModelAndView insert(ModelAndView mav) {
		mav.setViewName("insert");
		return mav;
	}

	/**
	 * @brief 템플릿으로부터 입력된 성적데이터를 db에 저장
	 * @param name		사용자 이름
	 * @param classNum	학번	
	 * @param sub1		성적1
	 * @param sub2		성적2
	 * @param sub3		성적3
	 */
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView insert(
			@RequestParam("name") String name,
			@RequestParam("classNum") String classNum,
			@RequestParam("sub1") int sub1,
			@RequestParam("sub2") int sub2,
			@RequestParam("sub3") int sub3,
			ModelAndView mav) {
		
		final int sum = sub1 + sub2 + sub3;		//성적점수들의 총점을 저장하기 위한 변수
		
		final double avg = sum/3.0;			//성적점수의 평균 값
		
		MyDataMongo mydata = new MyDataMongo(name, classNum, sub1, sub2, sub3, sum, avg);	//몽고 db에 데이터 저장을 위해 객체 생성
		repository.save(mydata);	//db에 값 저장
		return new ModelAndView("redirect:/");
	}
	
	
	/**
	 * @brief 해당 테이블 id를 받아 데이터 조회	
	 * @param id	해당 테이블 id	 	
	 * @return
	 */
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView edit(
			@PathVariable String id,
			ModelAndView mav) {
		mav.setViewName("edit");
		
		MyDataMongo getlist = repository.findByid(id);		//id값으로 해당 데이터 조회
		mav.addObject("getlist", getlist);
		return mav;
	}
	
	/**
	 * 
	 * @brief 성적 데이터 수정메소드 (기존에 테이블을 제거한 후 새로운 성적데이터를 삽입)
	 * @param name		사용자 이름
	 * @param classNum	학번	
	 * @param sub1		성적1
	 * @param sub2		성적2
	 * @param sub3		성적3
	 */
	@RequestMapping(value="/update", method=RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView update(@RequestParam String id,
			@RequestParam("name") String name,
			@RequestParam("classNum") String classNum,
			@RequestParam("sub1") int sub1,
			@RequestParam("sub2") int sub2,
			@RequestParam("sub3") int sub3,
			ModelAndView mav) {
		
		final int sum = sub1 + sub2 + sub3; 	
		
		final double avg = sum/3.0;
		
		MyDataMongo mydata = new MyDataMongo(name, classNum, sub1, sub2, sub3, sum, avg);
		repository.save(mydata);
		
		repository.deleteById(id);		//기존 테이블은 제거
		return new ModelAndView("redirect:/");
	}
	
	/**
	 * @brief 테이블 제거 메소드
	 */
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView remove(@RequestParam String id,
			ModelAndView mav) {
		repository.deleteById(id);
		return new ModelAndView("redirect:/");
	}
}
