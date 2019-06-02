package com.mongodb.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.mongodb.demo.repositories.MyDataMongoRepository;
import java.util.List;

@Controller
public class HeloController {
        
    @Autowired
    MyDataMongoRepository repository;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) 
    {
        mav.setViewName("index");
        mav.addObject("title","Find Page");
        mav.addObject("msg","MyDataMongo의 예제입니다.");
        Iterable<MyDataMongo> list = repository.findAll();
        mav.addObject("datalist", list);
        return mav;
    }
        
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @Transactional(readOnly=false)
    public ModelAndView form(
                    @RequestParam("name") String name,
                    @RequestParam("memo") String memo,
                    ModelAndView mov) 
    {
        MyDataMongo mydata = new MyDataMongo(name,memo);
        repository.save(mydata);
        return new ModelAndView("redirect:/");
    }
    
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ModelAndView find(ModelAndView mav) 
    {
        mav.setViewName("find");
        mav.addObject("title","Find Page");
        mav.addObject("msg","MyData의 예제입니다.");
        mav.addObject("value","");
        List<MyDataMongo> list = repository.findAll();
        mav.addObject("datalist", list);
        return mav;
    }
    
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public ModelAndView search(
	            @RequestParam("find") String param,
	            ModelAndView mav) 
    {
	    mav.setViewName("find");
	    if (param == "")
	    {
            mav = new ModelAndView("redirect:/find");
	    }
	    else 
	    {
            mav.addObject("title","Find result");
            mav.addObject("msg","「" + param + "」의 검색 결과");
            mav.addObject("value",param);
            List<MyDataMongo> list = repository.findByName(param);
            mav.addObject("datalist", list);
	    }
	    
	    return mav;
    }
}

