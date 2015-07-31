package com.sigaulaapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
	
	@Autowired
	protected String appName;
	
	@Autowired
	protected String appDescription;
	
}
