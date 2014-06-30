package com.todolist.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.todolist.service.PerformanceService;

@Controller
public class IndexController {

	@Autowired
	PerformanceService performanceService;
	
	@RequestMapping(value = { "*/", "/index" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		
		ModelAndView model = new ModelAndView();
		model.addObject("topFive", performanceService.getTopFivePerformers());
		
		model.setViewName("index");
		return model;
 
	}
	
	@RequestMapping("/otherPage")
	public String test(){
		return "test";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
 
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
 
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
 
		return model;
 
	}	
	
}
