package com.apexlegendsat.springmvc.frontend.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignupController {

	private static Logger logger = LogManager.getLogger(SignupController.class.getName());
	
	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public String getSignupPage() {
		logger.debug("getting sign up page");
		return "signup/signup";
	}
}
