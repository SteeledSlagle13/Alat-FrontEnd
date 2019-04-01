package com.apexlegendsat.springmvc.frontend.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

	static Logger logger = LogManager.getLogger(IndexController.class.getName());

	@RequestMapping(method = RequestMethod.GET)
	public String getIndexPage() {
		logger.debug("getting index page");
		return "index";
	}

}