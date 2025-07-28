package com.serverProject.JWTAuth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/welcome")
	public String home()
	{
		String text = "This is Private Page";
		text+= "This Page is not Allowed to Unauthenticated Users";
		return text;
	}
	
	@RequestMapping("/getUsers")
	public String user()
	{
		return "{\"name\": \"John\"}";
	}
	
	

}
