package com.smnam.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.smnam.springboot.repositories.MyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
public class HeloController 
{
	public void init(){
        MyData d1 = new MyData();
        d1.setName("tuyano");
        d1.setAge(123);
        d1.setMail("kim@gilbut.co.kr");
        d1.setMemo("090-999-999"); // ●
        repository.saveAndFlush(d1);
        MyData d2 = new MyData();
        d2.setName("lee");
        d2.setAge(15);
        d2.setMail("lee@flower");
        d2.setMemo("080-888-888"); // ●
        repository.saveAndFlush(d2);
        MyData d3 = new MyData();
        d3.setName("choi");
        d3.setAge(37);
        d3.setMail("choi@happy");
        d3.setMemo("070-777-777"); // ●
        repository.saveAndFlush(d3);
	}
    
    @Autowired
    MyDataRepository repository;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(
            @ModelAttribute("formModel") MyData mydata,
                    ModelAndView mav) {
            mav.setViewName("index");
            mav.addObject("msg","this is sample content.");
            mav.addObject("formModel",mydata);
            Iterable<MyData> list = repository.findAll();
            mav.addObject("datalist",list);
            return mav;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @Transactional(readOnly=false)
    public ModelAndView form(
                    @ModelAttribute("formModel")
                    @Validated MyData mydata,
                    BindingResult result,
                    ModelAndView mov) {
            ModelAndView res = null;
            if (!result.hasErrors()){
                    repository.saveAndFlush(mydata);
                    res = new ModelAndView("redirect:/");
            } else {
                    mov.setViewName("index");
                    mov.addObject("msg","sorry, error is occured...");
                    Iterable<MyData> list = repository.findAll();
                    mov.addObject("datalist",list);
                    res = mov;
            }
            return res;
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
