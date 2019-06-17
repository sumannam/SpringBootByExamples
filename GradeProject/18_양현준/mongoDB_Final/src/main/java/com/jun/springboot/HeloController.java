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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {

		mav.setViewName("index");
		mav.addObject("title", "회원 정보");
		mav.addObject("msg", "회원정보");

		Iterable<MyDataMongo> list = repository.findAll();
		mav.addObject("datalist", list);
		
		return mav;
	}
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView insert(ModelAndView mav) {
		mav.setViewName("insert");
		mav.addObject("title", "회원 가입");
		mav.addObject("msg", "회원 정보를 작성해주세요.");

		return mav;
	}	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView form(
			@RequestParam("name") String name,
			@RequestParam("eMail") String eMail,
			@RequestParam("phonenumber") String phonenumber,
			@RequestParam("tall") int tall, 
			@RequestParam("weight") int weight,
			@RequestParam("age") int age, 
			
			ModelAndView mov) 
	{
		MyDataMongo mydata = new MyDataMongo(name, eMail, phonenumber, tall, weight, age);
		repository.save(mydata);
		
		return new ModelAndView("redirect:/");
	}

}
