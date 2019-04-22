package com.smnam.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HeloController 
{
	@RequestMapping("/")
	public ModelAndView index(ModelAndView mav) {
			mav.setViewName("index");
			ArrayList<DataObject> data = new ArrayList<DataObject>();
			data.add(new DataObject(0,"park","park@yamada"));
			data.add(new DataObject(1,"lee","lee@flower"));
			data.add(new DataObject(2,"choi","choi@happy"));
			mav.addObject("data",data);
			return mav;
	}   
}

class DataObject 
{
	private int id;
	private String name;
	private String value;
	
	public DataObject(int id, String name, String value) 
	{
			super();
			this.id = id;
			this.name = name;
			this.value = value;
	}

	public int getId() 
	{ 
		return id; 
	}

	public void setId(int id)
	{ 
		this.id = id; 
	}
	
	public String getName() 
	{ 
		return name; 
	}

	public void setName(String name) 
	{
			this.name = name;
	}

	public String getValue() 
	{
			return value;
	}

	public void setValue(String value) 
	{
			this.value = value;
	}
}