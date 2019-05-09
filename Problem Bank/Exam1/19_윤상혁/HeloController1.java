package com.sanghyuk.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeloController {
	@RequestMapping("/{num}")
	public String index(@PathVariable int num) {
		double res = num * 1177.30;
		return num + " USD = " + res + " won.";
		
	}
}