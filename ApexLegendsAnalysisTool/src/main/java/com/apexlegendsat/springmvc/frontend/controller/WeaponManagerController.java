package com.apexlegendsat.springmvc.frontend.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.apexlegendsat.springmvc.frontend.view.UserView;

@Controller
public class WeaponManagerController {

	private static Logger logger = LogManager.getLogger(WeaponManagerController.class.getName());

	@RequestMapping(value = { "/weaponmanager" }, method = RequestMethod.GET)
	public ModelAndView getWeaponManagerPage(HttpServletRequest request) {

		UserView sessionUser = (UserView) request.getSession().getAttribute("user");

		ModelAndView modelView;

		if (sessionUser == null) {
			logger.error("User attempted to access memberonly page");
			modelView = new ModelAndView("redirect:/login", "Error", "LOGIN_ACCESS_ONLY");
		} else {
			logger.debug("getting weapon manager page");
			logger.debug(sessionUser);
			modelView = new ModelAndView("weaponManager/weaponManager", "user", sessionUser);
		}

		return modelView;
	}
}
