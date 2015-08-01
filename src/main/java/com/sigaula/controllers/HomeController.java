package com.sigaula.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String root() {
		logger.info("root()...");
		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		logger.info("home()...");
		return "core/home-description";
	}
	
	@RequestMapping(value = "/sobre", method = RequestMethod.GET)
	public String sobre() {
		logger.info("sobre()...");
		return "core/sobre";
	}
	
}
