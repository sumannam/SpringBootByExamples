package com.smnam.springboot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.smnam.springboot.repositories.MyDataRepository;
@Controller
public class HeloController {
        
        @Autowired
        MyDataRepository repository;
        
        @RequestMapping("/")
        public ModelAndView index(ModelAndView mav) {
                mav.setViewName("index");
                mav.addObject("msg","this is sample content.");
                Iterable<MyData> list = repository.findAll();
                mav.addObject("data",list);
                return mav;
        }
}
