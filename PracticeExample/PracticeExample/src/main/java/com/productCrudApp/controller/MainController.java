package com.productCrudApp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.productCrudApp.model.Product;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	// Show Add Product Form:
	@RequestMapping("/addProduct")
	public String addProduct(Model m)
	{
		m.addAttribute("title", "Add Product Page");
		return "add_product_form";
	}
	
	
	// Handle Add Product Form:
		@RequestMapping(value="/handleProduct", method=RequestMethod.POST)
		public RedirectView  handleProduct(@ModelAttribute Product product, HttpServletRequest request)
		{
			System.out.println(product);
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(request.getContextPath() + "/");
			return redirectView;
		}
	
	

}
