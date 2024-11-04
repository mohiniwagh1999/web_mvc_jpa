package com.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jpa.entity.Product;
import com.jpa.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;
	//load save product form
	@GetMapping("/product")
	public ModelAndView loadForm()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("product",new Product());//form binding
		mv.setViewName("index");
		return mv;
	}
	
	
	@PostMapping("/product")
	public ModelAndView handleForm(Product product)
	{
		
		ModelAndView mv=new ModelAndView();
		boolean status = service.saveProduct(product);
		if(status)
		{
			mv.addObject("smsg","product saved successfully");
		}
		else
		{
			mv.addObject("emsg","failed to save product");
		}
		mv.addObject("product",new Product());
		mv.setViewName("index");
		return mv;
	}
	
	@GetMapping("/products")//display all products
	public ModelAndView ViewProduct()
	{
		List<Product> productList = service.getAllProducts();
		ModelAndView mv=new ModelAndView();
		mv.addObject("plist",productList);
		mv.setViewName("view");
		return mv;
	}
	
	@GetMapping("/greet")
	public String getMsg(Model model)
	{
		model.addAttribute("msg", "good morning mumbai");
		return "index1";
	}

}
