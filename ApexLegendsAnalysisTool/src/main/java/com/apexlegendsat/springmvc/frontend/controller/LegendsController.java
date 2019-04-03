package com.apexlegendsat.springmvc.frontend.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LegendsController {
	
	private static Logger logger = LogManager.getLogger(LegendsController.class.getName());

	@RequestMapping(value = { "/legends" }, method = RequestMethod.GET)
	public String getLegendsPage() {
		logger.debug("getting legends page");
		return "legends/legends";
	}
}