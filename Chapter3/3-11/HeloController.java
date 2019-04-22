package com.smnam.springboot;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeloController {
        
        @RequestMapping("/")
        public String index() {
                return "index";
        }
        
}
