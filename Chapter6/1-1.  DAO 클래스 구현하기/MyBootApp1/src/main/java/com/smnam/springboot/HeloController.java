package com.smnam.springboot;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.smnam.springboot.repositories.MyDataRepository;

@Controller
public class HeloController {
        
    @Autowired
    MyDataRepository repository;
    
    @PersistenceContext
    EntityManager entityManager; //●
    
    MyDataDaoImpl dao; //●
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
            mav.setViewName("index");
            mav.addObject("msg","MyData의 예제입니다.");
            Iterable<MyData> list = dao.getAll(); //●
            mav.addObject("datalist", list);
            return mav;
    }
@PostConstruct
    public void init(){
            dao = new MyDataDaoImpl(entityManager); //●
            MyData d1 = new MyData();
            d1.setName("tuyano");
            d1.setAge(123);
            d1.setMail("kim@gilbut.co.kr");
            d1.setMemo("090999999");
            repository.save(d1);
            MyData d2 = new MyData();
            d2.setName("lee");
            d2.setAge(15);
            d2.setMail("lee@flower");
            d2.setMemo("080888888");
            repository.save(d2);
            MyData d3 = new MyData();
            d3.setName("choi");
            d3.setAge(37);
            d3.setMail("choi@happy");
            d3.setMemo("070777777");
            repository.save(d3);
    }
}
