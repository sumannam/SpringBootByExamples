package com.chapter05.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.chapter05.springboot.repositories.MyDataRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import javax.annotation.PostConstruct;

@Controller
public class HeloController 
{
	@PostConstruct
	public void init(){
        MyData d1 = new MyData();
        d1.setName("Park");
        d1.setStudentNumber("2016141023");
        d1.setSubject1("국어");
        d1.setSubject2("수학");
        d1.setSubject3("영어");
        repository.saveAndFlush(d1);
        
        MyData d2 = new MyData();
        d2.setName("Kim");
        d2.setStudentNumber("11111111");
        d2.setSubject1("국어");
        d2.setSubject2("수학");
        d2.setSubject3("영어");
        repository.saveAndFlush(d2);
        
        MyData d3 = new MyData();
        d3.setName("Hun");
        d3.setStudentNumber("222222222");
        d3.setSubject1("국어");
        d3.setSubject2("사회");
        d3.setSubject3("과학");
        repository.saveAndFlush(d3);
	}	
    
    @Autowired
    MyDataRepository repository;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(
    		@ModelAttribute("formModel") MyData mydata
    		, ModelAndView mav) 
    {
    	mav.setViewName("index");
    	mav.addObject("msg","this is sample content.");
    	Iterable<MyData> list = repository.findAll();
    	mav.addObject("datalist",list);
    	return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @Transactional(readOnly=false)
    public ModelAndView form(
    		@ModelAttribute("formModel") MyData mydata
    		, ModelAndView mav)
    {
    	repository.saveAndFlush(mydata);
    	return new ModelAndView("redirect:/");
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute MyData mydata,
                    @PathVariable int id,ModelAndView mav) {
            mav.setViewName("edit");
            mav.addObject("title","edit mydata.");
            MyData data = repository.findById((long)id).get();
            mav.addObject("formModel",data);
            return mav;
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @Transactional(readOnly=false)
    public ModelAndView update(@ModelAttribute MyData mydata,
                    ModelAndView mav) {
            repository.saveAndFlush(mydata);
            return new ModelAndView("redirect:/");
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id,
                    ModelAndView mav) {
            mav.setViewName("delete");
            mav.addObject("title","delete mydata.");
            MyData data = repository.findById((long)id).get();
            mav.addObject("formModel",data);
            return mav;
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @Transactional(readOnly=false)
    public ModelAndView remove(@RequestParam long id,
                    ModelAndView mav) {
            repository.deleteById(id);
            return new ModelAndView("redirect:/");
    }

}