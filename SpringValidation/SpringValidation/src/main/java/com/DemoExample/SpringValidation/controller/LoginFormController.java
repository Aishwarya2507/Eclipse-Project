package com.DemoExample.SpringValidation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.DemoExample.SpringValidation.model.LoginData;

@Controller
public class LoginFormController {
	
	@GetMapping("/form")
	public String useLogin(Model model)
	{
		System.out.println("Opening Login Form");
		model.addAttribute("loginData", new LoginData());
		return "form";
	}
	
	
	// Handler for processing Form:
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult result)
	{
		
		if(result.hasErrors())
		{
			System.out.println(result);
			return "form";
		}
		
		System.out.println(loginData);
		return "success";
	}

}
