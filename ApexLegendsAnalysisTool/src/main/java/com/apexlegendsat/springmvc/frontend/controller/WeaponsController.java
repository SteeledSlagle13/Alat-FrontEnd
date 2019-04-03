package com.apexlegendsat.springmvc.frontend.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.stereotype.Controller;

@Controller
public class WeaponsController {

	private static Logger logger = LogManager.getLogger(WeaponsController.class.getName());
	
	@RequestMapping(value = { "/weapons" }, method = RequestMethod.GET)
	public String getWeaponsPage() {
		logger.debug("getting weapons page");
		return "weaponCompare/weapons";
	}
}
