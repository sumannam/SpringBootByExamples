package com.jun.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jun.springboot.repositories.MyDataMongoRepository;

@Controller
public class HeloController {

	@Autowired
	MyDataMongoRepository repository;

	/**
	 *
	 * @fn 		public ModelAndView index(ModelAndView mav)
	 * 
	 * @brief 	메인 페이지 설정 
	 *
	 * @author 	양현준
	 * @date 	2019-06-17
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark 	웹 페이지를 불러오기 위한 초기페이지 설정		[2019-06-17; 양현준] \n
	 * 		   	FinaAll()를 이용해 모든 데이터를 List에 저장	[2019-06-17; 양현준]
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {

		mav.setViewName("index");
		mav.addObject("title", "회원 정보");
		mav.addObject("msg", "회원정보");

		Iterable<MyDataMongo> list = repository.findAll();
		mav.addObject("datalist", list);
		
		return mav;
	}
	
	/**
	 *
	 * @fn 		public ModelAndView insert(ModelAndView mav)
	 * 
	 * @brief 	입력 페이지 설정 
	 *
	 * @author 	양현준
	 * @date 	2019-06-17
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark 	입력  페이지를 불러오기 위한 초기페이지 설정		[2019-06-17; 양현준]
	 */
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView insert(ModelAndView mav) {
		
		mav.setViewName("insert");
		mav.addObject("title", "회원 가입");
		mav.addObject("msg", "회원 정보를 작성해주세요.");

		return mav;
	}	
	
	/**
	 *
	 * @fn 		public ModelAndView insert(ModelAndView mav)
	 * 
	 * @brief 	입력 페이지 설정 
	 *
	 * @author 	양현준
	 * @date 	2019-06-17
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark 	input box에 입력된 값을 받아온 후 저장 		[2019-06-17; 양현준] \n
	 * 			repository.save를 이용해 DB에 값 저장 		[2019-06-17; 양현준]
	 */
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView form(
			@RequestParam("name") String name,
			@RequestParam("eMail") String eMail,
			@RequestParam("phonenumber") String phonenumber,
			@RequestParam("age") int age,
			@RequestParam("tall") double tall, 
			@RequestParam("weight") double weight, ModelAndView mov) 
	{
		MyDataMongo mydata = new MyDataMongo(name, eMail, phonenumber, age, tall, weight);
		repository.save(mydata);
		
		return new ModelAndView("redirect:/");
	}
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("id") String id, ModelAndView mav) {
		
		mav.setViewName("detail");
		mav.addObject("title", "Detail Page");
		mav.addObject("msg", "회원 정보 상세 조회");

		List<MyDataMongo> list = repository.findById(id);
		mav.addObject("datalist", list);
		
		return mav;
	}
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") String id, ModelAndView mav) {
		
		mav.setViewName("edit");
		mav.addObject("title", "Edit");
		mav.addObject("msg", "변경하실 정보를 입력해주세요.");
		
		List<MyDataMongo> list = repository.findById(id);
		
		mav.addObject("datalist", list);
		
		return mav;
	}
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editpost(
			@RequestParam("id") String id,
			@RequestParam("name") String name,
			@RequestParam("eMail") String eMail,
			@RequestParam("phonenumber") String phonenumber,
			@RequestParam("age") int age,
			@RequestParam("tall") double tall, 
			@RequestParam("weight") double weight, ModelAndView mov)
	{
		MyDataMongo mydata = new MyDataMongo(name, eMail, phonenumber, age, tall, weight);
		repository.save(mydata);
		
		return new ModelAndView("redirect:/");
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView romovecheck(@PathVariable("id") String id, ModelAndView mav) {
		mav.setViewName("delete");
		mav.addObject("title", "Delete");
		mav.addObject("msg", "정말로 삭제하시겠습니까?");
		
		List<MyDataMongo> list = repository.findById(id);
		
		mav.addObject("datalist", list);
		
		return mav;
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView romove(@RequestParam("id") String id, ModelAndView mav) {
		
		repository.deleteById(id);
		
		return new ModelAndView("redirect:/");
	}
}
