package com.webPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webPortal.form.UserForm;
import com.webPortal.model.UserInfo;
import com.webPortal.service.UserService;
import com.webPortal.validator.RegistrationValidator;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public RegistrationValidator registrationValidator;
	
	@Autowired
	public UserService userService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("user/list");
		model.addObject("list", userService.list());
		
		return model;
	}

	
	 @RequestMapping(value="/change_pass/{username}", method=RequestMethod.GET)
	 public ModelAndView changePass(@PathVariable("username") String username){
	  ModelAndView model = new ModelAndView("user/change_pass");
	  model.addObject("user", userService.findUserByUsername(username));
	  
	  return model;
	 }
	 
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("user") UserInfo user){
	  ModelAndView model = changePass(user.getUsername());
	  userService.update(user.getUsername(), user.getPassword());
	  model.addObject("msg", "Your password has been changed successfully!");
	  
	  return model;
	 }

	 
	 @RequestMapping(value="/signup", method=RequestMethod.GET)
	 public ModelAndView signup(){
	  ModelAndView model = new ModelAndView("user/registration");
	  model.addObject("userForm", new UserForm());
	  
	  return model;
	 }

	 
	 @RequestMapping(value="/register", method=RequestMethod.POST)
	 public String register(@ModelAttribute("userForm") UserForm userForm, 
	BindingResult result, RedirectAttributes redirectAttributes){
	  
		 registrationValidator.validate(userForm, result);
	  
	  if(result.hasErrors()){
	   return "/user/registration";
	  } else {
	   userService.add(userForm.getUsername(), userForm.getPassword());
	   redirectAttributes.addFlashAttribute("msg", "Your account has been created successfully!");
	   
	   return "redirect:/login";
	  }
	 }

	
	
}
