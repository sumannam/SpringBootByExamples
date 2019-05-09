package com.sanghyuk.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeloController {
    @RequestMapping("/{num}")
    public String index(@PathVariable int num) {
    	double res = 2020 - num;
    	return "당신의 나이는 " + num + "살 입니다.";
    }
}